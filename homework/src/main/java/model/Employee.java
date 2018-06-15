package model;

public class Employee extends Person {

    public Employee() {}

    public Employee(int age, String _email, String _name, String _surname, String _phone) {
        super(age, _email, _name, _surname, _phone);
    }

    public int getDiscount() {
        return 25;
    }
}
