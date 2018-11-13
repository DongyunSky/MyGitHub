package fun.chaoxi.test;

import fun.chaoxi.list.MySequenceList;
import fun.chaoxi.list.SequenceList;
import fun.chaoxi.sort.MySort;
import fun.chaoxi.sort.SelectionSort;
import fun.chaoxi.util.SortUtils;
import org.junit.Test;

import java.util.Random;

public class MyTest {

    MySort mySort;
    Random random = new Random();

    @Test
    public void testMySequence() {
        // 创建表
        MySequenceList list = new MySequenceList(10);
    }

    @Test
    public void testSequence() {
        // 1.创建顺序表
        SequenceList sequenceList = new SequenceList();
        // 2.初始化表
        for (int i = 0; i < 10; i++) {
            sequenceList.addTail(i);
        }
        sequenceList.printAll("初始化表后");
        // 3.下标4位置插入整数100
        sequenceList.add(4,100);
        sequenceList.printAll("插入一个数据后");
        // 4.获得下标4的元素
        Object one = sequenceList.getOne(4);
        System.out.print("\n获得的元素: " + one);
        // 5.移出下标0, 5, size位置的元素
        sequenceList.remove(0);
        sequenceList.printAll("删除元素后");
        sequenceList.remove(5);
        sequenceList.printAll("删除元素后");
        sequenceList.remove(sequenceList.getSize()-1);
        sequenceList.printAll("删除元素后");
        // 6.修改下标0, 4, size位置的元素
        sequenceList.modify(0,1000);
        sequenceList.modify(4,45);
        sequenceList.modify(sequenceList.getSize()-1,123);
        sequenceList.printAll("修改元素后");

    }

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
