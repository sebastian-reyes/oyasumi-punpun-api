package com.manga.punpun.rest;

import com.manga.punpun.model.dto.ApiResponse;
import com.manga.punpun.model.dto.VolumeDto;
import com.manga.punpun.service.ImageService;
import com.manga.punpun.service.VolumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/volume")
@RequiredArgsConstructor
public class
VolumeRestController {

    private final VolumeService volumeService;
    private final ImageService imageService;

    @GetMapping
    public ResponseEntity<?> getVolumes() {
        Map<String, Object> response = new HashMap<>();
        List<VolumeDto> volumes = volumeService.listVolumes();
        response.put("content", volumes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVolume(@PathVariable Integer id) {
        return volumeService.findVolume(id)
                .map(volume -> new ResponseEntity<>(new ApiResponse<>(volume, null, HttpStatus.OK), HttpStatus.OK))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Volume not found"));
    }

    @GetMapping("/photo/{id}")
    public ResponseEntity<?> getVolumePhoto(@PathVariable Integer id) throws IOException {
        return volumeService.findVolume(id)
                .map(character -> {
                    String namePhoto = character.getNameImage();
                    if (namePhoto == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The character does not have a photo.");
                    }
                    return imageService.getImage("src/main/resources/static/photos/volume/" + namePhoto);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found."));
    }
}
