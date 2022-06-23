package com.zhuravlyov;

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
        for (int i = size; i < index; i--) {
            array[i] = array[i - 1];
        }
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
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
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
            T[] newArray = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public void clear() {
        size = 0;
        array = (T[]) new Object[10];
    }
}
