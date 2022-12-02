package dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InsertionRetrievalWithSqlDate extends ConnectionWithMysql {

	public static void main(String[] args){
		
		Connection connection = null;
		
		PreparedStatement pstmt =null;
		
		ResultSet resultSet = null;
		
		Scanner scan = new Scanner(System.in);
		
		try {
		
		connection = ConnectionWithMysql.getConnection();
		
		System.out.println("Enter the user details ::: ");
		
		System.out.println("Enter the name");
		
		String name = scan.next();
		
		System.out.println("Enter the address");
		
		String address = scan.next();
		
		System.out.println("Enter the gender");
		
		String gender = scan.next();
		
		System.out.println("Enter the date of birth :: dd-MM-yyyy");
		
		String birthdate = scan.next();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		java.util.Date utilDob = sdf.parse(birthdate);
		
		long time = utilDob.getTime();
		
		java.sql.Date sqlDob = new java.sql.Date(time);
		
		System.out.println("Enter the date of joining :: MM-dd-yyyy");
		
		String joinDate = scan.next();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		
		java.util.Date utilDob1 = sdf1.parse(joinDate);
		
		long time1 = utilDob1.getTime();
		
		java.sql.Date sqlDob1 = new java.sql.Date(time1);
		
		System.out.println("Enter the date of marriage :: yyyy-MM-dd");
		
		String marDate = scan.next();
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date utilDob2 = sdf2.parse(marDate);
		
		long time2 = utilDob2.getTime();
		
		java.sql.Date sqlDob2 = new java.sql.Date(time2);		
		
		String sqlQuery = "insert into userdata(username,address,gender,dob,doj,dom) values(?,?,?,?,?,?)";
		
		if(connection!=null) {
		
		pstmt= connection.prepareStatement(sqlQuery);	
		
		}
		
		if(pstmt!=null) {
		pstmt.setString(1, name);
		pstmt.setString(2, address);
		pstmt.setString(3, gender);
		pstmt.setDate(4, sqlDob);
		pstmt.setDate(5, sqlDob1);
		pstmt.setDate(6, sqlDob2);
		
		
		int result = pstmt.executeUpdate();
		
		System.out.println(result + " row affected");
		
		String sql = "select username,address,gender,dob,doj,dom from userdata where username=?";
		
		System.out.println("Enter the name to retrieve data");
		
		String data = scan.next();
		
		if(connection!=null) {
			
			pstmt = connection.prepareStatement(sql);
		}
		
		if(pstmt!=null) {
			
		pstmt.setString(1, data);
		
		resultSet = pstmt.executeQuery();
		
		}
		
		if(resultSet.next()) {
			
			System.out.println("name\t\taddress\t\tgender\t\tdob\t\t\tdoj\t\t\tdom");
			
			SimpleDateFormat resultsdf = new SimpleDateFormat("dd-MM-YYYY");
			
			System.out.println(resultSet.getString(1)+ "\t\t" + resultSet.getString(2)+ "\t\t" +resultSet.getString(3)+ "\t\t" 
					
					+ resultsdf.format( resultSet.getDate(4))+ "\t\t" + resultsdf.format( resultSet.getDate(5))+ "\t\t"+ resultsdf.format( resultSet.getDate(6)));
		}
		
		}
		
		}
		
		catch(SQLException se) {
			
			se.printStackTrace();
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		finally {
		
			ConnectionWithMysql.closeConnection(null, pstmt, connection);
		}
	}
	
}
		
	


