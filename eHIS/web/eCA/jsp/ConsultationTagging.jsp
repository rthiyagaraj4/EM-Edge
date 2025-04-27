<%
/*
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------	
22/04/2024  50627    Twinkle Shah    22/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper,webbeans.eCommon.*,eCA.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eCA/js/ConsultationTagging.js'> </script>	
      
</head>

<%
boolean func_appl_yn= true;
boolean pat_class_appl_yn= true;

String facility_id="";
facility_id=(String) session.getValue("facility_id");
String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
String option_id = request.getParameter("option_id")==null?"":request.getParameter("option_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");;
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String discharge_date = request.getParameter("discharge_date")==null?"":request.getParameter("discharge_date");
String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
String checkPatClsAppli="Y";

String bean_id				= "ConsultationTaggingBean" ;
String bean_name			= "eCA.ConsultationTaggingBean";
ConsultationTaggingBean bean	= (ConsultationTaggingBean)getBeanObject( bean_id, bean_name , request) ; 

if(patient_class.equals("IP"))
checkPatClsAppli=bean.appliPatConsulTagIPYN(facility_id,patient_id);
else if(patient_class.equals("OP"))
checkPatClsAppli=bean.appliPatConsulTagOPYN(facility_id,patient_id);
else if(patient_class.equals("DC"))
checkPatClsAppli=bean.appliPatConsulTagDCYN(facility_id,patient_id);
else if(patient_class.equals("EM"))
checkPatClsAppli=bean.appliPatConsulTagEMYN(facility_id,patient_id);


if(!discharge_date.equals(""))
{
	func_appl_yn		= false;
	pat_class_appl_yn   = false;
	  %>
	 <script>
		alert(getMessage("CONSULT_NOT_APPL_DISCH","CA"));
		window.close();
	 </script> 
	 <% 
} 
if(pat_class_appl_yn)
{
if(checkPatClsAppli.equals("N"))
{
	func_appl_yn		= false;
	  %>
	<script>
		 alert(getMessage("APPL_PAT_CONSUL_TAG","CA"));
		 window.close();
	 </script> 
	 <% 
}
}
if(func_appl_yn)
{
if("CONSULT_TAGGING".equals(option_id) || "CONSULT_TAGGING1".equals(option_id))
{
%>
<iframe name='ConsultationTagCriteria' id='ConsultationTagCriteria' src='../../eCA/jsp/ConsultationTaggingQuery.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize frameborder='0' style='height:10%;width:100vw'></iframe>
<iframe name='ConsultationTagResult' id='ConsultationTagResult' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' frameborder='0' style='height:18%;width:100vw'></iframe><iframe name='ConsultationTagQuery2' id='ConsultationTagQuery2' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' frameborder='0' style='height:72%;width:100vw'></iframe>
<% 
}
else
{
%>
<iframe name="ConsultationTagResultFrame" id="ConsultationTagResultFrame" frameborder="no" scrolling="auto" noresize src="../../eCA/jsp/ConsultationTaggingRecordedResult.jsp?<%=request.getQueryString()%>" frameborder='0' style="height:49%;width:100vw"></iframe>
<iframe name="ConsultationTagAuditTRialFrame" id="ConsultationTagAuditTRialFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/ConsultationTaggingAuditTrialBtn.jsp?<%=request.getQueryString()%>" frameborder='0' style="height:9%;width:100vw"></iframe>
<iframe name="ConsultationTagQuery2Frame" id="ConsultationTagQuery2Frame" frameborder="no" scrolling="auto" noresize src="../../eCA/jsp/ConsultationTaggingQuery2.jsp?<%=request.getQueryString()%>" frameborder='0' style="height:42%;width:100vw"></iframe>

<%
}
}
%>
<form>
<input type='hidden' name='option_id' id='option_id' value=<%=option_id%>>
</form>
</html>

