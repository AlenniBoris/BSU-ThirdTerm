package Lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FirstTask extends JFrame {
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> leftList = new JList<>(listModel);
    private final JList<String> rightList = new JList<>(listModel);
    private final JButton upperBtn = new JButton("->");
    private final JButton downBtn = new JButton("<-");
    ArrayList<String> leftData = new ArrayList<>();
    private ArrayList<String> rightData = new ArrayList<>();

    private void setDataToList(){
        leftList.setListData(leftData.toArray(String[]::new));
        rightList.setListData(rightData.toArray(String[]::new));
    }

    public FirstTask(){
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(leftList, BorderLayout.WEST);
        add(rightList, BorderLayout.EAST);

        leftData.add("1");
        leftData.add("2");
        leftData.add("3");
        leftData.add("4");
        rightData.add("5");
        rightData.add("6");
        rightData.add("7");
        rightData.add("8");

        setDataToList();

        JPanel centerPanel = new JPanel(new BorderLayout());
        add(centerPanel);

        centerPanel.add(upperBtn, BorderLayout.NORTH);
        upperBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rightData.add(leftList.getSelectedValue());
                leftData.remove(leftList.getSelectedValue());
                setDataToList();
            }
        });

        centerPanel.add(downBtn, BorderLayout.SOUTH);
        downBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftData.add(rightList.getSelectedValue());
                rightData.remove(rightList.getSelectedValue());
                setDataToList();
            }
        });
    }
}
