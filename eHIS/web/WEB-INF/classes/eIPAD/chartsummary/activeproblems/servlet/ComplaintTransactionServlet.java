/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.activeproblems.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eCA.RecPatChiefComplaint.RecPatChiefComplaintHome;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.common.response.TransactionResponse;

/**
 * Servlet implementation class ComplaintTransactionServlet
 * Consumes the EJB RecPatChiefComplaintManager
 * Based on RecPatChiefComplaintServlet 
 */
public class ComplaintTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode;
		mode = request.getParameter("hdnMode") != null ? request.getParameter("hdnMode") : "";
		if(mode.equalsIgnoreCase("RECORD")){
			insert(request, response);
		}
		else if(mode.equalsIgnoreCase("MODIFY")){
			modify(request, response);
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	private void insert(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		RequestDispatcher rd;
		PatContext patientContext;
		
		HttpSession session = req.getSession(false);
		
		//if session is null forward to login page
		if(session == null){
			rd = getServletContext().getRequestDispatcher("/ipadlogin");
			rd.forward(req, res);	
		}
		patientContext = (PatContext)session.getAttribute("PatientContext");
		
		//if patientcontext in session returns null forward to IPlist page
		if(patientContext == null){
			rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/IPad.jsp");
			rd.forward(req, res);
		}
		ErrorInfo errorInfo;
		
		java.util.Properties p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		String locale = patientContext.getLocale();
		String client_ip_address = (String) p.getProperty("client_ip_address");
		String x_facility_id = patientContext.getFacilityId();
		String x_complaint_id = req.getParameter("hdnComplCode")==null?"":req.getParameter("hdnComplCode");
		String x_onset_date = req.getParameter("hdnOnsetDateTime")==null?"":req.getParameter("hdnOnsetDateTime");
		String x_remarks = req.getParameter("txtRemarks")==null?"":req.getParameter("txtRemarks");
		String eid = patientContext.getEncounterId();
		String x_complaint_details = req.getParameter("txtComplDesc")==null?"":req.getParameter("txtComplDesc");
		long x_encounter_id = Long.parseLong(eid);
		
		boolean inserted = false;
		TransactionResponse transactResp = new TransactionResponse();
		
		try{
			boolean local_ejbs = false;
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecPatChiefComplaint",RecPatChiefComplaintHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[9];
			argArray[0] = p;
			argArray[1] = x_facility_id;
			argArray[2] = new Long(x_encounter_id);
			argArray[3] = x_complaint_id;
			argArray[4] = x_onset_date;
			argArray[5] = x_remarks;
			argArray[6] = client_ip_address;
			argArray[7] = locale;
			argArray[8] = x_complaint_details;
			
			Class paramArray[] = new Class[9];
			paramArray[0] = p.getClass();
			paramArray[1] = x_facility_id.getClass();
			paramArray[2] = new Long(x_encounter_id).getClass();
			paramArray[3] = x_complaint_id.getClass();
			paramArray[4] = x_onset_date.getClass();
			paramArray[5] = x_remarks.getClass();
			paramArray[6] = client_ip_address.getClass();
			paramArray[7] = locale.getClass();
	        paramArray[8] = x_complaint_details.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertChiefComplaint",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			argArray = null; 
			paramArray = null;
			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		}
		catch(Exception e){
			inserted = false;
			transactResp.setTransactionResult(TransactionResponse.FAILURE);
			System.out.println("An exception occurred while adding adding a new allergy through eMR record adverse event EJB");
			e.printStackTrace();
		}
		
		if(inserted){
        	transactResp.setTransactionResult(TransactionResponse.SUCCESS);
        	errorInfo = new ErrorInfo();
        	errorInfo.setErrorType(Errors.COMMON_TRANSACTION_SUCCESS, locale);
        	transactResp.getErrorsList().add(errorInfo);
        }
        else{
        	transactResp.setTransactionResult(TransactionResponse.FAILURE);
        	errorInfo = new ErrorInfo();
        	errorInfo.setErrorType(Errors.COMMON_TRANSACTION_FAILURE, locale);
        	transactResp.getErrorsList().add(errorInfo);
        }
        req.setAttribute("TRANSACTION_RESPONSE", transactResp);
        
        rd = getServletContext().getRequestDispatcher("/mobile/chartsummary/ChartWidgetsView");
		rd.forward(req, res);
		
	}
	
	private void modify(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		RequestDispatcher rd;
		PatContext patientContext;
		
		HttpSession session = req.getSession(false);
		
		//if session is null forward to login page
		if(session == null){
			rd = getServletContext().getRequestDispatcher("/ipadlogin");
			rd.forward(req, res);	
		}
		patientContext = (PatContext)session.getAttribute("PatientContext");
		
		//if patientcontext in session returns null forward to IPlist page
		if(patientContext == null){
			rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/IPad.jsp");
			rd.forward(req, res);
		}
		ErrorInfo errorInfo;
		
		java.util.Properties p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		String locale = patientContext.getLocale();
		String client_ip_address = (String) p.getProperty("client_ip_address");
		String x_facility_id = req.getParameter("hdnComplFacility")==null?"":req.getParameter("hdnComplFacility");
		String x_complaint_id = req.getParameter("hdnComplCode")==null?"":req.getParameter("hdnComplCode");
		String x_onset_date = req.getParameter("hdnOnsetDateTime")==null?"":req.getParameter("hdnOnsetDateTime");
		String x_remarks = req.getParameter("txtRemarks")==null?"":req.getParameter("txtRemarks");
		String eid = req.getParameter("hdnComplEncounterId")==null?"":req.getParameter("hdnComplEncounterId");
		String x_complaint_details = req.getParameter("txtComplDesc")==null?"":req.getParameter("txtComplDesc");
		String err_remarks = req.getParameter("txtErrRemarks")==null?"":req.getParameter("txtErrRemarks");
		long x_encounter_id = Long.parseLong(eid);
		String x_error_yn = req.getParameter("hdnErrorYN")==null?"N":req.getParameter("hdnErrorYN");
		
		boolean inserted = false;
		TransactionResponse transactResp = new TransactionResponse();
		
		try{
			boolean local_ejbs = false;
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecPatChiefComplaint",RecPatChiefComplaintHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[11];
			argArray[0] = p;
			argArray[1] = x_facility_id;
			argArray[2] = new Long(x_encounter_id);
			argArray[3] = x_complaint_id;
			argArray[4] = x_onset_date;
			argArray[5] = x_remarks;
			argArray[6] = client_ip_address;
			argArray[7] = locale;
			argArray[8] = err_remarks;
            argArray[9] = x_complaint_details;
			argArray[10] = x_error_yn;
			
			Class paramArray[] = new Class[11];
			paramArray[0] = p.getClass();
			paramArray[1] = x_facility_id.getClass();
			paramArray[2] = new Long(x_encounter_id).getClass();
			paramArray[3] = x_complaint_id.getClass();
			paramArray[4] = x_onset_date.getClass();
			paramArray[5] = x_remarks.getClass();
			paramArray[6] = client_ip_address.getClass();
			paramArray[7] = locale.getClass();
			paramArray[8] = err_remarks.getClass();
			paramArray[9] = x_complaint_details.getClass();
			paramArray[10] = x_error_yn.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modifyChiefComplaint",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			argArray = null; 
			paramArray = null;
			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		}
		catch(Exception e){
			inserted = false;
			transactResp.setTransactionResult(TransactionResponse.FAILURE);
			System.out.println("An exception occurred while adding adding a new allergy through eMR record adverse event EJB");
			e.printStackTrace();
		}
		
		if(inserted){
        	transactResp.setTransactionResult(TransactionResponse.SUCCESS);
        	errorInfo = new ErrorInfo();
        	errorInfo.setErrorType(Errors.COMMON_TRANSACTION_SUCCESS, locale);
        	transactResp.getErrorsList().add(errorInfo);
        }
        else{
        	transactResp.setTransactionResult(TransactionResponse.FAILURE);
        	errorInfo = new ErrorInfo();
        	errorInfo.setErrorType(Errors.COMMON_TRANSACTION_FAILURE, locale);
        	transactResp.getErrorsList().add(errorInfo);
        }
        req.setAttribute("TRANSACTION_RESPONSE", transactResp);
        
        rd = getServletContext().getRequestDispatcher("/mobile/chartsummary/ChartWidgetsView");
		rd.forward(req, res);
	}

}
