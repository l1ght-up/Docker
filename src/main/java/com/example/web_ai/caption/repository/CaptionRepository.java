package com.example.web_ai.caption.repository;

import com.example.web_ai.caption.domain.Caption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaptionRepository extends JpaRepository<Caption, Long> {
    @Override
    <S extends Caption> S save(S entity);

    Optional<Caption> findByIdx(Long idx);
}
