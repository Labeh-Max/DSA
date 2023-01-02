package generics_exercises;

import java.util.Random;

public class SortedListTest {
    public static void main(String[] args) {

        SortedList<Integer> sorted = new SortedList<>("sorted List");
        SortedList<Integer> sorted2 = new SortedList<>("second sorted List");
        Random random = new Random();

        for(int i = 0; i < 5; i++){
            sorted.insertAtFront(random.nextInt(101));
            sorted2.insertAtFront(random.nextInt(101));
        }

        sorted.merge(sorted2);


        sorted.print();
    }
}
