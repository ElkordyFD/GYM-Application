package src;

import java.io.Serializable;
import java.time.LocalDate;
public class MembershipPlan implements Serializable {
    private LocalDate startDate;
    private int registeredMonths;
    private int price;

    public MembershipPlan(LocalDate startDate, int registeredMonths, int price) {
        this.startDate = startDate;
        this.registeredMonths = registeredMonths;
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getRegisteredMonths() {
        return registeredMonths;
    }

    public float getPrice() {
        return price;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setRegisteredMonths(int registeredMonths) {
        this.registeredMonths = registeredMonths;
    }

    public void setPrice(int price) {
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
