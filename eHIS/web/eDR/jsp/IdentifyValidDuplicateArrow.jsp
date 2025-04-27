<!DOCTYPE html>
<!--	
	Developed By       :  P.Sudhakaran
-->
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
	<script language='javascript' src='../../eDR/js/IdentifyValidDuplicates.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<!-- <script language="javascript" src="../../eDR/js/DRrowcolor.js" ></script> -->
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
 </head>
 <body onMouseDown="CodeArrest()" onKeyDown='lockKey()'>


<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet	rs			= null;
try
{
	con	 = ConnectionManager.getConnection(request);
	stmt = con.createStatement();

	String p_patient_id	= ""; 	
	//String strsql1		= "";
	//String locale = (String)session.getAttribute("LOCALE");		
	String from = request.getParameter( "from" ) ;
	String to	= request.getParameter( "to" ) ;	
	
	int start = 0 ;
	int end = 0 ;
	int i=0;
	if(from == null) start = 1 ;
	else start = Integer.parseInt( from) ;
	if(to == null) end = 10 ;
	else end = Integer.parseInt( to ) ;
		
	int maxRecord = 0;

	String grp_no = "";

	grp_no =  request.getParameter("grp_no")==null?"":request.getParameter("grp_no");

	if(!(grp_no.equals("")))
			maxRecord = Integer.parseInt(grp_no);

	 String  str=" SELECT patient_id FROM DR_DUP_GROUP_HDR A, DR_DUP_GROUP_DTLS B WHERE A.DUP_GROUP_ID = B.DUP_GROUP_ID AND system_gen_yn='Y' AND marked_for_merge_yn='N' AND group_status = 'U' AND sug_valid_pat_flag='Y'  ";   
		
		rs  = stmt.executeQuery(str);
		if(rs != null)
		{
			if(start != 1)
			for(int j=1; j<start; i++,j++)
			{	
				rs.next();						  
			}
			while( rs.next() && i<=end)
			{
			p_patient_id    = rs.getString("patient_id");
	        if(p_patient_id==null) p_patient_id  ="";
		   }
		   }
		   if(rs != null) rs.close();
	      boolean printprevious = false;

	%>
<form name='group_header_image' id='group_header_image'>
	<table border=0 cellpadding=0 cellspacing=0 height=100% width=100% align='center'>
	<tr>
	<td>
	<% 

if (!(start <= 1))
		{
		
		out.println("<A HREF='../../eDR/jsp/IdentifyValidDuplicateArrow.jsp?grp_no="+maxRecord+"&from="+(start-10)+"&to="+(end-10)+"'"+" text-decoration='none'><IMG id='uparrow'  ALIGN='CENTER' SRC='../images/uparrow.gif' WIDTH='18' HEIGHT='18' BORDER=0 ALT='' onClick=javascript:callDupFunction("+(start-10)+","+(end-10)+","+maxRecord+")></IMG></A>");
			out.println("<BR>");
			printprevious = true;
		}
		else
		{
			out.println("<BR><BR>");
		}
		
		
		if (printprevious)
		{
			for (int x=0; x<21; x++)
			out.println("<BR>");
		}
		else
		{
			for (int x=0; x<23; x++)
			out.println("<BR>");
		}
		
		
		if ( !( (start+10) > maxRecord ) )
		{
			out.println("<A HREF='../../eDR/jsp/IdentifyValidDuplicateArrow.jsp?grp_no="+maxRecord+"&from="+(start+10)+"&to="+(end+10)+"'"+" text-decoration='none'><IMG ALIGN='CENTER' SRC='../images/downarrow.gif' WIDTH='18' HEIGHT='18' BORDER=0 ALT='' onClick=javascript:callDupFunction("+(start+10)+","+(end+10)+","+maxRecord+")></IMG></A>");
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
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>

</body>
</html>

