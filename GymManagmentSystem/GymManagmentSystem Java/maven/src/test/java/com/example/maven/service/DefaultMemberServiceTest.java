package com.example.maven.service;
import com.example.maven.pojo.Member.CreateMemberInput;
import com.example.maven.pojo.Member.Member;
import com.example.maven.pojo.Trainer.Trainer;
import com.example.maven.repository.MmemberRepository;
import com.example.maven.repository.TtrainerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class DefaultMemberServiceTest {

    @InjectMocks
    private DefaultMemberService memberService;

    @Mock
    private MmemberRepository mmemberRepository;

    @Mock
    private TtrainerRepository ttrainerRepository;

    public DefaultMemberServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        Trainer trainer = new Trainer();
        Member member = new Member();
        CreateMemberInput input = new CreateMemberInput();
        input.setId(1);
        input.setName("John");
        input.setPhone(Integer.valueOf("1234567890"));

        when(ttrainerRepository.findTrainerById(anyInt())).thenReturn(trainer);
        when(mmemberRepository.save(any(Member.class))).thenReturn(member);

        Member result = memberService.create(1, input);
        assertEquals(member, result);

        verify(ttrainerRepository, times(1)).findTrainerById(anyInt());
        verify(mmemberRepository, times(1)).save(any(Member.class));
    }
}
