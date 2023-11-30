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
    private double income;

}