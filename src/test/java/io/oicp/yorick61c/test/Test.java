package io.oicp.yorick61c.test;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static List<String> splitStr(String s){

        StringBuilder temp;

        char[] str = s.toCharArray();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < str.length;) {

            if (str[i] == '('){

                temp = new StringBuilder();

                while (i < str.length && str[i] == '('){

                    temp.append(str[i++]);

                }

                while (i < str.length && str[i] == ')'){

                    temp.append(str[i++]);

                }

                list.add(temp.toString());

            }

            if (i < str.length && str[i] == ')'){

                temp = new StringBuilder();

                while (i < str.length && str[i] == ')'){

                    temp.append(str[i++]);

                }

                list.add(temp.toString());

            }

        }

        return list;
    }

    public static int getCount(String s){

        int lc = 0, rc = 0;

        char[] str = s.toCharArray();

        if (str[0] == '('){

            for (char c : str) {

                if (c == '(') {

                    lc++;

                } else {

                    rc++;
                }

            }

            if (lc > rc){

                return  lc * 2 - rc;

            }else if (lc == rc){

                return rc * 2 - lc;

            }else {

                int t = rc - 2 * lc;

                if (t <= 0)

                    return -t;

                else {

                    if (t % 2 == 0)

                        return t/2;

                    else {

                        return ((t + 1 ) / 2) + 1;

                    }
                }

            }



        } else {

            int n = str.length ;

            if (n % 2 == 0)

                return n/2;

            else {

                return ((n + 1 ) / 2) + 1;

            }

        }

    }


    public static void main(String[] args) {

        List<String> list = splitStr("(((()(()((())))(((()())))()())))(((()(()()((()()))");

        System.out.println(list.toString());

        int count = 0;

        for (String s : list) {

            count += getCount(s);

        }

        System.out.println(count);

    }
}
