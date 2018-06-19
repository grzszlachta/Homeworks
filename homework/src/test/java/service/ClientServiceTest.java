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
        service.addClient(29, "a@email.com", "Ivan", "Ivanov", "+4812345678");
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

    private void generateRandomClient(ClientService service) {
        int maybePhomeNumber = random.nextInt();
        int phoneNumber = maybePhomeNumber > 0 ?  maybePhomeNumber : (maybePhomeNumber * -1) ;
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
