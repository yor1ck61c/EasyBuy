package io.oicp.yorick61c.test.homework03;

import java.util.*;

public class Homework03 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<>();

        System.out.println("Enter the integers between 1 and 100: ");

        int temp = input.nextInt();

        map.put(temp,1);

        temp = input.nextInt();

        while (temp != 0){

            if (map.containsKey(temp)){

                Integer count = map.get(temp);

                map.put(temp,++count);

            }else {

                map.put(temp,1);

            }

            temp = input.nextInt();

        }

        for (Map.Entry<Integer,Integer> sum : map.entrySet()) {

            System.out.println(sum.getKey() + " occurs " + sum.getValue() + " times");

        }

    }

}