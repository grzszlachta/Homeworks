package model;

import java.util.Objects;

public abstract class Person implements Discountable {
    private static int counter = 0;

    protected int age;
    protected String email;
    protected String name;
    protected String surname;
    protected String phone;
    private int id;
    private Address address;

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

//    public abstract int getDiscount();



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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return new String(email);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
