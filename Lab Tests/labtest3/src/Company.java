import java.util.ArrayList;

public class Company {
    private final ArrayList<StandardRobot> aRobots = new ArrayList<>();

    private final String aCompanyName;

    public Company(String pCompanyName){
        aCompanyName = pCompanyName;
    }

    public void addRobot(StandardRobot pRobot){
        assert pRobot !=null;
        aRobots.add(pRobot);
    }

    public void setManager(String pManager, StandardRobot pRobot){
        noticeRobot(pManager, pRobot);
    }

    //triggers robot to set its  managername field
    private void noticeRobot(String pManager, StandardRobot pRobot){
        pRobot.setManager(pManager);
    }

    //set isSleep to false for all robots
    public void wakeRobots(){
        for(StandardRobot r : aRobots){
            r.setSleep(false);
        }
    }
}
