package src;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) throws Exception {

        File file = new File("E:/Files/extra/Coach");

        Equipment equipment1 = new Equipment("Treadmill","1",6);
        Equipment equipment2 = new Equipment("LegCurl","2",8);
        ArrayList<Equipment>equipments = new ArrayList<>();
        equipments.add(equipment1);
        equipments.add(equipment2);


        InBody inBody1 = new InBody(1,LocalDate.now(),1.8f,60.8f,13.4f,4.5f,65,18.4f);
        InBody inBody2 = new InBody(2,LocalDate.now(),1.5f,76.4f,7,6.4f,85,32.4f);
        ArrayList<InBody>inBodies1 = new ArrayList<>();
        inBodies1.add(inBody1);
        ArrayList<InBody>inBodies2 = new ArrayList<>();
        inBodies2.add(inBody2);


        MembershipPlan membershipPlan1 = new MembershipPlan(LocalDate.now(),6,450);
        MembershipPlan membershipPlan2 = new MembershipPlan(LocalDate.now(),3,650);
        ArrayList<MembershipPlan>membershipPlans = new ArrayList<>();
        membershipPlans.add(membershipPlan1);
        membershipPlans.add(membershipPlan2);


        Subscription subscription1 = new Subscription(1,1,membershipPlan1);
        Subscription subscription2 = new Subscription(2,2,membershipPlan2);
        ArrayList<Subscription>subscriptions= new ArrayList<>();
        subscriptions.add(subscription1);
        subscriptions.add(subscription2);


        Customer customer1 = new Customer(1,"1","Rashed",'M',"Street","015","R@gmail.com",inBodies1,subscription1);
        Customer customer2 = new Customer(2,"1","Tamer",'M',"Street","010","T@gmail.com",inBodies2,subscription2);
        ArrayList<Customer>customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);


        Coach coach1 = new Coach(1,"1","Shams",'M',"Street","015","S@gmail.com",8);
        Coach coach2 = new Coach(2,"1","Razan",'F',"Street","011","R@gmail.com",5);
        ArrayList<Coach>coaches = new ArrayList<>();
        coaches.add(coach1);
        coaches.add(coach2);


        GYM gym = new GYM("H2o","Street","01070824047",coaches,equipments,subscriptions,customers);



    }
}
