package lesson1_8;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Graph extends JFrame {
    private final int windowWidth = 400;
    private final int windowHeight = 400;

    public Graph(String expression) {
        setTitle(expression);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(700, 300, windowWidth, windowHeight);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                for (double x = -windowWidth / 2.0; x < windowWidth / 2.0; x += 1) {
                    Calculator.run(0, expression, x);
                }
            }
        });

        setVisible(true);
    }
}
