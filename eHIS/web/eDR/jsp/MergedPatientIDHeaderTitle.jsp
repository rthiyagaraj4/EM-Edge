<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/MergedPatientIds.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<!-- <script language="javascript" src="../../eDR/js/DRrowcolor.js" ></script> -->
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%

	Connection          con         = null;
	java.sql.Statement	stmt		= null;
	ResultSet	        rs			= null;

	String str				        = "";
	String p_no_of_groups           = "";
try
	{
		String p_to_replace_date = request.getParameter( "p_to_replace_date" ) ;
	String p_fm_replace_date = request.getParameter( "p_fm_replace_date" ) ;
	if (p_to_replace_date==null || p_to_replace_date.equals("null") || p_to_replace_date.equals("")) 
				p_to_replace_date="31/12/5000";
	if (p_fm_replace_date==null || p_fm_replace_date.equals("null") || p_fm_replace_date.equals("")) 
				p_fm_replace_date="01/01/1700";
    con                             = ConnectionManager.getConnection(request);
	stmt					        = con.createStatement();
	
	str = "select count(*) total from dr_merged_patient_vw10 where nvl(initiating_function_id,0) <> 'MP_CHANGE_PAT_ID' and trunc(added_date) between  to_date('"+p_fm_replace_date+"','dd/mm/yyyy') and to_date('"+p_to_replace_date+"','dd/mm/rrrr') ";
	rs = stmt.executeQuery(str);
	if(rs!=null)
		{
			while (rs.next())
			{
				p_no_of_groups = rs.getString("total");
			}
	    } if(p_no_of_groups==null || p_no_of_groups.equals("null"))p_no_of_groups="";
		  if(rs!=null) rs.close();
%>
<form name='group_header_title' id='group_header_title'>
	<table border=0 width='100%' cellspacing=0  id='tb1' >
		<tr>
			<td class=label width='80%'></td>
			<td class=label width='15%'></td>
		</tr>
		<tr>
			<th class='columnheader' colspan=2> <fmt:message key="eDR.DuplicateGroups.label" bundle="${dr_labels}"/> </th>
		</tr>
		<tr>
			<td colspan=2 class='label'><b><fmt:message key="eMP.NoofGroups.label" bundle="${mp_labels}"/> = <%=p_no_of_groups%></td>
		</tr>
		<tr>
			<th class='columnheader'><fmt:message key="eDR.MainPatientID.label" bundle="${dr_labels}"/></th>
			<th class='columnheader'><fmt:message key="Common.count.label" bundle="${common_labels}"/></th>
		</tr>
 
 </table>

 </form>
<%
	if(rs!=null) rs.close();
    if (stmt!=null) stmt.close();
  }
	catch(Exception e)
	{
	   out.println("Exception from the File MergedPatientIDHeaderTitle.jsp"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>

</body>
</html>

