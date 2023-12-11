package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private final String username = "admin";
    private final String password = "admin";

    public static void addCoach(ArrayList<Coach> coaches) {
        Scanner input = new Scanner(System.in);
        int id;
        String password;
        String name;
        char gender;
        String address;
        String phoneNumber;
        String email;
        int workingHours;
        System.out.println("Enter id: ");
        id = input.nextInt();
        System.out.println("Enter password: ");
        password = input.nextLine();
        System.out.println("Enter name: ");
        name = input.nextLine();
        System.out.println("Enter gender: ");
        gender = input.next().charAt(0);
        System.out.println("Enter address: ");
        address = input.nextLine();
        System.out.println("Enter phoneNumber: ");
        phoneNumber = input.nextLine();
        System.out.println("Enter email: ");
        email = input.nextLine();
        System.out.println("Enter WorkingHours: ");
        workingHours = input.nextInt();
        Coach coach = new Coach(id, password, name, gender, address, phoneNumber, email, workingHours);
        coaches.add(coach);
    }

    public static void addCustomer(ArrayList<Customer> customers) {
        Scanner input = new Scanner(System.in);
        ArrayList<InBody> inBodies = new ArrayList<InBody>();
        Subscription subscription = new Subscription();
        int id;
        String password;
        String name;
        char gender;
        String address;
        String phoneNumber;
        String email;
        int workingHours;
        System.out.println("Enter id: ");
        id = input.nextInt();
        System.out.println("Enter password: ");
        password = input.nextLine();
        System.out.println("Enter name: ");
        name = input.nextLine();
        System.out.println("Enter gender: ");
        gender = input.next().charAt(0);
        System.out.println("Enter address: ");
        address = input.nextLine();
        System.out.println("Enter phoneNumber: ");
        phoneNumber = input.nextLine();
        System.out.println("Enter email: ");
        email = input.nextLine();
        Customer customer = new Customer(id, password, name, gender, address, phoneNumber, email, inBodies, subscription);
        customers.add(customer);
    }

    public static void addEquipment(ArrayList<Equipment> equipments) {
        Scanner input = new Scanner(System.in);
        String name;
        String code;
        int quantity;
        System.out.print("Enter name: ");
        name = input.next();
        System.out.print("Enter code: ");
        code = input.next();
        System.out.print("Enter quantity: ");
        quantity = input.nextInt();
        Equipment equipment = new Equipment(name, code, quantity);
        equipments.add(equipment);
    }

    public static void modify(Coach coach, int choice, ArrayList<Subscription> subscriptions, int coachId) {
        Scanner input = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("Enter new id: ");
                int newId = input.nextInt();
                for (Subscription subscription : subscriptions) {
                    if (subscription.getAssignedCoachID() == coachId)
                        subscription.setAssignedCoachID(newId);
                }
                (coach).setId(newId);
                break;
            case 2:
                System.out.println("Enter new password: ");
                String password = input.nextLine();
                (coach).setPassword(password);
                break;
            case 3:
                System.out.println("Enter new name: ");
                String name = input.nextLine();
                (coach).setName(name);
                break;
            case 4:
                System.out.println("Enter new gender: ");
                char gender = input.next().charAt(0);
                (coach).setGender(gender);
                break;
            case 5:
                System.out.println("Enter new address: ");
                String address = input.nextLine();
                (coach).setAddress(address);
                break;
            case 6:
                System.out.println("Enter new phoneNumber: ");
                String phoneNumber = input.nextLine();
                (coach).setPhoneNumber(phoneNumber);
                break;
            case 7:
                System.out.println("Enter new email: ");
                String email = input.nextLine();
                (coach).setEmail(email);
                break;
            case 8:
                System.out.println("Enter new WorkingHours: ");
                int workingHours = input.nextInt();
                (coach).setWorkingHoursPerDay(workingHours);
                break;
        }
    }

    public static void modify(Customer customer, int choice) {
        Scanner input = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("Enter new id: ");
                int newId = input.nextInt();
                (customer).setId(newId);
                (customer).getSubscription().setCustomerID(newId);
                break;
            case 2:
                System.out.println("Enter new password: ");
                String password = input.nextLine();
                (customer).setPassword(password);
                break;
            case 3:
                System.out.println("Enter new name: ");
                String name = input.nextLine();
                (customer).setName(name);
                break;
            case 4:
                System.out.println("Enter new gender: ");
                char gender = input.next().charAt(0);
                (customer).setGender(gender);
                break;
            case 5:
                System.out.println("Enter new address: ");
                String address = input.nextLine();
                (customer).setAddress(address);
                break;
            case 6:
                System.out.println("Enter new phoneNumber: ");
                String phoneNumber = input.nextLine();
                (customer).setPhoneNumber(phoneNumber);
                break;
            case 7:
                System.out.println("Enter new email: ");
                String email = input.nextLine();
                (customer).setEmail(email);
                break;
            case 8:
        }
    }

    public static void modify(Equipment equipment, int choice) {
        Scanner input = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("Enter new name: ");
                String name = input.nextLine();
                (equipment).setName(name);
                break;
            case 2:
                System.out.println("Enter new code: ");
                String code = input.next();
                (equipment).setCode(code);
                break;
            case 3:
                System.out.println("Enter new quantity: ");
                int quantity = input.nextInt();
                (equipment).setQuantity(quantity);
                break;
        }
    }

    public static void delete(Coach coach, ArrayList<Coach> coaches) {
        (coaches).remove(coach);
    }

    public static void delete(Customer customer, ArrayList<Customer> customers) {
        (customers).remove(customer);
    }

    public static void delete(Equipment equipment, ArrayList<Equipment> equipments) {
        (equipments).remove(equipment);
    }

    public static Subscription getSubscriptionHistoryForACustomer(ArrayList<Customer> customers, int id) {
        Subscription subscription = (Searching.searchCustomer(customers, id)).getSubscription();
        return subscription;
    }

    public static ArrayList<Customer> getCustomerInSpecificDate(ArrayList<Customer> c, String date) {
        ArrayList<Customer> customers = new ArrayList<>();
        String myDate;
        for (Customer customer : c) {
            myDate = DateFormating.dateFormatDayMonth(customer.getSubscription().getMembershipPlan().getStartDate());
            if (myDate.equals(date))
                customers.add(customer);
        }
        return customers;
    }

    public static int getGymIncome(ArrayList<Customer> customers, String date) {
        int income = 0;
        String myDate;
        for (Customer customer : customers) {
            myDate = DateFormating.dateFormatMonth(customer.getSubscription().getMembershipPlan().getStartDate());
            if (myDate.equals(date)) {
                income += customer.getSubscription().getMembershipPlan().getPrice();
            }
        }
        return income;
    }

    public static ArrayList<Customer> getCustomerOfSpecificCoach(ArrayList<Subscription> subscriptions, ArrayList<Customer> customerss, int coachId) {
        ArrayList<Customer> customers = new ArrayList<>();
        for (Subscription subscription : subscriptions) {
            if (subscription.getAssignedCoachID() == coachId) {
                customers.add(Searching.searchCustomer(customerss, subscription.getCustomerID()));
            }
        }
        return customers;
    }
    public static int getCounterOfCustomerOfSpecificCoach(ArrayList<Subscription> subscriptions, int coachId) {
        int countOfCustomer=0;
        for (Subscription subscription : subscriptions) {
            if (subscription.getAssignedCoachID() == coachId) {
                countOfCustomer++;
            }
        }
        return countOfCustomer;
    }

    public static ArrayList<CoachRecord> getDescendingCoaches(ArrayList<Subscription>subscriptions, ArrayList<Coach>coaches) {
        ArrayList<CoachRecord> coachesRecord = new ArrayList<>();
        for (Coach coach:coaches) {
            CoachRecord coachRecord = new CoachRecord(coach.getId(),getCounterOfCustomerOfSpecificCoach(subscriptions,coach.getId()));
            coachesRecord.add(coachRecord);
        }
        return coachesRecord;
    }
    public static void getCoachesAssignedCustomer(ArrayList<CoachRecord>coachRecords,ArrayList<Coach>coaches) {
        DisplayObject.displayDescendingCoaches(coachRecords,coaches);
    }
}