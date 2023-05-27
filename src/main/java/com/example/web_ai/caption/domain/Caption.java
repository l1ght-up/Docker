package com.example.web_ai.caption.domain;

import com.example.web_ai.image.domain.Image;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class Caption {
    @Id
    @Column(name = "Caption_Idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "Image_Idx")
    private Image image;

    @Column(nullable = false)
    @ElementCollection
    private Set<String> danger;

    public void update(String body, Set<String> danger) {
        this.body = body;
        this.danger = danger;
    }
}
