<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-----------------------------------------------------------------------------------------------
Date			Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?				100				?           created
30/05/2012		IN033040		Menaka V	OR>Place Order>Encounter type- External>When we view the Placed order from Existing Orders we
											get  internal Server Error.
24/09/2020		IN074110		Nijitha S	24/09/2020	Remesh G	MMS-KH-CRF-0029.4/05
-----------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ExistingOrder.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script>function_id = "<%=request.getParameter("function_id")%>";</script>
<%--<script>alert('<%=request.getQueryString()%>')</script>--%>
</head>
<%

    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String mode	   = (String)request.getParameter( "mode" ) ;
	//String function_id = (String)request.getParameter( "function_id" ) ;
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
	//String speciality = request.getParameter("speciality")==null?"": request.getParameter("speciality");
	//String location_desc = request.getParameter("location_desc")==null?"": request.getParameter("location_desc");
	String cnsnt_with_order_yn = request.getParameter("cnsnt_with_order_yn")==null?"N":request.getParameter("cnsnt_with_order_yn") ;
	String existing_order_called_from = ((String)request.getParameter("existing_order_called_from"))==null ? "" : (String)request.getParameter("existing_order_called_from");//IN074110
 	
	//68801 start
	String locale = request.getParameter("locale")==null?"":request.getParameter("locale") ;
	String Patient_ID = request.getParameter("Patient_ID")==null?"":request.getParameter("Patient_ID") ;
	//68801 end 
	
	if(patient_id!=null)
		patient_id = patient_id.trim();
	if(encounter_id!=null)
	encounter_id = encounter_id.trim();
	else //IN033040
		encounter_id="";//IN033040
	if(patient_class!=null)
	patient_class = patient_class.trim();
	if(function_from.equalsIgnoreCase("PASSED_ORDERS"))
	{
%>
	<!-- <frameset rows='34%,*'> -->
<%
	}
	else
	{
	%>
		<!-- <frameset rows='40%,*'> -->
	<%
	}
	%>

	<iframe name='ExistingOrderSearch' id='ExistingOrderSearch' src='../../eOR/jsp/ExistingOrderSearch.jsp?patient_id=<%=patient_id%>&episode_id=<%=encounter_id%>&encounter_id=<%=encounter_id%>&pract_reln_id=<%=pract_reln_id%>&location_type=<%=location_type%>&location_code=<%=location_code%>&patient_class=<%=patient_class%>&p_called_from_ca=<%=p_called_from_ca%>&Sex=<%=sex%>&Age=<%=age%>&Dob=<%=dob%>&visit_adm_date=<%=visit_adm_date%>&function_from=<%=function_from%>&patientId=<%=patientId%>&speciality_code=<%=speciality_code%>&locn_code=<%=locn_code%>&locn_type=<%=locn_type%>&multi_called_from=<%=multi_called_from%>&include_checkout_patients=<%=include_checkout_patients%>&cnsnt_with_order_yn=<%=cnsnt_with_order_yn%>&existing_order_called_from=<%=existing_order_called_from %>' frameborder=0  scrolling=no noresize style='height:40vh;width:100vw'></iframe><!-- Added existing_order_called_from for  IN074110 -->

	<!-- <frame name='ExistingOrderHeader' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize> -->
	<iframe name='ExistingOrderResult' id='ExistingOrderResult' src='../../eCommon/html/blank.html' frameborder=0 scrolling=yes noresize style='height:60vh;width:100vw'></iframe>
<!-- </frameset>-->
</html>
