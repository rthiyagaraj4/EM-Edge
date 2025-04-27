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
--------------------------------------------------------------------------------
Date       	Edit History   	Name        Rev.Date		Rev.Name	Description
--------------------------------------------------------------------------------
?           100         	?           							created
24/12/2015	IN058704		Karthi L								MMOH-SCF-0323 - IN058704
--------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head><title><fmt:message key="eOR.ExternalOrder.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	 
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->

	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="JavaScript" src="../../eOR/js/ExternalOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String bean_id=request.getParameter("bean_id");
String bean_name=request.getParameter("bean_name");
String Patientid=request.getParameter("patientId");
String Referral_facility=request.getParameter("facility");
String Referral_pract=request.getParameter("practitioner");
String practitioner_id=request.getParameter("practitionerId");
String practitionerName = request.getParameter("practitionerName");
//out.println("<script>alert('"+practitionerName+"');</script>");

String Referral_dt_time=request.getParameter("Referral_date");
String Remarks=request.getParameter("remarks");
String function_from=request.getParameter("function_from");
String patient_class = request.getParameter("patient_class");
String order_category = request.getParameter("order_category");
String order_type = request.getParameter("order_type");
String ordercode = request.getParameter("ordercode");
String activitycode = request.getParameter("activity_type");
String activitydesc = request.getParameter("activity_type_desc");
String patient_details =""; //request.getParameter("patient_details");
//IN039587 Starts
String sex = 	request.getParameter("Sex");
String Age = 	request.getParameter("Age");
//IN039587 Ends
String dob = 	request.getParameter("Dob"); //added for MMOH-SCF-0323 - IN058704
String qryString	= request.getParameter("qryString");

if(bean_id == null || bean_id.equals(""))bean_id="";
if(bean_name == null || bean_name.equals(""))bean_name="";
if(Patientid == null || Patientid.equals(""))Patientid="";
if(Referral_facility == null || Referral_facility.equals("")) Referral_facility=""; else Referral_facility = Referral_facility.trim();
if(Referral_pract == null || Referral_pract.equals(""))Referral_pract="";
if(practitionerName==null || practitionerName.equals("")) practitionerName = "";
if(Referral_dt_time == null || Referral_dt_time.equals(""))Referral_dt_time="";
if(Remarks == null || Remarks.equals(""))Remarks="";
if(function_from == null || function_from.equals(""))function_from="";
if(patient_class==null || patient_class.equals("")) patient_class = "";
if(order_category==null || order_category.equals("")) order_category = "";
if(order_type==null || order_type.equals("")) order_type = "";
if(ordercode==null || ordercode.equals("")) ordercode = "";
if(activitycode==null || activitycode.equals("")) activitycode = "";
if(activitydesc==null || activitydesc.equals("")) activitydesc = "";
if(patient_details == null || patient_details.equals(""))patient_details="";



//ExternalOrdersBean bean = (ExternalOrdersBean)mh.getBeanObject( bean_id, request,bean_name ) ;
 ExternalOrdersBean bean = (ExternalOrdersBean)getBeanObject( bean_id, bean_name, request ) ;
 bean.setLanguageId(localeName);
// Set it in bean
bean.setPatientId(Patientid);
bean.setFacilityId(Referral_facility);
bean.setPractitionerId(practitionerName);
bean.setReferral_date(Referral_dt_time);
bean.setRemarks(Remarks);

if(!activitycode.equals(""))
	bean.setActivity_Type(activitycode);
if(!activitydesc.equals(""))
	bean.setActivity_Desc(activitydesc);

if(!ordercode.equals(""))
{
	String[] catalog_nature_order_type = bean.getCatalogNatureOrderType(ordercode);
	if(catalog_nature_order_type.length>0&&catalog_nature_order_type!=null)
	{
		if(catalog_nature_order_type[0].equals("S"))
		{
			bean.setOrderCategory("CS");
		}
		else
		{
			bean.setOrderCategory(order_category);
		}
		if(!order_type.equals(""))
			bean.setOrderType(order_type);
		else
			bean.setOrderType(catalog_nature_order_type[1]);
	}
}
else
{
	bean.setOrderType(order_type);
	bean.setOrderCategory(order_category);
}
bean.setOrderCatalogCode(ordercode);
bean.setQryString(qryString);
%>
<Script>
  //commented for IN039587
  //document.location.href = "../../eOR/jsp/EnterOrder.jsp?patient_id=<%=Patientid%>&practitioner_id=<%=practitioner_id%>&practitioner_name=<%=practitionerName%>&location_type=R&location_code=<%=Referral_facility%>&patient_class=<%=patient_class%>&function_from=<%=function_from%>";
  document.location.href = "../../eOR/jsp/EnterOrder.jsp?patient_id=<%=Patientid%>&practitioner_id=<%=practitioner_id%>&practitioner_name=<%=practitionerName%>&location_type=R&location_code=<%=Referral_facility%>&patient_class=<%=patient_class%>&function_from=<%=function_from%>&Sex=<%=sex%>&Age=<%=Age%>&Dob=<%=dob%>";//IN039587 <!-- added 'Dob' for MMOH-SCF-0323 - IN058704 -->
</Script>
</html>

<%
 	putObjectInBean(bean_id,bean,request);
%>

