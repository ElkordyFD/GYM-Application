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

    public int getId() {
        return id;
    }

    public LocalDate getDATE_OF_INBODY() {
        return DATE_OF_INBODY;
    }

    public float getHeight() {
        return height;
    }

    public float getTotalWeight() {
        return totalWeight;
    }

    public float getBodyFatMass() {
        return bodyFatMass;
    }

    public float getMinerals() {
        return minerals;
    }

    public float getTotalBodyWater() {
        return totalBodyWater;
    }

    public float getProtein() {
        return protein;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDATE_OF_INBODY(LocalDate DATE_OF_INBODY) {
        this.DATE_OF_INBODY = DATE_OF_INBODY;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setTotalWeight(float totalWeight) {
        this.totalWeight = totalWeight;
    }

    public void setBodyFatMass(float bodyFatMass) {
        this.bodyFatMass = bodyFatMass;
    }

    public void setMinerals(float minerals) {
        this.minerals = minerals;
    }

    public void setTotalBodyWater(float totalBodyWater) {
        this.totalBodyWater = totalBodyWater;
    }

    public void setProtein(float protein) {
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
