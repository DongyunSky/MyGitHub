package fun.chaoxi.sort;

import java.util.concurrent.ForkJoinPool;

/**
 * Create by Wing Gao on 2018/10/29 8:57
 *
 * 选择排序, 固定下标与后面每个比, 后面小的话交换位置
 */
public class SelectionSort {

    public static int[] sort(int[] ints) {
        int length = ints.length;

        // 外层下标0开始遍历
        for (int i = 0; i < length; i++) {
            // 内层从最后一个开始, 遍历到下标比外层大1的时候结束
            for (int j = length -1; j > i; j--) {
                // 如果前>后, 交换位置
                if (ints[i] > ints[j]) {
                    int temp = ints[j];
                    ints[j] = ints[i];
                    ints[i] = temp;
                }
            }
        }
        return ints;
    }
}
