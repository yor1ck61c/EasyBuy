package io.oicp.yorick61c.test.homework03;

public class Second {

    public static int indexOfSmallestElement(double[] array){

        int index = 0;

        double temp = array[0];

        for (int i = 1; i < array.length; i++) {

            if (temp > array[i]) {

                temp = array[i];

                index = i;

            }

        }

        return index;

    }

    public static void main(String[] args) {

        double[] array = {6,2,2,5,2};

        System.out.println("最小下标为"+indexOfSmallestElement(array));

    }
}
