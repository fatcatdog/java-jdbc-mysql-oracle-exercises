//@Author = Jacob Duchen
//@Date = 8/2/18

package com.assignmentOne.model;

public class Item {

    int id;
    String name;
    int quantity_in_stock;
    float price;

    public Item(int id, String name, int quantity_in_stock, float price) {
        this.id = id;
        this.name = name;
        this.quantity_in_stock = quantity_in_stock;
        this.price = price;
    }

    public Item(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity_in_stock() {
        return quantity_in_stock;
    }

    public void setQuantity_in_stock(int quantity_in_stock) {
        this.quantity_in_stock = quantity_in_stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
