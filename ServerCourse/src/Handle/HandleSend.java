package Handle;


import java.io.DataOutputStream;
import java.net.Socket;

public class HandleSend{


    private Socket socketClient;

    public HandleSend(Socket socketClient){
        this.socketClient = socketClient;
    }


    public void sendLoginResult(int id, String login, double allmoney){
        try{
            int flag = 20;
            DataOutputStream dataOutputStream = new DataOutputStream(socketClient.getOutputStream());
            dataOutputStream.writeInt(flag);
            dataOutputStream.writeInt(id);
            dataOutputStream.writeUTF(login);
            dataOutputStream.writeDouble(allmoney);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.flush();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public void sendMeetings(int id_meetings, String name_meetings, String date_meetings){
        try{
            int flag = 19;
            DataOutputStream dataOutputStream = new DataOutputStream(socketClient.getOutputStream());
            dataOutputStream.writeInt(flag);
            dataOutputStream.writeInt(id_meetings);
            dataOutputStream.writeUTF(name_meetings);
            dataOutputStream.writeUTF(date_meetings);
            dataOutputStream.flush();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void sendReminders(int id_meetings, String name_reminders, String date_reminders){
        try{
            int flag = 21;
            DataOutputStream dataOutputStream = new DataOutputStream(socketClient.getOutputStream());
            dataOutputStream.writeInt(flag);
            dataOutputStream.writeInt(id_meetings);
            dataOutputStream.writeUTF(name_reminders);
            dataOutputStream.writeUTF(date_reminders);
            dataOutputStream.flush();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public void sendMonthlyConstant(int id_Consumption, String name_Consumption, Double price){
        try{
            int flag = 22;
            DataOutputStream dataOutputStream = new DataOutputStream(socketClient.getOutputStream());
            dataOutputStream.writeInt(flag);
            dataOutputStream.writeInt(id_Consumption);
            dataOutputStream.writeUTF(name_Consumption);
            dataOutputStream.writeDouble(price);
            dataOutputStream.flush();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public void sendMonthlyPermanen(int id_Income, String name_Income, Double price){
        try{
            int flag = 23;
            DataOutputStream dataOutputStream = new DataOutputStream(socketClient.getOutputStream());
            dataOutputStream.writeInt(flag);
            dataOutputStream.writeInt(id_Income);
            dataOutputStream.writeUTF(name_Income);
            dataOutputStream.writeDouble(price);
            dataOutputStream.flush();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }



}
