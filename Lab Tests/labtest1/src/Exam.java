import java.util.Comparator;

public class Exam implements Comparable<Exam> {
    final private String aCourseNumber; // immutable string
    final private int aLength; //primitive
    final private ExamType aExamType; //immutable enum

    public Exam(String pCourseNumber, int pLength, ExamType pExamType){
        aCourseNumber = pCourseNumber;
        aLength = pLength;
        aExamType = pExamType;
    }

    public String getCourseNumber(){
        return aCourseNumber;
    }

    public int getLength() {
        return aLength;
    }

    public ExamType getExamType() {
        return aExamType;
    }

    public String toString(){
        return this.aCourseNumber + " - " + this.aLength + " mins - " + this.aExamType;
    }

    @Override
    public int compareTo(Exam e){
        if(this.getLength() > e.getLength()){
            return 1;
        }
        else if(this.getLength() < e.getLength()){
            return -1;
        }
        else{
            return 0;
        }
    }


}
