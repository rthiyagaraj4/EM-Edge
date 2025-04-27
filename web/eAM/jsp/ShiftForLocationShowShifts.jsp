<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");	
    Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String locn_type = request.getParameter("locn_type")==null ? "":request.getParameter("locn_type");
	String facility = request.getParameter("facility")==null ? "":request.getParameter("facility");
try{
	String shift_code="";
	String shift_desc="";
	String start_time="";
	String end_time="";
	String shift_indicator="";
	String productive_flag="";
	String appl_for_working_days="";
	String appl_for_nonworking_days="";
	String appl_for_holidays="";
	String db_action="";
	String eff_status="";
	String checked="";
	int i=0; 
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='frm_list' id='frm_list' method=POST action='../../servlet/eAM.ShiftForLocationTypeServlet'
target='messageFrame'>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<tr>
		<td class='columnheader' rowspan="2"><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></td>
		<td class='columnheader' rowspan="2"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='columnheader' rowspan="2"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td class='columnheader' rowspan="2"><fmt:message key="Common.ShiftIndicator.label" bundle="${common_labels}"/></td>
		<td class='columnheader' rowspan="2"><fmt:message key="Common.ProductiveFlag.label" bundle="${common_labels}"/></td>
		<td class='columnheader' colspan="3"><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></td>
		<td class='columnheader' rowspan="2"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
			<td class='columnheader'><fmt:message key="Common.WDay.label" bundle="${common_labels}"/></td>
			<td class='columnheader'><fmt:message key="Common.NWDay.label" bundle="${common_labels}"/></td>
			<td class='columnheader'><fmt:message key="Common.HDay.label" bundle="${common_labels}"/></td>
		</tr>
<%
	String qry_shift = "select a.shift_code,b.long_desc shift_desc, to_char(b.shift_start_time,'hh24:mi') start_time, to_char(b.shift_end_time,'hh24:mi') end_time,decode(b.shift_indicator,'P','Productive','U','Unproductive','L','Leave','A','Absence') shift_indicator, decode(b.productive_flag,'W','Working','O','On Call','T','Training') productive_flag, b.appl_for_working_days appl_for_working_days, b.appl_for_nonworking_days appl_for_nonworking_days, b.appl_for_holidays appl_for_holidays, 'U' db_action,a.eff_status eff_status from am_shift_for_locn_type a, am_shift b where locn_type = ? and facility_id = ? and a.shift_code = b.shift_code union all select shift_code,long_desc shift_desc, to_char(shift_start_time,'hh24:mi') start_time, to_char(shift_end_time,'hh24:mi') end_time, decode(shift_indicator,'P','Productive','U','Unproductive',    'L','Leave','A','Absence') shift_indicator, decode(productive_flag,'W','Working','O','On Call','T','Training') productive_flag, appl_for_working_days, appl_for_nonworking_days,appl_for_holidays, 'I' db_action, 'E' eff_status from am_shift where eff_status = 'E' and shift_code not in ( select shift_code from am_shift_for_locn_type    where locn_type = ? and facility_id = ?) order by shift_desc";
	pstmt = conn.prepareStatement(qry_shift);
	
	pstmt.setString(1,locn_type);
	pstmt.setString(2,facility);
	pstmt.setString(3,locn_type);
	pstmt.setString(4,facility);


	rs = pstmt.executeQuery();
	while(rs.next())
	{
		shift_code=rs.getString("shift_code")==null ? "":rs.getString("shift_code");
		shift_desc=rs.getString("shift_desc")==null ? "":rs.getString("shift_desc");
		start_time=rs.getString("start_time")==null ? "":rs.getString("start_time");
		end_time=rs.getString("end_time")==null ? "":rs.getString("end_time");
		shift_indicator=rs.getString("shift_indicator")==null ? "":rs.getString("shift_indicator");
		productive_flag=rs.getString("productive_flag")==null ? "":rs.getString("productive_flag");
		appl_for_working_days=rs.getString("appl_for_working_days")==null ? "":rs.getString("appl_for_working_days");
		appl_for_nonworking_days=rs.getString("appl_for_nonworking_days")==null ? "":rs.getString("appl_for_nonworking_days");
		appl_for_holidays=rs.getString("appl_for_holidays")==null ? "":rs.getString("appl_for_holidays");
		db_action=rs.getString("db_action")==null ? "":rs.getString("db_action");
		eff_status=rs.getString("eff_status")==null ? "":rs.getString("eff_status");
//out.println(db_action);
//out.println(eff_status);

	String classValue = "" ;
		if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
	%>
		<input type=hidden name='shift_code<%=i%>' id='shift_code<%=i%>' value='<%=shift_code%>'>
	<%
	out.println(shift_desc +"</td><td class='" + classValue + "'>");
	out.println(start_time +"</td><td class='" + classValue + "'>");
	out.println(end_time +"</td><td class='" + classValue + "'>");
	out.println(shift_indicator +"</td><td class='" + classValue + "'>");
	if(productive_flag.equalsIgnoreCase("Working") || productive_flag.equalsIgnoreCase("On Call") ||
		productive_flag.equalsIgnoreCase("Training"))
	out.println(productive_flag +"</td><td class='" + classValue + "' align='center'>");
	else
	out.println("&nbsp" +"</td><td class='" + classValue + "' align='center'>");
		
	
	if (appl_for_working_days.equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td><td class='" + classValue + "' align='center'>");
		
	if (appl_for_nonworking_days.equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td><td class='" + classValue + "' align='center'>");
		
	if (appl_for_holidays.equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td><td class='" + classValue + "' align='center'>");

	if((db_action.equals("U")) && (eff_status.equals("E")))
	{
		checked="checked";
	}
	else 
	{
		checked="";
	}
		//out.println("inside u and e--->"+checked);
%>
	<input type=checkbox name="select<%=i%>" id="select<%=i%>" <%=checked%>>
	<input type=hidden name="db_action<%=i%>" id="db_action<%=i%>" value="<%=db_action%>">
	<input type=hidden name="prev_select<%=i%>" id="prev_select<%=i%>" value="<%=checked%>">

<%	
	out.println("</td></tr>");
	i++;
	}
//		out.println("checked"+checked);

%>
	</table>
	<input type=hidden name='locn_type' id='locn_type' value='<%=locn_type%>'>
	<input type=hidden name='facility' id='facility' value='<%=facility%>'>
	<input type=hidden name='noOfRecords' id='noOfRecords' value='<%=i-1%>'>
	<input type=hidden name='operation_type' id='operation_type' value='insert'>
	<input type=hidden name='operation' id='operation' value='showshifts'>
</form>
<%
}catch(Exception e)
{
	out.println(e.getMessage());
	e.printStackTrace();
}
finally
{
	try
	{
	if (pstmt != null) pstmt.close();
	if (rs != null)   rs.close();
	ConnectionManager.returnConnection(conn,request);
	}
	catch(Exception exp)
	{
		out.println(exp.toString());
	}
}
%>
</body>
</html>

