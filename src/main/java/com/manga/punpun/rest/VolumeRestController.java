package com.manga.punpun.rest;

import com.manga.punpun.interfaceService.IVolumeService;
import com.manga.punpun.model.Volume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/volume")
public class
VolumeRestController {

    @Autowired
    private IVolumeService service;

    @GetMapping
    public ResponseEntity<?> getVolumes() {
        Map<String, Object> response = new HashMap<>();
        List<Volume> volumes = service.listVolumes();
        response.put("content", volumes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCharacter(@PathVariable Integer id) {
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

}
