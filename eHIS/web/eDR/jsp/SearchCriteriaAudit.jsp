<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
<title><fmt:message key="eDR.ProcessAuditData.label" bundle="${dr_labels}"/></title>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/SearchCriteriaMain.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String proc_id				= "";		
	String search_submit_date	= "";	
	String search_submit_by_id 	= "";
	String search_schedule_date = "";	
	String search_start_date 	= "";
	String search_end_date		= "";
	String search_status		= "";	
	String merge_submit_date 	= "";
	String merge_submit_by_id 	= "";
	String merge_schedule_date 	= "";
	String merge_start_date 	= "";	
	String merge_end_date		= "";
	String merge_status			= "";
	String facility_name		= "";
String locale=(String)session.getAttribute("LOCALE");
	boolean allow_enter			= false;
	boolean record_avail		= false;

	String facility_id = (String) session.getValue("facility_id");

	Connection con				= null;
	java.sql.Statement stmt		= null;
	ResultSet rs				= null;
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		String str	= "";

		str = "SELECT count(*) FROM dr_process_ctl";
		rs  = stmt.executeQuery(str);
		if(rs != null)
		{
			 while(rs.next())
			{
				 allow_enter = true;
			}
		} if(rs != null) rs.close();

		if(allow_enter)
		{
			str = "";
			str = "SELECT proc_id,to_char(search_submit_date,'dd/mm/yyyy hh24:mi')search_submit_date1,search_submit_by_id,to_char(search_schedule_date,'dd/mm/yyyy hh24:mi')search_schedule_date1,to_char(search_start_date,'dd/mm/yyyy hh24:mi')search_start_date1,to_char(search_end_date,'dd/mm/yyyy hh24:mi')search_end_date1,search_status,to_char(merge_submit_date,'dd/mm/yyyy hh24:mi')merge_submit_date1,merge_submit_by_id,to_char(merge_schedule_date,'dd/mm/yyyy hh24:mi')merge_schedule_date1,to_char(merge_start_date,'dd/mm/yyyy hh24:mi')merge_start_date1,to_char(merge_end_date,'dd/mm/yyyy hh24:mi')merge_end_date1,merge_status,initiating_function_id,proc_status FROM dr_process_ctl";

			rs	= stmt.executeQuery(str);
			if(rs!= null)
			{
				if(rs.next())
				{
					proc_id					= rs.getString("proc_id");
					search_submit_date	= rs.getString("search_submit_date1");
					search_submit_date=DateUtils.convertDate(search_submit_date,"DMYHM","en",locale);
					search_submit_by_id 	= rs.getString("search_submit_by_id");
					search_schedule_date	= rs.getString("search_schedule_date1");
					search_schedule_date=DateUtils.convertDate(search_schedule_date,"DMYHM","en",locale);
					search_start_date 		= rs.getString("search_start_date1");
					search_start_date=DateUtils.convertDate(search_start_date,"DMYHM","en",locale);
					search_end_date			= rs.getString("search_end_date1");
                    search_end_date=DateUtils.convertDate(search_end_date,"DMYHM","en",locale);
					search_status			= rs.getString("search_status");
					
					if(search_status == null) search_status = "";
					else
					{
						if(search_status.equals("E")) search_status = "Error";
						else search_status = "Success";
					}
					
				   merge_submit_date 	= rs.getString("merge_submit_date1");
				   merge_submit_date=DateUtils.convertDate(merge_submit_date,"DMYHM","en",locale);
				   merge_submit_by_id 	= rs.getString("merge_submit_by_id");
				   merge_schedule_date	= rs.getString("merge_schedule_date1");
				    merge_schedule_date=DateUtils.convertDate(merge_schedule_date,"DMYHM","en",locale);
					merge_start_date 	= rs.getString("merge_start_date1");
					merge_start_date=DateUtils.convertDate(merge_start_date,"DMYHM","en",locale);
					merge_end_date		= rs.getString("merge_end_date1");
					merge_end_date=DateUtils.convertDate(merge_end_date,"DMYHM","en",locale);
					merge_status		= rs.getString("merge_status");
					
					if(merge_status == null) merge_status = "";
					else 
					{
						if(merge_status.equals("E"))merge_status = "Error";
						else merge_status = "Success";
					}
			 
					record_avail = true;
				} 
			} if(rs != null) rs.close();

			if(proc_id == null) proc_id = "";
			if(search_submit_date == null) search_submit_date = "";
			if(search_submit_by_id == null) search_submit_by_id = "";
			if(search_schedule_date == null) search_schedule_date = "";
			if(search_start_date == null) search_start_date = "";
			if(search_end_date == null) search_end_date = "";
			if(search_status == null) search_status = "";
			if(merge_submit_date == null) merge_submit_date = "";
			if(merge_submit_by_id == null) merge_submit_by_id = "";
			if(merge_schedule_date == null) merge_schedule_date = "";
			if(merge_start_date == null) merge_start_date = "";
			if(merge_end_date == null) merge_end_date = "";

			String str_fac_name = "SELECT facility_name FROM sm_facility_param_lang_vw WHERE facility_id = '"+facility_id+"' and language_id='"+locale+"'"; 
			rs	= stmt.executeQuery(str_fac_name);
			
			if(rs != null && rs.next())
			{
				facility_name = rs.getString("facility_name");
			} if(rs != null) rs.close();
			
			if(record_avail == false)
			{
				%>
				<script>
					errors = getMessage("NO_RECORDS_FOR_REVIEW","DR") ;
					alert(errors);
					window.close();
				</script>
				<%
			}
			%>
			<BR><BR>
		
  <table border=' 0' cellpadding='0' cellspacing='0' width='95%' align='center'>		
		<tr>
		<th class='columnheader'><fmt:message key="eDR.ProcessAuditData.label" bundle="${dr_labels}"/></th>
		</tr>    
		<tr><td colspan=4>&nbsp;</td></tr>
</table>
	

<table border='0' cellpadding='3' cellspacing='0' width='95%' align='center'>				
			<tr>
					<td width='20%' class='label' ><fmt:message key="eDR.LastDuplicateCheckDate.label" bundle="${dr_labels}"/></td>
					<td width='25%' class='querydata' ><%=search_submit_date%></td>
					<td width='25%'class='label'   ><fmt:message key="Common.ByFacility.label" bundle="${common_labels}"/></td>
					<td width='35%' class='querydata' ><%=facility_name%></td>					
			</tr>
</table>
		
<table border='0' cellpadding='0' cellspacing='0' width='95%' align='center'>
			<tr><td colspan=4>&nbsp;</td></tr>
			<tr><th class='columnheader'><fmt:message key="eDR.SearchProcessDetails.label" bundle="${dr_labels}"/></th></tr>
			<tr><td colspan=4>&nbsp;</td></tr>
				
</table>			
<table border='0' cellpadding='3' cellspacing='0' width='95%' align='center'>		
			<tr>
				<td  width='20%' class='label'  ><fmt:message key="eDR.SubmissionDate.label" bundle="${dr_labels}"/></td>
				<td  width='25%' class='querydata'><%=search_submit_date%></td>
				<td  width='25%' class='label'   ><fmt:message key="Common.SubmittedBy.label" bundle="${common_labels}"/></td>
				<td  width='30%' class='QUERYDATA'><%=search_submit_by_id%></td>				
			</tr>				
			
			<tr>
				<td class='label'  ><fmt:message key="Common.ScheduledDate.label" bundle="${common_labels}"/></td>
				<td class='querydata'><%=search_schedule_date%></td>
				<td class='label' colspan='2'></td>
			</tr>			
			<tr>
				<td class='label' ><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
				<td class='querydata'><%=search_start_date%></td>
				<td class='label' width='25%' ><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
				<td class='querydata'><%=search_end_date%></td>				
			</tr>				
			<tr>
				<td class='label' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td class='querydata'><%=search_status%></td>
				<td class='label' colspan='2'></td>				
			</tr>	
</table>
		
<table border='0' cellpadding='0' cellspacing='0' width='95%' align='center'>
			<tr><td colspan=4>&nbsp;</td></tr>			
			<tr><th class='columnheader'><fmt:message key="eDR.MergeProcessDetails.label" bundle="${dr_labels}"/></th></tr>
			<tr> <td colspan=4>&nbsp;</td></tr>
</table>			
<table border='0' cellpadding='3' cellspacing='0' width='95%' align='center'>	<tr> <td colspan=4></td></tr>	
			<tr>
				<td  width='20%' class='label'   ><fmt:message key="eDR.SubmissionDate.label" bundle="${dr_labels}"/></td>
				<td  width='25%' class='querydata'><%=merge_submit_date%></td>
				<td  width='25%' class='label'   ><fmt:message key="Common.SubmittedBy.label" bundle="${common_labels}"/></td>
				<td  width='35%' class='querydata'><B><%=merge_submit_by_id%></B></td>				
			</tr>		
			
			<tr>
				<td class='label'   ><fmt:message key="Common.ScheduledDate.label" bundle="${common_labels}"/></td>
				<td class='querydata'><%=merge_schedule_date%></td>
				<td class='label' colspan='2'></td>
			</tr>				
			<tr>
				<td  class='label' ><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
				<td  class='querydata'><%=merge_start_date %></td>
				<td  class='label'  ><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
				<td  class='querydata'><%=merge_end_date%></td>					
			</tr>				
			
			<tr>
				<td class='label'   ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td class='querydata'><%=merge_status%></td>
				<td class='label' colspan='2'></td>
			</tr>				
			<tr>
			<td colspan='3' width='75%'>&nbsp;</td>
			<td class='fields' width='25%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button'  class='BUTTON' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' name='close' onclick='parent.document.getElementById("dialog_tag").close();'></td>
			<tr><td colspan=4>&nbsp;</td></tr>
			 </tr>
		
</table>	

		<%
		}
		else
		{
			%>
			<SCRIPT>
				//alert("APP-DR0027 No Access to this function");
				alert(getMessage('NO_USER_RIGHTS','DR'));
			</SCRIPT>
			<%
		}

		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

