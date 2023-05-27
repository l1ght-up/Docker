package com.example.web_ai.caption.service;

import com.example.web_ai.caption.domain.Caption;
import com.example.web_ai.caption.dto.CaptionDto;
import com.example.web_ai.caption.repository.CaptionRepository;
import com.example.web_ai.image.domain.Image;
import com.example.web_ai.image.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CaptionService {

    private final CaptionRepository captionRepository;

    private final ImageRepository imageRepository;

    public ResponseEntity<CaptionDto> save(CaptionDto captionDto) {

        Image image = imageRepository.findByIdx(captionDto.getImgIdx())
                .orElseThrow(() -> new IllegalArgumentException("해당 이미지가 존재하지 않습니다. idx=" + captionDto.getImgIdx()));

        captionRepository.save(captionDto.toEntity(image));

        return new ResponseEntity<>(captionDto, HttpStatus.OK);
    }

    public ResponseEntity<CaptionDto> getCaptionByIdx(Long idx) {

        Caption caption = captionRepository.findByIdx(idx)
                .orElseThrow(() -> new IllegalArgumentException("해당 캡션이 존재하지 않습니다. idx=" + idx));

        CaptionDto newCaptionDto = CaptionDto.builder()
                .idx(caption.getIdx())
                .body(caption.getBody())
                .imgIdx(caption.getImage().getIdx())
                .danger(caption.getDanger())
                .build();

        return new ResponseEntity<>(newCaptionDto, HttpStatus.OK);
    }

    public ResponseEntity<CaptionDto> update(Long idx, CaptionDto captionDto) {

        Caption caption = captionRepository.findByIdx(idx)
                .orElseThrow(() -> new IllegalArgumentException("해당 캡션이 존재하지 않습니다. idx=" + idx));

        caption.update(captionDto.getBody(), captionDto.getDanger());
        CaptionDto updatedCaptionDto = CaptionDto.builder()
                .body(caption.getBody())
                .danger(caption.getDanger())
                .build();

        return new ResponseEntity<>(updatedCaptionDto, HttpStatus.OK);
    }
}
