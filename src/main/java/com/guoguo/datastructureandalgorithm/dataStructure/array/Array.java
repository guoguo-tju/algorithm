package com.guoguo.datastructureandalgorithm.dataStructure.array;


/**
 * @program: algorithm
 * @description:
 * @author: Karl Guo
 * @create: 2018-12-15 17:46
 **/
public class Array {

    private int[] data;
    private int size;   // 当前数组存储元素个数(元素的指针)

    // 构造时指定数组的容量
    public Array(Integer capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 无参构造,默认给定数组长度为10
    public Array() {
        this(10);
    }

    // 获取数组中元素的个数
    public int getSize() {
        return this.size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return this.data.length;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }

    // 指定index插入元素e
    public void add(int index, int e) {

        // 先判断传入的参数是否合法
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("add failed, index < 0 or index > size");
        }
        // 判断容量是否足够
        if (size == data.length) {
            throw new IllegalArgumentException("add failed, capacity is not enough");
        }
        // 插入思路:
        //  指定位置之后的元素全部后移一位,要从后往前移动,因为从前往后会把后面的元素覆盖掉
        //  将e放在index的位置
        //  处理完毕后将size ++;
        for (int i = this.size - 1; i <= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 在末尾添加一个元素
    public void addLast(int e) {
        add(this.size, e);
    }

    // 在开头添加一个元素
    public void addFirst(int e) {
        add(0, e);
    }

}
