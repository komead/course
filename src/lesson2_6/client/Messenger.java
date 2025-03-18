package lesson2_6.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Messenger extends JFrame {
    private JButton sendMessage_b;
    private JTextField message_tf;
    private JTextArea output_ta;

    private ServerHandler serverHandler;

    public Messenger() {
        setView();

        serverHandler = new ServerHandler();
        serverHandler.connect();

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

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                serverHandler.sendMessage("/end");
                serverHandler.finish();
            }
        });

        // тут будем прослушивать сообщения от сервера
        Thread t = new Thread(() -> {
            String receivedMessage = "";
                while (true) {
                    receivedMessage = serverHandler.checkMessage();

                    if (receivedMessage == null) {
                        break;
                    }

                    if (!receivedMessage.isEmpty()) {
                        output_ta.append(receivedMessage);
                    }
                }
        });
        t.setDaemon(true);
        t.start();
    }

    private void messageSender() {
        if (!message_tf.getText().isEmpty()) {
            serverHandler.sendMessage(message_tf.getText() + "\n");

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
