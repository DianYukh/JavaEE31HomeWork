package HomeWork2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;

public class Client {
    static final int port = 1234;
    public static void main(String[] args){

        try (Socket server = new Socket("127.0.0.1", port)) {
            System.out.println("Підключено до сервера");
            BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter writer = new PrintWriter(server.getOutputStream(), true);

            System.out.print("Клієнт: ");
            String serverMessege = new BufferedReader(new InputStreamReader(System.in)).readLine();
            while (serverMessege != null && !serverMessege.equals("bye")) {
                writer.println(serverMessege);
                serverMessege = reader.readLine();
                System.out.println("Сервер: [" + LocalTime.now() + "]" + serverMessege);
                System.out.print("Клієнт: [" + LocalTime.now() + "]");
                serverMessege = new BufferedReader(new InputStreamReader(System.in)).readLine();
            }

            reader.close();
            writer.close();
            server.close();
            System.out.println("Клієнт завершив роботу");
        } catch (IOException e) {
            System.out.println("Помилка з'єднання: " + e.getMessage());
        }

    }
}
