package integerarrayssort;

public class SortAlgorithm {

    public Integer[] sort(final Integer low, final Integer high, Integer[] array){
        System.out.println("low=" + low + " high=" + high);
        for (int i = low; i < high -1; i++) {
            for (int j = i+1; j < high; j++) {
                if(array[j] < array[i])
                {
                    swap(i, j, array);
                }
            }
        }
        return array;
    }
    public Integer[] sort(Integer[] array){
        return sort(0, array.length, array);
    }

    private void swap(int i, int j, Integer[] array) {
        Integer temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
