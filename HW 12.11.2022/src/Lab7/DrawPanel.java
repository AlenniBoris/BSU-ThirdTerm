package Lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JComponent{
    private BufferedImage image;
    private Graphics graphics;
    private Color color;
    private int currentX, currentY, oldX, oldY;

    public DrawPanel(){
        setDoubleBuffered(false);

        image = new BufferedImage(500,500, BufferedImage.TYPE_INT_RGB);
        graphics = image.createGraphics();
        color = Color.ORANGE;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
                graphics.setColor(color);
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                graphics.setColor(color);

                graphics.drawLine(oldX, oldY, currentX,currentY);
                repaint();
                oldX = currentX;
                oldY = currentY;
            }
        });
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(image,0,0,this);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
}


