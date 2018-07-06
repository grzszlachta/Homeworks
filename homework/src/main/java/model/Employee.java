package model;

public class Employee extends Person implements Comparable<Employee> {

    public Employee() {}

    public Employee(int age, String _email, String _name, String _surname, String _phone) {
        super(age, _email, _name, _surname, _phone);
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

    @Override
    public int compareTo(Employee o) {
        return this.surname.compareTo(o.surname);
    }
}
