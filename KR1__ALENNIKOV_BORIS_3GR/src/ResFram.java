import javax.swing.*;
import java.awt.*;

public class ResFram extends JFrame {
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> showArea = new JList<>(listModel);
    public ResFram(String[] arr){
        setLayout(new GridLayout(1,1));
        showArea.setListData(arr);
        add(showArea);
    }
}
