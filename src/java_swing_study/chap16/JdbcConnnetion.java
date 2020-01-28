package java_swing_study.chap16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java_swing_study.chap14.exam.dto.Department;

public class JdbcConnnetion {

	private static ArrayList<Department> deptArr;

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/mysql_study?useSSL=false";
		String user = "user_mysql_study";
		String pass = "rootroot";
		String selectSql = "select deptno, deptname, floor from department";
		String insertSql = "insert into department(deptno,deptname,floor) values(?,?,?)";
		String updateSql = "update department set deptname=?, floor=? where deptno=?";
		String deleteSql = "delete from department where deptno=?";
		selectDept(url,user,pass,selectSql);
		
		insertDept(url,user,pass,insertSql);
		selectDept(url,user,pass,selectSql);
		
		updateDept(url,user,pass,updateSql);
		selectDept(url,user,pass,selectSql);
		
		deleteDept(url,user,pass,deleteSql);
		selectDept(url,user,pass,selectSql);
		
	}

	private static void deleteDept(String url, String user, String pass, String sql) {
		try(Connection conn = DriverManager.getConnection(url,user,pass);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, 5);	
			System.out.println("delete finish");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			if(e.getErrorCode()==1064) {
				JOptionPane.showMessageDialog(null, "해당 부서가 이미 존재함");
			}
			System.err.println("해당 데이터베이스가 존재하지 않거나 계정 및 비밀번호 확인 요망" + e.getErrorCode());
			e.printStackTrace();
		}
		
	}

	private static void updateDept(String url, String user, String pass, String sql) {
		try(Connection conn = DriverManager.getConnection(url,user,pass);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, "솔루션");
			pstmt.setInt(2, 11);
			pstmt.setInt(3, 5);		
			System.out.println("update");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			if(e.getErrorCode()==1064) {
				JOptionPane.showMessageDialog(null, "해당 부서가 이미 존재함");
			}
			System.err.println("해당 데이터베이스가 존재하지 않거나 계정 및 비밀번호 확인 요망" + e.getErrorCode());
			e.printStackTrace();
		}
		
	}

	private static void insertDept(String url, String user, String pass, String sql) {
		try(Connection conn = DriverManager.getConnection(url,user,pass);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, 5);
			pstmt.setString(2, "마케팅");
			pstmt.setInt(3, 30);
			System.out.println("insert");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			if(e.getErrorCode()==1064) {
				JOptionPane.showMessageDialog(null, "해당 부서가 이미 존재함");
			}
			System.err.println("해당 데이터베이스가 존재하지 않거나 계정 및 비밀번호 확인 요망" + e.getErrorCode());
			e.printStackTrace();
		}
	}

	private static void selectDept(String url, String user, String pass, String sql) {
		try(Connection conn = DriverManager.getConnection(url,user,pass);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			Class.forName("com.mysql.jdbc.Driver");
			deptArr = new ArrayList<>();
			while(rs.next()) {
				int deptNo = rs.getInt("deptno");
				String deptName = rs.getString("deptname");
				int floor = rs.getInt("floor");
				deptArr.add(new Department(deptNo,deptName,floor));
			}
			System.out.println("select");
			for(Department dept : deptArr) {
				System.out.println(dept);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("해당 드라이버를 로드 할 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("해당 데이터베이스가 존재하지 않거나 계정 및 비밀번호 확인 요망" + e.getErrorCode());
			e.printStackTrace();
		}
	}

}
