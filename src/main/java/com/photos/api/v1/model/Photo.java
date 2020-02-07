package com.photos.api.v1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Photo {
    private Long id;
    private String filename, message, url;
    private Boolean archived;
}
