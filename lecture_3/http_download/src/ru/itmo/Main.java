package ru.itmo;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException {
        int nThreads = Integer.parseInt(args[0]);
        String output_folder = args[1];
        new File(output_folder).mkdir();
        String links = args[2];

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        Map<URL, ArrayList<File>> map = parseLinks(new File(links), output_folder);

        long startTime = System.currentTimeMillis();

        map.forEach((key, value) -> {
            executor.submit(new Download(key, value));
        });

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Statistics.setTimeAll(System.currentTimeMillis() - startTime);

        Statistics.showStatisticsAll();

    }

    public static Map<URL, ArrayList<File>> parseLinks(File links, String outputDir) throws IOException {
        Map<URL, ArrayList<File>> map = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(links));

        String line = reader.readLine();

        while (line != null) {
            URL url = new URL(line.split(" ")[0]);
            File file = new File(outputDir + "\\" + line.split(" ")[1]);

            if (map.containsKey(url)) {
                map.get(url).add(file);
            } else {
                ArrayList<File> list = new ArrayList<>();
                list.add(file);

                map.put(url, list);
            }

            line = reader.readLine();
        }


        return map;
    }
}
