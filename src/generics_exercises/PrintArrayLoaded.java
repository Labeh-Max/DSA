package generics_exercises;

public class PrintArrayLoaded {

    public static void main(String[] args) {

        //create arrays of Integer Double and Character
        Integer [] integerArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character [] characterArray = {'H', 'E', 'L', 'L', 'O'};
        String [] items = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        printArray(items);

        System.out.println("Array integerArray contains:");
        printArray(integerArray); //pass an Integer array
        System.out.println(printArray(integerArray, 0, 3));

        System.out.println("\nArray doubleArray contains:");
        printArray(doubleArray); //pass a Double array
        System.out.println(printArray(doubleArray, 4, 5));

        System.out.println("\nArray characterArray contains");
        printArray(characterArray); //pass a Character array
        System.out.println(printArray(characterArray, 1, 4));
    }

    //generic method printArray
    public static <T> void printArray(T [] inputArray){

        //display array elements
        for(T element : inputArray)
            System.out.printf("%s ", element);

        System.out.println();
    }

    //generic method but with lowSubscript and highSubscript
    public static <T> int printArray(T [] inputArray, int lowSubcript, int highSubscript){

        if(lowSubcript <= highSubscript && lowSubcript >= 0 && lowSubcript < inputArray.length && highSubscript < inputArray.length
        && highSubscript >= 0){

            for(int i = lowSubcript; i <= highSubscript; i++ ){
                System.out.printf("%s ", inputArray[i]);
            }

            System.out.println();

        }else{
            throw new InvalidSubscriptException();
        }

        return (highSubscript - lowSubcript) + 1;

    }

    //Nongeneric method with a
    public static void printArray(String [] items){

        System.out.printf("%s:\n", "Array stringArray contains");

        for(int i = 0; i < items.length; i++){

            if(i%4 == 0){
                System.out.println();
            }
            System.out.printf("%-9s",items[i]);

        }
    }
}
