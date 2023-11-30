package src;

import java.io.Serializable;
import java.util.ArrayList;

public class GYM implements Serializable {

    private String name ;
    private String address;
    private String phone_number ;
    private ArrayList<Coach> coaches ;
    private ArrayList<Equipment> sports_equipment;
    private ArrayList<Subscription> subscriptions;

    public GYM(String name, String address, String phone_number, ArrayList<Coach> coaches, ArrayList<Equipment> sports_equipment, ArrayList<Subscription> subscriptions) {
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.coaches = coaches;
        this.sports_equipment = sports_equipment;
        this.subscriptions = subscriptions;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public ArrayList<Coach> getCoaches() {
        return coaches;
    }

    public ArrayList<Equipment> getSports_equipment() {
        return sports_equipment;
    }

    public ArrayList<Subscription> getSubscriptions() {
        return subscriptions;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setCoaches(ArrayList<Coach> coaches) {
        this.coaches = coaches;
    }

    public void setSports_equipment(ArrayList<Equipment> sports_equipment) {
        this.sports_equipment = sports_equipment;
    }

    public void setSubscriptions(ArrayList<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }



    @Override
    public String toString() {
        return "GYM{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", coaches=" + coaches +
                ", sports_equipment=" + sports_equipment +
                ", subscriptions=" + subscriptions +
                '}';
    }
}