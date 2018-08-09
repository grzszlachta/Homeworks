package tools;

import model.Client;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Random;
import java.util.UUID;

public class LoopCheckerTest {
    private Random random = new Random();

    @Test
    public void testNotLoop() {
        LinkedList<Object> listOfStrings = new LinkedList<>();
        listOfStrings.add("A");
        listOfStrings.add("B");
        listOfStrings.add("C");

        System.out.println("listOfStrings = " + listOfStrings);
        Assert.assertFalse(LoopChecker.hasLoopHashes(listOfStrings));
    }

    @Test
    public void testLoop() {
        LinkedList<Object> listOfObjects = new LinkedList<>();
        listOfObjects.add("A");
        listOfObjects.add("B");
        listOfObjects.add("C");
        listOfObjects.add("D");
        listOfObjects.add("B");
        System.out.println("listOfObjects = " + listOfObjects);
        Assert.assertTrue(LoopChecker.hasLoopHashes(listOfObjects));

    }

    @Test
    public void testLoopOfClients() {
        LinkedList<Client> listOfClients = new LinkedList<>();
        Client head = generateRandomClient();
        listOfClients.add(head);
        listOfClients.add(generateRandomClient());
        listOfClients.add(generateRandomClient());
        listOfClients.add(generateRandomClient());
        listOfClients.pollFirst();
        System.out.println("listOfClients = " + listOfClients);

    }

    private Client generateRandomClient() {
        int maybePhoneNumber = random.nextInt();
        int phoneNumber = maybePhoneNumber > 0 ? maybePhoneNumber : (maybePhoneNumber * -1);
        return new Client(random.nextInt(83) + 16,
                UUID.randomUUID().toString().replaceAll("-", "") + "@" +
                        UUID.randomUUID().toString().replaceAll("-", "") + ".com",
                UUID.randomUUID().toString().replaceAll("-", ""),
                UUID.randomUUID().toString().replaceAll("-", ""),
                "+" + phoneNumber);
    }


}
