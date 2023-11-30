package src;

import java.io.Externalizable;
import java.io.Serializable;
import java.util.*;

public class Customer extends Person implements Serializable {
   private ArrayList<InBody> inBodies ;
   private Subscription subscription;
   private Coach coach;

   public Customer(int id, String password, String name, char gender, String address, String phoneNumber, String email, ArrayList<InBody> inBodies, Subscription subscription, Coach coach) {
      super(id, password, name, gender, address, phoneNumber, email);
      this.inBodies = inBodies;
      this.subscription = subscription;
      this.coach = coach;
   }

   public ArrayList<InBody> getInBodies() {
      return inBodies;
   }

   public Subscription getSubscription() {
      return subscription;
   }

   public Coach getCoach() {
      return coach;
   }

   public void setInBodies(ArrayList<InBody> inBodies) {
      this.inBodies = inBodies;
   }

   public void setSubscription(Subscription subscription) {
      this.subscription = subscription;
   }

   public void setCoach(Coach coach) {
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