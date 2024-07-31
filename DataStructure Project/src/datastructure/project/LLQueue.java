/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure.project;

public class LLQueue<E> {

    static class Node<E> {

        private E element;
        private Node<E> next; 

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public void setelement(E element) {
            this.element = element;
        }
    }
    
    protected Node<E> front;
    protected Node<E> rear;
    protected long size;
    private Order order;

    public LLQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public long getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { 
        if (isEmpty()) {
            return null;
        }
        return front.getElement();
    }

    public E last() { 
        if (isEmpty()) {
            return null;
        }
        return rear.getElement();
    }

    public void Enqueue(E elem) {
        Node<E> newest = new Node<E>(elem, null);
        if (isEmpty()) {
            front = newest;
        } else {
            rear.setNext(newest);
        }
        rear = newest; 
        size++;
    }

    // priority enqueue method
    public void Enqueue(E elem, boolean isPriority) {
        Node<E> newest = new Node<E>(elem, null);
        if (isEmpty()) {
            front = newest;
            rear = newest; 
        } else if (isPriority) {
            newest.setNext(front);
            front = newest;
        } else {
            rear.setNext(newest);
            rear = newest;
        }
        size++;
    }

    public E Dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = front.getElement();
        front = front.getNext();
        size--;
        if (size == 0) {
            rear = null; 
        }
        return answer;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        long s = getSize();
        for (int i = 0; i < s; i++) {
            E ele = Dequeue();
            System.out.println(ele);
            Enqueue(ele);
        }
    }

}
