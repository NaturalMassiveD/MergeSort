/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author teel6
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    //separate the initial array into parts then reassemble
    void merge(int arr[], int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
 
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        for (int i=0; i<n1; ++i){
        L[i] = arr[left + i];
        }
        for (int j=0; j<n2; ++j){
        R[j] = arr[mid + 1+ j];
        }
        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2){
        if (L[i] <= R[j]){
            arr[k] = L[i];
            i++;
            }
            else{
            arr[k] = R[j];
            j++;
            }
            k++;
        }
 
        while (i < n1){
        arr[k] = L[i];
        i++;
        k++;
        }

        while (j < n2){
        arr[k] = R[j];
        j++;
        k++;
        }
    }
 
    //sort the values
    void sort(int arr[], int l, int r){
    if (l < r){
        int m = (l+r)/2;
        sort(arr, l, m);
        sort(arr , m+1, r);
        merge(arr, l, m, r);
        }
    }

    //generate 15 random integers from the range 1-100 then sort it into numerical order
    public static void main(String[] args) {
        System.out.println("The randomized starting array is: ");
        int number = 15;
        int[] input = new int[number];
        for(int i = 0; i < number; i++){
            int Random = (int)(Math.random()*100);
            input[i] = Random;
        }
        System.out.println(java.util.Arrays.toString(input));
        MergeSort sort = new MergeSort();
        sort.sort(input, 0, input.length-1);
        System.out.println("The sorted array is: ");
        System.out.println(java.util.Arrays.toString(input));
    }
}
