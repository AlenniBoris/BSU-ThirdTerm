package KP_Test_Var;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MyCollection{
    private ArrayList<Student> students;

    public MyCollection(ArrayList<Student> students) {
        this.students = students;
    }

    public MyCollection() {
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void fillFromFile(File file) throws IOException{
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            students.add(new Student(sc.next(), Integer.parseInt(sc.next()), Double.parseDouble(sc.next())));
        }
    }

    public void saveTofile(File file, ArrayList<Student> studentArrayList) throws IOException{
        FileWriter fw = new FileWriter(file);
        for(Student student : studentArrayList){
            fw.write(student.printStudent() + "\n");
        }
        fw.close();
    }

    public void addComponent(Student student){
        students.add(student);
    }

    public void deleteStudent(int posInList){
        students.remove(posInList);
    }

    public void Sort(){
        for (int i = 0; i < students.size() - 1; ++i) {
            if(students.get(i).getAverage() > students.get(i+1).getAverage()){
                Collections.swap(students, i, i+1);
                i = 0;
            }
        }
    }

    public ArrayList<Student> getStudentWithMin() throws IllegalArgumentException{
        Sort();
        Student resStudent = students.get(0);
        ArrayList<Student> resArr = new ArrayList<>();
        resArr.add(resStudent);
        return resArr;
    }

    public ArrayList<Student> getStudentWithMax() throws IllegalArgumentException{
        Sort();
        Student resStudent = students.get(students.size() - 1);
        ArrayList<Student> resArr = new ArrayList<>();
        resArr.add(resStudent);
        return resArr;
    }

    public String[] printAll(){
        String[] res = new String[students.size()];
        for (int i = 0; i < students.size(); i++) {
            res[i] = students.get(i).printStudent();
        }
        return res;
    }
}
