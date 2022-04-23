package com.wuzx.list;


/**
 * 环形链表
 */
public class RingList {


    public static boolean isRing(Node head) {

        if (null == head) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;

        while (null != fast && null != fast.next) {

            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next; //步长为 2
        }

        return false;
    }

    public static void main(String[] args) {



        Node n1 = new Node(1, "张飞");
        Node n2 = new Node(2, "关羽");
        Node n3 = new Node(3, "赵云");
        Node n4 = new Node(4, "黄忠");
        Node n5 = new Node(5, "马超");
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        System.out.println(isRing(n1));

    }
}
