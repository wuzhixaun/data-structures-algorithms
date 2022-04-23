package com.wuzx.algorithmicThinking.greedy;

/**
 * 物品信息
 */
class Goods {
    String name;
    double weight;
    double price;
    double val;

    public Goods(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        val = price / weight;
    }
}
