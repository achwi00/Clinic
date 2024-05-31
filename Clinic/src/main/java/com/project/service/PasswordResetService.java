package com.project.service;

import com.project.clinic.PasswordResetToken;
import com.project.repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PasswordResetService {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    public PasswordResetService(PasswordResetTokenRepository passwordResetTokenRepository) {
        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }

    public Optional<PasswordResetToken> getTokenByEmail(String email) {
        try {
            if (email == null) {
                throw new IllegalArgumentException("PasswordResetService: incorrect email");
            }
            return passwordResetTokenRepository.findByEmail(email);
        } catch (Exception e) {
            System.err.println("Error retrieving code by email: " + e.getMessage());
            throw e;
        }
    }
    /*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.UUID;

@Service
public class PasswordResetService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken myToken = new PasswordResetToken();
        myToken.setToken(token);
        myToken.setUser(user);
        myToken.setExpiryDate(new Date(System.currentTimeMillis() + 3600000)); // 1 hour
        tokenRepository.save(myToken);
    }

    public PasswordResetToken validatePasswordResetToken(String token) {
        return tokenRepository.findByToken(token);
    }

    public void changeUserPassword(User user, String newPassword) {
        user.setPassword(new BCryptPasswordEncoder().encode(newPassword));
        userRepository.save(user);
    }
}*/

}
