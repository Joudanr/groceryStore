/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure.project;

import java.util.Scanner;

public class grocery {

    private String name;
    private SinglyLinkedList<Item> itemsLinkedList;
    private LLQueue<Order> ordersQueue; //customers and orders

    public grocery(String name) {
        this.name = name;
        ordersQueue = new LLQueue<>();
        itemsLinkedList = new SinglyLinkedList<>();
        groceryOrdersAndItems();
    }

    
    
    // first method in the main
    public void displayItems() {
        if (itemsLinkedList.isEmpty()) {
            System.out.println("No Items yet!");
        } else {
            itemsLinkedList.displayItems();
        }
    }

    //second method in the main
    public void addItems() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the item name: ");
        String name = input.nextLine();

        System.out.print("Enter the item id: ");
        int id = Integer.parseInt(input.nextLine());

        System.out.print("Enter the item price: ");
        double price = Double.parseDouble(input.nextLine());

        Item p = new Item(id, price, name);
        itemsLinkedList.addLast(p);

        System.out.println("The item has been included!");
    } 

    //third method in the main

    public void removeItem() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter item's id: ");
        int id = input.nextInt();
        Item it = retrieveItem(id);
        if (it == null) {
            System.out.println("No items has this id");
        } else {
            Item removed = itemsLinkedList.remove(it);
            if (removed != null) {
                System.out.println("item removed!");
            } else {
                System.out.println("item could not be removed");
            }
        }
    } 

    // to help retrieving items
    public Item retrieveItem(int itemId) {
        for (int i = 0; i < itemsLinkedList.size(); i++) {
            Item p = itemsLinkedList.get(i);
            if (p.getItemId() == itemId) {
                return p;
            }
        }
        return null;
    }


    
    

    //fourth method in the main
    public void OrdersQueue() {
        LLQueue<Order> q = new LLQueue<>();
        if (!ordersQueue.isEmpty()) {
            int r = 0;
            while (!ordersQueue.isEmpty()) {
                Order ord = ordersQueue.Dequeue();
                r += 1;
                System.out.print("\n" + r + " : ");
                ord.ordDis();
                q.Enqueue(ord);
            }
            System.out.println();
            while (!q.isEmpty()) {
                ordersQueue.Enqueue(q.Dequeue());
            }
        } else {
            System.out.println("there is no orders yet");
        }
    }

    // fifth method in the main
    public void getNextOrder() {
        if (ordersQueue.isEmpty()) {
            System.out.println("No orders to cancel");
        } else {
            Order o = ordersQueue.Dequeue();
            System.out.println(o.getCustomerName() + " has been canceled");
        }
    } 
    
    //sixth method in the main
    public void currentOrder() {
        if (ordersQueue.isEmpty()) {
            System.out.println("No orders yet");
        } else {
            System.out.println("current order in the queue: " + ordersQueue.first().getCustomerName());
        }
    } 

    // gitters we need 
    public String getName() {
        return name;
    }

    
    
    
    
    // the orders i have in my grocery
    private void groceryOrdersAndItems() {
        //add products to the list
        Item I1 = new Item(1, 1, "yogurt");
        Item I2 = new Item(2, 3.5, "Chocolate");
        Item I3 = new Item(3, 4.95, "Toast");
        Item I4 = new Item(4, 200, "cats food");
        Item I5 = new Item(5, 9, "laban");
        Item I6 = new Item(6, 23, "egg");
        Item I7 = new Item(7, 7.9, "coffee");
        Item I8 = new Item(8, 6.7, "tea");
        Item I9 = new Item(9, 2.95, "cookies");
        Item I10 = new Item(10, 8.9, "Chips");
        Item I11 = new Item(11, 3, "pepsi");
        Item I12 = new Item(11, 150, "rice");
        itemsLinkedList.addLast(I1);
        itemsLinkedList.addLast(I2);
        itemsLinkedList.addLast(I3);
        itemsLinkedList.addLast(I4);
        itemsLinkedList.addLast(I5);
        itemsLinkedList.addLast(I6);
        itemsLinkedList.addLast(I7);
        itemsLinkedList.addLast(I8);
        itemsLinkedList.addLast(I9);
        itemsLinkedList.addLast(I10);
        itemsLinkedList.addLast(I11);
        itemsLinkedList.addLast(I12);

        Order order = new Order("joud's order", 1);
        order.addItemsToLinkedList(I3);
        boolean p = order.priority();
        ordersQueue.Enqueue(order, p);

        order = new Order("ghala's order", 2);
        order.addItemsToLinkedList(I1);
        order.addItemsToLinkedList(I5);
        order.addItemsToLinkedList(I3);
        order.addItemsToLinkedList(I2);
        p = order.priority();
        ordersQueue.Enqueue(order, p);

        order = new Order("layans's order", 3);
        order.addItemsToLinkedList(I11);
        order.addItemsToLinkedList(I5);
        p = order.priority();
        ordersQueue.Enqueue(order, p);

        order = new Order("walah's order", 4);
        order.addItemsToLinkedList(I6);
        order.addItemsToLinkedList(I7);
        order.addItemsToLinkedList(I5);
        order.addItemsToLinkedList(I10);
        order.addItemsToLinkedList(I11);
        p = order.priority();
        ordersQueue.Enqueue(order, p);

        order = new Order("atheer's order", 5);
        order.addItemsToLinkedList(I4);
        order.addItemsToLinkedList(I9);
        order.addItemsToLinkedList(I8);
        p = order.priority();
        ordersQueue.Enqueue(order, p);

        order = new Order("waad's order", 6);
        order.addItemsToLinkedList(I9);
        order.addItemsToLinkedList(I1);
        order.addItemsToLinkedList(I8);
        order.addItemsToLinkedList(I10);
        p = order.priority();
        ordersQueue.Enqueue(order, p);

        order = new Order("rema's order", 7);
        order.addItemsToLinkedList(I3);
        order.addItemsToLinkedList(I1);
        order.addItemsToLinkedList(I6);
        order.addItemsToLinkedList(I11);
        order.addItemsToLinkedList(I12);
        p = order.priority();
        ordersQueue.Enqueue(order, p);

    }

}