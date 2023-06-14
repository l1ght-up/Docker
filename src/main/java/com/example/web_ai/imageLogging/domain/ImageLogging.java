package com.example.web_ai.imageLogging.domain;

import com.example.web_ai.gps.Gps;
import com.example.web_ai.imageAlter.dto.ImageAlterDto;
import com.example.web_ai.imageLogging.dto.ImageLoggingDto;
import com.example.web_ai.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ImageLogging {
    @Id
    @Column(name = "Image_Idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "Member_Idx")
    private Member member;

    @Column(nullable = false)
    private String savedPath;

    @Embedded
    @Column(nullable = false)
    private Gps gps;

    private int factor1;

    private int factor2;

    private int factor3;

    private int factor4;

    private int factor5;

    public void updateSavedPath(String savedPath) { this.savedPath = savedPath; }

    public ImageLoggingDto toDTO(ImageLogging image){
        ImageLoggingDto.ImageDtoBuilder builder = ImageLoggingDto.builder().toBuilder();
        ImageLoggingDto imageLoggingDto = builder
                .idx(image.getIdx())
                .savedPath(image.getSavedPath())
                .memberIdx(image.getMember().getIdx())
                .gps(image.getGps())
                .factor1(image.getFactor1())
                .factor2(image.getFactor2())
                .factor3(image.getFactor3())
                .factor4(image.getFactor4())
                .factor5(image.getFactor5())
                .build();

        return imageLoggingDto;
    }
}
