<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"  %><!--oracle.jdbc.driver.*,-->
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>



<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql.append("");
	String cd = request.getParameter("tab_list_no");
	String longdesc = request.getParameter("long_desc");
	String enabled = request.getParameter("nature");
	//String diag_code_scheme = request.getParameter("diag_code_scheme");
	
	int andCheck = 0;

	cd=cd.toUpperCase();

	if ( !(cd == null || cd.equals("")) )
			{
			sql.append("where upper(tab_list_no)  like upper('"+cd+"%') ");
			andCheck = 1;
			}

	/*if ( !(diag_code_scheme == null || diag_code_scheme.equals("")) )
			{
				if ( andCheck == 1 )
				{	
				sql.append(" and ");
				sql.append("where upper(diag_code_scheme)  =upper('"+diag_code_scheme+"') ");
				}
				else
				{
				sql.append("where upper(diag_code_scheme)  = upper('"+diag_code_scheme+"') " );
				andCheck = 1;
				}
			
			}*/
			
	
	if ( !(longdesc == null || longdesc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql.append(" and ");
					sql.append(" upper(long_desc)  like  upper('"+longdesc+"%') " );
				}
				else
				{
					sql.append("where upper(long_desc)  like upper('"+longdesc+"%') " );
					andCheck = 1;
				}
			}


		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		        {
			if ( andCheck == 0 )
				sql.append("where eff_status='E'");
			else
				sql.append(" and eff_status='E'");
			}
		   if ( enabled.equals("D") )
			{
			if ( andCheck == 0 )
				sql.append(" where  eff_status='D'");
			else
				sql.append(" and eff_status='D'");
		}
	}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sql.append(" order by ");

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sql.append(ord[i]);
		else
			sql.append(ord[i]+",");
		}
	}
	} //end of where clause IF
	else {
		sql.append( whereClause);

	}

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
	
	Connection conn = null;
	Statement stmt=null;
	//ResultSet rset=null;
	ResultSet rs=null;
	int maxRecord = 0;
	//String diag_code_scheme="";
	String diag_code_range="";

try{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();

		
/*String strsql1="select count(*) as total from mr_tab_list "+sql.toString();
rs = stmt.executeQuery(strsql1);
rs.next();
maxRecord = rs.getInt("total");

	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
*/
		String strsql2="select * from mr_tab_list "+sql.toString();

		rs = stmt.executeQuery(strsql2);

		if ( start != 1 )
			for( int j=1; j<start; i++,j++ ){
				rs.next() ;
				}

		while ( i<=end && rs.next() )
			{
				if (maxRecord==0)
					{
%>

		<P>
			<!-- <table border="1" width="100%" cellspacing='0' cellpadding='0'> -->
		 <table align='right'>
		<tr>

<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/DiagGroupQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		//if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/DiagGroupQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>

			</tr>
			</table>
			<br><br>
			</P>

			<table border="1" width="140%" cellspacing='0' cellpadding='0'>
			<th width='auto'><fmt:message key="eMR.TabulationListCode.label" bundle="${mr_labels}"/></th>
			<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eMR.DiagnosisCodingRange.label" bundle="${mr_labels}"/></th>
			<!-- <th><fmt:message key="Common.DiagnosisCodingScheme.label" bundle="${common_labels}"/></th> -->
			<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			<tr>
			<td width="10%"></td>
			<td width="45%"></td>
			<td width="20%"></td>
			<td width="40%"></td>
			<!-- <td width="10%"></td> -->
			<td width="10%"></td>
			</tr>

<%
					}
 	/*if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }*/
			String classValue = "" ;
//while ( rs.next() && i<=end )
//{

			//diag_code_scheme = rs.getString("diag_code_scheme");
			//if(diag_code_scheme == null) diag_code_scheme="";
			diag_code_range = rs.getString("diag_code_range");
			if(diag_code_range == null) diag_code_range="&nbsp;";
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			out.println("<tr><td width='10%' class='" + classValue + "'>");
			String code = rs.getString("tab_list_no");

			out.println("<a href='../../eMR/jsp/addModifyDiagGroup.jsp?tab_list_no="+ code + "' target='f_query_add_mod' >");
			out.println(code+"</a></td><td  class='" + classValue + "'>");
			out.println( rs.getString("long_desc") );
			out.println("</td>");
			out.println("<td  class='" + classValue + "'>");
			out.println( rs.getString("short_desc"));
			out.println("<td  class='" + classValue + "'>");
			out.println( diag_code_range);
			out.println("</td>");
			/*<td class='" + classValue + "'>");
			if(diag_code_scheme.equals("1"))
				out.println("ICD10");
			else
			if(diag_code_scheme.equals("2"))
				out.println("ICD9-CM");
			else
				out.println("&nbsp;");

			out.println("</td>");*/
			out.println("<td  class='" + classValue + "' align='center' >");
			if ( rs.getString("eff_status").equals("E") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			i++;
			maxRecord++;
			}//endwhile
%>

			</td></tr>
			</table>
			<br><center>
<%
//rs.close();
%>
</center>
</BODY>
</HTML>
<%
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		if ( maxRecord < 14 || (!rs.next()) )
		{
			%>
			<script >
				if (document.getElementById("next"))
					document.getElementById("next").style.visibility='hidden';
			</script>
			<% 
		}
		else
		{%>
			<script >
				if (document.getElementById("next"))
					document.getElementById("next").style.visibility='visible';
			</script>
		<%
		}
		sql.setLength(0);
}catch(Exception e){
		e.toString();
}
	finally   {
		try
		{
	if(stmt!=null)
	stmt.close();
	if(rs!=null)
	rs.close();
	//if(rset!=null)
	//rset.close();
		}
		catch(Exception e){
	//out.println("Exception @ try"+e.toString());
	e.printStackTrace();
}

	ConnectionManager.returnConnection(conn,request);
	}

%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

