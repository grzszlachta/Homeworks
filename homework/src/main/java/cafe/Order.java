package cafe;

public class Order {

    private Dish dish;
    private int number;

    public Order(Dish dish, int number) {
        this.dish = dish;
        this.number = number;
        System.out.println("Order with " + number +  " " + dish + " created");
    }

}
