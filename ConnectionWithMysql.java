package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionWithMysql {	
	
	public static Connection getConnection() {	
		
		Connection connection = null;
		
		String url = "jdbc:mysql://localhost:3306/practicedb";
		String username = "root";
		String password = "Java@2022";
		
		try {
			
			connection = DriverManager.getConnection(url, username, password);
			
			if(connection!=null) {
				
				return connection;
			}
		} 
		catch (SQLException se) {
			
			se.printStackTrace();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return connection;		
	}
	
	public static void closeConnection(ResultSet resultSet,PreparedStatement prepareStatement,Connection connection) {		
			
			try {
				
				if(resultSet!=null) {
					
				resultSet.close();
				
				}
				
				if(prepareStatement!=null) {
					
					prepareStatement.close();
				}
				
				if(connection!=null) {
					
					connection.close();
				}
			} 
			
			catch (SQLException e) {
				
				e.printStackTrace();
			}		
	}
}
