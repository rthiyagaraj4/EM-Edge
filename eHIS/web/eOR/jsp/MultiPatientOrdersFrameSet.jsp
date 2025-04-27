<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<% 
/*
-----------------------------------------------------------------------
Date       	Edit History   Name        Description
-----------------------------------------------------------------------
  ?             100            ?           created

28/01/2012	IN030566	Ramesh G	When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.								  
-----------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head><title><fmt:message key="eOR.OrderEntryMultiPatientOrders.label" bundle="${or_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%-- Mandatory declarations end --%>
<%

	String multi_bean_id 				= request.getParameter("bean_id");
	String multi_bean_name 				= request.getParameter("bean_name");
	/* Mandatory checks end */

	/* Initialize Function specific start */
	//MultiPatientOrdersBean multi_bean		= (MultiPatientOrdersBean)mh.getBeanObject( multi_bean_id, request,  multi_bean_name ) ;
	MultiPatientOrdersBean multi_bean		 = (MultiPatientOrdersBean)getBeanObject( multi_bean_id, multi_bean_name, request ) ;
	//MultiPatientOrdersBean multi_bean = (MultiPatientOrdersBean)getObjectFromBean(multi_bean_id, multi_bean_name,session);
	multi_bean.setLanguageId(localeName);

	String qryString						= multi_bean.getQryString();
	    /* Till here*/
	// Set the Patient_ids here
	ArrayList arr_patient_id		 = new ArrayList();

	/****Fetching Values from MultiPatientOrdersHdrResult.jsp on Press of Select*****/
	//arrylist to retreive all the details and is pssd as a parameter to arr_patient_id
	//ArrayList arr_checked_pat=new ArrayList();

	String recCntStr = request.getParameter("recCount");
	if(recCntStr == null || recCntStr.equals("")) recCntStr = "0";

	String encounterId = request.getParameter("encounter_id");
	if(encounterId == null || encounterId.equals("")) encounterId = "0";

	String patient_class = request.getParameter("patient_class");
	if(patient_class == null || patient_class.equals("")) patient_class = "0";

	String location_type = request.getParameter("source_type");
	String location_code = request.getParameter("source_code");
	String locn_type = request.getParameter("locn_type");
	String locn_code = request.getParameter("locn_code");
	String patientId = request.getParameter("patientId");
	String speciality_code = request.getParameter("speciality_code");
	String include_checkout_patients = request.getParameter("include_checkout_patients");
	String patientIds = "";
	String episodeId= "";
	String episodevisit = "";
	String patClass = "";
	String encounterIds = "";
	String s_patient_id = "",s_encounter_id = "",	s_pat_class = "",s_episode_id = "",s_episode_visit_num = ""; 
	if(location_type == null || location_type.equals(""))location_type="";
	if(location_code == null || location_code.equals(""))location_code="";
	if(patientId == null || patientId.equals(""))patientId="";
	if(speciality_code == null || speciality_code.equals(""))speciality_code="";	
	if(include_checkout_patients == null || include_checkout_patients.equals(""))include_checkout_patients="";	
	int count	= 0;
	//qryString		+= "&p_option_function_name=EXTERNAL&p_function_name=MULTI_PATIENT_ORDERS&function_from=MULTI_PATIENT_ORDERS&location_type="+location_type+"&location_code="+location_code;
	//qryString		=qryString+ "&p_option_function_name=EXTERNAL&p_function_name=MULTI_PATIENT_ORDERS&function_from=MULTI_PATIENT_ORDERS&location_type="+location_type+"&location_code="+location_code;
	qryString		= "p_called_from_ca=Y&option_id=MULTIPATIENTORDER&p_option_function_name=EXTERNAL&p_function_name=MULTI_PATIENT_ORDERS&function_from=MULTI_PATIENT_ORDERS&location_type="+location_type+"&location_code="+location_code+"&speciality_code="+speciality_code+"&patientId="+patientId+"&locn_code="+locn_code+"&locn_type="+locn_type+"&include_checkout_patients="+include_checkout_patients;
	multi_bean.setQryString(qryString);
	String [] record = null;
	if(!recCntStr.equals("0")){
		String patient_id = "", selectStr ="",encounter_id="",pat_class="";
		String episode_id = "", episode_visit_num = "";
		int recCnt = Integer.parseInt(recCntStr);
		for(int i=0; i<recCnt; i++){
			selectStr = request.getParameter("chk"+i);
			if(selectStr == null || selectStr.equals("")) {
				selectStr="N";
			}else if(selectStr.equals("Y")){

				record = new String [5];

				patient_id = request.getParameter("patient_id"+i);
				//[IN030566] Starts
				try{			
					if((session.getAttribute("TEMP_PASS")!=null) && (session.getAttribute("TEMP_PASS")!="")){
						HashMap mHash = new HashMap();
						mHash = (HashMap) session.getAttribute("TEMP_PASS");
						if(mHash.containsKey(patient_id)){
							mHash.remove(patient_id);
						}
						session.setAttribute("TEMP_PASS",mHash);
					}
				}catch(Exception ee)
				{	
					out.println("Exception in MultiPatientOrdersFrameSet.jsp for TEMP_PASS Session-- "+ee.toString()+"--");
					ee.printStackTrace();
				}
				//[IN030566] Ends
				encounter_id=request.getParameter("encounter_id"+i);
				pat_class=request.getParameter("patient_class"+i);
				episode_id= request.getParameter("episode_id"+i);
				episode_visit_num=request.getParameter("episode_visit_num"+i);
				s_patient_id = patient_id;
				s_encounter_id = encounter_id;
				s_pat_class = pat_class;
				s_episode_id = episode_id;
				s_episode_visit_num = episode_visit_num;
				if(s_patient_id == null || s_patient_id.equals("null")) s_patient_id="";
				if(s_encounter_id == null || s_encounter_id.equals("null")) s_encounter_id="";
				if(s_pat_class == null || s_pat_class.equals("null")) s_pat_class="";
				if(s_episode_id == null || s_episode_id.equals("null")) s_episode_id="";
				if(s_episode_visit_num == null || s_episode_visit_num.equals("null")) s_episode_visit_num="";
				if(s_episode_id.equals(""))s_episode_id=s_encounter_id;	 
				if(patient_id == null || patient_id.equals("null")) patient_id="~";
				if(encounter_id == null || encounter_id.equals("null")) encounter_id="~";
				if(pat_class == null || pat_class.equals("null")) pat_class="~";
				if(episode_id == null || episode_id.equals("null")) episode_id="~";
				if(episode_visit_num == null || episode_visit_num.equals("null")) episode_visit_num="~";
				if(episode_id.equals(""))episode_id=encounter_id;
				record[0]		= s_patient_id;
				record[1]		= s_encounter_id;
				record[2]		= s_episode_id;
				record[3]		= s_episode_visit_num;
				record[4]		= s_pat_class;
				if(patientIds.equals(""))
				{
					patientIds = patient_id+"!$!";
					encounterIds = encounter_id+"!$!";
					episodeId = episode_id+"!$!";
					episodevisit = episode_visit_num+"!$!";
					patClass = pat_class+"!$!";
				}
				else
				{
					patientIds = patientIds+patient_id+"!$!";
					encounterIds = encounterIds+encounter_id+"!$!";
					episodeId = episodeId+episode_id+"!$!";
					episodevisit = episodevisit+episode_visit_num+"!$!";
					patClass = patClass+pat_class+"!$!";
				}
				multi_bean.setPatString(patientIds);
				multi_bean.setEncString(encounterIds);
				multi_bean.setEpiString(episodeId);
				multi_bean.setVisitString(episodevisit);
				multi_bean.setPatClassString(patClass);
				//out.println("<script>alert('here')</script>");
				if (count == 0) {
					//qryString += "&patient_id="+patient_id+"&encounter_id=" + encounter_id+"&patient_class=" + pat_class+"&episode_id=" + encounter_id ;
					qryString =qryString+ "&patient_id="+s_patient_id+"&encounter_id=" + s_encounter_id+"&patient_class=" + s_pat_class+"&episode_id=" + s_encounter_id ;
				}
				arr_patient_id.add(record);
				count++;
			}
		}
		multi_bean.setMultiPatientDetails(arr_patient_id);
	}
  %>

<Script>
	document.location.href = "../../eOR/jsp/EnterOrder.jsp?<%=qryString%>";
</script>
</html>


<%
 
		// set it back persistence
		putObjectInBean(multi_bean_id,multi_bean,request);
		//putObjectInBean(multi_bean_id,multi_bean,session);
%>

