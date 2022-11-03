package VarB;

import VarSweets.SweetsClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GiftFrame extends JFrame {
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> showArea = new JList<>(listModel);

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

        JMenu saveMenu = new JMenu("Save");

        JMenuItem saveAllItem = new JMenuItem("Save all");
        saveAllItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Save all");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        giftClass.saveArrToFile(file);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
        saveMenu.add(saveAllItem);

        JMenuItem saveCookiesItem = new JMenuItem("Save cookies");
        saveCookiesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Save cookies");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        giftClass.saveCookiesToFile(file);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
        saveMenu.add(saveCookiesItem);

        JMenuItem saveLollipopsItem = new JMenuItem("Save cookies");
        saveCookiesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Save cookies");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        giftClass.saveLollipopsToFile(file);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
        saveMenu.add(saveLollipopsItem);

        JMenu loadTypeMenu = new JMenu("Load file");

        JMenuItem loadCookies = new JMenuItem("Cookies");
        loadCookies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Cookies");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        listModel.clear();
                        giftClass.getCookiesFromFile(file);
                        for (int i = 0; i < giftClass.getGiftArr().size(); i++) {
                           listModel.addElement(giftClass.getGiftArr().get(i).printSweet());
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JMenuItem loadLollipop = new JMenuItem("Lollipops");
        loadLollipop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Lollipops");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        listModel.clear();
                        giftClass.getLollipopFromFile(file);
                        for (String str: giftClass.printGift()){
                            listModel.addElement(str);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        loadTypeMenu.add(loadCookies);
        loadTypeMenu.add(loadLollipop);

        fileMenu.add(loadTypeMenu);
        fileMenu.add(saveMenu);

        return fileMenu;
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
        setLayout(new GridLayout(2,1));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(createSortMenu());
        menuBar.add(createFileMenu());

        for (String str : giftClass.printGift()){
            listModel.addElement(str);
        }
        add(showArea);

        JPanel btnPanel = new JPanel();
        add(btnPanel);
        btnPanel.setLayout(new GridLayout(1,2));

        btnPanel.add(createDelBtn());

    }

}
