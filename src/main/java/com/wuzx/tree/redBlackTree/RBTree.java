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
    public void insert(int key) {
        // 创建一个node节点
        RBTreeNode node = new RBTreeNode(key);
        // 判断是否存在根节点
        if (null == root) {
            node.isBlack = true; // 根节点必须是黑色
            root = node;
            return;
        }


        RBTreeNode parent = root;
        RBTreeNode son = null;
        if (key <= parent.key) {
            son = parent.left;
        } else {
            son = parent.right;
        }
        //find the position
        while (son != null) {
            parent = son;
            if (key <= parent.key) {
                son = parent.left;
            } else {
                son = parent.right;
            }
        }

        if (key <= parent.key) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        node.parent = parent;


        // 平衡红黑树
        balanceInsert(node);
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
            if (father ==  grandFather.left) {
                RBTreeNode uncle = grandFather.right; // 叔叔节点

                // 如果叔叔节点是红色，则需要变换颜色即可
                if (null != uncle && uncle.isBlack == false) {
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                // 如果叔叔节点是空或者是黑色， 则需要右旋,后面接一个左旋
                if (node == father.right) {
                    leftRevolve(father);
                    RBTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }

                setBlack(father);
                setRed(grandFather);
                //右旋
                rightRevolve(grandFather);


            } else if (father == grandFather.right) { // 父亲节点是右孩子
                // 如果叔叔节点是红色，则需要变换颜色即可
                RBTreeNode uncle = grandFather.left;
                if (uncle != null && uncle.isBlack == false) {
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }

                // 如果叔叔节点是空或者是黑色， 则需要左旋

                if (node == father.left) {
                    //右
                    rightRevolve(father);
                    RBTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }
                setBlack(father);
                setRed(grandFather);
                //左旋
                leftRevolve(grandFather);
            }
            setBlack(root);

        }


    }


    /**
     * 左旋 逆时针旋转红黑树的两个结点，使得父结点被自己的右孩子取代，而自己成为自己的左孩子
     *
     * @param node
     */
    private void leftRevolve(RBTreeNode node) {
        RBTreeNode parent = node.parent;
        RBTreeNode right = node.right;

        // root节点
        if (null == parent) {
            root = right;
            right.parent = null;
        } else {

            if (null != parent.left && parent.left == node) {
                parent.left = right;
            } else {
                parent.right = right;
            }

            right.parent = parent;
        }

        node.parent = right;
        node.right = right.left;

        if (null != right.left) {
            right.left.parent = node;
        }

        right.left = node;

    }


    /**
     * 右旋
     *
     * @param node
     */
    private void rightRevolve(RBTreeNode node) {
        RBTreeNode parent = node.parent;
        RBTreeNode left = node.left;

        // root节点
        if (null == parent) {
            root = left;
            left.parent = null;
        } else {

            if (null != parent.left && parent.left == node) {
                parent.left = left;
            } else {
                parent.right = left;
            }

            left.parent = parent;
        }

        node.parent = left;
        node.left = left.right;
        if (null != node.left) {
            node.left.parent = node;
        }

        left.right = node;
    }

    /**
     * 设置红色
     *
     * @param node
     */
    private void setRed(RBTreeNode node) {
        node.isBlack = false;
    }

    /**
     * 设置黑色
     *
     * @param node
     */
    public void setBlack(RBTreeNode node) {
        node.isBlack = true;
    }


    /**
     * 找到最小的子节点
     *
     * @param parent
     * @return
     */
    private RBTreeNode findSonNode(RBTreeNode parent, int key) {
        // 如果没有孩子节点返回父节点

        return parent;
    }


    public static void main(String[] args) {
        RBTree rb = new RBTree();
        rb.insert(10);//根节点
        rb.insert(5);
        rb.insert(9);
        rb.insert(3);
        rb.insert(6);
        rb.insert(7);
        rb.insert(19);
        rb.insert(32);
        rb.insert(24);
        rb.insert(17);
        rb.list(rb.root);
    }

}
