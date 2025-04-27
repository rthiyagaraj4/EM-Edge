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
	<script language='javascript' src='../../eDR/js/PossibleDuplicates.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<!-- <script language="javascript" src="../../eDR/js/DRrowcolor.js" ></script> -->
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey();'>
<%
		Connection          con      =    null;
		java.sql.Statement	stmt	 =    null;
		ResultSet	        rs		 =    null;

  try
	 {
        con                          = ConnectionManager.getConnection(request);
		stmt					     = con.createStatement();

		String str				     = "";
		String p_no_of_groups        = "";

		str = "select count(1) as total from dr_dup_group_vw2 where sug_valid_pat_flag='Y' and group_status='U' and system_gen_yn='Y' and marked_for_merge_yn='N' " ;
		rs = stmt.executeQuery(str);
		if(rs!=null)
		{
			while (rs.next())
			{
				p_no_of_groups = rs.getString("total");
			}
		}

		if(rs!=null) rs.close();
%>

<form name='group_header_title' id='group_header_title'>
	<table border=0 width=100% cellspacing=0  id='tb1' >
		<tr>
			<td class=label width='80%'></td>
			<td class=label width='15%'></td>
		</tr>
		<tr>
			<th class='columnheader' colspan=2 style="text-align:left;"><fmt:message key="eDR.DuplicateGroups.label" bundle="${dr_labels}"/> </th>
		</tr>
		<tr>
			<td colspan=2 class='label'><b><fmt:message key="eMP.NoofGroups.label" bundle="${mp_labels}"/> = <%=p_no_of_groups%></td>
		</tr>
		<tr>
			<th class='columnheader' style="text-align:left;"><fmt:message key="eDR.Sug.MainPatientID.label" bundle="${dr_labels}"/></th>
			<th class='columnheader' style="text-align:left;"> <fmt:message key="Common.count.label" bundle="${common_labels}"/></th>
		</tr>
    </table>
</form>
<%
	if(stmt!=null) stmt.close();
 }
	catch(Exception e)
	{
	 out.println("Error From File PossibleDuplicateHeaderTitle.jsp"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>

</body>
</html>

