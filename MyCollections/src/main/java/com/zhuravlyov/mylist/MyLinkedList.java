package com.zhuravlyov.mylist;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (size == 0) {
            first = new Node<>(null, t, null);
            last = first;
        } else {
            Node<T> secondLast = last;
            last = new Node<>(secondLast, t, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T t) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            return add(t);
        }
        Node<T> nodeNext = getNode(index);
        Node<T> nodePrevious = nodeNext.previous;
        Node<T> nodeNew = new Node<>(nodePrevious, t, nodeNext);
        if (nodePrevious != null) {
            nodePrevious.next = nodeNew;
        } else {
            first = nodeNew;
        }
        nodeNext.previous = nodeNew;
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean remove(T t) {
       int index = findElement(t);
       if(index != -1) {
           return removeAt(index);
       }
        return false;
    }

    @Override
    public boolean contains(T t) {
        return findElement(t) != -1;
    }

    @Override
    public boolean removeAt(int index) {
        Node<T> currentNode = getNode(index);
        Node<T> nodePrevious = currentNode.previous;
        Node<T> nodeNext = currentNode.next;
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
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
        for(int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.print("]");
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private int findElement(T t) {
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (t.equals(node.value)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T current = node.value;
                node = node.next;
                return current;
            }
        };
    }

    private static class Node<T> {
        private Node<T> previous;
        private T value;
        private Node<T> next;

        private Node(Node<T> previous, T value, Node<T> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
