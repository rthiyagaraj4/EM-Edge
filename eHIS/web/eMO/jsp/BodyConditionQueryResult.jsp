<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<HTML><head>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<%
request.setCharacterEncoding("UTF-8");
String whereClause = request.getParameter("whereclause");
StringBuffer sql =new StringBuffer();
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;

if ( (whereClause == null || whereClause.equals("")) )
{
 String cd    = request.getParameter("body_cond_code")==null ?"":request.getParameter("body_cond_code");
 String desc    = request.getParameter("long_desc")==null ?"":request.getParameter("long_desc");
 String enabled    = request.getParameter("EFF_STATUS")==null ?"":request.getParameter("EFF_STATUS");
int andCheck = 0;
if ( !(cd == null || cd.equals("")) )
{  sql.setLength(0);
	sql.append("where upper(BODY_COND_CODE) like upper('"+cd+"%')");
	andCheck = 1;
}

if ( !(desc == null || desc.equals("")) )
{
		if ( andCheck == 1 )
		{	sql.append(" and upper(LONG_DESC)  like  upper('"+desc+"%') "); 
		}
		else
		{sql.setLength(0);
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
	}else
	{
	sql.append(whereClause);
	}
	
	//end of where clause IF


	int start = 0 ;
	int end = 0 ;
	int i=1;
	int cnt = 0;
	//int endOfRes = 1;

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
    //int maxRecord = 0;

try{

stmt = conn.createStatement();
/*
StringBuffer strsql1=new  StringBuffer();
strsql1.append("select count(*) as total from mo_body_condition "+sql.toString());
rs = stmt.executeQuery(strsql1.toString());
if (rs.next())
	{	
	maxRecord = rs.getInt("total");
	}
	if(rs!=null)rs.close();
if(maxRecord == 0)
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
*/

		StringBuffer strsql2=new  StringBuffer();
		strsql2.append("select * from mo_body_condition "+sql.toString());
		rs = stmt.executeQuery(strsql2.toString());

		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;
	
		while(i<=end && rs.next()) 
		{		 
			if(cnt==0)
			{
%>

<P>
<table align='right'>
<tr >
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eMO/jsp/BodyConditionQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	out.println("<A id='nextval' HREF='../../eMO/jsp/BodyConditionQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
	<br><br>
</P>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%
	}
/*
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
 */
	  String classValue = "" ;

//while ( rs.next() && i<=end )
//{
if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
		classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("BODY_COND_CODE");


	out.println("<a href='../../eMO/jsp/addModifyBodyCondition.jsp?body_cond_code="+ code + "' target='f_query_add_mod' >");
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
//strsql1.setLength(0);
strsql2.setLength(0);
	
  }//endwhile

   if(cnt==0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

   if( !rs.next() && cnt!=0 )
   {
	%>
	<script>
		document.getElementById("nextval").innerHTML = " ";
	</script>
	<%
   }		
  
}catch(Exception e){
		e.toString();
}
	finally   {
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

