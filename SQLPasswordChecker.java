package com.bhavish.chatapp.db;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 

public class SQLPasswordChecker {
    public static void main(String[] args) {
        String host = "localhost";
        String username = "root";
        String password = "BHAVISH";
        String database = "chatdb";

 

        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

 

            // Create a connection to the MySQL database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":3306/" + database, username, password);

 

            // If the connection is successful, the password is correct
            System.out.println("Password is correct!");

 

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // If an SQLException is thrown, the password is incorrect
            System.out.println("Password is incorrect!");
            e.printStackTrace();
        }
    }
}