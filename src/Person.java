package src;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private int id;
    private String password;
    private String name;
    private char gender;
    private String address;
    private String phoneNumber;
    private String email;

    public Person(int id, String password, String name, char gender, String address, String phoneNumber, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' + ", ";
    }
}
