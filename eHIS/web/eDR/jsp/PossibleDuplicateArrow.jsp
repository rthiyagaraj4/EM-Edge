<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>
<html>
<head>
<!-- 	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
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
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey();'>
<%
		Connection con                  = null;
		java.sql.Statement	stmt		= null;
		ResultSet	rs			        = null;

		String p_patient_id		        = "";
		String whereClause              = "";
		String from                     = "";
		String to                       = "";
		String sql	                    = "";
		String strsql1	= "";
try
	{
	    from           = request.getParameter( "from" ) ;
	   	to             = request.getParameter( "to" ) ;
		whereClause    = request.getParameter("whereclause");
        p_patient_id   = request.getParameter("patient_id");
       
		con            = ConnectionManager.getConnection(request);
		stmt		   = con.createStatement();

	if ((whereClause == null || whereClause.equals("")))
	 {
		   if (p_patient_id==null) 
		   p_patient_id="";

		   //sql	= "where sug_valid_pat_flag='Y' and group_status='U' and patient_id=nvl(('"+p_patient_id+"'),patient_id) ";	
		   
		   sql	= " WHERE A.DUP_GROUP_ID = B.DUP_GROUP_ID AND sug_valid_pat_flag='Y' AND group_status='U' AND patient_id = NVL(('"+p_patient_id+"'),patient_id)";
	 }
	
		
		int start      = 0;
		int end        = 0;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;
	
	
		int maxRecord = 0;
		strsql1 = "select count(1) as total from dr_dup_group_vw2 where sug_valid_pat_flag='Y' and group_status='U' and system_gen_yn='Y' and marked_for_merge_yn='N' " ;
		//strsql1="select count(1) as total from dr_dup_group_vw2 "+  sql;
		rs = stmt.executeQuery(strsql1);
		rs.next();
		maxRecord = rs.getInt("total");
		boolean printprevious = false;
	if (rs != null) rs.close();
	
	

%>
<form name='group_header_image' id='group_header_image'>
	<table border=0 cellpadding=0 cellspacing=0 height=100% width=100% align='center'>
	<tr >
	<td>
<%
	if ( !(start <= 1) )
	{
		whereClause = URLEncoder.encode(sql);
			out.println("<A HREF='../../eDR/jsp/PossibleDuplicateArrow.jsp?from="+(start-10)+"&to="+(end-10)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><IMG ALIGN='CENTER' SRC='../images/uparrow.gif' WIDTH='18' HEIGHT='18' BORDER=0 ALT='' onClick=javascript:callDupFunction("+(start-10)+","+(end-10)+",'"+whereClause+"')></IMG></A>");
			out.println("<BR>");
			printprevious = true;
	}

	if (printprevious)
	{
		for (int x=0; x<19; x++)
		out.println("<BR>");
	}
	else
	{
		for (int x=0; x<23; x++)
		out.println("<BR>");
	}
	if ( !( (start+10) > maxRecord ) )
	{
		whereClause = URLEncoder.encode(sql);

		out.println("<A HREF='../../eDR/jsp/PossibleDuplicateArrow.jsp?from="+(start+10)+"&to="+(end+10)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><IMG ALIGN='CENTER' SRC='../images/downarrow.gif' WIDTH='18' HEIGHT='18' BORDER=0 ALT='' onClick=javascript:callDupFunction("+(start+10)+","+(end+10)+",'"+whereClause+"')></IMG></A>");
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
	if (stmt != null) stmt.close();
	 }
	catch(Exception e)
	{
		out.println("Exception  in File PossibleDuplicateArrow "+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

