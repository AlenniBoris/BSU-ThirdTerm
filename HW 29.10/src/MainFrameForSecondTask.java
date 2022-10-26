import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrameForSecondTask extends JFrame {
    private JLabel questionLbl = new JLabel("Do you like your stipa ?");
    private JPanel mainPanel = new JPanel();
    private JButton yesBtn = new JButton("Yes");
    private JButton noBtn = new JButton("No");

    public MainFrameForSecondTask(){
        super("Seconnd task");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500,500);
        setLocation(100,100);


        mainPanel.setLayout(null);
        yesBtn.setSize(60,40);
        noBtn.setSize(60,40);
        mainPanel.add(yesBtn);
        yesBtn.setLocation(0,0);
        mainPanel.add(noBtn);
        yesBtn.setLocation(70,0);

        add(questionLbl, BorderLayout.NORTH);
        add(mainPanel);

        noBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                questionLbl.setText("Me too");
            }
        });

        yesBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                yesBtn.setLocation((int)((Math.random() * (400- noBtn.getWidth())) + noBtn.getWidth()), (int)((Math.random() * (400 - noBtn.getHeight())) + noBtn.getHeight()));
            }
        });

    }
}
