package com.example.web_ai.caption.dto;

import com.example.web_ai.caption.domain.Caption;
import com.example.web_ai.image.domain.Image;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
public class CaptionDto {
    private Long idx;
    private String body;
    private Long imgIdx;
    private Set<String> danger;

    @Builder
    public CaptionDto(Long idx, String body, Long imgIdx, Set<String> danger) {
        this.idx = idx;
        this.body = body;
        this.imgIdx = imgIdx;
        this.danger = danger;
    }
    @Builder
    public CaptionDto(String body, Set<String> danger) {
        this.body = body;
        this.danger = danger;
    }
    public Caption toEntity(Image image){
        return Caption.builder()
                .body(body)
                .image(image)
                .danger(danger)
                .build();
    }
}
