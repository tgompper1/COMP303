import java.util.ArrayList;
import java.util.List;

public class Pucker implements Trick {
    final private String aName = "Pucker";
    final private List<BasicMove> aMovements = new ArrayList<BasicMove>();
    final private boolean aIsRecorded;
    final private double aDistance;
    final private Direction aDirection;
    final private Speed aSpeed;
    final private VideoFormats aVidFormat;

    public Pucker(double pDist, boolean pRecorded, Speed s, VideoFormats pVidFormat){
        assert pDist > 0;
        aDistance = pDist;
        aIsRecorded = pRecorded;
        aMovements.add(new BasicMove(Direction.UP, pDist/6, s, pRecorded));
        aMovements.add(new BasicMove(Direction.LEFT, pDist/6, s, pRecorded));
        aMovements.add(new BasicMove(Direction.LEFT, pDist/6, s, pRecorded));
        aMovements.add(new BasicMove(Direction.LEFT, pDist/6, s, pRecorded));
        aMovements.add(new BasicMove(Direction.LEFT, pDist/6, s, pRecorded));
        aMovements.add(new BasicMove(Direction.DOWN, pDist/6, s, pRecorded));
        aDirection = null;
        aSpeed = s;
        aVidFormat = pVidFormat;
    }

    @Override
    public String getName(){
        return aName;
    }

    @Override
    public ArrayList<BasicMove> getMovements(){
        ArrayList<BasicMove> moves = new ArrayList<BasicMove>();
        for(BasicMove m : aMovements){
            moves.add(m);
        }
        return moves;
    }

    @Override
    public void execute(Drone d){
        if(aIsRecorded == true){

            System.out.println("Executing Pucker for " + aDistance + " meters at " + aSpeed + " speed... recording as " + aVidFormat);
        }
        else {
            System.out.println("Executing Pucker for " + aDistance + " meters at " + aSpeed + " speed");
        }
    }

    @Override
    public boolean isRecorded() {
        return aIsRecorded;
    }

    @Override
    public Direction getDirection() {
        return aDirection;
    }

    @Override
    public double getDistance() {
        return aDistance;
    }

    @Override
    public Speed getSpeed() {
        return aSpeed;
    }

}
