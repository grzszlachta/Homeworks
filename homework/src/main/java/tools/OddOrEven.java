package tools;

import java.util.Arrays;
import java.util.Random;

public class OddOrEven {

    private static Random random = new Random();

    public static void main(String[] args) {
        int size = random.nextInt(28) + 1;
        System.out.println("size = " + size);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(99) + 1;
        }
        countOddAndEven(array);
    }

    public static void countOddAndEven(int[] input) {
        int counterEven = 0;
        System.out.println(Arrays.toString(input));
        for (int i : input) {
            if (i % 2 == 0) {
                counterEven++;
            }
        }
        System.out.println("counterOdd = " + (input.length - counterEven));
        System.out.println("counterEven = " + counterEven);
    }

}
