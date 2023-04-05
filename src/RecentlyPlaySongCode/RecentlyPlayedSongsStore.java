package RecentlyPlaySongCode;

import java.util.*;

public class RecentlyPlayedSongsStore 
{
    private final int capacity;
    private final Map<String, Deque<String>> userSongsMap;

    public RecentlyPlayedSongsStore(int capacity) 
    {
        this.capacity = capacity;
        userSongsMap = new HashMap<>();
    }

    public void addSong(String user, String songs2) 
    {
        Deque<String> songs = userSongsMap.get(user);
        if (songs == null) 
        {
            songs = new ArrayDeque<>();
            userSongsMap.put(user, songs);
        } else if (songs.size() >= capacity) 
        {
            songs.removeFirst(); // remove least recently played song
        }
        songs.addLast(songs2); // add new song
    }

    public List<String> getRecentlyPlayedSongs(String user) 
    {
        Deque<String> songs = userSongsMap.get(user);
        if (songs == null) 
        {
            return Collections.emptyList();
        } else 
        {
            return new ArrayList<>(songs); // return copy of the songs deque as a list
        }
    }
}

