package com.epam.goldmanSachs;

import java.util.NoSuchElementException;

//Double ended queue, hence it can be inserted and removed from the front and back as well
//addFirst(), addLast(), removeFirst(), removeLast(), peekFirst(), peekLast(), size()
public class Deque<T> {
    public static class Node<T>{
        T data;
        Node<T> next;
        Node<T> prev;
        Node(T data){
            this.data = data;
        }
    }

    public int size;
    public Node<T> head;
    public Node<T> tail;

    public Deque(){
        size = 0;
        head = null;
        tail = null;
    }
    public void addFirst(T data){
        Node<T> node = new Node<>(data);
        if(isEmpty()){
            head = tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }
    public void addLast(T data){
        Node<T> newNode = new Node(data);
        if(isEmpty()){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    public T removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        T data = head.data;
        if(head == tail){
            head = tail = null;
        }else{
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }
    public T removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException("Dequeue is empty");
        }
        T data = tail.data;
        if(head == tail){
            head = tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;

    }
    public T peekFirst(){
        if(isEmpty()){
            return null;
        }
        return head.data;
    }
    public T peekLast(){
        if (isEmpty()){
            return null;
        }
        return tail.data;
    }
    public int getSize(){
        return this.size;
    }
}
