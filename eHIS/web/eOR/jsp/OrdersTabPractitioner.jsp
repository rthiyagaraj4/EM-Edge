<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eOR.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eOR/js/OrdersTab.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	
	String patient_class = request.getParameter("patient_class");
	String practitioner_id = request.getParameter("practitioner_id");
	String practitioner_name = request.getParameter("practitioner_name");
	if(practitioner_name==null || practitioner_name=="")
		practitioner_name = "";
	//String facility_id = request.getParameter("facility_id");
	String mode = request.getParameter("mode");
%>
<form name="frmLookupPractitioner" id="frmLookupPractitioner">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<%//out.println("<script>alert('@@@practitioner_id="+practitioner_id+"');</script>");
	if(practitioner_id.equals("") || practitioner_id.equals(" ") || practitioner_id == null)
	{
		practitioner_id = "*A";
%>
<tr>

<td class="label" width="25%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
 
<td  class="fields" width="25%">
<input type="text" name="selectedPractitioner" id="selectedPractitioner" value="All" size="30" maxlength="30"
onblur="before_searchCodeForPractitioner(selectedPractitioner)" ><input type="button" class="button" name="SearchPractitioner" id="SearchPractitioner" value="?" onClick="searchCodeForPractitioner(selectedPractitioner)">
<img src="../../eCommon/images/mandatory.gif" align="center" >
</td>
</tr>

<%//out.println("<script>alert('@@@practitioner_id22222="+practitioner_id+"');</script>");
	}//end of if
	else
	{
%>
<tr>
<td class="label"  width="25%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
 
<td  class="fields" width="25%">
<input type="hidden" name="selectedPractitioner" id="selectedPractitioner" value='<%=practitioner_id%>' readonly size="30" maxlength="30">
<input type="text" name="Practitioner" id="Practitioner" value='<%=practitioner_name%>' disabled>
<input type="button" class="button" name="SearchPractitioner" id="SearchPractitioner" value="?" disabled >
<img src="../../eCommon/images/mandatory.gif"  align="center">
</td>
</tr>

<%
	}//end of else
%>
	</table>
<!-- <input type="hidden" name="SQL_OR_ORDERS_TAB_PRACTITIONER_SELECT" id="SQL_OR_ORDERS_TAB_PRACTITIONER_SELECT"
value="<%//= OrRepositoryExt.getOrKeyValue("SQL_OR_ORDERS_TAB_PRACTITIONER_SELECT")%>" > -->
<input type="hidden" name="SQL_OR_PRACTITIONER_LOOKUP" id="SQL_OR_PRACTITIONER_LOOKUP" value="<%= OrRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP")%>" >
<input type="hidden" name="SQL_OR_PRACTITIONER_LOOKUP2" id="SQL_OR_PRACTITIONER_LOOKUP2" value="<%= OrRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_SQL2")%>" >
<input type="hidden" name="mode" id="mode" value='<%= mode %>'>
<input type="hidden" name="practitioner_id" id="practitioner_id" value='<%= practitioner_id %>'>
<input type="hidden" name="patient_class_desc" id="patient_class_desc" value="">
<input type="hidden" name="patient_class" id="patient_class" value='<%= patient_class %>'>
<input type="hidden" name="bean_id" id="bean_id" value="">
<input type="hidden" name="bean_name" id="bean_name" value="">
<input type="hidden" name="facility_id" id="facility_id" value="">
<input type="hidden" name="temp_selectedPractitioner" id="temp_selectedPractitioner" value="">
</form>
</body>
</html>

