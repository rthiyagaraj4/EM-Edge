<!DOCTYPE html>
<%@ page      import="java.sql.*,java.util.*, java.text.*, webbeans.eCommon.* , java.io.*,webbeans.op.CurrencyFormat,eOR.*,eOR.Common.*,org.apache.commons.codec.binary.Base64" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/FieldFormatMethods.js'></Script>
<script language="javascript" src="../../eBL/js/BLDischClearCancel.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><%= request.getParameter("title")%> </title> 
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
%>
	
	<center>
	<form name='DischClearReprintForm' id='DischClearReprintForm' method="Post">
	
<%
		java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_user = (String) p.getProperty("login_user");
		
		String facilityId = (String)session.getAttribute("facility_id");
		String locale = (String)session.getAttribute("LOCALE");
		String docType = request.getParameter("docType");
		String docNumber = request.getParameter("docNumber");
		String billDocTypeCode = request.getParameter("billDocTypeCode");
		String billDocNum = request.getParameter("billDocNum");
		String episodeType = request.getParameter("episodeType");
		String episodeId = request.getParameter("episodeId");
		
%>
	<table>
	
	<tr><td align="center"><fmt:message key="eBL.ReprintDischClearBill.label" bundle="${bl_labels}"/></td></tr>
	<tr>
		<td colspan=20>&nbsp;</td>
	</tr>	
	<tr>
	<td align="center">
	<select id="option_type" name="option_type" id="option_type" >
		<option value="D"><fmt:message key="eBL.DischargeClear.label" bundle="${bl_labels}"/></option>
		<option value="B"><fmt:message key="eBL.Bill.label" bundle="${bl_labels}"/></option>
		<option value="Y"><fmt:message key="eBL.BOTH.label" bundle="${bl_labels}"/></option>				
	</select>
	</td>
	</tr>
	<tr>
		<td colspan=20>&nbsp;</td>
	</tr>
	<tr>
	<td align="left">
		<input type='button' class='button' name='accept_btn' id='accept_btn' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")%>" onClick ='reprint();'>
	</td>
	<td align="left">
			<input type='button' class='button' name='cancel_btn' id='cancel_btn'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "eBL.exit.label", "bl_labels")%>"  onClick='cancelReprint();'>
	</td>
	</tr>
	
	</table>
	<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facilityId%>"/>
	<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>"/>
	<input type="hidden" name="login_user" id="login_user" id="login_user" value="<%=login_user%>"/>
	<input type=hidden name="docType" id="docType" id="docType" value="<%=docType%>">
	<input type=hidden name="docNumber" id="docNumber" id="docNumber" value="<%=docNumber%>">
	<input type=hidden name="billDocTypeCode" id="billDocTypeCode" id="billDocTypeCode" value="<%=billDocTypeCode%>">
	<input type=hidden name="billDocNum" id="billDocNum" id="billDocNum" value="<%=billDocNum%>">
	<input type=hidden name="episodeType" id="episodeType" id="episodeType" value="<%=episodeType%>">
	<input type=hidden name="episodeId" id="episodeId" id="episodeId" value="<%=episodeId%>">
	
	</form>
	</center>
</body>
</html>

