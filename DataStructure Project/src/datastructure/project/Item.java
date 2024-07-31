/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure.project;

public class Item {

    private int itemId;
    private double itemPrice;
    private String itemName;

    public Item(int itemId, double itemPrice, String itemName) {
        this.itemId = itemId;
        this.itemPrice = itemPrice;
        this.itemName = itemName;

    }

    //setters and getters i need
    public int getItemId() {
        return itemId;
    }
    
    public double getItemPrice() {
        return itemPrice;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    @Override
    public String toString() {
        return String.format("\nItem Id: %d\nItem Nmae: %s\nItem Price: %.4f $", getItemId(), getItemName(), getItemPrice());
    }

}
