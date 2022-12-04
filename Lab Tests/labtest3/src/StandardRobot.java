public class StandardRobot {

    private final String aRobotName;
    private String aManagerName;
    private boolean isSleep;

    public StandardRobot(String pRobotName, String pManagerName){
        aRobotName = pRobotName;
        aManagerName=pManagerName;
        isSleep = true;
    }

    final public void toWalk(){
        System.out.println("walk");
    }

    final public void toStop(){
        System.out.println("stop");
    }

    public void printRobotType(){
        System.out.println("standard");
    }




    // part 2

    public void setManager(String pManager){
        aManagerName = pManager;
    }

    public String getManager(){
        return aManagerName;
    }

    public void setSleep(Boolean b){
        isSleep = b;
    }

    public boolean isSleep(){
        return isSleep;
    }
}
