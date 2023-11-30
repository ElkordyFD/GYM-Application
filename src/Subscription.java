package src;

import java.io.Serializable;

public class Subscription implements Serializable {
    private int customerID;
    private int assignedCoachID;
    private MembershipPlan membershipPlan;

    public Subscription(int customerID, int assignedCoachID, MembershipPlan membershipPlan) {
        this.customerID = customerID;
        this.assignedCoachID = assignedCoachID;
        this.membershipPlan = membershipPlan;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "customerID=" + customerID +
                ", assignedCoachID=" + assignedCoachID +
                ", membershipPlan=" + membershipPlan +
                '}';
    }
}
