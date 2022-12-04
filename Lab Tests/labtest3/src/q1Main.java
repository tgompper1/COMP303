public class q1Main {
    public static void main(String args[]){
        SwimRobot swimmer = new SwimRobot("Swimmer", "Tess");
        System.out.println("Swimmer swims, stops, and walks");
        swimmer.toSwim();
        swimmer.toStop();
        swimmer.toWalk();

        System.out.println();

        StandardRobot flier = new FlyRobot("Flier", "Tess");
        System.out.println("Flier flys, stops, and walks");
        ((FlyRobot) flier).toFly();
        flier.toStop();
        flier.toWalk();

        System.out.println();

        StandardRobot basic  = new StandardRobot("basic", "Tess");

        System.out.println("Robot type checks");
        System.out.print("basic: ");
        basic.printRobotType();
        System.out.print("Swimmer: ");
        swimmer.printRobotType();
        System.out.print("Flier: ");
        flier.printRobotType();
    }
}
