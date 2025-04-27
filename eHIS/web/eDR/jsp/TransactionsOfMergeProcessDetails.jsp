<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*, eDR.*" %>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/TransactionsOfMergeProcess.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
	String str				 = "";
	String p_dup_group_id	 = "";
	String p_valid_duplicate = "";
	String p_valid_check     = "";
	String p_dup_check       = "";
	String p_not_check       = "";
	String p_patient_line    = "";
	String p_dup_count		 = "";
	String p_order_by		 = "";
  //  String locale=(String)session.getAttribute("LOCALE");
	int i	= 0;
  
	String p_patient_id		= request.getParameter("patient_id");;
	String p_group_status	= request.getParameter("p_group_status");
	p_dup_count				= request.getParameter("p_pat_count");
	if(p_dup_count==null || p_dup_count.equals("null"))
	   p_dup_count="";
	   
	try
	{
		con	= ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		if(p_patient_id == null) p_patient_id = ""; 
		if(p_group_status.equals("X") || p_group_status.equals("E") )
		{ 
			//When Called from TransactionsOfMergeProcessSearch.jsp
			str  = "select dup_group_id,pat_count from dr_dup_group_vw2 where group_status in ('S','E') and patient_id = nvl(('"+p_patient_id+"'),patient_id) ";
			
		}
		else
		{
			//When Called from TransactionsOfMergeProcessHeader1.jsp
			str  = "select dup_group_id,pat_count from dr_dup_group_vw2 where dup_indicator='V' and group_status='S' and patient_id = nvl(('"+p_patient_id+"'),patient_id) ";
			
		}
        
		rs	= stmt.executeQuery(str);
		if(rs != null && rs.next())
		{
			p_dup_group_id = rs.getString("dup_group_id")==null?"":rs.getString("dup_group_id");
			p_dup_count    = rs.getString("pat_count") ==null?"":rs.getString("pat_count");
			%>
			<script>
				parent.frames[1].document.getElementById("p_patcount").value = <%=p_dup_count%> ; 
				parent.parent.frames[1].frames[7].document.getElementById("").disabled = false;
			</script>
			<%			
		}
		else
		{
			%>
			<script>
				var ErrorText = getMessage('NO_RECORDS_FOR_REVIEW','DR');
				parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
			</script>
			<%
		} if(rs != null) rs.close();

		str  = "select decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle from dr_process_ctl " ;
		rs	 = stmt.executeQuery(str);
		if(rs.next())
		{
			p_order_by = rs.getString("order_by_for_process_cycle")==null?"":rs.getString("order_by_for_process_cycle");
		} if(rs != null) rs.close();
	
		str   = "SELECT dup_group_id, patient_id, mp_patient_added_date, dup_indicator valid_duplicate,(CASE WHEN INSTR (Get_dup_Patient_line (patient_id,'en'), '#') > 0  THEN SUBSTR (Get_dup_Patient_line (patient_id,'en'), 1,   INSTR (Get_dup_Patient_line (patient_id,'en'), '#') - 1)  ELSE SUBSTR   (Get_Patient_line (patient_id,'en'), 1,   INSTR (Get_Patient_line (patient_id,'en'), '#') - 1 ) END)  patient_line FROM dr_dup_group_vw2 WHERE dup_group_id = '"+p_dup_group_id+"' ORDER BY "+p_order_by+" ";
		rs	= stmt.executeQuery(str);
		%>
		 <form name='group_details_form' id='group_details_form'>
			<table border=0 width='100%' cellspacing=0 cellpadding=0 >
			<%
			while (rs != null && rs.next())
			{
				i++;
				p_patient_id		= rs.getString("patient_id")==null?"":rs.getString("patient_id");
				p_valid_duplicate	= rs.getString("valid_duplicate")==null?"":rs.getString("valid_duplicate");
				p_patient_line		= rs.getString("patient_line")==null?"":rs.getString("patient_line");

				if(p_valid_duplicate.equals("V"))
				{
					p_valid_check = "checked";
					p_dup_check   = "unchecked";
					p_not_check   = "unchecked";
				}
				else if(p_valid_duplicate.equals("D"))
				{
					p_valid_check = "unchecked";
					p_dup_check   = "checked";
					p_not_check   = "unchecked";
				}
				else if(p_valid_duplicate.equals("X"))
				{
					p_valid_check = "unchecked";
					p_dup_check   = "unchecked";
					p_not_check   = "checked";
				}
				%>
				<tr>
					<td class='label' width='2%' align='center'>&nbsp;</td>
					
					<td width='2%' class='label' align='center'>
					<a href='javascript:viewPatientDetails("<%=p_patient_id%>", "<%=p_valid_duplicate%>","<%=p_group_status%>" )'>+&nbsp;</a></td>
					
					<td width='55%' class='label' align='left' colspan='1'><font size='1'><%=p_patient_id%></font></td>
					
					<td width='10%'  align='center' >
					
					<% if(p_valid_check.equals("checked")) { %>
						<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT="" align="center"></IMG>
					<% } %>
					&nbsp;
					</td>
					<td width='10%'  align='center'>
					
					<% if(p_dup_check.equals("checked")) { %>
						<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT="" align="center"></IMG>
					<% } %>
					&nbsp;
					</td>
					<td width='20%' class='label' align='center'>
					
					<% if(p_not_check.equals("checked")) { %>
						<IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT="" align="center"></IMG>
					<% } %>
					&nbsp;
					</td>
					
				</tr>
				<tr>
						<td class='label'>&nbsp;</td>
						<td class='label' colspan='5'><font size='1'><%=p_patient_line%> </font></td>
				</tr>
				<%
				} if(rs != null) rs.close();
				%>
		 	</table>

			<input type='hidden' name='patcount' id='patcount' value='0'>
			<input type='hidden' name='patient_id1' id='patient_id1' value=''>
			<input type='hidden' name='patient_id2' id='patient_id2' value=''>
			<input type='hidden' name='p_dup_group_id' id='p_dup_group_id' value='<%=p_dup_group_id%>'>
			<input type='hidden' name='p_dup_count' id='p_dup_count' value='<%=p_dup_count%>'>
		</form>
		<%
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
	</body>
</html>

