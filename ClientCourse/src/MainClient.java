import Functional.mainThread;

import java.net.Socket;

public class MainClient {
    private static Socket socketClient;
    private static mainThread clientThread;


    public static void main(String[] args) {
        connectToServer();
        createClientThread();
        end();
    }


    private static void connectToServer() {

        try {
            socketClient = new Socket("127.0.0.1", 1015);   //мы подключаемся к серверу,
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static void createClientThread() {
        clientThread = new mainThread(socketClient);
    }


    private static void end() {
        try {
            socketClient.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.exit(0);
    }


}
