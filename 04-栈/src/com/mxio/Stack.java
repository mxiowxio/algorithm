package com.mxio;

import com.mxio.list.ArrayList;

import com.mxio.list.List;

/**
 * @author mxio
 */
public class Stack<E> {

    private List<E> list = new ArrayList<>();

    public void clear() {   // 清空栈
        list.clear();
    }
    
    public int size() { // 元素的数量
        return list.size();
    }

    public boolean isEmpty() {  // 是否为空
        return list.isEmpty();
    }

    public void push(E element) {   // 入栈
        list.add(element);
    }

    public E pop() {     // 出栈
        return list.remove(list.size() - 1);
    }

    public E top() {    // 获取栈顶元素
        return list.get(list.size() - 1);
    }

}
