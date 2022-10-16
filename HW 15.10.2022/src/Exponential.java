public class Exponential extends Series{
    public Exponential(double first, double stepSrs, int elemPos) {
        super(first, stepSrs, elemPos);
    }

    @Override
    public double getElem(double first, double stepSrs, int elemPos) {
        return first*Math.pow(stepSrs, elemPos-1);
    }
}
