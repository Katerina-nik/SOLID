package ru.netology;

public class Clothes extends Goods{
//Liskov substitution principle
    public Clothes(String name, String manufacturer, int price) {
        super(name, manufacturer, price);
    }

}
