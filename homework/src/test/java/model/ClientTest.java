package model;

import org.junit.Assert;
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

    @Test
    public void testReflexiveEquals() {
        Client client = new Client(29, false, "a@email.com",
                "Ivan", "Ivanov", "+4812345678");
        Assert.assertTrue(client.equals(client));
    }

    @Test
    public void testEqualsNull() {
        Client client = new Client();
        Assert.assertFalse(client.equals(null));
    }

    @Test
    public void testSymmetric() {
        Client clientX = new Client(29, false, "a@email.com",
                "Ivan", "Ivanov", "+4812345678");
        Client clientY = new Client(29, false, "a@email.com",
                "Ivan", "Ivanov", "+4812345678");
        Assert.assertTrue(clientX.equals(clientY));
        Assert.assertTrue(clientY.equals(clientX));

        Client clientZ = new Client(17, true, "c@gmail.com",
                "John", "Smith", "+482345678");
        Assert.assertFalse(clientX.equals(clientZ));
        Assert.assertFalse(clientZ.equals(clientX));
    }

    @Test
    public void testTransitive() {
        Client clientX = new Client(29, false, "a@email.com",
                "Ivan", "Ivanov", "+4812345678");
        Client clientY = new Client(29, false, "a@email.com",
                "Ivan", "Ivanov", "+4812345678");
        Client clientZ = new Client(29, false, "a@email.com",
                "Ivan", "Ivanov", "+4812345678");
        Assert.assertTrue(clientX.equals(clientY));
        Assert.assertTrue(clientY.equals(clientZ));
        Assert.assertTrue(clientX.equals(clientZ));
    }

    @Test
    public void testConsistent() {
        Client clientX = new Client(29, false, "a@email.com",
                "Ivan", "Ivanov", "+4812345678");
        Address addressX = new Address("Cracow", "Szlak", "65", 101, "10001");
        addressX.setCity("Warsaw");
        clientX.setAddress(addressX);
        Client clientY = new Client(29, false, "a@email.com",
                "Ivan", "Ivanov", "+4812345678");
        Address addressY = new Address();
        addressY.setCity("Cracow");
        clientY.setAddress(addressY);
        Client clientZ = new Client(35, true, "b@outlook.com",
                "Jan", "Kowalsky", "+4898765432");
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(clientX.equals(clientY));
            Assert.assertFalse(clientX.equals(clientZ));
            Assert.assertFalse(clientY.equals(clientZ));
        }
    }

}
