package sortingalgorithmsbenchmark;

import java.util.Arrays;

public class SortingBenchmark {

    public static void main(String[] args) {
        int n = 100000; // حجم البيانات المطلوب

        int[] randomArr = ArrayGenerator.generateRandomArray(n);
        int[] revSortedArr = ArrayGenerator.generateReverselySortedArray(n);
        int[] partialSortedArr = ArrayGenerator.generatePartiallySortedArray(n);
        int[] fullySortedArr = ArrayGenerator.generateFullySortedArray(n);

        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.printf("%-18s | %-18s | %-18s | %-18s | %-18s%n", 
    "Algorithm", "Random", "Reversely Sorted", "Partially Sorted", "Fully Sorted");
        
        System.out.println("---------------------------------------------------------------------------------------------------------");

        runAndPrintBenchmark("Selection Sort", randomArr, revSortedArr, partialSortedArr, fullySortedArr, 1);
        runAndPrintBenchmark("Insertion Sort", randomArr, revSortedArr, partialSortedArr, fullySortedArr, 2);
        runAndPrintBenchmark("Bubble Sort",    randomArr, revSortedArr, partialSortedArr, fullySortedArr, 3);
        runAndPrintBenchmark("Merge Sort",     randomArr, revSortedArr, partialSortedArr, fullySortedArr, 4);
        runAndPrintBenchmark("Quick Sort",     randomArr, revSortedArr, partialSortedArr, fullySortedArr, 5);
        
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }

    public static void runAndPrintBenchmark(String name, int[] rand, int[] rev, int[] part, int[] full, int choice) {
        long tRand = measureTime(rand, choice);
        long tRev = measureTime(rev, choice);
        long tPart = measureTime(part, choice);
        long tFull = measureTime(full, choice);

        System.out.printf("%-18s | %,15d μs | %,15d μs | %,15d μs | %,15d μs%n", 
                name, tRand, tRev, tPart, tFull);
    }

    public static long measureTime(int[] original, int choice) {
        int[] testArray = Arrays.copyOf(original, original.length);

        long startTime = System.nanoTime();

        switch (choice) {
            case 1: SortingAlgorithms.selectionSort(testArray); break;
            case 2: SortingAlgorithms.insertionSort(testArray); break;
            case 3: SortingAlgorithms.bubbleSort(testArray);    break;
            case 4: SortingAlgorithms.mergeSort(testArray, 0, testArray.length - 1); break;
            case 5: SortingAlgorithms.quickSort(testArray, 0, testArray.length - 1); break;
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000; // التحويل إلى ميكروثانية
    }
}
