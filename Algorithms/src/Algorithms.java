import java.util.*;

public class Algorithms {

    public static void main(String[] args) {

        int[] arr = {3, 4, 3, 2, 3, -1, 3, 3};

        System.out.println(getRandomIndexOfDominator(arr));


        int[] arr1 = {3, 2, 1, 4};

        System.out.println(findMissingElementWithSum(arr1));

        System.out.println(findMissingElementWithSort(arr1));

        System.out.println(findMissingElementWithFreq(arr1));

    }

    private static int findMissingElementWithSum(int [] array) {
        int arraySum = 0;
        for(int number : array) {
            arraySum += number;
        }

        int expectedSum = 0;
        for(int i = 1; i <= array.length + 1; i++) {
            expectedSum += i;
        }

        return expectedSum - arraySum;
    }

    private static int findMissingElementWithFreq(int[] array) {

        for(int i = 1; i <= array.length + 1; i++) {
            int count = 0;
            for (int elem : array) {
                if (elem == i) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                return i;
            }
        }
        return  -1;
    }

    private static int findMissingElementWithSort(int[] array) {
        sortArray(array);

        if (array.length + 1 != array[array.length - 1]) {
            return array.length + 1;
        }

        for (int i = 1; i < array.length + 1; i++) {

            if ( ! (i == array[i - 1])) {
                return i;
            }
        }
        return -1;
    }

    private static void sortArray(int[] array) {
        boolean swapOccurred;
        for (int i = 0; i < array.length; i++) {
            swapOccurred = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapOccurred = true;
                }
            }
            if (!swapOccurred) {
                break;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    private static int getRandomIndexOfDominator(int[] array) {
        if (array.length == 0) {
            return -1;
        }

        int target = array.length / 2;
        int counter;

        List<Integer> dominators = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            counter = 0;
            dominators.clear();
            dominators.add(i);
            for (int j = 1; j < array.length ; j++) {
                if (array[i] == array[j]) {
                    dominators.add(j);
                    counter++;
                    if (counter == target) {
                        int index = random.nextInt(dominators.size());
                        return dominators.get(index);
                    }
                }
            }
        }
        return -1;
    }
}
