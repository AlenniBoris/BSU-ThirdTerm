package VarSweets;

public abstract class SweetsClass {
    private final String sweetName;
    private final String sweetType;
    private final double sweetWeight;
    private final double sweetSugar;

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

    public abstract String printSweet();
}
