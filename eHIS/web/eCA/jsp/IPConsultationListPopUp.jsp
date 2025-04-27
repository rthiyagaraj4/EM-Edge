<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
		<head><title><fmt:message key="eCA.GenerateList.label" bundle="${ca_labels}"/></title>

	<%
		  request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		  String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		//String locale = (String) p1.getProperty("LOCALE");
		String cons_desc		=	request.getParameter("cons_desc")==null?"":request.getParameter("cons_desc");

		

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script Language="JavaScript" src='../../eCA/js/IPConsultationList.js'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>

	<body onKeyDown="lockKey()">
		<form name='IPConsultationListPopUpForm' id='IPConsultationListPopUpForm' >
		<table border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
		<tr><td class='label' width='50%'><fmt:message key="eCA.ConsultationListDesc.label" bundle="${ca_labels}"/></td>
			<td class='fields' width='50%'><input type='text' size=15 maxlength='15' name='cons_list_desc' id='cons_list_desc' onkeypress='javascript:if(event.keyCode==13) return false;'><%=cons_desc%></td>
		</tr>
		<tr>
			<td class='label' width='25%' ></td><td class='label' width='25%' align='right'><input type='button' class='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' id='cons_btn'  name='cons_btn' onClick="click_ok();">
			<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' id='cancel_btn'  name='cancel_btn' onClick="const dialogTag = parent.document.getElementById('dialog_tag');dialogTag.close();"></td>
		</tr>

		</table>
		</form>
  </body>
</html>

