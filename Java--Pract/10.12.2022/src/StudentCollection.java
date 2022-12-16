import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentCollection {
    private final ArrayList<Student> students;

    public StudentCollection(ArrayList<Student> students) {
        this.students = students;
    }

    public StudentCollection() {
        students = new ArrayList<>();
    }

    public void add(Student student){
        students.add(student);
    }

    public ArrayList<Student> getListStudents(){ return students; }

    public String[] getStudents() {
        ArrayList<String> res = new ArrayList<>(students.size());
        for(Student student : students){
            res.add(student.toString());
        }
        return res.toArray(new String[0]);
    }

    public void setStudentsFromFile(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while(sc.hasNext())
            students.add(new Student(sc.nextInt(), sc.next(), sc.next(), sc.nextInt()));
    }

    public String[] getAllSubjects(){
        return students.stream().map(Student::getSubject).distinct().sorted(Comparator.naturalOrder()).toArray(String[]::new);
    }

    public String[] getAllSubjectsContainer(){
        ArrayList<String> resultArr = new ArrayList<>();
        for(Student t : students){
            resultArr.add(t.getSubject());
        }
        resultArr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return resultArr.stream().distinct().toArray(String[]::new);
    }

    public void saveToXML(){
        XMLSave.saveToXML(this);
    }

    public String[] getBySAX(){
        return XMLRead.readUsingSAX();
    }

    public String[] getByDOM(){
        return XMLRead.readUsingDOM();
    }
}
