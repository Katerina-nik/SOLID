package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Order {
    static int count = 1;
    // Single - responsibility principe (логическоее разделение программы на классы, данный класс создан для создания заказа)
    List<Goods> order = new ArrayList<>();
    int orderNumber;
    int goodsAmount;

    public static int getCount() {
        return count;
    }

    public int getGoodsAmount() {
        return goodsAmount;
    }

    public List<Goods> getOrder() {
        return order;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void create(Basket basket) {
        if (basket == null) {
            System.out.println("Ваша корзина пуста");
        } else {
            this.order = basket.getOrder();
            goodsAmount = basket.amount;
            orderNumber = count++;

            System.out.printf("Заказ № %d %s  в колличестве %d  шт. создан \n", orderNumber, order, goodsAmount);


        }
    }

}


