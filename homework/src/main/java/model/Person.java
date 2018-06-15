package model;

import java.util.Objects;

public abstract class Person {
    private static int counter = 0;

    protected int age;
    protected String email;
    protected String name;
    protected String surname;
    protected String phone;
    private int id;

    public Person() {}

    public Person(int age, String _email, String _name, String _surname, String _phone) {
        this.age = age;
        email = new String( _email);
        name = new String(_name);
        surname = new String(_surname);
        phone = new String(_phone);
        id = counter++;
        this.toString();
    }

    public abstract int getDiscount();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(email, person.email) &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(phone, person.phone);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", email='" + email + '\'' +
                ", name=`'" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                '}';
    }
}
