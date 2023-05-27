package com.example.web_ai.image.domain;

import com.example.web_ai.caption.domain.Caption;
import com.example.web_ai.gps.Gps;
import com.example.web_ai.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Image {
    @Id
    @Column(name = "Image_Idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ElementCollection
    private List<String> caption = new ArrayList<>();

    @Column(nullable = false)
    private String savedPath;

    @ManyToOne
    @JoinColumn(name = "Member_Idx")
    private Member member;

    @Embedded
    @Column(nullable = false)
    private Gps gps;

    public void update(List<String> caption) {
        this.caption = caption;
    }

}
