package org.interview.service;

import org.interview.model.Song;
import org.interview.model.User;

import java.util.List;
import java.util.Map;

public interface IMusic {

    /**
     * Returns a list of all songs belonging to the provided user.
     *
     * @param user The user object whose songs you want to retrieve.
     * @return A list of all songs associated with the given user.
     * @throws NullPointerException If the user object is null.
     */
    public List<Song> getAllSongFromUser(User user);

    /**
     * Returns a map where the key is a Song object and the value is the number of times that song has been listened to by the specified user.
     *
     * @param user The user object whose listening data you want to analyze.
     * @return A map containing song objects as keys and listen counts as values.
     * @throws NullPointerException If the user object is null.
     */
    Map<Song, Long> getUniqueListen(User user);

    /**
     * Returns a list of the top listened-to songs for the specified user, sorted by descending listen count.
     *
     * @param user The user object for whom you want to find the top songs.
     * @return A list of the most listened-to songs for the user, sorted by listen count.
     * @throws NullPointerException If the user object is null.
     */
    List<Song> getTopSong(User user);

    /**
     * Returns a map where the key is a genre string and the value is a list of songs belonging to that genre.
     *
     * @return A map grouping all songs by their genre.
     * @throws UnsupportedOperationException If the implementation doesn't support grouping by genre.
     */
    Map<String, List<Song>> getSongByGenre();

    /**
     * Returns a map where the key is a genre string and the value is the average duration (in some unit, e.g., seconds) of the songs belonging to that genre.
     *
     * @return A map containing genre strings as keys and average song durations as values.
     * @throws UnsupportedOperationException If the implementation doesn't support calculating average duration.
     */
    Map<String, Double> getAvgDuration();


}
