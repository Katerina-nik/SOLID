package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Goods> order = new ArrayList<>();
    int quantity;
    int amount;

    public Basket() {
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Goods> getOrder() {
        return order;
    }

    public void addInBasket(Goods goods, int amount) {
        this.amount = amount;
        order.add(goods);
        quantity = goods.getPrice() * amount;
    }

}
