package com.wuzx.algorithmicThinking.divide;


/**
 * 字符串转成大写
 */
public class CharToSupper {



    public  static char toUpCaseUnit(char c){
        int n=c;
        if (n<97 || n>122){
            return ' ';
        }
        return (char)Integer.parseInt(String.valueOf(n-32));
    }


    public static char[] toUpCase(char[] chars, int i) {

        if (i >= chars.length) {
            return chars;
        }


        chars[i]=toUpCaseUnit(chars[i]);
        return toUpCase(chars, i + 1);
    }

    public static void main(String[] args) {
        String ss="abcde";
        System.out.println(toUpCase(ss.toCharArray(),0));
    }


}
