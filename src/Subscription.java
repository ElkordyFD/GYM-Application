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
    public Subscription(){}

    public int getCustomerID() {
        return customerID;
    }

    public int getAssignedCoachID() {
        return assignedCoachID;
    }

    public MembershipPlan getMembershipPlan() {
        return membershipPlan;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setAssignedCoachID(int assignedCoachID) {
        this.assignedCoachID = assignedCoachID;
    }

    public void setMembershipPlan(MembershipPlan membershipPlan) {
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
