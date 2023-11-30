package src;

import java.util.*;

public class Customer extends Person {
   private ArrayList<InBody> inBodies ;
   private Subscription subscription;

   public Customer(int id, String password, String name, char gender, String address, String phoneNumber, String email, ArrayList<InBody> inBodies, Subscription subscription) {
      super(id, password, name, gender, address, phoneNumber, email);
      this.inBodies = inBodies;
      this.subscription = subscription;
   }

   @Override
   public String toString() {
      return "Customer{" +
              "inBodies=" + inBodies +
              ", subscription=" + subscription +
              '}';
   }
}