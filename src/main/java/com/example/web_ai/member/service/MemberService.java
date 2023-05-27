package com.example.web_ai.member.service;

import com.example.web_ai.member.domain.Member;
import com.example.web_ai.member.dto.MemberDto;
import com.example.web_ai.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private UUID uuid;

    public ResponseEntity signup(MemberDto memberDto) {

//        Optional<Member> member = memberRepository.findByIdx(memberDto.getIdx());

        Member newMember = Member.builder()
                .uuid(uuid.randomUUID().toString())
                .nickname(memberDto.getNickname())
                .build();

        memberRepository.save(newMember);
        return new ResponseEntity("success", HttpStatus.OK);
    }
}
