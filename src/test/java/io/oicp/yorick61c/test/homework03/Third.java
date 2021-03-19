package io.oicp.yorick61c.test.homework03;

public class Third {

    public static void reverse(int[] array){

        int j = array.length - 1;

        for (int i = 0; i < array.length / 2; i++, j--) {

            int t;

            t = array[i];

            array[i] = array[j];

            array[j] = t;

        }

    }

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6};

        System.out.println("before reverse:");

        for (int value : a) {

            System.out.print(value + " ");

        }

        System.out.println();

        reverse(a);

        System.out.println("after reverse:");

        for (int value : a) {

            System.out.print(value + " ");

        }

    }
}
