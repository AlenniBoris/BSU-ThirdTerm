package KP_Test_Var;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {
    private JMenu saveMenu() {
        JMenuItem saveMin = new JMenuItem("Minimum");
        saveMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save min");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        myCollection.saveTofile(file, myCollection.getStudentWithMin());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JMenuItem saveMax = new JMenuItem("Maximum");
        saveMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save max");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        myCollection.saveTofile(file, myCollection.getStudentWithMax());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JMenuItem saveAll = new JMenuItem("Save all");
        saveMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save all");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        myCollection.saveTofile(file, myCollection.getStudents());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JMenu saveMenu = new JMenu("Save");
        saveMenu.add(saveMin);
        saveMenu.add(saveMax);
        saveMenu.add(saveAll);

        return saveMenu;
    }

    private JMenu loadMenu(){
        JMenuItem loadItem = new JMenuItem("Load");
        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Load");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        myCollection.fillFromFile(file);
                        showList.setListData(myCollection.printAll());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JMenu loadMenu = new JMenu("Load");
        loadMenu.add(loadItem);

        return loadMenu;
    }

    private JButton minButton = new JButton("Minimum");
    private JButton maxButton = new JButton("Maximum");
    private JPanel buttonPanel = new JPanel(new GridLayout(1,2));
    private JMenuBar menuBar = new JMenuBar();
    private JFileChooser fileChooser;
    private MyCollection myCollection = new MyCollection();
    private JList showList = new JList();

    private ResFrame resFrame;

    public MainFrame(){
        super("main frame");
        setLayout(new GridLayout(2,1));

        setJMenuBar(menuBar);
        menuBar.add(loadMenu());
        menuBar.add(saveMenu());

        add(showList);

        add(buttonPanel);
        buttonPanel.add(minButton);
        minButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resFrame = new ResFrame(myCollection.getStudentWithMin());
                resFrame.setSize(500,500);
                resFrame.setVisible(true);
            }
        });

        buttonPanel.add(maxButton);
        maxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resFrame = new ResFrame(myCollection.getStudentWithMax());
                resFrame.setSize(500,500);
                resFrame.setVisible(true);
            }
        });
    }
}
