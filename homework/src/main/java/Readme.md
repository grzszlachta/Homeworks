## HomeWork 9

1. On template of ClientServiceTest#testAddClient write a test to verify expanding
storage of ClientService.
Use service.getClients and service.getStorageSize to prove it.

2. On the basis of ClientTest and EmployeeTest set of clients and employees, write a test in ClientServiceTest to count average discount:
Client client1 = new Client(29, false, "a@email.com", "Ivan", "Ivanov", "+4812345678");
Client client2 = new Client(35, true, "b@outlook.com", "Jan", "Kowalsky", "+4898765432");
Client client3 = new Client(17, true, "c@gmail.com", "John", "Smith", "+482345678");
Client client4 = new Client(17, true, "c@gmail.com", "John", "Smith", "+482345678");
new Employee(29, "a@email.com", "Ivan", "Ivanov", "+4812345678")
Use addClient and addEmployee to put them is storage

3. [BONUS] On the basis of Fibonacci, write a program to print out combinations of input string.
For example: 
"ab" => "ab", "ba" [2]
"abc" => "abc", "acb", "bac", "bca", "cab", "cba" [6]
"abcd" => ... [24]