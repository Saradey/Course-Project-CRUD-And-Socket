package AdapterCRUD.CRUDClass;

import Handle.HandleSend;
import Resource.dbManager;

public class Read {

    dbManager manager;



    public void read(int flag, String sqlSqript) {

        switch (flag) {
            case 19:
                manager.selectMeetings(sqlSqript);
                break;

            case 20:
                manager.authorization(sqlSqript);
                break;

            case 21:
                manager.selectReminders(sqlSqript);
                break;

            case 22:
                manager.selectMonthlyConstant(sqlSqript);

            case 23:
                manager.selectMonthlyPermanent(sqlSqript);
                break;
        }

    }


    public Read(dbManager manager) {
        this.manager = manager;
    }




}
