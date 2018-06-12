package model;

public class Person {
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
        System.out.println("done");
    }

    public int getDiscount() {
       return 0;
    }

}
