public class FlyRobot extends StandardRobot {

    public FlyRobot(String pRobotName, String pManagerName) {
        super(pRobotName, pManagerName);
    }

    public void toFly(){
        System.out.println("fly");
    }

    @Override
    public void printRobotType(){
        System.out.println("fly");
    }
}
