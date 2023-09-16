package application;

import application.Album;
import application.Song;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Listenify world");

        Album album_1 = new Album("Latest Song","Arijit Singh");

        album_1.addNewSongToAlbum("tum hi ho",3.5);
        album_1.addNewSongToAlbum("kesariya",5.2);
        album_1.addNewSongToAlbum("shayad",6.0);


        Album album_2 = new Album("Old songs","Kishore kumar");
        album_2.addNewSongToAlbum("neele nele ambar par",3.6);
        album_2.addNewSongToAlbum("mere mehboob qayamat",6.0);
        album_1.addNewSongToAlbum("mere ke sapno ki rani",5.3);

        List<Song> playList = new ArrayList<>();

        album_1.addSongToPlayList(1,playList);
        album_1.addSongToPlayList(3,playList);

        album_2.addSongToPlayList("mere mehboob qayamat",playList);
        album_2.addSongToPlayList("neele neele ambar par",playList);

        menu();
        startSong(playList);


    }

    public static void startSong(List<Song> playList){
        int index = 0;
        System.out.println("Now playing : "+playList.get(index).toString());

        Scanner sc = new Scanner(System.in);

        boolean continuePlayList = true;

        while(true){
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch (choice){
                case 1 :
                    if(index < (playList.size()-1)){
                        index++;
                    }
                    else{
                        index = 0;
                    }
                    System.out.println("Now playing"+playList.get(index).toString());
                    break;

                case 2 :
                    if(index==0){
                        index = 0;
                    }
                    else {
                        index--;
                    }
                    System.out.println("Now playing"+playList.get(index).toString());
                    break;

                case 3 :
                    System.out.println("Now playing"+playList.get(index).toString());
                    break;

                case 4 :
                    printPlayList(playList);
                    break;

                case 5 :
                    menu();
                    break;

                case 6 :
                    playList.remove(index);
                    //it will goto the next index
                    if(index== playList.size()){
                        index = 0;
                    }
                    break;

                case 7 :
                    Collections.shuffle(playList);
                    break;

                case 8 :
                    continuePlayList = false;
                    break;
            }
        }
    }
    public static void printPlayList(List<Song> playList){
        for(Song song : playList){
            System.out.println(song.toString());
        }
    }
    public static void menu(){
        System.out.println("These are the options you can choose from");
        System.out.println("1 : Goto and play next song");
        System.out.println("2 : Goto the previous song");
        System.out.println("3 : Repeat the same song");
        System.out.println("4 : Show all songs of playlist");
        System.out.println("5 : print menu");
        System.out.println("6 : Delete the current song");
        System.out.println("7 : Shuffel the playlist");
        System.out.println("8 : Exit playlist");
    }
}