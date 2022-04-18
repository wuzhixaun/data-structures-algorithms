package com.wuzx.tree.redBlackTree;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName RBTreeNode.java
 * @Description 红黑树节点
 * @createTime 2022年04月18日 16:22:00
 */
public class RBTreeNode {

    public int key; // 值
    public boolean isBlack; // 是否是黑色节点
    public RBTreeNode parent; // 父节点
    public RBTreeNode left; // 左孩子
    public RBTreeNode right; // 右孩子

    public RBTreeNode(int key) {
        this.key = key;
        this.isBlack = false; //新节点默认是红色
    }


    @Override
    public String toString() {
        return "RBTreeNode{" +
                "key=" + key +
                ", cloor=" + (isBlack ? "black" : "red") +
                ", parent=" + parent +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

