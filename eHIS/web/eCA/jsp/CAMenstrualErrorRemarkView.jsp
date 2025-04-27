<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
01/10/2024     68508     krishna pranay             13/10/2024  Ashwini Ragupathi  ML-MMOH-CRF-1759							
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<HTML>
<head>
<title>
	<fmt:message key="eCA.errorRemarks.label" bundle="${ca_labels}"/>
</title>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
<script language='javascript' src='../../eCA/js/CAMenstrualHistDtlTrans.js'></script>	
</head>
<% 
String error_remarks = "";
String error_remarks_by = "";
String marked_date = "";
String srl_no = request.getParameter("srl_no") == null ? "" : request.getParameter("srl_no");
String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String ca_bean_id = "@CAMenstrualHistDtlTransBean";
String ca_bean_name = "eCA.CAMenstrualHistDtlTransBean";
CAMenstrualHistDtlTransBean bean = (CAMenstrualHistDtlTransBean)getBeanObject(ca_bean_id, ca_bean_id, request);
ArrayList errorDetails = bean.getPatientMenstrualErrorRemarks(patient_id, srl_no);
if (errorDetails.size() > 0) { 
	for (int i = 0; i < errorDetails.size(); i++) {
        String[] record = (String[]) errorDetails.get(i); // corrected variable name
        error_remarks = CommonBean.checkForNull(record[0]);
		error_remarks_by = CommonBean.checkForNull(record[1]);
		marked_date = CommonBean.checkForNull(record[2]);
	}
%>
<body>
    <table border="0" cellpadding="5">
        <tr>
            <td colspan="2">
                <textarea readonly id="curr_remarks" name="curr_remarks" rows="6" cols="46" maxlength="2000"><%= error_remarks %></textarea>
            </td>
        </tr>
        <tr>
            <td class="label" style="font-size: 14px;"><fmt:message key="eCA.markedBy.label" bundle="${ca_labels}"/></td>
            <td style="font-size: 14px;"><%= error_remarks_by %></td>
        </tr>
        <tr>
            <td class="label" style="font-size: 14px;"><fmt:message key="eCA.markedDate.label" bundle="${ca_labels}"/></td>
            <td style="font-size: 14px;"><%= marked_date %></td>
        </tr>
    </table>
</body>
<%} %>
</HTML>

