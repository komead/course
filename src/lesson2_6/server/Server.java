package lesson2_6.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9090)) {
            System.out.println("Ожидание подключений...");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключён");
            ClientHandler clientHandler = new ClientHandler(socket);

            new Thread(() -> {
                String message = "";
                while (true) {
                    message = clientHandler.checkMessage();

                    if (message.equals("/end")) {
                        clientHandler.finish();
                        break;
                    }

                    System.out.print("client: " + message);
                }
            }).start();

            Thread thread = new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    clientHandler.sendMessage(scanner.nextLine());
                }
            });
            thread.setDaemon(true);
            thread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
