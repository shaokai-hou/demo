package com.haohao.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author haohao
 * @date 2022年07月22日 10:33
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 0, 100, 25, 14, 8, 1000, -2};
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
