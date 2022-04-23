package com.wuzx.list;

public class Node {

    int id;

    String name;
    Node next;


    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", next=" + next +
                '}';
    }
}
