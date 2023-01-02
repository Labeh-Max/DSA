package generics_exercises;

import java.util.Arrays;

public class GenericSelectionSort{


    public <T extends Comparable<T>> void sort(T [] data ){
        int smallest; //index of smallest element

        //loop over data.length -1 elements
        for(int i = 0; i < data.length - 1; i++){
            smallest = i; //first index of remaining array

            //loop to find index of smallest element
            for(int index = i + 1; index < data.length; index++){
                if(data[index].compareTo(data[smallest]) < 0){
                    smallest = index;
                }

            }

           data =  swap(i, smallest, data); //swap smallest element into position
            printPass(i + 1, smallest, data); //output pass of algorithm
        }//end outer for

    }

    //helper method to swap values in two elements
    public <T extends Comparable<T>> T [] swap(int first, int second, T [] data){
        T temporary = data[first];
        data[first] = data[second];
        data[second] = temporary;
        return data;
    }

    //print a pass of the algorithm
    public <T extends Comparable<T>> void printPass(int pass, int index, T [] data){
        System.out.printf("after pass %2d: ", pass);

        //output elements till selected item
        for(int i = 0; i < index; i++){
            System.out.print(data[i] + " ");
        }

        System.out.print(data[index] + "* "); //indicate swap

        //finish outputting array
        for(int i = index + 1; i < data.length; i++){
            System.out.print(data[i] + " ");

        }
        System.out.print("\n               "); //for alignment

        //indicate amount of array that is sorted
        for(int j = 0; j < pass; j++)
            System.out.print("-- ");
        System.out.println("\n"); //add endline
    }

    //method to output values in array
//    public String toString(){
//        return Arrays.toString(data);
//    }
}
