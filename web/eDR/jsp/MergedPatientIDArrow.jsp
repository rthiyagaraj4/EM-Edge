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
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%
	Connection             con      = null;
	java.sql.Statement	   stmt		= null;
	ResultSet	           rs		= null;
	
	String          p_patient_id	= "";
    String          sql	            = "";
	String          strsql1	        = "";

	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to	= request.getParameter( "to" ) ;
	
try{
     String p_to_replace_date = request.getParameter( "p_to_replace_date" ) ;
	String p_fm_replace_date = request.getParameter( "p_fm_replace_date" ) ;
	if (p_to_replace_date==null || p_to_replace_date.equals("null") || p_to_replace_date.equals("") ) 
				p_to_replace_date="31/12/5000";
	if (p_fm_replace_date==null || p_fm_replace_date.equals("null") || p_fm_replace_date.equals("")  ) 
				p_fm_replace_date="01/01/1700";
	 con                    = ConnectionManager.getConnection(request);;
	 stmt					= con.createStatement();
	if ((whereClause == null || whereClause.equals("")))
	{
		p_patient_id		= request.getParameter("patient_id");

		if (p_patient_id==null || p_patient_id.equals("null")) 
			p_patient_id="";

		sql	= "where patient_id=nvl(('"+p_patient_id+"'),patient_id) and trunc(added_date) between  to_date('"+p_fm_replace_date+"','dd/mm/yyyy') and to_date('"+p_to_replace_date+"','dd/mm/rrrr') ";
	}
	else
	{
		sql = whereClause;
	}
	
	int start = 0 ;
	int end = 0 ;
	if ( from == null || from.equals("null"))
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;
	if (to == null || to.equals("null"))
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;
		int maxRecord = 0;
		strsql1="select count(*) as total from dr_merged_patient_vw10 "+  sql;

		rs = stmt.executeQuery(strsql1);
		if(rs!=null)
	    { 
		  if(rs.next())
		  maxRecord = rs.getInt("total");
		}
		  if(rs != null) rs.close();
		  boolean printprevious = false;
%>

<form name='group_header_image' id='group_header_image'>

	<table border=0 cellpadding=0 cellspacing=0 height=100% width=100% align='center'>
	<tr>
	<td>
	<%
	if ( !(start <= 1) )
		{
			whereClause = URLEncoder.encode(sql);

			out.println("<A HREF='../../eDR/jsp/MergedPatientIDArrow.jsp?from="+(start-10)+"&to="+(end-10)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><IMG ALIGN='CENTER' SRC='../../eDR/images/uparrow.gif' WIDTH='18' HEIGHT='18' BORDER=0 ALT='' onClick=javascript:callDupFunction("+(start-10)+","+(end-10)+",'"+whereClause+"')></IMG></A>");
			out.println("<BR>");
			printprevious = true;
		}

			if (printprevious)
			{
				for (int x=0; x<21; x++)
				out.println("<BR>");
			}
			else
			{
				for (int x=0; x<24; x++)
				out.println("<BR>");
			}
		if ( !( (start+10) > maxRecord ) )
		{
			
			
			whereClause = URLEncoder.encode(sql);

			
			out.println("<A HREF='../../eDR/jsp/MergedPatientIDArrow.jsp?from="+(start+10)+"&to="+(end+10)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><IMG ALIGN='CENTER' SRC='../../eDR/images/downarrow.gif' WIDTH='18' HEIGHT='18' BORDER=0 ALT='' onClick=javascript:callDupFunction("+(start+10)+","+(end+10)+",'"+whereClause+"')></IMG></A>");
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
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();}
	catch(Exception e)
	{
	 out.println("Exception In The File MergedPatientIDArrow:"+e.toString());
	 e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>

</body>
</html>

