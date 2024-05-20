package com.example.maven.controller;
import com.example.maven.pojo.Member.CreateMemberInput;
import com.example.maven.pojo.Member.Member;
import com.example.maven.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(MemberController.class)
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    void testCreate() throws Exception {
        CreateMemberInput input = new CreateMemberInput();
        Member member = new Member();
        member.setId(1); // Make sure to set an ID for the member to match the jsonPath expectation

        when(memberService.create(anyInt(), any(CreateMemberInput.class))).thenReturn(member);

        mockMvc.perform(post("/member/trainer/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"Jane\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(member.getId())); // Ensure member.getId() is not null

        verify(memberService, times(1)).create(anyInt(), any(CreateMemberInput.class));
    }
}
