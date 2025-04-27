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
-----------------------------------------------------------------------
Date			Edit History	Name        Description
-----------------------------------------------------------------------
?				100         	?     		created	 
15/11/2012		IN030472		Ramesh G	Bru-HIMS-CRF-031[Patient instructions to be printed on demand] 								 
27/11/2012		IN036453		Ramesh G	Patient Instruction Print->In Local Language (Thai), the Print and Close Buttons is not displayed correctly. 								 
-----------------------------------------------------------------------
*/
%>

<%@ page contentType="text/html; charset=UTF-8" %> <!-- IN036453 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<% 
request.setCharacterEncoding("UTF-8");  
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>

<html>
	<head>
	<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function printit() 
			{	
				//changes made by Anbarasi 
					
				 if (parent.frames[0]) {
						parent.frames[0].focus();
					}
					window.print();	
				
				
			}
		</script>
	</head>
	<body>
		<form name="PatientInstructionsButtonForm" id="PatientInstructionsButtonForm">
			<table  border='0' align="center" width='100%' cellpadding='0' cellspacing='0'>
				<tr>
					<td width="100%" align='RIGHT' style="padding-right:30px">
						<input type='button' class='button' name='print' id='print'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>" onClick='printit();'>&nbsp;
						<input type='button' class='button' name='close' id='close'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='toCloseTopShowModal();'>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

