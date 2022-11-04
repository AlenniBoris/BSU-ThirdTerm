package KP_Test_Var;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FillClass {
    public static ArrayList<Student> getStudentsFromFile(File file) throws IOException {
        Scanner sc = new Scanner(file);
        ArrayList<Student> students = new ArrayList<>();
        while(sc.hasNext()){
            students.add(new Student(sc.next(), Integer.parseInt(sc.next()), Double.parseDouble(sc.next())));
        }
        return students;
    }

    public static ArrayList<Float> getFloatsFromFile(File file) throws IOException {
        Scanner sc = new Scanner(file);
        ArrayList<Float> numbers = new ArrayList<>();
        while(sc.hasNext()){
            numbers.add(Float.parseFloat(sc.next()));
        }
        return numbers;
    }
}
