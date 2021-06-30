package p1.p2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectSingleStudent {
	
	private PreparedStatement ps;
	private static ResultSet rs;
	
	public ResultSet selectSingleStudent(Integer sid) {
		int result = 0;
		Connection con = JdbcConnection.getConnection();
		System.out.println("Connection Established");
		String selectQuery="select * from student where sid=?";
		
		try {
			ps=con.prepareStatement(selectQuery);
			ps.setInt(1,sid);
			
			rs=ps.executeQuery();
		
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return rs;
	}
	

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Student Id :");
		int sid=sc.nextInt();
		rs=new SelectSingleStudent().selectSingleStudent(sid);
		
		try {
			if(rs.next())
			{
				System.out.println("Student ID :"+rs.getString(1));
				System.out.println("Student Name :"+rs.getString(2));
				System.out.println("Student City :"+rs.getString(3));
				System.out.println("**************************");
			}
			else
			{
				System.out.println("Student With Given Id:"+sid+" Not Available");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
