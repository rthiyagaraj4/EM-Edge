/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        	Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?          		 created
11/07/2012     	IN033155            Chowminya G 	Incident No: IN033155 - <When record chart date/time before last recorded date/time that marked as error data, system did not 	allow to record new data  > 
23/05/2013      IN040163			Nijitha  S		ML-BRU-SCF-0856
28/03/2014	    IN047838		    Chowminya		AAKH-CRF-0010.1/01 - Chart cannot be recorded
21/05/2015		IN054842			Vijayakumar K	ML-BRU-SCF-1586 [IN:054842]
23/12/2019		IN071766			Ramesh G		ML-MMOH-SCF-1411
--------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;
import javax.naming.*;
import eCA.ChartRecording.*;
import javax.rmi.*;

public class ChartRecordingServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out;
		java.util.Properties p;
		HttpSession session;
		String sStyle = "";

		out = response.getWriter();
		session = request.getSession(false);

		sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		p = (java.util.Properties) session.getValue("jdbc") ;

		
			
		String sentFrom = request.getParameter("sentFrom") == null ? "" : request.getParameter("sentFrom");

		String outPut1 = "<html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link><script Language='JavaScript' src='../eCA/js/CAMessages.js'></script><script Language='JavaScript' src='../eCA/js/ChartRecording.js'></script><script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY CLASS='MESSAGE'>";
		String outPut2 = "</BODY></html>";
		out.println(outPut1);
		if(sentFrom.equals("amendError"))
			amendError(request,out,p,session);
		else
			insertRecord(request,out,p,session);
		out.println(outPut2);
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}

	private void insertRecord(HttpServletRequest request, PrintWriter out, java.util.Properties p, HttpSession session)
	{
		//Hashtable tabdata = null;
		StringBuffer replaceString = null;
		Connection con = null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmtSelect=null;
		CallableStatement cs = null;
		String sysdate = "";
		ResultSet rs=null;
		p = (java.util.Properties) session.getValue("jdbc") ;
		String locale		= (String) p.getProperty("LOCALE");
		HashMap hashRecord = new HashMap();
		boolean bool = false;
		String disMsrId = "", disMsrResultType = "",  uom = "", normalLow = "",normalHigh = "",criticalLow = "",criticalHigh = "",normalAbnormalInd ="",chartGrpId = "",resultNum="",resultStr="",result_prefix="", remarks="";
		boolean flag=true;
		String taskSrlNo = request.getParameter("taskSrlNo") == null ? "" : request.getParameter("taskSrlNo");
		if(taskSrlNo.equals("null"))
		taskSrlNo = "";
		hashRecord.put("taskSrlNo",taskSrlNo);
		String taskCode = request.getParameter("taskCode") == null ? "" : request.getParameter("taskCode");
		if(taskCode.equals("null"))
		taskCode = "";
		hashRecord.put("taskCode",taskCode);
		String facilityId = (String)	session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
		hashRecord.put("facilityId",facilityId);
		String practitionerId = (String)	session.getValue("ca_practitioner_id")==null ? "" :(String)	session.getValue("ca_practitioner_id");
		//hashRecord.put("practitionerId",practitionerId); //IN071766
		String function_from = request.getParameter("function_from")==null ? "" : request.getParameter("function_from");
		hashRecord.put("function_from",function_from);
		String addedById   = p.getProperty( "login_user" )==null ? "" :p.getProperty( "login_user" ) ;
		hashRecord.put("addedById",addedById);
		String addedAtWSNo = p.getProperty("client_ip_address") ==null ? "" : p.getProperty("client_ip_address");
		hashRecord.put("addedAtWSNo",addedAtWSNo);
		String encounterId = request.getParameter("episode_id")==null ? "0" :request.getParameter("episode_id");
		if(encounterId.equals("")) encounterId = "0";
		hashRecord.put("encounterId",encounterId);
		String patientId = request.getParameter("patient_id")==null ? "" :request.getParameter("patient_id");
		hashRecord.put("patientId",patientId);

		String contr_mod_accession_num = request.getParameter("contr_mod_accession_num")==null ? "" :request.getParameter("contr_mod_accession_num");
		hashRecord.put("contr_mod_accession_num",contr_mod_accession_num);
		String module_id = request.getParameter("module_id")==null ? "" :request.getParameter("module_id");
		hashRecord.put("module_id",module_id);

		String patientClass = request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class");
		hashRecord.put("patientClass",patientClass);
		String chartId = request.getParameter("chart_id")==null ? "" :request.getParameter("chart_id");
		hashRecord.put("chartId",chartId);
		String recTime = request.getParameter("rec_time")==null ? "" : request.getParameter("rec_time");
		
		recTime		= com.ehis.util.DateUtils.convertDate(recTime,"DMYHM",locale,"en");
		hashRecord.put("recTime",recTime);

		String errorMsg = "";
		String count = request.getParameter("count") == null ? "0" : request.getParameter("count") ;
		int counter = Integer.parseInt(count);
		hashRecord.put("count",count);

		try
		{
			con  = ConnectionManager.getConnection(request);
			con.setAutoCommit(false);
			String query = "";
			
			/*******ADDED BY Deepa on 11/16/2009 at 3:00 PM for IN016097**************************/
			String chartType = "";
			
			query = "SELECT SPL_CHART_TYPE FROM CA_CHART WHERE CHART_ID = ?";
			pstmtSelect = con.prepareStatement(query);
			pstmtSelect.setString(1,chartId);
			rs = pstmtSelect.executeQuery();
			while(rs.next())
			{
				chartType = rs.getString("SPL_CHART_TYPE") == null ? "" : rs.getString("SPL_CHART_TYPE");
			}

			if(rs != null) rs.close();
			if(pstmtSelect != null) pstmtSelect.close();
			query = "";

			/*******ADDED BY Deepa on 11/16/2009 at 3:00 PM for IN016097**************************/
			//Added error check Condition --[IN033155]
			//IN054842 starts
			/*if(!function_from.equals("CP"))
			{
				query = "select 1  from CA_ENCNTR_DISCR_MSR a where  ENCOUNTER_ID=? and FACILITY_ID=? and CHART_ID =? and  TEST_OBSERV_DT_TM  >= to_date(?,'dd/mm/yyyy hh24:mi') and rownum=1 AND DISCR_MSR_RESULT_TYPE!='S' AND ERROR_YN is null"; 
				//union  select 1 from dual where to_date(?,'dd/mm/yyyy hh24:mi') > SYSDATE ) ";
			}
			else
			{
				query = " select 1  from CA_ENCNTR_DISCR_MSR a where  ENCOUNTER_ID=? and FACILITY_ID=? and CHART_ID =? and  TEST_OBSERV_DT_TM  = to_date(?,'dd/mm/yyyy hh24:mi') AND DISCR_MSR_RESULT_TYPE!='S' AND ERROR_YN is null";
			}
			*/
			query = "select 1  from CA_ENCNTR_DISCR_MSR a where  ENCOUNTER_ID=? and FACILITY_ID=? and CHART_ID =? and  TEST_OBSERV_DT_TM  >= to_date(?,'dd/mm/yyyy hh24:mi') and rownum=1 AND DISCR_MSR_RESULT_TYPE!='S' AND ERROR_YN is null";
			//IN054842 ends
			
			pstmtSelect = con.prepareStatement(query);
			pstmtSelect.setString(1,encounterId);
			pstmtSelect.setString(2,facilityId);
			pstmtSelect.setString(3,chartId);
			pstmtSelect.setString(4,recTime);
			/*
			if(!function_from.equals("CP"))
			{
				pstmtSelect.setString(5,recTime);
			}
			*/
			rs= pstmtSelect.executeQuery();
			while(rs.next())
			{
				flag=false;
				break;
			}
			if(pstmtSelect !=null) pstmtSelect.close();
			if(rs != null)rs.close();
			// IN071766 Start.
			if("".equals(practitionerId)){
				query = "SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE FUNC_ROLE='P' AND  APPL_USER_ID=?";
				pstmtSelect = con.prepareStatement(query);
				pstmtSelect.setString(1,addedById);
				rs= pstmtSelect.executeQuery();
				while(rs.next())
				{
					practitionerId=rs.getString(1)==null ? "" :(String)rs.getString(1);
				}
				if(pstmtSelect !=null) pstmtSelect.close();
				if(rs != null)rs.close();
			}
			hashRecord.put("practitionerId",practitionerId);
			// IN071766 End.
			sysdate = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			if(flag==true)
			{
				for(int i=0;i<counter;i++)
				{
					resultStr="";
					resultNum="";
					disMsrResultType = request.getParameter("dis_msr_type_"+i)==null ? "":request.getParameter("dis_msr_type_"+i);

					hashRecord.put("dis_msr_type_"+i,disMsrResultType);
					if(disMsrResultType.equals("N")||disMsrResultType.equals("A")||disMsrResultType.equals("S")||disMsrResultType.equals("I"))	 
					{
						resultNum = request.getParameter("comp_"+i)==null ? "":request.getParameter("comp_"+i);
						hashRecord.put("comp_"+i,resultNum);
						result_prefix = request.getParameter("result_prefix"+i)==null ? "":request.getParameter("result_prefix"+i);
						hashRecord.put("result_prefix"+i,result_prefix);
					}
					else if(disMsrResultType.equals("L"))	 
					{

						resultStr = request.getParameter("listItemValue"+i)==null ? "":request.getParameter("listItemValue"+i);
						if(resultStr.equals("------Select------")) resultStr = "";
						resultNum = request.getParameter("comp_"+i)==null ? "": request.getParameter("comp_"+i);
						/*//IN040163 Starts
						if("0".equals(resultNum))
						resultNum="";
						//IN040163 Ends fix given in chartrecording.js*/
						hashRecord.put("comp_"+i,resultNum);	
						hashRecord.put("listItemValue"+i,resultStr);
					}
					else
					{
						resultStr = request.getParameter("comp_"+i)==null ? "": request.getParameter("comp_"+i);

						if(disMsrResultType.equals("D") )	 
							resultStr = com.ehis.util.DateUtils.convertDate(resultStr,"DMY",locale,"en");
						else if(disMsrResultType.equals("E") )	 
							resultStr = com.ehis.util.DateUtils.convertDate(resultStr,"DMYHM",locale,"en");

						hashRecord.put("comp_"+i,resultStr);	
					}
					disMsrId = request.getParameter("dis_msr_id_"+i)==null ? "":request.getParameter("dis_msr_id_"+i) ;
					hashRecord.put("dis_msr_id_"+i,disMsrId);	
					uom = request.getParameter("uom_"+i)==null ? "":request.getParameter("uom_"+i);
					hashRecord.put("uom_"+i,uom);	
					normalLow = request.getParameter("normal_low_"+i)==null ? "": request.getParameter("normal_low_"+i);
					hashRecord.put("normal_low_"+i,normalLow);	
					normalHigh = request.getParameter("normal_high_"+i)==null ? "":request.getParameter("normal_high_"+i);
					hashRecord.put("normal_high_"+i,normalHigh);	
					criticalLow = request.getParameter("critical_low_"+i)==null ? "":request.getParameter("critical_low_"+i);
					hashRecord.put("critical_low_"+i,criticalLow);	
					criticalHigh = request.getParameter("critical_high_"+i)==null ? "":request.getParameter("critical_high_"+i);
					hashRecord.put("critical_high_"+i,criticalHigh);	
					normalAbnormalInd = request.getParameter("normal_abnormal_ind_"+i)==null ? "":request.getParameter("normal_abnormal_ind_"+i);
					hashRecord.put("normal_abnormal_ind_"+i,normalAbnormalInd);	
					chartGrpId = request.getParameter("chat_grp_id_"+i)==null ? "":request.getParameter("chat_grp_id_"+i);
					hashRecord.put("chat_grp_id_"+i,chartGrpId);
					remarks = request.getParameter("remarksField"+i)==null ? "":request.getParameter("remarksField"+i);
					hashRecord.put("remarksField"+i,remarks);
//					hashRecord.put("locale_"+i,locale);
					
				}
				boolean local_ejbs = false;
		
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ChartRecording",ChartRecordingManager.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
				Object argArray[] = new Object[3];

				argArray[0] = p;
				argArray[1] = hashRecord;
				argArray[2] = locale;

				Class paramArray[] = new Class[3];

				paramArray[0] = p.getClass();
				paramArray[1] = hashRecord.getClass();;
				paramArray[2] = locale.getClass();
				
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertChartRecords",paramArray)).invoke(busObj,argArray);


				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				bool = ((Boolean)results.get("results")).booleanValue();
			
				if(bool==false)
				{
					try
					{
						//tabdata = MessageManager.getMessage(con, "RECORD_INSERTED");
						int index=0;
						errorMsg= getMessage(locale, "RECORD_INSERTED","CA");
						replaceString = new StringBuffer(errorMsg);
						if((index=replaceString.toString().indexOf("<br>"))!=-1)
						{
							replaceString=replaceString.replace(index,index+"<br>".length()," ");
						}
						
						out.println("<script>alert('"+replaceString.toString()+"')</script>");
				  	
						out.println("<script>"); 	
						if(!function_from.equals("CP"))
						{
							if(!function_from.equals("SECONDARY_TRIAGE"))
							{	
								if(function_from.equals("AE"))
								{
									out.println("parent.ChartRecordingCriteriaFrame.document.forms[0].rec_time.value='"+sysdate+"'");
									out.println("parent.ChartRecordingCriteriaFrame.document.forms[0].systime.value='"+sysdate+"'");
									out.println("parent.ChartRecordingCriteriaFrame.loadChart(parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.chart_id,'fromservlet')");							
									out.println("parent.ChartRecordingToolBarFrame.document.F.record.disabled=false"); 	
						
								}
								else
								{
									out.println("top.content.workAreaFrame.ChartRecordingCriteriaFrame.document.forms[0].rec_time.value='"+sysdate+"'");
									out.println("top.content.workAreaFrame.ChartRecordingCriteriaFrame.document.forms[0].systime.value='"+sysdate+"'");
									out.println("top.content.workAreaFrame.ChartRecordingCriteriaFrame.loadChart(top.content.workAreaFrame.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.chart_id,'fromservlet')");
									out.println("top.content.workAreaFrame.ChartRecordingToolBarFrame.document.F.record.disabled=false"); 
									//out.println("top.content.workAreaFrame.ChartRecordingCriteriaFrame.document.forms(0).summaryText.value=1"); 
								}
							}
							else if(function_from.equals("SECONDARY_TRIAGE"))
							{			
								out.println("var dialogFrame = top.document.getElementById('dialog-body') ? top.document.querySelectorAll('#dialog-body')[ top.document.querySelectorAll('#dialog-body').length - 1].contentWindow : parent ;");
								out.println("dialogFrame.ChartRecordingDetailFrame.document.getElementById('detDate').value='" + sysdate + "';");
								out.println("window.close();");
							}

						}
						else
						{
							out.println("parent.ChartRecordingDetailFrame.document.forms[0].reset();"); 	
							out.println("parent.ChartRecordingCriteriaFrame.SearchChart('servlet','0','servlet');"); 			
							out.println("parent.ChartRecordingToolBarFrame.document.F.record.disabled=false"); 	
							out.println("parent.ChartRecordingCriteriaFrame.document.forms[0].rec_time.value='"+sysdate+"'");
							//out.println("parent.ChartRecordingCriteriaFrame.document.forms(0).summaryText.value=1"); 

							out.println("window.close();"); 	
						}
						out.println("</script>"); 	
					}
					catch(Exception ee)
					{
						out.println("Exception from Chart Recording Servlet :"+ee.toString());
					}

				/*******ADDED BY Deepa on 11/16/2009 at 3:00 PM for IN016097**************************/	
					try
					{
						if(chartType.equals("GR"))
						{
							cs = con.prepareCall("{call CABUILDSPLCHART.GR(?,?)}");
							cs.setString(1,patientId);
							cs.setString(2,chartId);
							cs.execute();

							con.commit();
						}					
					}
					catch (Exception proc)
					{
						proc.printStackTrace(System.err);
					}
			/*******ADDED BY Deepa on 11/16/2009 at 3:00 PM for IN016097**************************/
				}
				else
				{
					//tabdata = MessageManager.getMessage(con, "CONTACT_ADMIN");
					int index=0;
					errorMsg= getMessage(locale, "FAILED_TRANSACTION","CA");
					if (errorMsg==null)
					{
						errorMsg="FAILED_TRANSACTION";
					}
					replaceString = new StringBuffer(errorMsg);
					if((index=replaceString.toString().indexOf("<br>"))!=-1)
					{
						replaceString=replaceString.replace(index,index+"<br>".length()," ");
					}	
					out.println("<script>alert('"+replaceString.toString()+"')</script>");

					try
					{
						con.rollback();
					}
					catch(Exception ee){
					}
				}
			}
			else
			{
				int index = 0;	
				//tabdata = MessageManager.getMessage(locale,"DUP_ENT_NOT_ALLOWED","CA");
				String errorForCA = getMessage(locale,"CHART_LESS_PREV_REC","CA");
				if (errorForCA==null)
				{
					errorForCA="CHART_LESS_PREV_REC";
				}
				replaceString = new StringBuffer(errorForCA);
				if((index=replaceString.toString().indexOf("<br>"))!=-1)
				{
					replaceString=replaceString.replace(index,index+"<br>".length()," ");
				}
				out.println("<script>alert('"+replaceString.toString()+"')");
				if(!function_from.equals("CP"))
				{
				
					if(!function_from.equals("SECONDARY_TRIAGE"))
					{
						//IN047838 Added condition for AE
						if(function_from.equals("AE"))
						{
							out.println("parent.ChartRecordingCriteriaFrame.document.forms[0].rec_time.value='"+sysdate+"'");
							out.println("parent.ChartRecordingCriteriaFrame.document.forms[0].systime.value='"+sysdate+"'");
							out.println("parent.ChartRecordingCriteriaFrame.document.forms[0].toDate.value='"+sysdate+"'");
							out.println("parent.ChartRecordingToolBarFrame.document.F.record.disabled=false"); 
					
						}
						else
						{
							out.println("top.content.workAreaFrame.ChartRecordingCriteriaFrame.document.forms[0].rec_time.value='"+sysdate+"'");
							out.println("top.content.workAreaFrame.ChartRecordingCriteriaFrame.document.forms[0].systime.value='"+sysdate+"'");
							out.println("top.content.workAreaFrame.ChartRecordingCriteriaFrame.document.forms[0].toDate.value='"+sysdate+"'");
							out.println("top.content.workAreaFrame.ChartRecordingToolBarFrame.document.F.record.disabled=false");
						}
					}		
				}
				else
				{
					//IN054842 starts
					out.println("parent.ChartRecordingCriteriaFrame.document.forms[0].rec_time.value='"+sysdate+"'");
					out.println("parent.ChartRecordingCriteriaFrame.document.forms[0].systime.value='"+sysdate+"'");
					out.println("parent.ChartRecordingCriteriaFrame.document.forms[0].toDate.value='"+sysdate+"'");
					//IN054842 ends
					out.println("parent.ChartRecordingToolBarFrame.document.F.record.disabled=false"); 	
				}
				out.println("</script>");
			}
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
			}
			catch(Exception ee)
			{}
			e.printStackTrace(System.err);
			out.println("Exception in try2 of ChartRecordingServlet.java" +e.toString());
		}
		finally
		{
			try
			{
				if(rs!=null)rs.close();
				if(cs!=null)cs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)
					ConnectionManager.returnConnection(con,p);
			}
			catch(Exception e)
			{}
		}
		
		hashRecord.clear();
	}

	private void amendError(HttpServletRequest request, PrintWriter out, java.util.Properties p, HttpSession session)
	{
		Connection con = null;
		PreparedStatement pstmtSelect = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		StringBuffer replaceString = null;
		String count = request.getParameter("numOfRecs") == null ? "0" : request.getParameter("numOfRecs"); 
		String chartId = request.getParameter("chartId") == null ? "" : request.getParameter("chartId");
		String contr_mod_accession_num = request.getParameter("contr_mod_accession_num") == null ? "" : request.getParameter("contr_mod_accession_num");
		String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
		String recDatime = request.getParameter("recordedDatime") == null ? "" : request.getParameter("recordedDatime");
		String function_from = request.getParameter("functionFrom")==null ? "" : request.getParameter("functionFrom");

		String facilityId = (String)	session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
		String encounterId = request.getParameter("encounter_id") == null ? "0" : request.getParameter("encounter_id");
		if(encounterId.equals("")) encounterId = "0";
		String patientId = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String practitionerId = (String)	session.getValue("ca_practitioner_id")==null ? "" :(String)	session.getValue("ca_practitioner_id");
		String errorMarkedByID = request.getParameter("userIDHidden") == null ? "" : request.getParameter("userIDHidden");
		String patientClass = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");

		String addedById   = p.getProperty( "login_user" )==null ? "" :p.getProperty( "login_user" ) ;

		String addedAtWSNo = p.getProperty("client_ip_address") ==null ? "" : p.getProperty("client_ip_address");
		p = (java.util.Properties) session.getValue("jdbc") ;
		String locale		= (String) p.getProperty("LOCALE");

		int cnt = Integer.parseInt(count);
		int i = 0;
		boolean bool = false;

		String discrMsrId = "";
		String discrMsrGrpId = "";
		String discrMsrType = "";
		String errorYN = "";
		String objectValue = "";
		String accessionNum = "";
		String resultStr = "";
		String resultNum = "";
		String errorRemarks = "";
		String resultUOM = "";
		String normalLow = "";
		String normalHigh = "";
		String criticalLow = "";
		String criticalHigh = "";
		String normAbnomInd = "";
		String resStrForList = "";
		String grpDiscrMsrIds = "";
		String result_prefix = "";
		String query = "";
		String chartType = "";

		HashMap valuesMap = new HashMap();

		try
		{
			/*******ADDED BY Deepa on 11/16/2009 at 3:00 PM for IN016097**************************/
			con  = ConnectionManager.getConnection(request);
			con.setAutoCommit(false);
				
			query = "SELECT SPL_CHART_TYPE FROM CA_CHART WHERE CHART_ID = ?";
			pstmtSelect = con.prepareStatement(query);
			pstmtSelect.setString(1,chartId);
			rs = pstmtSelect.executeQuery();
			while(rs.next())
			{
				chartType = rs.getString("SPL_CHART_TYPE") == null ? "" : rs.getString("SPL_CHART_TYPE");
			}

			if(rs != null) rs.close();
			if(pstmtSelect != null) pstmtSelect.close();
			query = "";
			
			/*******ADDED BY Deepa on 11/16/2009 at 3:00 PM for IN016097**************************/

			valuesMap.put("recordedDatime",recDatime);
			valuesMap.put("chartId",chartId);
			valuesMap.put("contr_mod_accession_num",contr_mod_accession_num);
			valuesMap.put("module_id",module_id);
			valuesMap.put("count",count);
			valuesMap.put("facilityId",facilityId);
			valuesMap.put("encounterId",encounterId);
			valuesMap.put("patientId",patientId);
			valuesMap.put("patientClass",patientClass);
			valuesMap.put("practitionerId",practitionerId);
			valuesMap.put("addedById",addedById);
			valuesMap.put("errorMarkedByID",errorMarkedByID);
			valuesMap.put("addedAtWSNo",addedAtWSNo);
			//valuesMap.put("locale",locale);

			for(i=0;i<cnt;i++)
			{
				resultStr = "";
				resultNum = "";
				resStrForList = "";

				grpDiscrMsrIds = request.getParameter("grpDiscrMsrIds"+i) == null ? "" : request.getParameter("grpDiscrMsrIds"+i);
				discrMsrId = request.getParameter("discrMsrHidden"+i) == null ? "" : request.getParameter("discrMsrHidden"+i);
				discrMsrGrpId = request.getParameter("discrGrpHidden"+i) == null ? "" : request.getParameter("discrGrpHidden"+i);
				discrMsrType = request.getParameter("discrTypeHidden"+i) == null ? "" : request.getParameter("discrTypeHidden"+i);
				if(discrMsrType.equals("A"))
				{
					objectValue = request.getParameter("formulaObjectName"+grpDiscrMsrIds) == null ? "" : request.getParameter("formulaObjectName"+grpDiscrMsrIds);
				}
				else
				{
					objectValue = request.getParameter("objectName"+i) == null ? "" : request.getParameter("objectName"+i);
				}

				errorYN = request.getParameter("errorYN"+i) == null ? "" : request.getParameter("errorYN"+i);
				
				accessionNum = request.getParameter("accessNumHidden"+i) == null ? "" : request.getParameter("accessNumHidden"+i);
				if(!discrMsrType.equals("A"))
				{
					errorRemarks = request.getParameter("remarksHidden"+i) == null ? "" : request.getParameter("remarksHidden"+i);
				}
				else if(discrMsrType.equals("A"))
				{
					errorRemarks = "Formula Member(s) has/have been modified.";
				}
				resultUOM = request.getParameter("discrUOMHidden"+i) == null ? "" : request.getParameter("discrUOMHidden"+i);
				normalLow = request.getParameter("normalLow"+i) == null ? "" : request.getParameter("normalLow"+i);
				normalHigh = request.getParameter("normalHigh"+i) == null ? "" : request.getParameter("normalHigh"+i);
				criticalLow = request.getParameter("criticalLow"+i) == null ? "" : request.getParameter("criticalLow"+i);
				criticalHigh = request.getParameter("criticalHigh"+i) == null ? "" : request.getParameter("criticalHigh"+i);
				normAbnomInd = request.getParameter("normal_abnormal_ind_"+i) == null ? "" : request.getParameter("normal_abnormal_ind_"+i);
				resStrForList = request.getParameter("listStringValue"+i) == null ? "" : request.getParameter("listStringValue"+i);


				if(discrMsrType.equals("N") || discrMsrType.equals("A") || discrMsrType.equals("S") || discrMsrType.equals("I"))
				{
					resultNum = objectValue;
					result_prefix = request.getParameter("result_prefix"+i)==null ? "":request.getParameter("result_prefix"+i);
				}
				else if(discrMsrType.equals("L"))
				{
					resultNum = objectValue;
					resultStr = resStrForList;
					if(resultNum.equals("''")) resultNum = "";
				}
				else if(discrMsrType.equals("C"))
				{
					if(errorYN.equals("R"))
					{
						if(objectValue == null || objectValue.equals(""))
						{
							resultStr = "N";
							resultNum = "";
						}
						else
						{
							resultStr = "Y";
							resultNum = "";
						}
					}
				}
				else
				{
					resultStr = objectValue;
					
					if(discrMsrType.equals("D"))
						resultStr = com.ehis.util.DateUtils.convertDate(resultStr,"DMY",locale,"en");
					else if(discrMsrType.equals("E"))
						resultStr = com.ehis.util.DateUtils.convertDate(resultStr,"DMYHM",locale,"en");

				}

				valuesMap.put("error_remarks_"+i,errorRemarks);
				valuesMap.put("resultNum_"+i,resultNum);
				valuesMap.put("resultStr_"+i,resultStr);
				valuesMap.put("discrMsrType_"+i,discrMsrType);
				valuesMap.put("discrMsrId_"+i,discrMsrId);
				valuesMap.put("discrMsrGrpId_"+i,discrMsrGrpId);
				valuesMap.put("errorYN_"+i,errorYN);
				valuesMap.put("accessionNum_"+i,accessionNum);
				valuesMap.put("resultUOM_"+i,resultUOM);
				valuesMap.put("normalLow_"+i,normalLow);
				valuesMap.put("normalHigh_"+i,normalHigh);
				valuesMap.put("criticalLow_"+i,criticalLow);
				valuesMap.put("criticalHigh_"+i,criticalHigh);
				valuesMap.put("normAbnomInd_"+i,normAbnomInd);
				valuesMap.put("result_prefix"+i,result_prefix);
			}

			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ChartRecording",ChartRecordingManager.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[3];

			argArray[0] = p;
			argArray[1] = valuesMap;
			argArray[2] = locale;

			Class paramArray[] = new Class[3];

			paramArray[0] = p.getClass();
			paramArray[1] = valuesMap.getClass();
			paramArray[2] = locale.getClass();
				
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("amendErrorChartRecords",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			bool = (!((Boolean)results.get("results")).booleanValue()) ? false : ((Boolean)results.get("results")).booleanValue();
			String errorMsg = "";

			if(bool)
			{
				try
				{
					int index=0;
					errorMsg= (String) results.get("message");
					if (errorMsg==null)
					{
						errorMsg="";
					}
					replaceString = new StringBuffer(errorMsg);
					if((index=replaceString.toString().indexOf("<br>"))!=-1)
					{
						replaceString=replaceString.replace(index,index+"<br>".length()," ");
					}	
					out.println("<script>alert('"+replaceString.toString()+"')</script>");				  	
					if(!function_from.equals("SECONDARY_TRIAGE"))
					{
						if(!function_from.equals("CP"))
						{
							//IN047838 added condition for AE
							if(function_from.equals("AE")){
								out.println("<script>parent.chartRecordingFrameSet.rows='28%,7%,75%,4%,0%,0%';	parent.AEID.cols = '45%,50%';	parent.colBarID.cols = '45%,50%';</script>");
								out.println("<script>parent.ChartRecordingCriteriaFrame.loadChart(parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.chart_id,'fromservlet');</script>");
							}else{
								out.println("<script>top.content.workAreaFrame.chartRecordingFrameSet.rows='28%,7%,75%,4%,0%,0%';	top.content.workAreaFrame.AEID.cols = '45%,50%';	top.content.workAreaFrame.colBarID.cols = '45%,50%';</script>");
								out.println("<script>top.content.workAreaFrame.ChartRecordingCriteriaFrame.loadChart(top.content.workAreaFrame.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.chart_id,'fromservlet');</script>");
							}
						}
						else if(function_from.equals("CP"))
						{
							out.println("<script>parent.chartRecordingFrameSet.rows='28%,7%,75%,4%,0%,0%';	parent.AEID.cols = '45%,50%';	parent.colBarID.cols = '45%,50%';</script>");
							out.println("<script>parent.ChartRecordingCriteriaFrame.loadChart(parent.ChartRecordingCriteriaFrame.document.ChartLayoutCriteriaForm.chart_id,'fromservlet');</script>");
						}
					}					
				}
				catch(Exception excep)
				{
					excep.printStackTrace(System.err);
				}
				/*******ADDED BY Deepa on 11/16/2009 at 3:00 PM for IN016097**************************/
				try
				{
					if(chartType.equals("GR"))
					{
						cs = con.prepareCall("{call CABUILDSPLCHART.GR(?,?)}");
						cs.setString(1,patientId);
						cs.setString(2,chartId);
						cs.execute();

						con.commit();
					}					
				}
				catch (Exception proc)
				{
					proc.printStackTrace(System.err);
				}
			/*******ADDED BY Deepa on 11/16/2009 at 3:00 PM for IN016097**************************/
			}
			else
			{
				int index=0;
				errorMsg= (String) results.get("error");
				if (errorMsg==null)
				{
					errorMsg="";
				}
				replaceString = new StringBuffer(errorMsg);
				if((index=replaceString.toString().indexOf("<br>"))!=-1)
				{
					replaceString=replaceString.replace(index,index+"<br>".length()," ");
				}	
				out.println("<script>alert('"+replaceString.toString()+"')</script>");				  	
				out.println("<script>"); 	
			}
			results.clear();
		}
		catch(Exception e)
		{
			try{
			con.rollback();
			}catch(Exception ee)
			{}
			e.printStackTrace(System.err);
		}
		finally
		{
			try{
			if(rs != null)rs.close();
			if(cs != null)cs.close();
			if(con != null)
				ConnectionManager.returnConnection(con,p);
			}
			catch(Exception e)
			{}
		}
		valuesMap.clear();
	}
}
