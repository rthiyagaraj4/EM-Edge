<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*,eDR.*" %>

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
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<!-- <script language="javascript" src="../../eDR/js/DRrowcolor.js" ></script> -->
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet	rs			= null;
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		String str				="";
		String p_no_of_groups   = "";
		
		str = "SELECT count(1) as total FROM dr_dup_group_vw2 WHERE dup_indicator = 'V' AND group_status = 'E' AND patient_id = nvl(('"+""+"'), patient_id)";
		//str = "SELECT count(1) as total FROM dr_dup_group_vw2 WHERE dup_indicator = 'V' AND group_status = 'E' AND dup_group_id LIKE '%%'";
		rs = stmt.executeQuery(str);
		while(rs.next())
		{
			p_no_of_groups = rs.getString("total");
		}
		%>
		<form name='group_header_title' id='group_header_title'>
			<table border='0' width='100%' cellspacing='0' id='tb1'>
				<tr>
					<td class=label width='80%'></td>
					<td class=label width='15%'></td>
				</tr>
				<tr><th class='columnheader' colspan='2'><fmt:message key="eDR.NotMergedGroups.label" bundle="${dr_labels}"/></th></tr>
				<tr><td colspan='2' class='label'><b><fmt:message key="eMP.NoofGroups.label" bundle="${mp_labels}"/> = <%=p_no_of_groups%></td></tr>
			 </table>
		</form>
		<%
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
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

