package cafe;

public class Dish {

    private String name;

    public Dish(String name) {
        this.name = name;
        System.out.println("Dish " + name + " created");
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                '}';
    }
}
