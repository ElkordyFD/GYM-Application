package src;

import java.util.ArrayList;
import java.util.Date;

public class Searching {
    public static Coach searchCoach(ArrayList<Coach>coaches,int coachId) {
        Coach coach=null;
        for (Coach c:coaches) {
            if(c.getId()==coachId) {
                coach=c;
                break;
            }
        }
        return coach;
    }
    public static Customer searchCustomer(ArrayList<Customer>customers,int customerId) {
        Customer customer=null;
        for (Customer c:customers) {
            if(c.getId()==customerId) {
                customer=c;
                break;
            }
        }
        return customer;
    }
    public static ArrayList<Customer>searchCustomer(ArrayList<Customer>customers,String name) {
        ArrayList<Customer> customer=new ArrayList<>();
        for (Customer c:customers) {
            if(c.getName().equals(name)) {
                customer.add(c);
                break;
            }
        }
        return customer;
    }
    public static ArrayList<Customer> searchCustomer(ArrayList<Customer>customers, char gender) {
        ArrayList<Customer> customer=new ArrayList<>();
        for (Customer c:customers) {
            if(c.getGender()==gender) {
                customer.add(c);
            }
        }
        return customer;
    }
    public static Equipment searchEquipment(ArrayList<Equipment>equipments,String equipmentCode) {
        Equipment equipment=null;
        for (Equipment e:equipments) {
            if(e.getCode().equals(equipmentCode)) {
                equipment=e;
                break;
            }
        }
        return equipment;
    }
    public static InBody searchInBody(ArrayList<InBody> inBodies, String date) {
        InBody inbody=null;
        for (InBody inBody:inBodies) {
            if(DateFormating.dateFormatMonthYear(inBody.getDATE_OF_INBODY()).equals(date)) {
                inbody = inBody;
                break;
            }
        }
        return inbody;
    }

    public static ArrayList<Customer> searchCustomers(ArrayList<Customer> customers,int coachId) {
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        for(Customer customer : customers){
            if(customer.getSubscription().getAssignedCoachID()==coachId)
                customerArrayList.add(customer);
        }
        return customerArrayList;
    }
    public static Customer searchCustomer(String username, String password, ArrayList<Customer> customers) {
        Customer customer = null;
        for (Customer c:customers) {
            if(c.getEmail().equals(username) && c.getPassword().equals(password)) {
                customer=c;
                break;
            }
        }
        return customer;
    }

    public static Coach searchCoach(String username, String password, ArrayList<Coach> coaches) {
        Coach coach = null;
        for (Coach c:coaches) {
            if(c.getEmail().equals(username) && c.getPassword().equals(password)) {
                coach=c;
                break;
            }
        }
        return coach;
    }
}