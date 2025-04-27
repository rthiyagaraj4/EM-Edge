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
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<!-- <script language="javascript" src="../../eDR/js/DRrowcolor.js"></script> -->
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
	String whereClause	= request.getParameter("whereclause");
	String from			= request.getParameter("from");
	String to			= request.getParameter("to");

	String p_patient_id	= "";
	String sql			= "";
	String strsql1		= "";

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		if((whereClause == null || whereClause.equals("")))
		{
			sql	= "";

			p_patient_id	= request.getParameter("patient_id");
			if(p_patient_id == null) p_patient_id = "";

		//	sql	= "WHERE dup_indicator = 'V' AND group_status = 'S' AND marked_for_merge_yn = 'Y' AND patient_id = nvl(('"+p_patient_id+"'), patient_id) ";
		sql	= "WHERE dup_indicator = 'V' AND group_status = 'S' AND   patient_id = nvl(('"+p_patient_id+"'), patient_id) ";
		}
		else
		{
			sql = whereClause;
		}

		
		int start		= 0;
		int end			= 0;
		int maxRecord	= 0;
	
		if(from == null) start = 1;
		else start = Integer.parseInt(from);
		
		if(to == null) end = 5;
		else end = Integer.parseInt(to);
			
		strsql1="SELECT count(1) AS total FROM dr_dup_group_vw2 "+  sql + " AND dup_group_id LIKE '%%'";
		rs = stmt.executeQuery(strsql1);
		rs.next();
		maxRecord = rs.getInt("total");
		if(rs!=null) rs.close();

		boolean printprevious = false;
		%>
		<form name='group_header_image' id='group_header_image'>
			<table border='0' cellpadding='0' cellspacing='0' height='100%' width='100%' align='center'>
				<tr>
					<td>
					<%
					if(!(start <= 1))
					{
						whereClause = URLEncoder.encode(sql);
						out.println("<A HREF='../../eDR/jsp/TransactionsOfMergeProcessArrow1.jsp?from="+(start-5)+"&to="+(end-5)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><IMG ALIGN='CENTER' SRC='../../eDR/images/uparrow.gif' WIDTH='18' HEIGHT='18' BORDER=0 ALT='' onClick=javascript:callDupFunction1("+(start-5)+","+(end-5)+",'"+whereClause+"')></IMG></A>");
						out.println("<BR>");
						printprevious = true;
					}
					if(printprevious)
					{
						for(int x=0; x<7; x++)
						out.println("<BR>");
					}
					else
					{
						for(int x=0; x<10; x++)
						out.println("<BR>");
					}
					if(!( (start+5) > maxRecord))
					{
						whereClause = URLEncoder.encode(sql);
						out.println("<A HREF='../../eDR/jsp/TransactionsOfMergeProcessArrow1.jsp?from="+(start+5)+"&to="+(end+5)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><IMG ALIGN='CENTER' SRC='../../eDR/images/downarrow.gif' WIDTH='18' HEIGHT='18' BORDER=0 ALT='' onClick=javascript:callDupFunction1("+(start+5)+","+(end+5)+",'"+whereClause+"')></IMG></A>");
					}
					else
					{
						out.println("<BR><BR>");
					}
					%>
					</td>
				</table>
				<br><br>
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
			ConnectionManager.returnConnection(con, request);
		}
%>
</body>
</html>

