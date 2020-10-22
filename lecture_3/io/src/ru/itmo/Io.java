package ru.itmo;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Function;

public class Io {

    public static ArrayList<String> getListString(File file) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        FileReader fr = new FileReader(file);
        BufferedReader read = new BufferedReader(fr);

        String line = read.readLine();

        while (line != null) {
            list.add(line + "\n");
            line = read.readLine();
        }

        return list;
    }

    public static void inputLine(File file, String line) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(line);

        writer.flush();
    }

    public static File concat(File file1, File file2, File newFile) throws IOException {

        for (String line : Io.getListString(file1)) {
            Io.inputLine(newFile, line);
        }

        for (String line : Io.getListString(file2)) {
            Io.inputLine(newFile, line);
        }

        return newFile;
    }

    public static void copyFile(File from, File to) throws IOException {

        FileReader reader = new FileReader(from);
        FileWriter writer = new FileWriter(to);

        int c;
        while ((c = reader.read()) != -1) {
            writer.write(c);
            writer.flush();
        }
        
    }

    public static ArrayList<String> fineFileByName(File dir, String substring) {
        ArrayList<String> names = new ArrayList<>();

        for (String name : dir.list()) {
            if (name.contains(substring)) {
                names.add(name);
            }
        }

        return names;
    }

    public static ArrayList<String> fineFileByContent(File dir, String str) throws IOException {
        ArrayList<String> names = new ArrayList<>();

        for (String name : dir.list()) {
            if (!name.toLowerCase().endsWith(".txt"))
                continue;

            File file = new File(dir.getAbsolutePath() + "/" + name);

            for (String line : Io.getListString(file)) {
                line = line.replace("\n", "");

                if (line.equals(str)) {
                    names.add(name);
                    break;
                }
            }
        }

        return names;
    }

    public static ArrayList<File> fineFileByСondition(File dir, Function<File, Boolean> func) {
        ArrayList<File> files = new ArrayList<>();

        for (File f : dir.listFiles()) {
            if (func.apply(f)) {
                files.add(f);
            }
        }

        return files;
    }

}
