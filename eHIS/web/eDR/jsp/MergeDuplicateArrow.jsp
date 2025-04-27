<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*, eDR.*" %>

<html>
<head>

	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/MergeDuplicates.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>	
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
	String p_patient_id		= "";
	String sql				= "";

	StringBuffer strsql1	= null;
	strsql1					= new StringBuffer();

	String whereClause	= request.getParameter("whereclause");
	String from			= request.getParameter("from");
	String to			= request.getParameter("to");

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		

		if((whereClause == null || whereClause.equals("")))
		{
			sql	= "";

			p_patient_id	= request.getParameter("patient_id");
			if(p_patient_id == null) p_patient_id = "";

			sql = "WHERE dup_indicator = 'V' AND group_status = 'I' AND marked_for_merge_yn = 'N'";
		}
		else
		{
			sql = whereClause;
		}
		
		int maxRecord	= 0;
		
		int start		= 0;
		int end			= 0;

		if(from == null) start = 1 ;
		else start = Integer.parseInt(from);

		if(to == null) end = 9;
		else end = Integer.parseInt(to);
		
		strsql1.append("SELECT count(1) as total FROM dr_dup_group_vw2 ");
		strsql1.append(sql);		
		rs = stmt.executeQuery(strsql1.toString());
		rs.next();
		{
			maxRecord = rs.getInt("total");
		} if(rs != null) rs.close();

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
						out.println("<A HREF='../../eDR/jsp/MergeDuplicateArrow.jsp?from="+(start-9)+"&to="+(end-9)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><IMG ALIGN='CENTER' SRC='../images/uparrow.gif' WIDTH='18' HEIGHT='18' BORDER=0 ALT='' onClick=javascript:callDupFunction("+(start-9)+","+(end-9)+",'"+whereClause+"')></IMG></A>");

						out.println("<BR>");
						printprevious = true;
					}
					if(printprevious)
					{
						for (int x=0; x<21; x++)
						out.println("<BR>");
					}
					else
					{
						for(int x=0; x<23; x++)
						out.println("<BR>");
					}
					
					if(!((start+9) > maxRecord))
					{
						whereClause = URLEncoder.encode(sql);
						out.println("<A HREF='../../eDR/jsp/MergeDuplicateArrow.jsp?from="+(start+9)+"&to="+(end+9)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><IMG ALIGN='CENTER' SRC='../images/downarrow.gif' WIDTH='18' HEIGHT='18' BORDER=0 ALT='' onClick=javascript:callDupFunction("+(start+9)+","+(end+9)+",'"+whereClause+"')></IMG></A>");
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

			if((strsql1 != null) && (strsql1.length() > 0))
			{
				strsql1.delete(0,strsql1.length());
			}

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

