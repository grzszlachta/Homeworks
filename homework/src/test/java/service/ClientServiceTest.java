package service;

        import model.Client;
        import model.Employee;
        import model.Person;
        import org.junit.Assert;
        import org.junit.Test;

        import java.util.Arrays;
        import java.util.Collections;
        import java.util.Random;
        import java.util.UUID;

public class ClientServiceTest {

    private Random random = new Random();

    @Test
    public void testAddClient() {
        ClientService service = new ClientService();
        service.addClient(29,  "a@email.com", "Ivan", "Ivanov", "+4812345678");
        Assert.assertEquals(10, service.getStorageSize());
        Assert.assertEquals(1, countPersons(service.getPeople()));
    }

    @Test
    public void testExpandClientStorage() {
        ClientService service = new ClientService();
        int counter = 0;
        for (int index = 0; index < 20; index++) {
            generateRandomClient(service);
            Assert.assertEquals(++counter, countPersons(service.getPeople()));
        }
        Assert.assertEquals(20, service.getStorageSize());
        generateRandomClient(service);
        Assert.assertEquals(++counter, countPersons(service.getPeople()));
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
        for (Person person : service.getPeople()) {
            if (person != null) {
                System.out.println("person = " + person);
                sum += person.getDiscount();
            }
        }
        System.out.println("Average discount = " + (float)sum / 5);
    }

    @Test
    public void testGetPersonByEmail() {
        ClientService service = new ClientService();
        Assert.assertNull(service.findPersonByEmail("a@bc.com"));
        service.addClient(29, false,"a@email.com", "Ivan", "Ivanov", "+4812345678");
        service.addClient(35, true, "b@outlook.com", "Jan", "Kowalsky", "+4898765432");
        Person person = service.findPersonByEmail("a@email.com");
        Assert.assertNotNull(person);
        Assert.assertEquals(29, person.getAge());
        System.out.println("person found: " + person);

    }

    @Test
    public void testUpdate() {
        ClientService service = new ClientService();
        Client person = getRandomClient();
        Assert.assertNull(service.updatePerson("a@bc.com", person.getAge(), person.getName(), person.getSurname(), person.getPhone()));
        service.addClient(person.getAge(), person.getEmail(), person.getName(), person.getSurname(), person.getPhone());
        Assert.assertEquals(person, service.updatePerson(person.getEmail(), person.getAge(), person.getName(), person.getSurname(), person.getPhone()));
    }

    private void generateRandomClient(ClientService service) {
        int maybePhoneNumber = random.nextInt();
        int phoneNumber = maybePhoneNumber > 0 ?  maybePhoneNumber : (maybePhoneNumber * -1) ;
        service.addClient(random.nextInt(83) + 16,
                UUID.randomUUID().toString().replaceAll("-", "") + "@" +
                        UUID.randomUUID().toString().replaceAll("-", "") + ".com",
                UUID.randomUUID().toString().replaceAll("-", ""),
                UUID.randomUUID().toString().replaceAll("-", ""),
                "+" + phoneNumber);
    }

    private Client getRandomClient() {
        int maybePhoneNumber = random.nextInt();
        int phoneNumber = maybePhoneNumber > 0 ?  maybePhoneNumber : (maybePhoneNumber * -1) ;
        return new Client(random.nextInt(83) + 16,
                UUID.randomUUID().toString().replaceAll("-", "") + "@" +
                        UUID.randomUUID().toString().replaceAll("-", "") + ".com",
                UUID.randomUUID().toString().replaceAll("-", ""),
                UUID.randomUUID().toString().replaceAll("-", ""),
                "+" + phoneNumber);
    }

    private Employee getRandomEmployee() {
        int maybePhoneNumber = random.nextInt();
        int phoneNumber = maybePhoneNumber > 0 ?  maybePhoneNumber : (maybePhoneNumber * -1) ;
        return new Employee(random.nextInt(83) + 16,
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

    @Test
    public void testGetClientEmpty() {
        ClientService service = new ClientService();
        Assert.assertNull(service.getClient("a@a.bc"));
    }

    @Test
    public void testGetClientAbsent() {
        ClientService service = new ClientService();
        Client randomClient = getRandomClient();
        Assert.assertNull(service.getClient(randomClient.getEmail()));
    }

    @Test
    public void testGetClientNotExisted() {
        ClientService service = new ClientService();
        Client randomClient = getRandomClient();
        service.addClient(randomClient);
        Assert.assertNull(service.getClient("a@abc.com"));
    }

    @Test
    public void testGetClient() {
        ClientService service = new ClientService();
        Client randomClient = getRandomClient();
        service.addClient(randomClient);
        Assert.assertEquals(randomClient, service.getClient(randomClient.getEmail()));
    }

    @Test
    public void testGetClientWithEmployee() {
        ClientService service = new ClientService();
        Employee randomEmployee = getRandomEmployee();
        service.addEmployee(randomEmployee);
        Assert.assertEquals(randomEmployee, service.getClient(randomEmployee.getEmail()));
    }

    @Test
    public void testGetRegularClient() {
        ClientService service = new ClientService();
        Client randomClient = getRandomClient();
        randomClient.setRegular(true);
        service.addClient(randomClient);
        Assert.assertEquals(randomClient, service.getClient(randomClient.getEmail()));
    }

    @Test
    public void testDeleteClientEmpty() {
        ClientService service = new ClientService();
        Assert.assertFalse(service.deleteClient("a@abc.com"));
    }

    @Test
    public void testDeleteClientNotExisted() {
        ClientService service = new ClientService();
        Client randomClient = getRandomClient();
        service.addClient(randomClient);
        Assert.assertFalse(service.deleteClient("a@abc.com"));
    }

    @Test
    public void testDeleteClient() {
        ClientService service = new ClientService();
        Client randomClient = getRandomClient();
        service.addClient(randomClient);
        boolean goodResult = service.deleteClient(randomClient.getEmail());
        Assert.assertTrue(goodResult);
    }

    @Test
    public void testDeleteClientAsEmployee() {
        ClientService service = new ClientService();
        Employee randomEmployee = getRandomEmployee();
        service.addEmployee(randomEmployee);
        Assert.assertTrue(service.deleteClient(randomEmployee.getEmail()));
    }

    @Test
    public void testDeleteRegularClient() {
        ClientService service = new ClientService();
        Client randomClient = getRandomClient();
        randomClient.setRegular(true);
        service.addClient(randomClient);
        boolean goodResult = service.deleteClient(randomClient.getEmail());
        Assert.assertTrue(goodResult);
    }

    @Test
    public void testSortStorageComparator() {
        ClientService service = new ClientService();
        for (int i = 0; i < 10; i++) {
            service.addClient(getRandomClient());
        }
        for (Person person : service.getPeople()) {
            System.out.println(person.getSurname() + ": " + person.getAge());
        }
        Arrays.sort(service.getPeople(), service);
        System.out.println("After sort:");
        for (Person person : service.getPeople()) {
            System.out.println(person.getSurname() + ": " + person.getAge());
        }
    }

    @Test
    public void testSortStorageComparable() {
        ClientService service = new ClientService();
        for (int i = 0; i < 10; i++) {
            service.addClient(getRandomClient());
        }
        Client[] clients = new Client[service.getStorageSize()];
        for (int i = 0; i < service.getStorageSize(); i++) {
            clients[i] = (Client)service.getPeople()[i];
        }
        Arrays.sort(clients);
        for (Client client : clients) {
            System.out.println(client.getSurname() + ": " + client.getAge());
        }
        System.out.println("After sort:");
        for (Client client : clients) {
            System.out.println(client.getSurname() + ": " + client.getAge());
        }
    }

    @Test
    public void testSortEmployeeComparator() {
        ClientService service = new ClientService();
        for (int i = 0; i < 10; i++) {
            service.addEmployee(getRandomEmployee());
        }
        for (Person person : service.getPeople()) {
            System.out.println(person.getSurname() + ": " + person.getAge());
        }
        Arrays.sort(service.getPeople(), Collections.reverseOrder());
        System.out.println("After sort:");
        for (Person person : service.getPeople()) {
            System.out.println(person.getSurname() + ": " + person.getAge());
        }
    }

    @Test
    public void testEmployeeSortComparable() {
        ClientService service = new ClientService();
        for (int i = 0; i < 10; i++) {
            service.addEmployee(getRandomEmployee());
        }
        Employee[] staff = new Employee[service.getStorageSize()];
        for (int i = 0; i < service.getStorageSize(); i++) {
            staff[i] = (Employee)service.getPeople()[i];
        }
        Arrays.sort(staff);
        for (Employee employee : staff) {
            System.out.println(employee.getSurname() + ": " + employee.getAge());
        }
        System.out.println("After sort:");
        for (Employee employee : staff) {
            System.out.println(employee.getSurname() + ": " + employee.getAge());
        }
    }
}
