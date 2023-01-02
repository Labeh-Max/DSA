package generics_exercises;

public class TypeEquals {

    public static void main(String[] args) {

        Object number = new Object();
        Object value = new Object();

        System.out.println(isEqualTo(number, value));


    }

    public static <T> boolean isEqualTo(T arg1, T arg2){

       return arg1.equals(arg2);
    }
}
