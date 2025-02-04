package lesson1_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        setListeners();

        expression.setMaximumSize(new Dimension(Integer.MAX_VALUE, expression.getPreferredSize().height));

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(Box.createHorizontalStrut(10)); // Отступ между элементами
        add(expression);
        add(Box.createHorizontalStrut(10));
        add(calculate);
        add(Box.createHorizontalStrut(10));


        setVisible(true);
    }

    private void setListeners() {
        calculate.addActionListener(e -> {
            Graph graph = new Graph(expression.getText());


            graph.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    calculate.setEnabled(!calculate.isEnabled());
                }

                @Override
                public void windowOpened(WindowEvent e) {
                    calculate.setEnabled(!calculate.isEnabled());
                }
            });
        });
    }
}
