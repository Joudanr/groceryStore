/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure.project;

public class SinglyLinkedList<E> {

    private static class Node<E> {

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

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        } else {
            E data = tail.getElement();
            if (size == 1) {
                head = tail = null;
            } else {
                Node temp1 = head;
                Node temp2 = null;
                while (temp1.getNext() != null) {
                    temp2 = temp1;
                    temp1 = temp1.getNext();
                }
                temp2.setNext(null);
                tail = temp2;
            }
            size--;
            return data;
        }
    }

    public void displayItems() {
        if (isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            int r = 0;
            System.out.println("items List:");
            Node<E> current = head;
            while (current != null) {
                r = r + 1;
                System.out.println();
                System.out.print(r + " : ");
                System.out.println(current.getElement());
                current = current.getNext();
            }
        }
    }

    public E remove(E item) {
        if (head == null || item == null) {
            return null;
        }

        if (head.element == item) {
            E data = head.getElement();
            head = head.next;

            if (head == null) {
                tail = null;
            }
            size--;
            return data;
        }
        Node<E> current = head;
        while (current.next != null && current.next.element != item) {
            current = current.next;
        }
        if (current.next == null) {
            return null;
        }
        E data = current.next.getElement();
        current.next = current.next.next;

        if (current.next == null) {
            tail = current;
        }
        size--;
        return data;
    }

    public E get(int index) {

        Node<E> current = head;
        int position = 0;

        while (current != null) {

            if (position == index) {
                return current.getElement();
            }

            position++;
            current = current.getNext();
        }
        return null;
    }

}
