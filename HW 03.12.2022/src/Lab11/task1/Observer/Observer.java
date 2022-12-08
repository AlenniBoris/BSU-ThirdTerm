package Lab11.task1.Observer;

import java.util.List;

public interface Observer {
    public void handleEvent(List<String> pressedKeys);
}
