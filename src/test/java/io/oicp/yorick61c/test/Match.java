package io.oicp.yorick61c.test;

public class Match {

    public static int minInsertions(String s) {

        char[] str = s.toCharArray();

        int sum = 0 , left = 0;

        for(int i = 0 ; i < str.length; i++){

            if (str[i] == '('){

                left++;

            } else {

                if(left == 0) sum++;

                else left--;

                if (i == str.length -1 || str[i+1] != ')') sum++;

                else i++;

            }

        }

        return sum + 2 * left;

    }

    public static void main(String[] args) {

        String str = "))(";

        System.out.println(minInsertions(str));
    }
}
