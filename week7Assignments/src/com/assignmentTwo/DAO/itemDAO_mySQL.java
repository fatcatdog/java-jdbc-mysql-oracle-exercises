//@Author = Jacob Duchen
//@Date = 8/2/18

package com.assignmentTwo.DAO;

import com.assignmentTwo.connectionFactory.CreateConnection;
import com.assignmentTwo.model.Item;

import java.sql.*;
import java.util.ArrayList;

public class itemDAO_mySQL implements itemDAO {

    @Override
    public int getMaxIdPlusOne(){
        int max = 0;
        Connection connection = CreateConnection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS max_id FROM  item_db.item");
            if (rs.next()) {
                max = rs.getInt(1);
                return (max + 1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return max;
    }

    @Override
    public Item getItemById(int id) {
        Connection connection = CreateConnection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM item WHERE id=" + id);
            if(rs.next())
            {
                Item item = new Item();
                item.setId( rs.getInt("id") );
                item.setName( rs.getString("name") );
                item.setQuantity_in_stock( rs.getInt("quantity_in_stock") );
                item.setPrice( rs.getFloat("price") );
                return item;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    @Override
    public void createItem(Item item) {
        Connection connection = CreateConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO item VALUES (?, ?, ?, ?)");
            ps.setInt(1, item.getId());
            ps.setString(2, item.getName());
            ps.setInt(3, item.getQuantity_in_stock());
            ps.setFloat(4, item.getPrice());

            int i = ps.executeUpdate();
            if(i == 1) {
                System.out.println("Successfully created item :)");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        System.out.println("Failed to create item");
    }

    @Override
    public void updateItem(Item item){
        Connection connection = CreateConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE item SET name=?, quantity_in_stock=?, price=? WHERE id=?");
            ps.setInt(4, item.getId());
            ps.setString(1, item.getName());
            ps.setInt(2, item.getQuantity_in_stock());
            ps.setFloat(3, item.getPrice());
            int i = ps.executeUpdate();

            if(i == 1) {
                System.out.println("Update item successful");;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Update item failed");;
    }


    @Override
    public ArrayList<Item> getItemsCostingGreaterThan(double price_input) {

        Connection connection = CreateConnection.getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM item WHERE price > " + (price_input));
            ArrayList<Item> items = new ArrayList<Item>();
            while(rs.next())
            {
                Item item = new Item();
                item.setId( rs.getInt("id") );
                item.setName( rs.getString("name") );
                item.setQuantity_in_stock( rs.getInt("quantity_in_stock") );
                item.setPrice( rs.getFloat("price") );

                items.add(item);
            }

            System.out.println(items.size() + " items with cost greater than " + price_input);
            for(int i = 0; i < items.size(); i++) {
                System.out.print(items.get(i).getName() + ": ($" +items.get(i).getPrice()  + "), ");
            }

            if(items.size() > 0) {
                System.out.print("are more expensive than $" + price_input + ".");
            }

            return items;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Item> getItemsInStock() {

        Connection connection = CreateConnection.getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM item WHERE NOT quantity_in_stock < 1");
            ArrayList<Item> items = new ArrayList<Item>();
            while(rs.next())
            {
                Item item = new Item();
                item.setId( rs.getInt("id") );
                item.setName( rs.getString("name") );
                item.setQuantity_in_stock( rs.getInt("quantity_in_stock") );
                item.setPrice( rs.getFloat("price") );

                items.add(item);
            }

            System.out.println(items.size() + " items currently in stock (!= 0).");
            for(int i = 0; i < items.size(); i++) {
                System.out.print(items.get(i).getName() + ", ");
            }
            if(items.size() > 0) {
                System.out.print("are in stock.");
            }


            return items;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateQuantityInStock(int order_id) {


        return false;
    }

}
