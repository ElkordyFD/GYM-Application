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
    public static Customer searchCustomer(ArrayList<Customer>customers,String name) {
        Customer customer=null;
        for (Customer c:customers) {
            if(c.getName().equals(name)) {
                customer=c;
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
        InBody inbody=new InBody();
        for (InBody inBody:inBodies) {
            if(DateFormating.dateFormatMonthYear(inBody.getDATE_OF_INBODY()).equals(date))
                inbody=inBody;
            break;
        }
        return inbody;
    }

    public static ArrayList<Customer> searchCustomers(ArrayList<Customer> customers, ArrayList<Integer> iDs) {
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        for(Integer id:iDs){
            for(Customer c:customers){
                if(id == c.getId()){
                    customerArrayList.add(c);
                }
            }
        }
        return customerArrayList;
    }
}
