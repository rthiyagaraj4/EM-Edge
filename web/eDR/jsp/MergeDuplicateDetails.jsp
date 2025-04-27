<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*, eDR.*" %>

<html>
<head>
	
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/MergeDuplicates.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	Connection con			= null;

	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
   java.sql.Statement stmt1	= null;
	ResultSet rs1			= null;
	String str					= "";
	String p_dup_group_id		= "";
	String p_valid_duplicate	= "";
	String p_valid_check		= "";
	String p_dup_check			= "";
	String p_not_check			= "";
	String p_patient_line		= "";
	String p_line				= "";
	String p_dup_count			= "";
	String p_order_by			= "";
	String sys_date				= "";
	String sys_time				= "";
	StringBuffer sb				= null;
    String pat_series             ="";
	int i		= 0;
	int j       = 0;
	int flag	= 0;

	String locale = (String)session.getAttribute("LOCALE");
	String p_patient_id	= request.getParameter("patient_id");
	String fromPage		= request.getParameter("fromPage");
	String facility		= request.getParameter("facility1");
	p_dup_count			= request.getParameter("p_pat_count"); 
  
	if(fromPage == null) fromPage = "";
	if(facility == null) facility = "";	
	
	try
	{   
		sb      = new StringBuffer();
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
        stmt1	= con.createStatement(); 
		String sql_sysdate = "SELECT to_char(sysdate,'dd/mm/yyyy'), to_char(sysdate,'hh24:mi') FROM dual";
		rs = stmt.executeQuery(sql_sysdate);
		while(rs.next())
		{
			sys_date	= rs.getString(1);
			sys_time	= rs.getString(2);
		} if(rs != null) rs.close();

	
		if(p_patient_id == null || p_patient_id.equals("null"))
		{
			p_patient_id = "";
		}
        
		str  = "SELECT dup_group_id, pat_count FROM dr_dup_group_vw2 WHERE group_status = 'I' AND marked_for_merge_yn = 'N' AND patient_id = '"+p_patient_id+"' AND added_facility_id = nvl('"+facility+"', added_facility_id) ";
		rs	= stmt.executeQuery(str);
    	if(rs != null)
		{
			if(rs.next())
			{
				p_dup_group_id = rs.getString("dup_group_id");
				p_dup_count    = rs.getString("pat_count") ;
				%>
				<script>
					if(parent.frames[1].document.getElementById('') != null)
					{
						parent.frames[1].document.getElementById('p_patcount').value='<%=p_dup_count%>'; 
					}	
				</script>
				<%			
			}
			
		} if(rs != null) rs.close();
		
		str  = "SELECT decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle FROM dr_process_ctl " ;
		rs	 = stmt.executeQuery(str);
		if(rs.next())
		{
			p_order_by = rs.getString("order_by_for_process_cycle");
			flag = 1;
		} if(rs != null) rs.close();
	
		sb.append("SELECT dup_group_id, patient_id, mp_patient_added_date, dup_indicator valid_duplicate,SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6)  patient_line FROM dr_dup_group_vw2 WHERE dup_group_id = '"+p_dup_group_id+"'");

		if(flag == 1)
		{
			sb.append("order by "+p_order_by+" ");
			flag = 0;
		}
		
		rs	= stmt.executeQuery(sb.toString());
		
		%>
		<form name='group_details_form' id='group_details_form' action='../../servlet/eDR.MergeDuplicateServlet' method='post' target='messageFrame'>
			<table border='0' width='100%' cellspacing='0' cellpadding='0'>
			
    
			<%
			if(rs != null)
			{
				while(rs.next())
				    {
					i++;j++;
					p_patient_id		= rs.getString("patient_id");
					p_valid_duplicate	= rs.getString("valid_duplicate");
					p_patient_line		= rs.getString("patient_line");

					if(p_valid_duplicate.equals("V"))
					{
						p_valid_check = "checked";
						p_dup_check   = "unchecked";
						p_not_check   = "unchecked";
					}
					else if(p_valid_duplicate.equals("D"))
					{
						p_valid_check = "unchecked";
						p_not_check   = "unchecked";
						p_dup_check   = "checked";
					}
					else if(p_valid_duplicate.equals("X"))
					{
						p_valid_check = "unchecked";
						p_dup_check   = "unchecked";
						p_not_check   = "checked";
					}
					
					String str1="SELECT PAT_SER_GRP_CODE FROM mp_patient WHERE patient_id='"+p_patient_id+"'";
					rs1 = stmt1.executeQuery(str1);
					while(rs1.next())
					{	
		         pat_series=rs1.getString("PAT_SER_GRP_CODE")==null?"":rs1.getString("PAT_SER_GRP_CODE");
					}
							if(rs1 != null) rs1.close();

					%>
					<tr>
						<td width='18%' class='data'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=pat_series%> </td>
					
					<td width='3%' class='label' nowrap><a href='javascript:viewPatientDetails("<%=p_patient_id%>")'>+</a></td>
						<td class='data' colspan='1' wrap  width='48%'><font size='1'><%=p_patient_id%></font></td>
						<td width='15%' class='data' align='center'>
						<%
						if(p_valid_check.equals("checked"))
						{
							%>
			      <IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</IMG></td>
							<%
						}
						%>
						<td width='15%'class='data' align='center'>
						<%
						if(p_dup_check.equals("checked"))
						{
							%>
							<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</IMG></td>
							<%
						}
						%>
						<td width='20%' class='data' align='center'>
						<%
						if(p_not_check.equals("checked"))
						{
							%>
							<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</IMG></td>
							<%
						}
						%>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td width='3%' class='label' nowrap></td>
						<td class='data' colspan='5' nowrap><font size='1'><%=p_patient_line%> </font></td>
					</tr>
					<%
				}
				
			} if((j==0) && (!p_patient_id.equals("")))
		       {
				
				%>
				<script>
					    var ErrorText = getMessage('NO_RECORD','DR');
						parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
				</script>
             <% }
				else
		         { %>
					<script>
					   	 
				       var ErrorText =""; 
						parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
				</script>
				 <%}%>
		
			</table>
			<input type='hidden' name='patcount' id='patcount' value='0'>
			<input type='hidden' name='patient_id1' id='patient_id1' value=''>
			<input type='hidden' name='patient_id2' id='patient_id2' value=''>
			<input type='hidden' name='p_dup_group_id' id='p_dup_group_id' value='<%=p_dup_group_id%>'>
			<input type='hidden' name='p_dup_count' id='p_dup_count' value='<%=p_dup_count%>'>
			<input type='hidden' name='p_line' id='p_line' value='<%=p_line%>'>
			<input type='hidden' name='count' id='count' value='<%=i%>'>
			<input type='hidden' name='final_chk_values' id='final_chk_values' value=''>
			<input type='hidden' name='p_final_dup_group_id' id='p_final_dup_group_id' value=''>
			<input type='hidden' name='process_start' id='process_start' value=''>
			<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
			<input type='hidden' name='sys_time' id='sys_time' value='<%=sys_time%>'>
			<input type='hidden' name='modal' id='modal' value='N'> 
			<input type='hidden' name='start_later_time' id='start_later_time' value=''> 
		</form>
		<%
				if(sb!=null || sb.length() >0)
				sb.setLength(0);
		if(rs != null) rs.close();
		if(rs1 != null) rs1.close();
		if(stmt != null) stmt.close();
		if(stmt1 != null) stmt1.close();
	}
	catch(Exception e)
	{
		out.println("Exception in THe File MergeDuplicateDetails"+e.getMessage());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

