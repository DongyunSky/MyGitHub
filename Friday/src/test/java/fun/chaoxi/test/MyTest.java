package fun.chaoxi.test;

import fun.chaoxi.sort.SelectionSort;
import org.junit.Test;

public class MyTest {

    @Test
    public void testSort() {
        int[] ints = {0, 12, 34, 999, -123, 1, 3, -56, 32, 0, 3, 34, 115};
        int[] sorted;

        sorted = SelectionSort.sort(ints); // 选择

        for (int i : sorted) {
            System.out.print(i + "  ");
        }
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
