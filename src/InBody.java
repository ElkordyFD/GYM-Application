package src;

import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;
public class InBody implements Serializable {
    private int id;
    private LocalDate DATE_OF_INBODY;
    private float height;
    private float totalWeight;
    private float bodyFatMass;
    private float minerals;
    private float totalBodyWater;
    private float protein;

    public InBody(int id, LocalDate DATE_OF_INBODY, float height, float totalWeight, float bodyFatMass, float minerals, float totalBodyWater, float protein) {
        this.id = id;
        this.DATE_OF_INBODY = DATE_OF_INBODY;
        this.height = height;
        this.totalWeight = totalWeight;
        this.bodyFatMass = bodyFatMass;
        this.minerals = minerals;
        this.totalBodyWater = totalBodyWater;
        this.protein = protein;
    }

    @Override
    public String toString() {
        return "InBody{" +
                "id=" + id +
                ", DATE_OF_INBODY=" + DATE_OF_INBODY +
                ", height=" + height +
                ", totalWeight=" + totalWeight +
                ", bodyFatMass=" + bodyFatMass +
                ", minerals=" + minerals +
                ", totalBodyWater=" + totalBodyWater +
                ", protein=" + protein +
                '}';
    }
}
