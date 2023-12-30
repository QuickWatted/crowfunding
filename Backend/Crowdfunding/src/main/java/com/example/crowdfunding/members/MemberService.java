package com.example.crowdfunding.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, BCryptPasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        if (id == null) {
            // Handle unauthenticated access, maybe throw an exception or return an appropriate response
            return Optional.empty();
        }
        return memberRepository.findById(id);
    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public void updateMember(Long id, Member member) {
        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Member not found"));
        // Update fields as needed
        existingMember.setEmail(member.getEmail());
        // ... update other fields
        memberRepository.save(existingMember);
    }

    public Member loginMember(String email, String password) {
        // In a real-world scenario, you would hash the password before querying the database
        return memberRepository.findByEmailAndPassword(email, password);
    }
}
