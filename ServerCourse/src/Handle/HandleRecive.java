package Handle;


import AdapterCRUD.AdapterCRUD;

import java.io.DataInputStream;
import java.net.Socket;

public class HandleRecive extends Thread {

    private Socket socketClient;
    private AdapterCRUD adapterCRUD;

    public HandleRecive(Socket socketClient){
        this.socketClient = socketClient;
        adapterCRUD = new AdapterCRUD(socketClient);
    }


    @Override
    public void run() {
        while (true){

            while (true){
                if(!ReadData()) { //если мы ничего не прочли, засыпаем, если прочли то читаем подряд
                    try {
                        Thread.sleep(10);
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }

        }
    }



    private boolean ReadData(){
        try {
            DataInputStream inputStream = new DataInputStream(socketClient.getInputStream()); //мы получаем данные
            if(inputStream.available() <= 0)
                return false;
            String sqlSqript = inputStream.readUTF();
            int flag = inputStream.readInt();
            adapterCRUD.SetScript(sqlSqript, flag);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return true;
    }



}
