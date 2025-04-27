<!DOCTYPE html>

<%--
	FileName	:PatientTypeQueryResult.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()'  class='CONTENT' >


<%
request.setCharacterEncoding("UTF-8");	

	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
	String cd    = request.getParameter("patient_type")==null ?"":request.getParameter("patient_type");
	String longdesc    = request.getParameter("long_desc")==null ?"":request.getParameter("long_desc");
	String enabled    = request.getParameter("nature")==null ?"":request.getParameter("nature");

	int andCheck = 0;

	cd=cd.toUpperCase();

	if ( !(cd == null || cd.equals("")) )
			{
			sbQuery.setLength(0);
			sbQuery.append("where upper(patient_type) like upper('"+cd+"%')");
			andCheck = 1;
			}

		if ( !(longdesc == null || longdesc.equals("")) )
			{
				if ( andCheck == 1 )

				{	
					sbQuery.append(" and ");
					sbQuery.append(" upper(long_desc)  like  upper('"+longdesc+"%') ");
				}
				else
				{
					sbQuery.setLength(0);
					sbQuery.append("where upper(long_desc)  like upper('"+longdesc+"%') ");
					andCheck = 1;
				}
			}


		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		        {
			if ( andCheck == 0 ){
				sbQuery.setLength(0);
				sbQuery.append("where eff_status='E'");}
			else
					{sbQuery.append(" and eff_status='E'");}
			}
		   if ( enabled.equals("D") )
			{
			if ( andCheck == 0 ){
				sbQuery.setLength(0);
				sbQuery.append("where  eff_status='D'");}
			else
				{	sbQuery.append("and eff_status='D'");}
			}
	  }

	

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sbQuery.append(" order by ");

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			{sbQuery.append(ord[i]);}
		else
			{sbQuery.append(ord[i]+",");}
		}
}
	} //end of where clause IF
	else {
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
		//sql = whereClause;

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
conn = ConnectionManager.getConnection(request);
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;

try{

stmt = conn.createStatement();
String strsql1="select count(*) as total from am_patient_type "+sbQuery.toString();
rs = stmt.executeQuery(strsql1);

if (rs.next())
	{
		maxRecord = rs.getInt("total");
	}
if(stmt!=null) 	stmt.close();	
		if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");

	
String strsql2="select * from am_patient_type "+sbQuery.toString();
stmt = conn.createStatement();
if(rs!=null)rs.close();
rs = stmt.executeQuery(strsql2);
%>

<p>
<table align='right'>
<tr>
<td>
<%
try{
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/PatientTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/PatientTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
}catch(Exception e){}	
%>
</td>
</tr>
</table>
	<br><br>
</p>


<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }

String classValue = "" ;

while ( rs.next() && i<=end )
{
	if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
		classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("patient_type");

	out.println("<a href='../../eAM/jsp/addModifyPatientType.jsp?patient_type="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_desc") );
	out.println("</td><td align='center' class='" + classValue + "'>");
	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;

  }//endwhile
  if(rs!=null) 	rs.close();
  if(stmt!=null) stmt.close();
}catch(Exception e){
		e.toString();
}
	finally   {
	
	ConnectionManager.returnConnection(conn,request);

	}
%>

</td></tr>
</table>
<br>
</BODY>
</HTML>

