package generics_exercises;
import generics.List;

import java.util.LinkedList;


public class ListConcatenate {

    public static <E extends Comparable<E>> void concatenate(LinkedList<E> listOne, LinkedList<E> listTwo){

        listOne.addAll(listTwo);

        System.out.println(listOne);


    }
}
