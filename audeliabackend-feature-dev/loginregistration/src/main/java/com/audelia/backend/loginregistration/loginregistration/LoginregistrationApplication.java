package com.audelia.backend.loginregistration.loginregistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class LoginregistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginregistrationApplication.class, args);
	}

	@Autowired
	Environment environment;


	@Bean(name = "mailSender")
	public JavaMailSenderImpl javaMailService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(587);
		javaMailSender.setProtocol("smtp");
		javaMailSender.setUsername(environment.getRequiredProperty("email"));
		javaMailSender.setPassword("Audelia@17");
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.auth", "true");
		mailProperties.put("mail.smtp.starttls.enable", "true");
		mailProperties.put("mail.smtp.debug", "true");
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		javaMailSender.setJavaMailProperties(mailProperties);
		return javaMailSender;
	}


}
