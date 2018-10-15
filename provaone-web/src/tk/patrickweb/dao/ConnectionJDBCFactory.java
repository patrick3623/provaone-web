package tk.patrickweb.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionJDBCFactory {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return (Connection) DriverManager.getConnection("jdbc:mysql://172.17.0.2:3306/prova_db", "root", "root");
	}

}
