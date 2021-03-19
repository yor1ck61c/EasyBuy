package io.oicp.yorick61c.test;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {

        if (low < high){

            int std = getStd(arr, low, high);

            quickSort(arr, 0,std - 1);

            quickSort(arr, std + 1, high);

        }
    }

    private static int getStd(int[] arr, int low, int high) {

        int std = arr[low];

        while (low < high && arr[high] >= std)

            high--;

        arr[low] = arr[high];

        while (low < high && arr[low] <= std)

            low++;

        arr[high] = arr[low];

        arr[low] = std;

        return low;

    }

    public static void main(String[] args) {

        int[] arr = {-1,2,-8,-10};

        quickSort(arr,0,3);

        for (int value : arr) {

            System.out.print(value + " ");

        }
    }
}
