import java.util.ArrayList;
import java.util.List;

public class Spindive implements Trick {
    final private String aName = "Spindive";
    final private List<BasicMove> aMovements = new ArrayList<BasicMove>();
    final private double aDistance;
    final private boolean aIsRecorded;
    final private Direction aDirection;
    final private Speed aSpeed;
    final private VideoFormats aVidFormat;

    public Spindive(double dist, boolean pRecorded, VideoFormats pVidFormat){
        assert dist > 0;
        aDistance = dist;
        aIsRecorded = pRecorded;
        aMovements.add(new BasicMove(Direction.DOWN, dist/3, Speed.HIGH, pRecorded));
        aMovements.add(new BasicMove(Direction.RIGHT, dist/3, Speed.HIGH, pRecorded));
        aMovements.add(new BasicMove(Direction.RIGHT, dist/3, Speed.HIGH, pRecorded));
        aMovements.add(new BasicMove(Direction.DOWN, dist/3, Speed.LOW, pRecorded));
        aDirection = Direction.DOWN;
        aSpeed = getMySpeed();
        aVidFormat = pVidFormat;
    }

    private Speed getMySpeed(){
        Speed cur;
        Speed max = Speed.LOW;
        for(BasicMove m : aMovements){
            cur = m.getSpeed();
            if(max.compareTo(cur) > 0){
                max = cur;
            }
        }
        return max;
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
        if(aIsRecorded == true) {
            System.out.println("Executing Spindive for " + aDistance + " meters ... recording as " + aVidFormat);
        }
        else{
            System.out.println("Executing Spindive for " + aDistance + " meters");
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