package model;

public class Employee extends Person {

    public Employee() {}

    public Employee(int age, String _email, String _name, String _surname, String _phone) {
        super(age, _email, _name, _surname, _phone);
    }

    @Override
    public int getDiscount() {
        System.out.println("Discount of employee is 25");
        return 25;
    }

    @Override
    public String toString() {
        return "model.Employee{" +
                "age=" + age +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
