package Sweets;

public abstract class Sweet {
    private String sweetName;
    private String sweetType;
    private double sweetWeight;
    private double sweetSugar;

    public Sweet(String sweetName, String sweetType, double sweetWeight, double sweetSugar) {
        this.sweetName = sweetName;
        this.sweetType = sweetType;
        this.sweetWeight = sweetWeight;
        this.sweetSugar = sweetSugar;
    }

    public void setSweetName(String sweetName) {
        this.sweetName = sweetName;
    }

    public void setSweetType(String sweetType) {
        this.sweetType = sweetType;
    }

    public void setSweetWeight(double sweetWeight) {
        this.sweetWeight = sweetWeight;
    }

    public void setSweetSugar(double sweetSugar){
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


    public abstract String toString();
}
