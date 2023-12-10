package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class InputObject {
    public static Coach inputCoach() {
        int id,workingHours;
        String password,name,address,phoneNumber,email;
        char gender;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter id: ");
        id=input.nextInt();
        System.out.println("Enter password: ");
        password=input.next();
        System.out.println("Enter name: ");
        name=input.next();
        System.out.println("Enter gender: ");
        gender=input.next().charAt(0);
        System.out.println("Enter address: ");
        address=input.next();
        System.out.println("Enter phoneNumber: ");
        phoneNumber=input.next();
        System.out.println("Enter email: ");
        email=input.next();
        System.out.println("Enter workingHours: ");
        workingHours=input.nextInt();
        Coach coach = new Coach(id,password,name,gender,address,phoneNumber,email,workingHours);
        return coach;
    }
    public static Equipment inputEquipment() {
        String name;
        String code;
        int quantity;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name: ");
        name=input.next();
        System.out.println("Enter code: ");
        code=input.next();
        System.out.println("Enter quantity: ");
        quantity=input.nextInt();
        Equipment equipment = new Equipment(name,code,quantity);
        return equipment;
    }
    public static Customer inputCustomer() {
        ArrayList<InBody> inBody=null;
        Subscription subscription=new Subscription();
        MembershipPlan membershipPlan=new MembershipPlan();
        int id,coachId,months;
        String password,name,address,phoneNumber,email;
        char gender;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter id: ");
        id=input.nextInt();
        subscription.setCustomerID(id);
        System.out.println("Enter Coach's id: ");
        coachId=input.nextInt();
        subscription.setAssignedCoachID(coachId);
        System.out.println("Enter register months: ");
        months = input.nextInt();
        membershipPlan.setRegisteredMonths(months);
        if(months>3)
            membershipPlan.setPrice(400);
        else
            membershipPlan.setPrice(500);
        membershipPlan.setStartDate(LocalDate.now());
        subscription.setMembershipPlan(membershipPlan);
        System.out.println("Enter name: ");
        name=input.next();
        System.out.println("Enter address: ");
        address=input.next();
        System.out.println("Enter phoneNumber: ");
        phoneNumber=input.next();
        System.out.println("Enter email: ");
        email=input.next();
        System.out.println("Enter password: ");
        password=input.next();
        System.out.println("Enter gender: ");
        gender=input.next().charAt(0);
        subscription.setMembershipPlan(membershipPlan);
        Customer customer = new Customer(id,password,name,gender,address,phoneNumber,email,inBody,subscription);
        return customer;
    }
}
