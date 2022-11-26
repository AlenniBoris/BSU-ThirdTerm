import Gift.*;
import Interface.*;
import Strategy.*;
import Sweets.*;

public class StartClass {
    public static void main(String[] args) {
        Gift gift = new Gift();

        Lollipop lollipop1 = new Lollipop("lollipop1", "lollipop", 18, 0, "wooden");
        Lollipop lollipop2 = new Lollipop("lollipop2", "lollipop", 8, 12, "plastic");
        Cookie cookie1 = new Cookie("cookie1", "cookie", 8, 2, "chocolate");
        Cookie cookie2 = new Cookie("cookie2", "cookie", 15, 0, "vanilla");
        Candy candy1 = new Candy("candy1", "candy", 47, 197, "paper");
        Cookie candy2 = new Cookie("candy2", "candy", 31, 1, "plastic");

        gift.add(lollipop1);
        gift.add(lollipop2);
        gift.add(cookie1);
        gift.add(cookie2);
        gift.add(candy1);
        gift.add(candy2);

        Iterator iter = gift.getIterator();
        while(iter.isDone()){
            System.out.println(iter.Next());
        }
        System.out.println();
        System.out.println(iter.First());

        System.out.println();

        System.out.println("Sugar before " + gift.getGiftSugar());
        gift.scaleParameter(new LowSugarStrategy(gift), 2);
        System.out.println("Sugar after " + gift.getGiftSugar());

        System.out.println("Weight before " + gift.getGiftWeight());
        gift.scaleParameter(new LowWeightStrategy(gift), 4);
        System.out.println("Weight after " + gift.getGiftWeight());

        System.out.println();

        iter.renewIterator();
        while(iter.isDone()){
            System.out.println(iter.Next());
        }

        System.out.println();

        System.out.println("Gift before: ");

        iter.renewIterator();
        while(iter.isDone()){
            System.out.println(iter.Next());
        }

        gift.reduceParameter(new LowWeightStrategy(gift), "cookie");

        System.out.println("Gift after: ");
        iter.renewIterator();
        while(iter.isDone()){
            System.out.println(iter.Next());
        }
    }
}
