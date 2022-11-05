import java.util.ArrayList;

public abstract class Employee implements Comparable<Employee>{
    private String surname;
    private String organization;
    private double workCoefficient;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public double getWorkCoefficient() {
        return workCoefficient;
    }

    public void setWorkCoefficient(double workCoefficient) {
        this.workCoefficient = workCoefficient;
    }

    public Employee(String surname, String organization, double workCoefficient) {
        this.surname = surname;
        this.organization = organization;
        this.workCoefficient = workCoefficient;
    }

    public abstract double getSalary();

    @Override
    public int compareTo(Employee o) {
        return (int) (this.getSalary() - o.getSalary());
    }

    @Override
    public abstract String toString();

}
