/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import eXH.XHDBAdapter;

/*
 * This class is used to get the results of the SQL query 
 * This uses the QueryContext and the ConnectionFactory for the 
 * database connection
 */

public class XHSelectQuery
{
	
/**
  * GetResults method which returns the resultset values depanding the query passed
  * @param  HashMap hashmp 
  */	

public ArrayList getResults(HashMap hashmp)
{
	PreparedStatement pstmt= null;
	Connection conn = null;
	ArrayList arrRow  = new ArrayList();
	ArrayList arrColumns = null;
	ResultSet rset = null;
    
	try
	{
		conn = (Connection)hashmp.get("connection");		
		String sql = (String)hashmp.get("sql");	
		int col = Integer.parseInt((String)hashmp.get("col"));
	
		pstmt= conn.prepareStatement(sql);
		rset = pstmt.executeQuery();
		
		while(rset.next())
		{
		   arrColumns = new ArrayList(col); 
		   for(int i=0;i<col;i++)
		   {
                 
			 arrColumns.add(rset.getString(i+1)+"");
		   }
		   arrRow.add(arrColumns);
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception exp)
	{
		System.out.println("Error in getresults method of xhselectquery :"+exp.toString()); 
		exp.printStackTrace(System.err);
	}
	finally {
		//pstmt.close(); 
		//resultSet.close();	
		XHUtil.closeDBResources(rset, pstmt, conn);

	}
   return(arrRow);
  }
}
// end of class 
