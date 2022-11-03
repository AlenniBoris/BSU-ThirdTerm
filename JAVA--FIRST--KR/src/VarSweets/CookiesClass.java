package VarSweets;

public class CookiesClass extends SweetsClass{
    private final String toping;
    private final int number;

    public CookiesClass(String sweetName, String sweetType, String toping, double sweetWeight, double sweetSugar, int number) {
        super(sweetName, sweetType, sweetWeight, sweetSugar);
        this.toping = toping;
        this.number = number;
    }

    public String getToping() {
        return toping;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String printSweet() {
        return("Name: " + getSweetName() + " " + "Type: " + getSweetType()+ " " + "Toping: " + toping + " "
                + "Weight: " + getSweetWeight() + " " + "Sugar: " + getSweetSugar() + " " + "Number: " + number);
    }
}
