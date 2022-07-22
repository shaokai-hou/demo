package com.haohao.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author haohao
 * @date 2022年07月22日 09:53
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 0, 100, 25, 14, 8, 1000, -2};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
