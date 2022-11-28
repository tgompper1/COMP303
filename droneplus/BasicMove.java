public class BasicMove implements Movement {
    //immutable
    final private Direction aDirection;
    final private double aDistance;
    final private Speed aSpeed;
    final private boolean aIsRecorded;
    final private VideoFormats aVidFormat;

    public BasicMove(Direction pDirection, double pDistance, Speed pSpeed, boolean pIsRecorded){
        assert pDistance > 0 && pIsRecorded == false;
        aDirection = pDirection;
        aDistance = pDistance;
        aSpeed = pSpeed;
        aIsRecorded = false;
        aVidFormat = null;
    }

    public BasicMove(Direction pDirection, double pDistance, Speed pSpeed, boolean pIsRecorded, VideoFormats pVidFormat){
        assert pDistance > 0 && pIsRecorded == true;
        aDirection = pDirection;
        aDistance = pDistance;
        aSpeed = pSpeed;
        aIsRecorded = true;
        aVidFormat = pVidFormat;
    }

    public boolean equals(BasicMove m){
        return this.aDirection == m.aDirection && this.aDistance == m.aDistance && this.aSpeed == m.aSpeed;
    }

    @Override
    public void execute(Drone d){
        System.out.println("Moveing " + aDirection + " " + aDistance + " meters at " + aSpeed + " speed");
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