<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*" %>
   <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
		Statement stmt   	= null ;
		ResultSet rs   	= null;
		String fac_id    	= (String) session.getValue( "facility_id" ) ;
		String f_mode		= "delete" ;
		String p_clinic_code	= request.getParameter("clinic_code") ;
		String p_pract_id	= request.getParameter("practid") ;
		String p_day_no		= request.getParameter("dayno") ;
		String p_time_table_type= request.getParameter("timetabletype") ;
		String p_roster_checked = "" ;
		StringBuffer sql=new StringBuffer("") ;
try
{
 con = ConnectionManager.getConnection(request);
		 stmt   	= con.createStatement() ;
	%>

	<HTML>

	<HEAD>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>
	<script language="javascript" src="../../eCommon/js/common.js"> 		</script>
	<script language="javascript" src="../../eOA/js/TimeTable.js">		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</HEAD>
	<BODY onLoad="javascript:timetableType()"  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<FORM name='TimeTable' id='TimeTable' method='post' action='../../servlet/eOA.TimeTableServlet' target='messageFrame'>

<%
	sql.append( "select clinic_code,clinic_name,day_no,day_of_week,practitioner_id,practitioner_name,") ; 
	sql.append( "time_table_type,to_char(start_time,'hh24:mi')start_time,to_char(end_time,'hh24:mi')end_time,");
	sql.append( "nvl(to_char(time_per_patient,'hh24:mi'),'00:00')time_per_patient,nvl(max_patients_per_day,0)max_patients_per_day,nvl(to_char(time_per_slab,'hh24:mi'),'00:00')time_per_slab,") ;
	sql.append( "nvl(max_patients_per_slab,0)max_patients_per_slab,nvl(max_first_visits,0)max_first_visits,nvl(max_over_booking,0)max_over_booking,NVL(phys_roster_reqd_yn,'N')phys_roster_reqd_yn,nvl(remarks,'&nbsp;')remarks  ") ;
	sql.append("from oa_clinic_time_table_vw where facility_id = '"+fac_id+"' " );
	sql.append("and clinic_code = '"+p_clinic_code+"' and practitioner_id = '"+p_pract_id+"' ");
	sql.append("and day_no = '"+p_day_no+"' and time_table_type = '"+p_time_table_type+"' ") ;

	rs = stmt.executeQuery(sql.toString());
	sql.setLength(0);
	rs.next() ;
	
%>

	<TABLE WIDTH='100%' CELLPADDING='0' CELLSPACING='0' BORDER='0'>
	<tr><td class='BODYCOLORFILLED'>&nbsp;</td></tr>
	<tr><td>&nbsp;</td></tr>
	<TR>
	<TD CLASS='BORDER'>

	<TABLE WIDTH='90%' CELLPADDING='0' CELLSPACING='0' BORDER='0'  ALIGN='CENTER'>
	<TR>
	<TD>

	<TABLE WIDTH='90%' CELLPADDING='0' CELLSPACING='0' BORDER='0'>
	<TR>
	<TD class="label" align='right' width='15%'>Clinic</TD>
	<TD class="label" align='left'  width='15%'>&nbsp;&nbsp;
	<INPUT name='b_clinic_name' id='b_clinic_name' VALUE='<%=rs.getString("clinic_name")%>' readonly>
	<INPUT TYPE='hidden' name='b_clinic' id='b_clinic' VALUE='<%=rs.getString("clinic_code")%>'>
	</TD>
				
	<TD class="label" align='right' width='19%'>Practitioner</TD>
	<TD class="label" align='left'  width='16%'>&nbsp;&nbsp;

	<INPUT name='b_practitioner_name' id='b_practitioner_name' VALUE='<%=rs.getString("practitioner_name")%>' readonly>
	<INPUT TYPE='hidden' name='b_practitioner' id='b_practitioner' VALUE='<%=rs.getString("practitioner_id")%>'>
	</TD>
	</TR>
	<TR>
	
	<TD class="label" align='right' width='15%'>Day</TD>
	<TD class="label" align='left'  width='15%'>&nbsp;&nbsp;
	<INPUT name='b_week_day' id='b_week_day' VALUE='<%=rs.getString("day_of_week")%>' readonly>
	</TD>
				
	<TD class="label" align='right' width='19%'>Roster Required ?</TD>
	<TD class="label" align='left'  width='16%'>&nbsp;
	<%
	String chk = "" ;
	p_roster_checked = rs.getString("phys_roster_reqd_yn") ;

	if (p_roster_checked.equals("Y"))
	{
		chk = "checked" ;
	}
	else
	{
		chk = "" ;
	}
	%>
	<INPUT TYPE=CHECKBOX name='b_roster_reqd' id='b_roster_reqd' <%=chk%>>
	</TD>
	</TR>

	<TR>
	<TD class="label" align='right' width='15%'>Time Table Type</TD>
	<TD class="label" align='left'  width='15%' COLSPAN='1'>&nbsp;&nbsp;
	<%
	out.println("<INPUT name='time_table_type' id='time_table_type' VALUE='");
	
	if (rs.getString("time_table_type").equals("1"))
	{
		out.println("Slot");out.println("' readonly>");
		out.println("<INPUT TYPE='hidden' NAME=b_time_table_type VALUE='1'>") ;
	}
	else if (rs.getString("time_table_type").equals("2"))
	{
		out.println("Slab");out.println("' readonly>");
		out.println("<INPUT TYPE='hidden' NAME=b_time_table_type VALUE='2'>") ;
	}
	else if (rs.getString("time_table_type").equals("3"))
	{
		out.println("Free Time");out.println("' readonly>");
		out.println("<INPUT TYPE='hidden' NAME=b_time_table_type VALUE='3'>") ;
	}
	%>

	<INPUT TYPE='HIDDEN' name='b_time_table_type_hd' id='b_time_table_type_hd' VALUE='<%=rs.getString("time_table_type")%>'>
	<INPUT TYPE='HIDDEN' name='b_day' id='b_day' VALUE='<%=rs.getString("day_no")%>'>

	</TD>
	<td><input type='hidden' name='l_ident_at_checkin' id='l_ident_at_checkin'></td>
	<td><input type='hidden' name='l_fi_visit_type_appl_yn' id='l_fi_visit_type_appl_yn'></td>
	</TR>
	</TABLE>
	</TD>
	</TR>
	</TABLE>
	</TD></TR>
	<tr><td>&nbsp;</td></tr>
	<tr><td class='BODYCOLORFILLED'>&nbsp;</td></tr>

	<TR>
	<TD class='BORDER'>
	<TABLE WIDTH='100%' CELLPADDING='0' CELLSPACING='0' BORDER='0' ALIGN='CENTER'>
	<TH align='left'>Clinic Charactersitics</TH>
	</TABLE>
	</TD>
	</TR>
	<tr><td>&nbsp;</td></tr>

	<TR>
	<TD class='BORDER'>
	<TABLE WIDTH='90%' CELLPADDING='0' CELLSPACING='0' BORDER='0' ALIGN='CENTER'>
	<TR>
	<TD CLASS='BORDER'>
	<TABLE WIDTH='90%' CELLPADDING='0' CELLSPACING='0' BORDER='0'>
	<TR>
	<TD class="label" align='right' width='15%'>Start Time</TD>
	<TD class="label" align='left' width='15%' >&nbsp;&nbsp;
	<INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name='b_start_time' id='b_start_time' VALUE='<%=rs.getString("start_time")%>'"> 
	&nbsp;<img src="../../eCommon/images/mandatory.gif" align='center'></img></TD>
					
	<TD class="label" align='right' width='19%'>End Time</TD>
	<TD class="label" align='left' width='16%'>&nbsp;&nbsp;
	<INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name='b_end_time' id='b_end_time'   VALUE='<%=rs.getString("end_time")%>' "> 
	&nbsp;<img src="../../eCommon/images/mandatory.gif" align='center'></img></TD>
	<td><input type='hidden' name='l_p_fi_visit_type_appl_yn' id='l_p_fi_visit_type_appl_yn'></td>
	</TR>
	</TABLE>
	</TD>
	</TR>
	</TABLE>
	</TD>
	</TR>

	<TR>
	<TD class='BORDER'>
	<TABLE WIDTH='90%' CELLPADDING='0' CELLSPACING='0' BORDER='0' ALIGN='CENTER'>
	<TR>
	<TD CLASS='BORDER'>
	<TABLE WIDTH='90%' CELLPADDING='0' CELLSPACING='0' BORDER='0'>
	<TR>
	<TD class="label" align='right' width='15%'>Time per Patient</TD>
	<TD class="label" align='left' width='15%' >&nbsp;&nbsp;
	<INPUT name='b_time_per_patient' id='b_time_per_patient' TYPE=TEXT SIZE=5 MAXLENGTH=5 VALUE='<%=rs.getString("time_per_patient")%>' > </TD>
	
	<TD class="label" align='right' width='19%'>Maximum Patients per Day</TD>
	<TD class="label" align='left' width='16%'>&nbsp;&nbsp;
	<INPUT name='b_max_patients_per_day' id='b_max_patients_per_day' TYPE=TEXT SIZE=5 MAXLENGTH=3 VALUE='<%=rs.getString("max_patients_per_day")%>' > </TD>
	<td><input type='hidden' name='l_max_pat_per_day' id='l_max_pat_per_day'></td>
	</TR>

	<TR>
	<TD class="label" align='right' width='15%'>Time per Slab</TD>
	<TD class="label" align='left' width='15%' >&nbsp;&nbsp;
	<INPUT name='b_time_per_slab' id='b_time_per_slab' TYPE=TEXT SIZE=5 MAXLENGTH=5 VALUE='<%=rs.getString("time_per_slab")%>' > </TD>
	
	<TD class="label" align='right' width='19%'>Maximum Patients per Slab</TD>
	<TD class="label" align='left' width='16%'>&nbsp;&nbsp;
	<INPUT name='b_max_patients_per_slab' id='b_max_patients_per_slab' TYPE=TEXT SIZE=5 MAXLENGTH=3 VALUE='<%=rs.getString("max_patients_per_slab")%>' > </TD>
	</TR>

	<TR>
	<TD class="label" align='right' width='15%'>Maximum First Visit</TD>
	<TD class="label" align='left' width='15%'>&nbsp;&nbsp;
	<INPUT name='b_max_first_visit' id='b_max_first_visit' TYPE=TEXT SIZE=5 MAXLENGTH=3 VALUE='<%=rs.getString("max_first_visits")%>' > </TD>
	
	<TD class="label" align='right' width='19%'>Maximum Over Bookings</TD>
	<TD class="label" align='left' width='16%'>&nbsp;&nbsp;
	<INPUT name='b_max_over_bookings' id='b_max_over_bookings' TYPE=TEXT SIZE=5 MAXLENGTH=3 VALUE='<%=rs.getString("max_over_booking")%>' > </TD>
	</TR>

	</TABLE>
	</TD>
	</TR>
	</TABLE>
	</TD>
	</TR>
	<tr><td colspan='3'>&nbsp;</td></tr>

	<TR>
	<TD class='BORDER'>
	<TABLE WIDTH='90%' CELLPADDING='0' CELLSPACING='0' BORDER='0' ALIGN='CENTER'>
	<TR>
	<TD CLASS='BORDER'>
	<TABLE WIDTH='90%' CELLPADDING='0' CELLSPACING='0' BORDER='0'>
	<TR>
	<TD class="label" align='right' width='15%'>Remarks</TD>
	<TD class="label" align='left' width='49%' >&nbsp;&nbsp;
	<INPUT name='b_remarks' id='b_remarks' TYPE=TEXT SIZE=67 VALUE='<%=rs.getString("remarks")%>' MAXLENGTH=60></TD>
	</TR>
	</TABLE>
	</TD>
	</TR>
	</TABLE>
	</TD>
	</TR>
	<tr><td>&nbsp;</td>
	</tr>
	<tr><td class='BODYCOLORFILLED'>&nbsp;</td></tr>
	
	<TR>
	<TD class='BORDER'>
	<TABLE WIDTH='90%' CELLPADDING='0' CELLSPACING='0' BORDER='0' ALIGN='CENTER'>
	<TR>
	<TD align='left' width='15%'>
	<INPUT TYPE='HIDDEN' name='fmode' id='fmode' VALUE='<%=f_mode%>'>
	<INPUT TYPE='HIDDEN' name='ftotstr' id='ftotstr' >
	</TD>
	</TR>
	</TABLE>
	</TD>
	</TR>
	</TABLE>
	</FORM>
	</BODY>
	</HTML>
	
	<%
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
}catch(Exception e) { 
	//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{

	ConnectionManager.returnConnection(con,request);
}
%>

