import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MainServer {

    private static ServerSocket server;
    private static Map<Socket, ClientThread> threadClient = new HashMap<>();    //здесь у нас хранится поток клиента и его сокет


    public static void main(String[] args) {
        start();
        HandleEvent();
        end();
    }


    private static void start() {
        //создаем сервер сокет к которому можно будет подключится и даём ему порт
        try {
            server = new ServerSocket(1015);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private static void HandleEvent() {
        while (true) {
            try {
                Socket socketClient = server.accept();
                ClientThread clientThread = new ClientThread(socketClient);
                threadClient.put(socketClient, clientThread);
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {    //sleep необходимл для того что бы не убивать ресурсы процессора
                Thread.sleep(100);
            } catch (InterruptedException in) {
                in.printStackTrace();
            }
        }
    }


    private static void end() {
        //сервер нужно обязательно закрывать, иначе он будет продолжать свою работу
        try {
            server.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.exit(0); //выходим
    }
}
