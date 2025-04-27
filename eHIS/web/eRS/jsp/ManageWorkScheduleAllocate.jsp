<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	15 Feb 2005
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
<title><fmt:message key="eRS.AllocateNewShift.label" bundle="${rs_labels}"/></title>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eRS/js/ManageWorkScheduleAllocate.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CallableStatement cstmt = null;
	String p_facility_id  = request.getParameter("p_facility_id");
	String p_workplace_code = request.getParameter("p_workplace_code");
	String p_date  = request.getParameter("p_date");
	int p_cell_no  = Integer.parseInt(request.getParameter("p_cell_no"));
	String p_role_type  = request.getParameter("p_role_type");
	String p_staff_id  = request.getParameter("p_staff_id");
	String p_staff_type  = request.getParameter("p_staff_type");
	String p_position_code  = request.getParameter("p_position_code");
	String p_shift_code  = request.getParameter("p_shift_code");
	String p_shift_mnemonic  = request.getParameter("p_shift_mnemonic");
	//System.err.println("p_shift_mnemonic--------->"+p_shift_mnemonic);
	
	String p_requirement_id = "";
	String p_schedule_date  = "";
	/*System.out.println("values in manageworkscheduleallocatejsp");
	System.out.println("=========================================");
	System.out.println("p_workplace_code-----|"+p_workplace_code+"|------");
	System.out.println("p_date-----|"+p_date+"|------");
	System.out.println("p_cell_no -----|"+p_cell_no +"|------");
	System.out.println("p_role_typee-----|"+p_role_type+"|------");
	System.out.println("p_staff_id-----|"+p_staff_id+"|------");
	System.out.println(" p_staff_type-----|"+ p_staff_type+"|------");
	System.out.println(" p_position_code-----|"+ p_position_code+"|------");
	System.out.println(" p_shift_code-----|"+ p_shift_code+"|------");
	System.out.println("p_shift_mnemonic-----|"+p_shift_mnemonic+"|------");
	System.out.println("p_requirement_id-----|"+p_requirement_id+"|------");
	System.out.println("p_schedule_dat 56e-----|"+p_schedule_date+"|------");*/
	try{
		con = ConnectionManager.getConnection(request);
        StringBuffer temp_shift = new StringBuffer("'" + p_shift_code + "'");
        while(temp_shift.toString().indexOf('|') != -1){
            int index = temp_shift.toString().indexOf('|');
            temp_shift.replace(index,index+1,"','");
        }
		p_shift_code = temp_shift.toString();
		//.out.println("p_shift_code 65-----|"+p_shift_code+"|-----");
        StringBuffer temp_mnemo = new StringBuffer("'" + p_shift_mnemonic + "'");
        while(temp_mnemo.toString().indexOf('|') != -1){
            int index = temp_mnemo.toString().indexOf('|');
            temp_mnemo.replace(index,index+1,"','");
        }
		p_shift_mnemonic = temp_mnemo.toString();
		//.out.println("p_shift_mnemonic 72-----|"+p_shift_mnemonic+"|-----");
		// To get p_schedule_date
		String sql_sch_date = "select to_char(to_date(?,'dd/mm/yyyy') + ?,'dd/mm/yyyy' )p_schedule_date from dual";
		pstmt = con.prepareStatement(sql_sch_date);
		pstmt.setString(1,p_date);
		pstmt.setInt(2,p_cell_no);
		rs = pstmt.executeQuery();
		/*out.println("p_date 79----|"+p_date+"|------");
		System.out.println("p_cell_no 80----|"+p_cell_no+"|------");*/
		if(rs!=null){
			if(rs.next()){
				p_schedule_date = rs.getString("p_schedule_date");
			}
		}
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		// End of p_schedule_date
		String p_activity = "AL";
		
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
			out.println("<script>alert(getMessage('NO_VALID_SHIFT_ALLOCATION','RS'));</script>");
			out.println("<script>window.close();</script>");
		}
%>
</head>
<body>
<form name="ManageWorkScheduleAllocate" id="ManageWorkScheduleAllocate" action='../../servlet/eRS.ManageWorkScheduleAllocateServlet' target='blankFrame' method="post">
<table cellpadding=0 cellspacing=0 border=0 width="100%" align='right'>
<tr>
	<td colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td class='querydata' align='right' width='30%'><fmt:message key="eRS.ScheduleDate.label" bundle="${rs_labels}"/></td>
	<td class='label'>&nbsp;&nbsp;&nbsp;&nbsp;<%=p_schedule_date%></td>
</tr>
<tr>
	<td colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td class='querydata' width='30%' align='right'><fmt:message key="eRS.AlreadyAllocatedShifts.label" bundle="${rs_labels}"/></td>
	<td>&nbsp;</td>
</tr>
<%
		if(!(p_shift_code.equals("") || p_shift_code==null)){
			//String sql_str	=	"select distinct a.shift_code,short_desc,shift_mnemonic from am_shift a,rs_shift_for_workplace b where b.facility_id = ? and a.shift_code in ("+p_shift_code+") and shift_mnemonic in("+p_shift_mnemonic+") and a.shift_code=b.shift_code";
			String sql_str	=	"select distinct a.shift_code,short_desc,shift_mnemonic from am_shift_lang_vw a,rs_shift_for_workplace b where  b.facility_id = ? and a.language_id = ? and a.shift_code in ("+p_shift_code+") and shift_mnemonic in("+p_shift_mnemonic+") and a.shift_code=b.shift_code  ";
			pstmt = con.prepareStatement(sql_str);
			pstmt.setString(1,p_facility_id);
			pstmt.setString(2,locale);


			rs = pstmt.executeQuery();
			
			if(rs!=null){
				while(rs.next()){
					out.println("<tr>");
					out.println("<td class='label' width='30%' align='right'>&nbsp;</td>");
					out.println("<td class='label' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("short_desc")+"&nbsp;&nbsp;"+rs.getString("shift_mnemonic")+"</td>");
					out.println("</tr>");
				}
			}
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}
		else{
%>
			<tr>			
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>			
<%
		}
%>
<tr>
	<td colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td class='label' align='right'><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;&nbsp;<SELECT name="shift" id="shift" onchange='popuvalues()'>
		<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
<%
		if(shift_details.indexOf('~')!=-1){
			StringTokenizer shift_stk = new StringTokenizer(shift_details,"~");
			while (shift_stk.hasMoreTokens()){
				StringTokenizer sft_stk = new StringTokenizer(shift_stk.nextToken(),"|");
				out.println("<option  value='"+sft_stk.nextToken()+"'>"+sft_stk.nextToken()+"("+sft_stk.nextToken()+")"+"</option>");
				p_requirement_id = sft_stk.nextToken();
			}
		}
%>
		</SELECT><img src="../../eCommon/images/mandatory.gif">
	</td>
</tr>
<tr>
	<td >&nbsp;</td>
	<td id='productive' class='label' align='left'>&nbsp;</td>
</tr>
<tr>
	<td colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td class='label' width='30%' align='right'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
<%
	//String sql_reason="select reason_code,reason_desc from rs_reason where activity_type_code = 'AL' and eff_status = 'E' order by reason_desc";
	String sql_reason="select reason_code,reason_desc from rs_reason_lang_vw where language_id = ? and activity_type_code = 'AL' and eff_status = 'E' order by reason_desc";
	pstmt = con.prepareStatement(sql_reason);
	pstmt.setString(1,locale);
	rs = pstmt.executeQuery();
	if(rs!=null){
%>
	<td>&nbsp;&nbsp;&nbsp;<SELECT name="reason" id="reason">
			<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
<%	
		while(rs.next()){
			out.println("<option value='"+rs.getString("reason_code")+"'>"+rs.getString("reason_desc")+"</option>");
		}
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	}
%>
		</SELECT><img src="../../eCommon/images/mandatory.gif">
	</td>
</tr>
<tr>
	<td colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td class='label' width='30%' align='right'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;&nbsp;<TEXTAREA NAME="remarks" COLS="30" onkeypress='return notallowenter(event);'></TEXTAREA>
	</td>
</tr>
<tr>
	<td colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td align='right'><INPUT TYPE="button" class='button' value='Apply' onclick="apply()"><INPUT TYPE="button" class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'onclick="wincls()"></td>
</tr>
<tr>
	<td colspan='2'>&nbsp;</td>
</tr>
</table>
<INPUT TYPE="hidden" name="p_shift_code" id="p_shift_code" value="<%=p_shift_code%>">
<INPUT TYPE="hidden" name="p_requirement_id" id="p_requirement_id" value="<%=p_requirement_id%>">
<INPUT TYPE="hidden" name="p_workplace_code" id="p_workplace_code" value="<%=p_workplace_code%>">
<INPUT TYPE="hidden" name="p_schedule_date" id="p_schedule_date" value="<%=p_schedule_date%>">
<INPUT TYPE="hidden" name="p_role_type" id="p_role_type" value="<%=p_role_type%>">
<INPUT TYPE="hidden" name="p_staff_id" id="p_staff_id" value="<%=p_staff_id%>">
<INPUT TYPE="hidden" name="p_staff_type" id="p_staff_type" value="<%=p_staff_type%>">
<INPUT TYPE="hidden" name="p_position_code" id="p_position_code" value="<%=p_position_code%>">
<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
<INPUT TYPE="hidden" name="mnemonic" id="mnemonic" value="">
<INPUT TYPE="hidden" name="shift_start_time" id="shift_start_time" value="">
<INPUT TYPE="hidden" name="shift_end_time" id="shift_end_time" value="">
<INPUT TYPE="hidden" name="mode" id="mode" value="insert">
<INPUT TYPE="hidden" name="shift_indicator" id="shift_indicator" value="">
<INPUT TYPE="hidden" name="productive_flag" id="productive_flag" value="">
</form>
</body>
<%
	}
	catch (Exception e){
		e.printStackTrace() ;
		out.println(e.toString());
	}
	finally{
		try
		{
		if(cstmt!=null) cstmt.close();
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		ConnectionManager.returnConnection(con,request);
		}
		catch(Exception exp)
		{
			out.println("Exception in finally"+exp.toString());
		}
	}
%>
</html>

