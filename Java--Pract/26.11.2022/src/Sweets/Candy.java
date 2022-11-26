package Sweets;

public class Candy extends Sweet{
    private final String wrapType;

    public Candy(String sweetName, String sweetType, double sweetWeight, double sweetSugar, String wrapType) {
        super(sweetName, sweetType, sweetWeight, sweetSugar);
        this.wrapType = wrapType;
    }

    public String getWrapType() {
        return wrapType;
    }

    @Override
    public String toString() {
        return "Name: " + getSweetName() + " Type: " + getSweetType() + " Weight: " + getSweetWeight() +
                " Sugar: " + getSweetSugar() + " Wrap: " + wrapType;
    }
}
