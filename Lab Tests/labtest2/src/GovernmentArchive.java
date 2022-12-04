import java.util.ArrayList;

public class GovernmentArchive {
    private String name;
    ArrayList<Government> govs = new ArrayList<>();;
    //flyweight


    private GovernmentArchive(String pName){
        name = pName;
    }

    public void addGov(String pName, int pSession){
        for(Government g : govs){
            if(g.getName().equals(pName) && g.getSession() == pSession){
                return;
            }
        }
        Government newG = new Government(pName, pSession);
        govs.add(newG);
    }

    /**
     * @pre there exists a government in the system with the given name and session
     * @post the indicated government
     */
    public Government getGov(String name, int session){
        for(Government g : govs){
            if(g.getName().equals(name) && g.getSession() == session){
                return g;
            }
        }
        //if its not there, create, add and return it
        Government newG = new Government(name, session);
        govs.add(newG);
        return newG;
    }
}