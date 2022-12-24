package p2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonHandler implements ActionListener {
private int row,col;
private MineGrid grid;

public ButtonHandler(int x,int y, MineGrid g) {
	row=x;
	col=y;
	grid=g;
}

		public void actionPerformed(ActionEvent event) {
		if(grid.isMINE(row, col) && event.getSource() instanceof JButton && !MineSweeperGUI.getFlags()[row][col]) {
			JButton button =(JButton)event.getSource();
		    Icon icon = new ImageIcon("src\\p2\\mine.png");
           button.setIcon(icon);
       	for (int i=0;i<MineSweeperGUI.getButtons().length;i++) {
			for(int j=0;j<MineSweeperGUI.getButtons()[0].length;j++) {
			  if(grid.isMINE(i,j)) {
				 MineSweeperGUI.getButtons()[i][j].setIcon(icon);
			 }
			}
		}
        Icon sad = new ImageIcon("src\\p2\\sad.png");
       	MineSweeper.getLabel().setIcon(sad);
	JOptionPane.showMessageDialog(null, "You have lost!");
			
	MineSweeper.end();
		} else {
			if (event.getSource() instanceof JButton) {
				JButton button =(JButton)event.getSource();	
			     if (!MineSweeperGUI.getFlags()[row][col] && !MineSweeperGUI.getOpenedCells()[row][col]) {	
				
				if(grid.getCellContent(row,col)==0) {
					
					revealZeros(row,col);
					MineSweeperGUI.getOpenedCells()[row][col]=true;
					
				}
				
				else if(grid.getCellContent(row, col)==1) {
					  Icon icon1 = new ImageIcon("src\\p2\\1.png");
					  button.setIcon(icon1);
						MineSweeperGUI.getOpenedCells()[row][col]=true;
				
				   } 
				   else if(grid.getCellContent(row, col)==2) {
						  Icon icon2 = new ImageIcon("src\\p2\\2.png");
						  button.setIcon(icon2);
							MineSweeperGUI.getOpenedCells()[row][col]=true;
					
					}
				   else if(grid.getCellContent(row, col)==3) {
						  Icon icon3 = new ImageIcon("src\\png\\3.png");
						  button.setIcon(icon3);
							MineSweeperGUI.getOpenedCells()[row][col]=true;
					}
				   else if(grid.getCellContent(row, col)==4) {
						  Icon icon4 = new ImageIcon("src\\png\\4.png");
						  button.setIcon(icon4);
							MineSweeperGUI.getOpenedCells()[row][col]=true;
					} else {
						Icon icon5 = new ImageIcon("src\\png\\5.png");
						  button.setIcon(icon5);
							MineSweeperGUI.getOpenedCells()[row][col]=true;
					}
				}
				}
			}
		}
	public void revealZeros(int row, int col) {
		if(!grid.isInsideGrid(row, col)) return;

	     if ( grid.getCellContent(row, col) == 0 && !MineSweeperGUI.getFlags()[row][col] && !MineSweeperGUI.getOpenedCells()[row][col]) {
	 
	               MineSweeperGUI.getButtons()[row][col].setIcon(null);  
	               MineSweeperGUI.getButtons()[row][col].setBackground(Color.LIGHT_GRAY);
	               MineSweeperGUI.getOpenedCells()[row][col] = true;
	              
	               revealOtherNumbers(row+1, col-1);
	               revealOtherNumbers(row+1, col);
	               revealOtherNumbers(row+1, col+1);
	               revealOtherNumbers(row-1, col);
	               revealOtherNumbers(row-1, col+1);
	               revealOtherNumbers(row-1, col-1);
	               revealOtherNumbers(row, col-1);
	               revealOtherNumbers(row, col-1);
	               
	               revealZeros( row+1, col-1 );
	               revealZeros( row+1, col );
	               revealZeros( row+1, col +1);
	               revealZeros( row-1, col );      
	               revealZeros( row-1, col +1);
	               revealZeros( row-1, col -1);
	               revealZeros( row, col-1 );
	               revealZeros( row, col+1 );
	                             
	           } else {
	               return;
	           }
	        
		
	}
	
	public void revealOtherNumbers(int row, int col) {
		if(!grid.isInsideGrid(row, col)) return;
		 if ( grid.getCellContent(row, col)!=0 && !MineSweeperGUI.getFlags()[row][col] && !MineSweeperGUI.getOpenedCells()[row][col] &&!grid.isMINE(row, col)) {
			 if(grid.getCellContent(row, col)==1) {
				  Icon icon1 = new ImageIcon("src\\p2\\1.png");
				  MineSweeperGUI.getButtons()[row][col].setIcon(icon1);
					MineSweeperGUI.getOpenedCells()[row][col]=true;
			
			   } 
			   else if(grid.getCellContent(row, col)==2) {
					  Icon icon2 = new ImageIcon("src\\p2\\2.png");
					  MineSweeperGUI.getButtons()[row][col].setIcon(icon2);
						MineSweeperGUI.getOpenedCells()[row][col]=true;
				
				}
			   else if(grid.getCellContent(row, col)==3) {
					  Icon icon3 = new ImageIcon("src\\p2\\3.png");
					  MineSweeperGUI.getButtons()[row][col].setIcon(icon3);
						MineSweeperGUI.getOpenedCells()[row][col]=true;
				}
			   else if(grid.getCellContent(row, col)==4) {
					  Icon icon4 = new ImageIcon("src\\p2\\4.png");
					  MineSweeperGUI.getButtons()[row][col].setIcon(icon4);
						MineSweeperGUI.getOpenedCells()[row][col]=true;
				} else {
					Icon icon5 = new ImageIcon("src\\p2\\5.png");
					 MineSweeperGUI.getButtons()[row][col].setIcon(icon5);
						MineSweeperGUI.getOpenedCells()[row][col]=true;
				}
		 }
	}

}
