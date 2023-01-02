package generics_exercises;

public class Pair <F, S>{

    F firstElement;
    S secondValue;

    public Pair(F first, S second){
        this.firstElement = first;
        this.secondValue = second;
    }

    public void setFirstElement(F firstElement) {
        this.firstElement = firstElement;
    }

    public F getFirstElement() {
        return firstElement;
    }

    public void setSecondValue(S secondValue) {
        this.secondValue = secondValue;
    }

    public S getSecondValue() {
        return secondValue;
    }
}
