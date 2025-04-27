<!DOCTYPE html>
<%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StafRosterCriteria.jsp
*	Purpose 		:	
*	Modified By		:	Karabi S.
*	Modified On		:	2nd Dec 2004.
* --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/RSCommonFunction.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/StaffRoster.js"></script>
<script language="javascript" src="../js/StaffRosterArrows.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
Connection Con			= null;
PreparedStatement pstmt_currdate = null;
PreparedStatement pstmt_staff = null;
ResultSet rs_currdate		= null;
ResultSet rs_staff		= null;

String staff_name="";
String lookup_status="";
String mode	   = request.getParameter("p_mode")==null?"":request.getParameter("p_mode");
String staff_id	   = request.getParameter("p_staff_id")==null?"":request.getParameter("p_staff_id");
String role_type	   = request.getParameter("p_role_type")==null?"":request.getParameter("p_role_type");
String from_date="";
String to_date="";

Con=ConnectionManager.getConnection(request);
if(mode.equals("CA")) 
{
try
{
String sql="select staff_name,to_char(sysdate,'dd/mm/yyyy') date_fm, to_char(last_day(sysdate),'dd/mm/yyyy') date_to from am_staff_vw where role_type = ? and staff_id = ?";
pstmt_staff=Con.prepareStatement(sql);

pstmt_staff.setString(1,role_type);
pstmt_staff.setString(2,staff_id);

rs_staff=pstmt_staff.executeQuery();
if(rs_staff!=null)
{
	while(rs_staff.next())
	{
		staff_name=rs_staff.getString("staff_name");
		from_date=rs_staff.getString("date_fm");
		to_date=rs_staff.getString("date_to");
	}
}
}
catch(Exception exp)
{
	out.println(exp.toString());
}
finally
{
	if(rs_staff!=null) rs_staff.close();
	if(pstmt_staff!=null) pstmt_staff.close();
}
	lookup_status="disabled";
}
else
{
	staff_name="";
	staff_id="";
	lookup_status="";
    role_type="";
	from_date="";
	to_date="";
}

String function_id = request.getParameter( "function_id");
String facility_id	=(String)session.getValue( "facility_id" ) ;
String currentdate="";

try
{
pstmt_currdate=Con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') d from dual ");
rs_currdate=pstmt_currdate.executeQuery();
rs_currdate.next();
currentdate = rs_currdate.getString("d");
}
catch(Exception e){}
finally
{
	if(rs_currdate !=null) rs_currdate.close();
	if(pstmt_currdate !=null) pstmt_currdate.close();
	 ConnectionManager.returnConnection(Con,request);
}
%>

<form name='StaffRosterCriteriaform' id='StaffRosterCriteriaform' >
<table id='t1' cellpadding=0 cellspacing=0 border=0 width="100%" align=center>
<tr>
	<td width="40%"  align=right class="label"><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/>&nbsp;</td>
	<td >&nbsp;<input type=text name="staff_Id" id="staff_Id" value="<%=staff_name%>" readonly size="30" ><input class='button' type=button name="stafflookup_button" id="stafflookup_button" value="?"  onClick='viewstaff(staff_Id,staff_name,role_type_desc)' <%=lookup_status%>>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
	<td  id='role_type_desc' align="left" class="label" width="15%">
	<td class=label colspan='4'>&nbsp;&nbsp;</td>
</tr>
<tr>
	<td width="40%"  align=right class="label"><fmt:message key="Common.duration.label" bundle="${common_labels}"/>&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;</td>

	<td>&nbsp;<input type=text name="from_date" id="from_date" id='id_from_date' value="<%=from_date%>" size="11" maxlength="10" onBlur='if(CheckDate(this))validate("FROM_DATE_LESS_SYSDATE");'><img  name='from_date_img' src='../../eCommon/images/CommonCalendar.gif' onclick="return showCal(from_date,'id_from_date');">&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>

	<td width="20%"  align=right class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>

	<td>&nbsp;<input type=text name="to_date" id="to_date" id='id_to_date' value="<%=to_date%>" size="11" maxlength="10"   onBlur='if(CheckDate(this))validate("TO_DT_GR_EQ_FM_DT");//getdate();'><img  name='to_date_img' src='../../eCommon/images/CommonCalendar.gif' onclick="return showCal(to_date,'id_to_date');">&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>

	<input type='hidden' name='from_date1' id='from_date1' value=''>
	<input type='hidden' name='to_date1' id='to_date1' value=''>

	<td width="20%"  align=right class="label">&nbsp;&nbsp;</td>
	<td align='center' colspan='1'>&nbsp;<input class='button' type=button name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'onClick='RosterDetails()'></td>
	<td width="20%"  align=right class="label">&nbsp;&nbsp;</td>
		
</tr>
<tr>
	<td colspan="7">&nbsp;</td>
</tr>

<%-------------------------datas returned frm skill modal window--------------------------------%>

<input type='hidden' name='staffID' id='staffID' value=''>
<input type='hidden' name='staffcode' id='staffcode' value=''>
<input type='hidden' name='funcVal' id='funcVal' value=''>
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
<input type='hidden' name='db_action' id='db_action' value=''>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type='hidden' name='staff_name' id='staff_name' value='<%=staff_id%>'>
<input type='hidden' name='role_type' id='role_type' value='<%=role_type%>'>
<input type='hidden' name='mode' id='mode' value=''>
<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>
<input type='hidden' name='getFlag' id='getFlag' value='N'>
<input type=hidden name='p_from' id='p_from'  value="" >
<input type=hidden name='p_to' id='p_to'  value="" >
<input type=hidden name='p_from_p rev' id='p_from_p rev'  value="" >
<input type=hidden name='p_to_prev' id='p_to_prev'  value="" >
<input type=hidden name='locale' id='locale'  value="<%=locale%>" >
<input type=hidden name='callmode' id='callmode' value="<%=mode%>">
<%-------------------------datas returned frm skill modal window--------ends--------------------%>
</form>
</body>
</html>

