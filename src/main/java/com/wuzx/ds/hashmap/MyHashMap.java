package com.wuzx.ds.hashmap;

/**
 * 手动hashMap
 */
public class MyHashMap {

    // 初始化8个 2的n次方
    private ListNode[] map = new ListNode[8];

    // listNode 个数
    int size;

    public void put(String key, String value) {
        //该扩容了
        if (size >= map.length * 0.75) {
            System.out.println("map需要扩容");
            return;
        }

        //计算索引 数组下标
        int index = Math.abs(key.hashCode()) % map.length;

        //获得该下标处的ListNode
        ListNode ln = map[index];

        if (null == ln) {
            ListNode lnNew = new ListNode(); //创建头结点
            Node head = new Node(key, value); //挂载头结点
            lnNew.head = head;
//把单链放到数组里
            map[index] = lnNew;
            size++;
        } else {
            //单链表挂结点
            ln.addNode(key,value);
        }


    }


    public String get(String key) {
        //计算索引 数组下标
        int index = Math.abs(key.hashCode()) % map.length;

        ListNode ln=map[index];
        if(ln==null) return  null;
        return ln.getValue(key);
    }


    public static void main(String[] args) {
        MyHashMap hashMap=new MyHashMap();
        hashMap.put("m3","cccccc");
        hashMap.put("c1","kkkkkk");
        hashMap.put("c1","mmmmmmm");
        System.out.println(hashMap.get("c1"));
    }


}
