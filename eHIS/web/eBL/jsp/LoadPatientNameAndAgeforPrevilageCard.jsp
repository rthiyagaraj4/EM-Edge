<!DOCTYPE html>
<%@ page    import="java.sql.*,java.util.*,webbeans.eCommon.*, eBL.Common.*,eBL.resources.*,  eCommon.Common.*,eBL.BillingPrevilageCardPatientBean,eBL.BillingPrevilageCardMemberBean ,eBL.BillingPrevilageCardVisiiUtilizationBean " contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0    
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
String bean_id																				=	"";
String bean_name																			=	"";
String Str																					=	"!";
String pateintId																			=	"";
try
{
	pateintId																				= 	request.getParameter("patientId");
	System.out.println("Patient ID in LoadPatientNameAndAgeforPrevilageCard.jsp::: +pateintId");
	bean_id																					= 	"BillingPrevilageCardMemberBean" ;
	bean_name																				= 	"eBL.BillingPrevilageCardMemberBean";
	BillingPrevilageCardMemberBean billingPrevilageCardMemberBean							= 	(BillingPrevilageCardMemberBean)getBeanObject( bean_id, bean_name, request ) ;
	Str=Str+billingPrevilageCardMemberBean.getPrevilageCardPatientDetails(pateintId)+"~"+billingPrevilageCardMemberBean.getPrevilageCardPatientAge(pateintId);
 	out.println(Str);
	putObjectInBean(bean_id, billingPrevilageCardMemberBean, request);
}
catch(Exception e)
{
	System.out.println("EXCEPTION IN LoadPatientNameAndAgeforPrevilageCard.jsp::::: "+e);
}

%>

