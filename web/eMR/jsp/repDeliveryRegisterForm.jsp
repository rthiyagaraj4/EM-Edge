<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
	
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%

    Connection con =null;
	String facility_id = (String) session.getValue("facility_id");
    String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");
	String sysdateSql = null;
	Statement stmt = null;
	ResultSet rs = null;
	String SystemDate = null;

try 
{
	con=ConnectionManager.getConnection(request);
   sysdateSql="select to_char(sysdate,'dd/mm/yyyy')SystemDate from dual";
	stmt = con.createStatement();
	rs	=	stmt.executeQuery(sysdateSql);
	if (rs.next() && rs != null)
	{
		SystemDate = rs.getString("SystemDate");
	}
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
%>

<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<form name="MRIPDLRG" id="MRIPDLRG" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<input type="hidden" name="current_date" id="current_date"	value="<%=SystemDate%>">
<table border="0" width='60%' cellpadding="0" cellspacing="0"  align='center'>
<th align='left' colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
<tr>
			<td align="center" width="35%">&nbsp;</td>
			<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="querydata" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
	    <tr>
			<td align='left' width='30%' class="label"><fmt:message key="eMR.DeliveryDate.label" bundle="${mr_labels}"/> &nbsp;</td>
			<td><input type='text' id='birthfrom' name='P_FM_ADMN_DATE' id='P_FM_ADMN_DATE' size='10' onBlur="CheckDate(this);ValidateDt(this,this,document.forms[0].current_date,'D')" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthfrom');"/>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>

			<td><input type='text' id='birthto' name='P_TO_ADMN_DATE' id='P_TO_ADMN_DATE' size='10' onBlur="CheckDate(this);ValidateDt(this,this,document.forms[0].current_date,'D')" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthto');"/>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>
	   </tr>
	    <tr>
			<td align='left' class="label" colspan=0><fmt:message key="eMR.IncludeBBA.label" bundle="${mr_labels}"/>&nbsp;</td>
			<td><input type='checkbox' value='Y' name='bba_stat_yn1' id='bba_stat_yn1' onClick="bbastatyn(this)">
			</td>

			<td>&nbsp</td>
	   </tr>
    <tr>
		<td colspan=3>&nbsp;</td>
	</tr>
   </table>


<input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="MRIPDLRG">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
<input type="hidden" name="bba_stat_yn" id="bba_stat_yn">
</form>
</body>
</html>
<%
} catch(Exception e) { /*  out.println("in else "+e); */e.printStackTrace(); }
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>


