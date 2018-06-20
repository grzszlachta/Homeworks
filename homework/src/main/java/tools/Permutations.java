package tools;

public class Permutations {

    public static String getAllPermutations(String input) {
        StringBuilder result = new StringBuilder();
        if (input.length() == 0) {

        }
        if (input.length() == 1) {
            result.append(input);
        }
        if (input.length() == 2) {
            String first = input.substring(0, 1);
            String second = input.substring(1, 2);
            result.append(first + second);
            result.append(" ");
            result.append(second + first);
        }
        if (input.length() > 2) {
            String first = input.substring(0, 1);
            String model = input.substring(1);
            String iteration = getAllPermutations(model);
            String[] cut = iteration.split(" ");
            for (String step : cut) {
                for (int i = 0; i <= step.length(); i++) {
                    result.append(step, 0, i).append(first).append(step, i, step.length()).append(" ");
                }
            }
        }
        return result.toString();
    }
}
