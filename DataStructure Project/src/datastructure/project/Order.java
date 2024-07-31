/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure.project;

public class Order {

    private int orderId;
    private String customerName;
    private SinglyLinkedList<Item> Items; 
    
    public Order(String customerName, int orderId) {
        this.orderId = orderId;
        this.customerName = customerName;
        Items = new SinglyLinkedList<>();
    }

    public void addItemsToLinkedList(Item p) {
        Items.addLast(p);
    }

    public double totalPrice() {
        int size = Items.size();
        double total = 0;
        for (int i = 0; i < size; i++) {
            Item p = Items.removeFirst();
            total += p.getItemPrice();
            Items.addLast(p);
        }
        total = total + (total * 0.15);
        return total;

    }
    
    public boolean priority(){
        return totalPrice() >= 100;
    }
    
    public String getCustomerName() {
        return customerName;
    }

    public void ordDis(){
        System.out.println(getCustomerName());
        System.out.printf("Total price: %.4f $\n", totalPrice());
    }
    
 
}
