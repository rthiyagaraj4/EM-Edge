<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eAM
*	Purpose 		:
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	17 Sept 2004
*	Modified On		:   22 Feb  2005
-->
<!-- PositionQueryResult.jsp-->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<body  OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()'>

<%
request.setCharacterEncoding("UTF-8");	
//MMS-ME-SCF-0096 vulnerability Issue 
	/* request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); */
	//MMS-ME-SCF-0096 vulnerability Issue
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer("");
	String Practitioner="Practitioner";
	String OtherStaff="OtherStaff";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String qryWhere = "";

	if (whereClause == null || whereClause.equals(""))
		{
			sql.setLength(0);
			String qry_Code = request.getParameter("position_code").equals("") ? "":request.getParameter("position_code");
			String qry_Description = request.getParameter("position_desc").equals("") ? "":request.getParameter("position_desc");
			String qry_RoleType = request.getParameter("role_type").equals("") ? "":request.getParameter("role_type");
			String qry_Enabled = request.getParameter("eff_status").equals("") ? "":request.getParameter("eff_status");

			qry_Code = qry_Code +"%";
			qry_Description  = qry_Description +"%";
			qry_RoleType  =   qry_RoleType +"%";
			qry_Enabled = qry_Enabled + "%";
			
			

			qryWhere = "where upper(position_code) like upper('"+qry_Code+"') and upper(position_desc) like upper('"+qry_Description+"') and upper(role_type) like upper('"+qry_RoleType+"') and  upper(eff_status) like upper('"+qry_Enabled+"')";


			sql.append(qryWhere);
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
		}
	else
	{
			sql.setLength(0);
			sql.append(whereClause);
	}
		
			String position_code="";
			String position_desc  = "";
			String role_type = "";
			String staff_type="";
			String staff_type_desc="";
			String grade_code="";
			String grade_short_desc="";
			String eff_status = "";
			
Connection conn = null;
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;
try
{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();

String strsql = "select position_code,position_desc,role_type,staff_type,staff_type_desc,eff_status,grade_code,grade_short_desc from am_position_vw "+ sql;

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

		
	rs = stmt.executeQuery(strsql);

	if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		 {
			rs.next() ;
		 }

while ( i<end && rs.next() )
	{
	if(maxRecord==0)
	{
%>
<P>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='PositionQueryResult.jsp?from="+(start-13)+"&to="+(end-13)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='PositionQueryResult.jsp?from="+(start+13)+"&to="+(end+13)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
</P>
<br><br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		
		<th class='columnheader' rowspan="2"><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th class='columnheader' rowspan="2"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th class='columnheader' rowspan="2"><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></th>
		<th class='columnheader' rowspan="2"><fmt:message key="Common.StaffType.label" bundle="${common_labels}"/></th>
		<th class='columnheader' rowspan="2"><fmt:message key="Common.Grade.label" bundle="${common_labels}"/></th>
		<th class='columnheader' rowspan="2"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	<tr>
	<% }
	String classValue = "" ;

	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

    position_code = rs.getString("position_code")==null ? "":rs.getString("position_code");
	position_desc  = rs.getString("position_desc")==null ? "":rs.getString("position_desc");
	role_type = rs.getString("role_type")==null ? "":rs.getString("role_type");
	staff_type=rs.getString("staff_type")==null ? "":rs.getString("staff_type");
	grade_short_desc=rs.getString("grade_short_desc")==null ? "":rs.getString("grade_short_desc");
	grade_code=rs.getString("grade_code")==null ? "":rs.getString("grade_code");
	eff_status = rs.getString("eff_status")==null ? "D":rs.getString("eff_status");
	staff_type_desc = rs.getString("staff_type_desc")==null ? "":rs.getString("staff_type_desc");
	    	
%>
<tr><td class='" + <%=classValue%> + "' align='left'>
<a		href="../../eAM/jsp/addModifyPosition.jsp?position_code=<%=position_code%>&position_desc=<%=position_desc%>&role_type=<%=role_type%>&staff_type=<%=staff_type%>&staff_type_desc=<%=staff_type_desc%>&grade_short_desc=<%=grade_short_desc%>&grade_code=<%=grade_code%>&eff_status=<%=eff_status%>&mode=2">	
<%




	out.println(position_code +"</a></td><td class='" + classValue + "' align='left'>");
	out.println(position_desc +"</td><td class='" + classValue + "' align='left'>");
	if (rs.getString("role_type").equalsIgnoreCase("P"))
	out.println(Practitioner +"</td><td class='" + classValue + "' align='left'>");
	else
	out.println(OtherStaff +"</td><td class='" + classValue + "' align='left'>");
	if(rs.getString("staff_type_desc")!=null)
		{
		out.println(staff_type_desc+"</td><td class='" + classValue + "' align='center'>");
		}
	else 
	out.println("&nbsp;</td><td class='" + classValue + "' align='center'>");
	if(rs.getString("grade_short_desc")!=null)
		{
		out.println(grade_short_desc+"</td><td class='" + classValue + "' align='center'>");
		}
	else 
	out.println("&nbsp;</td><td class='" + classValue + "' align='center'>");
	if ( rs.getString("eff_status").equalsIgnoreCase("E") )
		out.println("<img src='../../eCommon/images/enabled.gif' align='center'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif' align='center'></img>");
			out.println("</td></tr>");
	
i++;
maxRecord++;

  } // end of while

  if(maxRecord == 0)
		{ %>
			 <script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<% }

if ( maxRecord < 13 || (!rs.next()) ) {
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

  if(rs!=null) 	rs.close();
  if(stmt!=null) stmt.close();
  %>
	  </table>
<%
}// end of try
  catch(Exception e)
{
	out.println(e.getMessage());
	e.printStackTrace();
}
finally 
{
	try
	{
	  if (stmt != null) stmt.close();
	  if (rs != null)   rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	  sql.setLength(0);
	  ConnectionManager.returnConnection(conn,request);
	}
%>

</BODY>
</HTML>

