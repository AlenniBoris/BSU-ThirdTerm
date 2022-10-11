public class Liner extends Series{
    public Liner(double stepSrs, int elemPos, double first) {
        super(stepSrs, elemPos, first);
    }

    @Override
    public double getElem(double first, double stepSrs, int elemPos) {
        return first + (elemPos - 1) * stepSrs;
    }
}
