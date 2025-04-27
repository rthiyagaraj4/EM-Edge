<!DOCTYPE html>
<%--
	FileName	: DiscretePanelQueryResult.jsp
	Version	    : 3	
	Modified On	: 19-5-2005
--%>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
	<head>
		
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" class='CONTENT'>

<%
	request.setCharacterEncoding("UTF-8");

	String whereClause = request.getParameter("whereclause");

	StringBuffer sql=new StringBuffer("");
	String resulttypecode[] = {"G","V","Z",};
    String resulttypedesc[]={com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ChartSection.label","am_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VitalSignsBattery.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.PatientCarePanel.label","am_labels"),};

	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql.setLength(0);
	sql.append(" ");
	String discrmsrid    = request.getParameter("discr_msr_id")==null ?"":request.getParameter("discr_msr_id");
	//out.println(discrmsrid);
	String longdesc    = request.getParameter("long_desc")==null ?"":request.getParameter("long_desc");
	String shortdesc    = request.getParameter("short_desc")==null ?"":request.getParameter("short_desc");
	String resulttype    = request.getParameter("result_type")==null ?"":request.getParameter("result_type");
	String enabled    = request.getParameter("nature")==null ?"":request.getParameter("nature");

	int andCheck = 0;
	if(!(resulttype == null ) && resulttype.equals("Q"))
	{		//out.println("hi");
			sql.setLength(0);
			sql.append("where result_type in ('G','V','Z') ");
			andCheck = 1;	
	}

	if ( !(discrmsrid == null || discrmsrid.equals("")) )
	{
			discrmsrid=discrmsrid.toUpperCase();
			
			if ( andCheck == 1 )
			{	sql.append( " and ");
				sql.append( "upper(discr_msr_id) like  upper('"+discrmsrid+"%')" );
			}
			else
			{
					sql.setLength(0);
					sql.append("where upper(discr_msr_id) like upper('"+discrmsrid+"%')" );
					andCheck = 1;
			}
	}
	/*if ( !(discrmsrid == null || discrmsrid.equals("")) )
			{
			discrmsrid=discrmsrid.toUpperCase();
			sql.setLength(0);
			sql.append("where upper(discr_msr_id) like upper('"+discrmsrid+"%')");
			andCheck = 1;
			}*/
	
		if ( !(longdesc == null || longdesc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql.append( " and ");
					sql.append( "upper(long_desc) like  upper('"+longdesc+"%')" );
				}
				else
				{
					sql.setLength(0);
					sql.append("where upper(long_desc) like upper('"+longdesc+"%')" );
					andCheck = 1;
				}
			}


		if ( !(shortdesc == null || shortdesc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql.append( " and ");
					sql.append( "upper(short_desc) like  upper('"+shortdesc+"%')" );
				}
				else
				{
					sql.setLength(0);
					sql.append("where upper(long_desc) like upper('"+shortdesc+"%')" );
					andCheck = 1;
				}
			}
		if ( !(resulttype == null || resulttype.equals("Q")) )
			{
				if ( andCheck == 1 )
				{	sql.append( " and ");
					sql.append( "result_type =  '"+resulttype+"'" );
				}
				else
				{
					sql.setLength(0);
					sql.append("where result_type = '"+resulttype+"'" );
					andCheck = 1;
				}
			}
	
		
		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		        {
			if ( andCheck == 0 )
				{
				sql.setLength(0);
				sql.append("where eff_status='E'");
				}
			else
				sql.append(" and eff_status='E'");
			}
		   if ( enabled.equals("D") )
			{
			if ( andCheck == 0 )
				{
				sql.setLength(0);
				sql.append(" where  eff_status='D'");
				}
			else
				sql.append( " and eff_status='D'");
		}
	}
	
	sql.append(" and modifiable_yn ='Y' ");
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
	else 
	{
		sql.setLength(0);
		sql.append(whereClause);
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
ResultSet rs=null;
int maxRecord = 0;

try
{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
String strsql1="select count(*) as total from AM_DISCR_MSR "+sql;

rs = stmt.executeQuery(strsql1);
rs.next();
maxRecord = rs.getInt("total");
if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
if (stmt != null) stmt.close();
String strsql2=" SELECT discr_msr_id,long_desc,short_desc,RESULT_TYPE,EFF_STATUS FROM AM_DISCR_MSR  "+sql;
stmt = conn.createStatement();
rs = stmt.executeQuery(strsql2);

%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/DiscretePanelQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/DiscretePanelQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
	<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th><fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.ResultType.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

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
	String code = rs.getString("discr_msr_id");
	
	out.println("<a href='../../eAM/jsp/DiscretePanelAddModify.jsp?mode=update&discr_msr_id="+ code + "' target='f_query_add_mod' >");
	//out.println("<a href='../../eAM/jsp/DiscretePanelAddtoPanelElement.jsp?discr_msr_id="+ code + "' target='paneladd' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println( rs.getString("short_desc") );
	out.println("</td><td align='left' class='" + classValue + "'>");
	for(int k=0;k<resulttypecode.length;k++)
		if(resulttypecode[k].equals(rs.getString("RESULT_TYPE")))
			out.println(resulttypedesc[k]);
	out.println("</td><td align='center' class='" + classValue + "'>");
	if ( rs.getString("eff_status").equals("E") )
		out.print("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;

  }//endwhile
  if(rs!=null)	rs.close();
  if (stmt != null) stmt.close();
}
catch(Exception e)
{
//		out.println(e.toString());
		e.printStackTrace();
}
finally
{
	try
	{
	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	ConnectionManager.returnConnection(conn,request);

}
%>

</td></tr>
</table>
</BODY>
</HTML>

