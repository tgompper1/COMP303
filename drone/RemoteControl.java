
import java.util.ArrayList;
import java.util.List;

public class RemoteControl {

    private class Drone {

        // variables
        private boolean inAir = false;
        private boolean objectInFocus = false;
        private boolean pictureReadyToSave = false;

        private void takeOff(){
            if(!inAir) {
                System.out.println("Drone taking off...");
                inAir = true;
            }
            else{
                System.out.println("Error: Cannot take off, drone is already in flight");
            }
            pictureReadyToSave = false;
            objectInFocus = false;
        }

        private void land(){
            if(inAir) {
                System.out.println("Drone landing...");
                inAir = false;
            }
            else{
                System.out.println("Error: Cannot land, drone is not in flight");
            }
            pictureReadyToSave = false;
            objectInFocus = false;
        }

        private void moveForward(int dist){
            if(inAir){
                System.out.println("Drone moving forward " + dist + " meters...");
            }
            else{
                System.out.println("Error: Cannot move, drone is not in flight");
            }
            pictureReadyToSave = false;
            objectInFocus = false;
        }

        private void moveBackward(int dist) {
            if(inAir) {
                System.out.println("Drone moving backwards " + dist + " meters...");
            }
            else{
                System.out.println("Error: Cannot move, drone is not in flight");
            }
            pictureReadyToSave = false;
            objectInFocus = false;
        }

        private void moveUp(int dist) {
            if(inAir) {
                System.out.println("Drone moving up " + dist + " meters...");
            }
            else{
                System.out.println("Error: Cannot move, drone is not in flight");
            }
            pictureReadyToSave = false;
            objectInFocus = false;
        }

        private void moveDown(int dist){
            if(inAir){
                System.out.println("Drone moving down " + dist + " meters...");
            }
            else{
                System.out.println("Error: Cannot move, drone is not in flight");
            }
            pictureReadyToSave = false;
            objectInFocus = false;
        }

        private void focus(){
            objectInFocus = true;
            System.out.println("Drone focusing on object...Success...Drone ready for picture");
            pictureReadyToSave = false;
        }

        /**
         * Capture photo only when object is in focus
         */
        private void capturePicture(){
            if(objectInFocus){
                System.out.println("Drone taking picture...");
                objectInFocus = false;
                pictureReadyToSave = true;
            }
            else {
                System.out.println("Error: Object not in focus, drone cannot take picture. Drones lose focus with movement");
            }
        }

        /**
         * save the most recent picture taken with given FileFormat and file name
         * A picture cannot be saved if one hasn't been taken
         * A picture can only be saved immediately it was taken
         */
        private void savePictureFile(FileFormat type, String name){
            // can't save a picture if there isn't one
            // can only save a picture right after it was taken
            if(pictureReadyToSave) {
                System.out.println(name + "." + type + " saved");
            }
            else{
                System.out.println("Error: No picture to save, pictures must be saved immediately after being taken");
            }
        }
    }

    final private Drone myDrone = new Drone();
    final private List<Moves> myMoves = new ArrayList<>();
    private int numMoves = 0;

    /**
     * Set a single move that requires no parameters
     */
    public void setMove(MoveType move){
           Moves temp = new Moves(move);
           myMoves.add(temp);
           numMoves++;
    }

    /**
     * set a single move that requires a distance
     */
    public void setMove(MoveType move, int dist){
            Moves temp = new Moves(move, dist);
            myMoves.add(temp);
            numMoves++;
    }

    /**
     * Set a single move that requires a file name and format
     */
    public void setMove(MoveType move, String fileName, FileFormat type){
            Moves temp = new Moves(move, fileName, type);
            myMoves.add(temp);
            numMoves++;
    }

    /**
     * Edit a single move given position in move sequence, new MoveType, new fileName and new FileFormat
     */
    public void editMove(int pos, MoveType move, String fileName, FileFormat type ){
            Moves temp = new Moves(move, fileName, type);
            myMoves.remove(pos - 1);
            myMoves.add(pos - 1, temp);
    }

    /**
     * Edit a single move given position in move sequence, new MoveType, new distance
     */
    public void editMove(int pos, MoveType move, int dist){
        Moves temp = new Moves(move, dist);
        myMoves.remove(pos - 1);
            myMoves.add(pos - 1, temp);
    }

    /**
     * Edit a single move given postion in move sequence, new MoveType
     */
    public void editMove(int pos, MoveType move){
            Moves temp = new Moves(move);
            myMoves.remove(pos - 1);
            myMoves.add(pos - 1, temp);
    }

    /**
     * add a single move given position in move sequence, new MoveType, new fileName and new FileFormat
     */
    public void addMove(int pos, MoveType move, String fileName, FileFormat type ){
            Moves temp = new Moves(move, fileName, type);
            myMoves.add(pos - 1, temp);
            numMoves++;
    }

    /**
     * add a single move given position in move sequence, new MoveType, new distance
     */
    public void addMove(int pos, MoveType move, int dist){
            Moves temp = new Moves(move, dist);
            myMoves.add(pos - 1, temp);
            numMoves++;
    }

    /**
     * add a single move given position in move sequence, new MoveType
     */
    public void addMove(int pos, MoveType move){
            Moves temp = new Moves(move);
            myMoves.add(pos - 1, temp);
            numMoves++;
    }

    /**
     * delete a specific move given position in sequence
     */
    public void deleteMove(int pos){
        myMoves.remove(pos-1);
        numMoves--;
    }

    /**
     * @return Move in given position
     * only used by getMoveSequence
     */
    private Moves getMove(int pos){
        return myMoves.get(pos);
    }

    /**
     * @return Copy of sequence of moves
     * only method that allows client access to moveSequence
     */
    public List<Moves> getMoveSequence(){
        // access but not modify, thus a copy
        List<Moves> movesCopy = new ArrayList<Moves>(myMoves);
        return movesCopy;
    }

    /**
     * execute move sequence
     */
    public void execute(){
        System.out.println(".................... Starting Sequence ....................");
        if(myMoves.get(0).getMove() != MoveType.TAKEOFF){
            System.out.println("Error: sequence must begin with take-off");
        }
        else if( myMoves.get(numMoves-1).getMove() != MoveType.LAND){
            System.out.println("Error: sequence must end with landing");
        }
        else{
            for(int i = 0; i < numMoves; i++){
                Moves curr = getMove(i);
                MoveType currType = curr.getMove();
                switch (currType) {
                    case TAKEOFF:
                        myDrone.takeOff();
                        break;
                    case LAND:
                        myDrone.land();
                        break;
                    case MOVEUP:
                        myDrone.moveUp(curr.getDistance());
                        break;
                    case MOVEDOWN:
                        myDrone.moveDown(curr.getDistance());
                        break;
                    case MOVEFORWARD:
                        myDrone.moveForward(curr.getDistance());
                        break;
                    case MOVEBACKWARD:
                        myDrone.moveBackward(curr.getDistance());
                        break;
                    case FOCUS:
                        myDrone.focus();
                        break;
                    case CAPTURE:
                        myDrone.capturePicture();
                        break;
                    case SAVE:
                        myDrone.savePictureFile(curr.getFileType(), curr.getFileName());
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }
        System.out.println(".................... End of Sequence ....................");
    }
}
