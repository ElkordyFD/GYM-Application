package src;

import java.awt.image.AreaAveragingScaleFilter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    private final String username = "admin";

    private final String password = "admin";
    static private String pass;
    static private String name;
    static private char gender;
    static private String address;
    static private String phoneNumber;
    static private String email;
    static Scanner input = new Scanner(System.in);

    public static void addCoach(ArrayList<Coach> coaches) {
        int workingHours;
        int idCoach = generateCoachID(coaches);
        boolean checkWorkingHours = false;
        boolean checkEmail = false;
        System.out.print("Enter password: ");
        pass = input.next();
        System.out.print("Enter name: ");
        name = input.next();
        System.out.print("Enter gender: ");
        gender = Validate.getGender();
        System.out.print("Enter address: ");
        address = input.next();
        System.out.print("Enter phoneNumber: ");
        phoneNumber = input.next();
        do {
            if (checkEmail)
                System.out.println("Invalid email, the email must have '@' and '.com' ");
            System.out.print("Enter email: ");
            email = input.next();
            if(email.contains("@") && email.contains(".com"))
                checkEmail = false;
            else {
                checkEmail = true;
            }
        } while (checkEmail);
        do {
            if(checkWorkingHours)
                System.out.println("Invalid data");
            workingHours = Validate.checkInt(1,8);
            if (workingHours>8) {
                System.out.println("The Coach work not exceed 8 hours");
                checkWorkingHours = true;
            } else
                checkWorkingHours = false;
        } while (checkWorkingHours);
        Coach coach = new Coach(idCoach, pass, name, gender, address, phoneNumber, email, workingHours);
        coaches.add(coach);
    }

    public static void addCustomer(ArrayList<Customer> customers,ArrayList<Coach>coaches) {
        int idCustomer = generateCustomerID(customers);
        int idCoach;
        int registeredMonth;
        int price;
        int choice;
        ArrayList<InBody> inBodies = new ArrayList<>();
        boolean checkEmail = false;
        do {
            if (checkEmail)
                System.out.println("Invalid email, the email must have '@' and '.com' ");
            System.out.print("Enter email: ");
            email = input.next();
            if(email.contains("@") && email.contains(".com"))
                checkEmail = false;
            else {
                checkEmail = true;
            }
        } while (checkEmail);
        System.out.print("Enter password: ");
        pass = input.next();
        System.out.print("Enter name: ");
        name = input.next();
        System.out.print("Enter gender: ");
        gender = Validate.getGender();
        System.out.print("Enter address: ");
        address = input.next();
        System.out.print("Enter phoneNumber: ");
        phoneNumber = input.next();
        DisplayObject.displayCoaches(coaches);
        do {
            System.out.print("Enter coach id: ");
            idCoach = Validate.checkInt();
        } while(getCounterOfCustomerOfSpecificCoach(customers, idCoach) > 10);
        System.out.println("Enter membershipPLan Data");
        System.out.print("Enter registeredMonth: ");
        registeredMonth = Validate.checkInt();
        System.out.println("Enter plan");
        System.out.println("[1].3days plan   [2].6days plan");
        choice = Validate.checkInt(1,2);
        if(registeredMonth < 3) {
            price = registeredMonth*200;
        } else {
            price = (registeredMonth*200)-((int)((registeredMonth*200)*(0.2)));
        }
        MembershipPlan membershipPlan = new MembershipPlan(LocalDate.now(),registeredMonth,price);
        Subscription subscription = new Subscription(idCustomer,idCoach,membershipPlan);
        Customer customer = new Customer(idCustomer, pass, name, gender, address, phoneNumber, email, inBodies, subscription);
        customers.add(customer);
    }

    public static void addEquipment(ArrayList<Equipment> equipments) {
        String name;
        String code;
        int quantity;
        System.out.print("Enter name: ");
        name = input.next();
        System.out.print("Enter code: ");
        code = input.next();
        System.out.print("Enter quantity: ");
        quantity = Validate.checkInt();
        Equipment equipment = new Equipment(name, code, quantity);
        equipments.add(equipment);
    }

    public static void modify(ArrayList<Subscription> subscriptions,ArrayList<Coach>coaches) {
        int choiceAttribute = 0;
        int coachId;
        DisplayObject.displayCoaches(coaches);
        System.out.print("Enter Coach's id: ");
        coachId = Validate.checkInt();
        Coach coach = Searching.searchCoach(coaches, coachId);
        if (coach != null) {
            System.out.println("[1] id\n[2] password\n[3] name\n[4] gender\n[5] address\n[6] phoneNumber\n[7] email\n[8] workingHours");
            choiceAttribute = Validate.checkInt(1,8);
        } else
            System.out.println("there is no Coach with this id");
        switch (choiceAttribute) {
            case 1:
                System.out.println("Enter new id: ");
                int newId = Validate.checkInt();
                for (Subscription subscription : subscriptions) {
                    if (subscription.getAssignedCoachID() == coachId)
                        subscription.setAssignedCoachID(newId);
                }
                (coach).setId(newId);
                break;
            case 2:
                System.out.println("Enter new password: ");
                String password = input.next();
                (coach).setPassword(password);
                break;
            case 3:
                System.out.println("Enter new name: ");
                String name = input.next();
                (coach).setName(name);
                break;
            case 4:
                System.out.println("Enter new gender: ");
                char gender = Validate.getGender();
                (coach).setGender(gender);
                break;
            case 5:
                System.out.println("Enter new address: ");
                String address = input.next();
                (coach).setAddress(address);
                break;
            case 6:
                System.out.println("Enter new phoneNumber: ");
                String phoneNumber = input.next();
                (coach).setPhoneNumber(phoneNumber);
                break;
            case 7:
                System.out.println("Enter new email: ");
                String email = input.next();
                (coach).setEmail(email);
                break;
            case 8:
                System.out.println("Enter new WorkingHours: ");
                int workingHours = Validate.checkInt(1,8);
                (coach).setWorkingHoursPerDay(workingHours);
                break;
        }
    }

    public static void modify(ArrayList<Customer> customers) {
        int choiceAttribute = 0;
        DisplayObject.displayCustomers(customers);
        System.out.print("Enter Customer's id: ");
        int customerId = Validate.checkInt();
        Customer customer = Searching.searchCustomer(customers, customerId);
        if (customer != null) {
            System.out.println("[1] id\n[2] password\n[3] name\n[4] gender\n[5] address\n[6] phoneNumber\n[7] email");
            choiceAttribute = Validate.checkInt(1, 7);
        } else
            System.out.println("there is no Customer with this id");
        switch (choiceAttribute) {
            case 1:
                System.out.println("Enter new id: ");
                int newId = Validate.checkInt();
                (customer).setId(newId);
                (customer).getSubscription().setCustomerID(newId);
                break;
            case 2:
                System.out.println("Enter new password: ");
                String password = input.next();
                (customer).setPassword(password);
                break;
            case 3:
                System.out.println("Enter new name: ");
                String name = input.next();
                (customer).setName(name);
                break;
            case 4:
                System.out.println("Enter new gender: ");
                char gender = Validate.getGender();
                (customer).setGender(gender);
                break;
            case 5:
                System.out.println("Enter new address: ");
                String address = input.next();
                (customer).setAddress(address);
                break;
            case 6:
                System.out.println("Enter new phoneNumber: ");
                String phoneNumber = input.next();
                (customer).setPhoneNumber(phoneNumber);
                break;
            case 7:
                System.out.println("Enter new email: ");
                String email = input.next();
                (customer).setEmail(email);
                break;
            case 8:
        }
    }

    public static void modifyEquipment(ArrayList<Equipment>equipments) {
        int choiceAttribute = 0;
        DisplayObject.displayEquipments(equipments);
        System.out.print("Enter Equipment's code: ");
        String equipmentCode = input.next();
        Equipment equipment = Searching.searchEquipment(equipments , equipmentCode);
        if (equipment != null) {
            System.out.println("[1] name\n[2] code\n[3] quantity");
            choiceAttribute = Validate.checkInt(1, 3);
        } else
            System.out.println("there is no any equipment with this code");
        switch (choiceAttribute) {
            case 1:
                System.out.println("Enter new name: ");
                String name = input.next();
                (equipment).setName(name);
                break;
            case 2:
                System.out.println("Enter new code: ");
                String code = input.next();
                (equipment).setCode(code);
                break;
            case 3:
                System.out.println("Enter new quantity: ");
                int quantity = Validate.checkInt();
                (equipment).setQuantity(quantity);
                break;
        }
    }

    public static void deleteCoach(ArrayList<Coach> coaches) {
        DisplayObject.displayCoaches(coaches);
        System.out.print("Enter Coach's id: ");
        int coachId = Validate.checkInt();
        Coach coach = Searching.searchCoach(coaches, coachId);
        if (coach != null)
            coaches.remove(coach);
        else
            System.out.println("there is no Coach with this id");
    }

    public static void deleteCustomer(ArrayList<Customer> customers) {
        DisplayObject.displayCustomers(customers);
        System.out.print("Enter Customer's id: ");
        int customerId = Validate.checkInt();
        Customer customer = Searching.searchCustomer(customers,customerId);
        if (customer != null)
            customers.remove(customer);
        else
            System.out.println("there isn't Customer with this id");
    }

    public static void deleteEquipment(ArrayList<Equipment> equipments) {
        DisplayObject.displayEquipments(equipments);
        System.out.print("Enter Equipment's code: ");
        String equipmentCode = input.next();
        Equipment equipment = Searching.searchEquipment(equipments, equipmentCode);
        if (equipment != null)
            equipments.remove(equipment);
        else
            System.out.println("there isn't any equipment with this code");
    }

    public static void showSubscriptionHistoryForACustomer(ArrayList<Customer> customers) {
        System.out.print("Enter customer's id: ");
        int customerId = Validate.checkInt();
        Customer customer = (Searching.searchCustomer(customers, customerId));
        if(customer == null)
            System.out.println("there is no Customer with this id");
        else
            System.out.println(customer.getSubscription());
    }

    public static void getCustomerInSpecificDate(ArrayList<Customer> c) {
        Scanner input = new Scanner(System.in);
        String date;
        System.out.print("Enter the date: ");
        date = input.next();
        ArrayList<Customer> customers = new ArrayList<>();
        String myDate;
        for (Customer customer : c) {
            myDate = DateFormating.dateFormatDayMonth(customer.getSubscription().getMembershipPlan().getStartDate());
            if (myDate.equals(date))
                customers.add(customer);
        }
        if (customers.size() != 0)
            DisplayObject.displayCustomers(customers);
        else
            System.out.println("No customers subscripted in this date");
    }

    public static void showGymIncomeInSpecificMonth(ArrayList<Customer> customers) {
        Scanner input = new Scanner(System.in);
        int income = 0;
        System.out.print("Enter date: ");
        String myDate = input.next();
        for (Customer customer : customers) {
            myDate = DateFormating.dateFormatMonth(customer.getSubscription().getMembershipPlan().getStartDate());
            if (myDate.equals(myDate)) {
                income += customer.getSubscription().getMembershipPlan().getPrice();
            }
        }
        System.out.println(income);
    }

    public static void showCustomerOfSpecificCoach(ArrayList<Subscription> subscriptions, ArrayList<Customer> customerss) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Coach's id: ");
        int coachId = Validate.checkInt();
        ArrayList<Customer> customers = new ArrayList<>();
        for (Subscription subscription : subscriptions) {
            if (subscription.getAssignedCoachID() == coachId) {
                customers.add(Searching.searchCustomer(customerss, subscription.getCustomerID()));
            }
        }
        if (customers.size() != 0)
            DisplayObject.displayCustomers(customers);
        else
            System.out.println("There is no Coach with this id");
    }
    public static int getCounterOfCustomerOfSpecificCoach(ArrayList<Customer> customers, int coachId) {
        int countOfCustomer=0;
        for (Customer customer:customers) {
            if (customer.getSubscription().getAssignedCoachID() == coachId) {
                countOfCustomer++;
            }
        }
        return countOfCustomer;
    }


    public static ArrayList<CoachRecord> getDescendingCoaches(ArrayList<Customer>customers, ArrayList<Coach>coaches) {
        ArrayList<CoachRecord> coachesRecord = new ArrayList<>();
        for (Coach coach:coaches) {
            CoachRecord coachRecord = new CoachRecord(coach.getId(),getCounterOfCustomerOfSpecificCoach(customers,coach.getId()));
            coachesRecord.add(coachRecord);
        }
        return coachesRecord;
    }
    public static void showCoachesAssignedCustomer(ArrayList<Customer>customers,ArrayList<Coach>coaches) {
        ArrayList<CoachRecord> coachRecords = Admin.getDescendingCoaches(customers,coaches);
        DisplayObject.displayDescendingCoaches(coachRecords,coaches);
    }
    public static int generateCoachID(ArrayList<Coach>coaches) {
        int size = coaches.size();
        int id = (coaches.get(size-1).getId())+1;
        return id;
    }
    public static int generateCustomerID(ArrayList<Customer>customers) {
        int size = customers.size();
        int id = (customers.get(size-1).getId())+1;
        return id;
    }
}