package ru.netology;

import java.util.Scanner;

public interface Rating {
   // Dependency inversion principle(класс можно использовать для оценки чего-угодно)
    void counterRating(int rating);

}
