import java.util.*;

class MergeSort{
    //Merging sorted array
    public static void merge(int[] arr, int beg, int mid, int end){
        //Getting max value of arrays
        int n1 = mid - beg + 1;
        int n2 = end - mid;

        //Creating temp array
        int[] l = new int [n1];
        int[] r = new int [n2];

        //Copying data to temp array
        for(int i = 0; i<n1; ++i){
            l[i] = arr[beg + i];
        }
        for(int j = 0; j<n2; ++j){
            r[j] = arr[(mid+1) + j];
        }

        int i = 0, j = 0, k = beg;

        //Sorting array
        while(i < n1 && j < n2){
            if(l[i] <= r[j]){
                arr[k] = l[i];
                i++;
            } else {
                arr[k] = r[j];
                j++;
            }
            k++;
        }
        //Copying remaining data of left array
        while(i < n1){
            arr[k] = l[i];
            i++;
            k++;
        }
        //Copying remaining data of right array
        while(j < n2){
            arr[k] = r[j];
            j++;
            k++;
        }
        
    }
    //Function to divide array
    public static void mergeSort(int[] arr, int beg, int end){

        if(beg < end){
            int mid = (beg + end)/2;
            mergeSort(arr, beg, mid);
            mergeSort(arr, mid+1, end);
            //Merging array
            merge(arr, beg, mid, end);
        }
    }
    //Funtion to print array
    public static void printArray(int[] arr){
        for (int item : arr) {
            System.out.print(item + ", ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {45, 86, 92, 42, 29, 63, 53, 74};
        printArray(arr);
        //getting length of array
        int n = arr.length;
        mergeSort(arr, 0, n-1);
        System.out.print("\n");
        printArray(arr);
    }
}