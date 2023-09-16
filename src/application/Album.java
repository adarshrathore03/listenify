package application;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String albumName;
    private List<Song> songList;
    private String artistName;

    public Album(String albumName,String artistName){
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }
    public Album(String albumName, List<Song> songList, String artistName) {
        this.albumName = albumName;
        this.songList = songList;
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }



    public boolean findSongs(String enteredTitle){
        //you need to check if this song is present or not in album
        for(Song song : songList){
            if(song.getName().equals(enteredTitle)){
                return true;
            }
        }
        return false;
    }
    public String addNewSongToAlbum(String title,double duration){
        //adding song to the songlist
        // 1 - check if already present
        if(findSongs(title)){
            return "song is already present";
        }

        //if not present
        Song newSong = new Song(title,duration);
        songList.add(newSong);
        return title+" has been added in song list";
    }

    public String addSongToPlayList(int songNo,List<Song> playList){
        int index = songNo-1;

        if(index>=0 && index<songList.size()){
            Song song = songList.get(index);
            playList.add(song);
            return "song has been added in playlist";
        }
        else{
            return "song number is out of range";
        }
    }

    public String addSongToPlayList(String title,List<Song> playList){
        for(Song song : songList){
            if(title.equals(song.getName())){
                playList.add(song);
                return "song has been added in playlist";
            }
        }
        return "song is not present in album";
    }
}
