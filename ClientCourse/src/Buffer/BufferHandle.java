package Buffer;


import Functional.HandleSend;
import Menu.ClassMenu;

import java.io.DataInputStream;

public class BufferHandle extends Thread {

    private HandleSend handleSend;
    private ClassMenu classMenu;


    public BufferHandle(HandleSend handleSend){
        this.handleSend = handleSend;
        classMenu = new ClassMenu(this);
    }



    @Override
    public void run() {
        classMenu.initMenu();
    }


    public void selectUser(DataInputStream dataInputStream){
        classMenu.showUser(dataInputStream);
    }


    public void selectMeetings(DataInputStream dataInputStream){
        classMenu.showMeetings(dataInputStream);
    }


    public void sendPacket(String sqlScript, int index){
        handleSend.sendPacket(sqlScript, index);
    }


    public void selectReminders(DataInputStream dataInputStream){
        classMenu.selectReminders(dataInputStream);
    }


    public void selectMonthlyConstant(DataInputStream dataInputStream){
        classMenu.selectMonthlyConstant(dataInputStream);
    }

    public void selectMonthlyIncome(DataInputStream dataInputStream){
        classMenu.selectMonthlyIncome(dataInputStream);
    }


}
