import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrameForFirstTask extends JFrame{

    private JPanel mainPanel = new JPanel();
    private JLabel stateLbl = new JLabel("Position is unknown");
    private JButton button = new JButton();

    public MainFrameForFirstTask() throws HeadlessException{
        super("First task");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500,500);
        setLocation(100,100);


        mainPanel.setLayout(null);
        button.setSize(60,40);
        button.setMargin(new Insets(0,0,0,0));
        mainPanel.add(button);


        add(mainPanel);
        add(stateLbl, BorderLayout.SOUTH);

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                stateLbl.setText("Position = " + e.getPoint());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                stateLbl.setText("Position = " + e.getPoint());
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button.setLocation(e.getLocationOnScreen().x - mainPanel.getLocationOnScreen().x, e.getLocationOnScreen().y - mainPanel.getLocationOnScreen().y);
            }
        });

        button.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                stateLbl.setText("Position = " + (e.getLocationOnScreen().x - mainPanel.getLocationOnScreen().x) + ";" + (e.getLocationOnScreen().y - mainPanel.getLocationOnScreen().y));
                if (e.isControlDown()){
                    button.setLocation(e.getLocationOnScreen().x - mainPanel.getLocationOnScreen().x, e.getLocationOnScreen().y - mainPanel.getLocationOnScreen().y);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                stateLbl.setText("Position = " + (e.getLocationOnScreen().x - mainPanel.getLocationOnScreen().x) + ";" + (e.getLocationOnScreen().y - mainPanel.getLocationOnScreen().y));
            }
        });

        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (Character.isLetter(e.getKeyChar())){
                    button.setText(button.getText() + e.getKeyChar());
                }
                else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE && button.getText().length() > 0){
                    button.setText(button.getText().substring(0, button.getText().length() - 1));
                }
            }
        });

    }
}
