package generics_exercises;

public class TestGenericsSort {

    public static void main(String[] args) {

        //Integer [] numbers = {3, 4, 5, 4, 8, 33, 32, 4, 34};
        Float [] dNumber = {3.0f, 4.0f, 5.89f, 4.5f, 10.34f, 1.0f, 7.26f};

        GenericSelectionSort test = new GenericSelectionSort();

        test.sort(dNumber);
    }
}
