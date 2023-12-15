package src;

import java.io.Externalizable;
import java.io.Serializable;
import java.util.*;

public class Customer extends Person implements Serializable {
   private ArrayList<InBody> inBodies ;
   private Subscription subscription;

   public Customer(int id, String password, String name, char gender, String address, String phoneNumber, String email, ArrayList<InBody> inBodies, Subscription subscription) {
      super(id, password, name, gender, address, phoneNumber, email);
      this.inBodies = inBodies;
      this.subscription = subscription;
   }

   public ArrayList<InBody> getInBodies() {
      return inBodies;
   }

   public Subscription getSubscription() {
      return subscription;
   }

   public void getCoachInfo(Coach coach) {
      System.out.println("name: " + coach.getName() + "\n" +
              "PhoneNumber: " + coach.getPhoneNumber() + "\n" +
              "workingHours: " + coach.getWorkingHoursPerDay()
      );
   }
   public void getInbodyInfo(String date,ArrayList<InBody>inBodies) {
      System.out.println(Searching.searchInBody(inBodies,date));
   }
   public void CaculatePerfectWeight(Customer userCustomer) {
      int size = userCustomer.getInBodies().size();  /* to get last inbody */
      InBody inBody = userCustomer.getInBodies().get(size - 1);
      float h = inBody.getHeight();
      float w = inBody.getTotalWeight();
      /* Men: IBW (kgs) = 22 × Square(height in meters) */
      if (userCustomer.getGender() == 'M') {
         float Ideal = 22 * (h) * (h);
         if (Ideal > w) {
            System.out.println("You have to gain " + (Ideal - w) + " KGs");
         } else if (Ideal < w) {
            System.out.println("You have to lose " + (-Ideal + w) + " KGs");
         } else
            System.out.println("Your Weight is perfect ! keep on ");
      }
      /*  Women: IBW (kgs) = 22 × Square(height in meters − 10 cm) */
      else if (userCustomer.getGender() == 'F') {
         float Ideal = 22 * (h - 0.1f) * (h - 0.1f);
         if (Ideal > w) {
            System.out.println("You have to gain " + (Ideal - w) + " KGs");
         } else if (Ideal < w) {
            System.out.println("You have to lose " + (-Ideal + w) + " KGs");
         }
         else
            System.out.println("Your Weight is perfect ! keep on ");
      }
   }
   public void setInBodies(ArrayList<InBody> inBodies) {
      this.inBodies = inBodies;
   }

   public void setSubscription(Subscription subscription) {
      this.subscription = subscription;
   }


   @Override
   public String toString() {
      return "Customer" + super.toString() +
              "inBodies=" + inBodies +
              ", subscription=" + subscription +
              '}';
   }


}