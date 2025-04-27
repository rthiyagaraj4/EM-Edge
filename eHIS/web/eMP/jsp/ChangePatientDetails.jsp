<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	int step = Integer.parseInt( request.getParameter("step")==null?"1":request.getParameter("step") );
	
	String file_name	= "../../eMP/jsp/blank.jsp?step_1=5 ";

	String patient_id	= request.getParameter("Patient_ID");
	if(patient_id == null) patient_id = "" ;

	String function_id	= request.getParameter("function_id");
	if(function_id == null)function_id = "" ;
	String home_required_yn	= request.getParameter("home_required_yn" ) ;
	if (home_required_yn == null) home_required_yn ="";
	String parent_details	= request.getParameter("parent_details") ;
	if(parent_details == null) parent_details = "" ;

	String multi_birth					=  request.getParameter("multi_birth" )== null ? "" : request.getParameter("multi_birth");
	String nb_birth_place_code	= request.getParameter("nb_birth_place_code") == null ? "" : request.getParameter("nb_birth_place_code");
	String nb_birth_place_desc	= request.getParameter("nb_birth_place_desc") == null ? "" : request.getParameter("nb_birth_place_desc");

	String mother_patient_id	=  request.getParameter("mother_patient_id" ) ;
	if(mother_patient_id == null) mother_patient_id = "";
	
	//Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1
	String load_tab = request.getParameter("load_tab");
	if(load_tab == null) load_tab = "";

	String called_from_newborn = request.getParameter("called_from_newborn")==null?"N":request.getParameter("called_from_newborn");
	String noOfBirths = request.getParameter("noOfBirths");
	if(noOfBirths == null) noOfBirths = ""; 
	String numOfbaby = request.getParameter("numOfbaby");
	if(numOfbaby == null) numOfbaby = "";
	//addition ends here.
	
	if(!patient_id.equals("") && step == 1) 
	{ 
		file_name = "ChangePatientDetails.jsp?step=2&Patient_ID="+java.net.URLEncoder.encode(patient_id)+"&multi_birth="+multi_birth+"&mother_patient_id="+mother_patient_id+"&function_id="+function_id+"&parent_details="+java.net.URLEncoder.encode(parent_details)+"&numOfbaby="+numOfbaby+"&noOfBirths="+noOfBirths+"&load_tab="+load_tab+"&called_from_newborn="+called_from_newborn+"&nb_birth_place_code="+nb_birth_place_code+"&nb_birth_place_desc="+nb_birth_place_desc;
	}
	
	if(step == 1) 
	{  
		%>
		<html>
		<head>
		<title><fmt:message key="eMP.ChgPatDtl.title.label" bundle="${mp_labels}"/></title>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
		<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
		<Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
		<Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script>
		<Script language='javascript' src='../../eMP/js/ChangePatientDetails.js'></Script>
		<Script src="../../eCommon/js/DateUtils.js" language="JavaScript"></Script>
		<Script language="JavaScript"src="../../eCommon/js/common.js" ></Script>



		<%
			String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			String params = request.getQueryString() ;
			String source = url + params ;
			
			if(!function_id.equals("CHG_PAT_DTLS")&&!function_id.equals(""))
				source = "../../eMP/jsp/ChangepatdocsToolBar.jsp";
			
		%>
		</head>
			<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src="<%=source%>" frameborder='0' scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
			<!-- <iframe name='f_query_add_mod' id='f_query_add_mod' src="<%=file_name%>" frameborder='0'  scrolling='auto' style='height:83vh;width:100vw'></iframe> -->
			<iframe name='f_query_add_mod' id='f_query_add_mod' src="<%=file_name%>" frameborder='0'  scrolling='no' style='height: 85vh;width:99vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
		</html>
		<% 
	}
	else if(step == 2) 
	{ 		
		out.println("<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><iframe name='patient_main' id='patient_main'   src='../../eMP/jsp/ChangePatientHeader.jsp?patient_id="+java.net.URLEncoder.encode(patient_id)+"&function_id="+function_id+"' frameborder=0 scrolling='no' noresize style='height:12vh;width:100vw'></iframe><iframe name='patient_sub' id='patient_sub' src='../../eMP/jsp/ChangePatientSub.jsp?patient_id="+java.net.URLEncoder.encode(patient_id)+"&multi_birth="+multi_birth+"&mother_patient_id="+mother_patient_id+"&function_id="+function_id+"&parent_details="+java.net.URLEncoder.encode(parent_details)+"&numOfbaby="+numOfbaby+"&called_from_newborn="+called_from_newborn+"&noOfBirths="+noOfBirths+"&load_tab="+load_tab+"&nb_birth_place_code="+nb_birth_place_code+"&nb_birth_place_desc="+nb_birth_place_desc+"' frameborder=0 scrolling='auto' noresize style='height:87vh;width:100vw'></iframe>"); 
	}
%>

