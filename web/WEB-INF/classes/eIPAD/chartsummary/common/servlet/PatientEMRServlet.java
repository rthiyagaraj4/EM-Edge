/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.common.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIPAD.chartsummary.banner.bc.BannerBC;
import eIPAD.chartsummary.banner.healthobject.BannerConfigHO;
import eIPAD.chartsummary.banner.healthobject.BannerContentsHO;
import eIPAD.chartsummary.banner.request.BannerRequest;
import eIPAD.chartsummary.banner.response.BannerResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * Servlet implementation class PatientContextSelect 
 */
public class PatientEMRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientEMRServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		//PatContext patientContext = new PatContext();
		//String patientId = request.getParameter("hdnPatientId");
		//String episodeId = request.getParameter("hdnEpisodeId");
		//String baseEncId = "";
		
		/*if(session.getAttribute("facility_id") != null)
			patientContext.setFacilityId((String)session.getAttribute("facility_id"));
		if(request.getParameter("hdnEpisodeId") != null){
			baseEncId = request.getParameter("hdnEpisodeId");
			patientContext.setEncounterId(baseEncId);
		}*/
		
		/*if(request.getParameter("hdnPatientId") != null)
			patientContext.setPatientId(request.getParameter("hdnPatientId"));
		if(request.getParameter("hdnSelectedEncounter") != null && !request.getParameter("hdnSelectedEncounter").equals("") && !request.getParameter("hdnSelectedEncounter").equals(baseEncId))
			patientContext.setSelectedEncounterId(request.getParameter("hdnSelectedEncounter"));
		if(session.getAttribute("practitioner_id") != null)
			patientContext.setClinicianId((String)session.getAttribute("practitioner_id"));
		if(session.getAttribute("practitioner_type") != null)
			patientContext.setPracType((String)session.getAttribute("practitioner_type"));
		if(session.getAttribute("LOCALE") != null)
			patientContext.setLocale((String)session.getAttribute("LOCALE"));
		if(session.getAttribute("login_user") != null)
			patientContext.setLoggedInUser((String)session.getAttribute("login_user"));
		if(session.getAttribute("responsibility_id") != null)
			patientContext.setResponsibilityID((String)session.getAttribute("responsibility_id"));
		if(request.getParameter("hdnLocnCode") != null)
		{
			patientContext.setLocationCode(request.getParameter("hdnLocnCode"));
		}
		if(request.getParameter("hdnLocnType") != null)
		{
			patientContext.setLocationType(request.getParameter("hdnLocnType"));
		}
		if(request.getParameter("hdnPatClass") != null)
		{
			patientContext.setPatientClass(request.getParameter("hdnPatClass"));
		}*/
		
		
		String openingPage = "";
		if(request.getParameter("hdnopeningPage") !=null)
		{
			openingPage = request.getParameter("hdnopeningPage");
		}
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		if(patientContext!=null){
			BannerConfigHO bannerConfig;
			BannerContentsHO bannerContent;
			BannerRequest bannerRequest = new BannerRequest();
			BannerResponse bannerResponse;
			bannerRequest.setPatientContext(patientContext);
			BannerBC bannerBC = new BannerBC();
			bannerResponse = bannerBC.getBannerDetails(bannerRequest);
			
			if(bannerResponse.isSuccessResponse()){

				bannerConfig = bannerResponse.getBannerConfig();
				bannerContent = bannerResponse.getBannerContent();
				request.setAttribute("BannerConfig", bannerConfig);
				request.setAttribute("BannerContent", bannerContent);
				
				
				String bannerPatientId = bannerContent.getPatientId()==null ? "" : bannerContent.getPatientId();
				String bannerPatientName = bannerContent.getPatientName()==null ? "" : bannerContent.getPatientName();
				String bannerAge = bannerContent.getAge()==null ? "" : bannerContent.getAge();
				String bannerGender = bannerContent.getGender()==null? "" : bannerContent.getGender();
				String bannerDob = bannerContent.getDob()==null? "" : bannerContent.getDob();
				String bannerEncounterId = bannerContent.getEncounterId()==null? "" : bannerContent.getEncounterId();
				String bannerNationality = bannerContent.getNationality()==null? "" : bannerContent.getNationality();
				String bannerBedNum = bannerContent.getBedNum()==null? "" : bannerContent.getBedNum();
				String bannerNursingUnit = bannerContent.getNursingUnit()==null? "" : bannerContent.getNursingUnit();
				String bannerPatientNameLocal = bannerContent.getPatientNameLocal()==null? "" : bannerContent.getPatientNameLocal();
				String bannerAttendPractName = bannerContent.getAttendPractName()==null? "" : bannerContent.getAttendPractName();
				
				//setting remaining values in patient context
				patientContext.setAge(bannerAge);
				patientContext.setGender(bannerGender);
				patientContext.setDob(bannerDob);
				
				if(bannerConfig.isPatientID())
					request.setAttribute("bannerPatientId", bannerPatientId);
				if(bannerConfig.isPatientName())
					request.setAttribute("bannerPatientName", bannerPatientName);
				if(bannerConfig.isAge())
					request.setAttribute("bannerAge", bannerAge);
				if(bannerConfig.isGender())
					request.setAttribute("bannerGender", bannerGender);
				if(bannerConfig.isDob())
					request.setAttribute("bannerDob", bannerDob);
				if(bannerConfig.isEncounterId())
					request.setAttribute("bannerEncounterId", bannerEncounterId);
				if(bannerConfig.isNationality())
					request.setAttribute("bannerNationality", bannerNationality);
				if(bannerConfig.isNursingUnit())
					request.setAttribute("bannerBedNum", bannerBedNum);
				if(bannerConfig.isNursingUnit())
					request.setAttribute("bannerNursingUnit", bannerNursingUnit);
				if(bannerConfig.isLocalName())
					request.setAttribute("bannerPatientNameLocal", bannerPatientNameLocal);
				request.setAttribute("bannerAttendPractName", bannerAttendPractName);
				if(bannerConfig.isVipPatient())
					request.setAttribute("bannerVip", "true");
				else
					request.setAttribute("bannerVip", "false");
				if(bannerConfig.isPatientPhoto())
					request.setAttribute("bannerPhoto", "true");
				else
					request.setAttribute("bannerPhoto", "false");
				
				//setting patientContext to session
				//session.setAttribute("PatientContext", patientContext);
				
				//TODO remove below session values addition
				//This was added to test iscroll performance
				/*session.putValue("PatientID", bannerPatientId);
				session.putValue("EpisodeId", bannerEncounterId);*/
			}
			else{
				request.setAttribute("bannerError", "true");
			}
			

			/*if(openingPage.equals("clinicalNotes"))
			{
				RequestDispatcher rd = session.getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ClinicalNotes/ClinicalNotesBasePage.jsp");
				rd.forward(request, response);
			}*/
			
			RequestDispatcher rd = session.getServletContext().getRequestDispatcher("/eIPAD/jsp/PatientEMRBasePage.jsp?activePage="+openingPage);
			rd.forward(request, response);	
		}else{
			PrintWriter out = response.getWriter();
			out.println("Patient not chosen or Session expired. Please try logging in again");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
