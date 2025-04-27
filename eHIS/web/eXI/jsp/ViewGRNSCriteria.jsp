<!DOCTYPE html>
<%@page
	import="java.util.*,eST.*,eST.Common.*,webbeans.eCommon.*,eCommon.Common.*,java.sql.*"%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
					|| (session.getAttribute("PREFERRED_STYLE") != "") 
					? (String) session.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eXI/js/ViewGRNS.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form>
<%
String strStDate = "", strEndDate = "";
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try 
{
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("SELECT TO_CHAR(SYSDATE-7,'DD/MM/YYYY') STDATE,TO_CHAR(SYSDATE,'DD/MM/YYYY') EDDATE FROM DUAL");
	rs = pstmt.executeQuery();
	if (rs != null && rs.next()) 
	{
		strStDate = rs.getString(1);
		strEndDate = rs.getString(2);
	}
} 
catch (Exception e1) 
{
	e1.printStackTrace(System.err);
	System.out.println(" Error in Criteria Page " + e1.getMessage());
} 
finally 
{
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
	if (con != null) ConnectionManager.returnConnection(con, request);
}
%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<tr>
<td align='left' class='label' width='5%'>&nbsp;</td>
<td align='left' class='label' width='35%'>
	<input id=GRNradio type=radio name=GRNradio value="U" CHECKED onCLick="prcFlag(this.value);">
	<fmt:message key="eXI.UnProcessed.Label" bundle="${xi_labels}" /> &nbsp;&nbsp;&nbsp;&nbsp;
	<input id=GRNradio type=radio name=GRNradio value="P" onCLick="prcFlag(this.value);">
	<fmt:message key="eXI.Processed.Label" bundle="${xi_labels}" /> &nbsp;&nbsp;&nbsp;&nbsp;
	<input id=GRNradio type=radio name=GRNradio value="E" onCLick="prcFlag(this.value);">
	<fmt:message key="Common.Error.label" bundle="${common_labels}" /> &nbsp;&nbsp;&nbsp;&nbsp;
</td>
<td align='left' class='label' width='45%'>
	<table>
	<tr id="dtrange">
	<td class="LABEL" nowrap align='left'>
		<fmt:message key="Common.periodfrom.label" bundle="${common_labels}" />
	</td>
	<td id='dtfrangeb'>
		&nbsp;
		<input type='text' name='from_date_time' id='from_date_time' value='<%=strStDate%>' size='10' maxLength='10' onKeyPress="return AllowDateFormat()" onBlur="CheckValidDate(this);checkWithSysDate(this);checkDateRange(this,to_date_time);">
		<input type='image' id="frcal" name="frcal" id="frcal" src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date_time');"> <IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
	</td>
	<td id='dtfrangec' class="LABEL" nowrap align='left'>
		<fmt:message key="Common.periodto.label" bundle="${common_labels}" />											 
	</td>
	<td id='dtfranged'>
		&nbsp;
		<input type='text' name='to_date_time' id='to_date_time' " value='<%=strEndDate%>' size='10' maxLength='10' onKeyPress="return AllowDateFormat()" onBlur="CheckValidDate(this);checkWithSysDate(this);checkDateRange(from_date_time,this);">
		<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('to_date_time');">
		<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
	</td>
	</tr>
	</table>
</td>
<td class='label' width='20%' align='right'>
	<input class="button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="getResults()" type="button">
	&nbsp;
</td>
</tr>
</table>
<input type='hidden' name='sys_date' id='sys_date' value='<%=strEndDate%>'>
<input type='hidden' name='st_date' id='st_date' value='<%=strStDate%>'>
</form>
</body>
</html>

