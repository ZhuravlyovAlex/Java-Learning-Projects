package com.zhuravlyov.mylist;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private T[] array = (T[]) new Object[10];
    private int size = 0;

    @Override
    public boolean add(T t) {
        array[size] = t;
        size++;
        increaseArray();
        return true;
    }

    @Override
    public boolean add(int index, T t) {
        increaseArray();
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = t;
        size++;
        return true;
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
               return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (t.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
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
            throw new IndexOutOfBoundsException();
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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }
            @Override
            public T next() {
                return array[index++];
            }
        };
    }
}
