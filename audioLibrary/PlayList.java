import java.util.LinkedList;
import java.util.List;

/**
 * Represents a sequence of playables to play in FIFO order.
 */
public class PlayList implements Playable {

    private final List<Playable> aList = new LinkedList<>();
    private final String aName;
    private int aNext;
    private int numPlayable;

    /**
     * Creates a new empty playlist.
     *
     * @param pName
     *            the name of the list
     * @pre pName!=null;
     */
    public PlayList(String pName) {
        assert pName != null;
        aName = pName;
        aNext = 0;
    }

    public List<Playable> getPlayList(){
        List<Playable> temp = new LinkedList<>();
        for( Playable p : aList){
            temp.add(p);
        }
        return temp;
    }

    public int getNumPlayable(){
        return numPlayable;
    }

    /**
     * Adds a playable at the end of this playlist.
     *
     * @param pPlayable
     *            the content to add to the list
     * @pre pPlayable!=null;
     */
    public void addPlayable(Playable pPlayable) {
        assert pPlayable != null;
        aList.add(pPlayable);
        numPlayable++;
    }

    /**
     * compare 2 playlists
     * playlists are equal if they have the same playables in the same order
     * @param p
     * @pre p != null
     */
    public boolean compareTo(PlayList p){
        assert p != null;

        boolean isSame = false;
        if (this.getNumPlayable() != p.getNumPlayable()){
            return false;
        }

        List<Playable> otherList = p.getPlayList();

        for(int i = 0; i < this.getNumPlayable(); i++){
            if(this.aList.get(i) == otherList.get(i)) {
                isSame = true; // song and same object
            }
            else if(this.aList.get(i) != otherList.get(i) && this.aList.get(i).getClass() == otherList.get(i).getClass() && this.aList.get(i).getClass() == Song.class){
                return false;
            }
            if(this.aList.get(i).getClass() == otherList.get(i).getClass() && this.aList.get(i).getClass() == Episode.class){
                isSame = ((Episode)this.aList.get(i)).equals((Episode)otherList.get(i));
                if(isSame == false){
                    return false;
                }
            }
        }
        return isSame;
    }

    @Override
    public void play() {
        for(Playable p : aList){
            p.play();
        }
    }

    public String getaName(){
        return aName;
    }
}
