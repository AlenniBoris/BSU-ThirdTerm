package VarB;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GiftClass {
    private final ArrayList<SweetsClass> giftArr;

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

    public void saveToFile(File fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        for(SweetsClass sweet : giftArr){
            fw.write(sweet.printSweet() + "\n");
        }
        fw.close();
    }

    public void getFromFile(File fileName) throws IOException{
        Scanner sc = new Scanner(fileName);
        while(sc.hasNext()){
            giftArr.add(new SweetsClass(sc.next(), sc.next(), Double.parseDouble(sc.next()), Double.parseDouble(sc.next())));
        }
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
        giftArr.sort(new Comparator<SweetsClass>() {
            @Override
            public int compare(SweetsClass o1, SweetsClass o2) {
                return o1.getSweetName().compareTo(o2.getSweetName());
            }
        });
    }

    public void sortByType(){
        giftArr.sort(new Comparator<SweetsClass>() {
            @Override
            public int compare(SweetsClass o1, SweetsClass o2) {
                return o1.getSweetType().compareTo(o2.getSweetType());
            }
        });
    }

    public void sortByWeight(){
        giftArr.sort(new Comparator<SweetsClass>() {
            @Override
            public int compare(SweetsClass o1, SweetsClass o2) {
                return Double.compare(o2.getSweetWeight(), o1.getSweetWeight());
            }
        });
    }

    public void sortBySugar(){
//        for (int i = 0; i < giftArr.size() - 1; ++i) {
//            if(giftArr.get(i).getSweetSugar() < giftArr.get(i+1).getSweetSugar()){
//                Collections.swap(giftArr, i, i+1);
//                i = 0;
//            }
//        }
        giftArr.sort(new Comparator<SweetsClass>() {
            @Override
            public int compare(SweetsClass o1, SweetsClass o2) {
                return Double.compare(o2.getSweetSugar(), o1.getSweetSugar());
            }
        });
    }
}
