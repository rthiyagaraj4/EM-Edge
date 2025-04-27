/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXB;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
/**
 * The XBDatabaseQuery  is used to get the Results of any Query.
 *  It used the QueryContext implementation. Before calling this
 *  method, the QueryContext has to be created to define the type
 *  of SQL Query
 *
 */

public class XBDatabaseQuery
{
/**
 * The XBDatabaseQuery is used to get the Results of SQL Query.
 *  HashMap has the QueryContext.
 *  And Oracle Connection for the Database query.
 *  Returns the Hashmap conntaining array list of all the 
 *  Queried data
 */

public HashMap getResults(HttpServletRequest request,HttpSession session,Connection conn)
{
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ResultSetMetaData resultSetMetaData	= null;

		HashMap hashmp = new HashMap();
		int max_records = 7 ;		
		int start = 0,end = 0;
		int intFetchedRecords = 0;

		try
		{
         
		 XBQueryContext qryContext = (XBQueryContext) session.getAttribute(XBQueryRender.qryContxt);
         String sql = qryContext.getSQLSearch();
		 System.out.println("XBDatabaseQuery sql : "+sql);
	     start = qryContext.getPreviousSet();
	     end = qryContext.getNextSet();
	     max_records = qryContext.getMaxRecord();
	     System.out.println("XBDatabaseQuery.java max_records : "+max_records);
	     int byteColumns = (int)qryContext.getNoOfColumns();
 			System.out.println("XBDatabaseQuery 56 Cols : "+byteColumns);
	     ArrayList arrRow = new ArrayList();
         ArrayList arrColumns = new ArrayList();
         try
         {
    	   if (start<=0)
  		   {
      		   start = 0;
           }
           
		   int intTempStart = start;             													
           pstmt = conn.prepareStatement(sql);   

		   rs = pstmt.executeQuery();
 		   resultSetMetaData	=	rs.getMetaData();
//			System.out.println("XBDatabaseQuery 75 ");

		   while(rs.next())
      	   {
//			System.out.println("XBDatabaseQuery 79 ");

			if (!(intTempStart<=0))
            {
			  --intTempStart;
              continue;
            }

	        for (int l=0;l<byteColumns;l++)
			{
				int iColumnType=	resultSetMetaData.getColumnType(l+1);
//				System.out.println("iColumnType : "+iColumnType);
				
				switch (iColumnType){

				case Types.CLOB:
					Clob clobData= rs.getClob(resultSetMetaData.getColumnName(l+1));
					StringBuffer sbClobData	= new StringBuffer();
					if(clobData!=null)
						sbClobData.append(clobData.getSubString(1,(int)clobData.length()));
//						System.out.println("Clob Val 97 : "+sbClobData.toString());
						arrColumns.add(sbClobData.toString()+"");
					break;
	
				default:
//					System.out.println("!Clob Val 103 : "+rs.getString(l+1));
					arrColumns.add(rs.getString(l+1)+"");
				}
           }
		   arrRow.add(arrColumns);
		   arrColumns = new ArrayList();
		   arrColumns.clear();
		   ++intFetchedRecords;
           if (intFetchedRecords >= max_records)
           {
             break;
           }
        }
        
		System.out.println("intFetchedRecords : "+intFetchedRecords);
        if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
       }
      catch(Exception expSQL)
      {
         System.out.println("Error(1) in getresults method of XBdatabasequery :"+expSQL.toString());
	     expSQL.printStackTrace(System.err);
      }
	 
      hashmp.put("qry_result",arrRow);
	  hashmp.put("end",end+"");
	  hashmp.put("start",start+"");

 
      if (start>1)
      {
        hashmp.put("previous",new Boolean(true));
        
      }
      else
      {
        hashmp.put("previous",new Boolean(false));
      }
      if (intFetchedRecords>=max_records)
//      if (intFetchedRecords>max_records)
      {
        hashmp.put("next",new Boolean(true));
      }
      else
      {
        hashmp.put("next",new Boolean(false));
      }
      arrRow.clear();
      arrColumns.clear();      
      
  	}
    catch(Exception exp)
    {
      System.out.println("Error(2) in getresults method of XBdatabasequery :"+exp.toString());
	  exp.printStackTrace(System.err);
    }
	   return(hashmp);
   }
 }//end of class
	
