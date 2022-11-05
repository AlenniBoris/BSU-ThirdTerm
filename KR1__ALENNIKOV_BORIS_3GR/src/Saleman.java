public class Saleman extends Employee{
    private double profit;
    private final double PROCENT;

    public Saleman(String surname, String organization, double workCoefficient, double profit, double procent) {
        super(surname, organization, workCoefficient);
        this.profit = profit;
        this.PROCENT = procent;
    }

    @Override
    public double getSalary() {
        return (int)(PROCENT*profit*getWorkCoefficient());
    }

    @Override
    public String toString() {
        return "Surname =" + getSurname() + " Business = " + getOrganization() + " Coefficient = " + getWorkCoefficient() +
                " Profit = " + profit + " Procent = " + PROCENT + "\n";
    }

}
