/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.constants.*;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.common.response.TransactionResponse;
import java.util.*;
import webbeans.eCommon.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import eCA.ChartRecording.*;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class RecordVitals 
 */
public class RecordVitals extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordVitals() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out;
		java.util.Properties p;
		HttpSession session;
		out = response.getWriter();
		session = request.getSession(false);
		p = (java.util.Properties) session.getValue("jdbc");
		TransactionResponse oTransactionResponse = null;//insertRecord(request,out,p,session);
		try
		{
			 oTransactionResponse = insertRecord(request,out,p,session);
		}
		catch(Exception e)
		{
			System.out.println("An exception occurred while Recording Vitals");
			e.printStackTrace();
		}
		finally
		{
			request.setAttribute("TRANSACTION_RESPONSE", oTransactionResponse);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/mobile/chartsummary/ChartWidgetsView");
			if(rd != null)
				rd.forward(request, response);
		}
		
	}
	private TransactionResponse insertRecord(HttpServletRequest request, PrintWriter out, java.util.Properties p, HttpSession session)
	{
		    TransactionResponse transactResp = new TransactionResponse();
		    StringBuffer replaceString = null;
			Connection con = null;
			PreparedStatement pstmt=null;
			PreparedStatement pstmtSelect=null;
			CallableStatement cs = null;
			String sysdate = "";
			ResultSet rs=null;
			//List<String> oTransResultList = new ArrayList<String>();
			//p = (java.util.Properties) session.getValue("jdbc") ;
			String locale		= "en";//(String) p.getProperty("LOCALE");
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
			PatContext patientContext = null;
			String facilityId = "";
			String practitionerId = "";
			String encounterId = "";
			String addedById = "";
			if(session.getAttribute("PatientContext") != null)
			{
				patientContext = (PatContext)session.getAttribute("PatientContext");
				facilityId = patientContext.getFacilityId() == null ? "" : patientContext.getFacilityId() ;
				practitionerId = patientContext.getClinicianId() == null ? "" : patientContext.getClinicianId() ;
				encounterId = patientContext.getEncounterId() == null ? "" : patientContext.getEncounterId() ;
				addedById = patientContext.getLoggedInUser() == null ? "" : patientContext.getLoggedInUser() ;
				locale = patientContext.getLocale();
			}
			hashRecord.put("facilityId",facilityId);
			hashRecord.put("practitionerId",practitionerId);
			hashRecord.put("addedById",addedById);
			if(encounterId.equals("")) encounterId = "0";
			hashRecord.put("encounterId",encounterId);
			String function_from = request.getParameter("function_from")==null ? "" : request.getParameter("function_from");
			hashRecord.put("function_from",function_from);
			String addedAtWSNo = "IPAD";//p.getProperty("client_ip_address") ==null ? "" : p.getProperty("client_ip_address");
			hashRecord.put("addedAtWSNo",addedAtWSNo);
			String patientId = request.getParameter("hdnPatientId")==null ? "" :request.getParameter("hdnPatientId");
			hashRecord.put("patientId",patientId);
			String contr_mod_accession_num = request.getParameter("contr_mod_accession_num")==null ? "" :request.getParameter("contr_mod_accession_num");
			hashRecord.put("contr_mod_accession_num",contr_mod_accession_num);
			String module_id = request.getParameter("module_id")==null ? "" :request.getParameter("module_id");
			hashRecord.put("module_id",module_id);
			String patientClass =  request.getParameter("hdnPatientClass")==null ? "" : request.getParameter("hdnPatientClass");
			hashRecord.put("patientClass",patientClass);
			String chartId = request.getParameter("hdnChartId")==null ? "" :request.getParameter("hdnChartId");
			hashRecord.put("chartId",chartId);
			String recTime = com.ehis.util.DateUtils.getCurrentDate("DMYHM", locale);//request.getParameter("rec_time")==null ? "" : request.getParameter("rec_time");
			
			recTime		= com.ehis.util.DateUtils.convertDate(recTime,"DMYHM",locale,"en");
			hashRecord.put("recTime",recTime);
			
			String errorMsg = "";
			String count = request.getParameter("count") == null ? "0" : request.getParameter("count") ;
			int counter = Integer.parseInt(count);
			hashRecord.put("count",count);
			//boolean bTranResult = false;
			String bTranResult = "false";
			try
			{
				con  = ConnectionManager.getConnection(request);
				con.setAutoCommit(false);
				String query = "";
				String chartType = "";
				query = "SELECT SPL_CHART_TYPE FROM CA_CHART WHERE CHART_ID = ?";
				pstmtSelect = con.prepareStatement(query);
				if(pstmtSelect != null)
				{
					pstmtSelect.setString(1,chartId);
					rs = pstmtSelect.executeQuery();
				}
				if(rs != null)
				{
					while(rs.next())
					{
						chartType = rs.getString("SPL_CHART_TYPE") == null ? "" : rs.getString("SPL_CHART_TYPE");
					}
				}

				if(rs != null) rs.close();
				if(pstmtSelect != null) pstmtSelect.close();
				query = "";
				if(!function_from.equals("CP"))
				{
				query = "select 1  from CA_ENCNTR_DISCR_MSR a where  ENCOUNTER_ID=? and FACILITY_ID=? and CHART_ID =? and  TEST_OBSERV_DT_TM  >= to_date(?,'dd/mm/yyyy hh24:mi') and rownum=1 AND DISCR_MSR_RESULT_TYPE!='S' ";
//				union  select 1 from dual where to_date(?,'dd/mm/yyyy hh24:mi') > SYSDATE ) ";
				}
				else
				{
					query = " select 1  from CA_ENCNTR_DISCR_MSR a where  ENCOUNTER_ID=? and FACILITY_ID=? and CHART_ID =? and  TEST_OBSERV_DT_TM  = to_date(?,'dd/mm/yyyy hh24:mi') AND DISCR_MSR_RESULT_TYPE!='S' ";
				}
				
				
				pstmtSelect = con.prepareStatement(query);
				if(pstmtSelect != null)
				{
					pstmtSelect.setString(1,encounterId);
					pstmtSelect.setString(2,facilityId);
					pstmtSelect.setString(3,chartId);
					pstmtSelect.setString(4,recTime);
					rs= pstmtSelect.executeQuery();
				}
				if(rs != null)
				{
					while(rs.next())
					{
						flag=false;
						break;
					}
				}
				if(pstmtSelect !=null) pstmtSelect.close();
				if(rs != null)rs.close();
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
					else	if(disMsrResultType.equals("L"))	 
						{

								resultStr = request.getParameter("listItemValue"+i)==null ? "":request.getParameter("listItemValue"+i);
								if(resultStr.equals("------Select------")) resultStr = "";
								resultNum = request.getParameter("comp_"+i)==null ? "": request.getParameter("comp_"+i);
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
//						hashRecord.put("locale_"+i,locale);
						
					}//for
					boolean local_ejbs = false;
					ErrorInfo errorInfo;
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
						
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertChartRecords",
					paramArray)).invoke(busObj,argArray);


					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

					bool = ((Boolean)results.get("results")).booleanValue();
					//bTranResult = bool;
					
					if(!bool)
					{
						bTranResult = "false";
						transactResp.setTransactionResult(TransactionResponse.SUCCESS);
					    errorInfo = new ErrorInfo();
			        	errorInfo.setErrorType(Errors.COMMON_TRANSACTION_SUCCESS, locale);
			        	transactResp.getErrorsList().add(errorInfo);
					}
					else
					{
						bTranResult = "true";
						transactResp.setTransactionResult(TransactionResponse.FAILURE);
						errorInfo = new ErrorInfo();
			        	errorInfo.setErrorType(Errors.COMMON_TRANSACTION_FAILURE, locale);
			        	transactResp.getErrorsList().add(errorInfo);
					}
					
					//if(bTranResult == false)
					//int chk = 0 ;
					//int pi = 5/chk ;
					if(bool == false)	
					{
						try
						{
							if(chartType.equals("GR"))
							{
								cs = con.prepareCall("{call CABUILDSPLCHART.GR(?,?)}");
								cs.setString(1,patientId);
								cs.setString(2,chartId);
								cs.execute();

								con.commit();
								transactResp.setTransactionResult(TransactionResponse.SUCCESS);
								errorInfo = new ErrorInfo();
						        errorInfo.setErrorType(Errors.COMMON_TRANSACTION_SUCCESS, locale);
						        transactResp.getErrorsList().add(errorInfo);
							}					
						}
						catch (Exception proc)
						{
							//proc.printStackTrace(System.err);
							bTranResult = proc.toString();
							transactResp.setTransactionResult(TransactionResponse.FAILURE);
							errorInfo = new ErrorInfo();
				        	errorInfo.setErrorType(Errors.COMMON_TRANSACTION_FAILURE, locale);
				        	transactResp.getErrorsList().add(errorInfo);

						}
					}
				}// if flag == true

				

			}
			catch(Exception e)
			{
				
			}
			finally
			{
				
			}
			
			

			
		 
		 return transactResp;
		
	}

}
