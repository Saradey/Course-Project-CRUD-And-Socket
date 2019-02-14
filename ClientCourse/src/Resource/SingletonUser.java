package Resource;



public class SingletonUser {

    private static SingletonUser instance;


    private int id = -1;
    private boolean isAuthorization = false;
    private String login = "";
    private double money;


    private SingletonUser(){
    }



    public static SingletonUser getInstance(){
        if(instance == null)
            instance = new SingletonUser();
        return instance;
    }


    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public int getId() {
        return id;
    }

    public boolean isAuthorization() {
        return isAuthorization;
    }

    public String getLogin() {
        return login;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthorization(boolean authorization) {
        isAuthorization = authorization;
    }

    public void setLogin(String login) {
        this.login = login;
    }


}
