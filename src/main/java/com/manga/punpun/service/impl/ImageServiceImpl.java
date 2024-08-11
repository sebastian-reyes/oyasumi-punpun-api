package com.manga.punpun.service.impl;

import com.manga.punpun.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public ResponseEntity<byte[]> getImage(String imagePath) {
        File img = new File(imagePath);
        if (!img.exists()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo file not found.");
        }
        try {
            byte[] imageBytes = Files.readAllBytes(img.toPath());
            MediaType mediaType = MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img));
            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .body(imageBytes);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error reading the photo file.", e);
        }
    }
}
