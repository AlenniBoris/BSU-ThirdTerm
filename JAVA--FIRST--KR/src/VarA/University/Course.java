package VarA.University;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class Course{
    private Set<Student> students;
    private String name;

    public Course(String name, Set<Student> students) {
        this.students = students;
        this.name = name;
    }

    public Course(String name){
        this.name = name;
        students = new HashSet<>();
    }

    public void showCourse(){
        for(var student : students){
            System.out.println(student.getName() + " " + student.getLogin() + " " + student.getEmail());
        }
    }

    public Set<Student> getPostgraduates(String NameOfSupervisor){
        Set<Student> resArr = new HashSet<>();
        for (var student : students){
            if (student instanceof Postgraduate){
                if (((Postgraduate) student).getTutor().getName().equals(NameOfSupervisor)){
                    resArr.add(student);
                }
            }
        }
        return resArr;
    }

    public Set<Student> getArrayForPredicate(Predicate predicate){
        Set<Student> resArr = new HashSet<>();
        for (var student : students){
            if (predicate.test(student)){
                resArr.add(student);
            }
        }
        return resArr;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    @Override
    public String toString(){
        return name + "\nstudents: "  + students.toString();
    }


}
