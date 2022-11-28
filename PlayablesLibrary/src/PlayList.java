import java.util.*;

/**
 * Represents a sequence of playables to play in FIFO order.
 */
public class PlayList implements Playable, Cloneable{

    private List<Playable> aList = new LinkedList<>();
    private String aName;

    private ArrayList<StateChangingMethod> prevCalls = new ArrayList<>();
    private ArrayList<StateChangingMethod> undoneCalls = new ArrayList<>();

    private static boolean lastStateChangingCallUndo;

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
        lastStateChangingCallUndo = false;
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
        ConcreteAddPlayable call = new ConcreteAddPlayable(this, pPlayable);
        prevCalls.add(0, call);
        aList.add(pPlayable);
        lastStateChangingCallUndo = false;
    }

    /**
     * remove a playable from the Playlist given its index
     * @param pIndex
     *          the index of playable to be removed
     * @return the removed playable
     */
    public Playable removePlayable(int pIndex) {
        assert pIndex >= 0 && pIndex < aList.size();
        ConcreteRemovePlayable call = new ConcreteRemovePlayable(this, pIndex);
        prevCalls.add(0,call);
        lastStateChangingCallUndo = false;
        return aList.remove(pIndex);
    }

    /**
     * @return The name of the playlist.
     */
    public String getName() {
        return aName;
    }

    /**
     * modify the name of the playlist
     * @param pName
     *          the new name of the playlist
     */
    public void setName(String pName) {
        assert pName != null;
        ConcreteSetName call = new ConcreteSetName(this, pName);
        prevCalls.add(0, call);
        this.aName = pName;
        lastStateChangingCallUndo = false;
    }

    // dont need
    /**
     * get the index of the last playable in the playlist
     * @return size of playlist - 1
     */
    public int getSize(){
        return aList.size();
    }

    /**
     * Iterating through the playlist to play playable content.
     */
    @Override
    public void play() {
        for(Playable playable:aList){
            playable.play();
        }
    }

    /**
     * change the order how playlist play the playables it contains
     */
    public void shuffle() {
        lastStateChangingCallUndo = false;
        ConcreteShuffle call = new ConcreteShuffle(this);
        prevCalls.add(0,call);
        Collections.shuffle(aList);
        lastStateChangingCallUndo = false;
    }

    /**
     * undo the last method call
     * @return undone playlist
     */
    public PlayList undo(){

        if(prevCalls.size() == 0){
            return this;
        }
        PlayList undone = prevCalls.get(0).undo().get();
        StateChangingMethod removed = prevCalls.remove(0);
        undoneCalls.add(0, removed);
        lastStateChangingCallUndo = true;
        return undone;
    }

    /**
     * redo previous call or redo previous undone call
     * @return updated playlist
     */
    public Playable redo(){
        Playable r;
        if(prevCalls.size() == 0 && undoneCalls.size() == 0){
            return this;
        }
        if(lastStateChangingCallUndo == false){
            r = prevCalls.get(0).redo();
            StateChangingMethod call =  prevCalls.get(0).clone();
            prevCalls.add(0, call);
        }
        else{
            r = undoneCalls.get(0).redo();
            undoneCalls.remove(0);
            lastStateChangingCallUndo = true;
        }
        return r;
    }

    /**
     * Checks is two playlists are equal based on playable objects and their order
     *
     * @param o
     *            The object to compare a playlist to
     * @return    This method returns true if the playlist is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return this.aList.equals(playList.aList);
    }

    /**
     * Equal playlists have the same hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(aList);
    }

    /**
     * @return cloned playlist
     */
    @Override
    public PlayList clone(){
        try {
            PlayList clone = (PlayList) super.clone();
            clone.aList = new ArrayList<>();
            for(Playable p : aList){
                clone.aList.add(p.clone());
            }
            return clone;
        }
        catch(CloneNotSupportedException e){
            assert false;
            return null;
        }
    }

    public class ConcreteAddPlayable implements StateChangingMethod, Cloneable{
        PlayList prevPList;
        int index;
        Playable added;
        PlayList aPList;

        /**
         *  creates a concreteAddPlayable object
         * @param pPlist playlist in current state before adding the new playable
         * @param pAdded the added playable
         */
        public ConcreteAddPlayable(PlayList pPlist, Playable pAdded){
            prevPList = pPlist.clone();

            for(int i = 0; i < aList.size(); i++){
                prevPList.aList.set(i, aList.get(i));
            }
            index = aList.size();
            added = pAdded.clone();
            aPList = pPlist;
        }

        /**
         *
         * @return previous state of playlist
         */
        @Override
        public Optional<PlayList> undo() {
            aList.remove(added);
            return Optional.of(prevPList);
        }

        /**
         *
         * @return playlist with after redoing
         */
        @Override
        public Playable redo() {
            aList.add(index,added);
            return aPList;
        }

        @Override
        public ConcreteAddPlayable clone(){
            try {
                ConcreteAddPlayable clone = (ConcreteAddPlayable) super.clone();
                clone.prevPList = this.aPList;
                clone.aPList = this.aPList;
                clone.added = this.added;
                return clone;
            }
            catch(CloneNotSupportedException e){
                assert false;
                return null;
            }
        }
    }

    public class ConcreteRemovePlayable implements StateChangingMethod, Cloneable{

        PlayList prevPList ;
        PlayList aPList;
        int index;
        Playable aRemoved;

        /**
         *
         * @param pPlist playlist in current state before playable is removed
         * @param pIndex playable to be removed
         */
        public ConcreteRemovePlayable(PlayList pPlist, int pIndex){
            prevPList = pPlist.clone();
            aRemoved = pPlist.aList.get(pIndex).clone();
            for(int i = 0; i < pPlist.getSize(); i++){
                prevPList.aList.set(i, aList.get(i));
            }
            index = pIndex;
            aPList = pPlist;
        }

        /**
         *
         * @return stored previous state
         */
        @Override
        public Optional<PlayList> undo() {
            return Optional.of(prevPList);
        }

        /**
         *
         * @return playlist state after redoing
         */
        @Override
        public Playable redo() {
            aPList.removePlayable(index);
            return (aPList);
        }

        @Override
        public ConcreteRemovePlayable clone(){
            try {
                ConcreteRemovePlayable clone = (ConcreteRemovePlayable) super.clone();
                clone.prevPList = this.prevPList;
                clone.aPList = this.aPList;
                clone.aRemoved = this.aRemoved;
                return clone;
            }
            catch(CloneNotSupportedException e){
                assert false;
                return null;
            }
        }
    }

    public class ConcreteShuffle implements StateChangingMethod, Cloneable{

        PlayList prevPList;
        PlayList aPList;

        /**
         *
         * @param pPList pre shuffle state
         */
        public ConcreteShuffle(PlayList pPList){
            prevPList = pPList.clone();
            aPList = pPList;
            for(int i = 0; i < pPList.getSize(); i++){
                prevPList.aList.set(i, aList.get(i));
            }
        }

        /**
         *
         * @return playlist reverted to stored state
         */
        @Override
        public Optional<PlayList>  undo() {
            return Optional.of(prevPList);
        }

        /**
         *
         * @return playlist shuffled again
         */
        @Override
        public Playable  redo() {
            Collections.shuffle(aList);
            return (aPList);
        }

        @Override
        public ConcreteShuffle clone(){
            try {
                ConcreteShuffle clone = (ConcreteShuffle) super.clone();
                clone.prevPList = this.prevPList;
                clone.aPList = this.aPList;
                return clone;
            }
            catch(CloneNotSupportedException e){
                assert false;
                return null;
            }
        }
    }

    public class ConcreteSetName implements StateChangingMethod, Cloneable{

        String prevName;
        PlayList aPList;

        /**
         *
         * @param pPList current state before name change
         * @param pName name before name change
         */
        public ConcreteSetName(PlayList pPList, String pName){
            prevName = pName;
            aPList = pPList.clone();
        }

        /**
         *
         * @return plist with previous name
         */
        @Override
        public Optional<PlayList> undo() {
            aPList.aName=prevName;
            return Optional.of(aPList);
        }


        @Override
        public Playable redo() {

            return aPList;
        }

        @Override
        public ConcreteSetName clone(){
            try {
                ConcreteSetName clone = (ConcreteSetName) super.clone();
                clone.aPList = this.aPList;
                return clone;
            }
            catch(CloneNotSupportedException e){
                assert false;
                return null;
            }
        }
    }
}