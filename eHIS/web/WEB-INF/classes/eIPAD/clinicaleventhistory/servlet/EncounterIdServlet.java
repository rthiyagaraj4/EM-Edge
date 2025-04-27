/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIPAD.clinicaleventhistory.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommon.Common.CommonBean;
import eIPAD.IPADConstants;
import eIPAD.clinicaleventhistory.ClinicalEventHistory;
import eIPAD.clinicaleventhistory.EncounterIdContainer;
import eIPAD.clinicaleventhistory.PatientClassAndEncounterIdRequest;
import eIPAD.clinicaleventhistory.PatientClassAndEncounterIdResponse;
import eIPAD.clinicaleventhistory.PatientClassResponse;

/**
 * @author GRamamoorthy
 *
 */
public class EncounterIdServlet extends HttpServlet implements Servlet {

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		String selectedPeriod = req.getParameter("selectedperiod");
		selectedPeriod = CommonBean.checkForNull(selectedPeriod,IPADConstants.LAST_ONE_DAY);
		String patientClass = req.getParameter("patientclass");
		patientClass = CommonBean.checkForNull(patientClass,IPADConstants.INPATIENT_KEYWORD);
		String patientId = req.getParameter("patientid");
		patientId = CommonBean.checkForNull(patientId);
		String facilityId = req.getParameter("facility_id");
		facilityId = CommonBean.checkForNull(facilityId);
		
		PatientClassAndEncounterIdRequest patClassEncounterIdRequest = new PatientClassAndEncounterIdRequest();
		patClassEncounterIdRequest.setPatientId(patientId);
		patClassEncounterIdRequest.setFacilityId(facilityId);
		patClassEncounterIdRequest.setRequest(req);
		patClassEncounterIdRequest.setSession(req.getSession());
		patClassEncounterIdRequest.setSelectedTimePeriod(selectedPeriod);
		patClassEncounterIdRequest.setPatientClass(patientClass);
		
		ClinicalEventHistory beanInst = new ClinicalEventHistory();
		PatientClassAndEncounterIdResponse patClassEncounterIdResponse = beanInst
				.getPatientClassAndEncounterIdList(patClassEncounterIdRequest);
		Map<PatientClassResponse, List<EncounterIdContainer>> dataMap = patClassEncounterIdResponse
				.getDataMap();
		Set<PatientClassResponse> patientClassSet = null;
		if (dataMap != null) {
			patientClassSet = dataMap.keySet();
		}
		Iterator<PatientClassResponse> patientClassItr = null;
		List<EncounterIdContainer> ipEncounterIdList = new ArrayList<EncounterIdContainer>();
		if (patientClassSet != null && !patientClassSet.isEmpty()) {
			patientClassItr = patientClassSet.iterator();
		}
		
		StringBuffer contentBuff = new StringBuffer();
		// safe check
		if(patientClassItr == null){
			writer.println(contentBuff.toString());
			return;
		}
		
		PatientClassResponse patClassResponse = null;
		while (patientClassItr.hasNext()) {
			patClassResponse = patientClassItr.next();
			patientClass = patClassResponse.getPatientClass();

			ipEncounterIdList = dataMap.get(patClassResponse);
			if (ipEncounterIdList != null && !ipEncounterIdList.isEmpty()) {
				for (EncounterIdContainer encounterId : ipEncounterIdList) {
					contentBuff.append("<option>");
					contentBuff.append(encounterId.getEncounterId());
					contentBuff.append("</option>");
				}
			}
		}
		// finally write the contents
		writer.println(contentBuff.toString());
		
	}

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	
	
}
