package com.mxio;

import com.mxio.Single.SingleLinkedList;
import com.mxio.circle.CircleLinkedList;
import com.mxio.circle.SingleCircleLinkedList;

/**
 * @author mxio
 */
public class Main {

    static void testList(List<Integer> list) {
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0, 55); // [55, 11, 22, 33, 44]
        list.add(2, 66); // [55, 11, 66, 22, 33, 44]
        list.add(list.size(), 77);  // [55, 11, 66, 22, 33, 44, 77]

        list.remove(0);
        list.remove(2);
       list.remove(list.size() - 1);

        Asserts.test(list.indexOf(44) == 3);
        Asserts.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
        Asserts.test(list.contains(33));
        Asserts.test(list.get(0) == 11);
        Asserts.test(list.get(1) == 66);
        Asserts.test(list.get(list.size() - 1) == 44);


        System.out.println(list);
    }

    // 约瑟夫问题
    static void josephus() {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        for (int i = 1; i <= 8; i++) {
            list.add(i);
        }

        // 指向头结点（指向1）
        list.reset();

        while (!list.isEmpty()) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }
    }

    public static void main(String[] args) {

//        testList(new SingleCircleLinkedList<>());
        josephus();
    }

}
