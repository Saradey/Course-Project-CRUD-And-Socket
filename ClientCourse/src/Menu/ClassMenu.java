package Menu;

import java.io.DataInputStream;

import Buffer.BufferHandle;
import Resource.SingletonUser;

public class ClassMenu {

    private int mainMenu = 0;
    private int secondMenu = 0;
    private int thirdMenu = 0;

    private ShowInput showInput;

    private BufferHandle bufferHandle;


    public ClassMenu(BufferHandle bufferHandle) {
        this.bufferHandle = bufferHandle;
        showInput = new ShowInput(this.bufferHandle);
    }


    public void initMenu() {
        while (true) {
            switch (mainMenu) {
                case 0:
                    showInputIndexMainMenu();
                    break;

                case 1:
                    showAuthorization();
                    break;

                case 2:
                    showInputRegistration();
                    break;

                case 3:
                    System.exit(1);
                    break;


                default:
                    showInputIndexMainMenu();
                    break;
            }
        }
    }


    private void showInputIndexMainMenu() {
        mainMenu = showInput.showMainMenu();
    }


    private void showInputRegistration() {
        showInput.InputRegistration();
        mainMenu = 0;
    }


    public void showMeetings(DataInputStream dataInputStream) {
        showInput.showMeetings(dataInputStream);
    }


    public void showUser(DataInputStream dataInputStream) {
        showInput.showUser(dataInputStream);
    }

    public void selectReminders(DataInputStream dataInputStream) {
        showInput.showReminders(dataInputStream);
    }


    public void selectMonthlyConstant(DataInputStream dataInputStream) {
        showInput.showMonthlyConstant(dataInputStream);
    }

    public void selectMonthlyIncome(DataInputStream dataInputStream) {
        showInput.showMonthlyIncome(dataInputStream);
    }


    private void showAuthorization() {
        showInput.InputUser();

        if (SingletonUser.getInstance().isAuthorization()) {
            secondMenu = showInput.InputSecondMenu();

            switch (secondMenu) {
                case 1:
                    showInput.InputShowMetings();
                    showNextMeetigsMenu();
                    break;

                case 2:
                    showInput.InputShowReminders();
                    showNextRemindersMenu();
                    break;

                case 3:
                    showInput.InputShowConstantConsumption();
                    showConstantConsumptionMenu();
                    break;

                case 4:
                    showInput.InputShowMonthlyIncome();
                    showMonthlyPermanent();
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    System.exit(1);
                    break;

                    default:
                        secondMenu = showInput.InputSecondMenu();
                        break;
            }
        }
    }





    private void showNextMeetigsMenu() {
        thirdMenu = showInput.showNextMeetingsMenu();

        switch (thirdMenu) {
            case 1:
                showInput.insertMeetings();
                thirdMenu = showInput.showNextMeetingsMenu();
                break;

            case 2:
                showInput.deleteMeetings();
                thirdMenu = showInput.showNextMeetingsMenu();
                break;

            case 3:
                showInput.updateMeetings();
                thirdMenu = showInput.showNextMeetingsMenu();
                break;

            case 4:
                thirdMenu = -1;
                secondMenu = 0;
                break;

            case 0:
                showNextMeetigsMenu();
                break;

            default:
                break;
        }
    }



    private void showNextRemindersMenu() {
        thirdMenu = showInput.showNextRemindersMenu();

        switch (thirdMenu) {
            case 1:
                showInput.insertReminders();
                thirdMenu = showInput.showNextRemindersMenu();
                break;

            case 2:
                showInput.deleteReminders();
                thirdMenu = showInput.showNextRemindersMenu();
                break;

            case 3:
                showInput.updateReminders();
                thirdMenu = showInput.showNextRemindersMenu();
                break;

            case 4:
                thirdMenu = -1;
                secondMenu = 0;
                break;

            case 0:
                showNextRemindersMenu();
                break;

            default:
                break;
        }
    }



    private void showConstantConsumptionMenu() {
        thirdMenu = showInput.showNextConstantConsumptionMenu();

        switch (thirdMenu) {
            case 1:
                showInput.insertConstantConsumption();
                thirdMenu = showInput.showNextConstantConsumptionMenu();
                break;

            case 2:
                showInput.deleteConstantConsumption();
                thirdMenu = showInput.showNextConstantConsumptionMenu();
                break;

            case 3:
                showInput.updateConstantConsumption();
                thirdMenu = showInput.showNextConstantConsumptionMenu();
                break;

            case 4:
                thirdMenu = -1;
                secondMenu = 0;
                break;

            case 0:
                showConstantConsumptionMenu();
                break;

            default:
                break;
        }
    }


    private void showMonthlyPermanent() {
        thirdMenu = showInput.showNextMonthlyPermanentMenu();

        switch (thirdMenu) {
            case 1:
                showInput.insertMonthlyPermanent();
                thirdMenu = showInput.showNextMonthlyPermanentMenu();
                break;

            case 2:
                showInput.deleteMonthlyPermanent();
                thirdMenu = showInput.showNextMonthlyPermanentMenu();
                break;

            case 3:
                showInput.updateMonthlyPermanent();
                thirdMenu = showInput.showNextMonthlyPermanentMenu();
                break;

            case 4:
                thirdMenu = -1;
                secondMenu = 0;
                break;

            case 0:
                showMonthlyPermanent();
                break;

            default:
                break;
        }
    }


}
