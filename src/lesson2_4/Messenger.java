package lesson2_4;

import javax.swing.*;
import java.awt.*;

public class Messenger extends JFrame {
    private JButton sendMessage_b;
    private JTextField message_tf;
    private JTextArea output_ta;

    public Messenger() {
        setTitle("Main Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 500);
        setResizable(false);

        Box verticalBox = Box.createVerticalBox();
        sendMessage_b = new JButton("Send");
        message_tf = new JTextField();
        output_ta = new JTextArea();

        verticalBox.add(output_ta);

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(message_tf);
        horizontalBox.add(sendMessage_b);

        setListeners();

        message_tf.setMaximumSize(new Dimension(Integer.MAX_VALUE, message_tf.getPreferredSize().height));

        verticalBox.add(horizontalBox);
        add(verticalBox);

        setVisible(true);
    }

    private void setListeners() {
        sendMessage_b.addActionListener(e -> {
            messageReader();
        });

        message_tf.addActionListener(e -> {
            messageReader();
        });
    }

    private void messageReader() {
        if (!message_tf.getText().isEmpty()) {
            output_ta.append(message_tf.getText() + "\n");
            message_tf.setText("");
        }
    }
}
