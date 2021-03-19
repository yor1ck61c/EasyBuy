package io.oicp.yorick61c.utils;

import java.util.Arrays;

public class algo {

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0, sum = 0;

        while (i < g.length && j < s.length) {

            if (s[j] >= g[i]) {

                i++;j++;sum++;

            } else {

                j++;

            }

        }

        return sum;

    }

    public static void main(String[] args) {

        int[] a = {1,2,3};

        int[] b = {1,1};

        System.out.println(findContentChildren(a,b));
    }
}
