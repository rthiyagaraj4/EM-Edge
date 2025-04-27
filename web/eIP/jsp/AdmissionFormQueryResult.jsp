<!DOCTYPE html>
<!--Created by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*, java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>");
	
	String locale = (String)session.getAttribute("LOCALE");
	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String sql ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql="";
	String cd = request.getParameter("admission_form_code");
	String longdesc = request.getParameter("long_desc");
	String specialty = request.getParameter("spec_short_desc");
	String bydefault = request.getParameter("by_default");
	String enabled = request.getParameter("nature");


	cd=cd.toUpperCase();

	if ( !(cd == null || cd.equals("")) )
			{
			sql = sql + " and upper(a.admission_form_code)  like  upper('"+cd+"%') ";
			}

	if ( !(longdesc == null || longdesc.equals("")) )
			{
			sql = sql + " and upper(a.long_desc)  like  upper('"+longdesc+"%') " ;	
			}

	if ( !(specialty == null || specialty.equals("")) )
			{
			sql = sql + " and upper(b.short_desc)  like  upper('"+specialty+"%') " ;
			}

	if ( !(bydefault == null || bydefault.equals("")) )
			{
			   if ( bydefault.equals("Y") )
				{
					sql = sql + " and a.by_default='Y'";
				}
			   if ( bydefault.equals("N") )
				{
					sql = sql + " and a.by_default='N'";
				}
			}

	if ( !(enabled == null || enabled.equals("")) )
			{
			   if ( enabled.equals("E") )
				{
					sql = sql + " and a.eff_status='E'";
				}
			   if ( enabled.equals("D") )
				{
					sql = sql + " and a.eff_status='D'";
				}
			}

	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
			{
				sql=sql+" order by ";

				for ( int i=0;i < ord.length;i++ )
				{
				if ( i == ord.length - 1 )
					sql=sql+ord[i];
				else
					sql=sql+ord[i]+",";
				}
			}
	}
	else {
		sql = whereClause;
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

	Connection conn =null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

try{
	conn=ConnectionManager.getConnection(request);
	stmt = conn.createStatement();

	String strsql2="select a.admission_form_code,a.long_desc,a.short_desc,b.short_desc specialty, a.by_default, a.eff_status from IP_ADMISSION_FORM a, AM_SPECIALITY b where b.speciality_code = a.specialty_code"+sql;
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
			<table align='right'>
			<tr>
			<%
			if ( !(start <= 1) )
				out.println("<td align ='right' id='prev'><A HREF='../../eIP/jsp/AdmissionFormQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

				out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eIP/jsp/AdmissionFormQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
			%>
			</tr>
			</table>
			<br><br>
			</P>

			<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.by.label" bundle="${common_labels}"/> <fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%
			}
 	
		String classValue="";

		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;
		out.println("<tr><td  class='" + classValue + "'>");
		String code = rs.getString("admission_form_code");

		out.println("<a href='../../eIP/jsp/AddModifyAdmissionForm.jsp?admission_form_code="+ code+"&mode=modify'>");

		out.println(code+"</a></td><td  class='" + classValue + "'>");
		out.println( rs.getString("long_desc") );

		out.println("</td><td  class='" + classValue + "'>");
		out.println(rs.getString("short_desc") );

		out.println("</td><td  class='" + classValue + "'>");
		out.println(rs.getString("specialty") );

		out.println("</td><td align='center'  class='" + classValue + "'>");

		if ( rs.getString("by_default").equals("Y") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

		out.println("</td><td align='center'  class='" + classValue + "'>");

		if ( rs.getString("eff_status").equals("E") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		i++;
		maxRecord++;
		}
%>
		</td></tr>
		</table>
		<br><center>
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
	{
	%>
		<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%
	}
%>

</center>
</BODY>
</HTML>
<%
}catch(Exception e){
		e.toString();
}
finally{
	if(stmt!=null)
	stmt.close();
	if(rs!=null)
	rs.close();
	ConnectionManager.returnConnection(conn,request);
	}	
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>

