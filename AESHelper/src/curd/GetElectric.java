package curd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import util.SqlJDBC;

public class GetElectric {
	
	 public static ResultSet  executeQuery(String SQL)  
	    {    
	          try  
	  
	          {  
	        	  SqlJDBC sqljdbc=new SqlJDBC();
	           Connection con=sqljdbc.getConnection();  
	           System.out.println("---------------连接数据库成功");    
	           String sql = "SELECT PlanTypeID, PlanTypeName FROM C_PlanType ";  
	           Statement stmt = con.createStatement();  
	           ResultSet rs = stmt.executeQuery(sql);  
	              while (rs.next())  
	              { 
	                 System.out.println(rs.getString("PlanTypeID") + ", " + rs.getString("PlanTypeName")); 
	              }  
	             // rs.close();  
	             // stmt.close();   
	              return  rs;  
	          }  
	          catch(Exception e)  
	          {  
	           e.printStackTrace();  
	           System.out.print("----------------查询失败");  
	          }  
	          return null;  
	    }  
}
