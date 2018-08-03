//@Author = Jacob Duchen
//@Date = 8/2/18

package com.assignmentTwo.DAO;

import com.assignmentTwo.connectionFactory.CreateConnection;
import com.assignmentTwo.model.Item;
import com.assignmentTwo.model.Order;

import java.sql.*;
import java.util.Map;
import java.util.Set;

public class orderDAO_mysql implements OrderDao {

    @Override
    public int getMaxId() {
        int max = 0;
        Connection connection = CreateConnection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS max_id FROM  item_db.order");
            if (rs.next()) {
                 max = rs.getInt(1);
                 return max;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return max;
    }

//    @Override
//    public boolean inStock(Order order) {
//
//
//        return false;
//    }

    @Override
    public void processOrder(Map<Integer, Integer> hashMapOfOrders){
        Set< Map.Entry< Integer,Integer> > iterateThroughItems = hashMapOfOrders.entrySet();

        for (Map.Entry< Integer,Integer> tempOrder:iterateThroughItems) {
            int maxId = getMaxId();

            Order order = new Order((maxId + 1), tempOrder.getKey(), tempOrder.getValue());

//            if(inStock(order)){
                createOrder(order);
//            } else {
//                System.out.println("we ran out of those...");
//            }

        }

    }

    @Override
    public boolean createOrder(Order tempOrder) {
        Connection connection = CreateConnection.getConnection();

        try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO item_db.order VALUES (?, ?, ?)");
                ps.setInt(1, tempOrder.getId());
                ps.setInt(2, tempOrder.getItem_id());
                ps.setInt(3, tempOrder.getQuantity());

                int i = ps.executeUpdate();
                if (i == 1) {
                    System.out.println("Successfully ordered item :)");
                }

                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        return false;

            }

}
