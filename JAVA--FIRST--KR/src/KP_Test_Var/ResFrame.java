package KP_Test_Var;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ResFrame extends JFrame {
    private JList list = new JList<>();
    public ResFrame(ArrayList<Student> collection){
        super("student");
        setLayout(new BorderLayout());

        add(list);
        String[] arr = new String[collection.size()];
        for(int i = 0; i < collection.size(); ++i){
            arr[i] = collection.get(i).printStudent();
        }

        list.setListData(arr);
    }
}
