package com.wuzx.ds.hashmap;

/**
 * 单链表
 */
public class ListNode {

    public Node head; //头结点


    /**
     * 添加但链表节点
     * @param key
     * @param value
     */
    public void addNode(String key, String value) {
        if (null == head) {
            return;
        }

        // 创建节点
        Node node = new Node(key, value);

        //
        Node tmp = head;

        while (true) {

            if (tmp.key.equals(key)) {
                tmp.value = value;
            }

            if (tmp.next == null) {
                break;
            }



            tmp = tmp.next;
        }
        tmp.next = node;

    }


    /**
     * 获取值
     * @param key
     */
    public String getValue(String key) {
        if (null == head) {
            return null;
        }

        Node tmp = head;

        while (true) {
            if (tmp.next == null) {
                break;
            }

            if (tmp.key.equals(key)) {
                return tmp.value;
            }
            tmp = tmp.next;
        }


        return null;
    }





}
