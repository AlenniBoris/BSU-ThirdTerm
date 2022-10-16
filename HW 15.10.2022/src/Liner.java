public class Liner extends Series{
    public Liner(double first, double stepSrs, int elemPos) {
        super(first, stepSrs, elemPos);
    }

    @Override
    public double getElem(double first, double stepSrs, int elemPos) {
        return first + (elemPos - 1) * stepSrs;
    }
}
