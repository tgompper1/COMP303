import java.util.ArrayList;

public class Government {
    private String name;
    private int session;

    Government(String pName, int pSession){
        name = pName;
        session = pSession;
    }

    public String getName(){
        return name;
    }
    public int getSession(){
        return session;
    }
}
