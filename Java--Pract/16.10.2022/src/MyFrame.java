import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    public MyFrame(String title) throws HeadlessException {
        super(title);
        // завершение программы при закрытии пользователем окна приложения
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        series = new Liner(10,2,15);

        setLayout(new GridLayout(4,2));
        add(new JLabel("first"));
        JTextField firstText = new JTextField("" + series.getFirstElement());
        add(firstText);

        add(new JLabel("step"));
        JTextField stepText = new JTextField("" + series.getStep());
        add(stepText);

        add(new JLabel("count"));
        JTextField countText = new JTextField("" + series.getN());
        add(countText);

        JButton calculateButton = new JButton("calculate");
        add(calculateButton);

        JTextField showText = new JTextField();
        add(showText);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              double sum =  Double.parseDouble(firstText.getText()) + Double.parseDouble(stepText.getText());
                showText.setText("" + sum);
            }
        });


    }

    private Series series;
}
