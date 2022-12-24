package projectdeneme;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList; // import the ArrayList class
import java.util.*;
import java.awt.*;
public class ScoreBoard  {
	
  
   public static void main(String args[]) {
			   JButton quitButton=new JButton("QUIT");
			   JButton returnButton=new JButton("RETURN");
		       JPanel scoreBoardPanel=new JPanel();
		       JPanel optionPanel=new JPanel();
			   JFrame scoreBoard=new JFrame("ScoreBoard");
			   DefaultTableModel tableModel = new DefaultTableModel();  
			   ArrayList<String> columnNames = new ArrayList<String>(); 
			   columnNames.add("Name");
			   columnNames.add("Completion Time");
			   scoreBoardPanel.setLayout(new BoxLayout(scoreBoardPanel, BoxLayout.Y_AXIS));
			   scoreBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			   scoreBoard.setSize(1200,800);
			   scoreBoard.setLayout(new BorderLayout());
			   optionPanel.add(quitButton);
			   optionPanel.add(returnButton);
			   scoreBoard.add(optionPanel,BorderLayout.SOUTH);
			   scoreBoard.add(scoreBoardPanel,BorderLayout.NORTH);
			   for(String columnName : columnNames){
				      tableModel.addColumn(columnName);
			   }
			   tableModel.addRow(new Object[]{"dinçer","6"});
			   tableModel.addRow(new Object[]{"ali","5"});
			   JTable jTable = new JTable();
			   jTable.setRowHeight(35);
			   jTable.setEnabled(false);
			   JScrollPane scrollPane=new JScrollPane(jTable);
			   jTable.setModel(tableModel);		   
			   scoreBoardPanel.add(scrollPane);
			   scoreBoard.setVisible(true);
   }
    void addScore(String username,int completionTime) {
	  
  }
    
}
