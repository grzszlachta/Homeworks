package tools;

import java.util.*;
/*
https://www.hackerrank.com/challenges/java-stack
 */
class JavaStack {

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            for (String s : input.split("\n")) {
                System.out.println(isBalanced(s));
            }
        }

    }

    public static boolean isBalanced(String input) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : input.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else {
                Character select = getPair(c);
                if (select == null || stack.isEmpty()) {
                    return false;
                }
                Character peek = stack.peek();
                if (peek != select) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size() == 0;
    }

    private static boolean isOpen(char input) {
        return input == '(' || input == '[' || input == '{';
    }

    private static Character getPair(char input) {
        switch(input) {
            case ')': return '(';
            case ']': return '[';
            case '}': return '{';
        }
        return null;
    }
}