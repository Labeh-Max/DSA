package generics_exercises;

import java.util.LinkedList;
import java.util.List;

public class ListConTest {
    public static void main(String[] args) {

        //create first List

        Character one = 'a';
        LinkedList<Character> chOne = new LinkedList<>();
        LinkedList<Character> chTwo = new LinkedList<>();

        chOne.add('a');
        chTwo.add('e');

        ListConcatenate.concatenate(chOne, chTwo);




    }
}
