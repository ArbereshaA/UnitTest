package com.example.maven.controller;

import com.example.maven.pojo.Member.CreateMemberInput;
//import com.example.maven.pojo.Member.EditMemberInput;
import com.example.maven.pojo.Member.Member;
import com.example.maven.pojo.Trainer.Trainer;
import com.example.maven.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;


    @PostMapping("/member/trainer/{trainer_id}")
    public Member create(
            @PathVariable Integer trainer_id,
            @RequestBody CreateMemberInput input) {
        return memberService.create(trainer_id,input);
    }

}
