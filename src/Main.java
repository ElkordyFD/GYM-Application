package src;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.lang.*;

public class Main {
    public static void gymApplication(GYM gym) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            choice = 0;
            System.out.println("**************** Welcome to GYM ***************");
            System.out.println("[1].Login  [2].register [3] exit program");
            choice = Validate.checkInt(1, 3);
            switch (choice) {
                case 1:
                    Object object = Login.login(gym.getCustomers(),gym.getCoaches());
                    if (object instanceof String) {
                        //************ ADMIN ************//
                        System.out.println("**************** Welcome Admin! ****************");
                        do {
                            System.out.println("[1] Modify\n[2] Show the subscription history for a customer\n[3] Display all the customers that subscribed to the gym in a given month/day\n[4] Display all the customers of a specific coach\n[5] Display the GYM income in a given month\n[6] Display the coaches sorted in terms of the most assigned number of customers to the coaches");
                            choice = Validate.checkInt(1, 6);
                            switch (choice) {
                                case 1:
                                    System.out.println("[1] add\n[2] edit\n[3] delete");
                                    choice = Validate.checkInt(1, 3);
                                    switch (choice) {
                                        case 1:
                                            System.out.println("[1] Coach\n[2] Customer\n[3] Equipment");
                                            choice = Validate.checkInt(1, 3);
                                            switch (choice) {
                                                case 1:
                                                    Admin.addCoach(gym.getCoaches());
                                                    break;
                                                case 2:
                                                    Admin.addCustomer(gym.getCustomers(),gym.getCoaches());
                                                    break;
                                                case 3:
                                                    Admin.addEquipment(gym.getSports_equipment());
                                                    break;
                                            }
                                            break;
                                        case 2:
                                            System.out.println("[1] Coach\n[2] Customer\n[3] Equipment");
                                            choice = Validate.checkInt(1, 3);
                                            switch (choice) {
                                                case 1:
                                                    Admin.modify(gym.getSubscriptions(),gym.getCoaches());
                                                    break;
                                                case 2:
                                                    Admin.modify(gym.getCustomers());
                                                    break;
                                                case 3:
                                                    Admin.modifyEquipment(gym.getSports_equipment());
                                                    break;
                                            }
                                            break;
                                        case 3:
                                            System.out.println("[1] Coach\n[2] Customer\n[3] Equipment");
                                            choice = Validate.checkInt(1, 3);
                                            switch (choice) {
                                                case 1:
                                                    Admin.deleteCoach(gym.getCoaches());
                                                    break;
                                                case 2:
                                                    Admin.deleteCustomer(gym.getCustomers());
                                                    break;
                                                case 3:
                                                    Admin.deleteEquipment(gym.getSports_equipment());
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                                case 2:
                                    Admin.showSubscriptionHistoryForACustomer(gym.getCustomers());
                                    break;
                                case 3:
                                    Admin.getCustomerInSpecificDate(gym.getCustomers());
                                    break;
                                case 4:
                                    Admin.showCustomerOfSpecificCoach(gym.getSubscriptions(), gym.getCustomers());
                                    break;
                                case 5:
                                    Admin.showGymIncomeInSpecificMonth(gym.getCustomers());
                                    break;
                                case 6:
                                    Admin.showCoachesAssignedCustomer(gym.getCustomers(),gym.getCoaches());
                                    break;
                            }
                            System.out.println("Do you want to do another operation?\n" + "[1] yes [2] logOut");
                            choice = Validate.checkInt(1,2);
                            if (choice == 2)
                                gymApplication(gym);
                        } while (choice == 1);
                        // ************* the end of Admin ************** //
                    } else if (object instanceof Customer) {
                        Customer userCustomer = (Customer) object;
                        /* ************* Customer ************* */
                        System.out.println("\nWelcome " + userCustomer.getName() + "\n");
                        do {
                            System.out.println("[1] Get Coach Info\n[2] Gym Equipment\n[3] Membership's Plan\n[4] In-body Info\n[5] Kilos Required");
                            choice = Validate.checkInt(1, 5);
                            switch (choice) {
                                case 1:
                                    Coach coach = Searching.searchCoach(gym.getCoaches(), userCustomer.getSubscription().getAssignedCoachID());
                                    userCustomer.printCoachInfo(coach);
                                    break;
                                case 2:
                                    DisplayObject.displayEquipments(gym.getSports_equipment());
                                    break;
                                case 3:
                                    System.out.println(userCustomer.getSubscription().getMembershipPlan());
                                    break;
                                case 4:
                                    userCustomer.printInbodyInfo(userCustomer.getInBodies());
                                    break;
                                case 5:
                                    userCustomer.CaculatePerfectWeight(userCustomer);
                                    break;
                            }
                            System.out.println("Do you want to do another operation?\n" + "[1] yes [2] logOut");
                            choice = Validate.checkInt(1, 2);
                            if (choice == 2)
                                gymApplication(gym);
                        } while (choice == 1);
                    } else if (object instanceof Coach) {
                        Coach userCoach = (Coach) object;
                        //************ COACH ************//
                        do {
                            System.out.println(
                                    "\n" +
                                            "[1] show a list of all my customer\n"+
                                            "[2] Get inbody history of a customer\n" +
                                            "[3] Search for customer by name\n" +
                                            "[4] Show customers by gender");
                            choice = Validate.checkInt(1, 4);
                            switch (choice) {
                                case 1:
                                    userCoach.showMyCustomer(gym.getCustomers(),userCoach.getId());
                                    break;
                                case 2:
                                    userCoach.printInbodyHistoryforSpecificCustomer(gym.getCustomers(),userCoach.getId());
                                    break;
                                case 3:
                                    userCoach.printDetailsOfSpecificCustomerByName(gym.getCustomers(),userCoach.getId());
                                    break;
                                case 4:
                                    userCoach.showCustomersByGender(gym.getCustomers(),userCoach.getId());
                                    break;
                            }
                            System.out.println("Do you want to do another operation?\n" + "[1] yes [2] logOut");
                            choice = Validate.checkInt(1, 2);
                            if(choice == 2)
                                gymApplication(gym);
                        } while (choice == 1);
                    }
                    break;
                case 2:
                    /******* register *******/
                    System.out.println("[1] Coach\n[2] Customer");
                    choice = Validate.checkInt(1, 2);
                    switch (choice) {
                        case 1:
                            Register.registerCoach(gym.getCoaches());
                            break;
                        case 2:
                            Register.registerCustomer(gym.getCustomers(),gym.getCoaches());
                            break;
                    }
                    System.out.println("Registered done");
                    System.out.println("[1] back to menu   [2] exit program");
                    choice = Validate.checkInt(1,2);
            }
        } while (choice == 1);
    }
    public static void main(String[] args) throws Exception {
        File file = new File("E:/Gym.java");
        GYM gym =(GYM) FileReading.read(file);
        gymApplication(gym);
        FileWriting.write(file,gym);
    }
}