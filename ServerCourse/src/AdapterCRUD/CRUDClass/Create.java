package AdapterCRUD.CRUDClass;

import Handle.HandleSend;
import Resource.dbManager;

public class Create {

    dbManager manager;

    public void create(String sqlSqript) {
        manager.setSqlScqript(sqlSqript);
    }

    public Create(dbManager manager) {
        this.manager = manager;
    }

}
