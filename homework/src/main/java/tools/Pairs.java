package tools;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Pairs {

    // Complete the pairs function below.
    public static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        if (arr.length == 2) {
            if (arr[1] - arr[0] == k) {
                return 1;
            } else {
                return 0;
            }
        }
        int counter = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = arr.length - 2; j >= 0; j--) {
                if (arr[i] - arr[j] == k) {
                    counter++;
                    continue;
                }
                if (arr[i] - arr[j] > k) {
                    continue;
                }
            }
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
