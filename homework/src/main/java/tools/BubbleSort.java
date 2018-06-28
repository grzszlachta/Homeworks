package tools;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] inputA = {99, 70, 50, 40, 20, 13, 12, 7, 6, 4, 3, 1};
        int[] input = {1, 2, 3, 12, 4, 5, 7, 9, 10};
        sort(input);
        Arrays.sort(inputA);
        System.out.println("inputA = " + Arrays.toString(inputA));

    }

    public static void sort(int[] input) {
//        printout(input);
        System.out.println("input = " + Arrays.toString(input));
        int counter = 1;
        boolean stop = false;
        for (int i = 0; i < input.length; i++) {
            stop = true;
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                    stop = false;
                }
            }
            if (stop) {
                break;
            }
            printout(input, counter++);
        }
        printout(input);
    }

    private static void printout(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static void printout(int[] array, int counter) {
        System.out.print("" + counter + ": ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
