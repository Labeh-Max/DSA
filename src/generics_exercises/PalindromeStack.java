package generics_exercises;

import generics.EmptyStackException;
import generics.Stack;

import java.util.Scanner;

public class PalindromeStack {

    public static void main(String[] args) {

        //stack to hold letters of the string
        Stack<String> letterStack = new Stack<>();

        //Scanner object to take user input
        Scanner input = new Scanner(System.in);

        //Take user input
        System.out.println("Please enter a word");
        String text = input.nextLine().replaceAll("\\W", "");

        String [] splitText  = text.split("");

        //push letters into stack
        for(String letter : splitText){

            letterStack.push(letter);
        }

        String reverseWord = "";
        try {
            while (true){
              reverseWord += letterStack.pop();
            }
        }
        catch (EmptyStackException ex){
            //ex.printStackTrace();
        }

        System.out.println(reverseWord.equals(text));


    }
}
