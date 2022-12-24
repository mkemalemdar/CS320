package p2;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList; // import the ArrayList class
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ScoreBoard  {
	
  
   public static void main(String args[]) {
   }   
	   
   public static void getScoreboard() {
		   JButton quitButton=new JButton("QUIT");
		   JButton returnButton=new JButton("RETURN");
	       JPanel scoreBoardPanel=new JPanel();
	       JPanel optionPanel=new JPanel();
		   JFrame scoreBoard=new JFrame("ScoreBoard");
		   DefaultTableModel tableModel = new DefaultTableModel();  
		   ArrayList<String> columnNames = new ArrayList<String>(); 
		   columnNames.add("User Name");
		   columnNames.add("Score");
		   scoreBoardPanel.setLayout(new BoxLayout(scoreBoardPanel, BoxLayout.Y_AXIS));
		   scoreBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   scoreBoard.setSize(1200,800);
		   scoreBoard.setLayout(new BorderLayout());
		   optionPanel.add(quitButton);
		   
		   quitButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		   
		   
		   optionPanel.add(returnButton);
		   returnButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					scoreBoard.dispose();
				}
			});
		   
		   scoreBoard.add(optionPanel,BorderLayout.SOUTH);
		   scoreBoard.add(scoreBoardPanel,BorderLayout.NORTH);
		   for(String columnName : columnNames){
			      tableModel.addColumn(columnName);
		   }
		   
		   Connection conn = MineSweeper.establishConnection();
		   PreparedStatement pt = null;
		   Statement statement = null;
			try {
				statement = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			   String sql31 = "SELECT * FROM leaderboard order by score_time ASC;";
			   
				try (ResultSet rs1 = statement.executeQuery(sql31)){
					while(rs1.next()) {			 
						tableModel.addRow(new Object[]
								{rs1.getString("user_name"),rs1.getInt("score_time")});		
						}
					}	catch (SQLException e) {
						e.printStackTrace();			
					}
   			
				
	 
		   JTable jTable = new JTable();
		   jTable.setRowHeight(35);
		   jTable.setEnabled(false);
		   JScrollPane scrollPane=new JScrollPane(jTable);
		   jTable.setModel(tableModel);		   
		   scoreBoardPanel.add(scrollPane);
		   scoreBoard.setVisible(true);
	   }
   
    
    
    
}
