<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
29/04/2024     58928	     Krishna pranay	         30/04/204         Ramesh Goli       	ML-MMOH-CRF-1759.2
01/10/2024     68508     krishna pranay             13/10/2024  Ashwini Ragupathi  ML-MMOH-CRF-1759							
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
request = new XSSRequestWrapper(request); // MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); // MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); // MMS-ME-SCF-0085
String patient_id 	= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String sex 			= request.getParameter("Sex")==null?"":request.getParameter("Sex");
String age 			= request.getParameter("Age")==null?"":request.getParameter("Age");

String called_form 			= request.getParameter("called_form")==null?"":request.getParameter("called_form");

String facility_id=(String) session.getValue("facility_id");
Integer patientAge = 0;
String or_bean_id = "@CAMenstrualHistDtlTransBean";
String or_bean_name = "eCA.CAMenstrualHistDtlTransBean";
CAMenstrualHistDtlTransBean bean = (CAMenstrualHistDtlTransBean)getBeanObject(or_bean_id, or_bean_name, request);
int[] ageDetails = bean.getMenstrualAgeDetails(facility_id);
int minAge = ageDetails[0];
int maxAge = ageDetails[1];


if (age != null && age.length() > 0) {

    if (age.indexOf('Y') != -1) {
        patientAge = Integer.parseInt(age.substring(0, age.indexOf('Y')));

    }
    else
    {
    	patientAge=Integer.parseInt(age);

    }
}
%>
<html>
<head>
<%if(called_form.equals("PAS_TRANSCATION_INVOKING")) {%>
<title>
	 <fmt:message key="eCA.ViewMenstrualHistDtl.label" bundle="${ca_labels}"/>
</title>
<%}%>
    <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
    <script src="../../eCommon/js/common.js" language="javascript"></script>
</head>
<%
if (!sex.equals("F")) {
%>
     <body>
        <table width="100%" height="100%">
            <tr>
                <td align="center" valign="middle">
                    This function is applicable for Female Patients Only.
                </td>
            </tr>
        </table>
    </body>
<%
} else if (sex.equals("F") && (patientAge < minAge || patientAge > maxAge)) {
%>
    <body>
        <table width="100%" height="100%">
            <tr>
                <td align="center" valign="middle">
                    Patient's Age falling outside the defined range. Recording Menstrual History Details is not allowed.
                </td>
            </tr>
        </table>
    </body>
<%
} else {
%>
    <iframe name='MenstrualHistDtlResultFrame' id='MenstrualHistDtlResultFrame' src='../../eCA/jsp/CAMenstrualHistDtlResult.jsp?facility_id=<%=facility_id%>&<%=request.getQueryString()%>' frameborder='0' scrolling='auto' noresize frameborder='0' style='height:30%;width:100vw'></iframe>
        <iframe name='MenstrualHistDtlTopFrame' id='MenstrualHistDtlTopFrame' src='../../eCA/jsp/CAMenstrualHistDtlTop.jsp?facility_id=<%=facility_id%>&<%=request.getQueryString()%>' frameborder='0' scrolling='auto' noresize frameborder='0' style='height:15%;width:100vw'></iframe>
        <iframe name='MenstrualHistDtlBottomFrame' id='MenstrualHistDtlBottomFrame' src='../../eCA/jsp/CAMenstrualHistDtlBottom.jsp?facility_id=<%=facility_id%>&<%=request.getQueryString()%>' frameborder='0' scrolling='auto' noresize frameborder='0' style='height:55%;width:100vw'></iframe>
    
<%
}
%>
</html>


