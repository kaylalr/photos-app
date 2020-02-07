package com.photos.api.v1;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.PhotosLibrarySettings;
import com.google.photos.types.proto.Album;

import java.io.FileInputStream;

public class ConnectToLibrary {

    GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("./client_secret_644613220319-t9kb4go0fr5248oeuaa8nhttd6b596g8.apps.googleusercontent.com.json"));

    // Set up the Photos Library Client that interacts with the API
    PhotosLibrarySettings settings = PhotosLibrarySettings.newBuilder().setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();

    try (PhotosLibraryClient photosLibraryClient = PhotosLibraryClient.initialize(settings)) {

        // Create a new Album  with at title
        Album createdAlbum = photosLibraryClient.createAlbum("My Album");

        // Get some properties from the album, such as its ID and product URL
        String id = album.getId();
        String url = album.getProductUrl();

    } catch (ApiException e) {
        // Error during album creation
    }
}
