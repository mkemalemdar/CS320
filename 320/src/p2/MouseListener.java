package p2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MouseListener extends MouseAdapter {
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
		Icon icon = new ImageIcon("src\p2\\flag.png");
		  button.setIcon(icon);
		  MineSweeperGUI.getFlags()[row][col]=true;
		  	}  
		else if(!MineSweeperGUI.getFlags()[row][col] && !MineSweeperGUI.getOpenedCells()[row][col] ) { 
		
			Icon icon = new ImageIcon("src\p2\\flag.png");
			  button.setIcon(icon);
			  MineSweeperGUI.getFlags()[row][col]=true;
			  	}  
		else if (!MineSweeperGUI.getOpenedCells()[row][col] && grid.isMINE(row, col)) {
		MineSweeper.mineCountUp();
				Icon icon1 = new ImageIcon("src\p2\\button.png");
				button.setIcon(icon1);
			 MineSweeperGUI.getFlags()[row][col]=false;
	} 	else if(!MineSweeperGUI.getOpenedCells()[row][col] ){

		Icon icon1 = new ImageIcon("src\p2\\button.png");
		button.setIcon(icon1);
		  MineSweeperGUI.getFlags()[row][col]=false;

	}
}

	if (MineSweeper.getMineCount()==0) {
	int time = MineSweeper.getTime();
	String name = MineSweeper.getName();
	JOptionPane.showMessageDialog(null, "You have completed the game in "+ time + " seconds!");


	 
} else return;
	}	
	
}
