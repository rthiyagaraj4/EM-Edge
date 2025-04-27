<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
01/10/2024     68508     krishna pranay             13/10/2024  Ashwini Ragupathi  ML-MMOH-CRF-1759							
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>

<%  
String	remarks =  request.getParameter("remarks")==null?"":request.getParameter("remarks");
String	event_remarks =  request.getParameter("event_remarks")==null?"":request.getParameter("event_remarks");
String	srl_no =  request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
String	patient_id =  request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

String	modifiedRemarks =  request.getParameter("modifiedRemarks")==null?"":request.getParameter("modifiedRemarks");

if (!modifiedRemarks.equals("")) {		
%>
<HTML>
<title>
	 <fmt:message key="eCA.modifiedRemarks.label" bundle="${common_labels}"/>
</title>
<%}else{ %>
<title>
	 <fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
</title>
<%} %>
<body>
<br>
	<div>
<div 
    id="curr_remarks" 
    style="border: 1px solid #ccc; padding: 5px; width: 400px; height: 100px;  overflow: auto;" 
    readonly
>
    <% if (!modifiedRemarks.equals("")) { %>
        <%= modifiedRemarks %>
    <% } else { %>
        <%= remarks %>
    <% } %>
    
    <% if(!event_remarks.equals("")){%>
    <span style="display: block; color: red; margin-top: 50px;"><%= event_remarks%></span>
    <%} %>
</div>

</div>
<br>
<div align='Right'>	
	<button type="button" onclick="javascript:window.close()"><fmt:message key="Common.close.label" bundle="${common_labels}"/></button>
</div>
</body>
</HTML>
