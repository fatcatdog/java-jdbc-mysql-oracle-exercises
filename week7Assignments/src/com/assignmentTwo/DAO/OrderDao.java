//@Author = Jacob Duchen
//@Date = 8/2/18

package com.assignmentTwo.DAO;

import com.assignmentTwo.model.Order;

import java.util.Map;

public interface OrderDao {
    boolean createOrder(Order order);
    int getMaxId();
    void processOrder(Map<Integer, Integer> itemsOrdered);
//    boolean inStock(Order order);
}
