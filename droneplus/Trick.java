import java.util.ArrayList;

public interface Trick extends Movement {
    public String getName();
    public ArrayList<BasicMove> getMovements();

}