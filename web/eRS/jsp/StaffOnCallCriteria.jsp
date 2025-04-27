<!DOCTYPE html>
<!--StaffOnCallCriteria.jsp
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi	
*	Created On		:	12th May 2005-->
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
String locale			= (String)session.getAttribute("LOCALE");


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"> </script>
<script language="javascript" src="../../eRS/js/RSMessages.js"></script> -->
<script language="javascript" src="../js/StaffOnCall.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
Connection conn = null;
PreparedStatement pstmt_workplace = null;
ResultSet rs_workplace = null;
PreparedStatement pstmt_workplacedesc = null;
ResultSet rs_workplacedesc = null;
PreparedStatement pstmt_sysdate = null;
ResultSet rs_sysdate= null;

String p_mode = request.getParameter("p_mode")== null ? "":request.getParameter("p_mode"); 
String p_locn_type = "IP";
String p_locn_code = request.getParameter("p_locn_code")== null ? "":request.getParameter("p_locn_code");
String login_facility_id =(String)session.getAttribute("facility_id");
String workplace_code = "";
String workplace_desc = "";
String sql_workplace = "";
String sql_sysdate = "";
String sql_workplacedesc = "";
String sysdate = "";
try{
	conn = ConnectionManager.getConnection(request);

if (p_mode.equals("CA"))
	{
				

		if (p_locn_type.equals("IP") || p_locn_type.equals("DC"))
		{
			sql_workplace ="select workplace_code from rs_locn_for_workplace where facility_id = ? and locn_code = (select nursing_unit_code from ip_nursing_unit where facility_id = ? and nursing_unit_code = ?)";
		}
		else if(p_locn_type.equals("OP") || p_locn_type.equals("EM"))
		{
			sql_workplace ="select workplace_code from rs_locn_for_workplace where facility_id = ? and locn_code = (select clinic_code from op_clinic where facility_id = ? and clinic_code = ?)";
		}

		pstmt_workplace = conn.prepareStatement(sql_workplace);

		pstmt_workplace.setString(1,login_facility_id);
		pstmt_workplace.setString(2,login_facility_id);
		pstmt_workplace.setString(3,p_locn_code);
		
		rs_workplace = pstmt_workplace.executeQuery();

		while((rs_workplace != null) && (rs_workplace.next()))
		{
			workplace_code = rs_workplace.getString("workplace_code")==null ? "":rs_workplace.getString("workplace_code");
		}
		if(pstmt_workplace != null)
			pstmt_workplace.close();
		if(rs_workplace != null)
			rs_workplace.close();

if(!(workplace_code.equals("")))
		{
			//sql_workplacedesc = "select workplace_desc from rs_workplace where facility_id = ? and workplace_code = ? ";	
			sql_workplacedesc = "select workplace_desc from rs_workplace_lang_vw where facility_id = ? and workplace_code = ? and language_id = ? ";	

		pstmt_workplacedesc = conn.prepareStatement(sql_workplacedesc);

		pstmt_workplacedesc.setString(1,login_facility_id);
		pstmt_workplacedesc.setString(2,workplace_code);
		pstmt_workplacedesc.setString(3,locale);
		
		rs_workplacedesc = pstmt_workplacedesc.executeQuery();

		while((rs_workplacedesc != null) && (rs_workplacedesc.next()))
		{
			
			workplace_desc = rs_workplacedesc.getString("workplace_desc")==null ? "":rs_workplacedesc.getString("workplace_desc");
		}
			

		sql_sysdate = "select to_char(sysdate,'dd/mm/yyyy') from dual";
		pstmt_sysdate = conn.prepareStatement(sql_sysdate);
		rs_sysdate = pstmt_sysdate.executeQuery();
					

		while(rs_sysdate.next())
			{
				sysdate = rs_sysdate.getString(1);
			}
			if(pstmt_sysdate != null)
				pstmt_sysdate.close();
			if(rs_sysdate != null)
				rs_sysdate.close();
			
		}


	}
}catch(Exception e)
{
		e.printStackTrace();
}
finally
{
	if(rs_workplace!=null) rs_workplace.close();
	if(rs_workplacedesc!=null) rs_workplacedesc.close();
	if(pstmt_workplace!=null) pstmt_workplace.close();
	if(pstmt_workplacedesc!=null) pstmt_workplacedesc.close();
	if(pstmt_sysdate != null) pstmt_sysdate.close();
	if(rs_sysdate != null) rs_sysdate.close();
    if(conn != null) ConnectionManager.returnConnection(conn,request);
}
%>

<form name='form_StaffOnCall' id='form_StaffOnCall' target='messageFrame'>
<table cellpadding=0 cellspacing=0 border=0 width="102%" align=center>
<%if(p_mode.equals("CA")){%>
<tr>
		<td width="30%"  align=right class="label"><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;&nbsp;&nbsp;</td>
		<td><input type='text' name='workplace_code' id='workplace_code' value='<%=workplace_desc%>' size='30'maxlength='30'>
		<input class='button' type='button' name='workplace_lookup' id='workplace_lookup' value='?' onClick='workplaceLookup(workplace_code)' Disabled>&nbsp;<img src="../../eCommon/images/mandatory.gif">
		</td>
		<td></td>
	</tr>
			<tr>
			
		<td width="30%"  align=right class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</td>
		<td><input type='text' name='date' id='date' id='id_date' size='15' value="<%=sysdate%>">
		<img  name='date_img' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCal(date,'id_date');">&nbsp;<img src="../../eCommon/images/mandatory.gif">
		</td>
		<td><input class='button' type='button' name='search_staff' id='search_staff' value='<fmt:message key="Common.search.label"bundle="${common_labels}"/>'align='right' onclick='Searchstaff();' ></td>
	</tr>
	<%}else{%>
	<tr>
		<td width="30%"  align=right class="label"><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;&nbsp;&nbsp;</td>
		<td><input type='text' name='workplace_desc' id='workplace_desc' value='' size='30'maxlength='30' readonly>
		<input class='button' type='button' name='workplace_lookup' id='workplace_lookup' value='?' onclick='workplaceLookup(workplace_desc);'><input type='hidden' name="workplace_code" id="workplace_code" value="">&nbsp;<img src="../../eCommon/images/mandatory.gif">
		</td>
		<td></td>
	</tr>
			
	<tr>
		<td width="30%"  align=right class="label"><fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</td>
		<td><input type='text' name='date' id='date' id='id_date'value='' size='15'>
		<img  name='date_img' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCal(date,'id_date');">&nbsp;<img src="../../eCommon/images/mandatory.gif">
		</td>
		<td><input class='button' type='button' name='search_staff' id='search_staff' value='<fmt:message key="Common.search.label"bundle="${common_labels}"/>'align='right' onclick='Searchstaff();' ></td>
	</tr>
			<%}%>
</table>
<input type=hidden name="login_facility_id" id="login_facility_id" value="<%=login_facility_id%>">
<input type=hidden name="p_mode" id="p_mode" value="<%=p_mode%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
</form>
</body>
</html>

