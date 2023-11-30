package src;

import java.util.*;

public class Customer extends Person {
   private ArrayList<InBody> inBodies ;
   private Subscription subscription;

   private Coach coach;

   public Customer(int id, String password, String name, char gender, String address, String phoneNumber, String email, ArrayList<InBody> inBodies, Subscription subscription, Coach coach) {
      super(id, password, name, gender, address, phoneNumber, email);
      this.inBodies = inBodies;
      this.subscription = subscription;
      this.coach = coach;
   }

   @Override
   public String toString() {
      return "Customer" + super.toString() +
              "inBodies=" + inBodies +
              ", subscription=" + subscription +
              ", coach=" + coach +
              '}';
   }
}