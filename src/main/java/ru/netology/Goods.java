package ru.netology;

public abstract class Goods {
    protected String name;
    protected String manufacturer;
    protected int price;

    public Goods(String name, String manufacturer, int price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Goods setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Goods setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getName() {
        return name;
    }

    public Goods setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return name +
                ", произволитель: " + manufacturer +
                ", цена: " + price;
    }
}
