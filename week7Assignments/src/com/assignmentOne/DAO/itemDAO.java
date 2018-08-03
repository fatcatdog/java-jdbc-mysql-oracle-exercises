//@Author = Jacob Duchen
//@Date = 8/2/18

package com.assignmentOne.DAO;

import com.assignmentOne.model.Item;

import java.util.ArrayList;

public interface itemDAO {
    Item getItemById(int id);
    void createItem(Item item);
    ArrayList<Item> getItemsCostingGreaterThan(double price_input);
    ArrayList<Item> getItemsInStock();

}