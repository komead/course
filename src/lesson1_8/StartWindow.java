package lesson1_8;

import javax.swing.*;
import java.awt.*;

public class StartWindow extends JFrame {
    JButton calculate;
    JTextField expression;

    public StartWindow() {
        setTitle("Main Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 100);
        setResizable(false);

        calculate = new JButton("Calculate");
        expression = new JTextField();

        setListener();

        expression.setMaximumSize(new Dimension(Integer.MAX_VALUE, expression.getPreferredSize().height));

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(Box.createHorizontalStrut(10)); // Отступ между элементами
        add(expression);
        add(Box.createHorizontalStrut(10)); // Отступ между элементами
        add(calculate);
        add(Box.createHorizontalStrut(10)); // Отступ между элементами


        setVisible(true);
    }

    private void setListener() {
        calculate.addActionListener(e -> {
            new Graph("");
        });
    }
}
