package integerarrayssort;

import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumbers {
    public static Integer[] execute(int lenght, int max) {
        Random r = new Random();
        int arrayLenght = lenght;
        Integer[] randomNumbers = r.ints(arrayLenght, 0, max).boxed().collect(Collectors.toList()).toArray(new Integer[arrayLenght]);
        return randomNumbers;
    }

}
