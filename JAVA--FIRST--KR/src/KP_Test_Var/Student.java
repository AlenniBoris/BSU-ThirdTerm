package KP_Test_Var;

public class Student implements Comparable<Student>{
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

    @Override
    public String toString(){
        return ("Name: " + name + " Course: " + course + " Average: " + average);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public int compareTo(Student o) {
        return (int)(this.getAverage() - o.getAverage());
    }
}