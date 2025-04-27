<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	14 mar 2005
--%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><!-- <script language="JavaScript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<%
	Connection conn = null;
	PreparedStatement pstmt_schedule_date = null;
	PreparedStatement pstmt_viewStaff = null;

	ResultSet rs_schedule_date = null;
	ResultSet rs_viewStaff = null;

	String p_schedule_date = "";
	String sql_schedule_date = "";
	String p_date  = request.getParameter("p_date");
	int p_cell_no  = Integer.parseInt(request.getParameter("p_cell_no"));
	try{	
		conn = ConnectionManager.getConnection(request);
		sql_schedule_date="select to_char(to_date(?,'dd/mm/yyyy') + ?,'dd/mm/yyyy') p_schedule_date from dual";

		pstmt_schedule_date=conn.prepareStatement(sql_schedule_date);
		pstmt_schedule_date.setString(1,p_date);
		pstmt_schedule_date.setInt(2,p_cell_no);
		rs_schedule_date = pstmt_schedule_date.executeQuery();
		while(rs_schedule_date!=null && rs_schedule_date.next()){
		p_schedule_date = rs_schedule_date.getString("p_schedule_date");
		}
		if(pstmt_schedule_date != null)
			pstmt_schedule_date.close();
		if(rs_schedule_date != null)
			rs_schedule_date.close();
%>
<title><fmt:message key="eRS.ViewSchedule.label" bundle="${rs_labels}"/> <%=p_schedule_date%></title>
<%
		String p_facility_id  = request.getParameter("p_facility_id");
		String p_role_type  = request.getParameter("p_role_type");
		String p_staff_id  = request.getParameter("p_staff_id");
		
		String sql_viewStaff = "";
		String workplace = "";
		String shift_desc = "";
		String shift_start = "";
		String shift_end = "";
		String classValue = "";
		int i = 0;
		String prev_workplace = "";
		String disp_wrk="";

		//sql_viewStaff = "select b.workplace_desc workplace, c.short_desc||'('||c.mnemonic_key||')' shift_desc,to_char(a.shift_start_time,'dd/mm/yyyy hh24:mi') shift_start,       to_char(a.actual_end_time,'dd/mm/yyyy hh24:mi') shift_end from rs_work_schedule a, rs_workplace b, am_shift c where a.role_type = ? and a.staff_id = ? and a.schedule_date = to_date(?,'dd/mm/yyyy') and a.facility_id = ? and b.facility_id = a.facility_id and b.workplace_code = a.workplace_code  and c.shift_code = a.shift_code order by b.workplace_desc, c.short_desc, a.shift_start_time" ;
		sql_viewStaff = "select b.workplace_desc workplace, c.short_desc||'('||c.mnemonic_key||')' shift_desc,to_char(a.shift_start_time,'dd/mm/yyyy hh24:mi') shift_start,       to_char(a.actual_end_time,'dd/mm/yyyy hh24:mi') shift_end from rs_work_schedule a, rs_workplace_lang_vw b, am_shift_lang_vw c where a.role_type = ? and a.staff_id = ? and a.schedule_date = to_date(?,'dd/mm/yyyy') and a.facility_id = ? and b.facility_id = a.facility_id and b.workplace_code = a.workplace_code  and c.shift_code = a.shift_code and b.language_id = ? and c.language_id = b.language_id order by b.workplace_desc, c.short_desc, a.shift_start_time" ;
		pstmt_viewStaff=conn.prepareStatement(sql_viewStaff);

		pstmt_viewStaff.setString(1,p_role_type);
		pstmt_viewStaff.setString(2,p_staff_id);
		pstmt_viewStaff.setString(3,p_schedule_date);
		pstmt_viewStaff.setString(4,p_facility_id);
		pstmt_viewStaff.setString(5,locale);
		rs_viewStaff = pstmt_viewStaff.executeQuery();
		
%>
</head>
<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="form_ManageWorkScheduleViewStaffDaySchedule" id="form_ManageWorkScheduleViewStaffDaySchedule">
<table cellpadding=0 cellspacing=0 border=1 width="103%" align='right'>
<tr>
	<th><fmt:message key="eRS.Workplace.label" bundle="${rs_labels}"/></th>
	<th><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.Start.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.time.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eRS.End.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="Common.time.label" bundle="${common_labels}"/></th>
</tr>
<%
	
	  while(rs_viewStaff!=null && rs_viewStaff.next())
	  {
			workplace = rs_viewStaff.getString("workplace");
			shift_desc = rs_viewStaff.getString("shift_desc");
			shift_start = rs_viewStaff.getString("shift_start");
			shift_end = rs_viewStaff.getString("shift_end");

			disp_wrk = workplace;						
			if(workplace.equals(prev_workplace))
				disp_wrk="&nbsp;";

			if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
			else
			classValue = "QRYODD" ;
			prev_workplace = workplace ;
%>
			<tr>
			<td align='left' class=<%=classValue%>><%=disp_wrk%></td>
			<td align='left' class=<%=classValue%>><%=shift_desc%></td>
			<td align='left' class=<%=classValue%>><%=shift_start%></td>
			<td align='left' class=<%=classValue%>><%=shift_end%></td>
			</tr>
<%
			i++;
		}
		
	}
	catch (Exception e)
	{
			out.println(e.toString());
	}
	finally{
		
		if(rs_schedule_date!=null) rs_schedule_date.close();
		if(rs_viewStaff!=null) rs_viewStaff.close();
		
		if(pstmt_schedule_date!=null) pstmt_schedule_date.close();
		if(pstmt_viewStaff!=null) pstmt_viewStaff.close();
		
		ConnectionManager.returnConnection(conn,request);
	}
%>
</form>
</body>
</html>

