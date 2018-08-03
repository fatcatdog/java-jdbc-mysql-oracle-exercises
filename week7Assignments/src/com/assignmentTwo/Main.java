package com.assignmentTwo;

import com.assignmentTwo.DAO.itemDAO_mySQL;
import com.assignmentTwo.DAO.orderDAO_mysql;
import com.assignmentTwo.model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
//        Main test = new Main();

//        Connection connection = CreateConnection.getConnection();
//        itemDAO_mySQL dao = new itemDAO_mySQL();

//        Item thing = dao.getItemById(2);
//        System.out.println(thing.getName());


//        Item newItem = new Item(4, "Saab", 39, 859.99f);
//        dao.createItem(newItem);

//        ArrayList<Item> allItems = dao.getItemsInStock();

//        ArrayList<Item> ourList = dao.getItemsCostingGreaterThan(1.99);

//        Item newItem = new Item(4, "Saaab", 39, 859.99f);
//        dao.updateItem(newItem);
//        ArrayList<Item> newallItems = dao.getItemsInStock();

        itemDAO_mySQL item_dao = new itemDAO_mySQL();

        orderDAO_mysql order_dao = new orderDAO_mysql();
//
        Map<Integer,Integer> jacobsOrder = new HashMap<Integer,Integer>();
        jacobsOrder.put(5, 50);
        jacobsOrder.put(6, 4);
        jacobsOrder.put(7, 3);

        order_dao.processOrder(jacobsOrder);

//        int new_id = item_dao.getMaxIdPlusOne();
//        Item newItem = new Item(new_id, "Sneakers", 28372, 65.99f);
//
//        item_dao.createItem(newItem);








    }

}
