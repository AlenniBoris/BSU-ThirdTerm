package ExamWork2.MVC;

import ExamWork2.Stack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Controller {
    private final Stack model;
    private JFileChooser fileChooser;
    private final View view;

    public Controller(){
        model = new Stack();
        view = new View(model);
    }

    public Controller(Stack model, View view) {
        this.model = model;
        this.view = view;
    }

    public JMenuBar getMyBar(){
        JMenuBar menuBar = new JMenuBar();

        menuBar.add(getMenu());

        return menuBar;
    }

    private JMenu getMenu(){
        JMenu menu = new JMenu("Menu");

        JMenuItem load = new JMenuItem("Load");
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser(".");
                fileChooser.setDialogTitle("Load");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        model.setFromFile(file);
                        view.update();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        menu.add(load);

        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser(".");
                fileChooser.setDialogTitle("Load");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        model.setToFile(file, view.getLabelsText());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        menu.add(save);

        JMenuItem add = new JMenuItem("Add");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = JOptionPane.showInputDialog("Push data to stack");
                String[] arr = data.split(",");
                for(String str : arr){
                    model.Push(Integer.parseInt(str));
                }
                view.update();
            }
        });
        menu.add(add);

        JMenuItem pop = new JMenuItem("Pop");
        pop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.Pop();
                view.update();
            }
        });
        menu.add(pop);

        return menu;
    }
}
