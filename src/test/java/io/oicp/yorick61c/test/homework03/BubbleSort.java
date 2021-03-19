package io.oicp.yorick61c.test.homework03;

public class BubbleSort {

    public int[] bbSort(int[] a){

        for (int i = 0; i < a.length; i++) {

            for (int j = i; j < a.length; j++) {

                if (a[i] < a[j]){

                    int t = a[i];

                    a[i] = a[j];

                    a[j] = t;

                }

            }
        }

        return a;
    }
}
