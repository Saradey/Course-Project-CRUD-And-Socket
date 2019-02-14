package Resource;


import Handle.HandleSend;

import java.sql.*;

public class dbManager {

    private Connection conn;
    private Statement statmt;
    private ResultSet resSet;

    HandleSend handleSend;


    public dbManager(HandleSend handleSend) {
        this.handleSend = handleSend;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:CourseProject.db");
            statmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void authorization(String sqlScqript){
        try {
            resSet = statmt.executeQuery(sqlScqript);
            while(resSet.next())
            {
                handleSend.sendLoginResult(resSet.getInt(1), resSet.getString(2), resSet.getDouble(4));
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void setSqlScqript(String sqlScqript){
        try {
            statmt.execute(sqlScqript);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void selectMeetings(String sqlScqript){
        try {
            resSet = statmt.executeQuery(sqlScqript);
            while(resSet.next())
            {
                handleSend.sendMeetings(resSet.getInt(1), resSet.getString(2), resSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void selectReminders(String sqlScqript){
        try {
            resSet = statmt.executeQuery(sqlScqript);
            while(resSet.next())
            {
                handleSend.sendReminders(resSet.getInt(1), resSet.getString(2), resSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void selectMonthlyConstant(String sqlScqript){
        try {
            resSet = statmt.executeQuery(sqlScqript);
            while(resSet.next())
            {
                handleSend.sendMonthlyConstant(resSet.getInt(1), resSet.getString(2), resSet.getDouble(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void selectMonthlyPermanent(String sqlScqript){
        try {
            resSet = statmt.executeQuery(sqlScqript);
            while(resSet.next())
            {
                handleSend.sendMonthlyPermanen(resSet.getInt(1), resSet.getString(2), resSet.getDouble(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
