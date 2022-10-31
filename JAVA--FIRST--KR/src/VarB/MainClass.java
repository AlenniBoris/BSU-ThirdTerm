package VarB;

import VarB.GiftFrame;

public class MainClass {
    public static void main(String[] args) {
//        VarB.SweetsClass sw1 = new VarB.SweetsClass("d", "Candy", 15.2,0.8);
//        VarB.SweetsClass sw2 = new VarB.SweetsClass("a", "Cracker", 10,18.4);
//        VarB.SweetsClass sw3 = new VarB.SweetsClass("b", "Ice-cream", 250,50);
//        VarB.SweetsClass sw4 = new VarB.SweetsClass("c", "Candy", 2,0.2);
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

        GiftFrame fr = new GiftFrame();
        fr.setSize(500,500);
        fr.setVisible(true);
    }
}
