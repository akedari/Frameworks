package edu.kedari.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.kedari.model.Circle;

public class JdbcDaoImpl {


	public Circle getCircle(int cirId) {
		
		Connection conn = null;
		String driver = "org.apache.derby.jdbc.ClientDriver";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/mydb");
			PreparedStatement ps = conn.prepareStatement("select * from Circle where id=?");
			ps.setInt(1,cirId);
			
			Circle circle = null;
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				circle = new Circle(cirId, rs.getString("name"));
			}
			rs.close();
			ps.close();
			return circle;
			
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
