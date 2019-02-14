package Menu;


import Buffer.BufferHandle;
import Resource.SingletonUser;
import Resource.StringResource;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class ShowInput {

    private StringResource stringResource = new StringResource();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    private BufferHandle bufferHandle;


    ShowInput(BufferHandle bufferHandle) {
        this.bufferHandle = bufferHandle;
    }


    public int showMainMenu() {
        System.out.println();
        System.out.println(stringResource.str1_1);
        System.out.println(stringResource.str1_2);
        System.out.println(stringResource.str1_3);
        System.out.println(stringResource.str1_4);
        System.out.print(stringResource.strFirst);

        int answer = 0;
        try {
            answer = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }


    public void showUser(DataInputStream dataInputStream) {
        try {
            System.out.println();
            int id = dataInputStream.readInt();
            String login = dataInputStream.readUTF();
            double allmoney = dataInputStream.readDouble();
            boolean isAuto = dataInputStream.readBoolean();

            SingletonUser.getInstance().setId(id);
            SingletonUser.getInstance().setMoney(allmoney);
            SingletonUser.getInstance().setLogin(login);
            SingletonUser.getInstance().setAuthorization(isAuto);

            if (SingletonUser.getInstance().isAuthorization()) {
                System.out.println("Ваш id:" + id);
                System.out.println("Ваш логин:" + login);
                System.out.println("Ваши деньги:" + allmoney);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void InputUser() {
        try {
            if (!SingletonUser.getInstance().isAuthorization()) {
                System.out.println();
                System.out.print(stringResource.str2_1);
                String login = reader.readLine();
                System.out.print(stringResource.str2_2);
                String password = reader.readLine();
                bufferHandle.sendPacket("SELECT * FROM _user WHERE login = '" + login + "' AND pasword = '" + password + "'", 20);
                sleeep();
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void InputRegistration() {
        try {
            if (!SingletonUser.getInstance().isAuthorization()) {
                System.out.println();
                System.out.print(stringResource.str2_1);
                String login = reader.readLine();
                System.out.print(stringResource.str2_2);
                String password = reader.readLine();
                System.out.print(stringResource.str2_3);
                String money = reader.readLine();

                bufferHandle.sendPacket("INSERT INTO _user (login, pasword, AllMoney) VALUES ('" + login + "', '" + password + "', " + money + ");", 2);
                sleeep();
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int InputSecondMenu() {
        int index = 0;
        try {
            System.out.println();
            System.out.println(stringResource.str4_1);
            System.out.println(stringResource.str4_2);
            System.out.println(stringResource.str4_3);
            System.out.println(stringResource.str4_4);
            System.out.println(stringResource.str4_5);
            System.out.println(stringResource.str4_6);
            System.out.println(stringResource.str4_7);
            System.out.println(stringResource.str4_8);
            System.out.println(stringResource.str4_9);
            System.out.print(stringResource.strFirst);
            index = Integer.parseInt(reader.readLine());
            sleeep();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return index;
    }

    private void sleeep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void InputShowMetings() {
        int id = SingletonUser.getInstance().getId();
        bufferHandle.sendPacket("SELECT * FROM meetings WHERE _id_user =" + id, 19);
    }

    public void showMeetings(DataInputStream dataInputStream) {
        try {
            int id_meetings = dataInputStream.readInt();
            String name_meetings = dataInputStream.readUTF();
            String date_m = dataInputStream.readUTF();

            System.out.println();
            System.out.println("id встречи:" + id_meetings);
            System.out.println("имя встречи:" + name_meetings);
            System.out.println("дата встречи:" + date_m);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int showNextMeetingsMenu() {
        int index = 0;
        try {
            sleeep();
            System.out.println(stringResource.str5_1);
            System.out.println(stringResource.str5_2);
            System.out.println(stringResource.str5_6);
            System.out.println(stringResource.strSecond);
            System.out.print(stringResource.strFirst);
            index = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return index;
    }


    public void insertMeetings() {
        try {
            System.out.println();
            System.out.print(stringResource.str5_3);
            String name = reader.readLine();
            System.out.print(stringResource.str5_4);
            String date = reader.readLine();
            int id_user = SingletonUser.getInstance().getId();
            bufferHandle.sendPacket("INSERT INTO meetings (name_meetings, date_meetings, _id_user) VALUES ('" + name + "', '" + date + "', " + id_user + ");", 1);
            sleeep();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void deleteMeetings() {
        try {
            System.out.println();
            System.out.print(stringResource.str5_5);
            int id_meetings = Integer.parseInt(reader.readLine());
            int id_user = SingletonUser.getInstance().getId();
            bufferHandle.sendPacket("DELETE FROM meetings WHERE id_meetings = " + id_meetings + " AND _id_user = " + id_user + ";", 10);
            sleeep();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updateMeetings() {
        try {
            System.out.println();
            System.out.print(stringResource.str5_7);
            int id_meetings = Integer.parseInt(reader.readLine());
            System.out.print(stringResource.str5_3);
            String name = reader.readLine();
            System.out.print(stringResource.str5_4);
            String date = reader.readLine();
            bufferHandle.sendPacket("UPDATE meetings SET name_meetings = '" + name + "', date_meetings = '" + date + "' WHERE id_meetings = " + id_meetings + ";", 28);
            sleeep();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void InputShowReminders() {
        int id = SingletonUser.getInstance().getId();
        bufferHandle.sendPacket("SELECT * FROM reminders WHERE _id_user =" + id, 21);
    }


    public void showReminders(DataInputStream dataInputStream) {
        try {
            int id_Reminders = dataInputStream.readInt();
            String name_Reminders = dataInputStream.readUTF();
            String date_Reminders = dataInputStream.readUTF();

            System.out.println();
            System.out.println("id напоминания:" + id_Reminders);
            System.out.println("имя напоминания:" + name_Reminders);
            System.out.println("дата напоминания:" + date_Reminders);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int showNextRemindersMenu() {
        int index = 0;
        try {
            sleeep();
            System.out.println(stringResource.str6_1);
            System.out.println(stringResource.str6_2);
            System.out.println(stringResource.str6_6);
            System.out.println(stringResource.strSecond);
            System.out.print(stringResource.strFirst);
            index = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return index;
    }


    public void insertReminders() {
        try {
            System.out.println();
            System.out.print(stringResource.str6_3);
            String name = reader.readLine();
            System.out.print(stringResource.str6_4);
            String urgency = reader.readLine();
            int id_user = SingletonUser.getInstance().getId();
            bufferHandle.sendPacket("INSERT INTO reminders (name_reminders, urgency, _id_user) VALUES ('" + name + "', '" + urgency + "', " + id_user + ");", 3);
            sleeep();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void deleteReminders() {
        try {
            System.out.println();
            System.out.print(stringResource.str6_5);
            int id_meetings = Integer.parseInt(reader.readLine());
            int id_user = SingletonUser.getInstance().getId();
            bufferHandle.sendPacket("DELETE FROM reminders WHERE id_reminders = " + id_meetings + " AND _id_user = " + id_user + ";", 12);
            sleeep();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updateReminders() {
        try {
            System.out.println();
            System.out.print(stringResource.str6_7);
            int id_Reminders = Integer.parseInt(reader.readLine());
            System.out.print(stringResource.str6_3);
            String name = reader.readLine();
            System.out.print(stringResource.str6_4);
            String urgency = reader.readLine();
            bufferHandle.sendPacket("UPDATE reminders SET name_reminders = '" + name + "', urgency = '" + urgency + "' WHERE id_reminders = " + id_Reminders + ";", 30);
            sleeep();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void InputShowConstantConsumption() {
        int id = SingletonUser.getInstance().getId();
        bufferHandle.sendPacket("SELECT * FROM monthlyConstantConsumption WHERE _id_user =" + id, 22);
    }


    public void showMonthlyConstant(DataInputStream dataInputStream) {
        try {
            int id_Consumption = dataInputStream.readInt();
            String name_Consumption = dataInputStream.readUTF();
            Double price = dataInputStream.readDouble();
            System.out.println();
            System.out.println("id постоянного ежемесячного расхода:" + id_Consumption);
            System.out.println("название постоянного ежемесячного расхода:" + name_Consumption);
            System.out.println("цена постоянного ежемесячного расхода:" + price);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public int showNextConstantConsumptionMenu() {
        int index = 0;
        try {
            sleeep();
            System.out.println(stringResource.str7_1);
            System.out.println(stringResource.str7_2);
            System.out.println(stringResource.str7_6);
            System.out.println(stringResource.strSecond);
            System.out.print(stringResource.strFirst);
            index = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return index;
    }



    public void insertConstantConsumption() {
        try {
            System.out.println();
            System.out.print(stringResource.str7_3);
            String name = reader.readLine();
            System.out.print(stringResource.str7_4);
            Double price = Double.parseDouble(reader.readLine());
            int id_user = SingletonUser.getInstance().getId();
            bufferHandle.sendPacket("INSERT INTO monthlyConstantConsumption (name_Consumption, price, _id_user) VALUES ('" + name + "', '" + price + "', " + id_user + ");", 4);
            sleeep();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void deleteConstantConsumption() {
        try {
            System.out.println();
            System.out.print(stringResource.str7_5);
            int id_Consumption = Integer.parseInt(reader.readLine());
            int id_user = SingletonUser.getInstance().getId();
            bufferHandle.sendPacket("DELETE FROM monthlyConstantConsumption WHERE id_Consumption = " + id_Consumption + " AND _id_user = " + id_user + ";", 13);
            sleeep();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updateConstantConsumption() {
        try {
            System.out.println();
            System.out.print(stringResource.str7_7);
            int id_Consumption = Integer.parseInt(reader.readLine());
            System.out.print(stringResource.str7_3);
            String name_Consumption = reader.readLine();
            System.out.print(stringResource.str7_4);
            Double price = Double.parseDouble(reader.readLine());
            bufferHandle.sendPacket("UPDATE monthlyConstantConsumption SET name_Consumption = '" + name_Consumption + "', price = '" + price + "' WHERE id_Consumption = " + id_Consumption + ";", 31);
            sleeep();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void InputShowMonthlyIncome() {
        int id = SingletonUser.getInstance().getId();
        bufferHandle.sendPacket("SELECT * FROM monthlyPermanentIncome WHERE _id_user =" + id, 23);
    }



    public void showMonthlyIncome(DataInputStream dataInputStream) {
        try {
            int id_Income = dataInputStream.readInt();
            String name_Income = dataInputStream.readUTF();
            Double price = dataInputStream.readDouble();
            System.out.println();
            System.out.println("id постоянного ежемесячного дохода:" + id_Income);
            System.out.println("название постоянного ежемесячного дохода:" + name_Income);
            System.out.println("цена постоянного ежемесячного дохода:" + price);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int showNextMonthlyPermanentMenu() {
        int index = 0;
        try {
            sleeep();
            System.out.println(stringResource.str8_1);
            System.out.println(stringResource.str8_2);
            System.out.println(stringResource.str8_6);
            System.out.println(stringResource.strSecond);
            System.out.print(stringResource.strFirst);
            index = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return index;
    }




    public void insertMonthlyPermanent() {
        try {
            System.out.println();
            System.out.print(stringResource.str8_3);
            String name = reader.readLine();
            System.out.print(stringResource.str8_4);
            Double price = Double.parseDouble(reader.readLine());
            int id_user = SingletonUser.getInstance().getId();
            bufferHandle.sendPacket("INSERT INTO monthlyPermanentIncome (name_Income, price, _id_user) VALUES ('" + name + "', '" + price + "', " + id_user + ");", 5);
            sleeep();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteMonthlyPermanent() {
        try {
            System.out.println();
            System.out.print(stringResource.str8_5);
            int id_Income = Integer.parseInt(reader.readLine());
            int id_user = SingletonUser.getInstance().getId();
            bufferHandle.sendPacket("DELETE FROM monthlyPermanentIncome WHERE id_Income = " + id_Income + " AND _id_user = " + id_user + ";", 14);
            sleeep();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updateMonthlyPermanent() {
        try {
            System.out.println();
            System.out.print(stringResource.str8_7);
            int id_Income = Integer.parseInt(reader.readLine());
            System.out.print(stringResource.str8_3);
            String name_Income = reader.readLine();
            System.out.print(stringResource.str8_4);
            Double price = Double.parseDouble(reader.readLine());
            bufferHandle.sendPacket("UPDATE monthlyPermanentIncome SET name_Income = '" + name_Income + "', price = '" + price + "' WHERE id_Income = " + id_Income + ";", 32);
            sleeep();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
