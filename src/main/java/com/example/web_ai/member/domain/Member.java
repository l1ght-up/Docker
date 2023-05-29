package com.example.web_ai.member.domain;

import com.example.web_ai.image.domain.Image;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false, length = 30)
    private String nickname;

//    @OneToMany(mappedBy = "member")
//    @Builder.Default
//    private List<Image> image = new ArrayList<Image>();
}
