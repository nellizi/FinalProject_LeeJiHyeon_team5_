package com.example.demo.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;


    @GetMapping("/join")
    public String join(){
        return "member/joinform";
    }

    @GetMapping("/login")
    public String login(){
        return "member/loginform";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(){
        return "admin 페이지";
    }

    @PostMapping("/join")
    @ResponseBody
    public String joinPost( JoinForm joinForm) {
        String rawPassword = joinForm.getPassword();
        memberService.join(joinForm);

        return rawPassword;
    }

    @GetMapping("/info")
    @ResponseBody
    public String info(){
        return "개인정보";
    }

}
