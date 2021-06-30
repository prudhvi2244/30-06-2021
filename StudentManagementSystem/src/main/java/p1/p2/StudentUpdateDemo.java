package p1.p2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentUpdateDemo {
	private static PreparedStatement ps;
	public Integer updateStudent(Integer sid, String scity) {
		int result = 0;
		Connection con = JdbcConnection.getConnection();
		System.out.println("Connection Established");

		String updateQuery = "update student set scity=? where sid=?";
		if (con != null) {
			try {
				ps = con.prepareStatement(updateQuery);
				ps.setString(1,scity);
				ps.setInt(2,sid);
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
				System.out.print("Enter Student City:");
		String scity = sc.next();

		int result = new StudentUpdateDemo().updateStudent(sid,scity);
		if (result == 1) {
			System.out.println("Student With ID :" + sid + " Updated Successfully!");
		} else {
			System.out.println("Failed To Update Student Record!");
		}
	}

}
