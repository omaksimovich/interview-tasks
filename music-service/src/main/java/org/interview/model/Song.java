package org.interview.model;

import java.time.LocalDateTime;

public class Song {

    private String title;
    private String artist;
    private String album;
    private String genre;
    private int durationInSeconds; // Store duration in seconds for flexibility
    private int listenCount;
    private LocalDateTime releaseDate;

    // Getters and setters for each attribute

    public Song(String title, String artist, String album, String genre, int durationInSeconds, LocalDateTime releaseDate) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.durationInSeconds = durationInSeconds;
        this.listenCount = 0; // Initialize with 0 listens
        this.releaseDate = releaseDate;
    }

    // Additional methods like play(), pause(), toString() as needed
}
