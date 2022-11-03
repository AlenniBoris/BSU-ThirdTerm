package VarSweets;

public class LollipopClass extends SweetsClass{
    private final String wrapColor;

    public LollipopClass(String sweetName, String sweetType, String wrapColor, double sweetWeight, double sweetSugar) {
        super(sweetName, sweetType, sweetWeight, sweetSugar);
        this.wrapColor = wrapColor;
    }

    public String getWrapColor() {
        return wrapColor;
    }

    @Override
    public String printSweet() {
        return("Name: " + getSweetName() + " " + "Type: " + getSweetType()+ " " + "Wrap color: " + wrapColor + " "
                + "Weight: " + getSweetWeight() + " " + "Sugar: " + getSweetSugar());
    }
}
