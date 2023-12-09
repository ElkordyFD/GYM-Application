package src;

import java.util.ArrayList;

public class DisplayObject {
    public static void displayCoachs(ArrayList<Coach> coaches) {
        for (Coach o:coaches) {
            System.out.println(o);
        }
    }
    public static void displayCustomers(ArrayList<Customer> customers) {
        for (Customer customer:customers) {
            System.out.println(customer);
        }
    }
    public static void displayEquipments(ArrayList<Equipment> equipments) {
        for (Equipment equipment:equipments) {
            System.out.println(equipment);
        }
    }
    public static void displayMembershipPlan(MembershipPlan membershipPlan) {
        System.out.println(membershipPlan);
    }
    public static void displayInBody(ArrayList<InBody>inBodies) {
        for (InBody inBody:inBodies) {
            System.out.println(inBody);
        }
    }
}