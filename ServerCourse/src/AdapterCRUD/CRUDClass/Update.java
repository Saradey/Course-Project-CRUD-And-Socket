package AdapterCRUD.CRUDClass;

import Handle.HandleSend;
import Resource.dbManager;

public class Update {

    dbManager manager;

    public void update(String sqlScript) {
        manager.setSqlScqript(sqlScript);
    }


    public Update(dbManager manager) {
        this.manager = manager;
    }

}
