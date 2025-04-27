<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>	
	<script language='javascript' src='../../eDR/js/DRUserRights.js'></script>
	<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad="callDummy()">
<%
	Connection conn			= null;
	java.sql.Statement stmt	= null;
	ResultSet rset			= null;
	ResultSet rs			= null;
	
	
	String search_priv_level		= "";
	String identify_priv_level		= "";
	String merge_priv_level			= "";
	String administer_priv_level	= "";
	String search_priv_level1		= "";
	String identify_priv_level1		= "";
	String merge_priv_level1		= "";
	String administer_priv_level1	= "";
	String emp_num					= "";
	String a_p_checked				= "";
	String l_p_checked				= "";
	String str						= "";
	String p_appl_user_id			= "";
	String eff_status				= "E";
	String eff_status_checked		= "checked";
	String fnval					= "insert";
	String n_p_checked				= "selected";
	String p_appl_user_name = "";

	String p_user_id = request.getParameter("p_appl_user_id");
	String operation = request.getParameter("operation");

	
	if(p_user_id == null) p_user_id = "";
	
	try
	{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();

		if(operation.equals("modify"))
		{
			str = "select search_privilege_level,identify_privilege_level,merge_privilege_level,unmerge_privilege_level,administer_privilege_level,eff_status,decode(search_privilege_level,'N','None','A','All Facilities','L','Logged in Facility') search_privilege_level1, decode(identify_privilege_level,'N','None','A','All Facilities','L','Logged in Facility') identify_privilege_level1, decode(merge_privilege_level,'N','None','A','All Facilities','L','Logged in Facility') merge_privilege_level1, decode(unmerge_privilege_level,'N','None','A','All Facilities','L','Logged in Facility') unmerge_privilege_level1, decode(administer_privilege_level,'N','None','A','All Facilities','L','Logged in Facility') administer_privilege_level1 from dr_user_rights where appl_user_id = '"+p_user_id+"'";
			rs = stmt.executeQuery(str);
			while(rs.next())
			{
				search_priv_level		= rs.getString("search_privilege_level");	
				identify_priv_level		= rs.getString("identify_privilege_level");	
				merge_priv_level		= rs.getString("merge_privilege_level");	
				administer_priv_level	= rs.getString("administer_privilege_level");	
				eff_status				= rs.getString("eff_status");
				search_priv_level1		= rs.getString("search_privilege_level1");	
				identify_priv_level1	= rs.getString("identify_privilege_level1");	
				merge_priv_level1		= rs.getString("merge_privilege_level1");	
				administer_priv_level1	= rs.getString("administer_privilege_level1");	
		}
		if(eff_status.equals("E"))
		{
			eff_status_checked = "checked";
		}
		else if(eff_status.equals("D"))
		{
			eff_status_checked = "unchecked";
		}
	}
	%>
	<form name='DRUserRights' id='DRUserRights' action='../../servlet/eDR.DRUserRightsServlet' method='post' target='messageFrame'>
		<div>
		<br><br><br><br>
		
<table border='0' cellpadding='4' cellspacing='0' width='100%' align='center'>			
			
    	<%
		if(operation.equals("modify"))
		{
			str = "select appl_user_id,appl_user_name,EMPLOYEE_NO from sm_appl_user where appl_user_id='"+p_user_id+"' ";
			rset = stmt.executeQuery(str);
			while(rset.next())
			{
				p_appl_user_id		= rset.getString("appl_user_id");
				p_appl_user_name	= rset.getString("appl_user_name");
				emp_num				= rset.getString("EMPLOYEE_NO");
				if(emp_num==null) emp_num = "";
			}
			%>
			<tr>    
 				<td	class='label' width='30%'><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
				<td class='fields' width='35%'><input type='text' name='userID' id='userID' size='30' maxlength='30' value='<%=p_appl_user_name%>' readonly><input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_appl_user_id%>'><input type='button' class='button'  value='?' onClick='displayUser(this,userID,p_user_name)' disabled></td>			   
				<td class='label' width='20%' nowrap><fmt:message key="Common.EmployeeNo.label" bundle="${common_labels}"/></td>	
				<td class='fields' width='15%'><input type='text' name='EMPNO' id='EMPNO'  value='<%=emp_num%>' size='7' maxlength='6' onblur='getUserId(this)' readonly></td>
			</tr>
					<%
				}
				else if (operation.equals("insert"))
				{
					%>
			<tr>    
				<td class='label' width='30%'><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
				<td class='fields' width='35%'><input type='text' name='userID' id='userID' size='30' maxlength='30' value='' onblur='if(this.value !="") displayUser(this,userID,p_user_name)'><input type='hidden' name='p_user_name' id='p_user_name' value=''><input type='button' class='button'  value='?' onClick='displayUser(this,userID,p_user_name)'></td>
				<td class='label' nowrap width='20%'><fmt:message key="Common.EmployeeNo.label" bundle="${common_labels}"/></td>
				<td class='fields' width='15%'><input type='text' name='EMPNO' id='EMPNO'  size='7' maxlength='6' onblur='getUserId(this)'>
				</td>
			</tr>
			<%
		}
		%>		
		<tr>
			<td class='label' width='30%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		<td class='fields' width='35%'><input type='checkbox' name='p_enabled' id='p_enabled' value='<%=eff_status%>' <%=eff_status_checked%> onClick='changeVal()'></td>
			<td class='label' colspan='2'>&nbsp;</td>
		</tr>		
</table>
	
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
	
	<tr><th class='columnheader' style='text-align:left;'><fmt:message key="eDR.RightsforDRProcesses.label" bundle="${dr_labels}"/></th></tr>
</table>
<table border='0' cellpadding='4' cellspacing='0' width='100%' align='center'>	
	<tr>
		<td class='label' width='30%'><fmt:message key="Common.search.label" bundle="${common_labels}"/></td>
		<td class='fields' width='35%'>
			<%
			if(eff_status.equals("D"))
			{
			%>	
			<input type=text name='p_search_name' id='p_search_name' value='<%=search_priv_level1%>' readonly>
			<input type=hidden name='p_search' id='p_search' value='<%=search_priv_level%>' >
			<%
		}
		else
		{
			%>
			<select name='p_search' id='p_search'>
			<%
				if(search_priv_level.equals("N"))
				{
					n_p_checked = "selected";
					a_p_checked = "";
					l_p_checked = "";
				}
				else if(search_priv_level.equals("L"))
				{
					n_p_checked = "";
					a_p_checked = "";
					l_p_checked = "selected";
				}
				else if(search_priv_level.equals("A"))
				{
					n_p_checked = "";
					a_p_checked = "selected";
					l_p_checked = "";
				}
				%>
				<option value='N' <%=n_p_checked%>><fmt:message key="Common.none.label" bundle="${common_labels}"/>
				<option value='L' <%=l_p_checked%>><fmt:message key="Common.LoggedinFacility.label" bundle="${common_labels}"/>
				<option value='A' <%=a_p_checked%>><fmt:message key="Common.AllFacilities.label" bundle="${common_labels}"/>
			</select>
			<%
		}
		%>
		</td>
		<td colspan='2'>&nbsp;</td>
    </tr>	
	<tr>
		<td class='label'><fmt:message key="eDR.IdentifyMainDuplicates.label" bundle="${dr_labels}"/></td>
		<td class='fields'>
			<%
			if(eff_status.equals("D"))
			{
				%>	
				<input type=text name='p_identify_name' id='p_identify_name' value='<%=identify_priv_level1%>' readonly>
				<input type=hidden name='p_identify_valid_dup' id='p_identify_valid_dup' value='<%=identify_priv_level%>' >
				<%
			}
			else
			{
				%>
				<select name='p_identify_valid_dup' id='p_identify_valid_dup'>
				<%
					if(identify_priv_level.equals("N"))
					{
						n_p_checked = "selected";
						a_p_checked = "";
						l_p_checked = "";
					}
					else if(identify_priv_level.equals("L"))
					{
						n_p_checked = "";
						a_p_checked = "";
						l_p_checked = "selected";
					}
					else if(identify_priv_level.equals("A"))
					{
						n_p_checked = "";
						a_p_checked = "selected";
						l_p_checked = "";
					}
					%>
					<option value='N' <%=n_p_checked%>><fmt:message key="Common.none.label" bundle="${common_labels}"/>
					<option value='L' <%=l_p_checked%>><fmt:message key="Common.LoggedinFacility.label" bundle="${common_labels}"/>
					<option value='A' <%=a_p_checked%>><fmt:message key="Common.AllFacilities.label" bundle="${common_labels}"/>
					</select>
					<%
				}
				%>
				</td>
				<td colspan='2'>&nbsp;</td>
			</tr>			
			<tr>
			     <td class='label'><fmt:message key="eDR.Merge.label" bundle="${dr_labels}"/></td>
				 <td class='fields'>
				 <%
					 if(eff_status.equals("D"))
					{
						%>
						<input type=text name='p_merge_name' id='p_merge_name' value='<%=merge_priv_level1%>' readonly>
						<input type=hidden name='p_merge' id='p_merge' value='<%=merge_priv_level%>' >
						<%
					}
					else
					{
						%>
						<select name='p_merge' id='p_merge'>
						<%
						if(merge_priv_level.equals("N"))
						{
							n_p_checked = "selected";
							a_p_checked = "";
							l_p_checked = "";
						}
						else if(merge_priv_level.equals("L"))
						{
							n_p_checked = "";
							a_p_checked = "";
							l_p_checked = "selected";
						}
						else if(merge_priv_level.equals("A"))
						{
							n_p_checked = "";
							a_p_checked = "selected";
							l_p_checked = "";
						}
						%>
						<option value='N' <%=n_p_checked%>><fmt:message key="Common.none.label" bundle="${common_labels}"/>
						<option value='L' <%=l_p_checked%>><fmt:message key="Common.LoggedinFacility.label" bundle="${common_labels}"/>
						<option value='A' <%=a_p_checked%>><fmt:message key="Common.AllFacilities.label" bundle="${common_labels}"/>
					</select>
					<%
				}
				%>
				</td>
				<td colspan='2'>&nbsp;</td><input type=hidden name='p_unmerge' id='p_unmerge' value='N' colspan='4'>   
    		</tr>			
			<tr>
				<td class='label'><fmt:message key="eDR.AdministerSearchProcess.label" bundle="${dr_labels}"/></td>
				<td class='fields'>
				<%
				if(eff_status.equals("D"))
				{
					%>	
					<input type=text name='p_admin_name' id='p_admin_name' value='<%=administer_priv_level1%>' readonly>
					<input type=hidden name='p_admin' id='p_admin' value='<%=administer_priv_level%>' >
					<%
				}
				else
				{
					%>
					<select name='p_admin' id='p_admin'>
					<%
						if(administer_priv_level.equals("N"))
						{
							n_p_checked = "selected";
							a_p_checked = "";
							l_p_checked = "";
						}
						else if(administer_priv_level.equals("L"))
						{
							n_p_checked = "";
							a_p_checked = "";
							l_p_checked = "selected";
						}
						else if(administer_priv_level.equals("A"))
						{
							n_p_checked = "";
							a_p_checked = "selected";
							l_p_checked = "";
						}
						%>
						<option value='N' <%=n_p_checked%>><fmt:message key="Common.none.label" bundle="${common_labels}"/>
						<option value='L' <%=l_p_checked%>><fmt:message key="Common.LoggedinFacility.label" bundle="${common_labels}"/>
						<option value='A' <%=a_p_checked%>><fmt:message key="Common.AllFacilities.label" bundle="${common_labels}"/>
					</select>
					<%
				}
				%>
				</td>
				<td colspan='2'>&nbsp;</td>
    		</tr>    		
		</table>
		</div>
		<input type='hidden' name='function' id='function' value='<%=fnval%>'>
		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
		<input type='hidden' name='mode' id='mode' value='<%=operation%>'>
	</form>
<%
	if(rs != null) rs.close();
	if(rset != null) rset.close();
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

