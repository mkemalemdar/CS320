package p2;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class MineSweeper {

private static int NUM_MINES = 40;
private static int SIZE = 20;
private static int num_mines;
private static Timer timer;
private static int seconds=0;
private static JLabel counter;
public static JLabel mineCounter;
private static JLabel picture;
private static String username;
private static JFrame frame2;

private static final String DB_USER = "root";
private static final String DB_PASS = "admin";
private static final String DB_NAME = "mines";
private static final String URL= "jdbc:mysql://localhost:3306/"+ DB_NAME+ "?useSSL=false";
private static Connection connection = null;

public static void establishConnection() {
	try {
		connection = DriverManager.getConnection(URL,DB_USER,DB_PASS);
		if (username== null){ //first login
			intial_login();
		}
		else ;//start();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
}
public static void closeConnection() {
	try {
		connection.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
}

public static void main(String[] args) {
	try {
		establishConnection();
		Statement statement = connection.createStatement();	

	} catch (SQLException e) {
		e.printStackTrace();			
	}
	finally {
		closeConnection();	
	}
}

	public static void intial_login(){


		JFrame frame = new JFrame ("Minesweeper App");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		frame.pack();
		frame.setVisible (true);




		JLabel jcomp1 = new JLabel ("Username:");
		JButton jcomp2 = new JButton ("Set Username");
		JTextField jcomp3 = new JTextField (5);

		//adjust size and set layout
		frame.setPreferredSize (new Dimension (394, 174));
		frame.setLayout (null);

		//add components
		frame.add (jcomp1);
		frame.add (jcomp2);
		frame.add (jcomp3);

		//set component bounds (only needed by Absolute Positioning)
		jcomp1.setBounds (110, 40, 100, 25);
		jcomp2.setBounds (135, 85, 120, 25);
		jcomp3.setBounds (180, 40, 100, 25);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible (true);

		jcomp2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				username = jcomp3.getText();
				frame.dispose();
				//start();
			}

		});


	}
	public static String getName() {
		return username;
	}
	
	
	public static void Timer() {
	timer =new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent event) {		
		  seconds++;
		  counter.setText(""+seconds);
		  
		}});
	}
	public static int getTime() {
		int x=seconds;
		return x;
		
	}
	
	public static void mineCountDown() {
		num_mines--;
		mineCounter.setText(""+(num_mines));
	}
	
	public static void mineCountUp() {
		num_mines++;
		mineCounter.setText(""+(num_mines));
	}

	public static JLabel getLabel() {
		return picture;
	}

	public static int getMineCount() {
		return num_mines;
	}

}


