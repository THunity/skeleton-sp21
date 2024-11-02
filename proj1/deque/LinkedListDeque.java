package deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<T> {
    private class Node {
        T item;
        Node prev; // 指向前一个节点的引用，类型为Node
        Node next; // 指向后一个节点的引用，类型为Node

        // Node类的构造函数，用于初始化一个新节点
        Node(T item, Node prev, Node next) {
            this.item = item; // 这里的this是指实例变量，调用实例方法来进行赋值
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel; // 哨兵节点
    private int size;      // 链表中元素的数量

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel; // 自我指向，表示当前队列为空，这个节点是唯一节点
        sentinel.prev = sentinel; // 同上
        size = 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }
    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node currentNode = sentinel.next;
        while (currentNode != sentinel)
        {
            System.out.print(currentNode.item + " ");
            currentNode = currentNode.next;
        }
        System.out.println("");
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node firstNode = sentinel.next;
        sentinel.next = firstNode.next;
        firstNode.next.prev = sentinel;
        size--;
        return firstNode.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node lastNode = sentinel.prev;
        sentinel.prev = lastNode.prev;
        lastNode.prev.next = sentinel;
        size--;
        return lastNode.item;
    }

    public T get(int index) {
        if (isEmpty() || index > size)
            return null;
        Node currentNode = sentinel.next;
        for (int i = 0; i < index; i++)
        {
            if (i != index - 1)
            {
                currentNode = currentNode.next;
            }
        }
        return currentNode.item;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() { // 这里是一个匿名内部类，创建对象的同时定义其实现的类，通常用于实现接口或扩展类的短小实现
            private Node currentNode = sentinel.next;

            @Override
            public boolean hasNext() {
                return currentNode != sentinel;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T item = currentNode.item;
                currentNode = currentNode.next;
                return item;
            }
        };
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    public T getRecursiveHelper(int index, Node currentNode) {
        if (currentNode == sentinel)
            return null;
        if (index == 0)
            return sentinel.next.item;
        return getRecursiveHelper(index - 1, currentNode.next);
    }

    @Override
    public boolean equals(Object o) {
        // 如果当前实例与o为同一个对象
        if (this == o)
            return true;
        if (!(o instanceof LinkedListDeque))
            return false;
        LinkedListDeque<T> that = (LinkedListDeque<T>) o;

        if (that.size() != ((LinkedListDeque) o).size())
            return false;
        for (int i = 0; i < size(); i++)
        {
            T item1 = this.get(i);
            T item2 = that.get(i);
            if (!item1.equals(item2))
                return false;
        }
        return true;
    }
}
