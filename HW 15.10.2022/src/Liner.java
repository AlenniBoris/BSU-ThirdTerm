public class Liner extends Series{


    public Liner(double _first, double _stepSrs, int _elemPos) {
        super(_first, _stepSrs, _elemPos);
    }

    @Override
    public double getElem(double first, double stepSrs, int elemPos) {
        return first + (elemPos - 1) * stepSrs;
    }
}
