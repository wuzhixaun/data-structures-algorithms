package com.wuzx.ds.hashmap;

public class Node {

    public String key;
    public String value;
    public Node next;


    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", next=" + next +
                '}';
    }


}
