package com.photos.api.v1.services;

import com.photos.api.v1.model.Photo;
import com.photos.api.v1.utils.SqlCache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class PhotoService {
    @Autowired
    SqlCache sqlCache;

    public List<Photo> getPhotos() {
        List<Photo> photos = sqlCache.query("photos.getAll", Collections.emptyMap(), Photo.class);
        return photos;
    }
    public void uploadPhoto(Photo photo) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("url", photo.getUrl());
        params.put("filename", photo.getFilename());
        params.put("message", photo.getMessage());
        sqlCache.update("photos.uploadPhoto", params);
    }
    public void deletePhoto(Long id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        sqlCache.update("photos.deletePhoto", params);
    }
    public Photo getOnePhoto(Long id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        Optional<Photo> photo = sqlCache.get("photos.getOnePhoto", params, Photo.class);
        return photo.orElse(null);
    }
}
