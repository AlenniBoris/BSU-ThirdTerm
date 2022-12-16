public class Student {
    private final int gradebook;
    private final String surname;
    private final String subject;
    private final int grade;

    public Student(int gradebook, String surname, String subject, int grade) {
        this.gradebook = gradebook;
        this.surname = surname;
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gradebook=" + gradebook +
                ", surname='" + surname + '\'' +
                ", subject='" + subject + '\'' +
                ", grade=" + grade +
                '}';
    }

    public int getGradebook() {
        return gradebook;
    }

    public String getSurname() {
        return surname;
    }

    public int getGrade() {
        return grade;
    }
}
