import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.bhavish.chatapp.db.UserDAO;
import com.bhavish.chatapp.dto.UserDTO;
import com.bhavish.chatapp.screens.DashBoard;
import com.bhavish.chatapp.utils.UserInfo;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserScreen extends JFrame{
	private JTextField useridtxt;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		
					UserScreen window = new UserScreen();
					
	}
	UserDAO userDAO=new UserDAO();
	private void doLogin() {
		String userid=useridtxt.getText();
		char []password=passwordField.getPassword();
		
		UserDTO userDTO=new UserDTO(userid,password);
		try {
			String message="";
			if(userDAO.isLogin(userDTO)) {
				message="Welcome"+userid;
				UserInfo.USER_NAME=userid;
				JOptionPane.showMessageDialog(this, message);
				DashBoard dashboard=new DashBoard(message);	
				setVisible(false);
				dispose();
				dashboard.setVisible(true);
			}
			else {
				message="Invalid Uerid or Password";
				JOptionPane.showMessageDialog(this, message);
			}
			//JOptionPane.showMessageDialog(this, message);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void register() {
		String userid=useridtxt.getText();
		char []password=passwordField.getPassword();
		//UserDAO userDAO=new UserDAO();
		UserDTO userDTO=new UserDTO(userid,password);
		try {
		int result=userDAO.add(userDTO);
		if(result>0) {
			JOptionPane.showMessageDialog(this, "Register Successfully");
			//System.out.println("Record Added....");
		}
		else {
			JOptionPane.showMessageDialog(this, "Register faiL");
			//System.out.println("Record not Added...");
		}
		}
		//catch(ClassNotFoundException |SQLException ex) {
			//System.out.println("DB issue...");
			//ex.printStackTrace();
		//}
		catch(Exception ex) {
			System.out.println("Some Generic exception Raised..");
			ex.printStackTrace();// where is exception
		}
		System.out.println("userid " +userid+" Password "+password);//classname@hashcose(hexa)
	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		//setEnabled(false);
		getContentPane().setEnabled(false);
		setTitle("Login");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(243, 43, 138, 58);
		getContentPane().add(lblNewLabel);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(319, 137, 177, 29);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel lbLabel_1 = new JLabel("Userid");
		lbLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbLabel_1.setBounds(192, 124, 98, 49);
		getContentPane().add(lbLabel_1);
		
		JLabel lblLabel_2 = new JLabel("Password");
		lblLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLabel_2.setBounds(192, 183, 98, 49);
		getContentPane().add(lblLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(319, 196, 177, 29);
		getContentPane().add(passwordField);
		
		JButton LoginBT = new JButton("Login");
		LoginBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		LoginBT.setFont(new Font("Tahoma", Font.BOLD, 16));
		LoginBT.setBounds(242, 283, 85, 29);
		getContentPane().add(LoginBT);
		
		JButton RegisterBT = new JButton("Register");
		RegisterBT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		RegisterBT.setFont(new Font("Tahoma", Font.BOLD, 16));
		RegisterBT.setBounds(367, 283, 112, 29);
		getContentPane().add(RegisterBT);
		setBackground(new Color(255, 255, 255));
		setSize( 649, 372);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
}
