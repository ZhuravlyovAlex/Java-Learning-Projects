package com.zhuravlyov;

public class MyLinkedList<T> implements MyList<T> {
    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public void add(T t) {
        if (size == 0) {
            first = new Node(null, t, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node<>(secondLast, t, null);
            secondLast.next = last;
        }
        size++;
    }

    @Override
    public void add(int index, T t) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        if (index == size) {
            add(t);
            return;
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node nodeNew = new Node(nodePrevious, t, nodeNext);
        if (nodePrevious != null) {
            nodePrevious.next = nodeNew;
        } else {
            first = nodeNew;
        }
        nodeNext.previous = nodeNew;
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean remove(T t) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (t.equals(node.value)) {
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node currentNode = getNode(index);
        Node nodePrevious = currentNode.previous;
        Node nodeNext = currentNode.next;
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

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node<T> {
        private Node previous;
        private T value;
        private Node next;

        private Node(Node previous, T value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
