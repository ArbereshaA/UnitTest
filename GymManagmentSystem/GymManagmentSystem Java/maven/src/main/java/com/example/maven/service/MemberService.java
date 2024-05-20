package com.example.maven.service;

import com.example.maven.pojo.Member.CreateMemberInput;
import com.example.maven.pojo.Member.Member;

import java.util.ArrayList;

public interface MemberService {

    Member create(Integer trainerId,CreateMemberInput input);

}
