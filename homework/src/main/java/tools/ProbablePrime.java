package tools;

public class ProbablePrime {

    public static void main(String[] args) {
        System.out.println("5 prime => " + checkIsPrime(5));
        System.out.println("7 prime => " + checkIsPrime(7));
        System.out.println("10 prime => " + checkIsPrime(10));
        System.out.println("11 prime => " + checkIsPrime(11));
    }

    public static boolean checkIsPrime(int input) {
        for (int i = 2; i <= input / 2; i++) {
            System.out.println("i = " + i);
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }
}
