package dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudUsingPreparedStatement extends ConnectionWithMysql {

	public static void main(String[] args)throws SQLException {
		
		ResultSet resultSet = null;
		PreparedStatement pstmt= null;
		Connection connection = null;
		
		Scanner scan = new Scanner(System.in);
		
		int option = 0;
		
		try {
		
		connection = ConnectionWithMysql.getConnection();		
		
		System.out.println("Press 1 or 2 or 3 or 4 to perform any of the below operation in student table"
				                +"\n1.insert data\n"
				                +"2.read data\n"
								+"3.update data\n"
				                +"4.delete data");
		
		option = scan.nextInt();
		
		//insert
		
		if(option==1) {
		
			System.out.println("Enter the student id");
			
			int id = scan.nextInt();
			
			System.out.println("Enter the student name");
			
			String name = scan.next();
			
			System.out.println("Enter the student marks");
			
			int marks = scan.nextInt();
			
			String sqlQuery = "insert into student(stud_id,stud_name,marks) values(?,?,?)";
			
			if(connection!=null) {
			
			pstmt= connection.prepareStatement(sqlQuery);	
			
			}
			
			if(pstmt!=null) {
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, marks);
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + " row affected");
			}
		}
		
		//read
		
		else if(option==2) {
			
			String sqlQuery = "select stud_id,stud_name,marks from student where stud_id=?";
			
			if(connection!=null) {
				
				pstmt = connection.prepareStatement(sqlQuery);
			}		
			
			if(pstmt!=null) {
				
			System.out.println("Enter the student id");
				
			int id = scan.nextInt();
			
			pstmt.setInt(1,id);
			resultSet = pstmt.executeQuery();
			
			}		
			
			if(resultSet!=null) {
				
				System.out.println("stud_id\t"+"\tstud_name\t"+"marks");
				
				while(resultSet.next()) {
					
					System.out.println(resultSet.getInt(1)+"\t"+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getInt(3));
				}
			}			
		}
		
		//update
		
		else if(option==3) {
			
			System.out.println("Enter the student id to update");
			
			int id = scan.nextInt();
			
			System.out.println("Enter the mark to update");
			
			int marks = scan.nextInt();
			
			String sqlQuery = "update student set marks=? where stud_id=?";
			
			if(connection!=null) {
			
			pstmt = connection.prepareStatement(sqlQuery);
			
			}
			
			if(pstmt!=null) {
				
				pstmt.setInt(1, marks);
				pstmt.setInt(2, id);
				
				int result = pstmt.executeUpdate();
				
				System.out.println(result + " row affected");
			}			
		}
		
		//delete
		
		else if(option==4){
			
			System.out.println("Enter the student id to delete");
			
			int id = scan.nextInt();
			
			String sqlQuery = "delete from student where stud_id=?";
			
			if(connection!=null) {
			
			pstmt = connection.prepareStatement(sqlQuery);
			
			}
			
			if(pstmt!=null) {
			
			pstmt.setInt(1, id);
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + " row affected");
			}
			
		}
			
		}
		
		finally {
			
			if(option==1) {
				
				ConnectionWithMysql.closeConnection(resultSet, pstmt, connection);	
			}
			
			else {
				
				ConnectionWithMysql.closeConnection(null, pstmt, connection);	
			}					
		}		
    }
	
}
