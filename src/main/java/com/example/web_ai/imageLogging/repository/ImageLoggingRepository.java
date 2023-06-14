package com.example.web_ai.imageLogging.repository;

import com.example.web_ai.imageLogging.domain.ImageLogging;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface ImageLoggingRepository extends JpaRepository <ImageLogging, Long> {
    Optional<ImageLogging> findByIdx(Long idx);

    Optional<ImageLogging> findByMemberIdx(Long idx);

    @Override
    <S extends ImageLogging> S save(S entity);
}
