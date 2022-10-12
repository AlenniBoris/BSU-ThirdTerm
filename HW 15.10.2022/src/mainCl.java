public class mainCl {
    public static void main(String[] args) {
        Liner a = new Liner(0,2,5);
        a.writeSeriesToFile("output");
        Exponential b = new Exponential(1.7,4,3);
        b.writeSeriesToFile("output1");
    }
}
