package Lab11.task2.Student;

import Lab11.task2.Strategy.Strategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

    public String[] getStudents() {
        ArrayList<String> res = new ArrayList<>(students.size());
        for(Student student : students){
            res.add(student.toString());
        }
        return res.toArray(new String[0]);
    }

    public ArrayList<Student> getList(){ return students; }

    public void setStudentsFromFile(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while(sc.hasNext())
            students.add(new Student(sc.nextInt(), sc.next(), sc.next(), sc.nextInt()));
    }

    public String[] getResultFromStrategy(Strategy strategy){
        return strategy.getResult();
    }
}
