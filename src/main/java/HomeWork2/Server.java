package HomeWork2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

public class Server {

        static final int port = 1234;
        public static void main(String[] args) throws IOException {

       try(ServerSocket server = new ServerSocket(port)){
            System.out.println("Сервер запущено");
            Socket client = server.accept();
            System.out.println("Клієнт підключився: " + client.getInetAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

            String clientMessage = reader.readLine();
            while (clientMessage != null && !clientMessage.equals("bye")) {
                System.out.println("Клієнт: [" + LocalTime.now() + "]" + clientMessage);
                System.out.print("Сервер: [" + LocalTime.now() + "]");
                clientMessage = new BufferedReader(new InputStreamReader(System.in)).readLine();
                writer.println(clientMessage);
                clientMessage = reader.readLine();
            }

            reader.close();
            writer.close();
            client.close();
            server.close();
            System.out.println("Сервер завершив роботу");
        }
       catch (IOException e) {
           System.out.println("Помилка з'єднання: " + e.getMessage());
       }

        }
    }




