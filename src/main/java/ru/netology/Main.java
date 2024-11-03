package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Basket basket = new Basket();
        Goods selectedProduct = null;
        Order order = new Order();
        Rating ratingProducts = new RatingGoods();

        List<Goods> goods = new ArrayList<>();
        Clothes clothes1 = new Clothes("Платье", "Zara", 1200);
        Clothes clothes2 = new Clothes("Джинсы", "Levis", 5000);
        Clothes clothes3 = new Clothes("Пиджак", "Louis Vuitton", 13000);
        Clothes clothes4 = new Clothes("Футболка", "Nike", 700);
        goods.add(clothes1);
        goods.add(clothes2);
        goods.add(clothes3);
        goods.add(clothes4);
        System.out.println("Добро пожаловать в онлайн-магазин одежды");
        showMenu();

        while (true) {
            String operation = scanner.nextLine();
            switch (operation) {
                case "1":
                    System.out.println("Список товаров:");
                    printGoods(goods);
                    selectedProduct = choiceGoods(goods, scanner);
                    showMenu();
                    break;
                case "2":
                    System.out.print("Введите количество товара: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    basket.addInBasket(selectedProduct, quantity);
                    showMenu();
                    break;
                case "3":
                    order.create(basket);
                    showMenu();
                    break;
                case "4":
                    System.out.println("Поставьте оценку товару" + basket.getOrder() + "от 1 до 10");
                    int rating = Integer.parseInt(scanner.nextLine());
                    ratingProducts.counterRating(rating);
                    showMenu();
                    break;
                case "5":
                    System.out.println("Завершение программы");
                    break;

            }
        }
    }

    // Don’t Repeat Yourself(вынесение повторяющегося кода в отдельный метод)
    private static void showMenu() {
        System.out.println("Выберите операцию:\n" +
                "1. Выбор товара\n" +
                "2. Добавление товара в корзину\n" +
                "3. Создание заказа\n" +
                "4. Оценка товара\n" +
                "5. Выйти из программы");
    }

    private static void printGoods(List<Goods> goods) {
        //магические числа
        for (int i = 0; i < goods.size(); i++) {
            System.out.println(goods.get(i));

        }
    }

    private static Goods choiceGoods(List<Goods> goods, Scanner scanner) {
        Goods find = null;
        System.out.println("Выберите товар:\n " +
                "1. По ключевому слову.\n " +
                "2. По цене. \n " +
                "3. По проиводителю.");
        String filter = scanner.nextLine();
        switch (filter) {
            case "1":
                System.out.println("Введите слово: ");
                find = findByWord(goods, scanner.nextLine());
                System.out.println(find);
                break;
            case "2":
                System.out.println("Введите цену: ");
                find = findByPrice(goods, Integer.parseInt(scanner.nextLine()));
                System.out.println(find);
                break;
            case "3":
                System.out.println("Введите производителя: ");
                find = findByManufacturer(goods, scanner.nextLine());
                System.out.println(find);
                break;

        }

        return find;
    }

    private static Goods findByWord(List<Goods> goods, String findWord) {
        Goods finding;
        List<Goods> find = goods.stream().filter(good -> good.getName().contains(findWord))
                .toList();
        finding = find.getFirst();
        return finding;
    }

    private static Goods findByPrice(List<Goods> goods, int price) {
        Goods finding;
        List<Goods> find = goods.stream().filter(good -> good.getPrice() == price).toList();
        finding = find.getFirst();
        return finding;
    }

    private static Goods findByManufacturer(List<Goods> goods, String findManufacturer) {
        Goods finding;
        List<Goods> find = goods.stream().filter(good -> good.getManufacturer().contains(findManufacturer)).toList();
        finding = find.getFirst();
        return finding;
    }
}
