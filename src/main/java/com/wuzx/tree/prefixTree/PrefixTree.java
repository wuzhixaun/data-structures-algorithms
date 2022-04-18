package com.wuzx.tree.prefixTree;


import org.apache.commons.lang.StringUtils;

import java.util.HashMap;

/**
 * 前缀树
 */
public class PrefixTree {


    public static void main(String[] args) {
        Trie trie = new Trie();
        
        
        trie.insert("abc");
        trie.insert("abc");
        trie.insert("abcd");
        trie.insert("baa");


        System.out.println(trie.search("baaa"));
        
    }
    
}


class Node {
    // 字节通过次数
    public int pass;

    // 字节结尾次数
    public int end;

    // node
    HashMap<Integer, Node> nexts;

    public Node() {
        this.pass = 0;
        this.end = 0;
        nexts = new HashMap<>();
    }
}

class Trie {

    // 初始化一个头结点
    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        if (StringUtils.isEmpty(word)) {
            return;
        }

        Node node = root;
        node.pass++;
        final char[] chars = word.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {

            int index = (int) chars[i];

            if (!node.nexts.containsKey(index)) {
                node.nexts.put(index, new Node());
            }

            node = node.nexts.get(index);
            node.pass++;
        }

        node.end++;
    }


    /**
     * 删除
     * @param word
     */
    public void delete(String word) {
        if (StringUtils.isEmpty(word)) {
            return;
        }
        
        // 查询是否有这个字段

        if (search(word) == 0) {
            return;
        }

        Node node = root;
        node.pass--;
        final char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i];

            if (--node.nexts.get(index).pass == 0) {
                node.nexts.remove(index);
                return;
            }

            node = node.nexts.get(index);
        }
        node.end--;
    }

    /**
     * word这个单词之前加入过几次
     * @param word
     * @return
     */
    public int search(String word) {
        if (StringUtils.isEmpty(word)) {
            return 0;
        }

        Node node = root;
        final char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            final int index = chars[i];

            // 中途如果不存在下一个则就是不存在
            if (!node.nexts.containsKey(index)) {
                return 0;
            }

            node = node.nexts.get(index);
        }
        
        return node.end;
    }


    /**
     * 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
     * @param word
     */
    public int prefixNumber(String word) {
        if (StringUtils.isEmpty(word)) {
            return 0;
        }
        
        Node node = root;
        final char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            final int index = chars[i];

            if (!node.nexts.containsKey(index)) {
                return 0;
            }
            node = node.nexts.get(index);
        }
        return node.pass;
    }
}
