package io.oicp.yorick61c.test;

public class OS {

    public int minInsertions(String s) {

        //转为字符串数组方便操作
        char[] str = s.toCharArray();

        //sum为需要插入的括号数，left为左括号计数器
        int sum = 0 , left = 0;

        for(int i = 0 ; i < str.length; i++){

            if (str[i] == '('){

                left++;

            } else {
                //匹配到右括号时
                //不是左括号，需要补一个
                if(left == 0) sum++;

                //左括号数量不为0时，消耗掉一个左括号
                else left--;

                //其他需要补右括号的情况（末尾，右括号下一个不是右括号）
                if (i == str.length -1 || str[i+1] != ')') sum++;

                //如果是连续两个右括号，则跳过下一个右括号
                else i++;

            }

        }
        //返回需要补的括号的个数 + 未被消耗掉的左括号需要匹配两个右括号
        return sum + 2 * left;

    }

}
