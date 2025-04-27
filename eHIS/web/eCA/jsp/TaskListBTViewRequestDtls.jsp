<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
    String locale = (String) property.getProperty("LOCALE");
%>
<head>
    
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	//Date Conversion added by Archana Dhal on 11/23/2010 related to incident no. IN025159.
	String request_date =  request.getParameter("request_date")==null?"":request.getParameter("request_date");
	request_date = com.ehis.util.DateUtils.convertDate(request_date,"DMYHM","en",locale);
	String request_by =  request.getParameter("request_by")==null?"":request.getParameter("request_by");

	//String classValue	= "gridData";
	

%>
<form name="antibody_details" id="antibody_details">

<table width="100%"  class="grid">
	<tr>
		<th ><fmt:message key="eCA.RequestDateTime.label" bundle="${ca_labels}"/></th>
		<th ><fmt:message key="eCA.RequestedBy.label" bundle="${ca_labels}"/></th>
	</tr>
	<tr>
		<td class='gridData'><%=request_date%></td>
		<td class='gridData'><%=request_by%></td>
	</tr>


</table>
</form>
</body>
</html>

