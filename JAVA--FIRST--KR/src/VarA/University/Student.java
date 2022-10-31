package VarA.University;

import VarA.Notify.Notifiable;
import VarA.University.Person;

public class Student extends Person implements Notifiable {
    private String login;
    private String email;

    public Student(String name, String login, String email) {
        super(name);
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void notify(String message) {

    }

    @Override
    public String toString() {
        return "(Name: " + getName() + ", Login: " + login + ", Email: " + email + ")";
    }
}
