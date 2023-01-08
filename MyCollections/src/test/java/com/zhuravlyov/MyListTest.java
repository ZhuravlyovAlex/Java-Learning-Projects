package com.zhuravlyov;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyListTest {

    private MyList<Integer> list;

    @Before
    public void setUp() throws Exception {

        list = new MyArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }

    @Test
    public void whenAddedNumber15InTheEndPositionThenSizeMustBeIncreased() {
        list.add(15);
        assertEquals(101, list.size());
    }

    @Test
    public void whenAddedNumber777InMiddlePositionThenSizeMustBeIncreased() {
        list.add(5, 777);
        assertEquals(101, list.size());
    }

    @Test
    public void whenRemovedNumberByIndexThenSizeMustBeDecreased() {
        assertTrue(list.removeAt(5));
        assertEquals(99, list.size());
    }

    @Test
    public void whenRemovedByNameThenSizeMustBeDecreased() {
        MyList<String> list2 = new MyLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            list2.add("Brand" + i);
        }
        list2.add(6, "BMW");
        assertTrue(list2.remove("BMW"));
        assertEquals(100, list.size());
    }

    @Test
    public void whenRemovedNonExistentObjectByNameThenSizeMustBeWithoutChanges() {
        MyList<String> list2 = new MyLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            list2.add("Brand" + i);
        }
        assertFalse(list2.remove("BMW"));
        assertEquals(100, list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTryingToCallNonExistentIndexThenThrownException() {
        list.get(100);
    }

    @Test
    public void whenClearingThenSizeMustBe0() {
        list.clear();
        assertEquals(0, list.size());
    }
}