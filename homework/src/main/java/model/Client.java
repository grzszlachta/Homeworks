package model;

public class Client extends Person implements Comparable<Client> {

    private static int counter = 0;

    private boolean isRegular = false;
    private int id;
    private boolean regular;

    // default constructor
    public Client() {

    }

    public Client(int age, String _email, String _name, String _surname, String _phone) {
        super(age, _email, _name, _surname, _phone);
    }

    public Client(int age, boolean _isRegular, String _email, String _name, String _surname, String _phone) {
        this(age, _email, _name, _surname, _phone);
        isRegular = _isRegular;
        id = counter++;
    }

    public int getDiscount() {
        int result = 0;
        if (age < 18) {
            result += 20;
        } else if (age > 70) {
            result += 15;
        }
        if (isRegular) {
            result += 5;
        }
        System.out.println("Discount of client " + id + " is " + result);
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        String personToString = super.toString();
        String clientToString = "model.Client{" +
                "isRegular=" + isRegular +
//                ", age=" + age +
//                ", email='" + email + '\'' +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", phone='" + phone + '\'' +
                ", id=" + id +
                '}';
        return clientToString + " " + personToString;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Client client = (Client) object;
        return email.equals(client.email) &&
                phone.equals(client.phone) &&
                isRegular == client.isRegular &&
                age == client.age &&
                name.equals(client.name) &&
                surname.equals(client.surname);
    }

    public void setRegular(boolean regular) {
        this.regular = regular;
    }

    public void setAge(int _age) {
        System.out.println("old age = " + getAge() + "; new age = " + _age);
        super.setAge(_age);
    }

    @Override
    public int compareTo(Client other) {
        return this.getSurname().compareTo(other.getSurname());
    }
}
