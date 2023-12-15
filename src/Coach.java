package src;

import java.io.Externalizable;
import java.io.Serializable;
import java.util.ArrayList;

public class Coach extends Person implements Serializable {
    private int workingHoursPerDay;

    public Coach(int id, String password, String name, char gender, String address, String phoneNumber, String email, int workingHoursPerDay) {
        super(id, password, name, gender, address, phoneNumber, email);
        this.workingHoursPerDay = workingHoursPerDay;
    }

    public int getWorkingHoursPerDay() {
        return workingHoursPerDay;
    }



    public void setWorkingHoursPerDay(int workingHoursPerDay) {
        this.workingHoursPerDay = workingHoursPerDay;
    }



    @Override
    public String toString() {
        return "Coach" + super.toString() +
                "workingHoursPerDay=" + workingHoursPerDay +
                '}';
    }

    public ArrayList<Integer> getCustomerIDs(ArrayList<Subscription> subscriptions) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Subscription s:subscriptions){
            if(s.getAssignedCoachID() == this.getId()){
                ids.add(s.getCustomerID());
            }
        }
        return ids;
    }
}