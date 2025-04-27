/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import eBL.reprintreport.bc.ReprintReportBC;
import eBL.reprintreport.request.ReprintRequest;
import eBL.reprintreport.response.ReprintResponse;

/**
 * Reprint Report Servlet which routes the Request to Reprint Rpeort BC
 * @author Rajesh V 
 *
 */
public class ReprintReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	java.util.Properties p;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReprintReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * From this method ReprintRequest Object is passed to ReprintReportBC and inturn
	 * ReprintResponse Object is recieved. Based on the response, a jsonObject is sent to
	 * the Script which initated ajax call
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		String siteSpecAuditReportYN = request.getParameter("siteSpecAuditReportYN"); //Added V20180727-Subha/ML-MMOH-CRF-1173/
		System.err.println("Reached Reprint Report Servlet");
		HttpSession session = request.getSession(false);
		String locale = "";
		/* V12122017 Rajesh V Modified for MMS-QH-CRF-0208.1
		 * Commented below logic of taking from session and getting from request
		 */
		locale = request.getParameter("hdrLocale");
		if(locale == null){
			locale	= "en";
		}
		/*if(session != null){
			locale = (String)session.getAttribute("LOCALE");
		}
		else{
			locale	= "en";
		}*/
		
		/*Added by Karthik to include login user in Param 17 */
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_user = this.p.getProperty( "login_user" ) ;
		 
		ReprintRequest mainRequest = new ReprintRequest();
		ReprintResponse mainResponse = null;
		List<ReprintRequest> requestList = new ArrayList<ReprintRequest>();
		ReprintRequest bean = null;
		ReprintReportBC reprintBC = null;
		JsonObject jsonObj = new JsonObject();
		PrintWriter out = response.getWriter();
		if("insertSyProgBulk".equals(mode)){
			int lastRow = 0;
			try{
				String reportId = request.getParameter("billType");
				String payer_type=request.getParameter("payer_type");
				String facilityId = request.getParameter("facilityId");
				String detailed_YN =request.getParameter("detailed_yn");
				String param16=request.getParameter("param16");
				String report_type=request.getParameter("report_type");
				lastRow = Integer.parseInt(request.getParameter("lastRowIndex"));
				for(int i=0;i<=lastRow;i++){
					String docNum = request.getParameter("doc_num"+i);
					String episode_id=request.getParameter("episode_id");
					System.out.println("episode_id:::::"+episode_id);
					if(docNum != null && !"".equals(docNum)){
						bean = new ReprintRequest();						
						bean.setParam1(request.getParameter("doc_typ_code"+i));
						bean.setParam2(request.getParameter("doc_typ_code"+i));
						bean.setParam3(request.getParameter("doc_num"+i));
						bean.setParam4(request.getParameter("doc_num"+i));
						bean.setParam5("");
						bean.setParam6(detailed_YN);		//bill_print_flag replaced detailed_YN - detailed bill format YN
						bean.setParam7("R");					
						if(payer_type.equals("B") && report_type.equals("R"))
						{
							System.out.println("inside if"+payer_type);
						bean.setParam8(locale);
						}
						else
						{
							System.out.println("inside else"+payer_type);
							bean.setParam8(payer_type);	
						}
						bean.setParam14(request.getParameter("episode_type"+i));
						bean.setParam15(request.getParameter("episode_id"+i));
						if(param16.equals("I") || param16.equals("D") )
						{
							bean.setParam16("BILL-MAINTANANCE");
						}
						else
						{
						bean.setParam16("Y");
						}
						bean.setFacilityId(facilityId);
						bean.setReportId(reportId);
						bean.setParam17(login_user);
						//Added V20180720-Subha/ML-MMOH-CRF-1173/Starts

						if((!("null".equals(siteSpecAuditReportYN))) && "Y".equals(siteSpecAuditReportYN)) {
						
							bean.setParam20("EBL_TRANS_SETL_REPRNT");
						}
						//Added V20180720-Subha/ML-MMOH-CRF-1173/Ends
						requestList.add(bean);
					}					
				}
				mainRequest.setRequestList(requestList);
				reprintBC = new ReprintReportBC();
				mainResponse = reprintBC.insertToProgParamBulk(mainRequest);
				if(mainResponse.isStatus()){
					//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( "APP-SM0070 Operation Completed Successfully ....","UTF-8" ) +"&err_value="+"1");
					jsonObj.addProperty("Success", "Y");
					jsonObj.addProperty("sessionId", mainResponse.getSessionId());
					jsonObj.addProperty("pgmDate", mainResponse.getPgmDate());
					jsonObj.addProperty("locale", locale);
					out.println(jsonObj);
				}
				else{
					//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(mainResponse.getError(),"UTF-8" ) +"&err_value="+"2");
					jsonObj.addProperty("Success","N");
					jsonObj.addProperty("errorMessage", mainResponse.getError());
					out.println(jsonObj);
				}
				
			}
			catch(Exception e){
				System.err.println("Exception in Reprint Servlet->"+e);
				//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(e.getMessage(),"UTF-8" ) +"&err_value="+"2");
				jsonObj.addProperty("Success","N");
				jsonObj.addProperty("errorMessage", e.getMessage());
				out.println(jsonObj);
			}
		}
	}

}
