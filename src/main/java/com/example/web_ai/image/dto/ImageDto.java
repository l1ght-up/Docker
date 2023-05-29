package com.example.web_ai.image.dto;

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
    private String savedPath;
    private Long memberIdx;
    private Gps gps;

    private int factor1;
    private int factor2;
    private int factor3;
    private int factor4;
    private int factor5;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ImageDtoBuilder {

    }

    @Builder
    public ImageDto(Long idx, String savedPath, Long memberIdx, Gps gps, int factor1, int factor2, int factor3, int factor4, int factor5) {
        this.idx = idx;
        this.savedPath = savedPath;
        this.memberIdx = memberIdx;
        this.gps = gps;
        this.factor1 = factor1;
        this.factor2 = factor2;
        this.factor3 = factor3;
        this.factor4 = factor4;
        this.factor5 = factor5;
    }

    public Image toEntity(Member member) {
        return Image.builder()
                .savedPath(savedPath)
                .member(member)
                .gps(gps)
                .factor1(factor1)
                .factor2(factor2)
                .factor3(factor3)
                .factor4(factor4)
                .factor5(factor5)
                .build();
    }
}
