package com.example.web_ai.image.service;

import com.example.web_ai.caption.repository.CaptionRepository;
import com.example.web_ai.image.domain.Image;
import com.example.web_ai.image.dto.ImageDto;
import com.example.web_ai.image.repository.ImageRepository;
import com.example.web_ai.member.domain.Member;
import com.example.web_ai.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final ImageRepository imageRepository;

    private final CaptionRepository captionRepository;

    private final MemberRepository memberRepository;

    public ResponseEntity<ImageDto> save(ImageDto imageDto) {

        Member member = memberRepository.findByIdx(imageDto.getMemberIdx())
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다. idx=" + imageDto.getMemberIdx()));

        List<String> captionList = imageDto.getCaption();

        imageRepository.save(imageDto.toEntity(member));

        return new ResponseEntity<>(imageDto, HttpStatus.OK);
    }
    public ResponseEntity<ImageDto> getImageByIdx(Long idx) {
        Image image = imageRepository.findByIdx(idx)
                .orElseThrow(() -> new IllegalArgumentException("해당 이미지가 존재하지 않습니다."));
        ImageDto newImageDto = ImageDto.builder()
                .idx(image.getIdx())
                .caption(image.getCaption())
                .savedPath(image.getSavedPath())
                .memberIdx(image.getMember().getIdx())
                .gps(image.getGps())
                .build();
        return new ResponseEntity<>(newImageDto, HttpStatus.OK);
    }
    public ResponseEntity<ImageDto> update(Long idx, ImageDto imageDto) {
        Image image = imageRepository.findByIdx(idx)
                .orElseThrow(() -> new IllegalArgumentException("해당 이미지가 존재하지 않습니다. idx=" + idx));
        image.update(imageDto.getCaption());

        ImageDto updatedImageDto = ImageDto.builder()
            .caption(image.getCaption())
            .build();
         return new ResponseEntity<>(updatedImageDto, HttpStatus.OK);
    }
}
