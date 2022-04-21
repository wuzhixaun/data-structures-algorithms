package com.wuzx.strmatch;


/**
 * RK算法
 */
public class RabinKarp {

    /**
     * 支持 a-z 二十六进制 * 获得字符串的hash值 * @param src
     *
     * @return
     */
    public static int strToHash(String src) {
        int hash = 0;
        for (int i = 0; i < src.length(); i++) {
            hash *= 26;
            hash += src.charAt(i) - 97;
        }
        return hash;
    }


    public static boolean isMatch(String main, String sub) {
        //算出子串的hash值
        int hash_sub = strToHash(sub);
        for (int i = 0; i <= (main.length() - sub.length()); i++) {
            // 主串截串后与子串的hash值比较
            if (hash_sub == strToHash(main.substring(i, i + sub.length()))) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(isMatch("abcvdcd","vdcd"));
    }

}
