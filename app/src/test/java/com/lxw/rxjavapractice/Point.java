package com.lxw.rxjavapractice;

class Point<T> {
    private T x;       // 表示X坐标
    private T y;       // 表示Y坐标

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getX() {
        return this.x;
    }

    public T getY() {
        return this.y;
    }

    public static <T extends Comparable> T min(T... a) {
        T smallest = a[0];
        for (T item : a) {
            if (smallest.compareTo(item)) {
                smallest = item;
            }
        }
        return smallest;
    }

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }
}

