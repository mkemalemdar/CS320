package p2;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;



public class MineSweeperGUI extends JPanel {
	private MineGrid grid;
	private static JButton [][] buttons;
	private static boolean [][] flags;
	private static boolean [][] openedCells;

	public MineSweeperGUI(int numRows,int numCols,int numMines) {
		 // grid =new MineGrid(numRows,numCols,numMines);

		buttons=new JButton[numRows][numCols];
		flags=new boolean[numRows][numCols];
		openedCells=new boolean[numRows][numCols];
		setLayout(new GridLayout(numRows,numCols));
		ArrayList <JButton> buttons=new ArrayList();
		for (int i=0;i<numRows;i++) {
			for(int j=0;j<numCols;j++) {

				JButton button= new JButton();
				MineSweeperGUI.buttons[i][j]=button;
				buttons.add(button);
				button.setSize(5,5);
				add(button);
				button.setSize(20,20);
				Icon buttonIcon = new ImageIcon("src\\p2\\button.png");
				button.setIcon(buttonIcon);
				button.addActionListener(new ButtonHandler(i,j,grid));
				button.addMouseListener(new MouseListener(i,j,grid));


			}
		}
	}
	
public static JButton[][] getButtons() {
	return buttons;
}

	public static boolean[][] getFlags() {
		return flags;
	}
	public static boolean [][] getOpenedCells() {
		return openedCells;
	}



}
