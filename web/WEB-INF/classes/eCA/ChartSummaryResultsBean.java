/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
25/01/2016	IN058139		Ramesh G										INT-CRF-BRU-CIS-005-US001
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import webbeans.eCommon.ConnectionManager;

public class  ChartSummaryResultsBean implements java.io.Serializable
{
	private String minValue = null;
	private String maxValue = null;
	private String seriesForGraph = null;
	
	
	public String getMinValue() {
		return minValue;
	}
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	public String getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}	
	public String getSeriesForGraph() {
		return seriesForGraph;
	}
	public void setSeriesForGraph(String seriesForGraph) {
		this.seriesForGraph = seriesForGraph;
	}
	
	public void getMaxAndMinValues(String disMsrId){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String disMsrMinValue = "";
		String disMsrMaxValue = "";
		try{
			String strQuery = "SELECT MIN_VALUE,MAX_VALUE FROM AM_DISCR_MSR WHERE DISCR_MSR_ID=?";
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,disMsrId);
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				disMsrMinValue= rs.getString("MIN_VALUE")==null?"":(String)rs.getString("MIN_VALUE");
				disMsrMaxValue= rs.getString("MAX_VALUE")==null?"":(String)rs.getString("MAX_VALUE");
			}			
			setMinValue(disMsrMinValue);
			setMaxValue(disMsrMaxValue);
			if(rs!= null) rs.close();
	        if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSQLObj(rs,"ResultSet");
			closeSQLObj(pstmt,"PreparedStatement");
			closeSQLObj(con,"Connection");
		}
		
	}
	public String getValuesRange(String locale, String patient_id, String event_code, String event_group, String histRecType, String event_dateTime){
		String 				valuesRange	= "";
		Connection 			con 		= null;
		PreparedStatement 	pstmt 		= null;
		ResultSet			rs			= null;
		String 				dateForgraph 	= "";
		String 				seriesForGraph 	= "";
		String 				ValueForgraph 	= "";
		StringBuffer sql = new StringBuffer();
		StringBuffer valuesBuffer = new StringBuffer();
		int indVal = 1;
		try{
			con = ConnectionManager.getConnection();
			
			sql.append("select a.RESULT_NUM, to_char(a.EVENT_DATE,'dd/mm/yyyy hh24:mi') EVENT_DATE, b.short_desc event_desc from CR_ENCOUNTER_DETAIL a, CR_CLN_EVT_MST_LANG_VW b where b.LANGUAGE_ID = ? and b.HIST_REC_TYPE = a.HIST_REC_TYPE and b.EVENT_CODE = a.EVENT_CODE and a.HIST_REC_TYPE = ? ");
			if(!event_group.equals(""))
				sql.append("and a.EVENT_GROUP = ? ");		
			sql.append("and a.EVENT_CODE = ? and a.PATIENT_ID = ? and nvl(a.STATUS,'`') not in('S','E') and a.EVENT_DATE= to_date(?,'dd/mm/yyyy hh24:mi:ss')");
			
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(indVal++,locale);
			pstmt.setString(indVal++,histRecType);
			if(!event_group.equals(""))
				pstmt.setString(indVal++,event_group);
			pstmt.setString(indVal++,event_code);
			pstmt.setString(indVal++,patient_id);			
			pstmt.setString(indVal++,event_dateTime);
			
			rs = pstmt.executeQuery();		
			
			int valueLenth=0;
			while(rs.next())
			{
				dateForgraph = rs.getString("EVENT_DATE") == null ? "" : rs.getString("EVENT_DATE");
				dateForgraph = com.ehis.util.DateUtils.convertDate(dateForgraph,"DMYHM","en",locale);
				ValueForgraph = rs.getString("RESULT_NUM") == null ? "" : rs.getString("RESULT_NUM");
				seriesForGraph = rs.getString("event_desc") == null ? "" : rs.getString("event_desc");				
				if(valueLenth!=0)
				valuesBuffer.append('@');
				valuesBuffer.append(dateForgraph);
				valuesBuffer.append('~');
				valuesBuffer.append(ValueForgraph);
				valuesBuffer.append('~');
				valuesBuffer.append(seriesForGraph);
				valueLenth++;
				
			}
			if(rs!= null) rs.close();
	        if(pstmt!=null) pstmt.close();
	        setSeriesForGraph(seriesForGraph);
	        valuesRange = valuesBuffer.toString();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSQLObj(rs,"ResultSet");
			closeSQLObj(pstmt,"PreparedStatement");
			closeSQLObj(con,"Connection");
		}
		return valuesRange;
	}
	
	public String closeSQLObj(Object object, String objectType)
	{
		if(object != null)
		{
			try
			{

				if(objectType.equalsIgnoreCase("ResultSet"))
				{
					ResultSet rs = (ResultSet)object;
					rs.close();
				}
				else if(objectType.equalsIgnoreCase("PreparedStatement"))
				{
					PreparedStatement pst = (PreparedStatement)object;
					pst.close();
				}
				else if(objectType.equalsIgnoreCase("Connection"))
				{
					Connection con = (Connection) object;
					con.close();
				}
			}
			catch(Exception se)
			{
				return se.toString();
			}
		}
		return "Object Closed.";
	}
}
