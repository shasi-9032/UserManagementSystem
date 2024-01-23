package com.mainproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mainproject.model.User;

public class UserDao {
	private static String url ="jdbc:mysql://localhost:3306/mainproject";
	private static String user = "root";
	private static String pass = "root";
	private static Connection con = null;
	private static Statement st = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static String select ="select * from uservalidate";
	private static String selectUsers = "select * from user";
	private static String insert = "insert into user(name, mobile, city) values(?,?,?)";
	private static String delete = "delete from user where id =?";
	private static String selectUserById = "select * from user where id =?";
	private static String update = "update user set name=?, mobile=?, city=? where id=?";
	
	
	//Check login validation
	public static String loginValidate(String u, String p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			rs = st.executeQuery(select);
			while(rs.next()) {
				if(u.equals(rs.getString("username")) && p.equals(rs.getString("password"))) {
					return "success";
				}
			}
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;		
	}
	
	//for inserting user details
	public static void insert(User u) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(insert);
			ps.setString(1, u.getName());
			ps.setLong(2, u.getMobile());
			ps.setString(3, u.getCity());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//display all the user details
	public static ArrayList<User> display() {
		ArrayList<User> a = new ArrayList<User>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			rs = st.executeQuery(selectUsers);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				long mobile = rs.getLong("mobile");
				String city = rs.getString("city");
				User u= new User(id, name, mobile, city);
				a.add(u);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return a;
	}
	
	//delete the user details by Id
	public static void delete(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(delete);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//get user details by ID 
	public static User selectUserById(int id1) {
		User u = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(selectUserById);
			ps.setInt(1, id1);
			
			rs = ps.executeQuery();
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			long mobile = rs.getLong("mobile");
			String city = rs.getString("city");
			u = new User(id, name, mobile, city);
		}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return u;
	}

	
	//update user details
	public static void updateUser(User u) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(update);
			ps.setString(1, u.getName());
			ps.setLong(2, u.getMobile());
			ps.setString(3, u.getCity());
			ps.setInt(4, u.getId());
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
