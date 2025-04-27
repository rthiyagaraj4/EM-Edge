<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@ page import="java.text.*,webbeans.eCommon.*" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<% 
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")? (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../js/ADRReporting.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<!-- <body> -->
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="formAdrReportingDruglookupSearch" id="formAdrReportingDruglookupSearch">
<%	
			String patient_id=request.getParameter("patient_id");
%>
			<table border="0" cellpadding="0" cellspacing="0" width="80%" align="center">
				<tr> 
					<td class='label' width ='80%'><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>&nbsp;&nbsp;
						 <input type='text' name='txt_drug_desc' id='txt_drug_desc' size='50' maxlength='180' >&nbsp;&nbsp;
						 <select name="drug_search_by" id="drug_search_by" >
								<option value="S" selected><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
								<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
								<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>                
						</select>
						<input type='button' name='btn_search' id='btn_search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='loaddrugdetails("<%=patient_id%>")' class='button'>
					</td>
				</tr>
			</table> 
		</form>
	</body>
</html>

