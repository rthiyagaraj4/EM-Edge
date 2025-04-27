package eXH.util;

import java.sql.SQLException;
import java.sql.Connection;

public class EMDataSource {
	
	/*

	static JdbcConnectionPool pool = new JdbcConnectionPool();

	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection connection = pool.getConnectionFromPool();
		return connection;
	}

	public static void returnConnection(Connection connection) {
		pool.returnConnectionToPool(connection);
	}
	
	*/
	
	

    //Only for Startup JDBC Servlet
    public static Connection getConnection(){
        Connection con = null;
        try{
            con = ServiceLocator.getInstance().getConnection();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }

    public static void returnConnection(Connection con){
        try{
			ServiceLocator.getInstance().returnConnection(con); 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /******************************************************************************/
  //Only for Startup JDBC Servlet
    public static Connection getConnection(String facilityId){
        Connection con = null;
        try{
            con = ServiceLocator.getInstance().getConnection(facilityId);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
    /******************************************************************************/
    
	
	
}
