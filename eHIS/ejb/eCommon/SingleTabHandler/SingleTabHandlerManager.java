/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
This file has been modified by USH on 02-Feb-2005.To make it compatable with V3
Following are the changes.
1.HashTable to HashMap conversion
2.String to StringBuffer whereever necessary
3.Removal of throws clause
4.Introduction of LocalHome and Local interfaces

*/
package eCommon.SingleTabHandler;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.*;
import javax.ejb.CreateException;
import javax.ejb.*;
import javax.naming.*;
import javax.sql.*;

import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="SingleTabHandler"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="SingleTabHandler"
*	local-jndi-name="SingleTabHandler"
*	impl-class-name="eCommon.SingleTabHandler.SingleTabHandlerManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCommon.SingleTabHandler.SingleTabHandlerManagerLocal"
*	remote-class="eCommon.SingleTabHandler.SingleTabHandlerManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCommon.SingleTabHandler.SingleTabHandlerManagerLocalHome"
*	remote-class="eCommon.SingleTabHandler.SingleTabHandlerManagerHome"
*	generate= "local,remote"
*
*
*/

public class SingleTabHandlerManager
    implements javax.ejb.SessionBean
{


    public SingleTabHandlerManager()
    {
    }

    public void ejbCreate() //throws java.rmi.RemoteException, javax.ejb.CreateException
    {
    }

    public void ejbRemove()
    {
    }

    public void ejbActivate()
    {
    }

    public void ejbPassivate()
    {
    }

    public void setSessionContext(javax.ejb.SessionContext sessioncontext)
    {
        ctx = sessioncontext;
    }
	/**
	 *Method to insert single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data 
	 *@param as data for duplication check
	 *@param s Table Name
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public java.util.HashMap insert(java.util.Properties properties, java.util.HashMap hashMap, java.lang.String as[], java.lang.String s)// throws java.rmi.RemoteException
    {
        java.util.HashMap hashMap1 = new HashMap();
        boolean flag = false;
        try
        {
            
			java.util.Set mapSet = (java.util.Set) hashMap.keySet();

			//Added by kumar on 28/11/2002 For Added Date and Modified Date 
			java.util.Set mapSetForDate = (java.util.Set) hashMap.keySet();
			//End 
            java.lang.String s1 = "";
            sb = new StringBuffer("");
			con=ConnectionManager.getConnection(properties);
		
			
			//For orion
			//Context context = new InitialContext();
            
            int i = 0;
            boolean flag1 = true;
           
			// Added By USH
			Iterator mapIter = mapSet.iterator();
			Iterator mapIterForDate = mapSetForDate.iterator();
			while(mapIter.hasNext()){
				 s1 = s1 + (java.lang.String)mapIter.next()+ ",";
				 i++;
			}

            java.lang.Object aobj[] = new java.lang.Object[i];
			mapSet = (java.util.Set) hashMap.keySet();
			mapIter = mapSet.iterator();

            if(as.length > 0 && as != null)
            {
                java.lang.Object aobj1[] = new java.lang.Object[as.length];
                for(int j = 0; j < as.length; j++)
                    aobj1[j] = hashMap.get(as[j]);

                java.lang.String s7 = "select * from  " + s + " where ";
                for(int i1 = 0; i1 < as.length; i1++)
                    s7 = s7 + as[i1] + "=? and ";

                s7 = s7.substring(0, s7.lastIndexOf("and") - 1);
                stmt = con.prepareStatement(s7);
                stmt = setData(stmt, aobj1);
                java.sql.ResultSet resultset = stmt.executeQuery();
                if(resultset.next())
                {
                    flag1 = false;
                    java.util.Hashtable hashtable5 = MessageManager.getMessage(properties.getProperty("LOCALE"),"CODE_ALREADY_EXISTS","Common");
                    sb.append((java.lang.String)hashtable5.get("message"));
					hashtable5.clear();
                } else
                {
                    flag1 = true;
                }
				if(resultset !=null) resultset.close();
            }
            if(flag1)
            {
                s1 = s1.substring(0, s1.length() - 1);				
                java.lang.String s6 = "insert into " + s + " (" + s1 + ") values(";
				String fieldName = "";
				//Added by kumar on 28/11/2002 For Added Date and Modified Date 
				mapSetForDate= hashMap.keySet();
				mapIterForDate = mapSetForDate.iterator();

				//End
                for(int k = 0; k < i; k++)
				{                    
					if(mapIterForDate.hasNext())
						fieldName = (String)mapIterForDate.next();

					if (fieldName.equalsIgnoreCase("added_date") || fieldName.equalsIgnoreCase("modified_date"))
						s6 = s6 + "sysdate,";
					else
						s6 = s6 + "?,";
					//End 
				}
                s6 = s6.substring(0, s6.length() - 1) + ")";	
                stmt = con.prepareStatement(s6);
				int incr = 0;
                for(int l = 0; l < i; l++)
                {
					fieldName =(java.lang.String)mapIter.next();
					//Added by kumar on 28/11/2002 Except for Added Date and Modified Date other values
					//are passed.
					if (!fieldName.equalsIgnoreCase("added_date") && !fieldName.equalsIgnoreCase("modified_date"))
					{
						aobj[incr] = hashMap.get(fieldName);
						incr++;
					}
                }
                stmt = setData(stmt, aobj);
                int j1 = stmt.executeUpdate();
                if(j1 != 0)
                {
                    flag = true;
					java.util.Hashtable hashtable4 = MessageManager.getMessage(properties.getProperty("LOCALE"),"RECORD_INSERTED","SM");
					sb.append((java.lang.String)hashtable4.get("message"));
                    con.commit();
                    stmt.close();
					hashtable4.clear();
                }
            }			
        }catch(java.lang.Exception exception){
            try
            {
                con.rollback();
            }
            catch(java.lang.Exception exception1) { }
            exception.printStackTrace();
            sb.append(exception.getMessage() + "<br>");
        }
        finally
        {
            try
            {
				 if(stmt!= null) stmt.close(); //Added by kamatchi for Checkstyle
				 if(con != null)      ConnectionManager.returnConnection(con,properties);
            }
            catch(java.lang.Exception exception1) { }
        }
        hashMap1.put("returndata", hashMap);
        hashMap1.put("status", new Boolean(flag));
        hashMap1.put("error", sb.toString());
        return hashMap1;
    }
	/**
	  * Method to update single record
	  * @param properties Connection Properties
	  * @paramhashaMap Record data 
	  * @s Table Name
	  * @return HashMap holding the transaction details
	  */
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public java.util.HashMap update(java.util.Properties properties, java.util.HashMap hashMap, java.util.HashMap hashMap1, java.lang.String s)//  throws java.rmi.RemoteException
    {
        java.util.HashMap hashMap2 = new HashMap();
        boolean flag = false;
        //boolean flag1 = true;
        int i = 0;
        try
        {
			java.util.Set mapSet = (java.util.Set) hashMap.keySet();
			java.util.Set mapSet1 = (java.util.Set) hashMap1.keySet();


            java.lang.String s1 = "";
            sb = new StringBuffer("");
		    con= ConnectionManager.getConnection(properties);
			//For orion
			//Context context = new InitialContext();

            int j = 0;
           // boolean flag2 = false;
            java.lang.String s6 = "update  " + s + "  set ";
			String fieldName = "";
           Iterator mapIter = mapSet.iterator();
		   Iterator mapIter1 = mapSet1.iterator();
		   

			while(mapIter.hasNext()){
				 fieldName = (java.lang.String)mapIter.next();
				//Added by kumar on 29/11/2002 to assign system date for column Modified Date
				if (fieldName.equalsIgnoreCase("modified_date"))
					s1 = s1 + fieldName + "=sysdate,";
				else
				{
					s1 = s1 + fieldName + "=?,";
		            j++;
				}
			}
			mapIter = mapSet.iterator();


            s1 = s1.substring(0, s1.length() - 1);
            s6 = s6 + s1;
            if(hashMap1.size() > 0)
            {
                s6 = s6 + " where ";
                while(mapIter1.hasNext()) 
                {
                    java.lang.String s7 = (java.lang.String)mapIter1.next();
                    s6 = s6 + s7 + "=? and ";
                    i++;
                }
                s6 = s6.substring(0, s6.lastIndexOf("and") - 1);
            }
			mapIter1 = mapSet1.iterator();


            java.lang.Object aobj[] = new java.lang.Object[j + i];			
            //System.out.println("s6 : " + s6);
			stmt = con.prepareStatement(s6);
            int k;			
			int incr=0;
            for(k = 0; mapIter.hasNext(); k++)
			{
                //Added by kumar on 29/11/2002 except for Modified Date other values are passed.
				fieldName = (String) mapIter.next();
				if (!fieldName.equalsIgnoreCase("modified_date"))
				{
					aobj[incr] = hashMap.get(fieldName);
					incr++;
				}
			}

            while(mapIter1.hasNext()) 
            {
                aobj[incr] = hashMap1.get(mapIter1.next());
                incr++;
            }
            stmt = setData(stmt, aobj);
            int l = stmt.executeUpdate();
            if(l != 0)
            {
                flag = true;
				java.util.Hashtable hashtable4 = MessageManager.getMessage(properties.getProperty("LOCALE"), "RECORD_MODIFIED","SM");
                sb.append((java.lang.String)hashtable4.get("message"));
				hashtable4.clear();
                con.commit();
            }
            stmt.close();			
        }
        catch(java.lang.Exception exception)
        {
            try
            {
                con.rollback();
            }
            catch(java.lang.Exception exception1) { }
            exception.printStackTrace();
            sb.append(exception.getMessage() + "<br>");
        }
        finally
        {
            try
            {
				if(con != null)      ConnectionManager.returnConnection(con,properties);
            }
            catch(java.lang.Exception exception1) { }
        }
        hashMap2.put("status", new Boolean(flag));
        hashMap2.put("error", sb.toString());
        return hashMap2;
    }

/**
  * @param preparedstatement  PreparedStatement object to fill it's placeholders
  * @param aobj	Array of data
  * @return PreparedStatement with filled placeholders
  */
    private java.sql.PreparedStatement setData(java.sql.PreparedStatement preparedstatement, java.lang.Object aobj[])
    {
        try
        {

            for(int i = 0; i < aobj.length; i++)
            {
                if(aobj[i] instanceof java.sql.Date)
                {
                    java.sql.Date date = (java.sql.Date)aobj[i];
                    java.util.Calendar calendar = java.util.Calendar.getInstance();
                    java.sql.Date date1 = new Date(java.util.Date.parse(date.toLocaleString()) + (long)(calendar.get(15) * 2));
                    preparedstatement.setDate(i + 1, date1);
                }
                if(aobj[i] instanceof java.sql.Timestamp)
                {
                    java.sql.Timestamp timestamp = (java.sql.Timestamp)aobj[i];
                    preparedstatement.setTimestamp(i + 1, timestamp);
                }
                if(aobj[i] instanceof java.lang.String)
                    if(((java.lang.String)aobj[i]).equalsIgnoreCase("null"))
                        preparedstatement.setString(i + 1, null);
                    else
                        preparedstatement.setString(i + 1, (java.lang.String)aobj[i]);
                if(aobj[i] instanceof java.lang.Integer)
                    preparedstatement.setInt(i + 1, ((java.lang.Integer)aobj[i]).intValue());
                if(aobj[i] instanceof java.lang.Long)
                    preparedstatement.setLong(i + 1, ((java.lang.Long)aobj[i]).longValue());
                if(aobj[i] instanceof java.lang.Double)
                    preparedstatement.setDouble(i + 1, ((java.lang.Double)aobj[i]).doubleValue());
                if(aobj[i] instanceof java.lang.Float)
                    preparedstatement.setFloat(i + 1, ((java.lang.Float)aobj[i]).floatValue());
            }
        }
        catch(java.lang.Exception exception)
        {
            exception.printStackTrace();
        }
        return preparedstatement;
    }

 /*
  *   @param java.util.Properties 
  *   @param java.util.HashMap
  *   @param java.lang.String
  */

  /**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public java.util.HashMap delete(java.util.Properties properties, java.util.HashMap hashMap, java.lang.String s)// throws java.rmi.RemoteException
    {
        java.util.HashMap hashMap1 = new HashMap();
        boolean flag = false;
       // boolean flag1 = true;
        try
        {
            int i = 0;
			java.util.Set mapSet = (java.util.Set) hashMap.keySet();

            sb = new StringBuffer("");
			con=ConnectionManager.getConnection(properties);
			//For orion
			//Context context = new InitialContext();

			Iterator mapIter = mapSet.iterator();

            java.lang.String s5 = "delete from " + s;
            if(hashMap.size() > 0)
            {
                s5 = s5 + " where ";
				while(mapIter.hasNext())
					{
					java.lang.String s6 = (java.lang.String)mapIter.next();
					s5 = s5 + s6 + "=? and ";
					i++;
					}
                s5 = s5.substring(0, s5.lastIndexOf("and") - 1);
			   mapSet = (java.util.Set) hashMap.keySet();
			   mapIter = mapSet.iterator();

            }
            stmt = con.prepareStatement(s5);
            if(i > 0)
            {
                int j = 0;
                java.lang.Object aobj[] = new java.lang.Object[i];
				while(mapIter.hasNext())
				{
					aobj[j] = hashMap.get(mapIter.next());
					j++;
				}
                stmt = setData(stmt, aobj);
            }
            int k = stmt.executeUpdate();
            if(k != 0)
            {
                flag = true;
				java.util.Hashtable hashtable3 = MessageManager.getMessage(properties.getProperty("LOCALE"), "RECORD_DELETED","SM");
                sb.append((java.lang.String)hashtable3.get("message"));
				hashtable3.clear();
                con.commit();
            }
            stmt.close();
        }
        catch(java.lang.Exception exception)
        {
            try
            {
                con.rollback();
            }
            catch(java.lang.Exception exception1) { }
            sb.append(exception.getMessage() + "<br>");
            exception.printStackTrace();
        }
        finally
        {
           try
            {
					 if(con != null)      ConnectionManager.returnConnection(con,properties);
            }
            catch(java.lang.Exception exception1) { }
        }
        hashMap1.put("status", new Boolean(flag));
        hashMap1.put("error", sb.toString());
        return hashMap1;
    }

    java.sql.Connection con = null;
    java.sql.PreparedStatement stmt = null;
    javax.ejb.SessionContext ctx = null;
    public final java.lang.String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS";
    public final java.lang.String RECORD_INSERTED = "RECORD_INSERTED";
    public final java.lang.String RECORD_MODIFIED = "RECORD_MODIFIED";
    public final java.lang.String RECORD_DELETED = "RECORD_DELETED";
    java.lang.StringBuffer sb = null;
}
