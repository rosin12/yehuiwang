package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlJDBC {
	public  Connection  getConnection() {
		Connection con=null;
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://58.19.246.149:6005";
		String userName = "SA"; // 默认用户名
		String userPwd = "yc@2016"; // 密码
		try {
		Class.forName(driverName);
		con = DriverManager.getConnection(dbURL, userName, userPwd);
		System.out.println("Connection Successful!"); // 如果连接成功
		} catch (Exception e) {
		e.printStackTrace();
		}finally{
		//进行资源的释放
		if(con!=null){
		try {
		con.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		}
		return con;
	}
}
