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
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;
import java.util.*;
 public class ChartRecordingCriteriaServlet extends HttpServlet
 {	 
/**
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
	public void init(ServletConfig config) throws ServletException
	{
		 super.init(config);
	}
/**
*	doPost	-	will be called when the method is of post
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		
		insertData(request,out,session);
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
	public void insertData(HttpServletRequest request,PrintWriter out,HttpSession session)
	{
		java.util.Properties p;
		String client_ip_addr;
		String facilityId;
		String addedId;
		String chartId;
		String encounterId;
		String sectionId	= "";
		String discrMsrId	= "";
		String resultType	= "";
		String displayOrderSeqNo = "";
		String orderSrlNo	= "";
		String formulaDef	= "";
		String defaultYN	= "";
		String sumYN		= "";
		String summaryColumn = "";
		String errorMsg ="";
		String summaryType = "";
		String flagMsg = "";
		
		String mandatory_yn="";

		StringBuffer replaceString = null;

		int index = 0;
		int indexI = 0;

//		Hashtable tabdata;
		
		CallableStatement cs = null;
		
		PreparedStatement ps;
		PreparedStatement psUpdate;
		PreparedStatement psSelect;
		PreparedStatement psDelete;
		PreparedStatement psDelete_;
		
		ResultSet rsSelect = null;
		
		Connection con;
		con = ConnectionManager.getConnection(request);

		boolean bUpd_status = true;
		
		try
		{		
			int flagCount =0;
//			int recordInserted =0;
			int total =0;

			p			= (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale		= (String) p.getProperty("LOCALE");
			facilityId		= (String) session.getValue( "facility_id" ) ;
			client_ip_addr	= p.getProperty("client_ip_address");
			addedId			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user"); 
			chartId			= request.getParameter("chartId")==null ? "" : request.getParameter("chartId");
			encounterId		= request.getParameter("encounterId")==null ? "0" : request.getParameter("encounterId");

			if(encounterId.equals("")) 
				encounterId = "0";

			index = request.getParameter("index")==null ? 0 : Integer.parseInt(request.getParameter("index"));
			indexI =0;
			
			flagMsg		= request.getParameter("flagMsg")==null ? "":request.getParameter("flagMsg");
			psDelete	= con.prepareStatement("delete  CA_ENCNTR_CHART_DRAFT where   FACILITY_ID= ? and  ENCOUNTER_ID = ? and  CHART_ID =? and  PANEL_ID = ? and DISCR_MSR_ID = ? "); 
			psSelect	= con.prepareStatement("select count(*) from CA_ENCNTR_CHART_DRAFT where   FACILITY_ID= ? and  ENCOUNTER_ID = ? and  CHART_ID =? and  PANEL_ID = ? and DISCR_MSR_ID = ? ");
			psUpdate	= con.prepareStatement("update CA_ENCNTR_CHART_DRAFT set DISCR_MSR_TYPE=?, FORMULA_DEF=?, SUM_YN=?, SUMMARY_TYPE=?, SUMMRY_COLUMN=?, PANEL_DISP_ORDER_SEQ=?, DISCR_DISP_ORDER_SEQ=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID = ?,MANDATORY_YN=?  where   FACILITY_ID= ? and  ENCOUNTER_ID = ? and  CHART_ID =? and  PANEL_ID = ? and DISCR_MSR_ID = ? ");
			ps			= con.prepareStatement("insert into CA_ENCNTR_CHART_DRAFT(FACILITY_ID, ENCOUNTER_ID, CHART_ID, PANEL_ID, DISCR_MSR_ID, DISCR_MSR_TYPE, FORMULA_DEF, SUM_YN, SUMMARY_TYPE, SUMMRY_COLUMN, PANEL_DISP_ORDER_SEQ, DISCR_DISP_ORDER_SEQ, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,MANDATORY_YN) values(?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?) ");

			psDelete_   = con.prepareStatement("delete  CA_ENCNTR_CHART_DRAFT where   FACILITY_ID= ? and  ENCOUNTER_ID = ? and  CHART_ID =? "); 
			psDelete_.setString(1,facilityId);
			psDelete_.setString(2,encounterId);
			psDelete_.setString(3,chartId);
			psDelete_.executeUpdate();
			for(indexI= 0 ;indexI < index ;indexI++)
			{
				defaultYN	= request.getParameter("defaultYN"+indexI)==null ? "" : request.getParameter("defaultYN"+indexI);
				sectionId	= request.getParameter("sectionId"+indexI)==null ? "" :  request.getParameter("sectionId"+indexI);
				discrMsrId  = request.getParameter("discrMsrId"+indexI)==null ? "" :  request.getParameter("discrMsrId"+indexI);
				
				if(defaultYN.equals("Y"))
				{
					flagCount++;
					psSelect.setString(1,facilityId);
					psSelect.setString(2,encounterId);
					psSelect.setString(3,chartId);
					psSelect.setString(4,sectionId);
					psSelect.setString(5,discrMsrId);

					rsSelect = psSelect.executeQuery();

					if(rsSelect.next())
						total = rsSelect.getInt(1);

					if(rsSelect != null)
						rsSelect.close();

					resultType			= request.getParameter("resultType"+indexI)==null ? "" :  request.getParameter("resultType"+indexI);
					displayOrderSeqNo	= request.getParameter("displayOrderSeqNo"+indexI)==null ? "" :  request.getParameter("displayOrderSeqNo"+indexI);
					orderSrlNo			= request.getParameter("orderSrlNo"+indexI)==null ? "" :  request.getParameter("orderSrlNo"+indexI);
					formulaDef			= request.getParameter("formulaDef"+indexI)==null ? "" :  request.getParameter("formulaDef"+indexI);
					sumYN				= request.getParameter("sumYN"+indexI)==null ? "N" :  request.getParameter("sumYN"+indexI);
					
					if(sumYN.equals("null") || sumYN.equals("")) 
						sumYN = "N";
					
					summaryColumn		= request.getParameter("summaryColumn"+indexI)==null ? "" :  request.getParameter("summaryColumn"+indexI);
					summaryType			= request.getParameter("summaryType"+indexI)==null ? "" :  request.getParameter("summaryType"+indexI);
					mandatory_yn		= request.getParameter("mandatory_yn"+indexI)==null ? "" :  request.getParameter("mandatory_yn"+indexI);

					if(mandatory_yn.equals("null") || mandatory_yn.equals("")) 
						mandatory_yn = "N";
					
					if(total != 0)
					{
						psUpdate.setString(12,facilityId);
						psUpdate.setString(13,encounterId);
						psUpdate.setString(14,chartId);
						psUpdate.setString(15,sectionId);
						psUpdate.setString(16,discrMsrId);
						psUpdate.setString(1,resultType);
						psUpdate.setString(2,formulaDef);
						psUpdate.setString(3,sumYN);
						psUpdate.setString(4,summaryType);
						psUpdate.setString(5,summaryColumn);
						psUpdate.setString(6,displayOrderSeqNo);
						psUpdate.setString(7,orderSrlNo);
						psUpdate.setString(8,addedId);
						psUpdate.setString(9,client_ip_addr);
						psUpdate.setString(10,facilityId);
						psUpdate.setString(11,mandatory_yn);	
						psUpdate.addBatch();
//						psUpdate.clearParameters();
					}
					else
					{
						ps.setString(1,facilityId);
						ps.setString(2,encounterId);
						ps.setString(3,chartId);
						ps.setString(4,sectionId);
						ps.setString(5,discrMsrId);
						ps.setString(6,resultType);
						ps.setString(7,formulaDef);
						ps.setString(8,sumYN);
						ps.setString(9,summaryType);
						ps.setString(10,summaryColumn);
						ps.setString(11,displayOrderSeqNo);
						ps.setString(12,orderSrlNo);
						ps.setString(13,addedId);
						ps.setString(14,client_ip_addr);
						ps.setString(15,facilityId);
						ps.setString(16,addedId);
						ps.setString(17,client_ip_addr);
						ps.setString(18,facilityId);
						ps.setString(19,mandatory_yn);
						ps.addBatch();
//						ps.clearParameters();
					}
				}
				else
				{
					psDelete.setString(1,facilityId);
					psDelete.setString(2,encounterId);
					psDelete.setString(3,chartId);
					psDelete.setString(4,sectionId);
					psDelete.setString(5,discrMsrId);
					psDelete.executeUpdate();
				}
			}

			try
			{
				int nUpdRecords  = 0;
				int nUpd []		= psUpdate.executeBatch();
				int nUpd1 []	= ps.executeBatch();

				if (nUpd.length == -3 || nUpd1.length == -3)
					bUpd_status = false;

				nUpdRecords = nUpd.length + nUpd1.length;

				if( flagCount != nUpdRecords )
					bUpd_status = false;
			}
			catch (Exception eeUpd)
			{
				bUpd_status = false;
			}

			if(psSelect != null) psSelect.close();
			if(psUpdate != null) psUpdate.close();
			if(psDelete != null) psDelete.close();
			if(ps != null) ps.close();
			if(psDelete_!=null)psDelete_.close();
			if(bUpd_status)
			{
				//tabdata = MessageManager.getMessage(con, "RECORD_INSERTED");
				errorMsg= getMessage(locale, "RECORD_INSERTED","CA");
				replaceString = new StringBuffer(errorMsg);
				cs = con.prepareCall("{call CA_REDEFINE_FORMULA_STRING(?,?,?)}");
				cs.setString(1,facilityId);
				cs.setString(2,encounterId);
				cs.setString(3,chartId);
				cs.execute();
				con.commit();

				if(cs!=null)cs.close();

				if((index=replaceString.toString().indexOf("<br>"))!=-1)
					replaceString=replaceString.replace(index,index+"<br>".length()," ");
				out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
				out.println("<script>window.returnValue='OK';</script>");
				out.println("<script>parent.window.close();</script>");
			}
			else
			{
				con.rollback();
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			try
			{
				if (con != null)
					con.rollback();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		finally
		{
			try
			{
				if(rsSelect != null) rsSelect.close();
				if(con != null)
					ConnectionManager.returnConnection(con);	
			}
			catch(Exception ee){ee.printStackTrace();}
		}
	}
 }
