package com.wuzx.algorithmicThinking.greedy;

import java.util.ArrayList;
import java.util.List;

class BagDemo1 {

    double bag; // 背包的大小


    public void take(List<Goods> goodsList) {


        sortValue(goodsList);

        double sum_w = 0;

        for (Goods goods : goodsList) {
            sum_w += goods.weight;

            System.out.println(goods.name + "取" + goods.weight + "kg");

            if (sum_w > bag) {
                return;
            }

        }

    }


    /**
     * 按照价值排序
     *
     * @param goodsList
     * @return
     */
    private List<Goods> sortValue(List<Goods> goodsList) {
        return goodsList;
    }

    public static void main(String[] args) {
        BagDemo1 bd = new BagDemo1();
        Goods goods1 = new Goods("A", 10, 60);
        Goods goods2 = new Goods("B", 20, 100);
        Goods goods3 = new Goods("C", 30, 120);
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        bd.bag = 50;
        bd.take(goodsList);

    }


}
