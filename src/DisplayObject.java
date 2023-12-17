package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DisplayObject {
    public static void displayCoaches(ArrayList<Coach> coaches) {
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
    public static void displayCoach(int coachId) {

    }
    public static void displayDescendingCoaches(ArrayList<CoachRecord>coachRecords,ArrayList<Coach>coaches) {
        Collections.sort(coachRecords, Comparator.comparingInt(CoachRecord::countOfCusomter).reversed());
        for (CoachRecord coachRecord :coachRecords) {
            System.out.println(Searching.searchCoach(coaches,coachRecord.coachId()));
        }
    }
    public static void displayAvailableCoaches(ArrayList<Coach>coaches,ArrayList<Subscription>subscriptions,int coachId) {
        ArrayList<Coach> coachArrayList = new ArrayList<>();
        if(Admin.getCounterOfCustomerOfSpecificCoach(subscriptions,coachId) < 10) {
            coachArrayList.add(Searching.searchCoach(coaches,coachId));
        }
        displayCoaches(coachArrayList);
    }
}