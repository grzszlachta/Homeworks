package tools;

public class ReverseString {

    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++ ) {
            sb.append(chars[chars.length - i - 1]);
        }
        String result = sb.toString();
        System.out.println("result = " + result);
        return result;
    }
}
