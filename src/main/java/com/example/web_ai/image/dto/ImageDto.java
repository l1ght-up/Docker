package com.example.web_ai.image.dto;

import com.example.web_ai.caption.domain.Caption;
import com.example.web_ai.gps.Gps;
import com.example.web_ai.image.domain.Image;
import com.example.web_ai.member.domain.Member;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder(builderClassName = "ImageDtoBuilder", toBuilder = true)
@JsonDeserialize(builder = ImageDto.ImageDtoBuilder.class)
@NoArgsConstructor
public class ImageDto {
    private Long idx;
    private List<String> caption;
    private String savedPath;
    private Long memberIdx;
    private Gps gps;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ImageDtoBuilder {

    }
    public List<String> getCaption() {
        return caption;
    }

    public void setCaption(List<String> caption) {
        this.caption = caption;
    }

    @Builder
    public ImageDto(Long idx, List<String> caption, String savedPath, Long memberIdx, Gps gps) {
        this.idx = idx;
        this.caption = caption;
        this.savedPath = savedPath;
        this.memberIdx = memberIdx;
        this.gps = gps;
    }

    @Builder
    public ImageDto(Long idx, String savedPath, Long memberIdx, Gps gps) {
        this.idx = idx;
        this.savedPath = savedPath;
        this.memberIdx = memberIdx;
        this.gps = gps;
    }
    @Builder
    public ImageDto(List<String> caption) {
        this.caption = caption;
    }
    public Image toEntity(Member member) {
        return Image.builder()
                .caption(caption)
                .savedPath(savedPath)
                .member(member)
                .gps(gps)
                .build();
    }
}
