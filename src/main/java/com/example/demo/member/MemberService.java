package com.example.demo.member;

import com.example.demo.member.model.Member;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private MemberRepository memberRepository;


//    public void join(Member member) {
//
//        String rawPassword = member.getPassword();
//        String encPassword = bCryptPasswordEncoder.encode(rawPassword); //원문으로 저장하면 시큐리티 로그인이 안 됨
//
//
//        member.setUsername(member.getUsername());
//        member.setPassword(encPassword);
//        member.setNickName(member.getNickName());
//        member.setEmail(member.getEmail());
//        member.setRole("ROLE_USER");
//        member.setAuthLevel(3L);
//
//        memberRepository.save(member);
//    }

    public void join(JoinForm joinForm) {

        String rawPassword = joinForm.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword); //원문으로 저장하면 시큐리티 로그인이 안 됨

        Member member = new Member();
        member.setUsername(joinForm.getUsername());
        member.setPassword(encPassword);
        member.setNickName(joinForm.getNickName());
        member.setEmail(joinForm.getEmail());
        member.setRole("ROLE_USER");
        member.setAuthLevel(3L);

        if(joinForm.getNickName().trim() != null)
            member.setRole("ROLE_AUTHOR");

        memberRepository.save(member);
    }
}
