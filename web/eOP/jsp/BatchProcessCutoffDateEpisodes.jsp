<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/DateUtils.js"></script>
	<script src="../../eOP/js/BatchProcess.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' onload='FocusFirstElement()' onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<%
	Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rs= null;

	try  
	{
		con=ConnectionManager.getConnection(request);
		Statement stmt=con.createStatement();
		ResultSet rset= null;
		//String locale = localeName;
		String episode_closure_by="";
		String Cut_off_date1="";
		//String Cut_off_date2="";
		String facility_id="";

		String srcode="";
		String srdesc="";

		facility_id=(String) session.getValue("facility_id");

		try
		{
			rset=stmt.executeQuery("Select nvl(episode_closure_by,'D') episode_closure_by from op_param where OPERATING_FACILITY_ID='"+facility_id+"'");

			if (rset!=null)
			{
				while (rset.next())
				{
					episode_closure_by=rset.getString("episode_closure_by");
				}

			}

		}catch(Exception e) { 
			e.printStackTrace();
			out.println(e.toString());}
		finally
		{
			if (rset != null) rset.close();
			if (stmt != null) stmt.close();
		}
		//String Cut_off_date1_display=DateUtils.convertDate(Cut_off_date1,"DMY","en",locale);
		//String Cut_off_date2_display=DateUtils.convertDate(Cut_off_date2,"DMY","en",locale);
%>
		<center>
			<form name = 'Cutoof_Date_Episodes_Form' >
				<br><br>

				<table border=0 cellpadding=0 cellspacing=0 width='80%' align=center>
				<%if(!episode_closure_by.equals("N")){%>
				<th  class='columnheader' colspan='2' align="left"><fmt:message key="eOP.CutoffDateforAutoCloseEpisodes.label" bundle="${op_labels}"/></th>
				<%}else{%>
				<th  class='columnheader' colspan='2'><fmt:message key="eOP.ClosureRulebasedonNoshowslastvisitFutappt.label" bundle="${op_labels}"/></th>
				<%}%>
				<table border=0 cellpadding=2 cellspacing=0 width='80%' align=center>
					<tr>
						<td class='LABEL' width='30%'colspan='2'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
						<td class='fields' width='50%'colspan='2'><select name='service' id='service' onChange='dtValue(this);'>
						<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
									bundle="${common_labels}"/> --------&nbsp;</option>
	<%
						pstmt = con.prepareStatement("Select short_desc, service_code from am_service where eff_status = 'E' order by short_desc");
						rs = pstmt.executeQuery();
						if(rs != null)
						{
							while(rs.next())
							{
							    srcode = rs.getString("service_code");
								srdesc = rs.getString("short_desc");

								out.println("<option value='"+srcode+"'>"+srdesc+"</option>");
							}
						}
	%>
						</select>
						</td>
					</tr>
<% if (!episode_closure_by.equals("N")){%>
					<tr>
						<td class='LABEL' width='30%'colspan='2'><fmt:message key="eOP.CutoffDatewithFollowup.label" bundle="${op_labels}"/></td>
						<td class='fields' width='50%' colspan='2'><input type='text' id='cutoffdate' name='Cut_off_date1' id='Cut_off_date1' READONLY value='' size=10 maxlength=10 onblur='validDateObj(this,"DMY",localeName);'></td>
					</tr>
					<tr>
						<td class='LABEL' width='30%'colspan='2'><fmt:message key="eOP.Cu-offDatewithoutFollowup.label" bundle="${op_labels}"/></td>
						<td class='fields' width='50%' colspan='2'><input type='text' id='cutoffdate1' name='Cut_off_date2' id='Cut_off_date2' READONLY value='' size=10 maxlength=10 onblur='validDateObj(this,"DMY",localeName);'></td>
					</tr>
					<input type='hidden' name='consecutive_no_shows' id='consecutive_no_shows' value=''>
					<input type='hidden' name='consecutive_no_shows_months' id='consecutive_no_shows_months' value=''>
					<input type='hidden' name='no_of_visits_months' id='no_of_visits_months' value=''>
					<input type='hidden' name='no_of_future_appts_months' id='no_of_future_appts_months' value=''>

					<%}else{%>
					<tr>
					<td width='30%'class='label'colspan='2'><fmt:message key="eOP.ConsecutiveNoShows.label" bundle="${op_labels}"/></td>
					<td width='50%' class='fields' colspan='2' >
					<input type ='text' name='consecutive_no_shows' id='consecutive_no_shows' value="" size='6' maxlength='3' readonly>&nbsp;&nbsp;<fmt:message key="eOP.in.label" bundle="${op_labels}"/>&nbsp;&nbsp;<input type ='text' name='consecutive_no_shows_months' id='consecutive_no_shows_months' value="" size='6' maxlength='2' readonly/>&nbsp;&nbsp;<fmt:message key="Common.months.label" bundle="${common_labels}"/>
					</td>
				</tr>
				<tr>
					<td width='30%' class='label'colspan='2'><fmt:message key="eOP.NoVisitsInLast.label" bundle="${op_labels}"/></td>
		            <td width='50%' class='fields' colspan='2' >
					<input type ='text' name='no_of_visits_months' id='no_of_visits_months' value="" size='6' maxlength='2'  readonly>
					<fmt:message key="Common.months.label" bundle="${common_labels}"/>
						
			        </td>
				</tr>			   
				<tr>
					<td width='30%' class='label'colspan='2'><fmt:message key="eOP.NoFutApptsIn.label" bundle="${op_labels}"/></td>
		            <td width='50%' class='fields' colspan='2' >
					<input type ='text' name='no_of_future_appts_months' id='no_of_future_appts_months' value="" size='6' maxlength='2'  readonly>
					<fmt:message key="Common.months.label" bundle="${common_labels}"/>
					
			        </td>
				</tr>	
				<input type='hidden' name='cutoffdate' id='cutoffdate' value=''>
				<input type='hidden' name='cutoffdate1' id='cutoffdate1' value=''>
<%	}%>
				</table>
				<input type='hidden' name='hidden_sysdate' id='hidden_sysdate' value='<%=Cut_off_date1%>'>
				<input type='hidden' name='service_code' id='service_code' value='<%=srcode%>'>
				<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
				<input type='hidden' name='episode_closure_by' id='episode_closure_by' value='<%=episode_closure_by%>'>
			</form>
		</center>
</body>
</html>
<%
	}catch(Exception e){}
	finally
	{
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();

		if(con!=null) ConnectionManager.returnConnection(con,request);
	}					
%>

