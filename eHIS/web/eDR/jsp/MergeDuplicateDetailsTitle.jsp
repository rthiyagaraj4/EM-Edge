<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ page import="eDR.*" %>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<script language='javascript' src='../../eDR/js/MergeDuplicates.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<!-- <script language='javascript' src='../../eCommon/js/dchk.js'></script> -->
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	String stTime	= "";
	String endTime	= "";

	Connection con			= null;
	java.sql.Statement st	= null;
	ResultSet rs			= null;

	try
	{
		con	= ConnectionManager.getConnection(request);
		st	= con.createStatement();

		rs	= st.executeQuery("SELECT to_char(exec_start_time,'hh24:mi'), to_char(exec_end_time,'hh24:mi') FROM dr_param");
		if(rs != null && rs.next())
		{
			stTime	= rs.getString(1);
		//	stTime=DateUtils.convertDate(stTime,"DMYHM","en",locale);
			endTime	= rs.getString(2);
		//	endTime=DateUtils.convertDate(endTime,"DMYHM","en",locale);
		}

		%>
		<form name='group_details_title' id='group_details_title'>
			<table border='0' width='100%' cellspacing='0' align='center'>
 				
				<tr><th class='columnheader' colspan='6' ><fmt:message key="Common.GroupDetails.label" bundle="${common_labels}"/></th></tr>
				
				<tr>
					<td class='button'  width='25%' >
					<input type='button' class='BUTTON' value='<fmt:message key="eDR.StartNow.label" bundle="${dr_labels}"/>' name='start_now' onClick='start_nowClick();' disabled></td>
					
					<td class='button' width='35%' >
					<input type='button' class='BUTTON' value='<fmt:message key="eDR.StartLater.label" bundle="${dr_labels}"/>' name='start_later' onClick='later_Click();' disabled ></td>
					
					<td class='label' width='15%'><fmt:message key="eDR.Dateandtime.label" bundle="${dr_labels}"/></td>
					
					<td class='fields' width='25%'>
					<input type='text' size='14' name='start_later_time'  id="startlater"  disabled value='' onBlur="validDateObj(this,'DMYHM',localeName);" ><input type='image' disabled id="datepicker" name="calendertime"  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('startlater',null,'hh:mm');"></td>
				</tr>

			</table>
			<table border='1' width='100%' cellspacing='0' align='center'>
				<tr>
					<th class='columnheader' width='16%'><fmt:message key="Common.patient.label" bundle="${common_labels}"/> <fmt:message key="Common.Series.label" bundle="${common_labels}"/></th>
			       
			<th class='columnheader' width='46%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th class='columnheader' width='15%'><fmt:message key="Common.main.label" bundle="${common_labels}"/></th>
					<th class='columnheader' width='15%'><fmt:message key="eDR.Duplicate.label" bundle="${dr_labels}"/></th>
					<th class='columnheader' width='20%'><fmt:message key="eDR.DoNotConsider.label" bundle="${dr_labels}"/></th>
				</tr>
			</table>
			<input type='hidden' name='startTime' id='startTime' value='<%=stTime%>'>
			<input type='hidden' name='endTime' id='endTime' value='<%=endTime%>'>
		</form>
		<%
		if(st!=null) st.close();
		if(rs!=null) rs.close();
	}
	catch(Exception e)
	{
		out.println("Excption e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

