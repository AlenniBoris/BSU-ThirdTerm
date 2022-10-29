import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GiftClass {
    private ArrayList<SweetsClass> giftArr;

    public GiftClass(ArrayList<SweetsClass> giftArr) {
        this.giftArr = giftArr;
    }

    public GiftClass(){ giftArr = new ArrayList<>(); };

    public ArrayList<SweetsClass> getGiftArr() {
        return giftArr;
    }

    public double getGiftWeight(){
        double resWeight = 0;
        for (SweetsClass sweet: giftArr) {
            resWeight += sweet.getSweetWeight();
        }
        return resWeight;
    }

    public void addSweet(SweetsClass sweet){
        giftArr.add(sweet);
    }

    public void deleteSweet(int index){
        giftArr.remove(index);
    }

    public String[] printGift(){
        String[] res = new String[giftArr.size()];

        for (int i = 0; i < giftArr.size(); i++) {
            res[i] = giftArr.get(i).printSweet();
        }
        return res;
    }

    public String getBySugar(double firstBound, double secondBound){
        if (giftArr.size() == 0){
            return "Gift is empty";
        }
        for(SweetsClass sweet : giftArr){
            if (sweet.getSweetSugar() <= secondBound && sweet.getSweetSugar() >= firstBound){
                return sweet.printSweet();
            }
        }
        return "No such sweet";
    }

    public void sortByName(){
        if (!(giftArr.size() == 0)){
            for (int i = 0; i < giftArr.size() - 1; ++i) {
                if(giftArr.get(i).getSweetName().compareTo(giftArr.get(i+1).getSweetName()) > 0){
                    Collections.swap(giftArr, i, i+1);
                    i = 0;
                }
            }
            printGift();
        } else{
            System.out.println("Nothing to sort");
        }
    }

    public void sortByType(){
        if (!(giftArr.size() == 0)){
            for (int i = 0; i < giftArr.size() - 1; ++i) {
                if(giftArr.get(i).getSweetType().compareTo(giftArr.get(i+1).getSweetType()) > 0){
                    Collections.swap(giftArr, i, i+1);
                    i = 0;
                }
            }
            printGift();
        } else{
            System.out.println("Nothing to sort");
        }
    }

    public void sortByWeight(){
        if (!(giftArr.size() == 0)){
            for (int i = 0; i < giftArr.size() - 1; ++i) {
                if(giftArr.get(i).getSweetWeight() > giftArr.get(i+1).getSweetWeight()){
                    Collections.swap(giftArr, i, i+1);
                    i = 0;
                }
            }
            printGift();
        } else{
            System.out.println("Nothing to sort");
        }
    }

    public void sortBySugar(){
        if (!(giftArr.size() == 0)){
            for (int i = 0; i < giftArr.size() - 1; ++i) {
                if(giftArr.get(i).getSweetSugar() > giftArr.get(i+1).getSweetSugar()){
                    Collections.swap(giftArr, i, i+1);
                    i = 0;
                }
            }
            printGift();
        } else{
            System.out.println("Nothing to sort");
        }
    }
}
