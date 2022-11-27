package Lab11.task1.InterfaceComponents;

import Lab11.task1.Interface.*;

import java.util.ArrayList;
import java.util.List;

public class ObservedItem implements Observed {
    List<String> keys = new ArrayList<>();
    List<Observer> subscribers = new ArrayList<>();

    public void addKey(String key){
        keys.add(key);
        notifyObservers();
    }

    public void removeKey(String key){
        keys.remove(key);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer subscriber: subscribers){
            subscriber.handleEvent(keys);
        }
    }
}
