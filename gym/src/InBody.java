import java.util.*;
import java.time.LocalDate;
public class InBody {
    private int id;
    private LocalDate DATE_OF_INBODY;
    private float height;
    private float totalWeight;
    private float bodyFatMass;
    private float minerals;
    private float totalBodyWater;
    private float protein;
    public InBody(LocalDate date) {

        this.DATE_OF_INBODY=date;
    }

    public LocalDate getDATE_OF_INBODY() {
        return DATE_OF_INBODY;
    }

    @Override
    public String toString() {
        return "InBody{" +
                "DATE_OF_INBODY=" + DATE_OF_INBODY +
                ", height=" + height +
                ", totalWeight=" + totalWeight +
                ", bodyFatMass=" + bodyFatMass +
                ", minerals=" + minerals +
                ", totalBodyWater=" + totalBodyWater +
                ", protein=" + protein +
                '}';
    }
}
