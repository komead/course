package lesson1_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GraphWindow extends JFrame {
    private final double step = 0.1;
    private String expression;

    public GraphWindow(String expression) {
        this.expression = expression;
        setTitle(expression);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(700, 300, 400, 400);

        GraphPanel graphPanel = new GraphPanel();
        add(graphPanel);
        setVisible(true);

        // Реагирование на изменение размеров
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                graphPanel.repaint();
            }
        });
    }

    private class GraphPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            graphics.setColor(Color.BLACK);
            drawGraph(graphics);
        }

        private void drawGraph(Graphics graphics) {
            double previousY = Calculator.run(0, expression, - getWidth() / 2.0);
            double currentY;
            for (double x = step; x < getWidth(); x += step) {
                currentY = Calculator.run(0, expression, x - getWidth() / 2.0);
                graphics.drawLine((int) (x - step), (int) (getHeight() / 2 - previousY), (int) (x), (int) (getHeight() / 2 - currentY));
                previousY = currentY;
            }
        }
    }
}
