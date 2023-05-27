package com.example.web_ai.image.repository;

import com.example.web_ai.image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByIdx(Long idx);

    Optional<Image> findByMemberIdx(Long idx);

    @Override
    <S extends Image> S save(S entity);
}
