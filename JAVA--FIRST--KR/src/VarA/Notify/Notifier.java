package VarA.Notify;

import VarA.University.Student;

import java.util.Set;

public class Notifier implements Notifiable{
    private Set<Student> notifiables;

    public Notifier(Set<Student> notifiables) {
        this.notifiables = notifiables;
    }

    public void doNotifyAll(String message){
        for(Student student: notifiables){
            student.notify(message);
        }
    }

    @Override
    public void notify(String message){

    }
}
