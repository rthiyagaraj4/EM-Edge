<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Sreenivasulu.Y
*	Created On		:	16 Feb 2005
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
<title><fmt:message key="eRS.ChangeShift.label" bundle="${rs_labels}"/></title>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../js/ManageWorkScheduleChange.js"></script>
<!-- <script language="javascript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CallableStatement cstmt = null;

	String p_facility_id  = request.getParameter("p_facility_id");
	String p_workplace_code = request.getParameter("p_workplace_code");
	String p_role_type  = request.getParameter("p_role_type");
	String p_staff_id  = request.getParameter("p_staff_id");
	String p_staff_type  = request.getParameter("p_staff_type");
	String p_position_code  = request.getParameter("p_position_code");
	String p_shift_code  = request.getParameter("p_shift_code");
	String p_shift_mnemonic  = request.getParameter("p_shift_mnemonic");
	String p_date  = request.getParameter("p_date");
	String p_cell_no  = request.getParameter("p_cell_no");
	String p_schedule_date  = "";
	String p_requirement_id="";
	
	try{
		con = ConnectionManager.getConnection(request);

		String p_sch_date="select to_char(to_date(?,'dd/mm/yyyy') + to_number(?) ,'dd/mm/yyyy') p_schedule_date from dual";
		pstmt = con.prepareStatement(p_sch_date);
		pstmt.setString(1,p_date);
		pstmt.setString(2,p_cell_no);
		rs = pstmt.executeQuery();
		
		while(rs!=null  && rs.next())	{
			p_schedule_date = rs.getString("p_schedule_date");
		}
		if(pstmt!=null) pstmt.close();		
		if(rs!=null) rs.close();

		StringBuffer temp_shift = new StringBuffer("'" + p_shift_code + "'");
        while(temp_shift.toString().indexOf('|') != -1){
            int index = temp_shift.toString().indexOf('|');
            temp_shift.replace(index,index+1,"','");
        }
		p_shift_code = temp_shift.toString();


        StringBuffer temp_mnemo = new StringBuffer("'" + p_shift_mnemonic + "'");
        while(temp_mnemo.toString().indexOf('|') != -1){
            int index = temp_mnemo.toString().indexOf('|');
            temp_mnemo.replace(index,index+1,"','");
        }
		p_shift_mnemonic = temp_mnemo.toString();


		String p_activity = "CH";
		cstmt = con.prepareCall("{call rs_validate_manage_schedule(?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,p_activity);
		cstmt.setString(2,p_schedule_date);
		cstmt.setString(3,p_role_type);
		cstmt.setString(4,p_staff_id);
		cstmt.setString(5,p_facility_id);
		cstmt.setString(6,p_workplace_code);
		cstmt.setString(7,p_position_code);
		cstmt.setString(8,p_shift_code);
		cstmt.registerOutParameter(9,Types.VARCHAR) ;
		cstmt.execute() ;
		String shift_details = cstmt.getString(9)==null?"":cstmt.getString(9);
		if(shift_details.equals("")){
			out.println("<script>alert(getMessage('NO_VALID_SHIFTS_CHANGE','RS'));</script>");
			out.println("<script>window.close();</script>");
		}
%>
</head>
<body>
<form name="ChangeShift" id="ChangeShift" action='../../servlet/eRS.ManageWorkScheduleChangeServlet' method='post' target='blankFrame'>
<table cellpadding=0 cellspacing=0 border=0 width="100%" align='right'>
<tr>
	<td colspan='3'>&nbsp;</td>
</tr>
<tr>
	<td class='querydata' align='right' width='30%'><fmt:message key="eRS.ScheduleDate.label" bundle="${rs_labels}"/></td>
	<td class='label'>&nbsp;&nbsp;&nbsp;&nbsp;<%=p_schedule_date%></td>
	<td>&nbsp;</td>
</tr>
<tr>
	<td colspan='3'>&nbsp;</td>
</tr>
<tr>
	<td width='30%'>&nbsp;</td>
	<td class='querydata'>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eRS.AllocatedShifts.label" bundle="${rs_labels}"/>&nbsp;&nbsp;&nbsp;</td>
	<td class='querydata' align='left'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
</tr>
	 <%
	//String sql_old_shift="SELECT DISTINCT a.SHIFT_CODE,SHORT_DESC shift_desc,SHIFT_MNEMONIC,SHIFT_INDICATOR,PRODUCTIVE_FLAG FROM AM_SHIFT a,RS_SHIFT_FOR_WORKPLACE b WHERE b.FACILITY_ID = ? and a.SHIFT_CODE IN ("+p_shift_code+") and SHIFT_MNEMONIC IN("+p_shift_mnemonic+") and a.shift_code=b.SHIFT_CODE";
	String sql_old_shift="SELECT DISTINCT a.SHIFT_CODE,SHORT_DESC shift_desc,SHIFT_MNEMONIC,SHIFT_INDICATOR,PRODUCTIVE_FLAG FROM AM_SHIFT_LANG_VW  a,RS_SHIFT_FOR_WORKPLACE b WHERE b.FACILITY_ID = ? and a.SHIFT_CODE IN ("+p_shift_code+") and SHIFT_MNEMONIC IN("+p_shift_mnemonic+") and a.shift_code=b.SHIFT_CODE AND A.LANGUAGE_ID = ?";
		
	pstmt = con.prepareStatement(sql_old_shift);
	pstmt.setString(1,p_facility_id);
	pstmt.setString(2,locale);
	rs = pstmt.executeQuery();
	while(rs!=null  && rs.next()){
		out.println("<tr>");
		out.println("<td class='label' width='30%' align='right'>&nbsp;</td>");
		out.println("<td class='label' width='30%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("shift_desc")+"&nbsp;&nbsp;"+rs.getString("shift_mnemonic")+"</td>");
		out.println("<td align='left'><INPUT TYPE='radio'  name='old_shift' id='old_shift' value='"+rs.getString("SHIFT_CODE")+"|"+rs.getString("SHIFT_MNEMONIC")+"|"+rs.getString("SHIFT_INDICATOR")+"|"+rs.getString("PRODUCTIVE_FLAG")+"' onClick='shiftchk(this)' ></td>");
		out.println("</tr>");
	 }
 	 if(pstmt!=null) pstmt.close();
	 if(rs!=null) rs.close();
%>
<tr>
	<td colspan='3'>&nbsp;</td>
</tr>
<tr>
	<td class='label' align='right'><fmt:message key="eRS.NewShift.label" bundle="${rs_labels}"/></td>
	<td>&nbsp;&nbsp;&nbsp;<SELECT name="new_shift" id="new_shift" onchange="popuvalues()">
			<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
<%
		StringTokenizer stk_dt = new StringTokenizer(shift_details,"~");
		while (stk_dt.hasMoreTokens()){
			String shift_dt=stk_dt.nextToken();
			StringTokenizer stk_ind = new StringTokenizer(shift_dt,"|");
			String shft_code=stk_ind.nextToken();
			String shft_desc=stk_ind.nextToken();
			String shft_mnemonic=stk_ind.nextToken();
			out.println("<option value='"+shft_code+ "'>"+shft_desc+"("+shft_mnemonic+")"+""); 
			p_requirement_id = stk_ind.nextToken();
		}
%>
		</SELECT><img src="../../eCommon/images/mandatory.gif">
	</td>
	<td>&nbsp;</td>
</tr>
<tr>
	<td >&nbsp;</td>
	<td id='productive' class='label' align='left'>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
<tr>
<td class='label' width='30%' align='right'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
<%
	//String sql_reason="select reason_code,reason_desc from rs_reason where activity_type_code = 'CH' and eff_status = 'E' order by reason_desc";
	String sql_reason="select reason_code,reason_desc from rs_reason_lang_vw where language_id = ? and activity_type_code = 'CH' and eff_status = 'E' order by reason_desc";
	pstmt = con.prepareStatement(sql_reason);
	pstmt.setString(1,locale);
	rs = pstmt.executeQuery();
%>
	<td>&nbsp;&nbsp;&nbsp;<SELECT name="reason" id="reason">
			<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
<%	
		while(rs!=null  && rs.next()){
			out.println("<option value='"+rs.getString("reason_code")+"'>"+rs.getString("reason_desc")+"</option>");
		  }
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
%>
		</SELECT><img src="../../eCommon/images/mandatory.gif">
	</td>
	<td>&nbsp;</td>
</tr>
<tr>
	<td class='label' width='30%' align='right'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;&nbsp;<TEXTAREA NAME="remarks" COLS="30" onkeypress='return notallowenter(event);'></TEXTAREA>
	</td>
	<td>&nbsp;</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td align='right'><INPUT TYPE="button" class='button' value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' onclick="apply()"><INPUT TYPE="button" class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="wincls()"></td>
</tr>
</table>
<input type="hidden" name="p_shift_code" id="p_shift_code" value="<%=p_shift_code%>">
<INPUT TYPE="hidden" name="p_requirement_id" id="p_requirement_id" value="<%=p_requirement_id%>">
<INPUT TYPE="hidden" name="p_workplace_code" id="p_workplace_code" value="<%=p_workplace_code%>">
<INPUT TYPE="hidden" name="p_schedule_date" id="p_schedule_date" value="<%=p_schedule_date%>">
<INPUT TYPE="hidden" name="p_role_type" id="p_role_type" value="<%=p_role_type%>">
<INPUT TYPE="hidden" name="p_staff_id" id="p_staff_id" value="<%=p_staff_id%>">
<INPUT TYPE="hidden" name="p_staff_type" id="p_staff_type" value="<%=p_staff_type%>">
<INPUT TYPE="hidden" name="p_position_code" id="p_position_code" value="<%=p_position_code%>">
<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
<INPUT TYPE="hidden" name="old_shift_val" id="old_shift_val" value="">
<INPUT TYPE="hidden" name="new_mnemonic" id="new_mnemonic" value="">
<INPUT TYPE="hidden" name="new_shift_start_time" id="new_shift_start_time" value="">
<INPUT TYPE="hidden" name="new_shift_end_time" id="new_shift_end_time" value="">
<INPUT TYPE="hidden" name="new_shift_indicator" id="new_shift_indicator" value="">
<INPUT TYPE="hidden" name="new_productive_flag" id="new_productive_flag" value="">
</form>
</body>
<%
		}
		catch (Exception e){
			out.println(e.toString());
		}
		finally{
			try
			{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(cstmt!=null) cstmt.close();
			ConnectionManager.returnConnection(con,request);
			}
			catch(Exception e)
			{
               out.println(e.toString());
			}
		}
%>
</html>

