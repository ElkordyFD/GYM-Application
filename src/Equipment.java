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

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "name: " + name +
                " ,code: " + code +
                " ,quantity: " + quantity +
                '}';
    }
}
