
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.RecordApprovalPatientDataBean "  contentType="text/html;charset=UTF-8" %> 
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
	System.out.println("Patient ID in BillingRecordApprovalGetPatienName.jsp::: +pateintId");
	bean_id																					= 	"RecordApprovalPatientDataBean" ;
	bean_name																				= 	"eBL.RecordApprovalPatientDataBean";
	RecordApprovalPatientDataBean recordApprovalPatientDataBean							= 	(RecordApprovalPatientDataBean)getBeanObject( bean_id, bean_name, request ) ;
	Str=Str+recordApprovalPatientDataBean.getRecordApprovalPatientName(pateintId);
 	out.println(Str);
	putObjectInBean(bean_id, recordApprovalPatientDataBean, request);
}
catch(Exception e)
{
	System.out.println("EXCEPTION IN BillingRecordApprovalGetPatienName.jsp::::: "+e);
}

%>

