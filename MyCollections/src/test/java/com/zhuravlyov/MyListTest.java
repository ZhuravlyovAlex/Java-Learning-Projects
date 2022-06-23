package com.zhuravlyov;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyListTest {

    private MyList<Integer> list;

    @Before
    public void setUp() throws Exception {

        list = new MyArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    @Test
    public void whenAddedNumber15InTheEndPositionThenSizeMustBeIncreased() {
        list.add(15);
        assertEquals(11, list.size());
    }

    @Test
    public void whenAddedNumber777InMiddlePositionThenSizeMustBeIncreased() {
        list.add(5, 777);
        assertEquals(11, list.size());
    }

    @Test
    public void whenRemovedNumberByIndexThenSizeMustBeDecreased() {
        list.removeAt(5);
        assertEquals(9, list.size());
    }

    @Test
    public void whenRemovedNumberByNameThenSizeMustBeDecreased() {
        MyList<String> list2 = new MyArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list2.add("Brand" + i);
        }
        list2.add(6, "BMW");
        list2.remove("BMW");
        assertEquals(10, list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTryingToCallNonExistentIndexThenThrownException() {
        list.get(10);
    }

    @Test
    public void whenClearingThenSizeMustBe0() {
        list.clear();
        assertEquals(0, list.size());
    }
}