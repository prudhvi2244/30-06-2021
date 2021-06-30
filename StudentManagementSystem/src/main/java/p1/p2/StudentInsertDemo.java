package p1.p2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentInsertDemo {
	private static PreparedStatement ps;

	public Integer saveStudent(Integer sid, String sname, String scity) {
		int result = 0;
		Connection con = JdbcConnection.getConnection();
		System.out.println("Connection Established");

		String insertQuery = "insert into student(sid,sname,scity) values(?,?,?)";
		if (con != null) {
			try {
				ps = con.prepareStatement(insertQuery);
				ps.setInt(1, sid);
				ps.setString(2, sname);
				ps.setString(3, scity);
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
		System.out.print("Enter Student Name:");
		String sname = sc.next();
		System.out.print("Enter Student City:");
		String scity = sc.next();

		int result = new StudentInsertDemo().saveStudent(sid, sname, scity);
		if (result == 1) {
			System.out.println("Student With ID :" + sid + " Saved Successfully!");
		} else {
			System.out.println("Failed To Save Student Record!");
		}

	}

}
