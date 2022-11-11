package Lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ThirdTask extends JFrame{
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton firstBtn = new JRadioButton();
    private JRadioButton secondBtn = new JRadioButton();

    public ThirdTask(){
        setSize(1500,1500);
        setVisible(true);
        setLayout(new GridLayout(1,2));
        add(firstBtn);
        add(secondBtn);
        firstBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                firstBtn.setIcon(new ImageIcon("choosePicture.png"));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                firstBtn.setIcon(new ImageIcon("pressPicture.png"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                firstBtn.setIcon(new ImageIcon("choosePicture.png"));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                firstBtn.setIcon(new ImageIcon("onPicture.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        buttonGroup.add(firstBtn);
        buttonGroup.add(secondBtn);
    }
}
