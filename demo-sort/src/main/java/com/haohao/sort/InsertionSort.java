package com.haohao.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author haohao
 * @date 2022年07月22日 10:43
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 0, 100, 25, 14, 8, 1000, -2};
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        System.out.println(Arrays.toString(array));
    }
}
