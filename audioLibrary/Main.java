public class Main {
    public static void main(String[] args) {

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Making sure there is only one object of the library...");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Creating myLibrary...");
        Library myLibrary = Library.libraryInstance();
        System.out.println("Creating myLibrary2...");
        Library myLibrary2 = Library.libraryInstance();
        boolean sameLib = myLibrary == myLibrary2;
        System.out.println("2 libraries refer to the same instance: " + sameLib);

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

        //make library with natural langauge
        System.out.println("Showing adding natural language description capability:");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("My Library's Language: "+ myLibrary.getNaturalLanguageDescription());
        myLibrary.setNaturalLanguageDescription("English");
        System.out.println("Adding language...");
        System.out.println("My Library's Language: "+ myLibrary.getNaturalLanguageDescription());

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");


        System.out.println("Creating 3 songs, Song1 and Song3 are duplicates, and adding them to the library");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

        //create a song
        Song song1 = Song.newSong("Yesterday", "the Beatles");
        Song song2 = Song.newSong("Today", "The Weatles");
        // duplicate
        Song song3 = Song.newSong("Yesterday", "the beatles");
        myLibrary.addSong(song1);
        myLibrary.addSong(song2);
        myLibrary.addSong(song3);
        System.out.println("Songs in Library:");
        myLibrary.getMySongs();
        boolean areTheSame = song3==song1;
        System.out.println("Song1 and Song3 refer to the same object: " + areTheSame);

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");


        //create a podcast
        System.out.println("Creating 3 podcasts, adding two episodes to each, Podcast1 and Podcast2 are duplicates, and adding them to the library");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

        Podcast Podcast1 = Podcast.newPodcast("NPR", "Audie Cornish");
        Podcast Podcast2 = Podcast.newPodcast("npr", "Audie Cornish");
        Podcast Podcast3 = Podcast.newPodcast("Office Ladies", "Genna Fisher");
        Episode e1 = new Episode(Podcast1, "Pilot", 1);
        Episode e2 = new Episode(Podcast2, "episode 1", 2);
        boolean a = Podcast1 == Podcast2;
        Episode e11 = new Episode(Podcast3, "episode 1", 1);
        Episode e12 = new Episode(Podcast3, "episdoe 2", 2);
        myLibrary.addPodcast(Podcast1);
        myLibrary.addPodcast(Podcast2);
        myLibrary.addPodcast(Podcast3);
        System.out.println("Podcasts in Library: ");
        myLibrary.getMyPodcasts();
        boolean podcastsAreTheSame = Podcast1 == Podcast2;
        System.out.println("Podcast1 and Podcast2 refer to the same object: " + podcastsAreTheSame);

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Creating 3 playlists, Playlist 1 and 3 are the same, and adding to library");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

        PlayList pl1 = new PlayList("Playlist 1");
        PlayList pl2 = new PlayList("Playlist 2");
        PlayList pl3 = new PlayList("Playlist 3");

        Song song4 = Song.newSong("What Makes you Beautiful", "One Direction");
        pl1.addPlayable(song1);
        pl1.addPlayable(song2);
        pl1.addPlayable(Podcast1.getEpisode(1));
        pl1.addPlayable(song4);
        myLibrary.addPlayList(pl1);

        pl2.addPlayable(song2);
        pl2.addPlayable(song1);
        pl2.addPlayable(Podcast1.getEpisode(1));
        pl2.addPlayable(pl1);
        myLibrary.addPlayList(pl2);

        pl3.addPlayable(song1);
        pl3.addPlayable(song2);
        pl3.addPlayable(Podcast1.getEpisode(1));
        pl3.addPlayable(song4);
        myLibrary.addPlayList(pl3);

        System.out.println("Playlists in library:");
        myLibrary.getMyPlaylists();
        System.out.println();

        System.out.println("Playing Playlist 1...");
        myLibrary.playPlaylist("Playlist 1");

        System.out.println();


        System.out.println("Playing Playlist 2...");
        myLibrary.playPlaylist("Playlist 2");

        System.out.println();


        System.out.println("Playing Playlist 3...");
        myLibrary.playPlaylist("Playlist 3");

        System.out.println();

        System.out.println("Comparing Playlist 1 and Playlist2...");
        System.out.println("Playlist 1 and Playlist 2 are the same: " + pl1.compareTo(pl2));
        System.out.println("Comparing Playlist 1 and Playlist 3...");
        System.out.println("Playlist 1 and Playlist 3 are the same: " + pl1.compareTo(pl3));

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Final contents of library (Songs and episodes):");
        myLibrary.getMyPlayables();
    }
}
