public abstract class Person {
    private int id;
    private String name;
    private Boolean gender;
    private String address;
    private String phoneNumber;
    private String email;

    public Person(int id, String name, Boolean gender, String address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
