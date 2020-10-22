package ru.itmo;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Download extends Thread {
    URL url;
    ArrayList<File> outFiles;

    public Download(URL url, ArrayList<File> outFiles) {
        this.url = url;
        this.outFiles = outFiles;
    }

    public void run() {
        BufferedInputStream in = null;
        ArrayList<FileOutputStream> outs = new ArrayList<>();

        int sizeBuffer = 1024;

        try {
            in = new BufferedInputStream(url.openStream(), sizeBuffer);

            for (File file : outFiles) {
                outs.add(new FileOutputStream(file));
            }

            byte buffer[] = new byte[sizeBuffer];
            int count = 0;

            System.out.println("Загружается файл: " + url);
            long timeStart = System.currentTimeMillis();

            while ((count = (in.read(buffer, 0, sizeBuffer))) != -1) {
                for (FileOutputStream out : outs) {
                    out.write(buffer, 0, count);
                }
            }

            long time = System.currentTimeMillis() - timeStart;
            float size = outFiles.get(0).length();

            Statistics.setStatisticsDownload(url.toString(), size, time);

            in.close();

            for (FileOutputStream out : outs) {
                out.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
