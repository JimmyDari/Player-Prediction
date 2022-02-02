package playerPredictions;
import java.sql.*;
import javax.swing.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
	Connection con = null;
	public static Connection connect() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:/Users/jimmydari/eclipse-workspace/tst.db");
			JOptionPane.showMessageDialog(null, "connect");
			return con;
		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}

}
