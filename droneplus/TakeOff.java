import java.util.ArrayList;
import java.util.List;

public class TakeOff implements Trick {
    final private String aName = "Take Off";
    final private List<BasicMove> aMovements = new ArrayList<BasicMove>();
    final private boolean aIsRecorded;
    final private double aDistance;
    final private Direction aDirection;
    final private Speed aSpeed;
    final private VideoFormats aVidFormat;

    public TakeOff(double pDistance, boolean pRecorded, VideoFormats pVidFormat){ //vid format can be null
        assert pDistance > 0;
        aDistance = pDistance;
        aMovements.add(new BasicMove(Direction.UP, pDistance/2, Speed.LOW, pRecorded ));
        aMovements.add(new BasicMove(Direction.UP, pDistance/2, Speed.MODERATE, pRecorded ));
        aIsRecorded = pRecorded;
        aDirection = Direction.UP; //returns general direction
        aSpeed = getMySpeed();  //returns max speed
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

    @Override
    public void execute(Drone d){
        if(aIsRecorded == true){
            System.out.println("Executing Take Off... recording as " + aVidFormat);
        }
        else {
            System.out.println("Executing Take Off...");
        }
    }
}