package com.wuzx.strmatch.trie;

public class Trie {


    TrieNode root = new TrieNode('/'); // 根节点


    /**
     * 插入到trie树
     * @param chars
     */
    public void insert(char[] chars) {
        TrieNode p = root;

        for (int i = 0; i < chars.length; i++) {
            // 得到索引位
            int index = chars[i] - 97;

            if (p.children[index] == null) {
                TrieNode node = new TrieNode(chars[i]);
                p.children[index] = node;
            }

            p = p.children[index];
        }

        p.isLeaf = true;
    }


    public boolean find(char[] patten) {
        TrieNode p = root;

        for (int i = 0; i < patten.length; i++) {
            // 得到索引位
            int index = patten[i] - 97;

            if (p.children[index] == null) {
                return false;
            }

            p = p.children[index];
        }

        if (p.isLeaf = false) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("hello".toCharArray());
        trie.insert("her".toCharArray());
        trie.insert("hi".toCharArray());
        trie.insert("how".toCharArray());
        trie.insert("see".toCharArray());
        trie.insert("so".toCharArray());

        System.out.println(trie.find("hi".toCharArray()));
        System.out.println(trie.find("hello".toCharArray()));

    }


}
