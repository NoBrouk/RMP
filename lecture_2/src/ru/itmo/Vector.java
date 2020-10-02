package ru.itmo;

public final class
Vector {

    final int x, y, z;

    Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarProduct(Vector v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vector vectorProduct(Vector v) {
        int x = this.y * v.z - this.z * v.y;
        int y = this.z * v.x - this.x * v.z;
        int z = this.x * v.y - this.y * v.x;

        return new Vector(x, y, z);
    }

    public double angleBetween(Vector v) {
        return this.scalarProduct(v) / (Math.abs(this.length()) * Math.abs(v.length()));
    }

    public Vector sum(Vector v) {
        return new Vector(x + v.x, y + v.y, z + v.z);
    }

    public Vector diff(Vector v) {
        return new Vector(x - v.x, y - v.y, z - v.z);
    }

    private static int random(int from, int to) {
        return (int) Math.round(Math.random() * (to - from) + from);
    }

    public static Vector[] randomVectors(int n) {
        Vector[] arr = new Vector[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Vector(random(0, 50), random(0, 50), random(0, 50));
        }

        return arr;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
