package integerarrayssort;

public class SortCheck {
    public boolean check(Integer[] array){
        for (int i = 0; i < array.length; i++) {
            if (i+1 == array.length){
                return true;
            }
            if (array[i] > array[i+1]){
             return false;
            }
        }
        return true;
    }
}
