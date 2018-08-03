//@Author = Jacob Duchen
//@Date = 8/2/18

package com.assignmentTwo.DAO;

import com.assignmentTwo.connectionFactory.CreateConnection;
import com.assignmentTwo.model.Item;
import com.assignmentTwo.model.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public interface itemDAO {
    Item getItemById(int id);

    void createItem(Item item);

    void updateItem(Item item);

    ArrayList<Item> getItemsCostingGreaterThan(double price_input);

    ArrayList<Item> getItemsInStock();

    boolean updateQuantityInStock(int order_id);

    int getMaxIdPlusOne();

}
