package fun.chaoxi.test;

import fun.chaoxi.bet.Gambler;
import fun.chaoxi.bet.TestBet;
import fun.chaoxi.list.*;
import fun.chaoxi.sort.MySort;
import fun.chaoxi.sort.SelectionSort;
import fun.chaoxi.util.SortUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class MyTest {

    MySort mySort;
    Random random = new Random();

    @Test
    public void testDCLL1() {
        int i = DoubleCircularLinkedList.test2(7, 8);
        System.out.println("\n" + (i));
    }

    @Test
    public void testDCLL() {
        DoubleCircularLinkedList list = new DoubleCircularLinkedList();
        list.initList();
        for (int i = 0; i < 10; i++) {
            list.tailAdd(i);
        }
        list.removeElement(5).removeElement(2);
        list.printList();
    }

    @Test
    public void testBet1() {
        long count = 0;
        for (int i = 0; i < 10000; i++) {
            if ("King".endsWith(TestBet.doBet(100000, 100, 0.500000001))) {
                count++;
            }
        }
        System.out.println("\n赌场最终赢了" + count + "次!");
    }

    @Test
    public void testBet() {
        Gambler king = new Gambler("King", 2147483647);
        Gambler luRen = new Gambler("LuRen", 100000);
        int count = 0;
        // 赌到有人没钱
        try {
            for (;;) {
                TestBet.bet(king, luRen, 0.5);
                count++;
            }
            // System.out.println("\n" + king + "\n" + luRen);
        } catch (Exception e) {
            System.out.println("\n" + "count: " + count + "\n" + king + "\n" + luRen);
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testA() {
        int n=10,m=3,s=0;
        for(int i=1;i<=n;i++)
            s=(s+m)%i;
        System.out.println(s%n+1);
    }

    @Test
    public void testDoubleLinkedList() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.initList();
        for (int i = 0; i < 39; i++) {
            doubleLinkedList.insertList(i+1+"", i+1);
        }
        doubleLinkedList.print();

        int count = 0;
        while (true) {

        }
    }

    @Test
    public void testMonitor() {
        new LinkList().getMonitor(39);
    }

    @Test
    public void testLinkedList() {
        LinkedList<String> stringList = new LinkedList<>();
        for (int i = 0; i < 39; i++) {
            stringList.add(i+1+"");
        }

        int count = 1;

        ListIterator<String> iterator = stringList.listIterator();
        int size = stringList.size();
        while (iterator.hasNext() && stringList.size()>2) {
            iterator.next();
            if (count%3 ==0) {
                iterator.remove();
            }
            if (count == size) {
                iterator = stringList.listIterator();
                size = stringList.size();
                count = 1;
            }
            count++;
        }
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    @Test
    public void testLinkList() {

        int a = 0;
        int b = 0;

        LinkList.CycleLinkList cycleLinkList = new LinkList.CycleLinkList(new LinkList.Node(0, null, null));
        cycleLinkList.printAll();

        for (int i = 0; i < 39; i++) {
            cycleLinkList.addNodeAtTail(new LinkList.Node(i+1, null, null));
        }
        cycleLinkList.printAll();

        // 循环链表
        cycleLinkList.getTailNode().setNext(cycleLinkList.getNode().getNext());

        LinkList.Node currentNode = cycleLinkList.getNode().getNext();
        int count = 1;
        while (!currentNode.getNext().equals(currentNode)) {
            if (count == 3) {
                if (currentNode.equals(currentNode.getNext().getNext())){
                    b = currentNode.getElement();
                    break;
                } else {
                    b = currentNode.getElement();
                    currentNode = cycleLinkList.removeAndGetNextNode(currentNode.getElement());
                }
                count = 1;
            } else {
                count++;
                currentNode = currentNode.getNext();
            }
        }

        a = currentNode.getElement();
        System.out.println("班长：" + a);
        System.out.println("副班长：" + b);

        // cycleLinkList.printAll();

        int person = random.nextInt(1000);
        int m = random.nextInt(100);
        System.out.println(person + "个人，" + "数到" + m + "的人退出！");

        LinkList.CycleLinkList list = new LinkList.CycleLinkList(new LinkList.Node(0, null, null));
        for (int i = 0; i < person; i++) {
            list.addNodeAtTail(new LinkList.Node(i+1, null, null));
        }
        LinkList.Node firstNode = list.getNode().getNext();
        LinkList.Node tailNode = list.getTailNode();
        tailNode.setNext(firstNode);

        count = 1;
        currentNode = firstNode;
        while (!currentNode.getNext().equals(currentNode)) {
            if (count == m) {
                list.removeElement(currentNode.getElement());
                if (currentNode.getElement() == firstNode.getElement()) {
                    if (currentNode.equals(currentNode.getNext().getNext())){
                        break;
                    } else {
                        currentNode = firstNode.getNext();
                    }
                } else {
                    currentNode = firstNode;
                }
                count = 1;
            } else {
                count++;
                currentNode = currentNode.getNext();
            }
        }

        System.out.println("中奖的人是" + list.getNode().getNext().getElement() + "号!");

    }

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
