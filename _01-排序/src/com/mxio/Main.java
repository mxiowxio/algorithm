package com.mxio;

import java.util.Arrays;

import com.mxio.sort.CountingSort;
import com.mxio.sort.RadixSort;
import com.mxio.sort.Sort;
import com.mxio.sort.cmp.BubbleSort1;
import com.mxio.sort.cmp.BubbleSort2;
import com.mxio.sort.cmp.BubbleSort3;
import com.mxio.sort.cmp.HeapSort;
import com.mxio.sort.cmp.InsertionSort1;
import com.mxio.sort.cmp.InsertionSort2;
import com.mxio.sort.cmp.InsertionSort3;
import com.mxio.sort.cmp.MergeSort;
import com.mxio.sort.cmp.QuickSort;
import com.mxio.sort.cmp.SelectionSort;
import com.mxio.sort.cmp.ShellSort;
import com.mxio.tools.Asserts;
import com.mxio .tools.Integers;

/**
 * @author mxio
 */

@SuppressWarnings({"rawtypes", "unchecked"})
public class Main {
    public static void main(String[] args) {

//		int[] array1 = {2, 4, 8, 8, 8, 12, 14};
//		Asserts.test(BinarySearch.search(array1, 5)==2);
//		Asserts.test(BinarySearch.search(array1, 1)==0);
//		Asserts.test(BinarySearch.search(array1, 15)==7);
//		Asserts.test(BinarySearch.search(array1, 8)==5);

//		Integer[] array = Integers.random(10000, 1, 10000);
        Integer[] array = Integers.random(100000, 1, 10000);
//		Integer[] array = {5,4,8,9,1,6,8,2};
        testSorts(array,
//				new BubbleSort1(),		// 冒泡排序
//				new BubbleSort2(),		// 冒泡排序-优化1
//				new BubbleSort3(),		// 冒泡排序-优化2
//				new SelectionSort(), 	// 选择排序
                new HeapSort(),        // 堆排序
//				new InsertionSort1(),   // 插入排序
//				new InsertionSort2(), 	// 插入排序-挪动优化
                new InsertionSort3(),    // 插入排序-二分查找优化
                new MergeSort(),        // 归并排序
                new QuickSort(),        // 快速排序
                new ShellSort()        // 希尔排序
//				new CountingSort(),		// 计数排序
//				new RadixSort()			// 基数排序
        );
    }

    static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }

}
