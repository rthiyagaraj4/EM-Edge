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
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="search_form.patient_id.focus()" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%

	String facilityId   = (String) session.getValue("facility_id");
	String appl_user_id	= (String) session.getValue("login_user");

	Connection con				= null;
	java.sql.Statement	stmt	= null;
	java.sql.Statement	stmt1	= null;
	java.sql.Statement	stmt2	= null;
	ResultSet rs				= null;
	ResultSet rs1				= null;
	ResultSet rs2				= null;

	String str			= "";
	String patient_id	= "";
String locale = (String)session.getAttribute("LOCALE");
	int pat_id_length = 0;

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		stmt1	= con.createStatement();
		stmt2	= con.createStatement();

		patient_id = request.getParameter("patient_id");
		if(patient_id == null) patient_id = "";
		
		str = "SELECT patient_id_length FROM mp_param";
		rs  = stmt.executeQuery(str);
		while(rs.next())
		{
			pat_id_length = rs.getInt("patient_id_length");
		} if(rs != null) rs.close();
				
		%>
		<form name='search_form' id='search_form'>
			<table border='0' width='100%' cellspacing='0' id='query'>
		 		<tr><th class='columnheader' colspan='5'><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></th></tr>
				
				<tr>
					
					<td class='label' colspan='1' width='20%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
					<td class='fields' colspan='1' width='30%'>
					<%
					String name		= "";
					String value	= "";
					String value1	= "";
					String sel		= "";

					String facility_level = "SELECT merge_privilege_level FROM dr_user_rights WHERE appl_user_id LIKE '"+appl_user_id+"%' " ;
					rs1 = stmt1.executeQuery(facility_level);
					if(rs1 != null)
					{
						while(rs1.next())
						{
							value	= rs1.getString("merge_privilege_level");
						}
					} if(rs1 != null) rs1.close();

					if(value.equals("A"))
					{
						%>
						<select name='facility' id='facility' onchange='//clearDetail();rfresh(this)'>
						<%

						String facility_name = "SELECT facility_name, facility_id FROM sm_facility_param_lang_vw where language_id='"+locale+"' ORDER BY 1 "; 	
						rs2 = stmt2.executeQuery(facility_name);	
						if(rs2 != null)
						{
							while(rs2.next())
							{
								name	= rs2.getString("FACILITY_NAME");
								value1	= rs2.getString("FACILITY_ID");

								if(value1.equals(facilityId)) { sel = "Selected"; }
								else { sel = ""; }
								%>
								<option value='<%=value1%>' <%=sel%>><%=name%></option>
								<%
							}
							%></select> <%
					  	} if(rs2 != null) rs2.close();				
					}	
					else
					{
						%>
						<select name='facility' id='facility' disabled onchange='//clearDetail();rfresh(this)'>
						<%
						String facility_name1 = "SELECT facility_name, facility_id FROM sm_facility_param_lang_vw WHERE facility_id = '"+facilityId+"' and language_id='"+locale+"'"; 	
						rs2 = stmt2.executeQuery(facility_name1);
						if(rs2 != null)
						{
							while(rs2.next())
							{
								name	= rs2.getString("FACILITY_NAME");
								value1	= rs2.getString("FACILITY_ID");
								%>
								<option value='<%=value1%>' ><%=name%></option></select>
								<%
							}
						} if(rs2 != null) rs2.close();
					}
					%>
					</td> 
					<td class='label' colspan='1' width='20%' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='fields' style="display:flex">
					<input type='text' size='20' width='25%' maxlength='<%=pat_id_length%>' name='patient_id' value='<%=patient_id%>' onBlur="touppercase(this)"><input type='button' name='patient_search_button' id='patient_search_button' value='?' class='button' onClick="callPatientSearch()">
					</td>
					<td class='button' width='20%'><input type='button' class='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callDuplicatesGroups()">
					</td>
				</tr>
				<tr><td class='label' colspan='5'>&nbsp;</td></tr>
		 	</table>
		</form>
		<%
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(stmt1 != null) stmt1.close();
		if(stmt2 != null) stmt2.close();
	}
	catch(Exception e)
	{
		out.println("Exception in File MergeDuplicateSearch:"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

