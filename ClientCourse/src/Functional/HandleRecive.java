package Functional;

import Buffer.BufferHandle;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class HandleRecive extends Thread {

    private Socket socketClient;
    private BufferHandle bufferHandle;
    private int flag;


    public HandleRecive(Socket socketClient, BufferHandle bufferHandle) {
        this.socketClient = socketClient;
        this.bufferHandle = bufferHandle;
        flag = 0;
    }


    @Override
    public synchronized void start() {
        run();
    }


    @Override
    public void run() {
        while (true) {
            try {
                DataInputStream dataInputStream = new DataInputStream(socketClient.getInputStream());
                if (dataInputStream.available() == 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    continue;
                }


                flag = dataInputStream.readInt();
                switch (flag) {
                    case 0:
                        break;

                    case 20:
                        selectUser(dataInputStream);
                        break;

                    case 19:
                        selectMeetings(dataInputStream);
                        break;

                    case 21:
                        selectReminders(dataInputStream);
                        break;

                    case 22:
                        selectMonthlyConstant(dataInputStream);
                        break;

                    case 23:
                        selectMonthlyIncome(dataInputStream);
                        break;

                }


            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }



    private void selectUser(DataInputStream dataInputStream){
        bufferHandle.selectUser(dataInputStream);
    }

    private void selectMeetings(DataInputStream dataInputStream){
        bufferHandle.selectMeetings(dataInputStream);
    }

    private void selectReminders(DataInputStream dataInputStream){
        bufferHandle.selectReminders(dataInputStream);
    }

    private void selectMonthlyConstant(DataInputStream dataInputStream){
        bufferHandle.selectMonthlyConstant(dataInputStream);
    }

    private void selectMonthlyIncome(DataInputStream dataInputStream){
        bufferHandle.selectMonthlyIncome(dataInputStream);
    }

}
