package com.example.crowdfunding.passswordreset;

import com.example.crowdfunding.members.Member;


public interface PasswordResetTokenService {
    PasswordResetToken createToken(Member member);

    boolean validateToken(String token);

    void resetPassword(String token, String newPassword);
}
