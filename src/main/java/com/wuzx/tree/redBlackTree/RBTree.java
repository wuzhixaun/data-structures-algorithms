package com.wuzx.tree.redBlackTree;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName RBTree.java
 * @Description 红黑树实现
 * @createTime 2022年04月18日 16:26:00
 */
public class RBTree {


    RBTreeNode root; //根节点


    /**
     * 遍历节点
     *
     * @param node
     */
    public void list(RBTreeNode node) {
        if (null == node) {
            return;
        }

        // 输出当前节点数据值
        System.out.println(node.key);
        // 终止条件
        if (null == node.left && null == node.right) {
            return;
        }

        list(node.left);
        list(node.right);
    }


    /**
     * 插入
     *
     * @param key
     */
    public void insetNode(int key) {
        // 创建一个node节点
        RBTreeNode node = new RBTreeNode(key);
        // 判断是否存在根节点
        if (null == root) {
            node.isBlack = true; // 根节点必须是黑色
            root = node;
            return;
        }

        // 从根节点，找到最下面的子节点
        RBTreeNode son = findSonNode(root, key);

        // 最先的子节点就是需要添加节点的父节点
        RBTreeNode parent = son;

        if (key < parent.key) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        node.parent = parent;




    }


    /**
     * 插入节点自平衡
     *
     * @param node 插入的节点
     */
    public void balanceInsert(RBTreeNode node) {
        RBTreeNode father; // 父节点
        RBTreeNode grandFather; // 祖父节点

        // 父亲结点是红色
        while (null != (father = node.parent) && father.isBlack == false) {
            grandFather = father.parent; // 祖父节点

            // 父亲节点是左孩子
            if (father == grandFather.left) {
                RBTreeNode uncle = grandFather.right; // 叔叔节点

                // 如果叔叔节点是红色，则需要变换颜色即可

                // 如果叔叔节点是空或者是黑色， 则需要右旋

            }

            // 父亲节点是右孩子
            if (father == grandFather.right) {
                // 如果叔叔节点是红色，则需要变换颜色即可



                // 如果叔叔节点是空或者是黑色， 则需要左旋


            }



        }



    }


    /**
     * 找到最小的子节点
     *
     * @param parent
     * @return
     */
    private RBTreeNode findSonNode(RBTreeNode parent, int key) {
        // 如果没有孩子节点返回父节点
        if (null == parent.left && null == parent.right) {
            return parent;
        }
        RBTreeNode son = null;
        if (key < parent.key) {
            son = findSonNode(parent.left,key);
        } else {
            son = findSonNode(parent.right, key);
        }

        return son;
    }


}
