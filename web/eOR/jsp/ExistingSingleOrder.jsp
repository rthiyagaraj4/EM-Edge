<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ExistingSingleOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script>function_id = "<%=request.getParameter("function_id")%>";</script>
<%--<script>alert('<%=request.getQueryString()%>')</script>--%>
</head>
<%

    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id =		(String)request.getParameter("patient_id");
	String encounter_id =	(String)request.getParameter("episode_id");
	String pract_reln_id = (String)request.getParameter("relationship_id");
	String visit_adm_date = (String)request.getParameter("visit_adm_date");

	String location_type			= (String)request.getParameter("location_type");
	String locn_type			= (String)request.getParameter("locn_type")==null?"": (String)request.getParameter("locn_type");
	String location_code			= (String)request.getParameter("location_code");
	String locn_code			= (String)request.getParameter("locn_code")==null?"":(String)request.getParameter("locn_code");
	String patient_class			= (String)request.getParameter("patient_class");
	String p_called_from_ca			= (String)request.getParameter("p_called_from_ca");
	String function_from			= (String)request.getParameter("function_from")==null?"":(String)request.getParameter("function_from");
	String sex						= (String)request.getParameter("Sex");
	String age						= (String)request.getParameter("Age");
	String dob						= (String)request.getParameter("Dob");
	String patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId") ;
	String speciality_code = request.getParameter("speciality_code")==null?"": request.getParameter("speciality_code");
	String multi_called_from = request.getParameter("multi_called_from")==null?"": request.getParameter("multi_called_from");
	String include_checkout_patients = request.getParameter("include_checkout_patients")==null?"": request.getParameter("include_checkout_patients");
	
 	if(patient_id!=null)
		patient_id = patient_id.trim();
	if(encounter_id!=null)
	encounter_id = encounter_id.trim();
	if(patient_class!=null)
	patient_class = patient_class.trim();
	if(function_from.equalsIgnoreCase("PASSED_ORDERS"))
	{
%>
	<frameset rows='34%,*'>
<%
	}
	else
	{
	%>
		<frameset rows='15%,*'><!--Menaka -->
	<%
	}
	%>

	<frame name='ExistingOrderSearch' src='ExistingSingleOrderSearch.jsp?patient_id=<%=patient_id%>&episode_id=<%=encounter_id%>&encounter_id=<%=encounter_id%>&pract_reln_id=<%=pract_reln_id%>&location_type=<%=location_type%>&location_code=<%=location_code%>&patient_class=<%=patient_class%>&p_called_from_ca=<%=p_called_from_ca%>&Sex=<%=sex%>&Age=<%=age%>&Dob=<%=dob%>&visit_adm_date=<%=visit_adm_date%>&function_from=<%=function_from%>&patientId=<%=patientId%>&speciality_code=<%=speciality_code%>&locn_code=<%=locn_code%>&locn_type=<%=locn_type%>&multi_called_from=<%=multi_called_from%>&include_checkout_patients=<%=include_checkout_patients%>' frameborder=0  scrolling=no noresize>

	<frame name='ExistingOrderResult' src='../../eCommon/html/blank.html' frameborder=0 scrolling=yes noresize>
</frameset>
</html>
