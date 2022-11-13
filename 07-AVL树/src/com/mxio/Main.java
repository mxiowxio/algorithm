package com.mxio;

import com.mxio.printer.BinaryTrees;
import com.mxio.tree.AVLTree;

/**
 * @author mxio
 */
public class Main {

    // Integer类型的数据
    public static void test1() {
        // Integer date[] = new Integer[] {
        Integer[] date = new Integer[]{
                75, 94, 21, 7, 93, 31, 83, 65, 43, 50, 57, 56
        };
        AVLTree<Integer> avl = new AVLTree<>();
        //for (int i = 0; i < date.length; i++) {
        for (Integer integer : date) {
            avl.add(integer);
            System.out.println("【" + integer + "】");
            BinaryTrees.println(avl);
            System.out.println("-----------------------------------------");
        }
    }

    // 删除
    public static void test2() {
        Integer[] data = new Integer[]{
                67, 52, 92, 96, 53, 95, 13, 63, 34, 82, 76, 54, 9, 68, 39
        };

        AVLTree<Integer> avl = new AVLTree<>();
        //for (int i = 0; i < data.length; i++) {
        for (Integer datum : data) {
            avl.add(datum);
//			System.out.println("【" + data[i] + "】");
//			BinaryTrees.println(avl);
//			System.out.println("---------------------------------------");
        }

        // for (int i = 0; i < data.length; i++) {
        for (Integer datum : data) {
            avl.remove(datum);
            System.out.println("【" + datum + "】");
            BinaryTrees.println(avl);
            System.out.println("---------------------------------------");
        }


        BinaryTrees.println(avl);
    }

    public static void main(String[] args) {
        test2();
    }

}
