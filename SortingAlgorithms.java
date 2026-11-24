package sortingalgorithmsbenchmark;

public class SortingAlgorithms {

    // 1. Selection Sort
    public static void selectionSort(int[] data) {
        int n = data.length;
        if (n < 2) return;
        for (int i = 0; i < n - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[smallest]) {
                    smallest = j;
                }
            }
            int temp = data[i];
            data[i] = data[smallest];
            data[smallest] = temp;
        }
    }

    // 2. Insertion Sort
    public static void insertionSort(int[] data) {
        int n = data.length;
        if (n < 2) return;
        for (int i = 1; i < n; i++) {
            int temp = data[i];
            int j = i;
            while (j > 0 && data[j - 1] > temp) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = temp;
        }
    }

    // 3. Bubble Sort
    public static void bubbleSort(int[] data) {
        int n = data.length;
        if (n < 2) return;
        boolean swapped = true;
        for (int i = 0; swapped && i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    // 4. Merge Sort
    public static void mergeSort(int[] A, int left, int right) {
        if (left >= right) return;
        int middle = left + (right - left) / 2;
        mergeSort(A, left, middle);
        mergeSort(A, middle + 1, right);
        merge(A, left, middle, right);
    }

    public static void merge(int[] A, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = A[left + i];
        for (int j = 0; j < n2; j++) R[j] = A[middle + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k++] = L[i++];
            } else {
                A[k++] = R[j++];
            }
        }
        while (i < n1) A[k++] = L[i++];
        while (j < n2) A[k++] = R[j++];
    }

    // 5. Quick Sort
    public static void quickSort(int[] A, int left, int right) {
        if (left >= right) return;
        int middle = partition(A, left, right);
        quickSort(A, left, middle - 1);
        quickSort(A, middle + 1, right);
    }

    public static int partition(int[] A, int left, int right) {
        // اختيار عنصر المنتصف كمحور لتفادي أسوأ حالة مع المصفوفات المرتبة والعكسية
        int midIndex = left + (right - left) / 2;
        int tempMid = A[midIndex];
        A[midIndex] = A[right];
        A[right] = tempMid;

        int x = A[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (A[j] < x) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        int temp = A[i + 1];
        A[i + 1] = A[right];
        A[right] = temp;

        return i + 1;
    }
}