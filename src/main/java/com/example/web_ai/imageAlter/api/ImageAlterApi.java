package com.example.web_ai.imageAlter.api;

import com.example.web_ai.imageAlter.dto.ImageAlterDto;
import com.example.web_ai.imageAlter.service.ImageAlterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imageAlter")
@RequiredArgsConstructor
public class ImageAlterApi {
    private final ImageAlterService imageAlterService;

    @PostMapping("/create")
    public ResponseEntity<ImageAlterDto> imageCreate(@RequestBody ImageAlterDto imageAlterDto) {
        return imageAlterService.save(imageAlterDto);
    }

    @GetMapping("/imageIdx")
    public ResponseEntity<ImageAlterDto> getImageByIdx(@RequestParam Long idx) {
        return imageAlterService.getImageByIdx(idx);
    }
}
