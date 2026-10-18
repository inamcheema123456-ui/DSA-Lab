import java.util.Random;

public class MergeSort {
    public static void PrintArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= ei) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    public static void main(String[] args) {
        int arr[] = new int[1000];
        Random random = new Random(12345);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
        long start = System.nanoTime();
        // Time Complexity = O(nlogn)
        mergeSort(arr, 0, arr.length - 1);
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("********** Merge Sort Completed! ********");
        System.out.println("Total Elements:" + arr.length);
        System.out.println("Execution time in NanoSeconds:" + time);
        System.out.println("Execution time in MilliSeconds:" + time / 1_000_000.0);

        System.out.println("******** First 10 Sorted Elements *******");
        // PrintArr(arr);
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
