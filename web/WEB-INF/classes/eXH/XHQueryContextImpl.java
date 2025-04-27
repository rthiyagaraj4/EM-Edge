/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.util.HashMap;

/**
 * This class implements the QueryContext Interface
 * This class can be overridden or extended for manipulating
 * the complex queries.
 */

public class XHQueryContextImpl implements eXH.XHQueryContext,java.io.Serializable
{

String strOriginialQuery ;
String sqlSearch="0";
byte maxRecord=15;
int next=0;
int previous=0;
String strQueryParam[] = null;
String strColumns[] = null;
byte byteColumnDataTypes[] = null;
String sqlOrderBy = "0";
byte noOfColumns = 0;
HashMap hashMapQueryCriteria;


/**
  * This method is set the Original Query.
  */
public void setOriginalQuery(String str)
{
	strOriginialQuery = str;
}

/**
   * This method is set the Query with the actual search text.
   * This sets the formatted Query
 */

public void setSQLSeach(String str)
{
		sqlSearch  = str;
	}
  /**
   * This method is sets maxRecord to be retrieved per hit.
   * 
   */
	
	public void setMaxRec(byte max)
	{
		maxRecord = max;
	}
  
  /**
   * This method sets the next set of result data
   * 
   */
	
	public void setNextSet(int  n)
	{
		next = n;
	}
  /**
   * This method sets the previous set of result data
   * 
   */
	
	public void setPreviousSet(int p)
	{
		previous = p;
	}
  /**
   * This method gets the Original Query
   * 
   */
	
	public String getOriginalQuery()
	{
		return(strOriginialQuery);
	}
  /**
   * This method gets the Formatted result Query
   * 
   */
	
	public String getSQLSearch()
	{
		return(sqlSearch);
	}
  
  /**
   * This method gets the Next Set of Data
   * 
   */
	
	public int getNextSet()
	{
		return(next);
	}
  /**
   * This method gets the Previous Set of Data
   * 
   */
	
	public int getPreviousSet()
	{
		return(previous);
	}
  /**
   * This method gets the max Record to be retrieved per hit.
   * 
   */
	
	public int getMaxRecord()
	{
		return(maxRecord);
	}
  /**
   * This method sets the Query Criteria
   * 
   */
	
	public void setQueryCriteria(HashMap hashmp)
	{
		this.hashMapQueryCriteria = hashmp;
	}
  /**
   * This method gets the Query Criteria
   * 
   */
	
	public HashMap getQueryCriteria()
	{
		return(hashMapQueryCriteria);
	}
  
  /**
   * This method clears the search criteria
   * 
   */
	
	public void cleanAll()
	{
		sqlSearch = "0";
		next=0;
		previous = 0;
		hashMapQueryCriteria = null;
	}
  /**
   * This method sets the QueryParameters
   * 
   */
	
	public void setQueryParam(String str[])
	{
			strQueryParam = str;
	}
  /**
   * This method gets the QueryParameters
   * 
   */
	
	public String[] getQueryParam()
	{
		return(strQueryParam);
	}
  /**
   * This method sets the Column Names
   * 
   */
	
	public void setColumns(String strCol[])
	{
		strColumns =  strCol;
	}
  /**
   * This method gets the Column Names
   * 
   */
	
	public String[] getColumns()
	{
		return(this.strColumns);
	}
  /**
   * This method gets the Column Data Types
   * 
   */
	
	public byte[] getColumnDataTypes()
	{
		return byteColumnDataTypes;
	}
  /**
   * This method sets the Column Data Types
   * 
   */
	
	public void setColumnDataTypes(byte byteData[])
	{
		this.byteColumnDataTypes = byteData;
	}

 /**
   * This method sets the sql order by
   * @param  String str
   * 
   */
	public void setSQLOrderBy(String str)
  {
    this.sqlOrderBy = str;
  }
  
 /**
   * This method gets sql order by
   * 
   */  
  public String getSQLOrderBy()
  {
    return(this.sqlOrderBy);
  }
  /**
   * This method get the no of columns 
   * 
   */
  public byte getNoOfColumns()
  {
    return(this.noOfColumns);
  }
   /**
   * This method sets the Columns
   * @param  byte b
   */
  public void setNoOfColumns(byte b)
  {
    this.noOfColumns =  b;
  }
}//end of class 
