package Functional;

import java.io.DataOutputStream;
import java.net.Socket;

public class HandleSend{

    private Socket socketClient;

    public HandleSend(Socket socketClient) {
        this.socketClient = socketClient;
    }


    public void sendPacket(String sqlScript, int flag){
        try{
            DataOutputStream dataOutputStream = new DataOutputStream(socketClient.getOutputStream());
            dataOutputStream.writeUTF(sqlScript);
            dataOutputStream.writeInt(flag);
            dataOutputStream.flush();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
