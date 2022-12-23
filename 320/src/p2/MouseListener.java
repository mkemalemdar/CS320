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

	
	
}
