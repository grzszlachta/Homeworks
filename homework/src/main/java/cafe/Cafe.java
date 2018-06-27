package cafe;

public class Cafe {

    public static void main(String[] args) {
        Table[] tables = new Table[5];
        for (int i = 0; i < 5; i++) {
            tables[i] = new Table(i + 1);
        }
        Dish salad = new Dish("Salad");
        Dish drink = new Dish("whiskey");
        Order[] orderMain = new Order[2];
        orderMain[0] = new Order(salad, 2);
        orderMain[1] = new Order(drink, 3);
        tables[2].addOrder(orderMain);
    }
}
