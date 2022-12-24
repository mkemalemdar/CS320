package p2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;


public class MouseListener extends MouseAdapter  {
private MineGrid grid;
private int row;
private int col;
public MouseListener(int x,int y, MineGrid g) {
	row=x;
	col=y;
	grid=g;
}

	public void mouseClicked(MouseEvent ME) {
		
	
		if (ME.getButton()==3 && ME.getSource() instanceof JButton) {
		JButton button =(JButton)ME.getSource(); 
		
		if(!MineSweeperGUI.getFlags()[row][col] && !MineSweeperGUI.getOpenedCells()[row][col] && grid.isMINE(row, col)) { 
		MineSweeper.mineCountDown();
		Icon icon = new ImageIcon("src\\p2\\flag.png");
		  button.setIcon(icon);
		  MineSweeperGUI.getFlags()[row][col]=true;
		  	}  
		else if(!MineSweeperGUI.getFlags()[row][col] && !MineSweeperGUI.getOpenedCells()[row][col] ) { 
		
			Icon icon = new ImageIcon("src\\p2\\flag.png");
			  button.setIcon(icon);
			  MineSweeperGUI.getFlags()[row][col]=true;
			  	}  
		else if (!MineSweeperGUI.getOpenedCells()[row][col] && grid.isMINE(row, col)) {
		MineSweeper.mineCountUp();
				Icon icon1 = new ImageIcon("src\\p2\\button.png");
				button.setIcon(icon1);
			 MineSweeperGUI.getFlags()[row][col]=false;
	} 	else if(!MineSweeperGUI.getOpenedCells()[row][col] ){

		Icon icon1 = new ImageIcon("src\\p2\\button.png");
		button.setIcon(icon1);
		  MineSweeperGUI.getFlags()[row][col]=false;

	}
}
if (MineSweeper.getMineCount()==0) {
	int time = MineSweeper.getTime();
	String name = MineSweeper.getName();
	JOptionPane.showMessageDialog(null, "You have completed the game in "+ time + " seconds!");
	MineSweeper.end();
	
	if (MineSweeper.diff==1) {
	       time=time*1000;
	   } if(MineSweeper.diff==2) {
	       time=time*600;
	   }if (MineSweeper.diff==3) {
	       time=time*300;
	   } 

	   if (MineSweeper.diff!=0) {
	        Connection conn = MineSweeper.establishConnection();
	        PreparedStatement pt = null;

	        String sql = " insert into leaderboard (user_name, score_time) VALUES (?, ?)";
	        try {
	            pt = conn.prepareStatement(sql);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        try {
	            pt.setString (1, name);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        try {
	            pt.setInt (2, time);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        try {
	            pt.executeUpdate();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }

	   }
	 
} else return;
	
}
	
}