package service;

import org.junit.Assert;
import org.junit.Test;

public class ClientServiceTest {

    @Test
    public void testAddClient() {
        ClientService service = new ClientService();
        service.addClient(29, "a@email.com",
                    "Ivan", "Ivanov", "+4812345678");
        Assert.assertEquals(10, service.getStorageSize());
    }
}
