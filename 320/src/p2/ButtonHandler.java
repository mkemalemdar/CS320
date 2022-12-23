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

	
}
