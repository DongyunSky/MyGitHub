package fun.chaoxi.test;

import fun.chaoxi.sort.MySort;
import fun.chaoxi.sort.SelectionSort;
import fun.chaoxi.util.SortUtils;
import org.junit.Test;

import java.util.Random;

public class MyTest {

    MySort mySort;
    Random random = new Random();

    @Test
    public void testRandom() {
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(100000));
        }
    }

    @Test
    public void testSort() {
        int[] ints = {0, 12, 34, 999, -123, 1, 3, -56, 32, 0, 3, 34, 115};
        int[] sorted;

        mySort = new SelectionSort();
        sorted = mySort.sort(ints); // 选择

        for (int i : sorted) {
            System.out.print(i + "  ");
        }
    }

    @Test
    public void testSortVelocity() {
        SelectionSort selectionSort = new SelectionSort();
        long selectionTime = SortUtils.getSortVelocity(selectionSort); // 选择
        System.out.println(selectionTime);

    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }
}
