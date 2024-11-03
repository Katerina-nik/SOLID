package ru.netology;

public class RatingGoods implements Rating {

    @Override
    public void counterRating(int rating) {
        if (rating <= 6) {
            System.out.println("Опишите, что Вам не понравилось");
        } else {
            System.out.println("Благодарим за высокую оценку.");
        }
    }

}

