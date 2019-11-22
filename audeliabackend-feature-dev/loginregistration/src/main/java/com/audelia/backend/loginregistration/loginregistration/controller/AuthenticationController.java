package com.audelia.backend.loginregistration.loginregistration.controller;

import com.audelia.backend.loginregistration.loginregistration.dto.AdminDTO;
import com.audelia.backend.loginregistration.loginregistration.model.Greeting;
import com.audelia.backend.loginregistration.loginregistration.model.HelloMessage;
import com.audelia.backend.loginregistration.loginregistration.model.VerificationToken;
import com.audelia.backend.loginregistration.loginregistration.repository.*;
import com.audelia.backend.loginregistration.loginregistration.security.AppConstant;
import com.audelia.backend.loginregistration.loginregistration.security.TokenUtils;
import com.audelia.backend.loginregistration.loginregistration.security.model.AuthenticationRequest;
import com.audelia.backend.loginregistration.loginregistration.security.model.AuthenticationResponse;
import com.audelia.backend.loginregistration.loginregistration.security.model.SpringSecurityUser;
import com.audelia.backend.loginregistration.loginregistration.service.EmailService;
import com.audelia.backend.loginregistration.loginregistration.service.UserService;
import com.audelia.backend.loginregistration.loginregistration.util.converter.DtoConverter;
import com.audelia.backend.loginregistration.loginregistration.util.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    private DtoConverter dtoConverter;

    // email service

    @Autowired
    private EmailService emailService;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private TeacherRepository teacherRepository;


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ParentRepository parentRepository;



    public AuthenticationController(){
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @GetMapping("/forgot")
    public boolean forgotPassword(@RequestParam("registrationNumber") String registrationNumber) {
        return emailService.sendForgotPasswordEmail(registrationNumber);
    }

    @GetMapping("/verify")
    public boolean verifyCode(@RequestParam("code") String code,@RequestParam("regNo") String regNo){

        System.out.println("======== Code " + code + " ============ " + regNo);

        VerificationToken verificationToken =  verificationTokenRepository.findByUsername(regNo);
        if(verificationToken != null){
            if(verificationToken.getToken().equals(code)){
                return true;
            }
            return false;
        }
        return false;
    }

    @GetMapping("/newPassword")
    public boolean newPassword(@RequestParam("password") String password,@RequestParam("regNo") String regNo,@RequestParam("code") String code){

        System.out.println("New Password ======= " + password + " -------- RegNo "  + regNo+ "========= " + code );

      if(verifyCode(code,regNo)){

          System.out.println(" =============== ");

          if(Pattern.matches("A\\d\\d\\d",regNo)){

              adminRepository.updateAdminPassword(passwordEncoder.encode(password),regNo);

          }else if(Pattern.matches("T\\d\\d\\d",regNo)){

              teacherRepository.updateTeacherPassword(passwordEncoder.encode(password),regNo);

          }else if(Pattern.matches("S\\d\\d\\d",regNo)){

              studentRepository.updateStudentPassword(passwordEncoder.encode(password),regNo);

          }else if(Pattern.matches("P\\d\\d\\d",regNo)){

              parentRepository.updateParentPassword(passwordEncoder.encode(password),regNo);

          }else{
              return false;
          }

          verificationTokenRepository.deleteByUsername(regNo);
          return true;
      }else{
          return false;
      }
    }

    @PostMapping(value = "/auth")
    public ResponseEntity<?> authenticationRequest(@RequestBody AuthenticationRequest authenticationRequest)
            throws AuthenticationException {

        // Perform the authentication
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-authentication so we can generate token
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token = this.tokenUtils.generateToken(userDetails);

        String usename = authenticationRequest.getUsername();

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();

        authenticationResponse.setToken(token);

        if(Pattern.matches("A\\d\\d\\d",usename)){
            authenticationResponse.setUserType(UserType.ADMIN);
            authenticationResponse.setObject((AdminDTO) userService.loadAdminByUsername(usename));
        }else if(Pattern.matches("T\\d\\d\\d",usename)){
            authenticationResponse.setUserType(UserType.TEACHER);
            authenticationResponse.setObject(userService.loadTeacherByUsername(usename));
        }else if(Pattern.matches("S\\d\\d\\d",usename)){
            authenticationResponse.setUserType(UserType.STUDENT);
            authenticationResponse.setObject(userService.loadStudentByUsername(usename));
        }else if(Pattern.matches("P\\d\\d\\d",usename)){
            authenticationResponse.setUserType(UserType.PARENT);
            authenticationResponse.setObject(userService.loadParentByUsername(usename));
        }

        // Return the token
        return ResponseEntity.ok(authenticationResponse);
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ResponseEntity<?> authenticationRequest(HttpServletRequest request) {
        String token = request.getHeader(AppConstant.tokenHeader);
        String username = this.tokenUtils.getUsernameFromToken(token);
        SpringSecurityUser user = (SpringSecurityUser) this.userDetailsService.loadUserByUsername(username);
        if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordReset())) {
            String refreshedToken = this.tokenUtils.refreshToken(token);
            return ResponseEntity.ok(new AuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }



}
