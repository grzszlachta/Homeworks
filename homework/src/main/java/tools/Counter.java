package tools;

public class Counter {

    public static void main(String[] args) {
        System.out.println("Counted.counter = " + Counted.counter);
        new Counted();
        new Counted();
        System.out.println("Counted.counter = " + Counted.counter);
        new Counted();
        new Counted();
        new Counted();
        System.out.println("Counted.counter = " + Counted.counter);

    }
}
