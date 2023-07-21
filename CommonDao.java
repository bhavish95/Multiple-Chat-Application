package com.bhavish.chatapp.db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import static com.bhavish.chatapp.utils.ConfigReader.getValue;
//throw early and catch later
public interface  CommonDao {
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		// step1 load the driver
		Class.forName(getValue("DRIVER"));
		//step2 making a connection
		final String CONNECTION_STRING=getValue("CONNECTION_URL");
		final String USER_ID=getValue("USERID");
		final String PASSWORD=getValue("PASSWORD");
		Connection con=DriverManager.getConnection(CONNECTION_STRING,USER_ID,PASSWORD);
	    if(con!=null) {
	    	System.out.println("Connection Created..");
	    	//con.close();
	    }
	    return con;
	}
	

}
