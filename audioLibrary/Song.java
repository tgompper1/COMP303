import java.util.ArrayList;
import java.util.Locale;

/**
 * Represents a single Song, with at least a title, and an artist name.
 */
public class Song implements Playable{

    private static final ArrayList<Song> SONGS = new ArrayList<Song>();

    private final String aTitle;
    private final String aArtist;

    /**
     * private flyweight constructor
     */
    private Song(String pTitle, String pArtist){
        aTitle = pTitle.toLowerCase();
        aArtist = pArtist.toLowerCase();
    }

    /**
     * creates a new song given artist and title, will not duplicate
     * flyweight pattern
     * @param pTitle
     * @param pArtist
     * @pre pTitle != null && pArtist != null
     */
    public static Song newSong(String pTitle, String pArtist){
        assert pTitle != null && pArtist != null;
        boolean alreadyCreated = false;
        for(Song s : SONGS ){
            if (s.aArtist.equals(pArtist.toLowerCase()) && s.aTitle.equals(pTitle.toLowerCase())){
                alreadyCreated = true;
                return s;
            }
        }
        if(alreadyCreated == false){
            Song s = new Song(pTitle.toLowerCase(), pArtist.toLowerCase());
            SONGS.add(s);
            return s;
        }
        return null;
    }

    /**
     *
     * @param pTitle
     * @param pArtist
     * @return requested song when given valid inputs, otherwise null
     * @pre pTitle != null && pArtist != null
     */
    public Song getSong(String pTitle, String pArtist){
        assert pTitle != null && pArtist != null;
        for(Song s : SONGS){
            if (s.aArtist == pArtist.toLowerCase() && s.aTitle == pTitle.toLowerCase()){
                return s;
            }
        }
        System.out.println("No such song");
        return null;
    }

    public void play() {
        // Just a stub.
        // We don't expect you to implement an actual music player!
        System.out.println("Now playing " + aTitle);
    }

    public String getTitle(){
        return aTitle;
    }

    public String getArtist(){
        return aArtist;
    }

    public String toString(){
        return aTitle +" by "+ aArtist;
    }
}

