<!DOCTYPE html>
<!--Created by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095-->

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="javascript" src="../../eCommon/js/common.js"></script>

<HTML>

<head>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

</head>

<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<%
String whereClause = request.getParameter("whereclause");
StringBuffer sql =new StringBuffer();
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;

if ( (whereClause == null || whereClause.equals("")) )
{
	String cd = request.getParameter("claimant_type_mstr_code")==null ?"":request.getParameter("claimant_type_mstr_code");
	String desc = request.getParameter("long_desc")==null ?"":request.getParameter("long_desc");
	String enabled = request.getParameter("eff_status")==null ?"":request.getParameter("eff_status");
	int andCheck = 0;

	if ( !(cd == null || cd.equals("")) )
	{
		sql.setLength(0);
		sql.append("where upper(CLAIMANT_TYPE_MSTR_CODE) like upper('"+cd+"%')");
		andCheck = 1;
	}

	if ( !(desc == null || desc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and upper(LONG_DESC)  like  upper('"+desc+"%') "); 
		}
		else
		{
			sql.setLength(0);
			sql.append("where upper(LONG_DESC)  like upper('"+desc+"%') ") ;
			andCheck = 1;
		}
	}

	if ( !(enabled == null || enabled.equals("")) )
	{
		if ( enabled.equals("E") )
		{
			if ( andCheck == 0 )
				sql.append( "where EFF_STATUS='E'");
			else
				sql.append( " and EFF_STATUS='E'");
		}
		
		if ( enabled.equals("D") )
		{
			if ( andCheck == 0 )
				sql.append(" where  EFF_STATUS='D'");
			else
				sql.append("  and EFF_STATUS='D'" );
		}
	}

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
}else
{
	sql.append(whereClause);
}

	int start = 0 ;
	int end = 0 ;
	int i = 1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

    Connection conn = ConnectionManager.getConnection(request);
    java.sql.Statement stmt=null;
    ResultSet rs=null;

try{

	stmt = conn.createStatement();

	StringBuffer strsql2=new  StringBuffer();
	strsql2.append("select * from MO_CLAIMANT_TYPE_MSTR "+sql.toString());
	rs = stmt.executeQuery(strsql2.toString());

	%>

	<%
		if ( start != 1 )
		for( int j=1; j<start; i++,j++ ){
		rs.next() ;
		}
	
	String classValue = "" ;
	int cnt=0;
	while (i<=end && rs.next())
	{
		if(cnt==0)
		{%>
			
		<P>
		<table align='right'>
		<tr>

		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMO/jsp/ClaimantTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMO/jsp/ClaimantTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
		%>
		
		</tr>
		</table>
		
		<br><br>

		</P>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

	    <%}
	
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		out.println("<tr><td class='" + classValue + "'>");
		String code = rs.getString("CLAIMANT_TYPE_MSTR_CODE");

		out.println("<a href='../../eMO/jsp/ClaimantTypeAddModify.jsp?claimant_type_mstr_code="+ code + "' target='f_query_add_mod' >");
		out.println(code+"</a></td><td class='" + classValue + "' wrap >");
		out.println( rs.getString("long_desc") );
		out.println("</td>");
		out.println("<td class='" + classValue + "' wrap >");
		out.println( rs.getString("short_desc") );
		out.println("</td>");
		out.println("<td class='" + classValue + "' align='center' >");
		if ( rs.getString("EFF_STATUS").equals("E") )
			out.print("<img src='../../eCommon/images/enabled.gif'></img>");
		else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		i++;
		cnt++;

		sql.setLength(0);

		strsql2.setLength(0);

	}
		if (cnt==0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		boolean flag = false;
		if ( cnt < 14 || (!rs.next()) ) {
		%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='hidden';
			</script>
		<% flag = true;
		} else {%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%}

}catch(Exception e){
		e.toString();
}
finally{
	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
	ConnectionManager.returnConnection(conn,request);
}
%>

</td></tr>
</table>
<br><center>
</center>
</BODY>
</HTML>

