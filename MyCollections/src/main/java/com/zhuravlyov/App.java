package com.zhuravlyov;

import com.zhuravlyov.mylist.MyArrayList;
import com.zhuravlyov.mylist.MyLinkedList;
import com.zhuravlyov.mylist.MyList;

/**
 * Собственная реализация коллекции ArrayList, LinkedList (используя принципы Clean Architecture и TDD)
 *
 * @author : Алексей Журавлёв.
 * @version : 0.2
 */
public class App {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();
        list.add("Первый");
        list.add("Второй");
        list.add("Третий");
        list.add("Четвертый");
        list.add("Пятый");
        list.add("Шестой");
        list.add("Седьмой");

        for (String s : list) {
            System.out.println(s);
        }
    }

}
