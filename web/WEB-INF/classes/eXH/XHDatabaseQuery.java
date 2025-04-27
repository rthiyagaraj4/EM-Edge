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
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import eXH.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *  The XHDatabaseQuery  is used to get the Results of any Query.
 *  It used the QueryContext implementation. Before calling this
 *  method, the QueryContext has to be created to define the type
 *  of SQL Query
 */

public class XHDatabaseQuery
{
/**
 *  The XHDatabaseQuery is used to get the Results of SQL Query.
 *  HashMap has the QueryContext.
 *  And Oracle Connection for the Database query.
 *  Returns the Hashmap conntaining array list of all the Queried data.
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
	boolean moreRecordsExist = false;
	String sql = "";

	try
	{
		XHQueryContext qryContext = (XHQueryContext) session.getAttribute(XHQueryRender.qryContxt);
		sql = qryContext.getSQLSearch();		

		start = qryContext.getPreviousSet();
		end = qryContext.getNextSet();
		max_records = qryContext.getMaxRecord();
		int byteColumns = (int)qryContext.getNoOfColumns();		

		ArrayList arrRow = new ArrayList();
		ArrayList arrColumns = new ArrayList();
		try
		{
			if(start <= 0)
			{
				start = 0;
			}

			int intTempStart = start;
			
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			resultSetMetaData =	rs.getMetaData();

			while(rs.next())
			{
				if (!(intTempStart <= 0))
				{
					--intTempStart;
					continue;
				}

				for (int l = 0; l < byteColumns; l++)
				{
					int iColumnType = resultSetMetaData.getColumnType(l+1);				

					switch (iColumnType)
					{
						case Types.CLOB:
							Clob clobData = rs.getClob(resultSetMetaData.getColumnName(l+1));
							StringBuffer sbClobData	= new StringBuffer();
							if(clobData != null)
							sbClobData.append(clobData.getSubString(1,(int)clobData.length()));						
							arrColumns.add(sbClobData.toString() + "");
							break;

						default:						
							arrColumns.add(rs.getString(l+1)+"");
					}
				}

				
				arrRow.add(arrColumns);
				arrColumns = new ArrayList();
				arrColumns.clear();
				++intFetchedRecords;

				if(max_records != 0 && intFetchedRecords >= max_records)
				{	
					if(rs.next())
					{
						moreRecordsExist = true;
					}
					break;
				}
			}			
		}
		catch(Exception expSQL)
		{
			System.out.println("Error(1) in getresults method of xhdatabasequery :"+expSQL.toString());
			System.out.println("(XHDatabaseQuery:getResults) Query: "+sql);
			expSQL.printStackTrace(System.err);
		}
		finally
		{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}

		hashmp.put("qry_result",arrRow);
		hashmp.put("end",end+"");
		hashmp.put("start",start+"");

		if (start > 1)
		{
			hashmp.put("previous",new Boolean(true));
		}
		else
		{
			hashmp.put("previous",new Boolean(false));
		}
		if ((intFetchedRecords >= max_records) && moreRecordsExist)
		{
			hashmp.put("next",new Boolean(true));
		}
		else
		{
			hashmp.put("next",new Boolean(false));
		}

	}
	catch(Exception exp)
	{
		System.out.println("XHDatabaseQuery sql : "+sql);
		exp.printStackTrace(System.err);
	}
	return(hashmp);
}

	/**
	 * Method used to get the queried results. Results will be sent in hashmap with column names as keys.
	 */
	public HashMap getResultWithColNames(HttpServletRequest request, HttpSession session, Connection conn)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData resultSetMetaData	= null;

		HashMap hashmp = new HashMap();
		int max_records = 7 ;		
		int start = 0;
		int end = 0;
		int intFetchedRecords = 0;
		boolean moreRecordsExist = false;
		String sql = "";

		try
		{
			XHQueryContext qryContext = (XHQueryContext) session.getAttribute(XHQueryRender.qryContxt);
			sql = qryContext.getSQLSearch();		

			start = qryContext.getPreviousSet();
			end = qryContext.getNextSet();
			max_records = qryContext.getMaxRecord();
			int byteColumns = (int)qryContext.getNoOfColumns();		

			ArrayList arrRow = new ArrayList();
			HashMap record = new HashMap();
			try
			{
				if(start <= 0)
				{
					start = 0;
				}

				int intTempStart = start;
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				resultSetMetaData =	rs.getMetaData();

				while(rs.next())
				{
					if (!(intTempStart <= 0))
					{
						--intTempStart;
						continue;
					}

					for (int l = 0; l < byteColumns; l++)
					{
						int iColumnType = resultSetMetaData.getColumnType(l+1);				

						switch (iColumnType)
						{
							case Types.CLOB:
								Clob clobData = rs.getClob(resultSetMetaData.getColumnName(l+1));
								StringBuffer sbClobData	= new StringBuffer();
								if(clobData != null) 
								{
									sbClobData.append(clobData.getSubString(1, (int)clobData.length()));
								}
								record.put(resultSetMetaData.getColumnName(l+1), sbClobData.toString() + "");
								break;

							default:
								record.put(resultSetMetaData.getColumnName(l+1), rs.getString(l+1) + "");
						}
					}
					arrRow.add(record);
					record = new HashMap();
					record.clear();
					++intFetchedRecords;

						if(max_records != 0 && intFetchedRecords >= max_records)
						{
							if(rs.next())
							{
								moreRecordsExist = true;
							}
							break;
						}
				}
			}
			catch(Exception expSQL)
			{
				System.out.println("Error(1) in getResultWithColNames method of xhdatabasequery :"+expSQL.toString());
				System.out.println("Query: "+sql);
				expSQL.printStackTrace(System.err);
			}
			finally
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}

			hashmp.put("qry_result", arrRow);
			hashmp.put("end", end + "");
			hashmp.put("start", start + "");

			if (start > 1)
			{
				hashmp.put("previous", new Boolean(true));
			}
			else
			{
				hashmp.put("previous", new Boolean(false));
			}
			if ((intFetchedRecords >= max_records) && moreRecordsExist)
			{
				hashmp.put("next", new Boolean(true));
			}
			else
			{
				hashmp.put("next", new Boolean(false));
			}

		}
		catch(Exception exp)
		{
			System.out.println("XHDatabaseQuery sql : "+sql);
			exp.printStackTrace(System.err);
		}
		return hashmp;
	}

}	
