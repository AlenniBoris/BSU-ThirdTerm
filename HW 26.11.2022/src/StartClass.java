import javax.swing.text.html.HTMLEditorKit;

public class StartClass {
    public static void main(String[] args) {
        Multitude<Integer> multitude = new Multitude<>();
        multitude.add(1);
        multitude.add(2);
        multitude.add(3);
        multitude.add(4);
        multitude.add(5);
        Iterator iterator = multitude.getIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println();

        Multitude<Integer> second = new Multitude<>();
        second.add(5);
        second.add(7);
        second.add(8);
        second.add(9);
        second.add(10);


        Iterator iter = second.getIterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println(multitude.isEmpty());
        System.out.println(multitude.equals(second));
        System.out.println(multitude.isEmpty());

        multitude.addAll(second);
        System.out.println(multitude.toString());

        System.out.println(multitude.unitMultitude(second));
        System.out.println(multitude.interceptionMultitude(second));
        System.out.println(multitude.diffMultitude(second));

        multitude.clear();
        System.out.println(multitude.isEmpty());

        AppGui appGui = new AppGui();
    }
}
