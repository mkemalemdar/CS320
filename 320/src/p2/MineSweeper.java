

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
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
public static int diff;

public static final String DB_USER = "root";
public static final String DB_PASS = "12345";
public static final String DB_NAME = "mines";
public static final String URL= "jdbc:mysql://localhost:3306/"+ DB_NAME+ "?useSSL=false";
public static Connection connection = null;

public static Connection establishConnection() {
	try {
		connection = DriverManager.getConnection(URL,DB_USER,DB_PASS);		
		return connection;
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
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
		if (username== null){ //wait until its given
			intial_login();
		}
		else start();

	} catch (SQLException e) {
		e.printStackTrace();			
	}
	finally {
		closeConnection();	
	}
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
			start();
		}

	});


}

public static void set_difficulty(){

	JFrame frame = new JFrame ("Set Difficulty");
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	frame.pack();

	JRadioButton e_select = new JRadioButton ("Easy");
	JRadioButton n_select = new JRadioButton ("Normal");
	JRadioButton h_select = new JRadioButton ("Hard");
	JRadioButton c_select = new JRadioButton ("Custom");
	JLabel jcomp5 = new JLabel ("Choose Difficulty");
	JButton a_button = new JButton ("Apply");
	JTextField grid_text = new JTextField (5);
	JTextField mine_text = new JTextField (5);
	JLabel grid_label = new JLabel ("Grid size");
	JLabel mine_label = new JLabel ("Number of mines");

	//adjust size and set layout
	frame.setPreferredSize (new Dimension (691, 200));
	frame.setLayout (null);

	//add components
	frame.add (e_select);
	frame.add (n_select);
	frame.add (h_select);
	frame.add (c_select);
	frame.add (jcomp5);
	frame.add (a_button);
	frame.add (grid_text);
	frame.add (mine_text);
	frame.add (grid_label);
	frame.add (mine_label);

	//set component bounds (only needed by Absolute Positioning)
	e_select.setBounds (50, 70, 100, 25);
	n_select.setBounds (170, 70, 100, 25);
	h_select.setBounds (305, 70, 100, 25);
	c_select.setBounds (430, 70, 70, 25);
	jcomp5.setBounds (45, 20, 100, 25);
	a_button.setBounds (300, 115, 100, 25);
	grid_text.setBounds (525, 70, 35, 25);
	mine_text.setBounds (605, 70, 35, 25);
	grid_label.setBounds (515, 95, 75, 25);
	mine_label.setBounds (575, 95, 110, 25);



	frame.pack();
	frame.setLocationRelativeTo(null);
	frame.setVisible (true);

	ButtonGroup G = new ButtonGroup();
	G.add(e_select);
	G.add(n_select);
	G.add(h_select);
	G.add(c_select);

	a_button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e_select.isSelected()){
                diff=1;
                NUM_MINES = 5;
                SIZE = 10;
                JOptionPane.showMessageDialog(null, "Easy Difficulty Selected");
            }
            else if (n_select.isSelected()){
                diff=2;
                NUM_MINES = 40;
                SIZE = 20;
                JOptionPane.showMessageDialog(null, "Normal Difficulty Selected");
            }
            else if (h_select.isSelected()){
                diff=3;
                NUM_MINES = 80;
                SIZE = 30;
                JOptionPane.showMessageDialog(null, "Hard Difficulty Selected");
            }
            else if (c_select.isSelected()){
                diff=4;
                NUM_MINES = Integer.parseInt(mine_text.getText());
                SIZE = Integer.parseInt(grid_text.getText());
                JOptionPane.showMessageDialog(null, "Custom Difficulty Selected");
            }

            frame.dispose();
        }
	});



}

public static void end(){
	frame2.dispose();
	seconds = 0;
	timer.stop();

	JFrame frame = new JFrame ("GG! " + username);
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	frame.pack();

	JButton p_button = new JButton ("Play Again");
	JButton s_button = new JButton ("Change Settings");
	JButton l_button = new JButton ("LeaderBoard");
	JButton q_button = new JButton ("Quit");
	JButton u_button = new JButton ("Change Username");

	//adjust size and set layout
	frame.setPreferredSize (new Dimension (858, 200));
	frame.setLayout (null);

	//add components
	frame.add (p_button);
	frame.add (s_button);
	frame.add (l_button);
	frame.add (q_button);
	frame.add (u_button);

	//set component bounds (only needed by Absolute Positioning)
	p_button.setBounds (65, 40, 130, 45);
	s_button.setBounds (250, 40, 150, 45);
	l_button.setBounds (450, 40, 150, 45);
	q_button.setBounds (360, 105, 120, 45);
	u_button.setBounds (655, 40, 150, 45);

	frame.pack();
	frame.setLocationRelativeTo(null);
	frame.setVisible (true);


	p_button.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			game(1);
			frame.dispose();
		}
	});

	q_button.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});

	u_button.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			update_username();
			frame.setTitle("GG! " + username);
		}
	});

	s_button.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			set_difficulty();
		}
	});

	l_button.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			
			ScoreBoard.getScoreboard();
		}
	});
}

public static void game(int i){
	frame2=new JFrame("Mine Sweeper | # of mines;" +NUM_MINES);
	num_mines = NUM_MINES;
	int size = SIZE;

	frame2.setSize(SIZE*20,SIZE*20+100);
	JPanel panel=new JPanel();
	panel.setBackground(Color.LIGHT_GRAY);



	panel.setLayout(new BorderLayout());
	frame2.add(panel,BorderLayout.NORTH);
	Icon Smiley =new ImageIcon("C:\\smiley.png");
	picture= new JLabel(Smiley);
	panel.add(picture);



	MineSweeperGUI panel2=new MineSweeperGUI(size, size,num_mines);
	panel2.setBackground(Color.LIGHT_GRAY);

	frame2.add(panel2,BorderLayout.SOUTH);


	frame2.add(panel2);

	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	counter=new JLabel("000");
	counter.setOpaque(true);
	counter.setBackground(Color.BLACK);
	counter.setFont(new Font("Courier", Font.BOLD, 25));
	counter.setForeground(Color.RED);
	panel.add(counter, BorderLayout.EAST);

	frame2.setLocationRelativeTo(null);
	frame2.setVisible(true);

	if (i == 0){
		Timer();
		timer.start();
	}
	else if (i == 1){
		timer.restart();
	}

	mineCounter=new JLabel(""+num_mines);
	mineCounter.setOpaque(true);
	mineCounter.setBackground(Color.BLACK);
	mineCounter.setFont(new Font("Courier", Font.BOLD, 25));
	mineCounter.setForeground(Color.RED);
	panel.add(mineCounter,BorderLayout.WEST);


}

public static void start(){
	JFrame frame = new JFrame ("Welcome " + username);
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);



	//construct components
	JButton p_button = new JButton ("Play");
	JButton s_button = new JButton ("Settings");
	JButton u_button = new JButton ("Change Username");
	JButton q_button = new JButton ("Quit");

	//adjust size and set layout
	frame.setPreferredSize (new Dimension (596, 204));
	frame.setLayout (null);

	//add components
	frame.add (p_button);
	frame.add (s_button);
	frame.add (u_button);
	frame.add (q_button);

	//set component bounds (only needed by Absolute Positioning)
	p_button.setBounds (225, 35, 145, 50);
	s_button.setBounds (250, 130, 100, 25);
	u_button.setBounds (50, 130, 150, 25);
	q_button.setBounds (410, 130, 100, 25);


	frame.pack();
	frame.setLocationRelativeTo(null);
	frame.setVisible (true);

	p_button.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			game(0);
			frame.dispose();
		}
	});

	q_button.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});

	u_button.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			update_username();
			frame.setTitle("Welcome " + username);
		}
	});

	s_button.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			set_difficulty();
		}
	});

}

public static void update_username(){


		JFrame frame = new JFrame ("Update Username");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		frame.pack();
		frame.setVisible (true);




		JLabel jcomp1 = new JLabel ("Username:");
		JButton jcomp2 = new JButton ("Update");
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

				JOptionPane.showMessageDialog(null, "Username Has Been Updated");
				frame.dispose();
			}

		});


	}

}
