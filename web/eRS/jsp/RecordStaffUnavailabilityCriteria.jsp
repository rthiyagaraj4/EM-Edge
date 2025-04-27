<!DOCTYPE html>

<!-- RecordAttendance.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:	
*	Created By		:	Subbulakshmky. k
*	Created On		:	23 Dec 2004
--%>

<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/RecordStaffUnavailability.js"></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%	
	String mode	   = request.getParameter("mode")==null?"":request.getParameter("mode");
	String function_id = request.getParameter( "function_id")==null?"":request.getParameter("function_id");
	String facility_id = (String)session.getAttribute("facility_id");
	String call_mode=request.getParameter("callmode")==null?"":request.getParameter("callmode");
	String currentdate="";
	String record[]=null;
	ArrayList Reason_Data= new ArrayList();

	Connection conn 		= null;
	PreparedStatement pstmt_currdate 	= null;
	PreparedStatement pstmt_reason 	= null;
	PreparedStatement pstmt_sch_type 	= null;
	PreparedStatement pstmt_position 	= null;
	PreparedStatement pstmt_staff_desc 	= null;
	PreparedStatement pstmt_staff_name 	= null;
    PreparedStatement pstmt_shift 	= null;

	ResultSet rs_currdate 		= null;
	ResultSet rs_reason 		= null;
	ResultSet rset_sch_type 		= null;
	ResultSet rset_position 		= null;
	ResultSet rset_staff_desc 		= null;
	ResultSet rset_staff_name 		= null;
	ResultSet rset_shift 		= null;

	conn = ConnectionManager.getConnection(request);
	try {

		pstmt_currdate=conn.prepareStatement("select to_char(sysdate,'dd/mm/yyyy')d from dual ");
		rs_currdate=pstmt_currdate.executeQuery();
		rs_currdate.next();
		
		currentdate = rs_currdate.getString("d");
		                                                                                
		if(pstmt_currdate != null)
			pstmt_currdate.close();
		if(rs_currdate != null)
			rs_currdate.close();
		//String reanSql="SELECT reason_code,reason_desc FROM rs_reason WHERE eff_status = 'E'  and activity_type_code = 'CS' ORDER BY reason_desc";
		String reanSql="SELECT reason_code,reason_desc FROM rs_reason_lang_vw WHERE language_id = ? and eff_status = 'E'  and activity_type_code = 'LV' ORDER BY reason_desc";

		pstmt_reason=conn.prepareStatement(reanSql);
		pstmt_reason.setString(1,locale);
		rs_reason = pstmt_reason.executeQuery();
	
		
		while(rs_reason.next()){
			record=new String[2];
			record[0]=rs_reason.getString("reason_code");
			record[1]=rs_reason.getString("reason_desc");
			Reason_Data.add(record);
		}
	if(pstmt_reason != null)
		pstmt_reason.close();
	if(rs_reason != null)
		rs_reason.close();
%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='form_RecordStaffUnavailabilityCriteria' id='form_RecordStaffUnavailabilityCriteria' action='../../servlet/eRS.RecordStaffUnavailabilityServlet' method='POST'
target='messageFrame'>
<%
	if(call_mode.equals("M")){
%>
	<table cellpadding=0 cellspacing=0 border='0' width="100%" align=center>
		<!-- <tr><td colspan='8'>&nbsp;</td></tr>
		<tr><td colspan='8'>&nbsp;</td></tr> -->
		<tr> 
			<td class='label' align='right' width='15%'><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/></td>
			<td colspan='2' align='left' width='20%'>&nbsp;&nbsp;&nbsp;<input type='text' name='staff_id' id='staff_id' value='' size='30' readonly ><input type='button' class='button' value='?' name='staff_lookup' id='staff_lookup' onclick='listStaff(staff_id);display(staf_name,role,position_desc,staff_type_desc);'>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
			<input type='hidden' name='staff_name' id='staff_name' value=''>
			<input type='hidden' name='role_type' id='role_type' value=''>
			<input type='hidden' name='position' id='position' value=''>
			<input type='hidden' name='staff_type' id='staff_type' value=''>
			<td colspan='6' id='staf_name' class='label1'></td>
		</tr>
		<tr><td colspan='8'>&nbsp;</td></tr>
		<tr> 
			<td width='15%' class='label' align='right'><fmt:message key="Common.Role.label" bundle="${common_labels}"/></td>
			<td colspan='2' width='20%' id='role' class='label1'></td>
			<td width='10%' class='label' align='right'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
			<td width='25%' id='position_desc' class='label1'></td>
			<td width='10%' class='label' align='right'><fmt:message key="eRS.StaffType.label" bundle="${rs_labels}"/></td>
			<td width='20%' id='staff_type_desc' class='label1'></td>

		</tr>
		<tr><td colspan='8'>&nbsp;</td></tr>
		<tr><td width='15%'>&nbsp;</td>
			<td width='10%' class='label'>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td width='10%' class='label'>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td colspan='5'>&nbsp;</td>
		</tr>
		<tr> 
			<td width='15%' class='label' align='right'><fmt:message key="eRS.LeavePeriod.label" bundle="${rs_labels}"/></td>
			<td width='10%'>&nbsp;&nbsp;&nbsp<input type='text' name='from_date' id='from_date' id='id_frm_date' size='8' maxlength='10' value='' onBlur="if(CheckDate(this)) checkFromDate();" onKeyPress='return AllowDateFormat();'><img src='../../eCommon/images/CommonCalendar.gif' onclick="return showCalendar('id_frm_date');">
			</td>
			<td width='10%'>&nbsp;&nbsp;&nbsp<input type='text' name='to_date' id='to_date' id='id_to_date' size='8' maxlength='10' value='' onBlur='if(CheckDate(this)) checkToDate()' onKeyPress='return AllowDateFormat();'><img src='../../eCommon/images/CommonCalendar.gif' onclick="return showCalendar('id_to_date');"></td>
			<td colspan='5'>&nbsp;</td>
		</tr>
		<tr><td colspan='8'>&nbsp;</td></tr>
		<tr><td width='15%' class='label' align='right'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
				<td colspan='2' width='20%' align='left'>&nbsp;&nbsp;&nbsp;<select name= 'reason'>
				<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<%for(int i=0;i<Reason_Data.size();i++){
							record=(String[])Reason_Data.get(i); %>
					<option value='<%= record[0]%>'> <%=record[1]%> </option>
				<%}%>
				</select>
				</td>
				<td colspan='6'>&nbsp;</td>
		</tr>
		<tr><td colspan='8'>&nbsp;</td></tr>
		<!-- <tr><td colspan='8'>&nbsp;</td></tr> -->
	</table>
<%
	}
	else if(call_mode.equals("W")){
		int cell_no=Integer.parseInt(request.getParameter("p_cell_no")==null?"0":request.getParameter("p_cell_no"));
		String date=request.getParameter("p_date")==null?"":request.getParameter("p_date");
		String role_type=request.getParameter("p_role_type")==null?"":request.getParameter("p_role_type");
		String staff_id=request.getParameter("p_staff_id")==null?"":request.getParameter("p_staff_id");
		String position_code=request.getParameter("p_position_code")==null?"":request.getParameter("p_position_code");
		String p_shift_code=request.getParameter("p_shift_code")==null?"":request.getParameter("p_shift_code");

		String schedule_date="";
		String position_desc="";
		String staff_desc="";
		String staff_name="";
		String role_type_desc="";

		String total_string="";
		String concat_string="";

		StringBuffer temp_code = new StringBuffer("'" + p_shift_code + "'");

		while(temp_code.toString().indexOf('|') != -1)	{
		   int index = temp_code.toString().indexOf('|');
		   temp_code.replace(index,index+1,"','");
		}
		p_shift_code = temp_code.toString();

		String sql_shift="select shift_code,mnemonic_key,shift_indicator,productive_flag from am_shift where shift_code in ("+p_shift_code+")";

		pstmt_shift=conn.prepareStatement(sql_shift);
		rset_shift=pstmt_shift.executeQuery();
		if(rset_shift!=null)
		{
			while(rset_shift.next())
			{ 
		concat_string=rset_shift.getString("shift_code")+"|"+rset_shift.getString("mnemonic_key")+"|"+rset_shift.getString("shift_indicator")+"|"+rset_shift.getString("productive_flag");

				if(total_string.equals(""))	{
					total_string=concat_string;
				}
				else{
					total_string=total_string+"~"+concat_string;
				}

			}
		}


		if(pstmt_shift != null)
			pstmt_shift.close();
		if(rset_shift != null)
			rset_shift.close();
		String sql_sch_date="select to_char((to_date(?,'dd/mm/yyyy') + ?),'dd/mm/yyyy') schedule_date from dual";
		pstmt_sch_type=conn.prepareStatement(sql_sch_date);
		pstmt_sch_type.setString(1,date);
		pstmt_sch_type.setInt(2,cell_no);

		rset_sch_type=pstmt_sch_type.executeQuery();
		if(rset_sch_type!=null)	{
		  while(rset_sch_type.next()){
			  schedule_date=rset_sch_type.getString("schedule_date");
		  }
		}
		if(pstmt_sch_type != null)
			pstmt_sch_type.close();
		if(rset_sch_type != null)
			rset_sch_type.close();

		//String sql_position="select position_desc from am_position where eff_Status = 'E' and role_type=? and position_code=?";
		String sql_position="select position_desc from am_position_lang_vw where eff_Status = 'E' and role_type=? and position_code=? and language_id = ?";
		pstmt_position=conn.prepareStatement(sql_position);
		pstmt_position.setString(1,role_type);
		pstmt_position.setString(2,position_code);
		pstmt_position.setString(3,locale);
		rset_position=pstmt_position.executeQuery();
		if(rset_position!=null){
		  while(rset_position.next()){
			  position_desc=rset_position.getString("position_desc");
		  }
		}

		//String sql_staff_desc="select desc_userdef staff_desc from am_pract_type where eff_Status = 'E' and ? = 'P' union select short_desc staff_desc from am_other_staff_type where eff_status = 'E' and ? = 'O' order by staff_desc";
		String sql_staff_desc="select desc_userdef staff_desc from am_pract_type_lang_vw where eff_Status = 'E' and ? = 'P' and language_id = ? union select short_desc staff_desc from am_other_staff_type_lang_vw where eff_status = 'E' and ? = 'O' and language_id = ? order by staff_desc";
		pstmt_staff_desc=conn.prepareStatement(sql_staff_desc);
		pstmt_staff_desc.setString(1,role_type);
		pstmt_staff_desc.setString(2,locale);
		pstmt_staff_desc.setString(3,role_type);
		pstmt_staff_desc.setString(4,locale);
		rset_staff_desc=pstmt_staff_desc.executeQuery();
		if(rset_staff_desc!=null){
		  while(rset_staff_desc.next()){
			  staff_desc=rset_staff_desc.getString("staff_desc");
		  }
		}
		if(pstmt_staff_desc != null)
			pstmt_staff_desc.close();
		if(rset_staff_desc != null)
			rset_staff_desc.close();

		String sql_staff_name="select staff_name from am_staff_vw where role_type=? and staff_id=? and language_id=?";
		pstmt_staff_name=conn.prepareStatement(sql_staff_name);
		pstmt_staff_name.setString(1,role_type);
		pstmt_staff_name.setString(2,staff_id);
		pstmt_staff_name.setString(3,locale);

		rset_staff_name=pstmt_staff_name.executeQuery();
		if(rset_staff_name!=null)	{
		  while(rset_staff_name.next()){
			  staff_name=rset_staff_name.getString("staff_name");
		  }
		}
		if(pstmt_staff_name != null)
			pstmt_staff_name.close();
		if(rset_staff_name != null)
			rset_staff_name.close();

		if(role_type.equals("P"))
			role_type_desc="Practitioner";
		else 
			role_type_desc="Other Staff";
%>
			<table cellpadding=0 cellspacing=0 border='0' width="100%" align=center>
			<!-- <tr><td colspan='10'>&nbsp;</td></tr>
			<tr><td colspan='10'>&nbsp;</td></tr> -->
			<tr> 
				<td class='label' align='right' width='15%'><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/></td>
				<td colspan='2' align='left' width='10%'>&nbsp;&nbsp;<input type='text' name='staff_id' id='staff_id' value='<%=staff_id%>' size='30' readonly ><input type='button' class='button' value='?' name='staff_lookup' id='staff_lookup' onclick='listStaff(staff_id);display(staf_name,role,position_desc,staff_type_desc);' disabled>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
				<input type='hidden' name='staff_name' id='staff_name' value=''>
				<input type='hidden' name='role_type' id='role_type' value='<%=role_type%>'>
				<input type='hidden' name='position' id='position' value=''>
				<input type='hidden' name='staff_type' id='staff_type' value=''>
				<td colspan='6' class='label1' align="left"><%=staff_name%></td>
			</tr>
			<tr><td colspan='10'>&nbsp;</td></tr>
			<tr><td colspan='10'>&nbsp;</td></tr>
			<tr> 
				<td width='15%' class='label' align='right'><fmt:message key="Common.Role.label" bundle="${common_labels}"/></td>
				<td colspan='8' class='label1'>&nbsp;&nbsp;<%=role_type_desc%></td>
			</tr>
			<tr><td colspan='10'>&nbsp;</td></tr>
			<tr><td colspan='10'>&nbsp;</td></tr>
			<tr>
				<td width='15%' class='label' align='right'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
				<td class='label1'>&nbsp;&nbsp;<%=position_desc%></td>
				<td width='20%' class='label' align='right'><fmt:message key="eRS.StaffType.label" bundle="${rs_labels}"/>&nbsp;&nbsp;</td>
				<td colspan='8' class='label1'><%=staff_desc%></td>
			</tr>
			<tr><td colspan='10'>&nbsp;</td></tr>
			<tr><td colspan='10'>&nbsp;</td></tr>
				<tr><td width='15%'>&nbsp;</td>
				<td width='10%' class='label'>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td width='10%' class='label'>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td colspan='8'>&nbsp;</td>
			</tr>
			<tr> 
				<td width='25%' class='label' align='right'><fmt:message key="eRS.LeavePeriod.label" bundle="${rs_labels}"/></td>
				<td width='10%'>&nbsp;&nbsp;<input type='text' name='from_date' id='from_date' id='id_frm_date' size='8' maxlength='10' value='<%=schedule_date%>' onBlur="if(CheckDate(this)) checkFromDate();" onKeyPress='return AllowDateFormat();' readonly>&nbsp;<img src='../../eCommon/images/CommonCalendar.gif' onclick="return showCalendar('id_frm_date');" disabled>&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp
				</td>
				<td width='10%'>&nbsp;&nbsp;&nbsp<input type='text' name='to_date' id='to_date' id='id_to_date' size='8' maxlength='10' value='<%=schedule_date%>' onBlur='if(CheckDate(this)) checkToDate()' onKeyPress='return AllowDateFormat();' readonly>&nbsp;<img src='../../eCommon/images/CommonCalendar.gif' onclick="return showCalendar('id_to_date');" disabled>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
				<td colspan='6'>&nbsp;</td>
			</tr>
			<tr><td colspan='10'>&nbsp;</td></tr>
			<tr><td colspan='10'>&nbsp;</td></tr>
			<tr><td width='15%' class='label' align='right'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
					<td colspan='4' width='20%' align='left'>&nbsp;&nbsp;<select name= 'reason'>
					<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
<%
			for(int i=0;i<Reason_Data.size();i++){
				record=(String[])Reason_Data.get(i); 
%>
						<option value='<%= record[0]%>'> <%=record[1]%> </option>
<%
			}
%>
					</select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
					</td>
					<td colspan='4'>&nbsp;</td>
			</tr>
			<tr>
			<td colspan='4' align='right' width='80%'><input class='button' type=button name='apply' id='apply' value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>'onClick="on_apply();">&nbsp;&nbsp;</td>
			<td colspan='6' align='left' width='10%'><input class='button' type=button name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'onClick="on_close();"></td>
			</tr>
			</table>
			<input type='hidden' name='total_string' id='total_string' value='<%=total_string%>'>
<%
		}
%>
		<input type='hidden' value='<%=mode%>' name='mode'>
		<input type='hidden' value='<%=call_mode%>' name='call_mode'>
		<input type='hidden' value='<%=function_id%>' name='function_id'>
		<input type='hidden' value='<%=facility_id%>' name='facility_id'>
		<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>
		
	</form>
	</body>
<%
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		try
		{
		if(pstmt_currdate != null)
			pstmt_currdate.close();
		if(rs_currdate != null)
			rs_currdate.close();
		if(pstmt_reason != null)
			pstmt_reason.close();
		if(rs_reason != null)
			rs_reason.close();
		ConnectionManager.returnConnection(conn,request);
		}
		catch(Exception exp)
		{
			out.println(exp.toString());
		}
	}
%>
</html>

