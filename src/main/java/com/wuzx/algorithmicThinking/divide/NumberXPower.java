package com.wuzx.algorithmicThinking.divide;


/**
 * x的n次幂问题
 */
public class NumberXPower {


    public static void main(String[] args) {
        System.out.println(commpow(2, 3));
        System.out.println(commpow(2, 4));
    }

    public static int commpow(int x,int n) {
        if(n==1) return x;

        int half = commpow(x, n / 2);

        // 偶次幂
        if (n % 2 == 0) {
            return half * half;
        }

        // 奇次幂
        return half * half * x;
    }
}
