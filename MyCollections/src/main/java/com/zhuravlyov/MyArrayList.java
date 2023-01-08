package com.zhuravlyov;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    private T[] array = (T[]) new Object[10];
    private int size = 0;

    @Override
    public void add(T t) {
        array[size] = t;
        size++;
        increaseArray();
    }

    @Override
    public void add(int index, T t) {
        checkIndex(index);
        System.arraycopy(array, index, array, index - 1, size - index);
        array[index] = t;
        size++;
        increaseArray();
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public boolean remove(T t) {
        for (int i = 0; i < size; i++) {
            if (t.equals(array[i])) {
                removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        System.arraycopy(array, index, array, index + 1, size - index);
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    private void checkIndex(int index) {
        if (0 < index && index >= size) {
            throw new IllegalArgumentException();
        }
    }

    private void increaseArray() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    @Override
    public void clear() {
        size = 0;
        array = (T[]) new Object[10];
    }
}
