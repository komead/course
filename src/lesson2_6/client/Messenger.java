package lesson2_6.client;

import javax.swing.*;
import java.awt.*;

public class Messenger extends JFrame {
    private JButton sendMessage_b;
    private JTextField message_tf;
    private JTextArea output_ta;

    public Messenger() {
        setView();
        setListeners();


    }

    private void setView() {
        setTitle("Main Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 500);
        setResizable(false);

        sendMessage_b = new JButton("Send");
        message_tf = new JTextField();
        output_ta = new JTextArea();

        message_tf.setMaximumSize(new Dimension(Integer.MAX_VALUE, message_tf.getPreferredSize().height));
        output_ta.setEditable(false);

        Box verticalBox = Box.createVerticalBox();
        addVerticalBorder(verticalBox, 20);
        verticalBox.add(output_ta);
        addVerticalBorder(verticalBox, 20);

        Box horizontalBox = Box.createHorizontalBox();
        addHorizontalBorder(horizontalBox, 10);
        horizontalBox.add(message_tf);
        addHorizontalBorder(horizontalBox, 10);
        horizontalBox.add(sendMessage_b);
        addHorizontalBorder(horizontalBox, 10);

        verticalBox.add(horizontalBox);
        addVerticalBorder(verticalBox, 20);
        add(verticalBox);

        setVisible(true);
        SwingUtilities.invokeLater(() -> message_tf.requestFocusInWindow()); // установка курсора в поле для записи
    }

    private void setListeners() {
        sendMessage_b.addActionListener(e -> {
            messageSender();
        });

        message_tf.addActionListener(e -> {
            messageSender();
        });
    }

    private void messageSender() {
        if (!message_tf.getText().isEmpty()) {
            // написать реализацию отправки сообщения

            output_ta.append(message_tf.getText() + "\n");
            message_tf.setText("");
        }
        SwingUtilities.invokeLater(() -> message_tf.requestFocusInWindow()); // установка курсора в поле для записи
    }

    private void addHorizontalBorder(Box box, int border) {
        box.add(Box.createHorizontalStrut(border));
    }

    private void addVerticalBorder(Box box, int border) {
        box.add(Box.createVerticalStrut(border));
    }
}
