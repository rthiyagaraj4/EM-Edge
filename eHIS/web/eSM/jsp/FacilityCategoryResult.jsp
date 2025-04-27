<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' class='CONTENT' >
<%
	request.setCharacterEncoding("UTF-8");	
	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	StringBuffer sbQuery = new StringBuffer();

if ( (whereClause == null || whereClause.equals("")) )
	{
		String facility_category_code = request.getParameter("facility_level_code");
		String longdesc = request.getParameter("long_desc");
		String enabled = request.getParameter("nature");
		int andCheck = 0;
		

	if ( !(facility_category_code == null || facility_category_code.equals("")) )
		{
			sbQuery.append("where upper(facility_level_code) like upper('"+facility_category_code+"%')");
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
				if ( andCheck == 0 )
				{	sbQuery.setLength(0);
					sbQuery.append("where eff_status='E'");}
				else
				{		
				sbQuery.append(" and eff_status='E'");}
		}
	   if ( enabled.equals("D") )
		{

		if ( andCheck == 0 )
			{	sbQuery.setLength(0);
			sbQuery.append("where  eff_status='D'");}
		else

			{	sbQuery.append(" and eff_status='D'");}

		}
	   if ( enabled.equals("B") )
	   	{
		}
	}


	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");
	if ( !(ord == null || ord .equals("")) )
	{
		sbQuery.append("order by ");
		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sbQuery.append(ord[i]);
		else
			sbQuery.append(ord[i]+",");
		}
	}
	} //end of where clause IF
	else
	{sbQuery.setLength(0);	
		sbQuery.append(whereClause);}

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

		Connection conn = ConnectionManager.getConnection(request);
		ResultSet rs=null;
		Statement stmt=null;
		int maxRecord = 0;



try{
	
	stmt = conn.createStatement();

	String sql="select facility_level_code,long_desc,short_desc,eff_Status from sm_facility_level "+sbQuery.toString();
	rs = stmt.executeQuery(sql);

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
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eSM/jsp/FacilityCategoryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eSM/jsp/FacilityCategoryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>

</tr>
</table>
</P>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<td class='columnheader'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

<% }
 	

	  String classValue = "" ;

	if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
		classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("facility_level_code");
	out.println("<a href='../../eSM/jsp/AddModifyFacilityCategory.jsp?function_name=modify&facility_category_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_desc") );
	out.println("</td>");
	
	out.println("<td align='center' class='" + classValue + "'>");

	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;
}//end of while 

if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='visible';
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%}
%>

</td></tr>
</table>
<br><center>
<% 
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
}catch(Exception e) { out.println(e.toString());}
finally
{
	
	ConnectionManager.returnConnection(conn,request);
}

%>
</center>
</BODY>
</HTML>



