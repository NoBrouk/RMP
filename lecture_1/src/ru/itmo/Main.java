package ru.itmo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //#1 Задание
        System.out.println("Задание #1");
        int arr[] = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random(1, 10);
            System.out.print(arr[i] + ", ");
        }

        System.out.println("\nМаксимальное значение: " + getMax(arr));
        System.out.println("Минимальное значение: " + getMin(arr));
        System.out.println("Среднее значение значение: " + getMiddle(arr));

        //#2 Задание
        System.out.println("\nЗадание #2");

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите n: ");
        int n = scan.nextInt();

        System.out.print("Введите k: ");
        int k = scan.nextInt();

        int sum = 0;
        for (int i = 0; i < n + 1; i++) {
            sum += Math.pow(i, k);
        }

        System.out.println("Сумма = " + sum);

        //#3 Задание
        System.out.println("\nЗадание #3");

        sortArray(arr);

        for (int item : arr) {
            System.out.print(item + ", ");
        }

        //#4 Задание
        System.out.println("\n\nЗадание #4");

        for (int i = 2; i <= 100; i++) {
            if (isPrimeNum(i)) {
                System.out.print(i + ", ");
            }
        }


        //#5 Задание
        System.out.println("\n\nЗадание #5");

        System.out.println(fibonacciNum(2));

    }

    public static int random(int from, int to) {
        return (int) Math.round(Math.random() * (to - from) + from);
    }

    public static int getMax(int arr[]) {
        int max = arr[0];

        for (int item : arr) {
            if (item > max) {
                max = item;
            }
        }

        return max;
    }


    public static int getMin(int arr[]) {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    public static float getMiddle(int arr[]) {
        int sum = 0;

        for (int item : arr) {
            sum += item;
        }

        return (float)sum / arr.length;
    }

    public static void sortArray(int arr[]) {
        int a = 1;

        while(a < arr.length) {
            if (a == 0) a = 1;

            if (arr[a] < arr[a - 1]) {
                int b = arr[a];
                arr[a] = arr[a - 1];
                arr[a - 1] = b;
                a--;
            } else {
                a++;
            }
        }
    }

    public static boolean isPrimeNum(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int fibonacciNum(int n) {
        int a = 0;
        int b = 1;
        for (int i = 2; i < n; ++i) {
            int next = a + b;
            a = b;
            b = next;
        }

        return b;
    }
}
