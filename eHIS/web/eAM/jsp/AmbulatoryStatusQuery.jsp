<!DOCTYPE html>
<%--
	FileName	: AmbulatoryStatusQuery.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()' >

<%
	request.setCharacterEncoding("UTF-8");

	String whereClause = request.getParameter("whereclause");
	//String sql ="";
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{

	//String facilityid=(String)session.getValue("facility_id");
	String cd = request.getParameter("ambulatory_status");
	String longdesc = request.getParameter("long_desc");
	String shortdesc = request.getParameter("short_desc");
	String enabled = request.getParameter("eff_status");

	int andCheck = 0;

	/*if ( !(facilityid == null || facilityid.equals("")) )
			{
			sql = "where facility_id like '"+facilityid+"%'";
			andCheck = 1;
		}*/
	if ( !(cd == null || cd.equals("")) )
		{
		sbQuery.setLength(0);
		 sbQuery.append("where upper(ambulatory_status) like upper('"+cd+"%')");
		//sql = "where upper(ambulatory_status) like upper('"+cd+"%')";
		andCheck = 1;
		}

	if ( !(longdesc == null || longdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{
			
			sbQuery.append("and upper(long_desc)  like  upper('"+longdesc+"%') ");
			//sql = sql + "and upper(long_desc)  like  upper('"+longdesc+"%') " ;
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append("where upper(long_desc)  like upper('"+longdesc+"%') ");
			//sql = "where upper(long_desc)  like upper('"+longdesc+"%') " ;
			andCheck = 1;
		}
	}

	if ( !(shortdesc == null || shortdesc.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sbQuery.append("and upper(short_desc)  like  upper('"+shortdesc+"%') ");
				//sql = sql + "and upper(short_desc)  like  upper('"+shortdesc+"%') " ;
			}
			else
			{
				sbQuery.append("where upper(short_desc)  like upper('"+shortdesc+"%') " );
			//	sql = "where upper(short_desc)  like upper('"+shortdesc+"%') " ;
				andCheck = 1;
			}
	}
	if ( !(enabled == null || enabled.equals("")) )
	{
	     if( enabled.equals("E") )
	     {
	        if ( andCheck == 0 )
			 {
				sbQuery.setLength(0);
				sbQuery.append("where eff_status='E'");}
		 //  sql = "where eff_status='E'";
		else
			 {sbQuery.append(" and eff_status='E'");}
	   	  // sql = sql + " and eff_status='E'";
	     }
	     if ( enabled.equals("D") )
	     {
	     	        if ( andCheck == 0 )
			 {
						sbQuery.setLength(0);
						sbQuery.append("where  eff_status='D'");}
	     	      //     sql = " where  eff_status='D'";
	     	        else
			 {sbQuery.append(" and eff_status='D'");}
	     	       //    sql = sql + " and eff_status='D'";
	     }//
	     if ( enabled.equals("B") )
	     {
	     		//out.println(sql );

	        	//sql = sql; //nothing is added to get both E and D
	     }
	}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sbQuery.append(" order by ");
		//sql=sql+" order by ";
		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sbQuery.append(ord[i]);
			//sql=sql+;
		else
			sbQuery.append(ord[i]+",");
			//sql=sql+ord[i]+",";
		}
	}
	/* if ( ord.length > 0 )
	{
		sql=sql+" order by ";
		for ( int i=0;i < ord.length;i++ )
		{
			if ( i == ord.length - 1 )
			  sql=sql+ord[i];
			else
			  sql=sql+ord[i]+",";
		}
	}*/
	} //end of where clause IF
	else
	{sbQuery.setLength(0);
		sbQuery.append(whereClause);}
		//sql = whereClause;

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
Statement stmt = null;
int maxRecord = 0;
ResultSet rs = null;

try{




stmt = conn.createStatement();
rs = stmt.executeQuery("select * from am_ambulatory_status "+sbQuery.toString());

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;

	while ( i<=end && rs.next() )
{
		if(maxRecord==0)
	{
%>

<P>
<table align='right'>
<tr >
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/AmbulatoryStatusQuery.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/AmbulatoryStatusQuery.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
<br></br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<% }
 	

	  String classValue = "" ;

	if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'align=='left'>");
	//String facilityid=(String)session.getValue("facility_id");
	String code = rs.getString("ambulatory_status");

	out.println("<a href='../../eAM/jsp/addAmbulatoryStatus.jsp?ambulatory_status="+ code + "' target='f_query_add_mod' >");
        out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_desc") );
	out.println("</td><td class='" + classValue + "' align='center'>");

	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;
	}//end of while 
		sbQuery.setLength(0);

if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}
		if (rs != null)   rs.close();
	     if (stmt != null) stmt.close();

}	catch(Exception e) { 
//out.println(e.toString());
e.printStackTrace();
}

	finally {
		 
	   ConnectionManager.returnConnection(conn,request);
	}

%>

</td></tr>
</table>
</center>

<br><center>


<!--%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/AmbulatoryStatusQuery.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/previous.gif' alt='Previous' border='0'></A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/AmbulatoryStatusQuery.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/next.gif' alt='Next' border='0'></A>");
rs.close();
%-->



</center>
</BODY>
</HTML>

