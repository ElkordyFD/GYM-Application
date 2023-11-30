package src;

import java.io.Serializable;
import java.time.LocalDate;
public class MembershipPlan implements Serializable {
    private LocalDate startDate;
    private int registeredMonths;
    private float price;

    public MembershipPlan(LocalDate startDate, int registeredMonths, float price) {
        this.startDate = startDate;
        this.registeredMonths = registeredMonths;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MembershipPlan{" +
                "startDate=" + startDate +
                ", registeredMonths=" + registeredMonths +
                ", price=" + price +
                '}';
    }
}
