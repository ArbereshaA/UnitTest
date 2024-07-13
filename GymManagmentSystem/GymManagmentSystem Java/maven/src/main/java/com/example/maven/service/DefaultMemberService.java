package com.example.maven.service;

import com.example.maven.pojo.Member.CreateMemberInput;
import com.example.maven.pojo.Member.Member;
import com.example.maven.pojo.Trainer.Trainer;
import com.example.maven.repository.MmemberRepository;
import com.example.maven.repository.TtrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DefaultMemberService implements MemberService {

    @Autowired
    private MmemberRepository mmemberRepository;
    @Autowired
    private TtrainerRepository ttrainerRepository;

    @Override
    public Member create(Integer trainerId, CreateMemberInput input) {
        Trainer trainer = ttrainerRepository.findTrainerById(trainerId);
        Member member = new Member();
        member.setId(input.getId());
        member.setName(input.getName());
        member.setPhone(input.getPhone());
        member.setTrainer(trainer);

        return mmemberRepository.save(member);
    }

}
