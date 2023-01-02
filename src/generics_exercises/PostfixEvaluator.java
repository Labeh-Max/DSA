package generics_exercises;

import generics.EmptyStackException;
import generics.StackComposition;

public class PostfixEvaluator {

    private StringBuffer postfix;


    private StackComposition<String> exp = new StackComposition<>();

    public void evaluatePostfixExpression(String expression){

        postfix = new StringBuffer(expression.replaceAll("\\s", ""));
        postfix.append(")");

        int charPosition = 0;
        char character;

        while (postfix.charAt(charPosition) != ')'){

            //Begin reading from L -> R
            character = postfix.charAt(charPosition);

            if(isDigit(character)){
                int intChar = character;
                int zero = '0';
                intChar = intChar - zero;
                exp.push(String.valueOf(intChar));

            }
            else if(isOperator(String.valueOf(character))){

                String x;
                String y;

                try {
                    x = exp.pop();
                    y = exp.pop();

                    exp.push(calculate(x, y, character));


                }
                catch (EmptyStackException exception){
                    System.out.println(exception.getMessage());
                }

            }

            ++charPosition;

        }

        System.out.println(exp.pop());


    }

    private boolean isDigit(char character){
        return String.valueOf(character).matches("\\d+");
    }
    private boolean isOperator(String c){
        return c.matches("[+\\-*/^%]");
    }
    private String calculate(String x, String y, char operator){

        int xNum = Integer.parseInt(x);
        int yNum = Integer.parseInt(y);
        int solution = switch (operator) {
            case '/' -> yNum / xNum;
            case '-' -> yNum - xNum;
            case '*' -> xNum * yNum;
            case '+' -> xNum + yNum;
            case '^' -> (int) Math.pow(yNum, xNum);
            case '%' -> yNum % xNum;
            default -> 0;
        };

        return String.valueOf(solution);

    }
}
