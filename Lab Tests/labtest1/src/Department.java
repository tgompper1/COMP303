import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department{
    private String aName;
    final private List<Exam> aExams = new ArrayList<Exam>();

    public Department(String pName){
        aName = pName;
    }

    public void addExam(Exam e){
        assert e != null;
        aExams.add(e);
    }

    public void printExams(){
        for(Exam e : aExams){
            System.out.println(e.toString()); //(e.getCourseNumber() + " - " + e.getLength() + " mins - " + e.getExamType());
        }
    }

    public void sort(){
        Collections.sort(aExams);
    }
}
