package com.manga.punpun.service;

import org.springframework.http.ResponseEntity;

public interface ImageService {
    ResponseEntity<byte[]> getImage(String imagePath);
}
