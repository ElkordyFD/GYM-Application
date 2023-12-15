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
        InBody inBody2 = new InBody(2, LocalDate.now(), 1.5f, 76.4f, 7, 6.4f, 85, 32.4f);
        ArrayList<InBody> inBodies1 = new ArrayList<>();
        inBodies1.add(inBody1);
        ArrayList<InBody> inBodies2 = new ArrayList<>();
        inBodies2.add(inBody2);

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
        Customer customer3 = new Customer(3, "1", "Raof", 'M', "Street", "010", "H@gmail.com", inBodies2, subscription3);
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
        String equipmentCode;
        String date;
        String username;
        String password;

        System.out.println("**************** Welcome to GYM ***************");

        System.out.print("Enter username: ");
        username = input.next();
        System.out.print("Enter password: ");
        password = input.next();
        Coach userCoach = Login.loginCoach(username,password,gym.getCoaches());
        Customer userCustomer = Login.loginCustomer(username,password,gym.getCustomers());
        if (username.equals("admin") && password.equals("admin")) {
            //************ ADMIN ************//
            System.out.println("**************** Welcome Admin! ****************");
            System.out.println("[1] Modify\n[2] Show the subscription history for a customer\n[3] Display all the customers that subscribed to the gym in a given month/day\n[4] Display all the customers of a specific coach\n[5] Display the GYM income in a given month\n[6] Display the coaches sorted in terms of the most assigned number of customers to the coaches");
            System.out.print("Enter feature: ");
            choiceFeature = input.nextInt();
            switch (choiceFeature) {
                case 1:
                    System.out.println("[1] add\n[2] edit\n[3] delete");
                    System.out.print("Enter operation: ");
                    choiceOperation = input.nextInt();
                    switch (choiceOperation) {
                        case 1:
                            System.out.println("[1] Coach\n[2] Customer\n[3] Equipment");
                            System.out.print("Enter entity: ");
                            choiceObject = input.nextInt();
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
                            System.out.print("Enter entity: ");
                            choiceObject = input.nextInt();
                            switch (choiceObject) {
                                case 1:
                                    DisplayObject.displayCoaches(gym.getCoaches());
                                    System.out.print("Enter Coach's id: ");
                                    coachId = input.nextInt();
                                    Coach coach = Searching.searchCoach(gym.getCoaches(), coachId);
                                    System.out.println("[1] id\n[2] password\n[3] name\n[4] gender\n[5] address\n[6] phoneNumber\n[7] email\n[8] workingHours");
                                    System.out.print("Enter attribute you will modify: ");
                                    choiceAttribute = input.nextInt();
                                    Admin.modify(coach, choiceAttribute, gym.getSubscriptions(), coachId);
                                    DisplayObject.displayCoaches(gym.getCoaches());
                                    break;
                                case 2:
                                    DisplayObject.displayCustomers(gym.getCustomers());
                                    System.out.print("Enter Customer's id: ");
                                    customerId = input.nextInt();
                                    Customer customer = Searching.searchCustomer(gym.getCustomers(), customerId);
                                    System.out.println("[1] id\n[2] password\n[3] name\n[4] gender\n[5] address\n[6] phoneNumber\n[7] email");
                                    System.out.print("Enter attribute you will modify: ");
                                    choiceAttribute = input.nextInt();
                                    Admin.modify(customer, choiceAttribute);
                                    DisplayObject.displayCustomers(gym.getCustomers());
                                    break;
                                case 3:
                                    DisplayObject.displayEquipments(gym.getSports_equipment());
                                    System.out.print("Enter Equipment's code: ");
                                    equipmentCode = input.next();
                                    Equipment equipment = Searching.searchEquipment(gym.getSports_equipment(), equipmentCode);
                                    System.out.println("[1] name\n[2] code\n[3] quantity");
                                    System.out.print("Enter attribute you will modify: ");
                                    choiceAttribute = input.nextInt();
                                    Admin.modify(equipment, choiceAttribute);
                                    DisplayObject.displayEquipments(gym.getSports_equipment());
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("[1] Coach\n[2] Customer\n[3] Equipment");
                            System.out.print("Enter entity: ");
                            choiceObject = input.nextInt();
                            switch (choiceObject) {
                                case 1:
                                    DisplayObject.displayCoaches(gym.getCoaches());
                                    System.out.print("Enter Coach's id: ");
                                    coachId = input.nextInt();
                                    Coach coach = Searching.searchCoach(gym.getCoaches(), coachId);
                                    Admin.delete(coach, gym.getCoaches());
                                    break;
                                case 2:
                                    DisplayObject.displayCustomers(gym.getCustomers());
                                    System.out.print("Enter Customer's id: ");
                                    customerId = input.nextInt();
                                    Customer customer = Searching.searchCustomer(gym.getCustomers(), customerId);
                                    Admin.delete(customer, gym.getCustomers());
                                    break;
                                case 3:
                                    DisplayObject.displayEquipments(gym.getSports_equipment());
                                    System.out.print("Enter Equipment's code: ");
                                    equipmentCode = input.next();
                                    Equipment equipment = Searching.searchEquipment(gym.getSports_equipment(), equipmentCode);
                                    Admin.delete(equipment, gym.getSports_equipment());
                                    break;
                                default:

                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Enter customer's id: ");
                    customerId = input.nextInt();
                    System.out.println(Admin.getSubscriptionHistoryForACustomer(gym.getCustomers(), customerId));
                    break;
                case 3:
                    System.out.print("Enter the date: ");
                    date = input.next();
                    DisplayObject.displayCustomers(Admin.getCustomerInSpecificDate(gym.getCustomers(), date));
                    break;
                case 4:
                    System.out.print("Enter Coach's id: ");
                    coachId = input.nextInt();
                    DisplayObject.displayCustomers(Admin.getCustomerOfSpecificCoach(gym.getSubscriptions(), gym.getCustomers(), coachId));
                    break;
                case 5:
                    System.out.println("Enter the date: ");
                    date = input.next();
                    System.out.println(Admin.getGymIncome(gym.getCustomers(), date));
                    break;
                case 6:
                    ArrayList<CoachRecord> coachRecords = Admin.getDescendingCoaches(gym.getSubscriptions(), gym.getCoaches());
                    Admin.getCoachesAssignedCustomer(coachRecords, gym.getCoaches());
                    break;
            }
            // ********* the end of Admin *********** //
            } else if (userCustomer != null) {
                System.out.println("[1] Get Coach Info\n[2] Gym Equipment\n[3] Membership's Plan\n[4] In-body Info\n[5] Kilos Required");
                System.out.print("Enter Operation: ");
                choiceOperation = input.nextInt();
                switch (choiceOperation) {
                    case 1:
                        Coach coach = Searching.searchCoach(gym.getCoaches(),userCustomer.getSubscription().getAssignedCoachID());
                        userCustomer.getCoachInfo(coach);
                        break;
                    case 2:
                        DisplayObject.displayEquipments(gym.getSports_equipment());
                        break;
                    case 3:
                        System.out.println(userCustomer.getSubscription().getMembershipPlan());
                        break;
                    case 4:
                        System.out.print("Enter date: ");
                        date = input.next();
                        userCustomer.getInbodyInfo(date,userCustomer.getInBodies());
                        break;
                    case 5:
                        userCustomer.CaculatePerfectWeight(userCustomer);
                }
            } else if (userCoach != null) {
                //************ COACH ************//
                ArrayList<Customer> myCustomers = Searching.searchCustomers(gym.getCustomers(),userCoach.getId());
                System.out.println(
                        "\n" +
                                "[1] Get inbody history of a customer\n" +
                                "[2] Search for customer by name\n" +
                                "[3] Show customers by gender");
                choice = Validate.getInt(1, 3);
                ArrayList<Customer> customerArrayList = new ArrayList<>();
                int customerID;
                String name;
                Customer c;
                char gender;
                switch (choice) {
                    case 1:
                        System.out.print("Enter customer ID: ");
                        customerID = input.nextInt();
                        c = Searching.searchCustomer(myCustomers, customerID);
                        DisplayObject.displayInBody(c.getInBodies());
                        break;
                    case 2:
                        System.out.print("Enter customer name: ");
                        name = input.next();
                        c = Searching.searchCustomer(myCustomers, name);
                        customerArrayList.add(c);
                        DisplayObject.displayCustomers(customerArrayList);
                        break;
                    case 3:
                        System.out.print("Enter gender(M/F): ");
                        gender = Validate.getGender();
                        customerArrayList = Searching.searchCustomer(myCustomers, gender);
                        DisplayObject.displayCustomers(customerArrayList);
                        break;
                }
        }
    }
}
