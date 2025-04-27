<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eBL.*, eBL.Common.*, eCommon.Common.*,webbeans.eCommon.*,com.ehis.util.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script language='javascript' src='../../eBL/js/BLApprStatusTrackSearch.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
	String view = checkForNull(request.getParameter("view"));
	//44856
	String cusName = checkForNull(request.getParameter("cusName"));
	String cusCode = checkForNull(request.getParameter("customerCode"));
	String strclientip = checkForNull(request.getParameter("strclientip"));
	String user = checkForNull(request.getParameter("user"));
	String encounterFromDate = checkForNull(request.getParameter("encounterFromDate"));
	String encounterToDate = checkForNull(request.getParameter("encounterToDate"));
	String episodeType = checkForNull(request.getParameter("episodeType"));
	String apprvSts_AAKHYN = checkForNull(request.getParameter("apprvSts_AAKHYN"));
	//44856
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='webcancel' id='webcancel' id='web_cancel' method='post'>
<div align='right'>
<table cellpadding='0' cellspacing='0' >
	<tr>
		<% if(view.equals("F")){%>
		<td colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td align='right' class='fields' width="15%"><input type="button" class='button' name="add_mod" id="add_mod"	id="add_mod"   value="Patient Demographic" onclick="callDemographic()"	/></td>
		<%}%>
		
		<td >
			<input type='button' name='close' id='close' value='Close' onClick='parent.returnValue="Y";closew()' class='button'>	
		</td>
	</tr>
		<input type='hidden' name='user' id='user' id='user' value='<%=user%>'>
		<input type='hidden' name='strclientip' id='strclientip' id='strclientip' value='<%=strclientip%>'>
		<input type='hidden' name='cusName' id='cusName' id='cusName' value='<%=cusName%>'> 
		<input type='hidden' name='customerCode' id='customerCode' id='customerCode' value='<%=cusCode%>'> 
		<input type='hidden' name='encounterFromDate' id='encounterFromDate' id='encounterFromDate' value='<%=encounterFromDate%>'>
		<input type='hidden' name='encounterToDate' id='encounterToDate' id='encounterToDate' value='<%=encounterToDate%>'>
		<input type='hidden' name='apprvSts_AAKHYN' id='apprvSts_AAKHYN' id='apprvSts_AAKHYN' value='<%=apprvSts_AAKHYN%>'>
		<input type='hidden' name='episodeType' id='episodeType' id='episodeType' value='<%=episodeType%>'>
		
</table>
</div>
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

