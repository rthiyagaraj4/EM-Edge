/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA;
import java.sql.*;
import java.io.*;
//import javax.servlet.*;
//import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.text.*;
//import webbeans.eCommon.*;
//import webbeans.eCommon.ConnectionManager;
//import webbeans.eCommon.MessageManager;
public class SectionChartBean  implements java.io.Serializable
 { 
	//Connection con;
	//PreparedStatement ps;
	//ResultSet rs;
	String finalString;
	int descLength;
	ArrayList retArray = new ArrayList();
	ArrayList list = new ArrayList();
	ArrayList retArray1 = new ArrayList();
	ArrayList indexList = new ArrayList();
	/*ArrayList arrayDesc = new ArrayList();
	ArrayList discreteMeasureId = new ArrayList();
	ArrayList orderSeqNo = new ArrayList();
	ArrayList flag = new ArrayList();*/
/**
*	deleteRow	-	will be called when a row has to be deleted from the Table
*	@param	remove_value - this is String
*	@param	connection - this is Connection
*	@param	chartId - this is String
*	
*/

	public void deleteRow(String remove_value,Connection connection,String chartId,Properties p)
	{
		PreparedStatement ps;
		try{
			ps = connection.prepareStatement("delete from ca_chart_section where chart_id =? and panel_id = ?");
			ps.setString (1,chartId);
			ps.setString (2,remove_value);
			//int deleted = ps.executeUpdate();
			ps.executeUpdate();
			if(ps != null )ps.close();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		finally
		{
			//if(connection != null) ConnectionManager.returnConnection(connection,p);
		}
		
	}
/**
*	getQueryForChart	-	will be called to display Six Records at a time from Database in a table 											Format in the JSP
*	@param	chartId - this is String
*	@param	connection - this is Connection
*	@param	searchText - this is String
*	@param	start - this is int
*	@param	end - this is int
*/
	public ArrayList getQueryForChart(String chartId,String searchText,Connection connection,int start,int end)
	{
		retArray = new ArrayList();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		String description ="";
		String seq_num = "";
		String discreteMeasureid = "";
		String sql = "select LONG_DESC long_desc, SHORT_DESC short_desc,b.DISPLAY_ORDER_SEQ seq_num,DISCR_MSR_ID discr_msr_id, decode(b.DISPLAY_ORDER_SEQ,null,'N','Y') flag from am_discr_msr a, ca_chart_section b where a.DISCR_MSR_ID = b.PANEL_ID(+) and RESULT_TYPE in ('G') and CHART_ID(+) = ? and upper(a.SHORT_DESC) like upper(?) and a.eff_status='E' order by 2";
		try{
				con =  connection;
				ArrayList arrayDesc = new ArrayList();
				ArrayList discreteMeasureId = new ArrayList();
				ArrayList orderSeqNo = new ArrayList();
				ArrayList flag = new ArrayList();
				ps = con.prepareStatement(sql);
				ps.setString(1,chartId);
				ps.setString(2,searchText);
				rs = ps.executeQuery();
				int i = 0;
				int j=0;
				int index = 0;
				int count = 0;
				for(j=1,i=1; j<start; i++,j++ )
				{
			      rs.next() ;
				}
				while(rs.next() && i<= end)
				{	
							
							count++;
							description = ( rs.getString("short_desc")==null ? "" : rs.getString("short_desc")) ;
							arrayDesc.add(index,description);
							seq_num  = rs.getString("seq_num")==null ? "" :rs.getString("seq_num");
							orderSeqNo.add(index,seq_num);
							discreteMeasureid = rs.getString("discr_msr_id")==null ? "" :rs.getString("discr_msr_id");
							discreteMeasureId.add(index,discreteMeasureid);
							flag.add(index,rs.getString("flag"));
							index++;
							i++;
				}
				retArray.add(0,arrayDesc);
				retArray.add(1,orderSeqNo);
				retArray.add(2,discreteMeasureId);
				retArray.add(3,flag);
				if(rs != null) rs.close();
				if(ps != null)ps.close();
				//arrayDesc.clear();
				//orderSeqNo.clear();
				//discreteMeasureId.clear();
				//flag.clear();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}

		return retArray;
	}
/**
*	getMaxRecord	-	will be called to get the total Number of Records from the database based upon 								Criteria matching
*	@param	chartId - this is String
*	@param	connection - this is Connection
*	@param	searchText - this is String
*/
	public int getMaxRecord(String chartId,String searchText,Connection connection)
	{
		int total=0;
		PreparedStatement ps;
		ResultSet rs;

		try{
		ps = connection.prepareStatement("select count(*) total from am_discr_msr a, ca_chart_section b where a.DISCR_MSR_ID = b.PANEL_ID(+) and RESULT_TYPE in ('G') and CHART_ID(+) = ? and upper(a.SHORT_DESC) like upper(?) and a.eff_status='E'");
		
		ps.setString(1,chartId);
		ps.setString(2,searchText);
		rs = ps.executeQuery();
		while(rs.next())
		{
			total = rs.getInt("total");
		}
		if(rs != null) rs.close();
		if(ps != null)ps.close();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		return total;
	}
/**
*	getQueryForChart	-	will be called to display Six Records at a time from Database in a table 											Format in the JSP
*	@param	chartId - this is String
*	@param	connection - this is Connection
*	@param	searchText - this is String
*/
	public ArrayList getQueryForChart(String chartId,String searchText,Connection connection)
	{
		retArray1 = new ArrayList();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;

		String description ="";
		String seq_num = "";
		String discreteMeasureid = "";
		String sql = "select LONG_DESC long_desc, SHORT_DESC short_desc,b.DISPLAY_ORDER_SEQ seq_num,DISCR_MSR_ID discr_msr_id, decode(b.DISPLAY_ORDER_SEQ,null,'N','Y') flag from am_discr_msr a, ca_chart_section b where a.DISCR_MSR_ID = b.PANEL_ID(+) and RESULT_TYPE in ('G') and CHART_ID(+) = ? and upper(a.SHORT_DESC) like upper(?)  and a.eff_status='E' order by 3";
		try{
				con =  connection;
				ArrayList arrayDesc = new ArrayList();
				//retArray = new ArrayList();
				ArrayList discreteMeasureId = new ArrayList();
				ArrayList orderSeqNo = new ArrayList();
				ArrayList flag = new ArrayList();
				ps = con.prepareStatement(sql);
				ps.setString(1,chartId);
				ps.setString(2,searchText);
				rs = ps.executeQuery();
				int i = 0;
				//int j=0;
				int count = 0;
				while(rs.next())
				{
							count++;
							description =( rs.getString("short_desc")==null ? "" : rs.getString("short_desc")) ;
							arrayDesc.add(i,description);
							seq_num  = rs.getString("seq_num")==null ? "" :rs.getString("seq_num");
							orderSeqNo.add(i,seq_num);
							discreteMeasureid = rs.getString("discr_msr_id")==null ? "" :rs.getString("discr_msr_id");
							discreteMeasureId.add(i,discreteMeasureid);
							flag.add(i,rs.getString("flag"));
							i++;
				}
				retArray1.add(0,arrayDesc);
				retArray1.add(1,orderSeqNo);
				retArray1.add(2,discreteMeasureId);
				retArray1.add(3,flag);
				if(rs != null) rs.close();
				if(ps != null)ps.close();
				//discreteMeasureId.clear();
				//orderSeqNo.clear();
				//arrayDesc.clear();
				//flag.clear();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		return retArray1;
	}
/**
*	returnConnection	-	used to Close Connections and Statement Objects
	public void  returnConnection()
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;

		con=conection;
		this.ps=ps;
		this.rs=rs;

		try{
				if(rs != null) rs.close();
				if(ps != null)ps.close();
				if(con != null)ConnectionManager.returnConnection(con);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	*/

/**
*	getConcatenatedString	-	returns a Contenated String
*/
	public String getConcatenatedString()
	{
		return this.finalString;
	}
	/**
*	setConcatenatedString	-	sets a Contenated String to Final String of Instance Variable
*/
	public void setConcatenatedString(String finalString)
	{
		this.finalString = finalString;
	}
/**
*	setLength	-	sets the length of the Concatenated String
*/
	public void setLength(int descLength)
	{
		this.descLength = descLength;
		
	}
/**
*	getLength	-	returns the length of the Concatenated String
*/
	public int  getLength()	
	{
		return this.descLength;
	}

	public String setFinalString(ArrayList list)
	 {
		ArrayList arrCode = (ArrayList)list.get(2);
		ArrayList arrDesc = (ArrayList)list.get(0);
		ArrayList arrSeqNum = (ArrayList)list.get(1);
		ArrayList arrFlag = (ArrayList)list.get(3);

		String code = "";
		String desc = "";
		String ordSeq = "";
		String flag = "";
		String finalString  = "";
		for(int i=0;i<arrCode.size();i++)
		{
			code = 	(String) arrCode.get(i);
			desc = 	(String) arrDesc.get(i);
			ordSeq = (String) arrSeqNum.get(i);
			flag = 	(String) arrFlag.get(i);
			
			if (flag.equals("Y"))
			{
			if(finalString.equals(""))
			{
				finalString = desc + "||" + code + "||" +  ordSeq + "||" +  flag;
			}
			else
			{
				finalString = finalString + "~" + desc + "||" + code + "||" +  ordSeq + "||" +  flag;
			}
		}
			
	 }
			return finalString;
	}		


	public void setArrayList(ArrayList list)
	 {
		 retArray1 = list;
	 }

	public ArrayList retrieveArrayList()
	{
		return retArray1;
	}

	public void clearArray(ArrayList retArray)
	 {		 
		retArray = null;
	 }
	
}
