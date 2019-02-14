package AdapterCRUD;


import AdapterCRUD.CRUDClass.Create;
import AdapterCRUD.CRUDClass.Delete;
import AdapterCRUD.CRUDClass.Read;
import AdapterCRUD.CRUDClass.Update;
import Handle.HandleSend;
import Resource.dbManager;

import java.net.Socket;

public class AdapterCRUD {

    Read read;
    Delete delete;
    Update update;
    Create create;

    dbManager manager;
    HandleSend handleSend;


    public AdapterCRUD(Socket socketClient) {
        handleSend = new HandleSend(socketClient);
        manager = new dbManager(handleSend);
        read = new Read(manager);
        delete = new Delete(manager);
        update = new Update(manager);
        create = new Create(manager);
    }


    public void SetScript(String sqlSqript, int flag){

        if(flag >= 19 && flag < 28) {
            read.read(flag, sqlSqript);
        } else if(flag >= 1 && flag < 10) {
            create.create(sqlSqript);
        } else if(flag >= 10 && flag < 19){
            delete.delete(sqlSqript);
        } else if(flag >= 28 && flag <= 36){
            update.update(sqlSqript);
        }

    }




}
