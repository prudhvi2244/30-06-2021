package p1.p2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentDeleteDemo {
	
	private static PreparedStatement ps;
	public Integer deleteStudent(Integer sid) {
		int result = 0;
		Connection con = JdbcConnection.getConnection();
		System.out.println("Connection Established");

		String updateQuery = "delete from student where sid=?";
		if (con != null) {
			try {
				ps = con.prepareStatement(updateQuery);
				ps.setInt(1,sid);
				result = ps.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			}

		} else {
			System.out.println("Connection Not Established");
		}
		return result;

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome To Student Management System");

		System.out.print("Enter Student ID :");
		Integer sid = sc.nextInt();
		
		int result = new StudentDeleteDemo().deleteStudent(sid);
		if (result == 1) {
			System.out.println("Student With ID :" + sid + " Deleted Successfully!");
		} else {
			System.out.println("Failed To Deletej Student Record!");
		}
	}


}
