package com.wuzx.strmatch.trie;

import com.wuzx.tree.binarytree.TreeNode;

public class TrieNode {


    char data; // 数据
    TrieNode[] children = new TrieNode[26];
    boolean isLeaf = false;

    public TrieNode(char data) {
        this.data = data;
    }
}
