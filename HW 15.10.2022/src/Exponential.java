public class Exponential extends Series{


    public Exponential(double _first, double _stepSrs, int _elemPos) {
        super(_first, _stepSrs, _elemPos);
    }

    @Override
    public double getElem(double first, double stepSrs, int elemPos) {
        return first*Math.pow(stepSrs, elemPos-1);
    }
}
