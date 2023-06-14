package com.example.web_ai.imageAlter.dto;

import com.example.web_ai.gps.Gps;
import com.example.web_ai.imageAlter.domain.ImageAlter;
import com.example.web_ai.member.domain.Member;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(builderClassName = "ImageDtoBuilder", toBuilder = true)
@JsonDeserialize(builder = ImageAlterDto.ImageDtoBuilder.class)
public class ImageAlterDto {
    private Long idx;
    private String savedPath;
    private Long memberIdx;
    private Gps gps;

    private int factor1;
    private int factor2;
    private int factor3;
    private int factor4;
    private int factor5;

    public static ImageDtoBuilder builder() {
        return new ImageDtoBuilder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class ImageDtoBuilder {
        // memberIdx 필드를 설정하는 Setter 메소드 추가
        private Long memberIdx;
        public ImageDtoBuilder memberIdx(Long memberIdx) {
            this.memberIdx = memberIdx;
            return this;
        }
        public ImageAlterDto build() {
            return new ImageAlterDto(idx, savedPath, memberIdx, gps, factor1, factor2, factor3, factor4, factor5);
        }
        public ImageDtoBuilder toBuilder() {
            return builder()
                    .idx(this.idx)
                    .savedPath(this.savedPath)
                    .memberIdx(this.memberIdx)
                    .gps(this.gps)
                    .factor1(this.factor1)
                    .factor2(this.factor2)
                    .factor3(this.factor3)
                    .factor4(this.factor4)
                    .factor5(this.factor5);
        }
    }
    @Builder
    public ImageAlterDto(Long idx, String savedPath, Long memberIdx, Gps gps, int factor1, int factor2, int factor3, int factor4, int factor5) {
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

    public ImageAlter toEntity(Member member) {
        return ImageAlter.builder()
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
