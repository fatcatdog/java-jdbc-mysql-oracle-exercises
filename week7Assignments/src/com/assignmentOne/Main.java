//@Author = Jacob Duchen
//@Date = 8/2/18

package com.assignmentOne;

import com.assignmentOne.DAO.itemDAO_mySQL;
import com.assignmentOne.model.Item;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
//        Main test = new Main();

//        Connection connection = CreateConnection.getConnection();
        itemDAO_mySQL dao = new itemDAO_mySQL();

//        Item thing = dao.getItemById(2);
//        System.out.println(thing.getName());


//        Item newItem = new Item(4, "Saab", 39, 859.99f);
//        dao.createItem(newItem);

//        ArrayList<Item> allItems = dao.getItemsInStock();

        ArrayList<Item> ourList = dao.getItemsCostingGreaterThan(1.99);





    }

}
