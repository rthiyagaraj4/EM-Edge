<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
    request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	</head>
	<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
//	String sql ;									// will be deleted once code walkthrough is done
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
//		sql = "";
		String cong_anomalies_code = request.getParameter("cong_anomalies_code");
		cong_anomalies_code = cong_anomalies_code.toUpperCase();
		String longdesc = request.getParameter("long_desc");
		if (longdesc==null) longdesc="";
		longdesc = longdesc.toUpperCase();

		String enabled = request.getParameter("nature");

		int andCheck = 0;

		if ( !(cong_anomalies_code == null || cong_anomalies_code.equals("")) )
		{
			andCheck=1;
			sbQuery.append("  upper(a.cong_anomalies_code) like '");
			sbQuery.append(cong_anomalies_code);
			sbQuery.append("%'");
//			sql = "  a.cong_anomalies_code like '"+cong_anomalies_code+"%'";
		}
		if ( !(longdesc == null || longdesc.equals("")) )
		{
			if(andCheck==1)		{
				sbQuery.append(" and ");
//				sql = sql+ " and ";	
			}
			sbQuery.append("upper(a.long_desc) like  '");
			sbQuery.append(longdesc);
			sbQuery.append("%'" );
//			sql = sql + "upper(a.long_desc) like  '"+longdesc+"%'" ;
			andCheck=1;
		}
		
		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E"))
		   {				
				if(andCheck==1)	{
					sbQuery.append(" and ");
//					sql = sql+ " and ";
				}
				sbQuery.append(" a.eff_status='E'");
//				sql = sql + " a.eff_status='E'";
				andCheck=1;
		   }
		   if ( enabled.equals("D") )
			{
				if(andCheck==1)	{
					sbQuery.append(" and ");
//					sql = sql+ " and ";
				}
				sbQuery.append(" a.eff_status='D'");
//				sql = sql + " a.eff_status='D'";
				andCheck=1;
			}
		}

		if(andCheck==1)
		{
			sbQuery.insert(0," where   ");
//			sql = " where   " + sql;
		}
		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null || ord .equals("")) )
		{
			sbQuery.append(" order by ");
//			sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);
//					sql=sql+ord[i];
				}else{
					sbQuery.append(ord[i]);
					sbQuery.append(",");
//					sql=sql+ord[i]+",";
				}
			}
		}
	} //end of where clause IF
	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
//		sql = whereClause;
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


//Connection conn = (Connection) session.getValue( "connection" ) ;
Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rs=null;
//int maxRecord = 0;
try{
	conn = ConnectionManager.getConnection(request);
	/*	pstmt = conn.prepareStatement("select count(*) as total from MP_CONGENITAL_ANOMALIES a    "+sbQuery.toString());
		
		rs = pstmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
	if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/

		pstmt = conn.prepareStatement("select a.cong_anomalies_code, a.long_desc ,a.short_desc, a.eff_status from MP_CONGENITAL_ANOMALIES a  "+sbQuery.toString());
		rs = pstmt.executeQuery();

%>



<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  	  String classValue = "" ;
		  int cnt=0;

while ( i<=end && rs.next())
{
	if(cnt==0)
	{%>
		<P>
		<table align='right'>
		<tr>

		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/queryCongenitalAnomalies.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			%>
				<td align ='right' id='next' style='visibility:hidden'>
			<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/queryCongenitalAnomalies.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
			<BR><BR>
		</P>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%	}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
			classValue = "QRYODD" ;

	out.println("<tr><td align='left' class='" + classValue + "'>");
	String cong_anomalies_code = rs.getString("cong_anomalies_code");
	// if ( rs.getString("eff_status").equals("E") )
	out.println("<a href='../../eMP/jsp/CongenitalAnomaliesModify.jsp?cong_anomalies_code="+ cong_anomalies_code + "' target='f_query_add_mod' >");
	out.println(cong_anomalies_code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_desc") );
	out.println("</td><td align='center' class='" + classValue + "'>");

	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	cnt++;
}   

	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 14 || (!rs.next()) ) {
	%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='hidden';
		</script>
	<% flag = true;
			} else {%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}%>

</td></tr>
</table>
<br><center>
<%
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
}catch(Exception e) { 
	out.println(e.toString());
	e.printStackTrace();
}finally{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
</center>
</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

