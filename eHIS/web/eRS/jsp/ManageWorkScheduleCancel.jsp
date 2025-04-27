<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	P.Anuradha
*	Created On		:	16 Feb 2005
-->
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
<title><fmt:message key="eRS.ChangeShift.label" bundle="${rs_labels}"/></title>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="javascript" src="../../eRS/js/RSMessages.js"></script> -->
<script language="javascript" src="../../eRS/js/ManageWorkScheduleCancel.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
	Connection conn=null;

	PreparedStatement pstmt=null;
	ResultSet rset=null;

	PreparedStatement pstmt_reason=null;
	ResultSet rset_reason=null;

	PreparedStatement pstmt_sos=null;
	ResultSet rset_sos=null;

	PreparedStatement pstmt_requirement_varying=null;
	ResultSet rset_requirement_varying=null;

	PreparedStatement pstmt_requirement_constant=null;
	ResultSet rset_requirement_constant=null;

	PreparedStatement pstmt_locn=null;
	ResultSet rset_locn=null;

	PreparedStatement pstmt_staff=null;
	ResultSet rset_staff=null;

	PreparedStatement pstmt_sch_type=null;
	ResultSet rset_sch_type=null;


	PreparedStatement pstmt_sch_type1=null;
	ResultSet rset_sch_type1=null;


	PreparedStatement pstmt_activity=null;
	ResultSet rset_activity=null;

	conn = ConnectionManager.getConnection(request);

	int count=0;

	try{
		int cell_no=Integer.parseInt(request.getParameter("p_cell_no")==null?"":request.getParameter("p_cell_no"));
		String date=request.getParameter("p_date")==null?"":request.getParameter("p_date");
		String facility_id=request.getParameter("p_facility_id")==null?"":request.getParameter("p_facility_id");
		String workplace_code=request.getParameter("p_workplace_code")==null?"":request.getParameter("p_workplace_code");
		String role_type=request.getParameter("p_role_type")==null?"":request.getParameter("p_role_type");
		String staff_id=request.getParameter("p_staff_id")==null?"":request.getParameter("p_staff_id");
		String position_code=request.getParameter("p_position_code")==null?"":request.getParameter("p_position_code");
		String p_shift_code=request.getParameter("p_shift_code")==null?"":request.getParameter("p_shift_code");

		String schedule_date="";
		String requirement_id_varying="";
		String requirement_id_constant="";
		String requirement_id="";
		String shift_code="";
		String schedule_type="";
		String shift_desc="";
		String shift_start_time="";
		String shift_mnemonic="";
		String shift_end_time="";
		String valid_yn="";
		String activity="";
		String select_enabled="";
		String productive_flag="";
		String shift_indicator="";

		StringBuffer temp_code = new StringBuffer("'" + p_shift_code + "'");

		while(temp_code.toString().indexOf('|') != -1)	{
		   int index = temp_code.toString().indexOf('|');
		   temp_code.replace(index,index+1,"','");
		}
		p_shift_code = temp_code.toString();
//		p_shift_code=p_shift_code.substring(1,(p_shift_code.length())-1);


		String sql_sch_date="select to_char((to_date(?,'dd/mm/yyyy') + ?),'dd/mm/yyyy') schedule_date from dual";

		pstmt_sch_type1=conn.prepareStatement(sql_sch_date);
		pstmt_sch_type1.setString(1,date);
		pstmt_sch_type1.setInt(2,cell_no);

		rset_sch_type1=pstmt_sch_type1.executeQuery();
		if(rset_sch_type1!=null)	{
		  while(rset_sch_type1.next()) {
			  schedule_date=rset_sch_type1.getString("schedule_date");
		  }
		}
		
		if(pstmt_sch_type1 != null)
			pstmt_sch_type1.close();
		if(rset_sch_type1 != null)
			rset_sch_type1.close();

		String sql_activity="select rs_activity_log_seq.nextval activity_id from dual";
		pstmt_activity=conn.prepareStatement(sql_activity);
		rset_activity=pstmt_activity.executeQuery();

		if(rset_activity!=null)	{
			while(rset_activity.next()){
				activity=rset_activity.getString("activity_id");
			}
		}
		if(pstmt_activity != null)
			pstmt_activity.close();
		if(rset_activity != null)
			rset_activity.close();

		String sql_locn="select locn_type from rs_locn_for_workplace where facility_id=? and workplace_code=?";

		pstmt_locn=conn.prepareStatement(sql_locn);

		pstmt_locn.setString(1,facility_id);
		pstmt_locn.setString(2,workplace_code);

		String locn_type="";

		rset_locn=pstmt_locn.executeQuery();
		if(rset_locn!=null)	{
			while(rset_locn.next()){ 
				locn_type=rset_locn.getString("locn_type");
			}
		}
		if(pstmt_locn != null)
			pstmt_locn.close();
		if(rset_locn != null)
			rset_locn.close();

		String sql_staff="select staff_type from rs_staff_for_workplace where facility_id=? and workplace_code=? and staff_id=? and role_type=?";
		pstmt_staff=conn.prepareStatement(sql_staff);
		pstmt_staff.setString(1,facility_id);
		pstmt_staff.setString(2,workplace_code);
		pstmt_staff.setString(3,staff_id);
		pstmt_staff.setString(4,role_type);

		String staff_type="";

		rset_staff=pstmt_staff.executeQuery();

		if(rset_staff!=null){
			while(rset_staff.next()){
				staff_type=rset_staff.getString("staff_type");
			}
		}
		if(pstmt_staff != null)
			pstmt_staff.close();
		if(rset_staff != null)
			rset_staff.close();

		String sql_sos="select max_continuous_work_duration, curr_shift_cancellation_yn, durn_for_cancel_from_sos from rs_parameter where facility_id = ?";

		pstmt_sos=conn.prepareStatement(sql_sos);

		String curr_cancel_yn="";
		String durn_for_curr_cancel_from_sos="";

		pstmt_sos.setString(1,facility_id);
		rset_sos=pstmt_sos.executeQuery();
		if(rset_sos!=null){
			while(rset_sos.next()){
				curr_cancel_yn=rset_sos.getString("curr_shift_cancellation_yn")==null?"":rset_sos.getString("curr_shift_cancellation_yn");
				durn_for_curr_cancel_from_sos=rset_sos.getString("durn_for_cancel_from_sos")==null?"":rset_sos.getString("durn_for_cancel_from_sos");
			}
		}
		if(pstmt_sos != null)
			pstmt_sos.close();
		if(rset_sos != null)
			rset_sos.close();

		String sql_requirement_varying="Select requirement_id from rs_workplace_requirement where facility_id = ? and workplace_code = ? and requirement_type = 'V' and to_date(?,'dd/mm/yyyy') between requirement_date_fm and requirement_date_to ";

		pstmt_requirement_varying=conn.prepareStatement(sql_requirement_varying);

		pstmt_requirement_varying.setString(1,facility_id);
		pstmt_requirement_varying.setString(2,workplace_code);
		pstmt_requirement_varying.setString(3,schedule_date);

		rset_requirement_varying=pstmt_requirement_varying.executeQuery();
		if(rset_requirement_varying!=null){
			while(rset_requirement_varying.next()){
			requirement_id_varying=rset_requirement_varying.getString("requirement_id");
			}
		}
		if(pstmt_requirement_varying != null)
			pstmt_requirement_varying.close();
		if(rset_requirement_varying != null)
			rset_requirement_varying.close();

		if(requirement_id_varying==""){
			String sql_requirement_constant="Select requirement_id from rs_workplace_requirement where facility_id = ? and workplace_code = ? and requirement_type = 'C' and requirement_date_fm is null and requirement_date_to is null";

			pstmt_requirement_constant=conn.prepareStatement(sql_requirement_constant);

			pstmt_requirement_constant.setString(1,facility_id);
			pstmt_requirement_constant.setString(2,workplace_code);


			rset_requirement_constant=pstmt_requirement_constant.executeQuery();
			if(rset_requirement_constant!=null){
				while(rset_requirement_constant.next()){
					requirement_id_constant=rset_requirement_constant.getString("requirement_id");
				}
			}
			if(pstmt_requirement_constant != null)
				pstmt_requirement_constant.close();
			if(rset_requirement_constant != null)
				rset_requirement_constant.close();
		}

		if(requirement_id_varying.equals(""))
			requirement_id=requirement_id_constant;
		else if(!requirement_id_varying.equals(""))
			requirement_id=requirement_id_varying;
%>
			<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
			<form name="ManageWorkScheduleCancel_Form" id="ManageWorkScheduleCancel_Form" method="post" action="../../servlet/eRS.ManageWorkScheduleCancelServlet" target="MessageFrame">
			<table cellpadding=0 cellspacing=0 border=0 width="100%">
			<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			<tr>
			<td width="20%" class="data" align="right"><fmt:message key="eRS.ScheduleDate.label" bundle="${rs_labels}"/>&nbsp;&nbsp;</td>
			<td width="80%" class="label" align="left"><%=schedule_date%></td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			</table>
			<table cellpadding=0 cellspacing=0 border=0 width="100%">
			<tr>
			<th width="30%" align="right"><fmt:message key="eRS.AllocatedShifts.label" bundle="${rs_labels}"/></th>
			<th>&nbsp;</th>
			<th width="80%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
<%
			//String sql="select a.productive_flag productive_flag,a.shift_indicator shift_indicator,a.shift_code shift_code, a.long_desc shift_desc, a.mnemonic_key shift_mnemonic,to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss') shift_start_time,to_char(b.shift_end_time,'dd/mm/yyyy hh24:mi:ss') shift_end_time,decode('Y','N','N',decode(sign(sysdate - (b.shift_start_time +(((to_number(substr(?,1,2))*60) + to_number(substr(?,4))) / (24*60)))),1,'N','Y')) valid_yn from am_shift a, rs_work_schedule b where a.shift_code in ("+p_shift_code+") and a.shift_code = b.shift_code and b.facility_id = ? and b.workplace_code = ? and b.role_type = ?   and b.staff_id = ? and trunc(sysdate) = to_date(?,'dd/mm/yyyy') and sysdate between b.shift_start_time and b.actual_end_time union all select a.productive_flag,a.shift_indicator,b.shift_code,a.long_desc,a.mnemonic_key,	to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss'),	to_char(b.shift_end_time,'dd/mm/yyyy hh24:mi:ss'),'Y' valid_yn from am_shift a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type=? and b.staff_id=? and b.schedule_date=to_date(?,'dd/mm/yyyy') and b.shift_start_time > sysdate and b.shift_code in ("+p_shift_code+") and a.shift_code=b.shift_code";
			String sql="select a.productive_flag productive_flag,a.shift_indicator shift_indicator,a.shift_code shift_code, a.long_desc shift_desc, a.mnemonic_key shift_mnemonic,to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss') shift_start_time,to_char(b.shift_end_time,'dd/mm/yyyy hh24:mi:ss') shift_end_time,decode('Y','N','N',decode(sign(sysdate - (b.shift_start_time +(((to_number(substr(?,1,2))*60) + to_number(substr(?,4))) / (24*60)))),1,'N','Y')) valid_yn from am_shift_lang_vw a, rs_work_schedule b where a.shift_code in ("+p_shift_code+") and a.shift_code = b.shift_code and b.facility_id = ? and b.workplace_code = ? and b.role_type = ?   and b.staff_id = ? and trunc(sysdate) = to_date(?,'dd/mm/yyyy') and sysdate between b.shift_start_time and b.actual_end_time and a.language_id = ? union all select a.productive_flag,a.shift_indicator,b.shift_code,a.long_desc,a.mnemonic_key,to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss'), to_char(b.shift_end_time,'dd/mm/yyyy hh24:mi:ss'),'Y' valid_yn from am_shift_lang_vw a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type=? and b.staff_id=? and b.schedule_date=to_date(?,'dd/mm/yyyy') and b.shift_start_time > sysdate and b.shift_code in ("+p_shift_code+") and a.shift_code=b.shift_code and a.language_id = ?";

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,durn_for_curr_cancel_from_sos);
			pstmt.setString(2,durn_for_curr_cancel_from_sos);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,workplace_code);
			pstmt.setString(5,role_type);
			pstmt.setString(6,staff_id);
			pstmt.setString(7,schedule_date);
			pstmt.setString(8,locale);
			pstmt.setString(9,facility_id);
			pstmt.setString(10,workplace_code);
			pstmt.setString(11,role_type);
			pstmt.setString(12,staff_id);
			pstmt.setString(13,schedule_date);
			pstmt.setString(14,locale);

			rset=pstmt.executeQuery();
			if(rset!=null)	{
				while(rset.next())	{
					productive_flag=rset.getString("productive_flag");
					shift_indicator=rset.getString("shift_indicator");
					shift_code=rset.getString("shift_code");
					shift_desc=rset.getString("shift_desc");
					shift_mnemonic=rset.getString("shift_mnemonic");
					shift_start_time=rset.getString("shift_start_time");
					shift_end_time=rset.getString("shift_end_time");
					valid_yn=rset.getString("valid_yn");
					if(valid_yn.equals("Y")){
						select_enabled="enabled";
						count++;
					}
					else if(valid_yn.equals("N")){
						select_enabled="disabled";
					}

					String sql_sch_type="select schedule_type from rs_work_schedule where facility_id=? and workplace_code=? and schedule_date=to_date(?,'dd/mm/yyyy') and staff_id=? and shift_code=?";

					pstmt_sch_type=conn.prepareStatement(sql_sch_type);

					pstmt_sch_type.setString(1,facility_id);
					pstmt_sch_type.setString(2,workplace_code);
					pstmt_sch_type.setString(3,schedule_date);
					pstmt_sch_type.setString(4,staff_id);
					pstmt_sch_type.setString(5,shift_code);

					rset_sch_type=pstmt_sch_type.executeQuery();

					if(rset_sch_type!=null)	{
						while(rset_sch_type.next()){
							schedule_type=rset_sch_type.getString("schedule_type");
%>
							<tr>
							<td class="label" align="right"><%=shift_desc%></td>
							<input type=hidden name="shift_code<%=count%>" id="shift_code<%=count%>" value="<%=shift_code%>">
							<input type=hidden name="shift_start_time<%=count%>" id="shift_start_time<%=count%>" value="<%=shift_start_time%>">
							<input type=hidden name="shift_end_time<%=count%>" id="shift_end_time<%=count%>" value="<%=shift_end_time%>">
							<td class="label" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=shift_mnemonic%></td>
							<input type=hidden name="shift_mnemonic<%=count%>" id="shift_mnemonic<%=count%>" value="<%=shift_mnemonic%>">
							<input type=hidden name="productive_flag<%=count%>" id="productive_flag<%=count%>" value="<%=productive_flag%>">
							<input type=hidden name="shift_indicator<%=count%>" id="shift_indicator<%=count%>" value="<%=shift_indicator%>">
							<input type=hidden name="schedule_type<%=count%>" id="schedule_type<%=count%>" value="<%=schedule_type%>">
							<td align="center"><input type=checkbox name="select<%=count%>" id="select<%=count%>" <%=select_enabled%>></input></td>
							<input type=hidden name="valid_yn<%=count%>" id="valid_yn<%=count%>" value="<%=valid_yn%>">
<%
						}
					}
				    if(pstmt_sch_type!=null) pstmt_sch_type.close();
				   if(rset_sch_type!=null) rset_sch_type.close();

				}
			}
			if(pstmt != null)
				pstmt.close();
			if(rset != null)
				rset.close();
%>
			</tr>
			<tr>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			</table>
			<table cellpadding=0 cellspacing=0 border=0 width="100%">
			<tr>
			<td width="20%" class="label" align="right"><fmt:message key="Common.reason.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td width="80%" align="left">
			<select name="Reason" id="Reason">
			<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
			//String sql_reason="select reason_code,reason_desc from rs_reason where activity_type_code='CS' order by reason_desc";
			String sql_reason="select reason_code,reason_desc from rs_reason_lang_vw where activity_type_code='CS' and language_id = ? order by reason_desc";
			pstmt_reason= conn.prepareStatement(sql_reason);
			pstmt_reason.setString(1,locale);
			rset_reason=pstmt_reason.executeQuery();
			if(rset_reason!=null){
				while(rset_reason.next()){
					String reason_code=rset_reason.getString("reason_code");
					String reason_desc=rset_reason.getString("reason_desc");
%>
					<option value=<%=reason_code%>><%=reason_desc%></option>
<%
				}
				if(pstmt_reason != null)
					pstmt_reason.close();
				if(rset_reason != null)
					rset_reason.close();
			}
%>
			</select>&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;
			</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			<tr>
			<td width="20%" class="label" align="right"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td width="80%" align="left"><textarea name="Remarks" cols=40 rows=4 size="2000" onblur="checkForMax(this);"></textarea></td>
			</tr>
			</table>
			<table cellpadding=0 cellspacing=0 border=0 width="100%">
			<tr>
			<td width="87%" align="right"><input class=button type=button name="apply" id="apply" value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>'onClick="on_apply();">&nbsp;&nbsp;</td>
			<td width="13%" align="left"><input class=button type=button name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'onClick="on_close();"></td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			</table>
			<input type=hidden name="schedule_date" id="schedule_date" value="<%=schedule_date%>">
			<input type=hidden name="total_Records" id="total_Records" value="<%=count%>">
			<input type=hidden name="requirement_id" id="requirement_id" value="<%=requirement_id%>">
			<input type=hidden name="staff_type" id="staff_type" value="<%=staff_type%>">
			<input type=hidden name="locn_type" id="locn_type" value="<%=locn_type%>">
			<input type=hidden name="role_type" id="role_type" value="<%=role_type%>">
			<input type=hidden name="facility_id" id="facility_id" value="<%=facility_id%>">
			<input type=hidden name="workplace_code" id="workplace_code" value="<%=workplace_code%>">
			<input type=hidden name="position_code" id="position_code" value="<%=position_code%>">
			<input type=hidden name="staff_id" id="staff_id" value="<%=staff_id%>">
			<input type=hidden name="activity_id" id="activity_id" value="<%=activity%>">
			<input type=hidden name="curr_cancel_yn" id="curr_cancel_yn" value="<%=curr_cancel_yn%>">
			<input type=hidden name="durn_for_cancel_from_sos" id="durn_for_cancel_from_sos" value="<%=durn_for_curr_cancel_from_sos%>">
			</form>
			</body>
<%
		}
		catch(Exception exp){
			out.println(exp.toString());
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();

				if(pstmt_reason!=null) pstmt_reason.close();
				if(rset_reason!=null) rset_reason.close();

				if(pstmt_sos!=null) pstmt_sos.close();
				if(rset_sos!=null) rset_sos.close();

				if(pstmt_requirement_varying!=null) pstmt_requirement_varying.close();
				if(rset_requirement_varying!=null) rset_requirement_varying.close();

				if(pstmt_requirement_constant!=null) pstmt_requirement_constant.close();
				if(rset_requirement_constant!=null) rset_requirement_constant.close();

				if(pstmt_locn!=null) pstmt_locn.close();
				if(rset_locn!=null) rset_locn.close();

				if(pstmt_staff!=null) pstmt_staff.close();
				if(rset_staff!=null) rset_staff.close();

				if(pstmt_sch_type!=null) pstmt_sch_type.close();
				if(rset_sch_type!=null) rset_sch_type.close();

				if(pstmt_activity!=null) pstmt_activity.close();
				if(rset_activity!=null) rset_activity.close();

				ConnectionManager.returnConnection(conn,request);
			}
			catch(Exception exp){
				out.println(exp.toString());
			}
		}
%>
</html>

