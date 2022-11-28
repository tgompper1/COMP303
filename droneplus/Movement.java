public interface Movement {
    /**
     * Execute a drone movement
     */
    void execute(Drone d);

    Direction getDirection();

    Speed getSpeed();

    double getDistance();

    boolean isRecorded();
}
