package KP_Test_Var;

public class Student {
    private String name;
    private int course;
    private double average;

    public Student(String name, int course, double average) {
        this.name = name;
        this.course = course;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public double getAverage() {
        return average;
    }

    public String printStudent(){
        return ("Name: " + name + " Course: " + course + " Average: " + average);
    }
}
