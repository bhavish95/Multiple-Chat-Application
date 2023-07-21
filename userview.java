package com.bhavish.chatapp.screens;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class userview extends JFrame{
	int counter;
	public userview() {  // creating screen
		counter=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // use to exit screen from down icon on desktop
		setSize(500,500);  // size of screen
		setResizable(false);  // to fix the size of screen after this we cant maximize 
		setTitle("Login"); //title of the screen is login
		//setLocation(500,150); // location of screen opening
		setLocationRelativeTo(null);  // its amomatic opening from centre of screen of desktop
		JLabel welcome=new JLabel("Login");
		welcome.setFont(new Font("Arial",Font.BOLD,40));
		Container container=this.getContentPane();
		container.setLayout(null);
		welcome.setBounds(100,70,200,60); //create box in between of screen
		container.add(welcome);
		JButton button = new JButton("Count"); //source
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				counter++;
				welcome.setText("Count"+counter);
			}
		});
		button.setBounds(100,300,200,50);
		container.add(button);
		setVisible(true);
	}
	public static void main(String[] args) {
		userview us= new userview(); // object of constructor uuserview
		
	}
  
}
