package VarB;

public class SweetsClass {
    private String sweetName;
    private String sweetType;
    private double sweetWeight;
    private double sweetSugar;

    public SweetsClass(String sweetName, String sweetType, double sweetWeight, double sweetSugar) {
        this.sweetName = sweetName;
        this.sweetType = sweetType;
        this.sweetWeight = sweetWeight;
        this.sweetSugar = sweetSugar;
    }

    public String getSweetName() {
        return sweetName;
    }

    public String getSweetType() {
        return sweetType;
    }

    public double getSweetWeight() {
        return sweetWeight;
    }

    public double getSweetSugar() {
        return sweetSugar;
    }

    public String printSweet(){
        return("Name: " + sweetName + " " + "Type: " + sweetType+ " " +
                "Weight: " + sweetWeight + " " + "Sugar: " + sweetSugar);
    }
}
