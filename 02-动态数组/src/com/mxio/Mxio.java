package com.mxio;

/**
 * @author mxio
 */
public class Mxio {

    public static void main(String[] args) {


        test();

    }

    static void test() {
        // 所有的类，最终都是继承java.lang.Object

        // new是向对空间申请内存
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(10, "james"));
        persons.add(new Person(12, "homi"));
        persons.add(new Person(13, "jack"));
        System.out.println(persons);

        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(20);
        ints.add(30);
        ints.add(40);
        System.out.println(ints);
    }

}
