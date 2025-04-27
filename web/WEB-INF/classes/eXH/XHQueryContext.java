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
 * This interface defines common methods 
 */
public interface XHQueryContext
{
	public void setOriginalQuery(String str);
	public void setSQLSeach(String str);
	public void setMaxRec(byte max);
	public void setNextSet(int n);
	public void setPreviousSet(int p);
	public String getOriginalQuery();
	public String getSQLSearch();
	public int getNextSet();
	public int getPreviousSet();
	public int getMaxRecord();
	public void setQueryCriteria(HashMap hashmp);
	public HashMap getQueryCriteria();
	public void cleanAll();
	public void setQueryParam(String str[]);
	public String[] getQueryParam();
	public void setColumns(String strCol[]);
	public String[] getColumns();
	public byte[] getColumnDataTypes();
	public void setColumnDataTypes(byte byteData[]);
	public void setSQLOrderBy(String str);
	public String getSQLOrderBy();
  public byte getNoOfColumns();
  public void setNoOfColumns(byte b);
}//end of interface
