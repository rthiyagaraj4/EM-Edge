<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ManageWorkScheduleCancelLeave.jsp
*	Purpose 		:	Cancel Leave
*	Created By		:	Srikanat Raut
*	Created On		:	19-08-2009
*/
%>
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
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

<script language="javascript" src="../js/RSCommon.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eRS/js/ManageWorkSchedule.js"></script>
<script language="javascript" src="../../eRS/js/ManageWorkScheduleCancelLeave.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="eRS.ManageWorkScheduleCancelLeave" bundle="${rs_labels}"/></title>

</head>
<%
	String role_type_desc = "";
	String staff_name = "";
	String position_desc = "";
	String staff_desc = "";
	String schedule_date = "";
	String p_facility_id = (String)session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");
	String role_type	   = request.getParameter("p_role_type")==null?"":request.getParameter("p_role_type");
	String staff_id	   = request.getParameter("p_staff_id")==null?"":request.getParameter("p_staff_id");
	String position_code	   = request.getParameter("p_position_code")==null?"":request.getParameter("p_position_code");
	int cell_no=Integer.parseInt(request.getParameter("p_cell_no")==null?"0":request.getParameter("p_cell_no"));
	String date	   = request.getParameter("p_date")==null?"":request.getParameter("p_date");
	String p_workplace_code = request.getParameter("p_workplace_code");
	String p_shift_code  = request.getParameter("p_shift_code");
	String p_shift_mnemonic  = request.getParameter("p_shift_mnemonic");
	//String user_id			=request.getParameter("user_id")==null?"":request.getParameter("user_id");
	
	
	String p_staff_type  = request.getParameter("p_staff_type");
	String new_from_date  = request.getParameter("p_date");
	
	String record[]=null;
	ArrayList Reason_Data= new ArrayList();

	Connection conn 					= null;
	PreparedStatement pstmt_staff_name	= null;
	PreparedStatement pstmt_position	= null;
	PreparedStatement pstmt_staff_desc	= null;
	PreparedStatement pstmt_sch_type	= null;
	PreparedStatement pstmt_reason	= null;
	ResultSet rset_staff_name			= null;
	ResultSet rset_position 			= null;
	ResultSet rset_staff_desc 			= null;
	ResultSet rset_sch_type 			= null;
	ResultSet rs_reason		 			= null;
	conn = ConnectionManager.getConnection(request);
	try {
		//For Staff Name
		pstmt_staff_name=conn.prepareStatement("select staff_name from am_staff_vw where role_type=? and staff_id=? and language_id = ?");
		pstmt_staff_name.setString(1,role_type);
		pstmt_staff_name.setString(2,staff_id);
		pstmt_staff_name.setString(3,locale);;


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

		//For Staff Position
		pstmt_position=conn.prepareStatement("select position_desc from am_position_lang_vw where eff_Status = 'E' and role_type=? and position_code=? and language_id = ?");
		pstmt_position.setString(1,role_type);
		pstmt_position.setString(2,position_code);
		pstmt_position.setString(3,locale);
		rset_position=pstmt_position.executeQuery();
		if(rset_position!=null){
		  while(rset_position.next()){
			  position_desc=rset_position.getString("position_desc");
		  }
		}
		if(pstmt_position != null)
			pstmt_position.close();
		if(rset_position != null)
			rset_position.close();
		
		pstmt_staff_desc=conn.prepareStatement("select desc_userdef staff_desc from am_pract_type_lang_vw where eff_Status = 'E' and ? = 'P' and language_id = ? union select short_desc staff_desc from am_other_staff_type_lang_vw where eff_status = 'E' and ? = 'O' and language_id = ? order by staff_desc");
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

		pstmt_sch_type=conn.prepareStatement("select to_char((to_date(?,'dd/mm/yyyy') + ?),'dd/mm/yyyy') schedule_date from dual");
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



		pstmt_reason=conn.prepareStatement("SELECT reason_code,reason_desc FROM rs_reason_lang_vw WHERE language_id =? AND eff_status = 'E'  AND activity_type_code = 'CL' ORDER BY reason_desc");
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
	}
	catch(Exception e)
	{
	e.printStackTrace() ;
	}finally
	{
		try{		
		conn.commit();
		conn.close();
		}catch(Exception ex)
		{ex.printStackTrace() ;}
	}
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name=form_ManageWorkScheduleCancelLeave action='../../servlet/eRS.ManageWorkScheduleCancelLeaveServlet' method='POST'
target='messageFrame'>
	<table border='0' cellpadding='0' cellspacing='0' align='left' width="100%">
			<tr>
				<td width='5%' align='left'>&nbsp;</td>
				<td colspan='5'>&nbsp;</td>
			</tr>
			<tr>
				<td class='label' width='12%' align='right'><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/> </td>
				<td width='20%' align='left'>&nbsp;<input name='cancel_leave_staff_txt' id='cancel_leave_staff_txt' type='text' size='20' maxlength='10' value ='<%=staff_name%>' readonly></td>
				<td colspan='5'>&nbsp;</td>
			</tr>
			<tr>
				<td width='5%' align='left'>&nbsp;</td>
				<td colspan='5'>&nbsp;</td>
			</tr>
			<tr>
				<td class='label' width='12%' align='right'><fmt:message key="Common.Role.label" bundle="${common_labels}"/></td>
				<td width='20%' align='left'>&nbsp;<input name='cancel_leave_role_txt' id='cancel_leave_role_txt' type='text' size='20' maxlength='10' value ='<%=role_type_desc%>' readonly></td>
				<td colspan='3'>&nbsp;</td>
			</tr>
			<tr>
				<td width='20%' align='left'>&nbsp;</td>
				<td colspan='5'>&nbsp;</td>
			</tr>
			<tr>
				<td class='label' width='12%' align='right'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
				<td width='20%' align='left'>&nbsp;<input name='cancel_leave_position_txt' id='cancel_leave_position_txt' type='text' size='20' maxlength='10' value ='<%=position_desc%>' readonly></td>
				<td class='label' width='12%' align='right'><fmt:message key="eRS.StaffType.label" bundle="${rs_labels}"/></td>
				<td width='20%' align='left'>&nbsp;<input name='cancel_leave_staff_type_txt' id='cancel_leave_staff_type_txt' type='text' size='20' maxlength='10' value = '<%=staff_desc%>' readonly></td>
			</tr>
			<tr>
				<td width='5%' align='left'>&nbsp;</td>
				<td colspan='5'>&nbsp;</td>
			</tr>
			

			<tr>
				<td class='label' width='12%' align='right'><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/> </td>
				<td width='20%' align='left'>&nbsp;<input name='frmdate' id='frmdate' id='cancel_leave_period_from_txt' type='text' size='8' maxlength='10' value='<%=schedule_date%>' readonly>
				<td class='label' width='12%' align='right'><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/> </td>
				<td width='20%' align='left'>&nbsp;<input name='todate' id='todate' id='cancel_leave_period_to_txt' type='text' size='8' maxlength='10'  value='<%=schedule_date%>' readonly></td>
				<td colspan='2'>&nbsp;</td>
	
			</tr>
			<tr>
				<td width='20%' align='left'>&nbsp;</td>
				<td colspan='5'>&nbsp;</td>
			</tr>
			<tr>
				<td class='label' width='12%' align='right'><fmt:message key="eRS.ManageWorkScheduleCancelLeave" bundle="${rs_labels}"/> </td>
				<td width='20%' align='left'>&nbsp;<input name='cancel_leave_YN' id='cancel_leave_YN' type='checkbox' onclick = "chk_value();" value= 'N'></td>
				<td colspan='5'>&nbsp;</td>
			</tr>
			<tr>
				<td width='20%' align='left'>&nbsp;</td>
				<td colspan='5'>&nbsp;</td>
			</tr>
			<tr>
				<td class='label' width='12%' align='right'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
				<td width='20%' align='left'>&nbsp;<select name= 'cancel_leave_reason'>
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
				<td colspan='6'>&nbsp;</td>
			</tr>
			<tr>
			<td colspan='4' align='right' width='80%'><input class='button' type=button name='apply' id='apply' value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>'onClick="on_apply();">&nbsp;&nbsp;</td>
			<td colspan='6' align='left' width='10%'><input class='button' type=button name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'onClick="on_close();"></td>
			</tr>
	</table>
	<input type='hidden' value='<%=role_type%>' name='role_type'>
	<input type='hidden' value='<%=staff_id%>' name='staff_id'>
	<input type='hidden' value='<%=schedule_date%>' name='date'>
	<input type='hidden' value='<%=cell_no%>' name='cell_no'>
	<input type='hidden' value='<%=p_shift_code%>' name='p_shift_code'>
	<input type='hidden' value='<%=p_shift_mnemonic%>' name='p_shift_mnemonic'>
	<input type='hidden' value='<%=position_code%>' name='position_code'>
	<input type='hidden' value='<%=p_facility_id%>' name='p_facility_id'>
	<input type='hidden' value='<%=p_workplace_code%>' name='p_workplace_code'>
	<input type='hidden' value='<%=p_staff_type%>' name='p_staff_type'>
	<input type='hidden' value='<%=new_from_date%>' name='new_from_date'>


</form>
</body>
</html>

