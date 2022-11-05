public class Security extends Employee{
    private double securedSquare;
    private final double BASE;

    public Security(String surname, String organization, double workCoefficient, double securedSquare, double base) {
        super(surname, organization, workCoefficient);
        this.securedSquare = securedSquare;
        BASE = base;
    }

    @Override
    public double getSalary() {
        return (int)(BASE*getWorkCoefficient()*securedSquare);
    }

    @Override
    public String toString() {
        return "Surname =" + getSurname() + " Business = " + getOrganization() + " Coefficient = " + getWorkCoefficient() +
                " Sequeredd square = " + securedSquare + " Base = " + BASE + "\n";
    }


}
