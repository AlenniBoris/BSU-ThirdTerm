package Sweets;

public class Cookie extends Sweet{
    private final String topingType;

    public Cookie(String sweetName, String sweetType, double sweetWeight, double sweetSugar, String topingType) {
        super(sweetName, sweetType, sweetWeight, sweetSugar);
        this.topingType = topingType;
    }

    public String getTopingType() {
        return topingType;
    }

    @Override
    public String toString() {
        return "Name: " + getSweetName() + " Type: " + getSweetType() + " Weight: " + getSweetWeight() +
                " Sugar: " + getSweetSugar() + " Toping: " + topingType;
    }

}
