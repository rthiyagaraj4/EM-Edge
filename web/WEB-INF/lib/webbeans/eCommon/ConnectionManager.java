/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eCommon;

import javax.naming.*;
import javax.rmi.*;
import javax.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.rmi.*;
import java.util.*;
import java.sql.*;

import com.ehis.eslp.*;

public class ConnectionManager{

    //Method to get DB connection
    //To be called from servlets/JSP
    public static Connection getConnection(HttpServletRequest request){
        Connection con = null;
        try{
            con = ServiceLocator.getInstance().getConnection(request);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }

	public static Connection getConnectionOGG(HttpServletRequest request){
        Connection con = null;
        try{
            con = ServiceLocator.getInstance().getConnectionOGG(request);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }

    //Method to get DB connection
    //To be called from EJB
    public static Connection getConnection(Properties props){
        Connection con = null;
        try{
			con = ServiceLocator.getInstance().getConnection(props);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }

    //Method to close a DB connection
    //To be called from servlets/JSP
    public static void returnConnection(Connection con,HttpServletRequest request){
      try{
         ServiceLocator.getInstance().returnConnection(con,request);
      }catch(Exception e){
          e.printStackTrace();
      }
    }

    //Method to close DB connection
    //To be called from EJB
    public static void returnConnection(Connection con,Properties props){
        try{
            ServiceLocator.getInstance().returnConnection(con,props);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

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

}
