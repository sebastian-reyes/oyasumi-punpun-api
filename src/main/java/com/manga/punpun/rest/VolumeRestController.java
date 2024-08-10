package com.manga.punpun.rest;

import com.manga.punpun.service.VolumeService;
import com.manga.punpun.model.entity.Volume;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/volume")
@RequiredArgsConstructor
public class
VolumeRestController {

    private final VolumeService service;

    @GetMapping
    public ResponseEntity<?> getVolumes() {
        Map<String, Object> response = new HashMap<>();
        List<Volume> volumes = service.listVolumes();
        response.put("content", volumes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVolume(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        Volume volume = null;
        try {
            volume = service.findVolume(id);
            if (volume != null) {
                return new ResponseEntity<>(volume, HttpStatus.OK);
            } else {
                response.put("message", "Volume not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            response.put("message", "Error when querying the database.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/photo/{id}")
    public ResponseEntity<?> getVolumePhoto(@PathVariable Integer id) throws IOException {
        Volume volume = null;
        String name_photo = null;
        Map<String, Object> response = new HashMap<>();
        try {
            volume = service.findVolume(id);
            if (volume != null) {
                name_photo = volume.getImage();
                if (name_photo != null){
                    File img = new File("src/main/resources/static/photos/volume/" + name_photo);
                    return ResponseEntity.ok()
                            .contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img)))
                            .body(Files.readAllBytes(img.toPath()));
                } else {
                    response.put("message", "The volume does not have a photo.");
                    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
                }
            } else {
                response.put("message", "Volume not found.");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            response.put("message", "Error when querying the database.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
