package sortingalgorithmsbenchmark;

import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {

    public static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000000);
        }
        return arr;
    }

    public static int[] generateFullySortedArray(int n) {
        int[] arr = generateRandomArray(n);
        Arrays.sort(arr);
        return arr;
    }

    public static int[] generateReverselySortedArray(int n) {
        int[] arr = generateFullySortedArray(n);
        int[] revArr = new int[n];
        for (int i = 0; i < n; i++) {
            revArr[i] = arr[n - 1 - i];
        }
        return revArr;
    }

    public static int[] generatePartiallySortedArray(int n) {
        int[] arr = generateFullySortedArray(n);
        Random rand = new Random();
        int swaps = (int) (n * 0.2);
        for (int i = 0; i < swaps; i++) {
            int idx1 = rand.nextInt(n);
            int idx2 = rand.nextInt(n);
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
        return arr;
    }
}
