package generics_exercises;

import java.util.Scanner;

public class TestInfixToPostfixCon {

    public static void main(String[] args) {

        InfixToPostfixConverter infixCon = new InfixToPostfixConverter();
        //Read user expressions
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter expression");
        String expression = input.nextLine();

        infixCon.convertToPostfix(expression);




    }




}
