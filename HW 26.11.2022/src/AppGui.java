import javax.swing.*;
import java.awt.*;

public class AppGui extends JFrame {

    private Multitude<Integer> firstMultitude = new Multitude<>();
    private Multitude<Integer> secondMultitude = new Multitude<>();
    DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList firstList = new JList(listModel);
    private JList secondList = new JList(listModel);


    //private JPanel btnPanel(); это панель со всеми кнопками, выводятся также предупреждения

    private JPanel getListPanel(){ //это для листов
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(2,1));
        listPanel.add(firstList);
        listPanel.add(secondList);

        return listPanel;
    }

    public AppGui(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
        setLayout(new GridLayout(1,2));


    }

}
