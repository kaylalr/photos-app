package com.photos.api.v1.controllers;

import com.photos.api.v1.model.Photo;
import com.photos.api.v1.services.PhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/photos")

public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @GetMapping(value="", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Photo> getPhotos() {
        return photoService.getPhotos();
    }

    @PostMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public void uploadPhoto(@RequestBody Photo photo) {
        photoService.uploadPhoto(photo);
    }

    @DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePhoto(@PathVariable Long id) { photoService.deletePhoto(id); }

    @GetMapping(value="/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Photo getOnePhoto(@PathVariable Long id) {
        return photoService.getOnePhoto(id);
    }
}
