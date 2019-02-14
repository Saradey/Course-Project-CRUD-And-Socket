package Functional;


import Buffer.BufferHandle;

import java.net.Socket;

public class mainThread {

    private Socket socketClient;
    private HandleRecive handleRecive;
    private HandleSend handleSend;

    private BufferHandle buffetHandle;


    public mainThread(Socket socketClient) {
        this.socketClient = socketClient;

        handleSend = new HandleSend(this.socketClient);

        buffetHandle = new BufferHandle(handleSend);
        buffetHandle.start();

        handleRecive = new HandleRecive(this.socketClient, buffetHandle);
        handleRecive.start();
    }



}
