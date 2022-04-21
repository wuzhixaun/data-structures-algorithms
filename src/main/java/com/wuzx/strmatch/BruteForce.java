package com.wuzx.strmatch;


/**
 * BF算法
 */
public class BruteForce {


    public static boolean isMatch(String main, String sub) {

        for (int i = 0; i <= main.length() - sub.length(); i++) {

            if (sub.equals(main.substring(i, i + sub.length()))) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {

        String main = "hello";
        System.out.println(isMatch(main, "ll"));
        System.out.println(isMatch(main, "el"));
        System.out.println(isMatch(main, "le"));

    }
}
