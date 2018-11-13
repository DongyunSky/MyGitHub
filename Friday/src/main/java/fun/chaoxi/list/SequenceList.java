package fun.chaoxi.list;

/**
 * Create by Wing Gao on 2018/11/1 18:24
 * 顺序表的实现
 */
public class SequenceList {

    // 数组实现
    private Object[] objects;
    // 长度
    private int size = 0;
    //
    private SequenceList sequenceList;

    public SequenceList() {
    }

    private SequenceList(Object[] objects) {
        this.objects = objects;
        this.size = objects.length;
    }

    /**
     * 尾插
     * @param o
     * @return
     */
    public SequenceList addTail(Object o) {
        Object[] temps = new Object[size+1]; // 新表长度+1
        // 尾插
        for (int i = 0; i < size; i++) {
            temps[i] = objects[i];
        }
        temps[size] = o; // size是大小, 参数是下标, 不用+1
        objects = temps;
        size++;
        return new SequenceList(objects);
    }

    /**
     * 在某一位置添加一个元素
     * @param index 要添加的位置
     * @param object 要添加的对象
     */
    public SequenceList add(int index, Object object) {
        Object[] temps = new Object[size+1]; // 新表长度+1
        if (index < 0){
            System.out.println("下标越界");
        } else if (index >= size) {
            // 尾插
            addTail(object);
        } else {
            // 平常的
            for (int i = size - 1; i >= index; i--) {
                // 移动该位置之后的
                temps[i+1] = objects[i];
            }
            for (int i = 0; i < index; i++) {
                // 该位置之前的不动
                temps[i] = objects[i];
            }
            temps[index] = object;
        }
        objects = temps;
        size++;
        return sequenceList;
    }

    /**
     * 获得某个下标的元素
     * @return
     */
    public Object getOne(int index) {
        isOutIndex(index);
        return objects[index];
    }

    /**
     * 删除某个位置的元素
     */
    public void remove(int index) {
        isOutIndex(index);
        for (int i = index; i < size-1; i++) {
            objects[i] = objects[i+1];
        }
        size--;
    }

    /**
     * 修改某个下标的元素
     */
    public void modify(int index, Object o) {
        isOutIndex(index);
        objects[index] = o;
    }

    /**
     * 遍历顺序表中所有元素
     * @param message
     */
    public void printAll(String message) {
        System.out.println("\n" +message + ":");
        for (int i = 0; i < size; i++) {
            System.out.print(objects[i] + "  ");
        }
    }

    /**
     * 判断是否下标越界
     * @param index
     * @return
     */
    public boolean isOutIndex(int index) {
        boolean result = true;
        if (index > size - 1 || index < 0) {
            throw new RuntimeException("下标越界");
        } else {
            result = false;
        }
        return result;
    }

    public int getSize() {
        return this.size;
    }

}
