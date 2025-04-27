package eXH.util;

import java.util.Properties;

public class DBConfiguration {

	public String DB_USER_NAME;
	public String DB_PASSWORD ;
	public String DB_URL;
	public String DB_DRIVER;
	public Integer DB_MAX_CONNECTIONS;

	public DBConfiguration(){
		init();
	}

	private static DBConfiguration configuration = new DBConfiguration();

	public static DBConfiguration getInstance(){ 
		return configuration;
	}

	private void init(){
		
		Properties props=new Properties (); 
		
		try{  
		
	        props.load(ConnectionManager.class.getClassLoader().getResourceAsStream("./config.properties"));
	        
			//step1 load the driver class
			
	        DB_DRIVER = props.getProperty("driver");
			
			DB_URL = props.getProperty("url");
			DB_USER_NAME = props.getProperty("username");
			DB_PASSWORD = props.getProperty("password");		
			 
			DB_MAX_CONNECTIONS = new Integer(props.getProperty("NoOfConnections"));
		}
		catch(Exception e){			
			System.out.println(e.getMessage());					} 
		}     
}
