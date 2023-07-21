package com.bhavish.chatapp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bhavish.chatapp.dto.UserDTO;
import com.bhavish.chatapp.utils.Encryption;

//USER CRUD
public class UserDAO {
	
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException,Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		final String SQL="select userid from users where userid=? and password=?";
		try {
			con=CommonDao.createConnection();
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1, userDTO.getUserid());
			String encryptedPwd=Encryption.passwordEncrypt(new String(userDTO.getPassword()));
			pstmt.setString(2, encryptedPwd);
			rs=pstmt.executeQuery();
			return rs.next();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
    
	//public int add(String userid,String password,byte age,String phone,String email,String country ,String state,String stdcode ){
		public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException ,Exception{
			// throws means we not handle caller will handle so we say it is emplicit throw
			System.out.println("Rec"+userDTO.getUserid()+" "+userDTO.getPassword());
			Connection connection=null;
			Statement stmt=null;//query
			try {// Garden region
			connection=CommonDao.createConnection();//step1 Connection create 
			//step 2 we do query
			stmt=connection.createStatement();
			//insert into users(userid, password) values('ram','ram123');
			int record=stmt.executeUpdate("insert into users(userid, password) values('"+userDTO.getUserid()+"','"+Encryption.passwordEncrypt(new String (userDTO.getPassword()))+"')");//insert , delete, update
			return record;
			}
			finally {// Always execute except if you write system.exit then it not execute 
				if(stmt!=null) {
			stmt.close();
				}
				if(connection!=null) {
			connection.close();
				}
			}
			
	}
}
