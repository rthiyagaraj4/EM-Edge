/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.ehis.eslp;

import java.util.*;
import java.text.*;
import java.lang.reflect.*;
import java.io.*;
import javax.naming.*;
import javax.ejb.*;
import javax.rmi.*;
import javax.sql.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 * Main Class implementing the Enhanced Service Locator J2EE Pattern
 * Implements the ServiceVerifiable and ServletContextListener interfaces
 */
public class ServiceLocator implements ServiceVerifiable {
    /**
     * Static member, for a singleton design pattern
     */
    private static ServiceLocator me;
    /**
     * Map object caching the J2EE Service Components
     */
    private static Map cache;
    /**
     * InitialContext object used to lookup DataSources and EJBHome Objects
     */
    private static InitialContext context = null;
    /**
     * ServiceLocatorVerifier Thread, used to check for cached objects which expire, due to various potential problems
     */
    private static ServiceLocatorVerifier serviceLocatorVerifier;
    
    /**
     * Frequency at which the SERviceLocatorVerifier thread should be run
     */
    private static	int _verificationFrequency_Minutes = 2;
    /**
     * Flag to enable / disable debugging
     * If set LOG4J will be configured and all events will be logged
     */
    private static boolean debug = false;

    /**
     * User name for accessing the JNDI.
     * Will be used if configured in the web.xml as a context parameter
     */
    private static String INITIALCONTEXT_PRINCIPAL = "";
    /**
     * Password for accessing the JNDI.
     * Will be used if configured in the web.xml as a context parameter
     */
    private static String INITIALCONTEXT_CREDENTIALS = "";
    /**
     * URL for accessing the JNDI.
     * Will be used if configured in the web.xml as a context parameter
     */
    private static String INITIALCONTEXT_URL = "";
    /**
     * Context Factory Name for accessing the JNDI.
     * Will be used if configured in the web.xml as a context parameter
     */
    private static String INITIALCONTEXT_FACTORY = "";

	private static String jdbc_lookup = "jdbc/OracleDS";
	private static String jdbc_lookup_OGG = "jdbc/OracleDSMerge";
    
    /**
     * SimpleDateFormat Object to format the error messages for connection requests
     */
    private static SimpleDateFormat sdf = new SimpleDateFormat("'Connection requested from ServiceLocator at ' dd/MM/yyyy HH:mm:ss:SSS ");
    
   
    /* Private Constructor will get called  from the getInstance() method */
    /**
     * Private Constructor to facilitate the uise of a Singleton Pattern
     * Will be called by the getInstance method
     */
	  private ServiceLocator() {

		try{
            //Need to add a check if there are any parameters to be passed in to create the InitialContext
            if (!INITIALCONTEXT_PRINCIPAL.equalsIgnoreCase("") && !INITIALCONTEXT_CREDENTIALS.equalsIgnoreCase("") && !INITIALCONTEXT_FACTORY.equalsIgnoreCase("") && !INITIALCONTEXT_URL.equalsIgnoreCase("")){
                Hashtable h = new Hashtable();
                h.put("java.naming.security.principal",INITIALCONTEXT_PRINCIPAL);
                h.put("java.naming.security.credentials",INITIALCONTEXT_CREDENTIALS);
                h.put("java.naming.provider.url",INITIALCONTEXT_URL);
                h.put("java.naming.factory.initial",INITIALCONTEXT_FACTORY);
                
                //Any more J2EE Application SErver specific properties can be added here into the JNDI properties
                
                context = new InitialContext(h);
            }else{
                context  = new InitialContext();
            }
            
            //Create the Cache
            cache    = Collections.synchronizedMap(new HashMap());
            
            //Create the Verifier thread
            if (serviceLocatorVerifier == null){
				serviceLocatorVerifier =  new ServiceLocatorVerifier( _verificationFrequency_Minutes,this);								

            }
        }catch(Exception exception){
			exception.printStackTrace();
        }
    }
    
    /**
     * Method to return the ServiceLocator, as a Singleton
     * @return ServiceLocator Object
     */
    public static ServiceLocator getInstance() {
		if(me == null){
			me = new ServiceLocator();
        }
		return me;
    }
    
    /**
     * Method to lookup the specified location in the JNDI and typecast it to the given HomeClassName
     * @return EJBHome object
     * @param jndiHomeName Location of the Object in JNDI
     * @param className HomeClass Name
     * @throws ServiceLocatorException Exception thrown in the case of the occurrance of an error
     */
    public Object getHome(String jndiHomeName, Class homeClassName,boolean local)  throws ServiceLocatorException {
		Object home = null;
        try {
            if (cache.containsKey(jndiHomeName)) {
                //Object found in the cache
                home = cache.get(jndiHomeName);                
            }else{
                //Object not found in the cache, now before handing it over to the client cache it
                Object objref = context.lookup(jndiHomeName);				
				if (local)	home = (EJBLocalHome) objref;
                else home = (EJBHome) objref;
				cache.put(jndiHomeName, home);               
            }
        }catch (NamingException ne) {
             ne.printStackTrace();
			 followError(ne);
            throw new ServiceLocatorException(ne);
        }catch (Exception e) {
            e.printStackTrace();
			 followError(e);
            throw new ServiceLocatorException(e);
        }
        return home;
    }

    
    /**
     * Method to lookup the DataSource in the JNDI
     * @return The DataSource object if found in the specified location in the JNDI
     * @param jndiHomeName Location of the DataSource Object in the JNDI
     * @throws ServiceLocatorException Exception thrown in the case of the occurrance of an error
     */
    public DataSource getDataSource(String jndiHomeName)  throws ServiceLocatorException {
		DataSource ds = null;
        try {
            if (cache.containsKey(jndiHomeName)) {
                //DataSource object found in the cache
                ds = (DataSource) cache.get(jndiHomeName);                
            }else{
                //DataSource not found in the cache, cache it before returning it to the client
                ds = (DataSource)context.lookup(jndiHomeName);
                cache.put(jndiHomeName, ds);                
            }
        } catch (NamingException ne) {
            followError(ne);
            ne.printStackTrace();
            throw new ServiceLocatorException(ne);
        } catch (Exception e) {
            followError(e);
			e.printStackTrace();            
            throw new ServiceLocatorException(e);
        }
        return ds;
    }
    
    /**
     * Implementing the checkServices function of ServiceVerifiable
     * Application Specific code to check the cached service objects
     * @throws Exception Exception thrown in the case of the occurrance of an error
     */
    public void checkServices() throws Exception{
        //Call the thread for verifying the cache
        if (serviceLocatorVerifier == null){
            serviceLocatorVerifier =
            new ServiceLocatorVerifier( _verificationFrequency_Minutes,this);
        }else{
            try{
                //Add the code to check the map elements
				synchronized(cache){
					for (Iterator iter = cache.entrySet().iterator(); iter.hasNext();){
						Map.Entry element = (Map.Entry) iter.next();
						if(element.getValue() == null || element.getValue().equals("")){
							followError(new Exception());
						}else {                        
							validateObj(element.getValue());
						}
					}
				}
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * Implementing the followError function of ServiceVerifiable
     * Error callback function, if one encountered in the case of checkign teh cached services
     * @param ex Exception thrown in the case of the occurrance of an error
     */
    public void followError(Exception ex){
        cache.clear();
    }
   
	/**
     * Method to validate the Cached objects
     * @param obj Object to be validated
     */
    public void validateObj(Object obj){
	    //Commenting due to performance issues 12:12 PM 3/20/2010
		/*
        if(obj instanceof EJBHome){
            //Object under question is an EJBHome Object, validate it
            try{
                EJBMetaData objMetaData = ((EJBHome)obj).getEJBMetaData();
                if(null == objMetaData.getHomeInterfaceClass() || null == objMetaData.getRemoteInterfaceClass()) throw new ServiceLocatorException("Invalid Remote or Home object");                
            }catch(Exception ex){
                ex.printStackTrace();
                followError(ex);
            }
        }else if(obj instanceof DataSource){
            //Object under question is a DataSource Object, validate it
            try{
                Connection connection = ((DataSource)obj).getConnection();
                PreparedStatement pstmt = connection.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS') FROM DUAL");
                ResultSet rs = pstmt.executeQuery();
                if((rs.next())&&(rs.getString(1) != null));
                else followError(new Exception());
                rs.close();
                pstmt.close();
                connection.close();
            }catch(SQLException ex){
                followError(ex);
            }catch(Exception ex){
                followError(ex);
            }
        }*/
    }
    
    /**
     * Request a database connection
     * Method specefic to JSPs and Servlets
     * @param httpservletrequest The HttpServletRequest object
     * @return Database Connection Object
     */
    public Connection getConnection(HttpServletRequest httpservletrequest){
        Connection connection = null;
        try {
            
			/* Commented by ChandraSekhar on 10/27/2006
			HttpSession httpsession = httpservletrequest.getSession(false);
            if(httpsession != null) {
                String s = (String)httpsession.getValue("connection_pooling_yn");
                if((s != null) && (s.equalsIgnoreCase("Y"))){
                    DataSource datasource = me.getDataSource(jdbc_lookup);
                    connection = datasource.getConnection();
                    connection.setAutoCommit(false);
                } else{
                    connection = (Connection)httpsession.getValue("connection");
                    if (connection != null)connection.setAutoCommit(false);
                }                
                //get the stacktrace where the connection was requested
                //throw new ConnectionGetException(sdf.format(new java.util.Date()));
            }
			*/

			DataSource datasource = me.getDataSource(jdbc_lookup);
            connection = datasource.getConnection();
            connection.setAutoCommit(false);

        }catch(Exception exception){
           exception.printStackTrace();
        }
        return connection;
    }
    

	 public Connection getConnectionOGG(HttpServletRequest httpservletrequest){
        Connection connection = null;
        try {
            
			/* Commented by ChandraSekhar on 10/27/2006
			HttpSession httpsession = httpservletrequest.getSession(false);
            if(httpsession != null) {
                String s = (String)httpsession.getValue("connection_pooling_yn");
                if((s != null) && (s.equalsIgnoreCase("Y"))){
                    DataSource datasource = me.getDataSource(jdbc_lookup);
                    connection = datasource.getConnection();
                    connection.setAutoCommit(false);
                } else{
                    connection = (Connection)httpsession.getValue("connection");
                    if (connection != null)connection.setAutoCommit(false);
                }                
                //get the stacktrace where the connection was requested
                //throw new ConnectionGetException(sdf.format(new java.util.Date()));
            }
			*/

			DataSource datasourceOGG = me.getDataSource(jdbc_lookup_OGG);
            connection = datasourceOGG.getConnection();
            connection.setAutoCommit(false);

        }catch(Exception exception){
           exception.printStackTrace();
        }
        return connection;
    }
    
    /**
     * Request a database connection
     * Method specific to EJBs
     * @param properties JDBC properties object containing the necessary connection patrameters
     * @return Database Connection Object
     */
    //Removed Synchronization on the method -- by Chandra 11/04/2003
    public Connection getConnection(Properties properties){
        Connection connection = null;
        try{
            /* Commented by ChandraSekhar on 10/27/2006
			String s = properties.getProperty("connection_pooling_yn");
            if(s.equalsIgnoreCase("Y")){
                DataSource datasource = me.getDataSource(jdbc_lookup);
                connection = datasource.getConnection();
                connection.setAutoCommit(false);
            } else{
                String s1 = properties.getProperty("jdbc_driver");
                String s2 = properties.getProperty("jdbc_dns");
                String s3 = properties.getProperty("db_user");
                String s4 = properties.getProperty("db_passwd");
                Class.forName(s1);
                connection = DriverManager.getConnection(s2, s3, s4);
                connection.setAutoCommit(false);
            }
			*/
            
			DataSource datasource = me.getDataSource(jdbc_lookup);
            connection = datasource.getConnection();
            connection.setAutoCommit(false);

            //get the stacktrace where the connection was requested
            //throw new ConnectionGetException(sdf.format(new java.util.Date()));
            
        }catch(Exception exception){
			exception.printStackTrace();            
        }
        return connection;
    }
    
    
    /**
     * Request a database connection
     * Method specific to Test Classes.
     * **** Should not be called by EJB/Servlet/JSP ****
     * @return Database Connection Object
     */
    //Removed Synchronization on the method -- by Chandra 11/04/2003
    public Connection getConnection(){
        Connection connection = null;
        try{
            DataSource datasource = me.getDataSource(jdbc_lookup);
            connection = datasource.getConnection();
            connection.setAutoCommit(false);
            
            //get the stacktrace where the connection was requested
            //throw new ConnectionGetException(sdf.format(new java.util.Date()));
            
        }catch(Exception exception){
			  exception.printStackTrace();      
        }
        return connection;
    }
    
    //Removed Synchronization on the method -- by Chandra 11/04/2003
    /**
     * Method to be called by Servlets / JSPs
     * Return the Connection to the Pool, or close it if necessary
     * @param connection Connection to be returned / closed
     * @param httpservletrequest HttpServletRequest to check if ConnectionPooling is set to TRUE or FALSE
     */
    public void returnConnection(Connection connection, HttpServletRequest httpservletrequest){
        try{
            /* Commented by ChandraSekhar on 10/27/2006
			HttpSession httpsession = httpservletrequest.getSession(false);
            if(httpsession != null){
                String s = (String)httpsession.getValue("connection_pooling_yn");
                if(s.equalsIgnoreCase("Y"))
                    
                    //Added condition to check if the connection is not null, only then close -- by Chandra 11/04/2003
                    if(connection != null)connection.close();
                //End
            }*/
			
			if(connection != null)connection.close();

        }catch(Exception exception){
           exception.printStackTrace();
        }
    }
    
    //Removed Synchronization on the method -- by Chandra 11/04/2003
    /**
     * Method to be called by EJBs
     * Return the Connection to the Pool, or close it if necessary
     * @param connection Connection to be returned / closed
     * @param properties JDBC properties to check if ConnectionPooling is set to TRUE or FALSE
     */
    public void returnConnection(Connection connection, Properties properties) {
        try{
            
            //Added condition to check if the connection is not null, only then close -- by Chandra 11/04/2003
            if(connection != null)connection.close();
            //End
            
        }catch(Exception exception){
           exception.printStackTrace();
        }
    }
    
    
    //Removed Synchronization on the method -- by Chandra 11/04/2003
    /**
     * Method to be called by Test Classes
     * Return the Connection to the Pool, or close it if necessary
     * **** Should not be called by EJB/Servlet/JSP ****
     * @param connection Connection to be returned / closed
     */
    public  void returnConnection(Connection connection){
        try{
            
            //Added condition to check if the connection is not null, only then close -- by Chandra 11/04/2003
            if(connection != null)connection.close();
            //End
            
        }catch(Exception exception){
           exception.printStackTrace();
        }
    }
    
    /**
     * Method to get the Stack Trace
     * @param t Throwable Object, whose stack trace need to be collected
     * @return Stack Trace as a string
     */
    public static String getStackTrace(Throwable t){
        String ret = null;
        
        try{
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.flush();
            ret = sw.toString();
            sw.close();
            pw.close();
        }catch(IOException exc){
            exc.printStackTrace();
        }
        return ret;
        
    }
    
    
    /**
     * Method which returns the debug flag
     * @return true/false based on whether debug flag is set
     */
    boolean getDebug(){
        return this.debug;
    }
}
