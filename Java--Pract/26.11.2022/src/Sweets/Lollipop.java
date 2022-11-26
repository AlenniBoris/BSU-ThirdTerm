package Sweets;

public class Lollipop extends Sweet{
    private final String stickType;

    public Lollipop(String sweetName, String sweetType, double sweetWeight, double sweetSugar, String stickType) {
        super(sweetName, sweetType, sweetWeight, sweetSugar);
        this.stickType = stickType;
    }

    public String getStickType() {
        return stickType;
    }

    @Override
    public String toString() {
        return "Name: " + getSweetName() + " Type: " + getSweetType() + " Weight: " + getSweetWeight() +
                " Sugar: " + getSweetSugar() + " Stick: " + stickType;
    }
}
