package HL7Engine.Common;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

/**
 * Class contains utility methods that can be used for various database transactions.
 * Examples for closing db resources like resultset, statemtn etc...
 *
 * Author  : Ravindranath
 * Version : 01/02/2011
 */

public class SQLUtil
{
	private SQLUtil sqlUtil = null;

	private SQLUtil()
	{		
	}	

	public static void closeResultSet(ResultSet rs)
	{
		try
		{
			if(rs != null) rs.close();
		}
		catch (Exception exp){		}
	}

	public static void closeStatement(Statement stmt)
	{
		try
		{
			if(stmt != null) stmt.close();
		}
		catch (Exception exp){		}
	}
	
	/**
	 * Static method used to close any database resource.
	 */
	public static void closeResource(ResultSet rs, Statement ps)
	{
		try
		{
			if(rs != null) rs.close();
			if(ps != null) ps.close();			
		}
		catch(Exception exp) {}										
	}
	
	/**																				  
	 * Utility method used for closing the database resources
	 */
	public static void closeDBResources(ResultSet rs, Statement stmt)
	{
		try {
			if(rs != null) rs.close();
		}
		catch(Exception exp) {
		}
		finally  {
			try {
				if(stmt != null) stmt.close();
			}
			catch(Exception exp) {
			}
		}
	}
}