package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConUtil {
	
	public static void main(String[] args) {
		
		getConnect();
	}

	public static void getConnect() {
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/test";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载驱动
			
			System.out.println("驱动加载成功");
			
			conn = DriverManager.getConnection(url,"root","root");//建立连接
			
			System.out.println(conn.getClass().getName());
			
			Statement sment = conn.createStatement();//创建语句
			
			String sql = "insert into demo(user_name)" + "value('Aslan')";//写SQL
			
			int i = sment.executeUpdate(sql);//执行SQL
			
			if(i > 0){
				
				System.out.println("数据插入成功");
				
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
			throw new RuntimeException("驱动加载失败");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			throw new RuntimeException("创建连接失败");
			
		}finally{
			
			if (conn != null) {
				
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	

}
