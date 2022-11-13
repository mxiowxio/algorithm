package com.mxio.Single;

import com.mxio.AbstractList;

/**
 * @author mxio
 *
 * 增加一个虚拟头结点
 */
public class SingleLinkedList2<E> extends AbstractList<E> {

    private Node<E> first;

    public SingleLinkedList2() {
        first = new Node<>(null, null);
    }

    /**
     * 根据索引找到链表的结点
     *
     * @param <E>
     */
    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 获取index位置的节点对象
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);

        Node<E> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        /*
         * 最好：O(1)
         * 最坏：O(n)
         * 平均：O(n)
         */
        if (index == 0) {   // 给空链表添加第一个元素的情况
            first = new Node<>(element, first);
        }else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        /*
         * 最好：O(1)
         * 最坏：O(n)
         * 平均：O(n)
         */
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) { // 删除第一个元素是特殊情况
            first = first.next;
        } else {
            Node<E> prev = node(index - 1); // 找到前一个元素
            node = prev.next; // 要删除的元素
            prev.next = node.next; // 删除元素
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        // 有个注意点, 如果传入元素为null, 则不能调用equals方法, 否则会空指针
        // 因此需要对元素是否为null做分别处理
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size: ").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(node.element);
            node = node.next;
        }
        string.append("]");

//        Node<E> node1 = first;
//        while (node1 != null) {
//            node1 = node1.next;
//        }

        return string.toString();
    }

}
