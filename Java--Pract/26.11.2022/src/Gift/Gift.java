package Gift;

import Interface.GiftStrategy;
import Interface.Iterator;
import Sweets.Sweet;

import java.util.ArrayList;

public class Gift {
    private ArrayList<Sweet> sweets;

    public Gift(ArrayList<Sweet> sweets) {
        this.sweets = sweets;
    }

    public Gift() {
        sweets = new ArrayList<>();
    }

    public ArrayList<Sweet> getSweets() {
        return sweets;
    }

    private class ListIterator implements Iterator{
        int index = 0;

        @Override
        public boolean isDone() {
            return index < sweets.size();
        }

        @Override
        public Object Next() {
            return this.isDone() ? sweets.get(index++) : null;
        }

        @Override
        public Object First() {
            return sweets.get(0);
        }

        @Override
        public void renewIterator() {
            index = 0;
        }
    }

    public Iterator getIterator(){
        return new ListIterator();
    }

    public void add(Sweet sweet){
        sweets.add(sweet);
    }

    public void setSweets(ArrayList<Sweet> sweets) {
        this.sweets = sweets;
    }

    public void delete(Sweet sweet){
        sweets.remove(sweet);
    }

    public Double getGiftSugar(){
        double res = 0;
        for (Sweet sweet : sweets)
            res += sweet.getSweetSugar();
        return res;
    }

    public Double getGiftWeight(){
        double res = 0;
        for (Sweet sweet : sweets)
            res += sweet.getSweetWeight();
        return res;
    }

    public void scaleParameter(GiftStrategy giftStrategy, int scale){
        giftStrategy.scaleParameter(scale);
    }

    public void reduceParameter(GiftStrategy giftStrategy, String parameter){
        giftStrategy.reduceParameter(parameter);
    }
}
