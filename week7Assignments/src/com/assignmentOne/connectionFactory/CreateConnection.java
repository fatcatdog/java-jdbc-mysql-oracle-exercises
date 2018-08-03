//@Author = Jacob Duchen
//@Date = 8/2/18

package com.assignmentOne.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {

    public static Connection getConnection() {
        System.out.println("Making sure program can find jdbc driver... which is in my path... so....");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }

        System.out.println("Great mysql jdbc driver found and no errors...");

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/item_db", "root", "Baseball");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Please read errors");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("You have access to database....");
        } else {
            System.out.println("Connection failed");
        }

        return connection;
    }

}
