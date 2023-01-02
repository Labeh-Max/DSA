package generics_exercises;


import generics.StackComposition;

public class InfixToPostfixConverter {

    private StringBuffer infix, postfix;

    private StackComposition<String> exp = new StackComposition<>();



    public void convertToPostfix(String expression){

        //any data cleaning required?
        //expression.matches("^[(0-9)+(\\()*]\\)*");
        infix = new StringBuffer(expression.replaceAll("\\s", ""));
        postfix = new StringBuffer();

        exp.push("("); //first left bracket push onto stack
        infix.append(")"); //append right bracket to infix


        //pass on infix from Left to Right
        String value;

        while(!exp.isEmpty()){
            for(int i = 0; i < infix.length(); i++){

                value = String.valueOf(infix.charAt(i));

                if(value.matches("\\d+")){ //Digit?
                    postfix.append(value);
                }

                if(value.matches("\\(")){ //is a left bracket?
                    exp.push(value);
                }

                if(isOperator(value)){ //is an operator
                    //System.out.println(value); debug line

                    //Yes, is an operator also at the top of the stack?
                    if(isOperator(exp.peek())){

                        //Yes, what is the level of precedence compared to infix operator
                        String operatorTwo = exp.peek();

                        if(precedence(value, operatorTwo)){ //operator 1 is lower in precedence

                            postfix.append(exp.pop());
                        }

                    }
                    exp.push(value);

                }

                if(value.matches("\\)")){ //is a right bracket

                    //pop operators until the top of the stack is a left bracket
                    while (!exp.peek().equals("(")){

                        postfix.append(exp.pop());
                    }

                    //pop last left bracket from stack
                    exp.pop();

                }

            }

        }

        System.out.println(postfix);

    }

    private boolean isOperator(String c){
        return c.matches("[+\\-*/^%]");
    }

    private boolean precedence(String operator1, String operator2){
        String [] operators = {" ", "^", "%", "/", "*",  "+", "-"};
        int operator1Index = 0;
        int operator2Index = 0;

        for(int i = 1; i < operators.length; i++){

            //check match
            if(operator1.equals(operators[i])){
                operator1Index = i;
            }
            if(operator2.equals(operators[i])){
                operator2Index = i;
            }

            if(operator1Index > 0 && operator2Index > 0){
                break;
            }
        }

        //operator 1 has a lower precedence than operator 2
        return operator1Index > operator2Index;
    }
}
