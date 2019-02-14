package AdapterCRUD.CRUDClass;

import Handle.HandleSend;
import Resource.dbManager;

public class Delete {

    dbManager manager;

    public void delete(String sqlScript) {
        manager.setSqlScqript(sqlScript);
    }


    public Delete(dbManager manager) {
        this.manager = manager;
    }
}
