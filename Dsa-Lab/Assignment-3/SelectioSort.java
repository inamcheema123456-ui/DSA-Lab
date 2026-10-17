import java.util.*;
public class SelectioSort {
     public static void PrintArr(int arr[]){
        for(int i = 0; i <arr.length;i++){
        System.out.print(arr[i]+" ");
    }
}

public static void main(String[] args){
    int arr[]= new int[1000];
    Random random = new Random(12345);
    for(int i = 0; i <arr.length;i++){
        arr[i] = random.nextInt(1000);
    }
   
    long start = System.nanoTime();
    //Selection Sort
    for(int i = 0;i<arr.length-1;i++){ // n-1
           int smallest  =i;
           for(int j = i+1; j<arr.length;j++){ //n(n-1)
            if(arr[smallest]>arr[j]){
                smallest = j;
            }
           }
           int temp = arr[smallest];
           arr[smallest] = arr[i];
           arr[i] = temp;
    }

     //Time Complexity = O(n^2)

    long end = System.nanoTime();
    long time = start-end;
     System.out.println("********** Selection Sort Completed! ********");
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