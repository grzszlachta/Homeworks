package model;

import org.junit.Test;

public class ClientTest {

    @Test
    public void testDefaultConstructor() {
        new Client();
    }

    @Test
    public void testNotRegularClient() {
        new Client(33, "a@bbs.com", "Gary", "Smith", "");
    }

    @Test
    public void testEquals() {
        Client client1 = new Client(29, false, "a@email.com",
                "Ivan", "Ivanov", "+4812345678");
        System.out.println("client1 = " + client1);

        Client client2 = new Client(35, true, "b@outlook.com",
                "Jan", "Kowalsky", "+4898765432");
        System.out.println("client2 = " + client2);

        Client client3 = new Client(17, true, "c@gmail.com",
                "John", "Smith", "+482345678");
        System.out.println("client3 = " + client3);
        Client client3_0 = client3;

        Client client4 = new Client(17, true, "c@gmail.com",
                "John", "Smith", "+482345678");
        System.out.println("client4 = " + client4);

        System.out.println("client1 is equals client2 = " + client1.equals(client2));
        System.out.println("client3 is equals client3_0 = " + client3.equals(client3_0));
        System.out.println("client3 is equals client4 = " + client3.equals(client4));
        System.out.println("client4 is equals null = " + client4.equals(null));
    }
}
