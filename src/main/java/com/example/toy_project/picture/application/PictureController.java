package com.example.toy_project.picture.application;

import com.example.toy_project.picture.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PictureController {
    private final PictureService pictureService;

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> findPictureById(@PathVariable Long id){
        return pictureService.findPictureById(id);
    }
}
