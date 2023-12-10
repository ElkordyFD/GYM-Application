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

    static void seed() {
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

        MembershipPlan membershipPlan1 = new MembershipPlan(LocalDate.now(), 6, 450);
        MembershipPlan membershipPlan2 = new MembershipPlan(LocalDate.now(), 3, 650);
        membershipPlans.add(membershipPlan1);
        membershipPlans.add(membershipPlan2);

        Subscription subscription1 = new Subscription(1, 1, membershipPlan1);
        Subscription subscription3 = new Subscription(3, 1, membershipPlan1);
        Subscription subscription2 = new Subscription(2, 2, membershipPlan2);
        subscriptions.add(subscription1);
        subscriptions.add(subscription2);
        subscriptions.add(subscription3);

        Customer customer1 = new Customer(1, "1", "Rashed", 'M', "Street", "015", "R@gmail.com", inBodies1, subscription1);
        Customer customer2 = new Customer(2, "1", "Tamer", 'M', "Street", "010", "T@gmail.com", inBodies2, subscription2);
        Customer customer3 = new Customer(3, "1", "Shams", 'M', "Street", "010", "H@gmail.com", inBodies2, subscription2);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        Coach coach1 = new Coach(1, "1", "Shams", 'M', "Street", "015", "S@gmail.com", 8);
        Coach coach2 = new Coach(2, "1", "Razan", 'F', "Street", "011", "R@gmail.com", 5);
        coaches.add(coach1);
        coaches.add(coach2);

        GYM gym = new GYM("H2o", "Street", "01070824047", coaches, equipments, subscriptions, customers);


    }

    public static void main(String[] args) throws Exception {
        seed();
        //THIS IS TEMPORARY UNTIL LOGIN IS APPLIED
        System.out.println("[1] Admin\n[2] Customer\n[3] Coach\n");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice){
            case 1:
                //ADMIN
                break;
            case 2:
                //CUSTOMER
                break;
            case 3:
                Coach user = coaches.get(0);
                ArrayList<Integer> iDs = user.getCustomerIDs(subscriptions);
                //System.out.println(Searching.searchCustomers(customers,iDs));
                DisplayObject.displayCustomers(Searching.searchCustomers(customers,iDs));
                /*System.out.println(
                        "\n\n[1] Show customers\n" +
                        "[2] Get inbody history of a customer\n" +
                                "[3] Search for customer by name\n" +
                                "[4] Show customers by gender");*/
                break;
        }
    }
}
