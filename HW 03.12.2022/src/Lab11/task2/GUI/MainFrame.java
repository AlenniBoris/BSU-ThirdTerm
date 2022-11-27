package Lab11.task2.GUI;

import Lab11.task2.InterfaceComponents.*;
import Lab11.task2.Student.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame{

    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> dataList = new JList<>(listModel);
    private final JList<String> streamList = new JList<>(listModel);
    private final JList<String> loopList = new JList<>(listModel);

    private JFileChooser fileChooser;
    private final StudentCollection collection = new StudentCollection();

    private JButton getAddBtn(){
        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(e -> {
            String str = JOptionPane.showInputDialog("Enter your student in such format: Number of gradebook,surname,subject,grade");
            String[] arr = str.split(",");
            collection.add(new Student(Integer.parseInt(arr[0]), arr[1], arr[2], Integer.parseInt(arr[3])));
            dataList.setListData(collection.getStudents());
            loopList.setListData(new String[0]);
            streamList.setListData(new String[0]);
        });
        return addBtn;
    }

    private JMenu getFileMenu(){
        JMenu fileMenu = new JMenu("Load");
        JMenuItem load = new JMenuItem("Load file");
        load.addActionListener(e -> {
            fileChooser = new JFileChooser(".");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setDialogTitle("Choose file");
            if (fileChooser.showDialog(null, "Open file") == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    collection.setStudentsFromFile(selectedFile);
                    dataList.setListData(collection.getStudents());
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        });
        fileMenu.add(load);
        return fileMenu;
    }

    private JMenu getActionMenu(){
        JMenu actionMenu = new JMenu("Action");
        JMenuItem action = new JMenuItem("result");
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                streamList.setListData(collection.getResultFromStrategy(new OnlyStream(collection.getList())));
                loopList.setListData(collection.getResultFromStrategy(new OnlyLoops(collection.getList())));
            }
        });
        actionMenu.add(action);
        return actionMenu;
    }

    private JMenuBar getBar(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(getFileMenu());
        menuBar.add(getActionMenu());
        return menuBar;
    }

    public MainFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,2));
        setSize(500,500);
        setVisible(true);

        setJMenuBar(getBar());

        add(dataList);
        add(streamList);
        add(getAddBtn());
        add(loopList);
    }
}
