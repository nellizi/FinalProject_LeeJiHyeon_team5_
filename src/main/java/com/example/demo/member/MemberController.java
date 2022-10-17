package com.example.demo.member;

import com.example.demo.auth.PrincipalDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @GetMapping("/modify")
    public String modify(@AuthenticationPrincipal PrincipalDetails principalDetails){
         return "member/modify";
    }

    @PostMapping("/modify")
    public String modifyPost(@AuthenticationPrincipal PrincipalDetails principalDetails, ModifyForm modifyForm){
        memberService.modify(principalDetails,modifyForm);
        System.out.println(principalDetails);
        return  "redirect:/";
    }

}
