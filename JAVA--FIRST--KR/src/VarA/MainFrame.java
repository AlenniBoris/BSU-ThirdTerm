package VarA;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private  CoursePanel coursePanel;

    public MainFrame(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(new Dimension(500,500));
    }
}
