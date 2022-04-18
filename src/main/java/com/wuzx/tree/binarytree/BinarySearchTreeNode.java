package com.wuzx.tree.binarytree;


/**
 * 二叉查找树
 */
public class BinarySearchTreeNode {


    private TreeNode root; // 根节点

    public void insertNode(int data) {
        root = insertNode(root, data);
    }


    /**
     *
     * @param node 当前数的根节点
     * @param data
     */
    public TreeNode insertNode(TreeNode node, int data) {
        if (null == node) {
            return new TreeNode(data);
        }


        if (data < node.data) {
            node.leftChild = insertNode(node.leftChild, data);
        } else if (data > node.data) {
            node.rightChild = insertNode(node.rightChild, data);
        } else{
            node.data = data;
        }
        return node;
    }


    /**
     * 前序遍历 根 左 右
     * @param node
     */
    public static void preorderTraversal(TreeNode node) {
        // 终止条件
        if (null == node) {
            return;
        }
        System.out.println(node.data);
        preorderTraversal(node.leftChild);
        preorderTraversal(node.rightChild);
    }


    /**
     * 中序遍历 左 根 右
     * @param node
     */
    public static void inorderTraversal(TreeNode node) {
        // 终止条件
        if (null == node) {
            return;
        }

        inorderTraversal(node.leftChild);
        System.out.println(node.data);
        inorderTraversal(node.rightChild);
    }

    /**
     * 前序遍历 左 根 右
     * @param node
     */
    public static void postorderTraversal(TreeNode node) {
        // 终止条件
        if (null == node) {
            return;
        }
        postorderTraversal(node.leftChild);
        postorderTraversal(node.rightChild);
        System.out.println(node.data);
    }

    /**
     *                 ┌───┐
     *                 │ 10│
     *           ┌─────┴───┴───┐
     *           │             │
     *         ┌─┴─┐          ┌┴───┐
     *         │  8│          │  11│
     *      ┌──┴───┴──┐       └────┴────┐
     *      │         │                 │
     *   ┌──┴┐      ┌─┴─┐             ┌─┴──┐
     *   │ 7 │      │ 9 │             │12  │
     *   └───┘      └───┘             └────┘
     * @param args
     */

    public static void main(String[] args) {
        // 构建一个二叉查找树
        BinarySearchTreeNode btt= new BinarySearchTreeNode();
        btt.insertNode(10);
        btt.insertNode(8);
        btt.insertNode(11);
        btt.insertNode(7);
        btt.insertNode(9);
        btt.insertNode(12);

        // 前序遍历
        preorderTraversal(btt.root);
        System.out.println("---------------------------");
        inorderTraversal(btt.root);
        System.out.println("---------------------------");
        postorderTraversal(btt.root);

    }



}
