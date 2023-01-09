package com.zhuravlyov;

import com.zhuravlyov.mylist.MyArrayList;
import com.zhuravlyov.mylist.MyLinkedList;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MyCollectionTest {

    private MyCollection<String> myCollection;

    @Before
    public void setUp() throws Exception {
        myCollection = new MyLinkedList<>();
        for (int i = 0; i < 100; i++) {
            myCollection.add("значение " + i);
        }
    }

    @Test
    public void contains() {
       assertTrue(myCollection.contains("значение 7"));
       assertFalse(myCollection.contains("значение 777"));
    }

    @Test
    public void testForeach() {
        int index = 0;
        for (String s : myCollection) {
            index++;
        }
       assertEquals(100, index);
    }

}