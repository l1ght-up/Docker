package com.example.web_ai.imageAlter.domain;

import com.example.web_ai.gps.Gps;
import com.example.web_ai.imageAlter.dto.ImageAlterDto;
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
public class ImageAlter {
    @Id
    @Column(name = "Image_Idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String savedPath;

    @ManyToOne
    @JoinColumn(name = "Member_Idx")
    private Member member;

    @Column(nullable = false)
    private Gps gps;

    private int factor1;
    private int factor2;
    private int factor3;
    private int factor4;
    private int factor5;

    public void updateSavedPath(String savedPath) {
        this.savedPath = savedPath;
    }

    public ImageAlterDto toDTO(ImageAlter imageAlter) {
        ImageAlterDto.ImageDtoBuilder builder = ImageAlterDto.builder().toBuilder();
        ImageAlterDto imageAlterDto = builder
                .idx(imageAlter.getIdx())
                .savedPath(imageAlter.getSavedPath())
                .memberIdx(imageAlter.getMember().getIdx())
                .gps(imageAlter.getGps())
                .factor1(imageAlter.getFactor1())
                .factor2(imageAlter.getFactor2())
                .factor3(imageAlter.getFactor3())
                .factor4(imageAlter.getFactor4())
                .factor5(imageAlter.getFactor5())
                .build();

        return imageAlterDto;
    }
}
