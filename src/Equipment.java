package src;

import java.io.Serializable;

public class Equipment implements Serializable {
    private String name;
    private String code;
    private int quantity;

    public Equipment(String name, String code, int quantity) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
