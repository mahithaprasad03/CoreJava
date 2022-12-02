package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MenuToPerformDbOperations {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String url = "jdbc:mysql://localhost:3306/practicedb";
		String username = "root";
		String password = "Java@2022";
		
		try {
		
		connection = DriverManager.getConnection(url, username, password);
		
		if(connection!=null) {
			
			statement = connection.createStatement();
		}
		
		if(statement!=null) {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Press 1 or 2 or 3 or 4 to perform any of the below operation in student table"
					                +"\n1.insert data\n"
					                +"2.read data\n"
									+"3.update data\n"
					                +"4.delete data");
			
			int option = scan.nextInt();
			
			//insert
			
			if(option==1) {
			
				System.out.println("Enter the student id");
				
				int id = scan.nextInt();
				
				System.out.println("Enter the student name");
				
				String name = scan.next();
				
				System.out.println("Enter the student marks");
				
				int marks = scan.nextInt();
				
				String sqlQuery = String.format("insert into student(stud_id,stud_name,marks) values(%d,'%s',%d)",id,name,marks);
				
				int result = statement.executeUpdate(sqlQuery);		
				
				System.out.println(result + " row affected");	
				
				String sql="select stud_id,stud_name,marks from student";
				
				resultSet = statement.executeQuery(sql);
				
				if(resultSet!=null) {
					
					System.out.println("stud_id\t"+"\tstud_name\t"+"marks");
					
					while(resultSet.next()) {
						
						System.out.println(resultSet.getInt(1)+"\t"+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getInt(3));
					}
					
				}
		     }
			
			//read
			
			else if(option==2) {
				
				String sqlQuery = "select stud_id,stud_name,marks from student";
				
				resultSet = statement.executeQuery(sqlQuery);
				
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
				
				String sqlQuery = String.format("update student set marks=%d where stud_id=%d",marks,id);
				
				statement.executeUpdate(sqlQuery);
				
				String sql = "select stud_id, stud_name, marks from student";
				
				resultSet = statement.executeQuery(sql);
				
				if(resultSet!=null) {
					
					System.out.println("stud_id\t"+"\tstud_name\t"+"marks");
					
					while(resultSet.next()) {
						
						System.out.println(resultSet.getInt(1)+"\t"+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getInt(3));
					}
				}
				
			}
			
			//delete
			
			else if(option==4) {
				
				System.out.println("Enter the student id to delete");
				
				int id = scan.nextInt();
				
				String sqlQuery = String.format("delete from student where stud_id=%d",id);
				
				statement.executeUpdate(sqlQuery);
				
				String sql = "select stud_id, stud_name, marks from student";
				
				resultSet = statement.executeQuery(sql);	
				
				if(resultSet!=null) {
					
					System.out.println("stud_id\t"+"\tstud_name\t"+"marks");
					
					while(resultSet.next()) {
						
						System.out.println(resultSet.getInt(1)+"\t"+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getInt(3));
					}
				}
			}
			
			else {
				
				System.out.println("Enter the correct option by executing again");
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
			
			if(resultSet!=null) {
				
				resultSet.close();
			}
			if(statement!=null) {
				
				statement.close();
			}
			if(connection!=null) {
				
				connection.close();
			}
		}
}
	
}
