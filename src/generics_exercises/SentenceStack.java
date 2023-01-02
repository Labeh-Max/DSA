package generics_exercises;

import generics.EmptyListException;
import generics.StackComposition;

import java.util.Scanner;

public class SentenceStack {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StackComposition<String> sentence = new StackComposition<>();

        //prompt user for input
        System.out.println("Please write sentence:");
        String text = input.nextLine();

        String [] arraySentence = text.split("\s");

        //push array elements into stack

        for(String word : arraySentence){
            System.out.println(word);
            sentence.push(word);
        }

        //pop items in stack
        try{
            while (true){

               System.out.println(sentence.pop());

            }
        }
        catch (EmptyListException emptyListException){
            emptyListException.printStackTrace();
        }



    }
}
