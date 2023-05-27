package com.example.web_ai.member.repository;

import com.example.web_ai.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByIdx(Long idx);
    @Override
    <S extends Member> S save(S entity);

    Optional<Member> findByUuid(String uuid);
}
