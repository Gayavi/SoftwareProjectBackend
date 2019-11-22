package com.audelia.backend.loginregistration.loginregistration.service.impl;

import com.audelia.backend.loginregistration.loginregistration.model.VerificationToken;
import com.audelia.backend.loginregistration.loginregistration.repository.*;
import com.audelia.backend.loginregistration.loginregistration.service.EmailService;
import com.audelia.backend.loginregistration.loginregistration.util.converter.EntityConverter;
import com.audelia.backend.loginregistration.loginregistration.util.enums.ImageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
@PropertySource("classpath:application.properties")
public class EmailServiceImpl implements EmailService {

    @Autowired
    VerificationTokenRepository tokenRepository;

    @Autowired
    EntityConverter entityConverter;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    Environment environment;


    private boolean createVerificationEmail(String receipientAddress, String verificationToken) {
        String subject = "ApeEvent Registration Confirmation";
//        String message = "You are almost there! Please enter the following verification code to activate your account." +
//                " \n\nVerification code: "+verificationToken;
        String url = environment.getRequiredProperty("backend_url") +
                "/api/v1/authentication/confirmRegistration?token=" + verificationToken;

        String message = "You are almost there! Please click the link to activate your account. \n\n" + url;
        return sendMail(receipientAddress, subject, message);
    }





    private LocalDate calculateExpiryDate() {
        return LocalDate.now().plusDays(2);
    }



    @Override
    public boolean sendForgotPasswordEmail(String registrationNumber) {

        String recipientAddress = "";

        if(Pattern.matches("A\\d\\d\\d",registrationNumber)){
           recipientAddress = adminRepository.findByRegistrationNumber(registrationNumber).getEmail();
        }else if(Pattern.matches("T\\d\\d\\d",registrationNumber)){
            recipientAddress = teacherRepository.findByRegistrationNumber(registrationNumber).getEmail();
        }else if(Pattern.matches("P\\d\\d\\d",registrationNumber)){
            recipientAddress = parentRepository.findByRegistrationNumber(registrationNumber).getEmail();
        }else if(Pattern.matches("S\\d\\d\\d",registrationNumber)){
            recipientAddress = parentRepository.findByRegistrationNumber(studentRepository.findByRegistrationNumber(registrationNumber).getParent().getRegistrationNumber()).getEmail();
        }

        if(recipientAddress == null){
            return false;
        }

        Random rand = new Random();
        String verificatonCode =  String.format("%04d", rand.nextInt(10000));
        System.out.println("========= " + verificatonCode);

        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUsername(registrationNumber);
        verificationToken.setToken(verificatonCode);
        verificationToken.setExpiryDate(calculateExpiryDate());
        verificationToken.setCreatedDate(LocalDate.now());

        verificationTokenRepository.save(verificationToken);

        String subject = "Audelia Password Reset";
        String message = "Your verification code is " + verificatonCode + "";
        System.out.println(recipientAddress);

        return sendMail(recipientAddress, subject, message);
    }



//        private helper methods-----------------------------------------------

    private String createVerificationToken() {
        return UUID.randomUUID().toString();
    }

    private String generatePassword() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    //send normal email
    private boolean sendMail(String recipientAddress, String subject, String message) {
        try {
            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper email = new MimeMessageHelper(msg);
            email.setFrom(environment.getRequiredProperty("email"));
            email.setTo(recipientAddress);
            email.setSubject(subject);
            email.setText(message);
            mailSender.send(msg);
            System.out.println("email sent");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    //send email with attachments
    private boolean sendEmailWithAttachment(String recipientAddress, String subject, String message, List<String> qrPaths) {
        try {
            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper email = new MimeMessageHelper(msg, true);
            email.setFrom(environment.getRequiredProperty("email"));
            email.setTo(recipientAddress);
            email.setSubject(subject);
            email.setText(message);

            for (int i = 0; i < qrPaths.size(); i++) {
                String path = qrPaths.get(i);
                FileSystemResource file = new FileSystemResource(new File(path));
                email.addAttachment("QR Code " + (i + 1) + "." + ImageType.PNG.toString().toLowerCase(), file);
            }

            mailSender.send(msg);
            System.out.println("email sent");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}