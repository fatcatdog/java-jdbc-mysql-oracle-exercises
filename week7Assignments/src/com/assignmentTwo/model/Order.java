package com.assignmentTwo.model;

public class Order {

    int id;
    int item_id;
    int quantity;

    public Order(int id, int item_id, int quantity) {
        this.id = id;
        this.item_id = item_id;
        this.quantity = quantity;
    }

    public Order(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
