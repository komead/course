package lesson1_8;

import javax.swing.*;

public class StartWindow extends JFrame {
    JButton calculate;
    JTextField expression;

    public StartWindow() {
        setTitle("Main Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 200);

        calculate = new JButton("Calculate");
        expression = new JTextField(10);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(expression);
        add(calculate);

        setVisible(true);
    }
}
