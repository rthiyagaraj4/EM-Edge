<!DOCTYPE html>
	<%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	16 Nov 2004.
* --%>

<html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
	<script language="javascript" src="../js/RSCommon.js"></script>
	<script language="javascript" src="../js/GenerateWorkSchedule.js"></script>
	<script language="javascript" src="../js/GenerateWorkScheduleData.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body  onload='FocusFirstElement();' onMouseDown="CodeArrest();" onKeyDown="lockKey();" >
<%
	Connection Con			= null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_currdate 	= null;
	PreparedStatement pstmt_Period_for_Schedule 	= null;
	ResultSet rslRst		= null;
	ResultSet rs_currdate 		= null;
	ResultSet rs_Period_for_Schedule 		= null;

	String appl_user_id	=(String)session.getValue("login_user");
	String facility_id	=(String)session.getValue( "facility_id" ) ;
	String currentdate="";
	String chkSql		="";
	String count		="";
	String locnSql		="";
	String locn_type	="";
	String locn_desc	="";
	int period_for_schedule=0;

	try{
		Con=ConnectionManager.getConnection(request);
				
			chkSql="select count(*) count FROM rs_access_rights WHERE appl_user_id = (?) AND facility_id = (?) AND ALLOCATE_YN = 'Y'";
				
				pstmt=Con.prepareStatement(chkSql);
				pstmt.setString(1,appl_user_id);
				pstmt.setString(2,facility_id);
				rslRst = pstmt.executeQuery();
			if(rslRst!=null)
			{
				while(rslRst.next()){
					count=rslRst.getString("COUNT");
				}
			}
			if(pstmt != null)
				pstmt.close();
			if(rslRst != null)
				rslRst.close();
			 int cnt=Integer.parseInt(count);

			if(cnt<=0){
				out.println("<script>alert(getMessage('NO_AXS_FOR_GEN_SCH','RS')); parent.parent.document.location.href='../../eCommon/jsp/home.jsp' </script>");
			}
			else{

				pstmt_currdate=Con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') d from dual ");
				rs_currdate=pstmt_currdate.executeQuery();
				rs_currdate.next();
				currentdate = rs_currdate.getString("d");
				if(pstmt_currdate != null)
					pstmt_currdate.close();
				if(rs_currdate != null)
					rs_currdate.close();

				String sql_period_for_schedule="select PERIOD_FOR_WORK_SCHEDULE_GEN days from rs_parameter where facility_id=?";
				pstmt_Period_for_Schedule=Con.prepareStatement(sql_period_for_schedule);
				pstmt_Period_for_Schedule.setString(1,facility_id);
				rs_Period_for_Schedule=pstmt_Period_for_Schedule.executeQuery();
				rs_Period_for_Schedule.next();
				period_for_schedule =Integer.parseInt(rs_Period_for_Schedule.getString("days")==null?"0":rs_Period_for_Schedule.getString("days"));
	%>

	<form name='formWrkScheduleCriteria' id='formWrkScheduleCriteria'>
	<table cellpadding='0' cellspacing='0' border='0' width="100%" align='center'>

	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
	<tr>
		<td width='15%'  align='right' class='label'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;</td>
		<td>&nbsp;<SELECT name='locn' id='locn' onchange='locnchange()'>
			<option value=''>&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
			<%
				locnSql="SELECT short_desc, locn_type FROM am_Care_locn_type_lang_vw where language_id = ? ORDER BY short_desc";

				pstmt=Con.prepareStatement(locnSql);
				pstmt.setString(1,locale);
				rslRst = pstmt.executeQuery();
				if(rslRst != null)
				{
					while(rslRst.next()){
						locn_type=rslRst.getString("locn_type");
						locn_desc=rslRst.getString("short_desc");
						out.println("<option value="+locn_type+'>'+locn_desc+"</option>");
					}
				}
			%>
		</SELECT></td>

		<td width="12%"  align=right class="label"><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;</td>
		<td>&nbsp;<input type=text name="work_text" id="work_text" value="" size="35" maxlength='30' onBlur='viewWrkPlace("T",work_text);'><input class='button' type=button name="wrklookup_button" id="wrklookup_button" value="?"  onClick='viewWrkPlace("B",work_text);'>&nbsp;<img src="../../eCommon/images/mandatory.gif">
		<input type="hidden" name="wrk_code" id="wrk_code" value="" ></td>
	</tr>

	<tr>
		<td width="15%"  align=right class="label"><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/>&nbsp;</td>
		<td>&nbsp;<SELECT name="role_type" id="role_type" onChange='rolechange();'>
			<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>&nbsp;<img src="../../eCommon/images/mandatory.gif">
			<option value="P"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
			<option value="O"><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
		</SELECT></td>
		<td width="15%"  align=right class="label"><fmt:message key="eRS.StaffType.label" bundle="${rs_labels}"/>&nbsp;</td>
		<td>&nbsp;<SELECT name="staff_type" id="staff_type" onChange='stafftypechange();'>
			<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
		</SELECT></td>
	</tr>

	<tr>
		<td width="8%"  align=right class="label"><fmt:message key="Common.Position.label" bundle="${common_labels}"/>&nbsp;</td>
		<td>&nbsp;<input type=text name="position_text" id="position_text" value="" size="25" onBlur='viewPosition("T", position_text);'><input class='button' type=button name="position_button" id="position_button" value="?"  onClick='viewPosition("B", position_text);'>
		<input type='hidden' name='position_code' id='position_code' value=''></td>
		<td width="12%"  align=right class="label"><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/>&nbsp;</td>
		<td>&nbsp;<input type=text name="staff_text" id="staff_text" value="" size="25" onBlur=''><input class='button' type=button name="stafflookup_button" id="stafflookup_button" value="?"  onClick='showStaff(staff_text);'>
		<input type='hidden' name='staff_id' id='staff_id' value=''></td>
	</tr>

	<tr>
		<td width="20%"  align=right class="label"><fmt:message key="eRS.GenerateSchedule.label" bundle="${rs_labels}"/>&nbsp;</td>
		<td colspan='3' class='label'>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp<input type='text' name='frm_dt' id='frm_dt' id='id_frm_date' size='8' maxlength='10' value='' onBlur="if(CheckDate(this)) checkFromDate(),checkDateRange(to_dt);" onKeyPress='return AllowDateFormat();'><img name='frm_dt_img' src='../../eCommon/images/CommonCalendar.gif' onclick="return showCal(frm_dt,'id_frm_date');">&nbsp;<img src="../../eCommon/images/mandatory.gif">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp<input type='text' name='to_dt' id='to_dt' id='id_to_date' size='8' maxlength='10' value='' onBlur='if(CheckDate(this)) return checkDateRange(this);' onKeyPress='return AllowDateFormat();'><img name='to_dt_img' src='../../eCommon/images/CommonCalendar.gif' onclick="return showCal(to_dt,'id_to_date');">&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>

	<tr>
		<td align='right' colspan='4'>&nbsp;<input class='button' type=button name="wrk_sch_button" id="wrk_sch_button" value='<fmt:message key="eRS.GenerateWorkSchedule.label" bundle="${rs_labels}"/>'onClick='GenerateSchedule()'></td>
	</tr>

	</table>
<%
			}	
	}catch(Exception e)
		{
			out.println("Exception in try of WrkPlaceReqdSrch.jsp : "+e);
		}
		finally 
		{
			if (pstmt != null) pstmt.close();
			if(pstmt_currdate != null)pstmt.close();
			if(pstmt_Period_for_Schedule != null)pstmt_Period_for_Schedule.close();

			if (rslRst != null) rslRst.close();
			if(rs_currdate != null)rs_currdate.close();
			if(rs_Period_for_Schedule != null)rs_Period_for_Schedule.close();

			if(Con!=null) ConnectionManager.returnConnection(Con,request);
		}
%>
<input type='hidden'  name='appl_user_id' id='appl_user_id' value='<%=appl_user_id%>'>
<input type='hidden'  name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type="hidden" name="locale" id="locale" value="<%=locale%>" >
<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>
<input type='hidden' name='period_for_schedule' id='period_for_schedule' value='<%=period_for_schedule%>'>
</form>
</body>
</html>

