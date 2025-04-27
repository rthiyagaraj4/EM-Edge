/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import java.util.*;

import webbeans.eCommon.*;

public class ChartComponentServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		//request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		PrintWriter out = null;
		
		try
		{
			out = response.getWriter();
			String mode = request.getParameter("mode")==null?"":request.getParameter("mode");			
			mode = "insert";
		
			if(mode.equals("insert")) insert(request,response, out);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
	
		try
		{
			out = response.getWriter();
			doPost(request,response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void insert(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
	{
		java.util.Properties p;
		HttpSession session;

		Connection con = null;

		PreparedStatement ps = null;
		PreparedStatement psSelect = null;
	
		ResultSet rs = null;
		
		String chart_id = "";
		String panel_id = "";
		String discr_msr_id = "";
		String added_facility_id = "";
		String modified_by_id = "";
		String modified_facility_id = "";
		String client_ip_address = "";
		String records = "";
		
		session = request.getSession(false);
		p = (java.util.Properties) session.getValue("jdbc");
		
		String locale = (String) p.getProperty("LOCALE");
		
		added_facility_id		= (String) session.getValue("facility_id");
		client_ip_address		= p.getProperty("client_ip_address");
		modified_by_id			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		modified_facility_id	= (added_facility_id==null)?"":added_facility_id;
		
		HashMap dummy = null;
		HashMap dummySummary = null;
		String resultType="";
		String orderSeqNo="";
		String disSeqNo="";
		String keyValue = "";
		String Formula = "";
		String finalString = "";
		String ch_id = "";
		String pa_id = "";
		String discr_id = "";
		String summary_type = "";
		String summary_column = "";
		String summ = "";
		String default_yn = "";
		String mandatory_yn = "";
		String sum_yn = "";
		String element_type = "";
		//String change_at_trans = "";
		PreparedStatement psdel = null;
		StringTokenizer strToken = null;
		StringTokenizer Strkey = null;	
		StringTokenizer finalStrTilde = null;
		StringTokenizer finalStrPipe = null; 
		StringTokenizer strSumm = null;
		//int i = 0;
		int rowsCount = 0;
		int index = 0;

		try
		{
			con = ConnectionManager.getConnection(request);
		
			ChartComponentFormulaBean formulaBean  = (ChartComponentFormulaBean)session.getAttribute("formulaBean");
			ChartComponentResultsetBean recordsBean = (ChartComponentResultsetBean)session.getAttribute("recordsBean");

			ArrayList keyList = recordsBean.fetchKeys();

			finalString = recordsBean.getFinalString()==null ? "" :  recordsBean.getFinalString();
			ps  = con.prepareStatement("insert into ca_chart_section_comp(CHART_ID, PANEL_ID, DISCR_MSR_ID, DISCR_MSR_TYPE, FORMULA_DEF, SUMMARY_TYPE, SUMMRY_COLUMN, PANEL_DISP_ORDER_SEQ, DISCR_DISP_ORDER_SEQ, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DEFAULT_DISPLAY_YN,SUM_YN,MANDATORY_YN,ELEMENT_TYPE) values(?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?)");
			//Added below block at the top starts
			if(!finalString.equals("")){
				psdel = con.prepareStatement("delete from ca_chart_section_comp where CHART_ID = ? and  PANEL_ID = ? and DISCR_MSR_ID = ?");
				finalStrTilde = new StringTokenizer(finalString,"~");
				while(finalStrTilde.hasMoreTokens()){
					finalStrPipe = new StringTokenizer(finalStrTilde.nextToken(),"||");
					ch_id = checkForNull(finalStrPipe.nextToken().trim());
					discr_id =checkForNull( finalStrPipe.nextToken().trim());
					pa_id = checkForNull(finalStrPipe.nextToken().trim());
					psdel.setString(1,ch_id);
					psdel.setString(2,pa_id);
					psdel.setString(3,discr_id);
					int deleted = psdel.executeUpdate();
					deleted = deleted;
					con.commit();
				}
			}
			//Added below block at the top Ends
			while(index < keyList.size())
			{
				keyValue = "";
				Formula = "";
			
				keyValue =checkForNull((String) keyList.get(index));
				Strkey = new StringTokenizer(keyValue,":");
				
				chart_id = checkForNull(Strkey.nextToken());

				panel_id = checkForNull(Strkey.nextToken());
	
				discr_msr_id = checkForNull(Strkey.nextToken());
		
				psSelect = con.prepareStatement("delete from ca_chart_section_comp where  CHART_ID = ? and PANEL_ID = ? and DISCR_MSR_ID=? ");
				psSelect.setString(1,chart_id);
				psSelect.setString(2,panel_id);	
				psSelect.setString(3,discr_msr_id);	
				int rows = psSelect.executeUpdate();
				rows = rows;
				con.commit();
				if(psSelect != null) psSelect.close();
				records = recordsBean.fetchRecords(keyValue);
				
				strToken = new StringTokenizer(records,"$");
				resultType = checkForNull(strToken.nextToken());
			
				orderSeqNo =checkForNull(strToken.nextToken());
			
				disSeqNo =checkForNull(strToken.nextToken());
			
				if(formulaBean != null){
					dummySummary = formulaBean.getSummary();
					
					if(dummySummary!=null){
						summ = checkForNull((String)dummySummary.get(keyValue));
										
						if(!summ.equals("")){
							strSumm = new StringTokenizer(summ,":");
							summary_column = checkForNull(strSumm.nextToken().trim());
					
							if(summary_column.equals("X"))
									summary_column = "";
							summary_type = checkForNull(strSumm.nextToken().trim());
						
							if(summary_type.equals("X"))
									summary_type = "";
							default_yn = checkForNull(strSumm.nextToken().trim());
						
							sum_yn = checkForNull(strSumm.nextToken().trim());
							mandatory_yn = checkForNull(strSumm.nextToken().trim());
					
							//change_at_trans = checkForNull(strSumm.nextToken().trim());
							element_type = checkForNull(strSumm.nextToken().trim());
							element_type = checkForNull(strSumm.nextToken().trim());
						}
						else
						{
							summary_column = "";
							summary_type = "";
							element_type = "";
						}						
					}
				}
				if(resultType.equals("A")){
					if(formulaBean != null){
						dummy = formulaBean.returnFormulaTab();
						if(dummy != null)
							Formula =checkForNull((String)dummy.get(keyValue));		
					
						}
				}//end of if	
			
				ps.setString(1,chart_id);
				ps.setString(2,panel_id);
				ps.setString(3,discr_msr_id);
				ps.setString(4,resultType);
				ps.setString(5,Formula);
				ps.setString(6,summary_type);
				ps.setString(7,summary_column);
				ps.setString(8,disSeqNo);
				ps.setString(9,orderSeqNo);
				ps.setString(10,modified_by_id);
				ps.setString(11,client_ip_address);
				ps.setString(12,modified_facility_id);
				ps.setString(13,modified_by_id);
				ps.setString(14,client_ip_address);
				ps.setString(15,modified_facility_id);
				ps.setString(16,default_yn);
				
				ps.setString(17,sum_yn);
				
				ps.setString(18,mandatory_yn);

				if(element_type.equals("##"))
					element_type = "";
		
				if (!resultType.equals("N") && !resultType.equals("I") && !resultType.equals("A"))
					element_type = "";

				ps.setString(19,element_type);

				rowsCount = rowsCount + ps.executeUpdate();						
				index++;
			}//end of while-1


			//if(keyList != null) keyList.clear();
			//if(dummy != null) dummy.clear();
			//if(dummySummary != null) dummySummary.clear();

			if(rowsCount == index){
				try{
					//the below if condition is added to the top
					/*
					if(!finalString.equals("")){
						psdel = con.prepareStatement("delete from ca_chart_section_comp where CHART_ID = ? and  PANEL_ID = ? and DISCR_MSR_ID = ?");
						finalStrTilde = new StringTokenizer(finalString,"~");
						while(finalStrTilde.hasMoreTokens()){
							finalStrPipe = new StringTokenizer(finalStrTilde.nextToken(),"||");
							ch_id = checkForNull(finalStrPipe.nextToken().trim());
							discr_id =checkForNull( finalStrPipe.nextToken().trim());
							pa_id = checkForNull(finalStrPipe.nextToken().trim());
							psdel.setString(1,ch_id);
							psdel.setString(2,pa_id);
							psdel.setString(3,discr_id);
							int deleted = psdel.executeUpdate();
							deleted = deleted;
							con.commit();
						}
					}
					*/
					// Ends Issue Happens when component is removed and added again
					recordsBean.setFinalString("");
					formulaBean.clearHashtableValue();
					recordsBean.clearHashtableValue();
					formulaBean.setretValString("");
					formulaBean.clearSummary();
					session.removeAttribute("formulaBean");
					session.removeAttribute("recordsBean");
					Hashtable tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
					String errorMsg= (String) tabdata.get("message");
					tabdata.clear();
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");
					con.commit();
				}//end of try-2
				catch(Exception ee){
					ee.printStackTrace();
				}			
			}//end of if rowcount
			else{
				try{
					con.rollback();
				}//end of try-3
				catch(Exception ee){
					ee.printStackTrace();
				}
			}//end of else
		}//end of try-1
		catch(Exception e){
			e.printStackTrace();
			 
		}
		finally
		{
			try
			{
				if(rs != null)rs.close();
				if(psdel != null)psdel.close();
				if( ps != null)ps.close();
				if(psSelect != null) psSelect.close();
				if(con != null)ConnectionManager.returnConnection(con);
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		}
	}//end of insert
	private String checkForNull(String inputString)
	{
		if(inputString == null || inputString.equals("") ||  inputString.equalsIgnoreCase("null") )
			inputString = "";
		return inputString;
	}
}//end of class
