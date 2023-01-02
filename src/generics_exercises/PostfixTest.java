package generics_exercises;

import java.util.Scanner;

public class PostfixTest {

    public static void main(String[] args) {

        PostfixEvaluator evaluator = new PostfixEvaluator();
        // Read user expressions
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter expression");
        String expression = input.nextLine();
        evaluator.evaluatePostfixExpression(expression);
    }
}
