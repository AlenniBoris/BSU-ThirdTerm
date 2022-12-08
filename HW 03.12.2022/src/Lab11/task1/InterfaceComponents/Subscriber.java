package Lab11.task1.InterfaceComponents;

import Lab11.task1.Observer.*;

import java.util.ArrayList;
import java.util.List;

public class Subscriber implements Observer {
    private List<String> incomingData = new ArrayList<>();

    public List<String> getIncomingData() {
        return incomingData;
    }

    public String getLastData(){
        return incomingData.get(incomingData.size() - 1);
    }

    @Override
    public void handleEvent(List<String> pressedKeys) {
        incomingData = pressedKeys;
    }
}
