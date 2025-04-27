<!DOCTYPE html>
<%@ page    import="java.sql.*,java.util.*,webbeans.eCommon.*, eBL.Common.*,eBL.resources.*,  eCommon.Common.*,eBL.BillingPrevilageCardPatientBean,eBL.BillingPrevilageCardPatientBean ,eBL.BillingPrevilageCardVisiiUtilizationBean " contentType="text/html;charset=UTF-8" %> 
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
String hiddenCardTypeCode																	=	"";
String locale																				=	"";
String facilityId																			=	"";
try
{
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	hiddenCardTypeCode																		=	checkForNull(request.getParameter("cardTypeCode")); 
	pateintId																				= 	request.getParameter("patientId");
	System.out.println("Patient ID in LoadAdditionalPatientDefaultPriceClassCode.jsp.::: +pateintId");
	System.out.println("cardTypeCode in LoadAdditionalPatientDefaultPriceClassCode.jsp.::: +cardTypeCode");
	bean_id																					= 	"BillingPrevilageCardPatientBean" ;
	bean_name																				= 	"eBL.BillingPrevilageCardPatientBean";
	BillingPrevilageCardPatientBean billingPrevilageCardPatientBean							= 	(BillingPrevilageCardPatientBean)getBeanObject( bean_id, bean_name, request ) ;
	Str=Str+billingPrevilageCardPatientBean.getDefaultPriceClassCodeForAdditionalPatient(pateintId, facilityId, hiddenCardTypeCode);
 	out.println(Str);
	putObjectInBean(bean_id, billingPrevilageCardPatientBean, request);
}
catch(Exception e)
{
	System.out.println("EXCEPTION IN LoadAdditionalPatientDefaultPriceClassCode.jsp.::::: "+e); 
}

%>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

