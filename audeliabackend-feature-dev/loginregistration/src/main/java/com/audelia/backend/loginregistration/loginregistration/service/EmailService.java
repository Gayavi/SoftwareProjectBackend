package com.audelia.backend.loginregistration.loginregistration.service;

public interface EmailService {

//    boolean enableUser(String token);

    boolean sendForgotPasswordEmail(String registrationNumber);

//    boolean resendVerificationEmail(String username);

}
