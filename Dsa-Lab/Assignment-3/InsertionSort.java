import java.util.*;
public class InsertionSort {
  
     public static void PrintArr(int arr[]){
        for(int i = 0; i <arr.length;i++){
        System.out.print(arr[i]+" ");
    }
}

public static void main(String[] args){
    int arr[]= new int[1000];
    Random random = new Random(12345);
    for(int i = 1; i<arr.length;i++){
        arr[i] = random.nextInt(1000);
    }

   long start = System.nanoTime();

    //Insertion Sort
    for(int i = 1; i<arr.length;i++){
        int current = arr[i];
        int j = i-1;
        while(j>=0 && current < arr[j] ){
            arr[j+1]= arr[j];
            j--;
        }
        //Placement
        arr[j+1] = current;

    }  //Time Complexity = O(n^2)
    long end = System.nanoTime();
    long time = end-start;
      System.out.println("********** Insertion Sort Completed! ********");
          System.out.println("Total Elements:" +arr.length);
           System.out.println("Execution time in NanoSeconds:" +time);
            System.out.println("Execution time in MilliSeconds:" +time/1_000_000.0);

      System.out.println("******** First 10 Sorted Elements *******");
            // PrintArr(arr);
            for(int i = 0; i<10;i++){
                 System.out.print(arr[i] + " ");
  
  
}
}
}
