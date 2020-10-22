package ru.itmo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("main.txt");

        Io.concat(file, file, new File("concat.txt"));

        Io.copyFile(file, new File("copy.txt"));

        File dir = new File("C:\\Users\\pukki\\Documents\\PC");

        System.out.println(
                "Названия файлов, в названии которых содержится строка hello" +
                Io.fineFileByName(dir, "hello")
        );

        System.out.println(
                "Названия ТЕКСТОВЫХ файлов, где содержится строка hello: " +
                Io.fineFileByContent(dir, "hello")
        );

        System.out.println(
                "Вывести из каталога только файлы: " +
                Io.fineFileByСondition(dir, Main::func)
        );
    }

    public static boolean func(File file) {
        return file.isFile();
    }
}
