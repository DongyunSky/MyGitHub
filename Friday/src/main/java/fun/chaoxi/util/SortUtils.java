package fun.chaoxi.util;

import fun.chaoxi.sort.MySort;

import java.util.Random;

/**
 * Create by Wing Gao on 2018/11/1 20:02
 */
public class SortUtils {

    private static Random random = new Random();

    public static long getSortVelocity(MySort mySort) {

        int [] ints = new int[100000];
        int[] sorted;

        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(2147483647);
        }

        System.out.println("排序前：");
        for (int anInt : ints) {
            System.out.print(anInt + "  ");
        }

        long begin = System.currentTimeMillis();
        // sorted = SelectionSort.sort(ints); // 选择
        sorted = mySort.sort(ints);
        long end = System.currentTimeMillis();

        System.out.println("\n" + "排序后：");
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(i + ":" + sorted[i] + "  ");
        }
        System.out.println("\n" + "排序时间：" + "\n" + (end - begin));

        return end - begin;
    }
}
