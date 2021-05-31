package com.example.toy_project.picture.service;

import com.example.toy_project.order_list.domain.OrderList;
import com.example.toy_project.picture.domain.Picture;
import com.example.toy_project.picture.domain.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PictureService {
    private final PictureRepository pictureRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<byte []> findPictureById(Long id){
        Picture picture = pictureRepository.findById(id).get();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(picture.getPicture());
    }
}
