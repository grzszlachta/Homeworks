public class Client {

    static int counter = 0;

    boolean isRegular;
    int age;
    String email;
    String name;
    String surname;
    String phone;
    int id;

    // default constructor
    public Client() {

    }

    public Client(int age, boolean _isRegular, String _email, String _name, String _surname, String _phone) {
        this.age = age;
        isRegular = _isRegular;
        email = new String( _email);
        name = new String(_name);
        surname = new String(_surname);
        phone = new String(_phone);
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
        return "Client{" +
                "isRegular=" + isRegular +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                '}';
    }

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
}
