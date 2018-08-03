//@Author = Jacob Duchen
//@Date = 8/3/18

package CoreJava.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlConnection {

    public static Connection getConnection() throws ClassNotFoundException,
            IOException, SQLException {
        final Properties prop = new Properties();
        final InputStream inputStream = MySqlConnection.class.getClassLoader()
                .getResourceAsStream(
                        "CoreJava/Resources/db.properties");
        prop.load(inputStream);
        Class.forName(prop.getProperty("driver"));
        final Connection connection = DriverManager.getConnection(prop.getProperty("url"),
                prop.getProperty("user"), prop.getProperty("password"));
        return connection;
    }

//    public static Connection getConnection() {
//        System.out.println("Making sure program can find jdbc driver... which is in my path... so....");
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Where is your MySQL JDBC Driver?");
//            e.printStackTrace();
//        }
//
//        System.out.println("Great mysql jdbc driver found and no errors...");
//
//        Connection connection = null;
//
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/item_db", "root", "Baseball");
//
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Please read errors");
//            e.printStackTrace();
//
//        }
//
//        if (connection != null) {
//            System.out.println("You have access to database....");
//        } else {
//            System.out.println("Connection failed");
//        }
//
//        return connection;
//    }
}
