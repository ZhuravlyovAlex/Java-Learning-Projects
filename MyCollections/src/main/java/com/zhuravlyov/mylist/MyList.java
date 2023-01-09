package com.zhuravlyov.mylist;

import com.zhuravlyov.MyCollection;

public interface MyList<T> extends MyCollection<T> {
    boolean add(T t);

    boolean add(int index, T t);

    T get(int index);

    boolean remove(T t);

    boolean removeAt(int index);

    int size();

    void print();

    void clear();
}
