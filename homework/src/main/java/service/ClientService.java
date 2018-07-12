package service;

import model.Client;
import model.Employee;
import model.Person;

import java.util.*;

public class ClientService implements Comparator<Person> {

    private List<Person> people = new ArrayList<>();
    private Map<String, Person> mapOfEmails = new HashMap<>();
    private int counter = 0;

    public void addClient(int age, String email, String name, String surname, String phone) {
        createPerson(new Client(age, email, name, surname, phone));
    }

    public void addClient(int age, boolean isRegular, String email, String name, String surname, String phone) {
        createPerson(new Client(age, isRegular, email, name, surname, phone));
    }

    public void addClient(Client client) {
        createPerson(client);
    }

    public void addEmployee(int age, String email, String name, String surname, String phone) {
        createPerson(new Employee(age, email, name, surname, phone));
    }

    public void addEmployee(Employee employee) {
        createPerson(employee);
    }

    public int getStorageSize() {
        return people.size();
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person findPersonByEmail(String email) {
        return mapOfEmails.get(email);
    }

    private void createPerson(Person person) {
        people.add(person);
        if (person.getEmail() != null && !mapOfEmails.containsKey(person.getEmail())) {
            mapOfEmails.put(person.getEmail(), person);
        }
    }

    public Person updatePerson(String email, int age, String name, String surname, String phone) {
        Person toUpdate = findPersonByEmail(email);
        if (toUpdate != null) {
            toUpdate.setAge(age);
            toUpdate.setName(name);
            toUpdate.setSurname(surname);
            toUpdate.setPhone(phone);
        }
        return toUpdate;
    }

    public Client getClient(String email) throws IllegalStateException {
        Person personByEmail = findPersonByEmail(email);
        if (personByEmail instanceof Client) {
            return (Client) personByEmail;
        }
        throw new IllegalStateException("It is not Client!");
    }

    public boolean deleteClient(String email) {
        Person person = findPersonByEmail(email);
        return people.remove(person);
    }

    @Override
    public int compare(Person client1, Person client2) {
        return client1.getAge() - client2.getAge();
    }
}
