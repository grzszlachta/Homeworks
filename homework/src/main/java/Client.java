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
        name = _name;
        surname = _surname;
        phone = _phone;
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

    @Override
    public String toString() {
        return id + ": " + name + " " + surname;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o instanceof Client) {
            Client toCompare = (Client)o;
            return (this.email.equals(toCompare.email)
                    && this.name.equals(toCompare.name));
        }
        return false;
    }
}
