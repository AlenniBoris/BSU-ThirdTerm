package Lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class SecondTask extends JFrame{
    private final int NUMBER_OF_LINES = 5;
    private JButton button;
    private Color color;

    private ArrayList<JButton> buttons = new ArrayList<>();

    public void addButtons(){
        for (int i = 0; i < Math.pow(NUMBER_OF_LINES, 2); ++i){
            button = new JButton(Integer.toString(i+1));
            button.setBackground(Color.green);
            buttons.add(button);
        }
        for (int i = 0; i < buttons.size(); ++i){
            buttons.get(i).setBackground(Color.green);
            String text = buttons.get(i).getText();
            int finalI = i;
            buttons.get(i).addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buttons.get(finalI).setText("Clicked!");
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    buttons.get(finalI).setText("Clicked!");
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    buttons.get(finalI).setText(text);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    color = buttons.get(finalI).getBackground();
                    buttons.get(finalI).setBackground(Color.red);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    buttons.get(finalI).setBackground(color);
                }
            });
            add(buttons.get(i));
        }
    }

    public SecondTask(){
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(NUMBER_OF_LINES, NUMBER_OF_LINES));
        addButtons();
    }
}
