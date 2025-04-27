<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eDR/js/DRAdminSearchProcess.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>	
 </head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey();'>
<%
	Connection conn			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	String str = "";

	StringBuffer SelectSqlBuffer = null;

	try
	{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();

		SelectSqlBuffer = new StringBuffer();
		
		SelectSqlBuffer.append("select to_char(search_submit_date,'dd/mm/yyyy hh24:mi:ss') search_submit_date, search_submit_by_id, to_char(search_schedule_date,'dd/mm/yyyy hh24:mi:ss') search_schedule_date, to_char(search_start_date,'dd/mm/yyyy hh24:mi:ss') search_start_date, to_char(search_end_date,'dd/mm/yyyy hh24:mi:ss') search_end_date, search_status, to_char(merge_submit_date,'dd/mm/yyyy hh24:mi:ss') merge_submit_date, merge_submit_by_id, to_char(merge_schedule_date,'dd/mm/yyyy hh24:mi:ss') merge_schedule_date, to_char(merge_start_date,'dd/mm/yyyy hh24:mi:ss') merge_start_date, to_char(merge_end_date,'dd/mm/yyyy hh24:mi:ss') merge_end_date, merge_status, order_by_for_process_cycle, proc_status from dr_process_ctl ");

		rs = stmt.executeQuery(SelectSqlBuffer.toString());

		String p_search_submit_date			= "";
		String p_search_submit_by_id		= "";
		String p_search_schedule_date		= "";
		String p_search_start_date			= "";
		String p_search_end_date			= "";
		String p_search_status				= "";
		String p_merge_submit_date			= "";
		String p_merge_submit_by_id			= "";
		String p_merge_schedule_date		= "";
		String p_merge_start_date			= "";
		String p_merge_end_date				= "";
		String p_merge_status				= "";
		String p_proc_status				= "";
		String p_order_by_for_process_cycle	= "";

		while (rs.next())
		{
			p_search_submit_date	= rs.getString("search_submit_date");
			p_search_submit_date=DateUtils.convertDate(p_search_submit_date,"DMYHMS","en",localeName);
			p_search_submit_by_id	= rs.getString("search_submit_by_id");
			p_search_schedule_date	= rs.getString("search_schedule_date");
			p_search_schedule_date=DateUtils.convertDate(p_search_schedule_date,"DMYHMS","en",localeName);
			p_search_start_date		= rs.getString("search_start_date");
			p_search_start_date=DateUtils.convertDate(p_search_start_date,"DMYHMS","en",localeName);
			p_search_end_date		= rs.getString("search_end_date");
			p_search_end_date=DateUtils.convertDate(p_search_end_date,"DMYHMS","en",localeName);
			p_search_status			= rs.getString("search_status");
			
			if(p_search_status == null) p_search_status = "";
			else
			{
				if(p_search_status.equals("E")) p_search_status ="Error";
			 	else p_search_status = "Success";
	 		}
			
			p_merge_submit_date		= rs.getString("merge_submit_date");
			p_merge_submit_date=DateUtils.convertDate(p_merge_submit_date,"DMYHMS","en",localeName);
			p_merge_submit_by_id	= rs.getString("merge_submit_by_id");
			p_merge_schedule_date	= rs.getString("merge_schedule_date");
			p_merge_schedule_date=DateUtils.convertDate(p_merge_schedule_date,"DMYHMS","en",localeName);
			p_merge_start_date		= rs.getString("merge_start_date");
			p_merge_start_date=DateUtils.convertDate(p_merge_start_date,"DMYHMS","en",localeName);
			p_merge_end_date		= rs.getString("merge_end_date");
			p_merge_end_date=DateUtils.convertDate(p_merge_end_date,"DMYHMS","en",localeName);
			p_merge_status			= rs.getString("merge_status");

			if(p_merge_status == null) p_merge_status = "";
			else
			{
				if(p_merge_status.equals("E")) p_merge_status = "Error";
				else p_merge_status = "Success";
			}	 

			p_proc_status					= rs.getString("proc_status");
			p_order_by_for_process_cycle	= rs.getString("order_by_for_process_cycle");
		} if(rs != null) rs.close();

		if(p_search_submit_date == null) p_search_submit_date = "";
		if(p_search_submit_by_id == null) p_search_submit_by_id = "";
		if(p_search_schedule_date == null) p_search_schedule_date = "";
		if(p_search_start_date == null) p_search_start_date = "";
		if(p_search_end_date == null) p_search_end_date = "";
		if(p_search_status == null) p_search_status = "";
		if(p_merge_submit_date == null) p_merge_submit_date = "";
		if(p_merge_submit_by_id == null) p_merge_submit_by_id = "";
		if(p_merge_schedule_date == null) p_merge_schedule_date = "";
		if(p_merge_start_date == null) p_merge_start_date = "";
		if(p_merge_end_date == null) p_merge_end_date = "";
		if(p_merge_status == null) p_merge_status = "";
		if(p_proc_status == null) p_proc_status = "";
		if(p_search_submit_date.equals("")) p_search_status="";
%>
<form name='DRAdminSearch' id='DRAdminSearch' action='../../servlet/eDR.DRAdminSearchServlet' method='post' target='messageFrame'>
	<div>
	<br><br><br><br><br><br>
	
<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>
		
	<tr>
		<td class='white'></td>	
		<td class='white' align='right'><input type='button' class='BUTTON' value='<fmt:message key="Common.Refresh.label" bundle="${common_labels}"/>' name='refresh' onclick='refresh_page();'>
	</tr>
		
	<tr><td class='white' colspan='2'>&nbsp;</td></tr>
	
</table>
	
<table border='0' cellpadding='3' cellspacing='0' width='80%' align='center'>
		<tr><Th colspan=4  class='columnheader' style="text-align:left"> <fmt:message key="eDR.SearchProcessDetails.label" bundle="${dr_labels}"/></th></tr>
		
		<tr><td colspan='4'></td></tr>
		
		 <tr>
		
		     <td class='label' width='25%'><fmt:message key="eDR.SubmissionDate.label" bundle="${dr_labels}"/></td>
		     <td class='querydata' width='25%' nowrap><%=p_search_submit_date%></td>
		
		     <td class='label' width='25%' nowrap><fmt:message key="Common.SubmittedBy.label" bundle="${common_labels}"/></td>
		     <td class='querydata' width='25%'><%=p_search_submit_by_id%></td>
		
		</tr>
		
		<tr>
		     
			 <td class='label' width='25%'><fmt:message key="Common.ScheduledDate.label" bundle="${common_labels}"/></td>
		     <td class='querydata' width='25%'><%=p_search_schedule_date%></td>
		     <td width='25%'></td><td class='label' width='25%'></td>
		</tr>	
		
		<tr>
			
		    <td class='label' width='25%'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
		    <td class='querydata' width='25%' nowrap><%=p_search_start_date%></td>
		   	<td class='label' width='25%'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
			<td class='querydata' width='25%' nowrap><%=p_search_end_date%></td>
			
		</tr> 
		
		<tr>
			
		    <td class='label' width='25%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			<td class='querydata' width='25%'><%=p_search_status%></td>
			<td class='label' width='25%'></td><td class='label' width='25%'></td>   				     
		 </tr>				
		
		<tr><Th colspan=4  class='columnheader' style="text-align:left"><fmt:message key="eDR.MergeProcessDetails.label" bundle="${dr_labels}"/></th></tr>
		
	
	
		
		<tr>
			
		    <td class='label' width='25%'><fmt:message key="eDR.SubmissionDate.label" bundle="${dr_labels}"/></td>
			<td class='querydata' width='25%' nowrap><b><%=p_merge_submit_date%></b></td>
			
			<td class='label' width='25%'><fmt:message key="Common.SubmittedBy.label" bundle="${common_labels}"/></td>
			<td class='querydata' width='25%'><b><%=p_merge_submit_by_id%></b></td>
			
		</tr>
		
		<tr>
		    
			<td class='label' width='25%'><fmt:message key="Common.ScheduledDate.label" bundle="${common_labels}"/></td>
			<td class='querydata' width='25%'><b><%=p_merge_schedule_date%></b></td>
			<td class='label' width='25%' ></td><td class='label' width='25%'></td>
		</tr>		
		
		<tr>
			
			<td class='label' width='25%'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
			<td class='querydata' width='25%' nowrap><b><%=p_merge_start_date%></b></td>
			
			<td class='label' width='25%'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
			<td class='querydata' width='25%' nowrap><b><%=p_merge_end_date%></b></td>
			
		</tr> 
		
		<tr>
			
			<td class='label' width='25%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			<td class='querydata' width='25%'><%=p_merge_status%></td>
			<td class='label' width='25%'></td>  <td class='label' width='25%'></td>  				     
		</tr>					
		
		
		
		<tr><th class='columnheader' colspan=4 style="text-align:left"> <fmt:message key="Common.action.label" bundle="${common_labels}"/></th></tr>
	
		
		<tr>
			
			<td  class='label' width='25%' nowrap><fmt:message key="eDR.OrderByforCycle.label" bundle="${dr_labels}"/></td>
			<td class='fields'  >
			<select name='order_by_for_process_cycle' id='order_by_for_process_cycle'>
			<%
			str = "select Check_Single_File_For_Patient check_string from dual" ;
			rs = stmt.executeQuery(str);

			String p_check_string	= "";
			String p_checked		= "";
			String r_checked		= "";
			String l_checked		= "";
			String f_checked		= "";

			while(rs.next())
			{
				p_check_string = rs.getString("check_string");
			} if(rs != null) rs.close();

			if(p_order_by_for_process_cycle.equals("P"))
			{
				p_checked = "selected"; 
				r_checked = ""; 
				l_checked = ""; 
				f_checked = ""; 
			}
			else if(p_order_by_for_process_cycle.equals("R"))
			{
				p_checked = ""; 
				r_checked = "selected"; 
				l_checked = ""; 
				f_checked = ""; 
			}
			else if(p_order_by_for_process_cycle.equals("F"))
			{
				p_checked = ""; 
				r_checked = ""; 
				l_checked = ""; 
				f_checked = "selected"; 
			}
			else if(p_order_by_for_process_cycle.equals("L"))
			{
				p_checked = ""; 
				r_checked = ""; 
				l_checked = "selected"; 
				f_checked = ""; 
			}

			%>
			<option value='P' <%=p_checked%>><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
			<option value='R' <%=r_checked%>><fmt:message key="Common.RegnDate.label" bundle="${common_labels}"/>
			<%
			if(p_check_string.equals("T"))
			{
				%>
				<option value='L' <%=l_checked%>><fmt:message key="eDR.FileLocation.label" bundle="${dr_labels}"/></option>
				<option value='F' <%=f_checked%>><fmt:message key="Common.fileno.label" bundle="${common_labels}"/></option>
				<%
			}
			%>
			</select>
		    </td>
		  
		    <td  class='label' width='25%' nowrap><fmt:message key="Common.ActionType.label" bundle="${common_labels}"/></td>
		    <td  align='left' class='fields'><select name='p_proc_status_update' id='p_proc_status_update'>
 				<option value='N'>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				
			
				<%		
					
				if(p_proc_status.equals("S1"))
				{
					if(p_proc_status.equals("M0"))
					{
						%>
						<option value='N' selected><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
						<%
					}
					else
					{
						%>
						<option value='N' selected><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>	
						<option value='AB'><fmt:message key="eDR.AbortProcess.label" bundle="${dr_labels}"/></option>
						<%
					}
				}
				else if(p_proc_status.equals("M1") || p_proc_status.equals("M2")) 
				{
					%>
					<option value='N' selected><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>		
					<option value='CS'><fmt:message key="eDR.CloseProcess.label" bundle="${dr_labels}"/></option>
					<%
				}
				else if(p_proc_status.equals("S0"))
				{
					%>
					<option value='N' selected><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
						<option value='AB'><fmt:message key="eDR.AbortProcess.label" bundle="${dr_labels}"/></option>


					<% 
				}
				else if(p_proc_status.equals("M0"))
				{
					%>
					<option value='N' selected><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
					<%
				}
					else if(p_proc_status.equals("S2"))

					{
						%>
						<option value='N' selected><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>	
						<option value='AB'><fmt:message key="eDR.AbortProcess.label" bundle="${dr_labels}"/></option>
						<%
					}
				%>
				</select>
				</td>
			    
			</tr>
			
			<tr><td colspan='4'>&nbsp;</td></tr>
		
</table>
		</div>
		
		<input type='hidden' name='mode' id='mode' value='modify'>
		<input type='hidden' name='procstatus' id='procstatus' value='<%=p_proc_status%>'>
</form>
	<%
		if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
		{
			SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
		}

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(conn,request);
	}
%>
</body>
</html>

