package org.interview.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {

    private String name;
    private User owner; // Reference to the owning User object
    private List<Song> songs;
    private LocalDateTime creationDate;

    // Getters and setters for each attribute

    public Playlist(String name, User owner) {
        this.name = name;
        this.owner = owner;
        this.songs = new ArrayList<>(); // Initialize with an empty list
        this.creationDate = LocalDateTime.now();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(songs); // Return an unmodifiable copy
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
// Additional methods like shuffleSongs(), getDuration(), toString() as needed
}
