package fun.chaoxi.list;

/**
 * @author Wing Gao
 * @date 2018/12/17 8:56
 * @description 双向循环链表的实现
 */
public class DoubleCircularLinkedList {

    public static void main(String[] args) {
        // 25 10
        int a, b = 0;
        DoubleCircularLinkedList list = new DoubleCircularLinkedList();
        list.initList();
        for (int i = 0; i < 39; i++) {
            list.tailAdd(i);
        }
        int count = 0;
        Node current = list.head;
        while (true) {
            if (current == list.head) {
                // 如果是头结点，进行下一次循环
                current = current.next;
                continue;
            }
            count++;
            System.out.print(current.element + " ");
            if (count % 3 == 0) {
                // 报到3的，最后一次被删除的是副班长
                b = (int) current.element;
                list.removeElement(current.element);
            }
            if (current.next.next == current) {
                a = (int) current.element;
                break;
            }
            current = current.next;
        }
        System.out.println("\n班长是第" + (a+1) + "位同学，副班是第" + (b+1) + "位同学。");
    }

    /**
     * 抽奖
     * @param m 所报的数
     * @param n 总人数
     * @return 中奖的人的下标
     */
    public static int test2(int m, int n) {
        int result = -1;
        DoubleCircularLinkedList list = new DoubleCircularLinkedList();
        list.initList();
        for (int i = 1; i < n+1; i++) {
            list.tailAdd(i);
        }
        int count = 0;
        Node current = list.head;
        while (current.next.next != current) {
            if (current == list.head) {
                // 如果是头结点，进行下一次循环
                current = current.next;
                continue;
            }
            count++;
            System.out.print(current.element + " ");

            if (count % m == 0) {
                list.removeElement(current.element);
                System.out.println();

                // 后面的人再从 1 开始  好像是一样的
                count = 0;
            }
            if (current.next == list.head) {
                // 如果是头结点，进行下一次循环
                current = current.next;
            }
            current = current.next;
        }
        return (int) current.element;
    }

    private Node head = null;

    /**
     * 移除一个元素
     * @param element 要移除的元素
     * @return 移除元素后的表
     */
    public DoubleCircularLinkedList removeElement(Object element) {
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
            if (element.equals(temp.element)) {
                temp.next.previous = temp.previous;
                temp.previous.next = temp.next;
            }
        }
        return this;
    }

    /**
     * 在尾部添加一个元素
     * @param element 添加的元素
     * @return 链表
     */
    public DoubleCircularLinkedList tailAdd(Object element) {
        Node node = new Node();
        node.element = element;
        if (head.previous == head) {
            // 第一次插入
            node.previous = head;
            node.next = head;
            head.previous = node;
            head.next = node;
        } else {
            // 在尾部添加
            node.next = head;
            node.previous = head.previous;
            // 原来的最后一个，现在的倒数第二个 的后置节点 --> 当前节点
            head.previous.next = node;
            head.previous = node;
        }
        return this;
    }

    /**
     * 打印当前链表
     */
    public void printList() {
        System.out.println("打印双向循环链表: ");
        Node temp = head;
        while (temp.next != head) {
            System.out.print(temp.next.element + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 初始化链表
     * @return 该初始化的表
     */
    public DoubleCircularLinkedList initList() {
        head = new Node();
        head.previous = head;
        head.next = head;
        head.element = null;
        return this;
    }

    /**
     * Node 节点类，提供get方法
     */
    class Node {
        private Node node;
        private Node next;
        private Node previous;
        public Object element;
    }

}
