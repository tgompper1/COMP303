public class Client {
    public static void main(String[] args){
        Exam e1 = new Exam("COMP303", 90, ExamType.TAKEHOME);
        Exam e2 = new Exam("COMP251", 120, ExamType.INPERSON);
        Exam e3 = new Exam("COMP273", 30, ExamType.ONLINE);

        Department cs = new Department("CompSci");
        cs.addExam(e1);
        cs.addExam(e2);
        cs.addExam(e3);

        System.out.println("Unsorted:");
        cs.printExams();

        cs.sort();

        System.out.println("Sorted:");
        cs.printExams();
    }
}
