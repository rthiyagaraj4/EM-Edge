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

import eIPAD.chartsummary.activeproblems.bc.ProblemsDiagnosisBC;
import eIPAD.chartsummary.activeproblems.request.ComplaintSfsRequest;
import eIPAD.chartsummary.activeproblems.request.DiagnosisSfsRequest;
import eIPAD.chartsummary.activeproblems.response.ComplaintSfsResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisSfsResponse;
import eIPAD.chartsummary.activeproblems.response.ProblemsDiagnosisConstants;
import eIPAD.chartsummary.common.bc.SfsBC;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.SfsResponse;

/**
 * Servlet implementation class ProblemsDiagnosisSFS 
 */
public class ProblemsDiagnosisSFS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sfsType = request.getParameter("SfsType") == null? "":request.getParameter("SfsType");
		boolean postBack = request.getParameter("hdnPostback")!=null&&request.getParameter("hdnPostback").equals("true")?true:false;
		//String diagSetId = request.getParameter("DiagSetId") == null? "":request.getParameter("DiagSetId");
		RequestDispatcher rd;
		HttpSession session = request.getSession(false);
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		ProblemsDiagnosisBC bc = new ProblemsDiagnosisBC();
		
		
		if(patientContext!=null){
			if(sfsType != null && sfsType.equals(ProblemsDiagnosisConstants.SFS_DIAGNOSIS)){
				DiagnosisSfsRequest sfsRequest = new DiagnosisSfsRequest();
				DiagnosisSfsResponse sfsRes = null;
				if(postBack){
					String termSetId = request.getParameter("TermSetId") == null? "":request.getParameter("TermSetId");
					String termGroupId = request.getParameter("hdnTermGroupId") == null? "":request.getParameter("hdnTermGroupId");
					String searchType = request.getParameter("hdnSearchType") == null? "":request.getParameter("hdnSearchType"); //Search or Custom list
					String sensitiveYN = request.getParameter("hdnSensitiveYN") == null? "":request.getParameter("hdnSensitiveYN");
					String notifiableYN = request.getParameter("hdnNotifiableYN") == null? "":request.getParameter("hdnNotifiableYN");
					String genderSpecInd = patientContext.getGender() == null ? "":patientContext.getGender();
					String searchBy = request.getParameter("hdnSearchBy") == null? "":request.getParameter("hdnSearchBy");//Code or Desc
					String searchCriteria = request.getParameter("SearchText") == null? "":request.getParameter("SearchText");//Search Text
					String locale = patientContext.getLocale() == null ? "en":patientContext.getLocale();
					
					
					sfsRequest.setLocale(locale);
					sfsRequest.setSearhcBy(searchBy);
					if(searchType.equals("C")){
						//Custom List
						sfsRequest.setSfsType(1);
						sfsRequest.setTermGroupId(termGroupId);
					}else{
						sfsRequest.setSfsType(2);
					}
					sfsRequest.setSearchCriteria(searchCriteria);
					sfsRequest.setbDuplicateValues(true);
					sfsRequest.setTermSetId(termSetId);
					sfsRequest.setSensitiveYN(sensitiveYN);
					sfsRequest.setNotifiableYN(notifiableYN);
					sfsRequest.setGenderSpecInd(genderSpecInd);
					
					sfsRes = bc.getDiagnosisCodeList(sfsRequest);
					request.setAttribute("SfsResponse",sfsRes);
					
				}
				rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/DiagnosisSFS.jsp");
				rd.forward(request, response);
			}
			else if(sfsType != null && sfsType.equals(ProblemsDiagnosisConstants.SFS_COMPLAINT)){
				ComplaintSfsRequest sfsRequest = new ComplaintSfsRequest();
				ComplaintSfsResponse sfsRes = null;
				if(postBack){
					String searchType = request.getParameter("hdnFilterBy") == null? "":request.getParameter("hdnFilterBy"); //Specialty, Non Specialty, ALL
					String specialityCode = request.getParameter("hdnSpecialtyCode") == null? "":request.getParameter("hdnSpecialtyCode");
					String searchBy = request.getParameter("hdnSearchBy") == null? "":request.getParameter("hdnSearchBy");//Code or Desc
					String searchCriteria = request.getParameter("SearchText") == null? "":request.getParameter("SearchText");//Search Text
					String locale = patientContext.getLocale() == null ? "en":patientContext.getLocale();
					
					
					sfsRequest.setLocale(locale);
					sfsRequest.setSearhcBy(searchBy);
					sfsRequest.setSpecialityCode(specialityCode);
					if(searchType.equals("S")){
						//Custom List
						sfsRequest.setSfsType(ComplaintSfsRequest.COMPLAINTS_SPECIALITY);
					}
					else if(searchType.equals("N")){
						sfsRequest.setSfsType(ComplaintSfsRequest.COMPLAINTS_NONSPECIALITY);
					}
					else{
						sfsRequest.setSfsType(ComplaintSfsRequest.COMPLAINTS_ALL);
					}
					sfsRequest.setSearchCriteria(searchCriteria);
					sfsRequest.setbDuplicateValues(true);
					
					sfsRes = bc.getComplaintCodeList(sfsRequest);
					request.setAttribute("SfsResponse",sfsRes);
					
				}
				rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ComplaintSFS.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
