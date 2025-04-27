<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*,com.ehis.util.*" %>
<html>
<head>
<!-- 	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/MergedPatientIds.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
	<%
		Connection          con		= null;
		java.sql.Statement	stmt	= null;
		java.sql.Statement	stmt1	= null;
		ResultSet	        rs		= null;
        ResultSet	        rs1		= null;
		 String locale=(String)session.getAttribute("LOCALE");
		String str			     = "";
		String p_dup_group_id	 = "";
		String p_valid_duplicate = "";
		String p_valid_check     = "";
		String p_dup_check       = "";
		String p_dup_count		 = "";
		String added_by_id		 = "";
		String added_date        = "";
		String added_date_display= "";
	   String pat_series="";
		int i	= 0;
		
		String p_patient_id	= checkForNull(request.getParameter("patient_id"));
		p_dup_count			= checkForNull(request.getParameter("p_pat_count"));
		p_dup_group_id=checkForNull(request.getParameter("p_dup_group_id"));
		
		try
		{
			con     = ConnectionManager.getConnection(request);
			stmt	= con.createStatement();
			stmt1	= con.createStatement();  

			if(p_dup_count.equals("") || p_dup_count.equals("0"))
			{
				%>
					<script>
						var ErrorText = getMessage('NO_RECORD','DR');
						parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;							
					</script>
				<%				
			} else {
				%>
					<script>
						parent.frames[1].document.getElementById('p_patcount').value = <%=p_dup_count%>;				
					</script>	
				<%
			}		
					
			str   = "select merge_trn_id dup_group_id,patient_id,dup_indicator valid_duplicate, SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6) patient_line,added_by_id,to_char(added_date,'dd/mm/yyyy')added_date from dr_merged_patient_vw11 where merge_trn_id='"+p_dup_group_id+"' and nvl(initiating_function_id,0) <> 'MP_CHANGE_PAT_ID' " ;
			
            rs	= stmt.executeQuery(str);
			%>
			<form name='group_details_form' id='group_details_form'>
				<table border='0' width='100%' cellspacing='0' cellpadding='0' >
				<%
				if(rs != null)
				{
					while(rs.next())
					{
						i++;
						p_patient_id		= checkForNull(rs.getString("patient_id"));
						p_valid_duplicate	= checkForNull(rs.getString("valid_duplicate"));
						added_date          = checkForNull(rs.getString("added_date"));
						added_by_id         = checkForNull(rs.getString("added_by_id"));
                        						
						if(p_valid_duplicate.equals("V"))
						{
							p_valid_check = "checked";
							p_dup_check   = "unchecked";
						}
						else if (p_valid_duplicate.equals("D"))
						{
							p_valid_check = "unchecked";
							p_dup_check   = "checked";
						}
						
						added_date_display = DateUtils.convertDate(added_date,"DMY","en",locale);

						String str1 = "SELECT PAT_SER_GRP_CODE FROM dr_mp_patient WHERE ";

						if(p_valid_duplicate.equals("V")) {
							str1 = str1+ "VALID_PATIENT_ID = '"+p_patient_id+"'";
						}
						else if(p_valid_duplicate.equals("D")) {
							str1 = str1+ "DUPLICATE_PATIENT_ID = '"+p_patient_id+"'";
						}

						
						rs1 = stmt1.executeQuery(str1);
						if(rs1!=null && rs1.next()) {								pat_series=rs1.getString("PAT_SER_GRP_CODE")==null?"":rs1.getString("PAT_SER_GRP_CODE");
						}
						
						%>
						<tr>
						<td align='center' width='19%' class='data'><%=pat_series%> </td>
						<td width='8%' class='label' align='center'><a href='javascript:viewPatientDetails("<%=p_patient_id%>","<%=p_valid_duplicate%>")'>+</a></td>
						<td align='center' width='29%' class='label'><font size=1><%=p_patient_id%></font></td>
							<td width='10%' class=label align='center'>
							<%
							if(p_valid_check.equals("checked"))
							{
						    	%>
								<IMG SRC="../../eCommon/images/enabled.gif" BORDER='0' ALT=""></IMG>
								<%
						   	}
							%>
							</td>
							<td width='10%' class=label align='center'>
							<%
							if(p_dup_check.equals("checked"))
							{
								%>
								<IMG SRC="../../eCommon/images/enabled.gif" BORDER='0' ALT=""></IMG>
								<%
							}
							%>
							</td>
							<td align='center' width='22%' valign='top' class='label' nowrap>	<%=added_by_id%></td>
							<td align='center' width='20%' valign='top' class='label' nowrap>
							<%=added_date_display%></td>
						</tr>
						<%
					}
				}
				if(rs != null) rs.close();
				%>
			 	</table>
				<input type='hidden' name='patcount' id='patcount' value='0'>
				<input type='hidden' name='patient_id1' id='patient_id1' value=''>
				<input type='hidden' name='patient_id2' id='patient_id2' value=''>
				<input type='hidden' name='p_dup_group_id' id='p_dup_group_id' value='<%=p_dup_group_id%>'>
				<input type='hidden' name='p_dup_count' id='p_dup_count' value='<%=p_dup_count%>'>
			</form>
		<%
		     if(rs   != null) rs.close();
			if(stmt != null) stmt.close();
		   if(rs1   != null) rs1.close();
			if(stmt1 != null) stmt1.close();
		}
		catch(Exception e)
			{
				out.println("Exception in MergedPatientIDDetails:"+e.toString());
		}
		finally
		{
			
		    ConnectionManager.returnConnection(con,request);
		}
		%>
	</body>
</html>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")))? "" : inputString);
}


%>

