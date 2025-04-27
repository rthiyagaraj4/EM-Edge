<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	24 Feb 2005
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
<title><fmt:message key="eRS.TransferShift.label" bundle="${rs_labels}"/></title>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="JavaScript" src="../../eRS/js/ManageWorkScheduleTransfer.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<%	
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String p_facility_id  = request.getParameter("p_facility_id")==null?"":request.getParameter("p_facility_id");
	String p_workplace_code = request.getParameter("p_workplace_code")==null?"":request.getParameter("p_workplace_code");
	String p_date  = request.getParameter("p_date")==null?"":request.getParameter("p_date");
	int p_cell_no  = Integer.parseInt(request.getParameter("p_cell_no")==null?"":request.getParameter("p_cell_no"));
	String p_role_type  = request.getParameter("p_role_type")==null?"":request.getParameter("p_role_type");
	String p_staff_id  = request.getParameter("p_staff_id")==null?"":request.getParameter("p_staff_id");
	String p_staff_type  = request.getParameter("p_staff_type")==null?"":request.getParameter("p_staff_type");
	String p_position_code  = request.getParameter("p_position_code")==null?"":request.getParameter("p_position_code");
	String p_shift_code  = request.getParameter("p_shift_code")==null?"":request.getParameter("p_shift_code");
	String p_shift_mnemonic  = request.getParameter("p_shift_mnemonic")==null?"":request.getParameter("p_shift_mnemonic");
	String p_schedule_date  = "";
	String cnt = "";
	String shift_ind = "";
	String prod_flag = "";

	try
	{	
		con = ConnectionManager.getConnection(request);
        StringBuffer temp_shift = new StringBuffer("'" + p_shift_code + "'");
		        while(temp_shift.toString().indexOf('|') != -1)
        {
            int index = temp_shift.toString().indexOf('|');
            temp_shift.replace(index,index+1,"','");
        }
		p_shift_code = temp_shift.toString();

        StringBuffer temp_mnemo = new StringBuffer("'" + p_shift_mnemonic + "'");
        while(temp_mnemo.toString().indexOf('|') != -1)
        {
            int index = temp_mnemo.toString().indexOf('|');
            temp_mnemo.replace(index,index+1,"','");
        }
		p_shift_mnemonic = temp_mnemo.toString();

		// To get p_schedule_date
		String sql_sch_date = "select to_char(to_date(?,'dd/mm/yyyy') + ?,'dd/mm/yyyy' )p_schedule_date from dual";
		pstmt = con.prepareStatement(sql_sch_date);
		pstmt.setString(1,p_date);
		pstmt.setInt(2,p_cell_no);
		rs = pstmt.executeQuery();
		
		if(rs!=null)
		{
			if(rs.next())
			{
				p_schedule_date = rs.getString("p_schedule_date");
				
			}
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}
		// End of p_schedule_date
%>
</head>
<body>
<form name="ManageWorkScheduleTransfer" id="ManageWorkScheduleTransfer" action='../../servlet/eRS.ManageWorkScheduleTransferServlet' target='blankFrame' method="post">
<table cellpadding=0 cellspacing=0 border=0 width="100%" align='center'>
<tr>
	<td colspan='3'>&nbsp;</td>
</tr>
<tr>
	<td class='label' align='right' width='30%'><fmt:message key="eRS.ScheduleDate.label" bundle="${rs_labels}"/></td>
	<td class='querydata'>&nbsp;&nbsp;&nbsp;&nbsp;<%=p_schedule_date%></td>
	<td class='label'>&nbsp;</td>
</tr>
<tr>
	<td colspan='3'>&nbsp;</td>
</tr>
<tr>
	<td class='label' align='right' width='30%'><fmt:message key="eRS.TransferFrom.label" bundle="${rs_labels}"/></td>
	<td class='querydata'>&nbsp;&nbsp;&nbsp;&nbsp;<%=p_workplace_code%></td>
	<td class='label'>&nbsp;</td>
</tr>
<tr>
	<td colspan='3'>&nbsp;</td>
</tr>
<tr>
	<td width='30%'>&nbsp;</td>
	<td class='querydata'>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eRS.AllocatedShifts.label" bundle="${rs_labels}"/></td>
	<td class='querydata' align='left'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
</tr>
<%
	//String sql_str = "SELECT DISTINCT a.SHIFT_CODE SHIFT_CODE,SHORT_DESC,SHIFT_MNEMONIC, SHIFT_INDICATOR,PRODUCTIVE_FLAG,to_char(SHIFT_START_TIME,'dd/mm/yyyyhh24:mi') SHIFT_START_TIME,to_char(SHIFT_END_TIME,'dd/mm/yyyyhh24:mi') SHIFT_END_TIME FROM AM_SHIFT a,RS_SHIFT_FOR_WORKPLACE b WHERE b.FACILITY_ID =? and a.SHIFT_CODE IN ("+p_shift_code+") and SHIFT_MNEMONIC IN("+p_shift_mnemonic+") and a.shift_code=b.SHIFT_CODE";
	String sql_str = "SELECT DISTINCT a.SHIFT_CODE SHIFT_CODE,SHORT_DESC,SHIFT_MNEMONIC, SHIFT_INDICATOR,PRODUCTIVE_FLAG,to_char(SHIFT_START_TIME,'dd/mm/yyyyhh24:mi') SHIFT_START_TIME,to_char(SHIFT_END_TIME,'dd/mm/yyyyhh24:mi') SHIFT_END_TIME FROM AM_SHIFT_LANG_VW  a,RS_SHIFT_FOR_WORKPLACE b WHERE b.FACILITY_ID =? and a.SHIFT_CODE IN ("+p_shift_code+") and SHIFT_MNEMONIC IN("+p_shift_mnemonic+") and a.shift_code=b.SHIFT_CODE and a.language_id = ?";
	pstmt = con.prepareStatement(sql_str);
	pstmt.setString(1,p_facility_id);
	pstmt.setString(2,locale);
	rs = pstmt.executeQuery();
	if(rs!=null)
	{
		int i = 1;
		while(rs.next())
		{

			out.println("<tr>");
			out.println("<td class='label' width='30%' align='right'> &nbsp;</td>");
			out.println("<td class='label' width='30%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("SHORT_DESC")+"&nbsp;&nbsp;"+rs.getString("SHIFT_MNEMONIC")+"</td>");
			out.println("<td align='left'><INPUT TYPE='checkbox' name='chk"+i+"' id='chk"+i+"' value='' onclick=shiftchk()></td>");
			out.println("</tr>");
			out.println("<INPUT TYPE='hidden' name='sft_code"+i+"' id='sft_code"+i+"' value='"+rs.getString("SHIFT_CODE")+"'>");
			out.println("<INPUT TYPE='hidden' name='shift_mnemonic"+i+"' id='shift_mnemonic"+i+"' value='"+rs.getString("SHIFT_MNEMONIC")+"'>");
			shift_ind = rs.getString("SHIFT_INDICATOR")==null?"":rs.getString("SHIFT_INDICATOR");
			prod_flag = rs.getString("PRODUCTIVE_FLAG")==null?"":rs.getString("PRODUCTIVE_FLAG");
			out.println("<INPUT TYPE='hidden' name='shift_indicator"+i+"' id='shift_indicator"+i+"' value='"+shift_ind+"'>");
			out.println("<INPUT TYPE='hidden' name='productive_flag"+i+"' id='productive_flag"+i+"' value='"+prod_flag+"'>");
			i++;
		}
		i = i-1;
		cnt = ""+i;
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	}
%>
<tr>
	<td colspan='3'>&nbsp;</td>
</tr>
<tr>
	<td class='label' width='30%' align='right'><fmt:message key="eRS.TransferTo.label" bundle="${rs_labels}"/></td>
<%
	//String sql_work="select workplace_code,workplace_desc from rs_workplace where facility_id = ? and workplace_code in(select workplace_code from rs_staff_for_workplace where facility_id = ? and role_type = ? and staff_id = ?and to_date(?,'dd/mm/yyyy')	between eff_date_from and nvl(eff_date_to,to_date('31/12/2200','dd/mm/yyyy')) and eff_status = 'E' and workplace_code != ?)";
	String sql_work="select workplace_code,workplace_desc from rs_workplace_lang_vw where facility_id = ? and workplace_code in(select workplace_code from rs_staff_for_workplace where facility_id = ? and role_type = ? and staff_id = ?and to_date(?,'dd/mm/yyyy') between eff_date_from and nvl(eff_date_to,to_date('31/12/2200','dd/mm/yyyy')) and eff_status = 'E' and workplace_code != ?) and language_id = ?";
	pstmt = con.prepareStatement(sql_work);
	pstmt.setString(1,p_facility_id);
	pstmt.setString(2,p_facility_id);
	pstmt.setString(3,p_role_type);
	pstmt.setString(4,p_staff_id);
	pstmt.setString(5,p_schedule_date);
	pstmt.setString(6,p_workplace_code);
	pstmt.setString(7,locale);
	rs = pstmt.executeQuery();
	if(rs!=null)
	{
%>
	<td>&nbsp;&nbsp;&nbsp;<SELECT name="transfer" id="transfer" onchange="shiftchk()">
			<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
<%	
		while(rs.next())
		{
			out.println("<option value='"+rs.getString("workplace_code")+"'>"+rs.getString("workplace_desc")+"</option>");
		}
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	}
%>
		</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif">
	</td>
	<td>&nbsp;</td>
</tr>
<tr>
	<td colspan='3'>&nbsp;</td>
</tr>
<tr>
	<td class='label' width='30%' align='right'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
<%
	//String sql_reason="select reason_code,reason_desc from rs_reason where activity_type_code = 'TR' and eff_status = 'E' order by reason_desc";
	String sql_reason="select reason_code,reason_desc from rs_reason_lang_vw where activity_type_code = 'TR' and eff_status = 'E' and language_id = ? order by reason_desc";
	pstmt = con.prepareStatement(sql_reason);
	pstmt.setString(1,locale);
	rs = pstmt.executeQuery();
	if(rs!=null)
	{
%>
	<td>&nbsp;&nbsp;&nbsp;<SELECT name="reason" id="reason">
			<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
<%	
		while(rs.next())
		{
			out.println("<option value='"+rs.getString("reason_code")+"'>"+rs.getString("reason_desc")+"</option>");
		}
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	}
%>
		</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif">
	</td>
	<td>&nbsp;</td>
</tr>
<tr>
	<td colspan='3'>&nbsp;</td>
</tr>
<tr>
	<td class='label' width='30%' align='right'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;&nbsp;<TEXTAREA NAME="remarks" COLS="30" onkeypress='return notallowenter(event);'></TEXTAREA>
	</td>
	<td>&nbsp;</td>
</tr>
<tr>
	<td colspan='3'>&nbsp;</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td align='right'><INPUT TYPE="button" class='button' value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' onclick="apply()"><INPUT TYPE="button" class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="wincls()"></td>
</tr>
<tr>
	<td colspan='3'>&nbsp;</td>
</tr>
</table>
<INPUT TYPE="hidden" name="p_shift_code" id="p_shift_code" value="<%=p_shift_code%>">
<INPUT TYPE="hidden" name="p_requirement_id" id="p_requirement_id" value="">
<INPUT TYPE="hidden" name="p_workplace_code" id="p_workplace_code" value="<%=p_workplace_code%>">
<INPUT TYPE="hidden" name="p_schedule_date" id="p_schedule_date" value="<%=p_schedule_date%>">
<INPUT TYPE="hidden" name="p_role_type" id="p_role_type" value="<%=p_role_type%>">
<INPUT TYPE="hidden" name="p_staff_id" id="p_staff_id" value="<%=p_staff_id%>">
<INPUT TYPE="hidden" name="p_staff_type" id="p_staff_type" value="<%=p_staff_type%>">
<INPUT TYPE="hidden" name="p_position_code" id="p_position_code" value="<%=p_position_code%>">
<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
<INPUT TYPE="hidden" name="shift_start_time" id="shift_start_time" value="">
<INPUT TYPE="hidden" name="shift_end_time" id="shift_end_time" value="">
<INPUT TYPE="hidden" name="mode" id="mode" value="insert">
<INPUT TYPE="hidden" name="count" id="count" value="<%=cnt%>">
</form>
</body>
<%
	}
	catch (Exception e)
	{
		out.println(e.toString());
	}
	finally
	{
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

