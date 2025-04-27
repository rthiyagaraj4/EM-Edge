<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/ReviewMergeProcessErrors.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	String p_patient_id		= "";
	String class_value		= "";
	String sql				= "";
	String strsql1			= "";

	String whereClause	= request.getParameter("whereclause");
	String from			= request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" ) ;
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		if((whereClause == null || whereClause.equals("")))
		{
			sql						= "";
			p_patient_id			= request.getParameter("patient_id");

			if(p_patient_id == null) p_patient_id = "";

			sql = "WHERE dup_indicator = 'V' AND group_status = 'E' ";
		}
         else
		{
			sql = whereClause;
		}
		
		int start	= 0 ;
		int end		= 0 ;
	
		if(from == null) start = 1 ;
		else start = Integer.parseInt( from ) ;

		if(to == null) end = 9 ;
		else end = Integer.parseInt( to ) ;
		
		int maxRecord = 0;
		strsql1 = "SELECT count(1) AS total FROM dr_dup_group_vw2 "+sql;
		rs = stmt.executeQuery(strsql1);
		rs.next();
		maxRecord = rs.getInt("total");
		if(rs != null) rs.close();

		boolean printprevious = false;
		
		if(maxRecord<23)
		{
			class_value="white";
		}
		else
		{
			class_value = "label";
		}
		%>

		<form name='group_header_image' id='group_header_image'>
			<table border='0' cellpadding='0' cellspacing='0' height='100%' width='100%' align='center'>
				<tr>
					<td>
					<%
						if(!(start <= 1))
						{
							//whereClause =URLEncoder.encode(sql);
							//whereClause =sql;
							out.println("<A HREF='../../eDR/jsp/ReviewMergeProcessErrorsArrow.jsp?from="+(start-9)+"&to="+(end-9)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><IMG ALIGN='CENTER' SRC='../../eDR/images/uparrow.gif' WIDTH='18' HEIGHT='18' BORDER=0 ALT='' onClick=javascript:callDupFunction("+(start-9)+","+(end-9)+",'"+URLEncoder.encode(sql)+"')></IMG></A>");
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
							for (int x=0; x<23; x++)
							out.println("<BR>");
						}
					      if ( !( (start+9) > maxRecord ))
						{
							//whereClause = URLEncoder.encode(sql);
							//whereClause =sql;
							out.println("<A HREF='../../eDR/jsp/ReviewMergeProcessErrorsArrow.jsp?from="+(start+9)+"&to="+(end+9)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><IMG ALIGN='CENTER' SRC='../../eDR/images/downarrow.gif' WIDTH='18' HEIGHT='18' BORDER='0' ALT='' onClick=javascript:callDupFunction("+(start+9)+","+(end+9)+",'"+URLEncoder.encode(sql)+"')></IMG></A>");
						}
						else
						{
							out.println("<BR><BR>");
						}
						%>
						</td>
					<input type='hidden' name="CheckBoxes" id="CheckBoxes" value="">
		   <input type='hidden' name="selAll" id="selAll" value="">
		   <input type='hidden' name="dup_group_id" id="dup_group_id" value=''>
		   <input type='hidden' name='chkedVls' id='chkedVls' value=''>	
						</table>
					<br><br>
				</form>
			<%	
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exfception e :"+e.toString());
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
		%>
	</body>
</html>

