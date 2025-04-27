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
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCA/js/ConsultationTagging.js'> </script>	
</head>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	String facility_id=(String) session.getValue("facility_id");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String qrystr = request.getQueryString();
    boolean getRecordYN=false;
	String bean_id = "ConsultationTaggingBean" ;
	String bean_name = "eCA.ConsultationTaggingBean";
	ConsultationTaggingBean bean	= (ConsultationTaggingBean)getBeanObject( bean_id, bean_name , request) ; 
	getRecordYN =bean.getRecordYN(facility_id,patient_id,encounter_id);
%>
<form name='ConsultationTagAuditTrialBtn' id='ConsultationTagAuditTrialBtn' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<tr>
<%
if(getRecordYN){%>
<td  class='button'  align=right id="audittrialbutton">
<INPUT TYPE="button" id='audittrialbutton' name='audittrialbutton' id='audittrialbutton' value='<fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/>' class='button'  onClick='showConsultationTagHist()'>
</td>
<%
}
%>
</tr>

</table>

<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>	
</form>
</body>
</html>

