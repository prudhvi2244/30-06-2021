package p1.p2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllStudents {


	private PreparedStatement ps;
	private static ResultSet rs;
	public ResultSet selectAllStudents() {
		int result = 0;
		Connection con = JdbcConnection.getConnection();
		System.out.println("Connection Established");
		String selectQuery="select * from student";
		
		try {
			ps=con.prepareStatement(selectQuery);
			rs=ps.executeQuery();
		
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return rs;
	}
	
	public static void main(String[] args) {
	
		rs=new SelectAllStudents().selectAllStudents();
		
		try {
			while(rs.next())
			{
				System.out.println("Student ID :"+rs.getString(1));
				System.out.println("Student Name :"+rs.getString(2));
				System.out.println("Student City :"+rs.getString(3));
				System.out.println("**************************");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

}
