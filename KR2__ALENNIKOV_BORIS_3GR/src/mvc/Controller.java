package mvc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Controller {
    private final Multitude model;
    private JFileChooser fileChooser;
    private final View view;

    public Controller(){
        model = new Multitude();
        view = new View(model);
    }

    public Controller(Multitude model, View view) {
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
                        model.save(file);
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
                    model.add(Integer.parseInt(str));
                }
                view.update();
            }
        });
        menu.add(add);

        return menu;
    }
}
