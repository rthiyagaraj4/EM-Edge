package eXH.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	public static String  l_errmsg = "";
	
	public static Connection getConnection()
	{
		Connection con=null;	
		
		String driver = "", url = "", username = "", password = "";		
		
		
		try{  
			
			System.out.println("::: Inside Connection Manager :::");
			
			l_errmsg = "";
			
			Properties props=new Properties (); 
				
	        props.load(ConnectionManager.class.getClassLoader().getResourceAsStream("./config.properties"));
	        
			//step1 load the driver class
			
			driver = props.getProperty("driver");
	
			if (driver != null) {
			    Class.forName(driver) ;
			}
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
			
			System.out.println("Driver : "+driver+" ::: DB URL : "+url+" ::: DB Username :"+username+" ::: DB Password : "+password);
		  
			//step2 create  the connection object  
			con=DriverManager.getConnection(  
					url,username,password);  
			
			DatabaseMetaData dmd = con.getMetaData();
			url = dmd.getURL();
			System.out.println("Connection Sucessfull :: "+url.substring(url.lastIndexOf("/") + 1));
			System.out.println("DataBase Connected :: "+url.substring(url.lastIndexOf("/") + 1));
			
		}
		catch(Exception e){
			l_errmsg = " Error in getting the DB Connection - "+e.getMessage();
			System.out.println(l_errmsg);
			return null;
		} 
		return con;
	}
	public static void returnConnection(Connection con)
	{
		try {
			con.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public static String getDBDetails()
	{
		
		Connection con=null;
		String response = "S";	
		
		String driver = "", url = "", username = "", password = "";
		
		try{ 
			
			System.out.println("::: Inside getDBDetails :::");
			
	        Properties props=new Properties (); 
	
	        props.load(ConnectionManager.class.getClassLoader().getResourceAsStream("./config.properties"));
	        
			//step1 load the driver class
			
			driver = props.getProperty("driver");
	
			if (driver != null) {
			    Class.forName(driver) ;
			}
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
			
			System.out.println("Driver : "+driver+" ::: DB URL : "+url+" ::: DB Username :"+username+" ::: DB Password : "+password);
		  
			//step2 create  the connection object  
			con=DriverManager.getConnection(  
					url,username,password);  
			DatabaseMetaData dmd = con.getMetaData();
			url = dmd.getURL();
			System.out.println("Connection Sucessfull :: "+url.substring(url.lastIndexOf("/") + 1));
			System.out.println("DataBase Connected :: "+url.substring(url.lastIndexOf("/") + 1));
			
			con.close();
		}
		catch(Exception e){  
		  System.out.println("Exception in getting DB details ::: Driver : "+driver+" ::: DB URL : "+url+" ::: DB Username :"+username+" ::: DB Password : "+password+" ::: Exception :"+e.getMessage());
		  response =  "E";
		}	

		return response;
	}
}
	

