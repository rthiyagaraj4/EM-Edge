<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
 
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='StyleSheet' href='../../eCommon/html/Tabs.css'></link>
<script>

</script>


<% if(sStyle!=null && sStyle.equals("IeStyle.css")) { %>
<STYLE TYPE="text/css">
	A:active { 	COLOR: white; }
	A:visited { COLOR: white; }
	A:link { COLOR: white; }
 	</STYLE>
<% } %>
</head> 
<%
	String bean_id				= "Or_CareSet" ;
	String bean_name			= "eOR.CareSetBean";
	String bill_install_Yn		= "N";
	String order_set_code		= "";

	CareSetBean bean			= (CareSetBean)getBeanObject(bean_id,bean_name,request ) ;

	try
	{
		bill_install_Yn			= bean.getBillingInstalledYN();
		if(bill_install_Yn == null)
		{
			bill_install_Yn="N";
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
<!-- onMouseDown="CodeArrest()"  onKeyDown="lockKey()	 -->
<body topmargin="0" onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name="tab" id="tab">
<table border="1" width="60%" cellspacing="1" cellpadding="3" align=left>
<tr>
		<td id="synonymsTab" class="normal" width="15%" height="20" onClick='parent.parent.display("S");'><a href='#'><fmt:message key="eOR.Synonyms.label" bundle="${or_labels}"/></a></td>

		<td id="componentTab" class="normal" width="15%" height="20" onClick='parent.parent.display("C");'><a href='#'><fmt:message key="Common.Component.label" bundle="${common_labels}"/></a></td>

		<td id="explanatoryTab" class="normal" width="15%" height="20" onClick='parent.parent.display("E");'><a href='#'><fmt:message key="eOR.ExplanatoryText.label" bundle="${or_labels}"/></a></td>

		<td id="settingsTab" class="normal" width="15%" height="20" onClick='parent.parent.display("Se");'><a href='#'><fmt:message key="eOR.Settings.label" bundle="${or_labels}"/></a></td>
		<%
		if(bill_install_Yn.equals("Y"))
		{
		%>
			<td align="center" id="billingTab" class="normal" width="15%" height="20" onClick='parent.parent.display("B");'><a href='#'><fmt:message key="Common.Billing.label" bundle="${common_labels}"/></a></td>
		<%
		}
		%>

</tr>
</table>
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
</form>
</body>
</html>

