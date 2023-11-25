import java.util.*;

public class Customer extends Person{
    InBody []inBodies={};
    Subscription subscription;
    public Customer(int id, String name,Boolean gender,String address,String phoneNumber,String email) {
        super(id,name,gender,address,phoneNumber,email);

    }
}
