package p2;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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



	}


