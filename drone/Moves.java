public class Moves {
//fine for this to be public because even if the client created a move, they can't do anything with it that would touch the drone
    // params
    private MoveType move;  //immutable
    private int distance;   //primitive
    private String fileName;    //immutable
    private FileFormat fileType;    //immutable

    // constructors
    public Moves(MoveType m){
        if(m == MoveType.LAND || m == MoveType.TAKEOFF || m == MoveType.FOCUS || m == MoveType.CAPTURE){
            this.move = m;
        }
        else{
            throw new RuntimeException("Missing necessary parameters for given MoveType");
        }
    }

    public Moves(MoveType m, int dist){
        if( m == MoveType.MOVEUP || m == MoveType.MOVEDOWN || m == MoveType.MOVEFORWARD || m == MoveType.MOVEBACKWARD){
            this.move = m;
            this.distance = dist;
        }
        else{
            throw new RuntimeException("Missing necessary parameters for given MoveType");
        }
    }

    public Moves(MoveType m, String name, FileFormat type){
        if( m == MoveType.SAVE){
            this.move = m;
            this.fileName = name;
            this.fileType = type;
        }
        else{
            throw new RuntimeException("Missing necessary parameters for given MoveType");
        }
    }

    // get methods
    public MoveType getMove(){
        return this.move;
    }

    public int getDistance(){
        return this.distance;
    }

    public String getFileName(){
        return this.fileName;
    }

    public FileFormat getFileType(){
        return this.fileType;
    }
}

