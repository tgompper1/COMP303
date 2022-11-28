import java.util.List;

public class runDrone {

    /**
     * Prints out a given move sequence
     */
    public static void printMoveSequence(List<Moves> moves){
        for(int i = 0; i < moves.size(); i++) {
            System.out.print(moves.get(i).getMove() + ", ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        RemoteControl myRemote = new RemoteControl();
        /**
         * Test 1: no errors, perfect example of a move sequence, all parameter and prereq expectations are met
         */
        myRemote.setMove(MoveType.TAKEOFF); // take-off
        myRemote.setMove(MoveType.MOVEUP, 5); // move up some distance
        myRemote.setMove(MoveType.MOVEFORWARD, 7); // move forward some distance
        myRemote.setMove(MoveType.MOVEDOWN, 2); // move down some distance
        myRemote.setMove(MoveType.FOCUS); // focus on an object
        myRemote.setMove(MoveType.CAPTURE); // capture a picture if an object is in focus
        myRemote.setMove(MoveType.SAVE, "pic", FileFormat.JPG); // save the picture with a file name and file format provided by client
        myRemote.setMove(MoveType.MOVEBACKWARD, 6); // move backwards some distance
        myRemote.setMove(MoveType.LAND);
        System.out.println("******************** Test 1: testing perfect moveSequence, no errors expected ********************");
        List<Moves> currMoves = myRemote.getMoveSequence();
        runDrone.printMoveSequence(currMoves);
        myRemote.execute();

        /**
         * Test 2: testing camera capabilities
         *  first captures a photo with no error, then error, fails to capture a photo because the drone moved after focusing- thus unfocusing
         *  then error, fails to save photo because you must save a photo immediately after its taken
         */
        myRemote.deleteMove(9);
        myRemote.setMove(MoveType.FOCUS);
        myRemote.setMove(MoveType.MOVEFORWARD,1);
        myRemote.setMove(MoveType.CAPTURE); // Fails to capture because the drone moved after focusing, and object is no longer in focus
        myRemote.setMove(MoveType.FOCUS);
        myRemote.setMove(MoveType.CAPTURE);
        myRemote.setMove(MoveType.MOVEUP, 3);
        myRemote.setMove(MoveType.SAVE, "pic2", FileFormat.PNG); // fails to save because you must save immediately after capturing
        myRemote.setMove(MoveType.LAND); // Land
        System.out.println("******************** Test 2: testing camera capabilities, 2 errors expected ********************");
        currMoves = myRemote.getMoveSequence();
        runDrone.printMoveSequence(currMoves);
        myRemote.execute();

        /**
         * test 3: demonstrates delete functionality, error because the sequence does not start with take-off
         */
        System.out.println("*********** Test 3: testing delete functionality and sequence does not start with take-off, 1 error expected *****************");
        System.out.print("Before: ");
        currMoves = myRemote.getMoveSequence();
        runDrone.printMoveSequence(currMoves);
        myRemote.deleteMove(1); // remove take-off
        myRemote.deleteMove(9);
        myRemote.deleteMove(12);
        System.out.print("After: ");
        currMoves = myRemote.getMoveSequence();
        runDrone.printMoveSequence(currMoves);
        myRemote.execute(); // fails to execute because sequence does not begin with take-off

        /**
         *  Test 4: demonstrates edit move functionality, no errors expected
         */
        System.out.println("************** Test 4: testing edit move functionality, no errors expected");
        System.out.print("Before: ");
        currMoves = myRemote.getMoveSequence();
        runDrone.printMoveSequence(currMoves);
        myRemote.editMove(1, MoveType.TAKEOFF); //change move 1 to takeoff
        System.out.print("After: ");
        currMoves = myRemote.getMoveSequence();
        runDrone.printMoveSequence(currMoves);
        myRemote.execute();

        /**
         * Test 5: demonstrates addMove functionality, 1 error due to 2 take-offs with no landing in between
         */
        System.out.println("*************** Test 5: testing addMove functionality, 1 error expected due to a take-off when already in the air");
        System.out.print("Before: ");
        currMoves = myRemote.getMoveSequence();
        runDrone.printMoveSequence(currMoves);
        myRemote.addMove(3, MoveType.TAKEOFF); // add a second take-off which will give an error because drone is already in flight, drone continues anyway
        System.out.print("After: ");
        currMoves = myRemote.getMoveSequence();
        runDrone.printMoveSequence(currMoves);
        myRemote.execute();

        myRemote.deleteMove(3); // delete extra take-off

        /**
         * Test 6: 1 error due to 2 landings with no take-off in between
         */
        System.out.println("************* Test 6: 1 error expected due to a land when already on the ground ***********");
        myRemote.addMove(4, MoveType.LAND); // add a Land in the middle, which will cause errors on all moves that are not takeoff or camera related
        currMoves = myRemote.getMoveSequence();
        runDrone.printMoveSequence(currMoves);
        myRemote.execute();

        /**
         * Test 7: fails to execute due to sequence not ending with a landing
         */
        System.out.println("************** Test 7: fails to execute due to sequence not ending with a landing *************************");
        myRemote.deleteMove(14); // remove final landing
        currMoves = myRemote.getMoveSequence();
        runDrone.printMoveSequence(currMoves);
        myRemote.execute(); // fails to execute because sequence does not end with a landing
    }
}
