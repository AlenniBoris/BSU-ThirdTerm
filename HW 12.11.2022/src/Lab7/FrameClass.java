package Lab7;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FrameClass extends JFrame {
    private DrawPanel drawPanel = new DrawPanel();
    private JFileChooser fileChooser = new JFileChooser();

    private JMenu createColorMenu(){
        JMenu colorMenu = new JMenu("Color");

        JButton pinkBtn = new JButton("Pink");
        pinkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setColor(Color.pink);
            }
        });
        colorMenu.add(pinkBtn);

        JButton blueBtn = new JButton("Blue");
        blueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setColor(Color.blue);
            }
        });
        colorMenu.add(blueBtn);

        JButton redBtn = new JButton("Red");
        redBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setColor(Color.red);
            }
        });
        colorMenu.add(redBtn);

        JButton greenBtn = new JButton("Green");
        greenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.setColor(Color.green);
            }
        });
        colorMenu.add(greenBtn);

        return colorMenu;
    }
    private JMenu createFileMenu(){
        JMenu fileMenu = new JMenu("File");

        JButton saveBtn = new JButton("Save");
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser(".");
                fileChooser.setDialogTitle("Load");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        ImageIO.write(drawPanel.getImage(), "jpg", fileChooser.getSelectedFile());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
        fileMenu.add(saveBtn);

        JButton loadBtn = new JButton("Load");
        loadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser(".");
                fileChooser.setDialogTitle("Load");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    try {
                        drawPanel.setImage(ImageIO.read(fileChooser.getSelectedFile()));
                        setPreferredSize(new Dimension(drawPanel.getImage().getWidth(), drawPanel.getImage().getHeight()));
                        drawPanel.setGraphics(drawPanel.getImage().createGraphics());
                        drawPanel.setColor(drawPanel.getColor());
                        repaint();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
        fileMenu.add(loadBtn);

        return fileMenu;
    }

    public FrameClass(){
        setLayout(new BorderLayout());
        pack();
        setSize(900,900);
        setVisible(true);

        add(drawPanel);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(createColorMenu());
        menuBar.add(createFileMenu());

        JScrollPane scrollPane = new JScrollPane(drawPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
        scrollPane.createVerticalScrollBar();
        scrollPane.createHorizontalScrollBar();
        scrollPane.setPreferredSize(new Dimension(50,60));
        add(scrollPane);
    }
}
