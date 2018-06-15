package tools;

public class Fibonacci {

    private static long[] numbers = new long[129];

    public static void main(String[] args) {
        System.out.println("getNumber(128) = " + getNumber(128));
    }

    private static long getNumber(int position) {
        long result = 0;
        if (numbers[position] != 0) {
            result = numbers[position];
        } else if (position == 0 || position == 1) {
            result = 1;
        } else {
            result = getNumber(position - 2) + getNumber(position - 1);
        }
        System.out.println(position + " => " + result);
        numbers[position] = result;
        return result;
    }
}
