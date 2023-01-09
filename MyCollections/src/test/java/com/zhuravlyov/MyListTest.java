package com.zhuravlyov;

import com.zhuravlyov.mylist.MyArrayList;
import com.zhuravlyov.mylist.MyLinkedList;
import com.zhuravlyov.mylist.MyList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyListTest {

    private MyList<Integer> list;
    private MyList<String> list2;

    @Before
    public void setUp() throws Exception {

        list = new MyArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list2 = new MyArrayList<String>();
        for (int i = 0; i < 100; i++) {
            list2.add("Brand" + i);
        }
    }

    @Test
    public void whenAddedValueInTheEndPositionThenSizeMustBeIncreased() {
        list.add(15);
        assertEquals(101, list.size());
        list2.add("miracle");
        assertEquals(101, list2.size());
    }

    @Test
    public void whenAddedNumberValueInMiddlePositionThenSizeMustBeIncreased() {
        list.add(5, 777);
        assertEquals(101, list.size());
        list2.add(5, "animal");
        assertEquals(101, list2.size());
    }

    @Test
    public void whenRemovedNumberByIndexThenSizeMustBeDecreased() {
        assertTrue(list.removeAt(5));
        assertEquals(99, list.size());
        assertTrue(list2.removeAt(5));
        assertEquals(99, list2.size());
    }

    @Test
    public void whenRemovedByNameThenSizeMustBeDecreased() {
        assertTrue(list.add(6, 10000));
        assertEquals(101, list.size());
        assertTrue(list.remove(10000));
        assertEquals(100, list.size());
        assertTrue(list2.add(6, "BMW"));
        assertEquals(101, list2.size());
        assertTrue(list2.remove("BMW"));
        assertEquals(100, list2.size());
    }

    @Test
    public void whenRemovedNonExistentObjectByNameThenSizeMustBeWithoutChanges() {
        assertFalse(list.remove(70000));
        assertEquals(100, list.size());
        assertFalse(list2.remove("BMW"));
        assertEquals(100, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenTryingToCallNonExistentIndexThenThrownException() {
        list.get(100);
    }

    @Test
    public void whenClearingThenSizeMustBe0() {
        list.clear();
        assertEquals(0, list.size());
    }
}