package recursion;

//LC 784

public class LetterCaseTransformations {

    private static void printTransformations(String input, String partial_solution) {
        //Base Case
        if (input.length() == partial_solution.length()) {
            System.out.println(partial_solution);
            return;
        }
        int i = partial_solution.length();
        if (Character.isDigit(input.charAt(i))) {
            printTransformations(input, partial_solution + input.charAt(i));
        } else {
            printTransformations(input, partial_solution + Character.toLowerCase(input.charAt(i)));
            printTransformations(input, partial_solution + Character.toUpperCase(input.charAt(i)));
        }
    }


    public static void main(String[] args) {
        /*
        input - "a1b2"
        output - "a1b2", "A1b2", "A1B2", "a1B2"
         */
        printTransformations("a1b2", "");


    }

}
