package model;

import java.util.*;

public class AutoBoxer {

    public static void main(String[] args) {
        /*int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = i;
        }
        cleanupArray(numbers);*/

        List<Integer> n2 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            n2.add(i);
        }
        ListIterator<Integer> iterator = n2.listIterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (value % 2 != 0) {
                iterator.remove();
            }
        }

        /*for (int i : n2) {
            n2.remove(i);
        }*/
        for (int i : n2) {
            System.out.println("i = " + i);
        }

//        for (int in : numbers) {
//            System.out.println("in = " + in);
//        }
//        for (int i = 10; i < 99; i++) {
//            numbers.add(i);
//        }
//
//        Integer integ = 7;
//        System.out.println("result = " + (integ + 4));
    }

    private static int[] cleanupArray(int[] input) {
        return input;
    }
}
