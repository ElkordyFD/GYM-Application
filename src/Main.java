package src;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.lang.*;

public class Main {
    static ArrayList<Equipment> equipments = new ArrayList<>();
    static ArrayList<MembershipPlan> membershipPlans = new ArrayList<>();
    static ArrayList<Subscription> subscriptions = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Coach> coaches = new ArrayList<>();

    static GYM seed() {
        File file = new File("E:/Files/extra/Coach");


        Equipment equipment1 = new Equipment("Treadmill", "1", 6);
        Equipment equipment2 = new Equipment("LegCurl", "2", 8);
        equipments.add(equipment1);
        equipments.add(equipment2);

        InBody inBody1 = new InBody(1, LocalDate.now(), 1.8f, 60.8f, 13.4f, 4.5f, 65, 18.4f);
        InBody inBody2 = new InBody(2, LocalDate.now().minusMonths(1), 1.5f, 76.4f, 7, 6.4f, 85, 32.4f);
        InBody inBody3 = new InBody(2, LocalDate.now(), 1.6f, 75.4f, 6, 7.4f, 34, 36.4f);
        InBody inBody4 = new InBody(3, LocalDate.now(), 1.8f, 34.4f, 7, 6.4f, 85, 32.4f);
        ArrayList<InBody> inBodies1 = new ArrayList<>();
        inBodies1.add(inBody1);
        ArrayList<InBody> inBodies2 = new ArrayList<>();
        inBodies2.add(inBody2);
        inBodies2.add(inBody3);
        ArrayList<InBody> inBodies3 = new ArrayList<>();
        inBodies3.add(inBody4);

        MembershipPlan membershipPlan1 = new MembershipPlan(LocalDate.now().minusMonths(2), 6, 450);
        MembershipPlan membershipPlan2 = new MembershipPlan(LocalDate.now().minusDays(3), 3, 650);
        membershipPlans.add(membershipPlan1);
        membershipPlans.add(membershipPlan2);

        Subscription subscription1 = new Subscription(1, 1,membershipPlan1);
        Subscription subscription2 = new Subscription(2, 1,membershipPlan2);
        Subscription subscription3 = new Subscription(3, 2,membershipPlan1);
        subscriptions.add(subscription1);
        subscriptions.add(subscription2);
        subscriptions.add(subscription3);

        Customer customer1 = new Customer(1, "1", "Rashed", 'M', "Street", "015", "Rashed@gmail.com", inBodies1, subscription1);
        Customer customer2 = new Customer(2, "1", "Tamer", 'M', "Street", "010", "T@gmail.com", inBodies2, subscription2);
        Customer customer3 = new Customer(3, "1", "Raof", 'M', "Street", "010", "H@gmail.com", inBodies3, subscription3);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        Coach coach1 = new Coach(1, "1", "Shams", 'M', "Street", "015", "Shams@gmail.com", 8);
        Coach coach2 = new Coach(2, "2", "Razan", 'F', "Street", "011", "Razan@gmail.com", 5);
        coaches.add(coach1);
        coaches.add(coach2);

        GYM gym = new GYM("H2o", "Street", "01070824047", coaches, equipments, subscriptions, customers);

        return gym;
    }

    public static void main(String[] args) throws Exception {
        GYM gym = seed();
        Scanner input = new Scanner(System.in);
        int choice;
        int choiceOperation;
        int choiceObject;
        int choiceAttribute;
        int choiceFeature;
        int coachId;
        int customerId;
        int checkValue;
        int choiceCredentials;
        int choiceRegister;
        int choiceOpenion ;
        String equipmentCode;
        String date;
        String username;
        String password;
        final String admin = "admin";
        Coach userCoach;
        Customer userCustomer;
        boolean valueChecked = false;
        boolean adminChecked = false;
        do {
            choiceOpenion = 0;
            System.out.println("**************** Welcome to GYM ***************");
            System.out.println("[1].Login  [2].register");
            choiceCredentials = Validate.checkInt(1, 2);
            switch (choiceCredentials) {
                case 1:
                    do {
                        if (valueChecked)
                            System.out.println("Invalid Data!\n");
                        System.out.print("Enter username: ");
                        username = input.next();
                        System.out.print("Enter password: ");
                        password = input.next();
                        userCoach = Login.loginCoach(username, password, gym.getCoaches());
                        userCustomer = Login.loginCustomer(username, password, gym.getCustomers());
                        if (username.equals(admin) && password.equals(admin))
                            adminChecked = true;
                        else
                            adminChecked = false;
                        if (userCoach == null && userCustomer == null && adminChecked == false)
                            valueChecked = true;
                        else
                            valueChecked = false;
                    } while (valueChecked);
                    if (username.equals(admin) && password.equals(admin)) {
                        //************ ADMIN ************//
                        System.out.println("**************** Welcome Admin! ****************");
                        do {
                            System.out.println("[1] Modify\n[2] Show the subscription history for a customer\n[3] Display all the customers that subscribed to the gym in a given month/day\n[4] Display all the customers of a specific coach\n[5] Display the GYM income in a given month\n[6] Display the coaches sorted in terms of the most assigned number of customers to the coaches");
                            choiceFeature = Validate.checkInt(1, 6);
                            switch (choiceFeature) {
                                case 1:
                                    System.out.println("[1] add\n[2] edit\n[3] delete");
                                    choiceOperation = Validate.checkInt(1, 3);
                                    switch (choiceOperation) {
                                        case 1:
                                            System.out.println("[1] Coach\n[2] Customer\n[3] Equipment");
                                            choiceObject = Validate.checkInt(1, 3);
                                            switch (choiceObject) {
                                                case 1:
                                                    Admin.addCoach(gym.getCoaches());
                                                    break;
                                                case 2:
                                                    Admin.addCustomer(gym.getCustomers());
                                                    break;
                                                case 3:
                                                    Admin.addEquipment(gym.getSports_equipment());
                                                    break;
                                            }
                                            break;
                                        case 2:
                                            System.out.println("[1] Coach\n[2] Customer\n[3] Equipment");
                                            choiceObject = Validate.checkInt(1, 3);
                                            switch (choiceObject) {
                                                case 1:
                                                    DisplayObject.displayCoaches(gym.getCoaches());
                                                    System.out.print("Enter Coach's id: ");
                                                    coachId = Validate.checkInt();
                                                    Coach coach = Searching.searchCoach(gym.getCoaches(), coachId);
                                                    if (coach != null) {
                                                        System.out.println("[1] id\n[2] password\n[3] name\n[4] gender\n[5] address\n[6] phoneNumber\n[7] email\n[8] workingHours");
                                                        System.out.print("Enter attribute you will modify: ");
                                                        choiceAttribute = input.nextInt();
                                                        Admin.modify(coach, choiceAttribute, gym.getSubscriptions(), coachId);
                                                        DisplayObject.displayCoaches(gym.getCoaches());
                                                    } else
                                                        System.out.println("there isn't Coach with this id");
                                                    break;
                                                case 2:
                                                    DisplayObject.displayCustomers(gym.getCustomers());
                                                    System.out.print("Enter Customer's id: ");
                                                    customerId = Validate.checkInt();
                                                    Customer customer = Searching.searchCustomer(gym.getCustomers(), customerId);
                                                    if (customer != null) {
                                                        System.out.println("[1] id\n[2] password\n[3] name\n[4] gender\n[5] address\n[6] phoneNumber\n[7] email");
                                                        choiceAttribute = Validate.checkInt(1, 7);
                                                        Admin.modify(customer, choiceAttribute);
                                                        DisplayObject.displayCustomers(gym.getCustomers());
                                                    } else
                                                        System.out.println("there isn't Customer with this id");
                                                    break;
                                                case 3:
                                                    DisplayObject.displayEquipments(gym.getSports_equipment());
                                                    System.out.print("Enter Equipment's code: ");
                                                    equipmentCode = input.next();
                                                    Equipment equipment = Searching.searchEquipment(gym.getSports_equipment(), equipmentCode);
                                                    if (equipment != null) {
                                                        System.out.println("[1] name\n[2] code\n[3] quantity");
                                                        System.out.print("Enter attribute you will modify: ");
                                                        choiceAttribute = Validate.checkInt(1, 3);
                                                        Admin.modify(equipment, choiceAttribute);
                                                    } else
                                                        System.out.println("there isn't any equipment with this code");
                                                    break;
                                            }
                                            break;
                                        case 3:
                                            System.out.println("[1] Coach\n[2] Customer\n[3] Equipment");
                                            choiceObject = Validate.checkInt(1, 3);
                                            switch (choiceObject) {
                                                case 1:
                                                    DisplayObject.displayCoaches(gym.getCoaches());
                                                    System.out.print("Enter Coach's id: ");
                                                    coachId = Validate.checkInt();
                                                    Coach coach = Searching.searchCoach(gym.getCoaches(), coachId);
                                                    if (coach != null)
                                                        Admin.delete(coach, gym.getCoaches());
                                                    else
                                                        System.out.println("there isn't Coach with this id");
                                                    break;
                                                case 2:
                                                    DisplayObject.displayCustomers(gym.getCustomers());
                                                    System.out.print("Enter Customer's id: ");
                                                    customerId = Validate.checkInt();
                                                    Customer customer = Searching.searchCustomer(gym.getCustomers(), customerId);
                                                    if (customer != null)
                                                        Admin.delete(customer, gym.getCustomers());
                                                    else
                                                        System.out.println("there isn't Customer with this id");
                                                    break;
                                                case 3:
                                                    DisplayObject.displayEquipments(gym.getSports_equipment());
                                                    System.out.print("Enter Equipment's code: ");
                                                    equipmentCode = input.next();
                                                    Equipment equipment = Searching.searchEquipment(gym.getSports_equipment(), equipmentCode);
                                                    if (equipment != null)
                                                        Admin.delete(equipment, gym.getSports_equipment());
                                                    else
                                                        System.out.println("there isn't any equipment with this code");
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
                                    Admin.showCoachesAssignedCustomer(gym.getSubscriptions(),gym.getCoaches());
                                    break;
                            }
                            System.out.println("Do you want to do another operation?\n" + "[1] yes [2] logOut");
                            checkValue = Validate.checkInt(1, 2);
                        } while (checkValue == 1);
                        // ************* the end of Admin ************** //
                    } else if (userCustomer != null) {
                        /* ************* Customer ************* */
                        System.out.println("\nWelcome " + userCustomer.getName() + "\n");
                        do {
                            System.out.println("[1] Get Coach Info\n[2] Gym Equipment\n[3] Membership's Plan\n[4] In-body Info\n[5] Kilos Required");
                            choiceOperation = Validate.checkInt(1, 5);
                            switch (choiceOperation) {
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
                            checkValue = Validate.checkInt(1, 2);
                        } while (checkValue == 1);
                    } else if (userCoach != null) {
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
                            checkValue = Validate.checkInt(1, 2);
                        } while (checkValue == 1);
                    }
                    break;
                case 2:
                    /******* register *******/
                    System.out.println("[1] Coach\n[2] Customer");
                    choiceRegister = Validate.checkInt(1, 2);
                    switch (choiceRegister) {
                        case 1:
                            Register.registerCoach(gym.getCoaches());
                            break;
                        case 2:
                            Register.registerCustomer(gym.getCustomers());
                            break;
                    }
                    System.out.println("Registered done");
                    System.out.println("[1] back to menu   [2] exit program");
                    choiceOpenion = Validate.checkInt(1,2);
            }
        } while (choiceOpenion == 1);
    }
}
