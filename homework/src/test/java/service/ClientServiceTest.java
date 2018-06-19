package service;

import model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

public class ClientServiceTest {

    private Random random = new Random();

    @Test
    public void testAddClient() {
        ClientService service = new ClientService();
        service.addClient(29,  "a@email.com", "Ivan", "Ivanov", "+4812345678");
        Assert.assertEquals(10, service.getStorageSize());
        Assert.assertEquals(1, countPersons(service.getClients()));
    }

    @Test
    public void testExpandClientStorage() {
        ClientService service = new ClientService();
        int counter = 0;
        for (int index = 0; index < 20; index++) {
            generateRandomClient(service);
            Assert.assertEquals(++counter, countPersons(service.getClients()));
        }
        Assert.assertEquals(20, service.getStorageSize());
        generateRandomClient(service);
        Assert.assertEquals(++counter, countPersons(service.getClients()));
        Assert.assertEquals(40, service.getStorageSize());
    }

    @Test
    public void testAverageDiscount() {
        ClientService service = new ClientService();
        service.addClient(29, false,"a@email.com", "Ivan", "Ivanov", "+4812345678");
        service.addClient(35, true, "b@outlook.com", "Jan", "Kowalsky", "+4898765432");
        service.addClient(17, true, "c@gmail.com", "John", "Smith", "+482345678");
        service.addClient(17, true, "c@gmail.com", "John", "Smith", "+482345678");
        service.addEmployee(29, "a@email.com", "Ivan", "Ivanov", "+4812345678");
        int sum = 0;
        for (Person person : service.getClients()) {
            if (person != null) {
                System.out.println("person = " + person);
                sum += person.getDiscount();
            }
        }
        System.out.println("Average discount = " + (float)sum / 5);
    }

    private void generateRandomClient(ClientService service) {
        int maybePhoneNumber = random.nextInt();
        int phoneNumber = maybePhoneNumber > 0 ?  maybePhoneNumber : (maybePhoneNumber * -1) ;
        service.addClient(random.nextInt(83) + 1,
                UUID.randomUUID().toString().replaceAll("-", "") + "@" +
                        UUID.randomUUID().toString().replaceAll("-", "") + ".com",
                UUID.randomUUID().toString().replaceAll("-", ""),
                UUID.randomUUID().toString().replaceAll("-", ""),
                "+" + phoneNumber);
    }

    private int countPersons(Person[] people) {
        int counter = 0;
        for (Person person : people) {
            if (person != null) {
                counter++;
            }
        }
        return counter;
    }
}
