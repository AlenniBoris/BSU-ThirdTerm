package VarA.University;

public class Postgraduate extends Student {
    Academic tutor;

    public Postgraduate(String name, String login, String email) {
        super(name, login, email);
    }

    public Academic getTutor() {
        return tutor;
    }

    public void setTutor(Academic tutor) {
        this.tutor = tutor;
    }
}
