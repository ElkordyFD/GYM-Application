package src;

import java.io.Externalizable;
import java.io.Serializable;

public abstract class Person implements Serializable {
    private int id;
    private String name;
    private String password;
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

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String s = "Id: "          + this.id +
                "\nName: "         + this.name +
                "\nPassword: "     + this.password +
                "\nGender: "       + this.gender +
                "\nAddress: "      + this.address +
                "\nPhone Number: " + this.phoneNumber +
                "\nE-mail: "       + this.email + "\n";
        return s;
    }
}