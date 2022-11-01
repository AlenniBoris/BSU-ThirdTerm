package VarB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GiftFrame extends JFrame {
    private final JTextField nameInput = new JTextField();
    private final JTextField typeInput = new JTextField();
    private final JTextField weigthInput = new JTextField();
    private final JTextField sugarInput = new JTextField();

    private final JList<Object> showArea = new JList<>();

    private final JFileChooser fileChooser = new JFileChooser();

    private final GiftClass giftClass = new GiftClass();

    private JMenu createSortMenu(){
        JMenu sortMenu = new JMenu("Sort");

        JCheckBoxMenuItem sortName = new JCheckBoxMenuItem("Name");
        sortName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giftClass.sortByName();
                showArea.setListData(giftClass.printGift());
            }
        });

        JCheckBoxMenuItem sortType = new JCheckBoxMenuItem("Type");
        sortType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giftClass.sortByType();
                showArea.setListData(giftClass.printGift());
            }
        });

        JCheckBoxMenuItem sortWeight = new JCheckBoxMenuItem("Weight");
        sortWeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giftClass.sortByWeight();
                showArea.setListData(giftClass.printGift());

            }
        });

        JCheckBoxMenuItem sortSugar = new JCheckBoxMenuItem("Sugar");
        sortSugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giftClass.sortBySugar();
                showArea.setListData(giftClass.printGift());
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

    private JButton createAddBtn(){
        JButton addBtn = new JButton("Add");
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

        return addBtn;
    }

    private JButton createDelBtn(){
        JButton delBtn = new JButton("Delete");
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    giftClass.deleteSweet(showArea.getSelectedIndex());
                    showArea.setListData(giftClass.printGift());
                } catch (IndexOutOfBoundsException err){
                    showArea.setListData(giftClass.printGift());
                }
            }
        });

        return delBtn;
    }

    public GiftFrame(){
        setLayout(new GridLayout(3,1));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(createSortMenu());
        menuBar.add(createFileMenu());

        JPanel inputPanel = new JPanel();
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

        showArea.setListData(giftClass.printGift());
        add(showArea);

        JPanel btnPanel = new JPanel();
        add(btnPanel);
        btnPanel.setLayout(new GridLayout(1,2));

        btnPanel.add(createAddBtn());
        btnPanel.add(createDelBtn());

    }

}
