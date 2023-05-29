package com.example.web_ai.imageAlter.repository;

import com.example.web_ai.imageAlter.domain.ImageAlter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageAlterRepository extends JpaRepository <ImageAlter, Long> {
    Optional<ImageAlter> findByIdx(Long idx);
    Optional<ImageAlter> findByMemberIdx(Long idx);

    @Override
    <S extends ImageAlter> S save(S entity);
}
