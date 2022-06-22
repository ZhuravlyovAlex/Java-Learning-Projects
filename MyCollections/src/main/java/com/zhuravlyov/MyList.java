package com.zhuravlyov;

public interface MyList<T> {
    boolean add(T t);

    boolean add(int index, T t);

    T get(int index);

    boolean remove(T t);

    boolean removeAt(int index);

    int size();

    void print();

    void clear();
}
