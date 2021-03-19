package io.oicp.yorick61c;

public class HeapSort {

    public void swap(int[] arr, int i, int j){ //交换函数，传址交换该数组内的值

        int t = arr[i];

        arr[i] = arr[j];

        arr[j] = t;


    }

    public void adjustHeap(int[] arr, int parent, int length){  //构建大根堆函数

        int temp = arr[parent]; //存储父节点的值

        int child = parent * 2 + 1; //找到左子节点

        while (child < length){

            if (child + 1 < length && arr[child] < arr[child+1] ) //如果右子节点的值存在且大于左子节点，就定位到右子节点

                child++;

            if (temp >= arr[child]) //如果父节点的值大于两个子节点，那么就退出循环

                break;

            arr[parent] = arr[child]; //父节点的值小于某个子节点的值就交换

            parent = child; //继续构建

            child = 2 * child + 1;

        }

        arr[parent] = temp;//此时parent指代上一次的child，将temp中存储的较小的值赋给上一次的子节点

    }

    public void heapSort(int[] arr){  //堆排序算法

        for (int i = arr.length / 2; i >= 0 ; i--) {//先找到最后一个非子结点，构建大根堆

            adjustHeap(arr,i,arr.length);

        }

        //已经构建好大根堆，根节点就是最大的元素。将最大的元素置于数组末尾，并重新构建大根堆，重复至数组中最后一个元素。
        for (int i = arr.length - 1; i > 0 ; i--) {

            swap(arr,0,i);

            adjustHeap(arr,0,i);

        }
    }

    public static void main(String[] args) {

        int[] arr = {5,4,3,2,1};

        new HeapSort().heapSort(arr);

        for (int value : arr) {

            System.out.print(value);

        }
    }
}
