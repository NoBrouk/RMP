package ru.itmo;

public class Statistics {
    static int count = 0;
    static float sizeAll = 0;
    static long timeAll = 0;
    static float speed = 0;

    static public void setStatisticsDownload(String name, float size, long time) {
        count++;
        sizeAll += size;
        speed += size / (float) time;

        System.out.println(
                "Файл " + name + " загружен: "
                        + (size / 1024 / 1024) + "MB за "
                        + ((float)time / 1000) + " сек."
        );
    }

    public static void setTimeAll(long timeAll) {
        Statistics.timeAll = timeAll;
    }

    public static void showStatisticsAll() {
        float time = ((float)timeAll / 1000);
        float avgSpeed = speed / count;

        System.out.println(
                "Загружено: " + count + " файлов, " + (sizeAll / 1024 / 1024) + "MB\n"
                        + "Время: " + time + " сек.\n"
                        + "Средняя скорость: " + avgSpeed + " kB/s"
        );
    }
}
