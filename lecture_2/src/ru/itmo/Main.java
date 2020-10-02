package ru.itmo;

public class Main {

    public static void main(String[] args) {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(3, 2, 1);

        System.out.println("Длинна v1: " + v1.length());

        System.out.println("Скалярное произведение: " + v1.scalarProduct(v2));
        System.out.println("Векторное произведение: " + v2.vectorProduct(v1));

        System.out.println("Угол между: " + v1.angleBetween(v2));

        System.out.println("Сумма: " + v2.sum(v1));
        System.out.println("Разница: " + v2.diff(v1));

        Vector[] arr = Vector.randomVectors(5);

        System.out.println("Рандомные вектора");
        for (Vector item : arr) {
            System.out.println(item);
        }
    }
}
