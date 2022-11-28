import java.util.ArrayList;
import java.util.Optional;

/**
 * Represents an Audio library, with individual Song titles, Podcasts and playlists.
 */
public class Library {

    private String aName;
    private Optional<String> aNaturalLanguageDescription;

    private static final Library INSTANCE = new Library(); // single instance of the Library

    //private ArrayList<Song> mySongs = new ArrayList<Song>();
    private final ArrayList<Playable> myPlayables = new ArrayList<Playable>(); // all songs and episodes
    private final ArrayList<Podcast> myPodcasts = new ArrayList<Podcast>(); // all podcasts
    private final ArrayList<PlayList> myPlaylists = new ArrayList<PlayList>(); // all playlists

    /**
     * Private Singleton constructor
     */
    private Library(){
        aName = "My Library";
        aNaturalLanguageDescription = Optional.empty();
    }

    /**
     * accessor method, returns only instance of the library, library is immutable
     * @return INSTANCE
     */
    public static Library libraryInstance(){
        return INSTANCE;
    }

    /**
     * sets natural language description, given by user
     * @param pNaturalLanguageDescription
     * @pre pNaturalLanguageDescription != null
     */
    public void setNaturalLanguageDescription(String pNaturalLanguageDescription){
        assert pNaturalLanguageDescription != null;
        aNaturalLanguageDescription = Optional.of(pNaturalLanguageDescription);
    }

    /**
     * Stes library name to name of users choice
     * @param pName
     * @pre pName != null
     */
    public void setName(String pName){
        assert pName != null;
        aName = pName;
    }

    /**
     * unwraps and returns optional of natural language description of the library
     * if not present, prints a message for the user and returns "not available"
     * @return aNaturalLanguageDescription
     */
    public String getNaturalLanguageDescription(){
        if(aNaturalLanguageDescription.isPresent()){
            String lang = aNaturalLanguageDescription.get();
            return lang;
        }
        else{
            System.out.println("No natural language description for " + aName);
            return "not available";
        }
    }

    /**
     * Adds a Song to the library. Duplicate Songs aren't added twice.
     * Song added to list of Playables
     * @param pSong
     *              the Song to add
     * @pre pSong != null
     */
    public void addSong(Song pSong) {
        assert pSong != null;

        if(!myPlayables.contains(pSong)){
            myPlayables.add(pSong);
        }
    }

    /**
     * Adds a PlayList to the library. All Songs from the list are also added as individual Songs to the library.
     * individual episodes are also added
     * @param pList
     *            the PlayList to add
     * @pre pList!=null;
     */
    public void addPlayList(PlayList pList) {
        assert pList != null;
        boolean alreadyAdded = false;

        for(PlayList pl : myPlaylists){
            if(pl.compareTo(pList) == true){
                alreadyAdded = true;
            }
        }
        if(alreadyAdded == false) {
            myPlaylists.add(pList);
            for (Playable p : pList.getPlayList()) {
                if(!myPlayables.contains(p) && p.getClass() == PlayList.class){
                    this.addPlayList((PlayList) p);
                }
                else if (!myPlayables.contains(p)) {
                    myPlayables.add(p);
                }
            }
        }
    }

    /**
     * Adds a Podcast to the library. All Episodes from the list are also added as individual episodes to the library.
     *
     * @param pPodcast
     *            the Podcast to add
     * @pre pPodcast!=null;
     */
    public void addPodcast(Podcast pPodcast) {
        assert pPodcast != null;

        if(myPodcasts.contains(pPodcast)){
            return;
        }
        myPodcasts.add(pPodcast);
        if(pPodcast.getNumEpisodes() > 0) {
            for (int i = 0; i < pPodcast.getNumEpisodes(); i++) {
                myPlayables.add(pPodcast.getEpisode(i));
            }
        }
    }

    /**
     *  PLays a given song if it is present in the library, otherwise notifies the client that the song is not in the library
     *
     * @param song
     * @assert song != null
     */
    public void playSong(Song song){
        assert song != null;

        boolean found = false;
        for(Playable s : myPlayables){
            if(song == s){
                found = true;
                s.play();
            }
        }
        if(!found){
            System.out.println("No such song in Library");
        }
    }

    /**
     * PLays a given episode from a given podcast if it is present in the library
     *      otherwise notifies the user the episode is not present in the library
     * @param podcast
     * @param episodeNumber
     * @pre podcast != null episodeNumber > 0
     */
    public void playPodcastEpisode(Podcast podcast, int episodeNumber){
        assert podcast != null && episodeNumber > 0;

        boolean found = false;
        for(Podcast p : myPodcasts){
            if(podcast == p){
                found = true;
                p.getEpisode(episodeNumber-1).play();
            }
        }
        if(!found){
            System.out.println("No such podcast with given episode number in Library");
        }
    }

    /**
     * Plays a given playlist in the library based on playlist name
     *      if the library contains no such playlist, notifies the user
     * @param playListName
     * @pre playListName != null
     */
    public void playPlaylist(String playListName){
        assert playListName != null;

        boolean played = false;
        for(PlayList p : myPlaylists){
            if(p.getaName().equals(playListName)){
                p.play();
                played = true;
            }
        }
        if(played == false){
            System.out.println("No such playlist in library");
        }
    }

    /**
     * Prints out all songs in myPlayables / returns all songs in the library
     */
    public void getMySongs() {
        for(Playable p : myPlayables){
            if (p.getClass() == Song.class){
                System.out.println(p);
            }
        }
    }

    /**
     * Prints out all playables (songs and episodes) in the library
     */
    public void getMyPlayables(){
        for(Playable p : myPlayables){
            System.out.println(p);
        }
    }

    /**
     * Prints out all podcasts in the library
     */
    public void getMyPodcasts(){
        for(Podcast p : myPodcasts){
            System.out.println(p);
        }
    }

    public void getMyPlaylists(){
        for(PlayList p : myPlaylists){
            System.out.println(p.getaName());
        }
    }

}
