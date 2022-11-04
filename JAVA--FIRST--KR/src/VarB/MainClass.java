package VarB;

import VarB.GiftFrame;
import VarSweets.CookiesClass;
import VarSweets.LollipopClass;

import java.io.File;
import java.io.IOException;
import java.util.function.Predicate;

public class MainClass {
    public static void main(String[] args) throws IOException {
//        VarSweets.SweetsClass sw1 = new VarSweets.SweetsClass("d", "Candy", 15.2,0.8);
//        VarSweets.SweetsClass sw2 = new VarSweets.SweetsClass("a", "Cracker", 10,18.4);
//        VarSweets.SweetsClass sw3 = new VarSweets.SweetsClass("b", "Ice-cream", 250,50);
//        VarSweets.SweetsClass sw4 = new VarSweets.SweetsClass("c", "Candy", 2,0.2);
//
//        VarB.GiftClass gift = new VarB.GiftClass();
//
//        gift.addSweet(sw1);
//        gift.addSweet(sw2);
//        gift.addSweet(sw3);
//        gift.addSweet(sw4);
//
//        System.out.println(gift.getGiftWeight());
//        gift.printGift();
//        System.out.println();
//        gift.sortByName();
//        System.out.println();
//        gift.sortByType();
//        System.out.println();
//        gift.sortByWeight();
//        System.out.println();
//        gift.sortBySugar();
//
//        gift.deleteSweet(sw1);
//        System.out.println();
//        gift.printGift();

        CookiesClass cookiesClass1 = new CookiesClass("jhvbshjvb","dsc","kmsdcksm",45,66,4);
        CookiesClass cookiesClass2 = new CookiesClass("fdb","zdfbzfdb","wqdq",32,4,1);
        LollipopClass lollipopClass1 = new LollipopClass("jhvbshjvb","dsc","kmsdcksm",45,6);
        LollipopClass lollipopClass2 = new LollipopClass("fdb","zdfbzfdb","wqdq",32,4);

        GiftClass gift = new GiftClass();

        gift.addSweet(cookiesClass1);
        gift.addSweet(cookiesClass2);
        gift.addSweet(lollipopClass1);
        gift.addSweet(lollipopClass2);

        for(String str : gift.printGift()){
            System.out.println(str);
        }

        gift.saveArrToFile(new File("cookies_out"));
        gift.getCookiesFromFile(new File("cookies"));
        gift.saveArrToFile(new File("cookies_out"));


        System.out.println('\n' + gift.getBySugar(4, 40));

        GiftFrame fr = new GiftFrame();
        fr.setSize(500,500);
        fr.setVisible(true);
    }
}
