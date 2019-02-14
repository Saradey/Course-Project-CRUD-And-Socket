import Handle.HandleRecive;
import Handle.HandleSend;

import java.net.Socket;


public class ClientThread {

    final private Socket client;        //сокет клиента
    private HandleRecive handleRecive;

    ClientThread(Socket client) {
        this.client = client;
        handleRecive = new HandleRecive(this.client);
        handleRecive.start();
    }

}
