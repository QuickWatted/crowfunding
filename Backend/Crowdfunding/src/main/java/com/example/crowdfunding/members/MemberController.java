package com.example.crowdfunding.members;

import com.example.crowdfunding.passswordreset.ForgotPasswordRequest;
import com.example.crowdfunding.passswordreset.PasswordResetTokenServiceImpl;
import com.example.crowdfunding.passswordreset.ResetPasswordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/members")
public class MemberController {

    private final MemberService memberService;
    private final PasswordResetTokenServiceImpl passwordResetTokenService;

    @Autowired
    public MemberController(MemberService memberService, PasswordResetTokenServiceImpl passwordResetTokenService) {
        this.memberService = memberService;
        this.passwordResetTokenService = passwordResetTokenService;
    }

    @PostMapping("/register")
    public void createMember(@RequestBody Member member) {
        memberService.createMember(member);
    }

    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    @PutMapping("/{id}")
    public void updateMember(@PathVariable Long id, @RequestBody Member member) {
        memberService.updateMember(id, member);
    }

    @PostMapping("/login")
    public ResponseEntity<Member> loginMember(@RequestBody Member member) {
        String email = member.getEmail();
        String password = member.getPassword();

        // Use your MemberService to authenticate the member
        Member loggedInMember = memberService.loginMember(email, password);

        if (loggedInMember != null) {
            // Member is authenticated, you may generate a token or perform other actions
            // For simplicity, returning the authenticated member for now
            return new ResponseEntity<>(loggedInMember, HttpStatus.OK);
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        Member member = memberService.findByEmail(request.getEmail());
        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Member not found");
        }

        passwordResetTokenService.createToken(member);
        // Send resetToken.getToken() to the member via email

        return ResponseEntity.ok("Password reset instructions sent to your email");
    }
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {
        if (!passwordResetTokenService.validateToken(request.getToken())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired token");
        }
        passwordResetTokenService.resetPassword(request.getToken(), request.getNewPassword());
        return ResponseEntity.ok("Password reset successfully");
    }
}
