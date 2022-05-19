package com.leetcode.code;

import java.util.Stack;

/**
 * @Description:
 * @ClassName: Code227
 * @Author: ZK
 * @Date: 2021/3/11 19:37
 * @Version: 1.0
 */
public class Code227 {

    public static void main(String[] args) {
        String s = " 3/2 ";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
//        定义栈，用于保存遍历的数字
        Stack<Integer> stack = new Stack<>();
//        用来计算最终的结果
        int res = 0;
//        用来保存当前遍历的数字
        int num = 0;
//        当前数字前边的运算符，切记当前数字前边的
        char preSign = '+';

        for (int i = 0; i < len; i++) {
//            获取到当前字符
            char c = chars[i];
//            如果当前字符为一个数字，则用num来保存
            if (c >= '0' && c <= '9') {
//                例如：123+4，此时 num 应累加为123
                num = num * 10 + c - '0';
            }
//            如果当前字符为运算符，或者是最后一位
            if ( (c=='+' || c=='-' || c=='*' || c=='/') || i==len-1) {
//                对于 num 前边的运算符进行判断
                switch (preSign) {
//                    如果是加号，则将num入栈
                    case '+':
                        stack.push(num);
                        break;
//                    如果是减号，则将 num 的相反数 -num 入栈
                    case '-':
                        stack.push(-num);
                        break;
//                    如果是乘号，则将栈顶元素取出，与当前的 num 相乘，结果再入栈
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
//                    如果是除号，则将栈顶元素取出，与当前的 num 相除，结果再入栈
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
//                对应40行的判断，如果当前字符为运算符，则 preSign 就是当前运算符了
//                如果当前字符是最后一位，则 preSign 就没有作用了，其无论记录什么都不影响结果
                preSign = chars[i];
//                表示遇到符号了，num 应重新开始保存下一个数字，故置为0
                num = 0;
            }
        }
//        元素出栈，逐一相加即可，因为遇到减号的时候，保存的是减号后边数字的相反数
//        例如3-2，栈中的元素为[3，-2],直接计算-2+3即可，和3-2的结果是一样
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

}