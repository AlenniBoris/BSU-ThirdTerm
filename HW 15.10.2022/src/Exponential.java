public class Exponential extends Series{
    public Exponential(double stepSrs, int elemPos, double first) {
        super(stepSrs, elemPos, first);
    }

    @Override
    public double getElem(double first, double stepSrs, int elemPos) {
        return first*Math.pow(stepSrs, elemPos-1);
    }
}
