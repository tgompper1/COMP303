import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single Podcast, with at least a name and a host. Each Podcast aggregates episodes.
 */
public class Podcast{

    private static final ArrayList<Podcast> PODCASTS = new ArrayList<Podcast>();

    private final String aName;
    private final String aHost;

    private final List<Episode> aEpisodes = new ArrayList<>();
    private int numEpisodes = 0;

    /**
     * private flyweight constructor
     */
    private Podcast(String pName, String pHost){
        aName = pName.toLowerCase();
        aHost = pHost.toLowerCase();
    }

    /**
     * if a podcast foes not all ready exist, it is created
     * flyweight pattern
     * @param pName
     * @param pHost
     * @pre pName != null && pHost != null
     */
    public static Podcast newPodcast(String pName, String pHost){
        assert pName != null && pHost != null;
        boolean alreadyCreated = false;
        for(Podcast p : PODCASTS ){
            if (p.aHost.equals(pHost.toLowerCase()) && p.aName.equals(pName.toLowerCase())){
                alreadyCreated = true;
                return p;
            }
        }
        if(alreadyCreated == false){
            Podcast p = new Podcast(pName.toLowerCase(), pHost.toLowerCase());
            PODCASTS.add(p);
            return p;
        }
        return null;
    }

    /**
     * if a podcasts has already been created, it is returned, otherwise client is notified no such podcast exists
     * @param pName
     * @param pHost
     * @pre pName != null && pHost != null
     */
    public Podcast getPodcast(String pName, String pHost){
        assert pName != null && pHost != null;
        for(Podcast p : PODCASTS){
            if (p.aName == pName.toLowerCase() && p.aHost == pHost.toLowerCase()){
                return p;
            }
        }
        System.out.println("No such Podcast");
        return null;
    }


    /**
     * Add one episode to the podcast
     * @param pEpisode to be put into the podcast
     * @pre pEpisode != null
     */
    protected void addEpisode(Episode pEpisode) {
        assert pEpisode != null;
        if(!aEpisodes.contains(pEpisode)) {
            aEpisodes.add(pEpisode);
        }
        numEpisodes++;
    }

    /**
     * retrieve one episode from the podcast
     * @param pIndex
     * @pre pIndex >= 0
     */
    public Episode getEpisode(int pIndex) {
        if(aEpisodes.size() > pIndex){
            return aEpisodes.get(pIndex);
        }
        return null;
    }

    public String getName() {
        String temp = aName;
        return temp;
    }

    public String getaHost() {
        String temp = aHost;
        return temp;
    }

    public int getNumEpisodes() {
        int temp = numEpisodes;
        return temp;
    }

    public String toString(){
        return aName + " hosted by " + aHost + " Episodes: " + aEpisodes;
    }
}