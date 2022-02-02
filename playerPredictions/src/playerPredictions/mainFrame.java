package playerPredictions;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;

//import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.sql.*;
import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class mainFrame {

	private JFrame frame;
	private String teamaverage;
	private String teamassist;
	private String teamrebounds;
	private String oppoaverage;
	private String oppoassist;
	private String opporebound;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame window = new mainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection connection=null;
	private JTextField nameText;
	private JTable table;
	private JTable table_1;
	private JLabel lblNewLabel_12;
	public mainFrame() {
		//CONNECTING TO DATABASE
		connection=dbconnection.connect();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("AutoFinder");
		btnNewButton.setBounds(28, 68, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel averageLab = new JLabel("00.00");
		averageLab.setBounds(85, 144, 205, 16);
		frame.getContentPane().add(averageLab);
		
		nameText = new JTextField();
		nameText.setBounds(28, 30, 130, 26);
		frame.getContentPane().add(nameText);
		nameText.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(348, 31, 78, 27);
		frame.getContentPane().add(comboBox);
		
		JLabel teamAvg = new JLabel("00.00");
		teamAvg.setBounds(85, 245, 205, 16);
		frame.getContentPane().add(teamAvg);
		
		JComboBox<String> comboBox2 = new JComboBox<String>();
		comboBox2.setBounds(494, 31, 179, 27);
		frame.getContentPane().add(comboBox2);
		
		JComboBox<String> comboBox3 = new JComboBox<String>();
		comboBox3.setBounds(204, 31, 78, 27);
		frame.getContentPane().add(comboBox3);
		
		JLabel playerTeam = new JLabel("Players Team");
		playerTeam.setBounds(207, 6, 89, 16);
		frame.getContentPane().add(playerTeam);
		
		JLabel oppoTeam = new JLabel("Opposing Team");
		oppoTeam.setBounds(338, 6, 111, 16);
		frame.getContentPane().add(oppoTeam);
		
		JLabel lblNewLabel = new JLabel("Players Name");
		lblNewLabel.setBounds(28, 2, 130, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Players Average");
		lblNewLabel_1.setBounds(28, 116, 117, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Points: ");
		lblNewLabel_2.setBounds(28, 144, 47, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Against Opposing Team");
		lblNewLabel_3.setBounds(28, 217, 205, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Points:");
		lblNewLabel_4.setBounds(28, 245, 52, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Players Missing:");
		lblNewLabel_5.setBounds(504, 6, 154, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Assist:");
		lblNewLabel_6.setBounds(28, 165, 47, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel assistAvg = new JLabel("00:00");
		assistAvg.setBounds(85, 165, 191, 16);
		frame.getContentPane().add(assistAvg);
		
		JLabel lblNewLabel_7 = new JLabel("Rebounds:");
		lblNewLabel_7.setBounds(28, 189, 78, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel reboundAvg = new JLabel("00:00");
		reboundAvg.setBounds(107, 189, 205, 16);
		frame.getContentPane().add(reboundAvg);
		
		JLabel lblNewLabel_8 = new JLabel("Assist:");
		lblNewLabel_8.setBounds(28, 273, 47, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel assistTeamAvg = new JLabel("00:00");
		assistTeamAvg.setBounds(84, 273, 179, 16);
		frame.getContentPane().add(assistTeamAvg);
		
		JLabel reboundAvgOppo = new JLabel("Rebound:");
		reboundAvgOppo.setBounds(28, 301, 61, 16);
		frame.getContentPane().add(reboundAvgOppo);
		
		JLabel reboundTeamAvg = new JLabel("00:00");
		reboundTeamAvg.setBounds(97, 301, 179, 16);
		frame.getContentPane().add(reboundTeamAvg);
		
		JLabel test1 = new JLabel("00:00");
		test1.setBounds(494, 116, 222, 16);
		frame.getContentPane().add(test1);
		
		JButton test2 = new JButton("Missing Player");
		test2.setBounds(504, 68, 117, 29);
		frame.getContentPane().add(test2);
		
		JLabel lblNewLabel_9 = new JLabel("Averaged Scored When Gone:");
		lblNewLabel_9.setBounds(492, 101, 205, 16);
		frame.getContentPane().add(lblNewLabel_9);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(348, 143, 424, 153);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton loadStat = new JButton("Load Stats");
		loadStat.setBounds(504, 296, 117, 29);
		frame.getContentPane().add(loadStat);
		
		table_1 = new JTable();
		table_1.setBounds(348, 337, 424, 153);
		frame.getContentPane().add(table_1);
		
		JButton loadStat2 = new JButton("Load Stat");
		loadStat2.setBounds(504, 502, 117, 29);
		frame.getContentPane().add(loadStat2);
		
		JLabel lblNewLabel_10 = new JLabel("Player Stats");
		lblNewLabel_10.setBounds(403, 301, 89, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Player Stats Against Opponents");
		lblNewLabel_11.setBounds(299, 507, 205, 16);
		frame.getContentPane().add(lblNewLabel_11);
		
		JButton proStats = new JButton("Predict");
		proStats.setBounds(53, 462, 117, 29);
		frame.getContentPane().add(proStats);
		
		JLabel proLabel = new JLabel("0:00");
		proLabel.setBounds(127, 434, 61, 16);
		frame.getContentPane().add(proLabel);
		
		lblNewLabel_12 = new JLabel("Prediction:");
		lblNewLabel_12.setBounds(28, 434, 78, 16);
		frame.getContentPane().add(lblNewLabel_12);
		
		
		
		
		//ADDING TEAMS TO COMBOBOX
		comboBox.addItem("ATL");
		comboBox.addItem("BKN");
		comboBox.addItem("BOS");
		comboBox.addItem("CHA");
		comboBox.addItem("CHI");
		comboBox.addItem("CLE");
		comboBox.addItem("DAL");
		comboBox.addItem("DEN");
		comboBox.addItem("DET");
		comboBox.addItem("GSW");
		comboBox.addItem("HOU");
		comboBox.addItem("IND");
		comboBox.addItem("LAC");
		comboBox.addItem("LAL");
		comboBox.addItem("MEM");
		comboBox.addItem("MIA");
		comboBox.addItem("MIL");
		comboBox.addItem("MIN");
		comboBox.addItem("NOH");
		comboBox.addItem("NYK");
		comboBox.addItem("OKC");
		comboBox.addItem("ORL");
		comboBox.addItem("PHI");
		comboBox.addItem("PHO");
		comboBox.addItem("POR");
		comboBox.addItem("SAC");
		comboBox.addItem("TOR");
		comboBox.addItem("UTH");
		comboBox.addItem("WAS");
		
		
		comboBox3.addItem("ATL");
		comboBox3.addItem("BKN");
		comboBox3.addItem("BOS");
		comboBox3.addItem("CHA");
		comboBox3.addItem("CHI");
		comboBox3.addItem("CLE");
		comboBox3.addItem("DAL");
		comboBox3.addItem("DEN");
		comboBox3.addItem("DET");
		comboBox3.addItem("GSW");
		comboBox3.addItem("HOU");
		comboBox3.addItem("IND");
		comboBox3.addItem("LAC");
		comboBox3.addItem("LAL");
		comboBox3.addItem("MEM");
		comboBox3.addItem("MIA");
		comboBox3.addItem("MIL");
		comboBox3.addItem("MIN");
		comboBox3.addItem("NOH");
		comboBox3.addItem("NYK");
		comboBox3.addItem("OKC");
		comboBox3.addItem("ORL");
		comboBox3.addItem("PHI");
		comboBox3.addItem("PHO");
		comboBox3.addItem("POR");
		comboBox3.addItem("SAC");
		comboBox3.addItem("TOR");
		comboBox3.addItem("UTH");
		comboBox3.addItem("WAS");
		
		

		btnNewButton.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	//GRABS NAME FROM TEXT BOX
		    	String q = nameText.getText();
		    	//STORES VALUES FROM COMBOBOX FOR PLAYERS TEAMS
		    	String value= comboBox.getSelectedItem().toString();
		    	String value2= comboBox3.getSelectedItem().toString();
		    	
		    	//ADDING MAIN PLAYERS TO PLAYERS MISSING COMBOBOX FROM EACH TEAM
		   
		    	playerMissing players= new playerMissing();
		    	players.setPlayerMissing(value2,comboBox2);
		    	
		    	//SETTING PLAYER AVERAGE POINTS 
		    	try {
		    		
		    		String query="SELECT field22, AVG(field43) FROM nba WHERE field22 ='"+q+"' and field25!='0:00'";
			    	Statement pst = connection.createStatement();
			    	
			    	ResultSet rs = pst.executeQuery(query); 
			    	while(rs.next()) {
			    	
			    		String nam = rs.getString(1);
			    		teamaverage= rs.getString(2);
			    		averageLab.setText(teamaverage);
			    		pst.close();
			    		rs.close();
			    		
		    	}
		    	
		    	}catch(Exception r)
		    	{
		    		
		    	}
		    	//SETTING PLAYERS AVERAGE AGAINST OPPONETS
		    	try {
		    		
		    		String query="SELECT field22, AVG(field43) FROM nba WHERE field22 ='"+q+"' and field25!='0:00' and field14 ='"+value+"'";
			    	Statement pst = connection.createStatement();
			    	
			    	ResultSet rs = pst.executeQuery(query); 
			    	while(rs.next()) {
			    	
			    		String nam = rs.getString(1);
			    		oppoaverage = rs.getString(2);
			    		teamAvg.setText(oppoaverage);
			    		pst.close();
			    		rs.close();
			    		
		    	}
		    	
		    	}catch(Exception r)
		    	{
		    		
		    	}
		    	//SETTING PLAYERS AVERAGE ASSIST
		    	try {
		    		
		    		String query="SELECT field22, AVG(field38) FROM nba WHERE field22 ='"+q+"' and field25!='0:00'";
			    	Statement pst = connection.createStatement();
			    	
			    	ResultSet rs = pst.executeQuery(query); 
			    	while(rs.next()) {
			    	
			    		String nam = rs.getString(1);
			    		teamassist = rs.getString(2);
			    		assistAvg.setText(teamassist);
			    		pst.close();
			    		rs.close();
			    		
		    	}
		    	
		    	}catch(Exception r)
		    	{
		    		
		    	}
		    	//SETTING PLAYERS AVERAGE ASSIT AGAINST OPPENENTS 
		    	try {
		    		
					String query="SELECT field22, AVG(field38) FROM nba WHERE field22 ='"+q+"' and field25!='0:00' and field14 ='"+value+"'";
			    	Statement pst = connection.createStatement();
			    	
			    	ResultSet rs = pst.executeQuery(query); 
			    	while(rs.next()) {
			    	
			    		String nam = rs.getString(1);
			    		oppoassist = rs.getString(2);
			    		assistTeamAvg.setText(oppoassist);
			    		pst.close();
			    		rs.close();
			    		
		    	}
		    	
		    	}catch(Exception r)
		    	{
		    		
		    	}
		    	//SETTING PLAYERS AVERAGE REBOUNDS
		    	try {
		    		
					String query="SELECT field22, AVG(field37) FROM nba WHERE field22 ='"+q+"' and field25!='0:00'";
			    	Statement pst = connection.createStatement();
			    	
			    	ResultSet rs = pst.executeQuery(query); 
			    	while(rs.next()) {
			    	
			    		String nam = rs.getString(1);
			    		teamrebounds = rs.getString(2);
			    		reboundAvg.setText(teamrebounds);
			    		pst.close();
			    		rs.close();
			    		
		    	}
		    	
		    	}catch(Exception r)
		    	{
		    	//SETTING PLAYERS AVERAGE REBOUNDS AGAINST TEAM	
		    	}
				try {
					
					String query="SELECT field22, AVG(field37) FROM nba WHERE field22 ='"+q+"' and field25!='0:00' and field14 ='"+value+"'";
					Statement pst = connection.createStatement();
					
					ResultSet rs = pst.executeQuery(query); 
					while(rs.next()) {
					
						String nam = rs.getString(1);
						opporebound = rs.getString(2);
						reboundTeamAvg.setText(opporebound);
						pst.close();
						rs.close();
						
				}
				
				}catch(Exception r)
				{
					
				}
				
		    }
		    
		});
		//SETTING PLAYERS POINTS WHEN THAT PLAYER IS MISSING 
		test2.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		
		String q = nameText.getText();
		String value3= comboBox2.getSelectedItem().toString();
		
		
		try {
			
			String query="SELECT field22,avg(field43) FROM nba WHERE field13 like '%"+value3+"%' and field22 = '"+q+"'";
			Statement pst = connection.createStatement();
			
			ResultSet rs = pst.executeQuery(query); 
			while(rs.next()) {
			
				String nam = rs.getString(1);
				opporebound = rs.getString(2);
				test1.setText(opporebound);
				pst.close();
				rs.close();
				
		}
		
		}catch(Exception r)
		{
			
		}
		
		}
		
		});
		
		//LOAD STATS INTO TABLE
		loadStat.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		
		String q = nameText.getText();
		
		

		try {
			
			String query="Select field22, field14, field37, field38, field43 From nba where field22='"+q+"'";
			Statement pst = connection.createStatement();
			
			ResultSet rs = pst.executeQuery(query); 
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 TableColumnModel tcm = table.getColumnModel();
			 tcm.getColumn(0).setHeaderValue("Player Name");
			 tcm.getColumn(1).setHeaderValue("Against");
			 tcm.getColumn(2).setHeaderValue("Rebounds");
			 tcm.getColumn(3).setHeaderValue("Assists");
			 tcm.getColumn(4).setHeaderValue("Points");
		
		}catch(Exception r)
		{
			
		}
		
		}
		
		});
		//LOAD STATS INTO TABLE
		loadStat2.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		String value= comboBox.getSelectedItem().toString();
		String q = nameText.getText();
		
		

		try {
			
			String query="Select field22, field14, field37, field38, field43 From nba where field22='"+q+"' and field14='"+value+"'";
			Statement pst = connection.createStatement();
			
			ResultSet rs = pst.executeQuery(query); 
			 table_1.setModel(DbUtils.resultSetToTableModel(rs));
			 TableColumnModel tcm = table_1.getColumnModel();
			 tcm.getColumn(0).setHeaderValue("Player Name");
			 tcm.getColumn(1).setHeaderValue("Against");
			 tcm.getColumn(2).setHeaderValue("Rebounds");
			 tcm.getColumn(3).setHeaderValue("Assist");
			 tcm.getColumn(4).setHeaderValue("Points");
		
		}catch(Exception r)
		{
			
		}
		
		}
		
		});
		//PROJECT THE PLAYER STATS USING MY FORMULA/ALGORITHM
		proStats.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	String getSt = averageLab.getText();
		    	String value3= comboBox.getSelectedItem().toString();
		    	String value4 = teamAvg.getText();
		    	String value5= comboBox2.getSelectedItem().toString();
		    	
		    	oppDef defense= new oppDef();
		    	defense.oppDefRank(getSt, value3, value4,value5, proLabel, test1);
		    	
		    }
		    
		    });
		    
		
	}
}

