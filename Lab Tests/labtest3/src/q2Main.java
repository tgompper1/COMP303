import java.util.ArrayList;

public class q2Main {
    public static void main(String args[]) {
        Company myRobotCompany = new Company("Robos");

        StandardRobot r1 = new StandardRobot("r1", "Tess");
        StandardRobot r2 = new StandardRobot("r2", "Tess");
        StandardRobot s1 = new SwimRobot("s1", "Tess");
        StandardRobot s2 = new SwimRobot("s2", "Tess");
        StandardRobot f1 = new FlyRobot("f1", "Tess");
        StandardRobot f2 = new FlyRobot("f2", "Tess");

        myRobotCompany.addRobot(r1);
        myRobotCompany.addRobot(r2);
        myRobotCompany.addRobot(s1);
        myRobotCompany.addRobot(s2);
        myRobotCompany.addRobot(f1);
        myRobotCompany.addRobot(f2);

        System.out.println(r1.getManager());
        myRobotCompany.setManager("not Tess", r1);
        System.out.println(r1.getManager());

        System.out.println(r1.isSleep() +" " + r2.isSleep() +" "+ f1.isSleep() +" " + f2.isSleep() + " "+ s1.isSleep()+ " " + s2.isSleep());
        myRobotCompany.wakeRobots();
        System.out.println(r1.isSleep() +" " + r2.isSleep() +" "+ f1.isSleep() +" " + f2.isSleep() + " "+ s1.isSleep()+ " " + s2.isSleep());

    }
}
