package VarB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GiftFrame extends JFrame {
    private JPanel btnPanel = new JPanel();
    private JButton addBtn = new JButton("Add");
    private JButton delBtn = new JButton("Delete");

    private JPanel inputPanel = new JPanel();
    private JTextField nameInput = new JTextField();
    private JTextField typeInput = new JTextField();
    private JTextField weigthInput = new JTextField();
    private JTextField sugarInput = new JTextField();

    private JList showArea;

    private JMenuBar menuBar = new JMenuBar();

    private JFileChooser fileChooser = new JFileChooser();

    private GiftClass giftClass = new GiftClass();

    private JMenu createSortMenu(){
        JMenu sortMenu = new JMenu("Sort");

        JCheckBoxMenuItem sortName = new JCheckBoxMenuItem("Name");
        sortName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(giftClass.getGiftArr().size() == 0)){
                    giftClass.sortByName();
                }else throw new RuntimeException("Nothing to sort");
            }
        });

        JCheckBoxMenuItem sortType = new JCheckBoxMenuItem("Type");
        sortType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(giftClass.getGiftArr().size() == 0)){
                    giftClass.sortByType();
                }else throw new RuntimeException("Nothing to sort");
            }
        });

        JCheckBoxMenuItem sortWeight = new JCheckBoxMenuItem("Weight");
        sortWeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(giftClass.getGiftArr().size() == 0)){
                    giftClass.sortByWeight();
                }else throw new RuntimeException("Nothing to sort");
            }
        });

        JCheckBoxMenuItem sortSugar = new JCheckBoxMenuItem("Sugar");
        sortSugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(giftClass.getGiftArr().size() == 0)){
                    giftClass.sortBySugar();
                }else throw new RuntimeException("Nothing to sort");
            }
        });

        sortMenu.add(sortName);
        sortMenu.add(sortType);
        sortMenu.add(sortWeight);
        sortMenu.add(sortSugar);

        return sortMenu;
    }

    private JMenu createFileMenu(){
        JMenu fileMenu = new JMenu("File");

        JMenuItem saveItem = new JMenuItem("Save as");
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Save as");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        giftClass.saveToFile(file);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
        fileMenu.add(saveItem);

        JMenuItem loadItem = new JMenuItem("Load file");
        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Save as");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        giftClass.getFromFile(file);
                        showArea.setListData(giftClass.printGift());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        fileMenu.add(loadItem);

        return fileMenu;
    }

    public GiftFrame(){
        setLayout(new GridLayout(3,1));

        setJMenuBar(menuBar);
        menuBar.add(createSortMenu());
        menuBar.add(createFileMenu());


        add(inputPanel);

        inputPanel.setLayout(new GridLayout(1,4));

        inputPanel.add(nameInput);
        nameInput.setToolTipText("name");


        inputPanel.add(typeInput);
        typeInput.setToolTipText("type");


        inputPanel.add(weigthInput);
        weigthInput.setToolTipText("weight");

        inputPanel.add(sugarInput);
        sugarInput.setToolTipText("sugar");


        showArea = new JList(giftClass.printGift());
        add(showArea);

        add(btnPanel);
        btnPanel.setLayout(new GridLayout(1,2));

        btnPanel.add(addBtn);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameInput.getText().length() != 0 && typeInput.getText().length() != 0 && weigthInput.getText().length() != 0 && sugarInput.getText().length() != 0){
                    giftClass.addSweet(new SweetsClass(nameInput.getText(), typeInput.getText(), Double.parseDouble(weigthInput.getText()), Double.parseDouble(sugarInput.getText())));
                }
                showArea.setListData(giftClass.printGift());
                nameInput.setText("");
                typeInput.setText("");
                weigthInput.setText("");
                sugarInput.setText("");
            }
        });

        btnPanel.add(delBtn);
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giftClass.deleteSweet(showArea.getSelectedIndex());
                showArea.setListData(giftClass.printGift());
            }
        });
    }


}
