public class SwimRobot extends StandardRobot{
    public SwimRobot(String pRobotName, String pManagerName) {
        super(pRobotName, pManagerName);
    }

    public void toSwim(){
        System.out.println("swim");
    }

    @Override
    public void printRobotType(){
        System.out.println("swim");
    }

    /*@Override
    public void toWalk(){

    }*/

    /*@Override
    public void toStop(){

    } */
}
