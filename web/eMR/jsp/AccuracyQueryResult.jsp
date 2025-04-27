<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script language=JavaScript src="../../eCommon/js/common.js"></script>
	

<%
	
    String whereClause = request.getParameter("whereclause");
	String sql="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String qryWhere = "";

	if (whereClause == null || whereClause.equals(""))
		{
			String qry_accuracy_code = request.getParameter("Accuracy_code").equals("") ? "":request.getParameter("Accuracy_code");
			String qry_long_desc = request.getParameter("Accuracy_Longdesc").equals("") ? "":request.getParameter("Accuracy_Longdesc");
			String qry_indicator = request.getParameter("Indicator").equals("") ? "":request.getParameter("Indicator");
     		String qry_Enabled = request.getParameter("eff_status_yn").equals("") ? "":request.getParameter("eff_status_yn");

			qry_accuracy_code = qry_accuracy_code +"%";
			qry_long_desc  =   qry_long_desc +"%";
			qry_indicator  =   qry_indicator +"%";
			qry_Enabled = qry_Enabled + "%";
			
			qryWhere = "where upper(accuracy_code) like upper('"+qry_accuracy_code+"')  and upper(long_desc) like upper('"+qry_long_desc+"') and upper(accuracy_indicator) like upper('"+qry_indicator+"') and upper(eff_status) like upper('"+qry_Enabled+"')";


			sql = qryWhere;
			//appending order by clause
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
	else
			sql = whereClause;
		
			String accuracy_code="";
			String short_desc  = "";
			String long_desc = "";
			//String indicator="";
			String eff_status = "";
			String indicator_desc="";
			
			Connection conn = null;
			Statement stmt=null;
			ResultSet rs=null;
			int maxRecord = 0;
			try{
					conn = ConnectionManager.getConnection(request);
					//stmt = conn.createStatement();
					//String sqlCount = "select count(*) from mr_accuracy "+ sql;

					String accuracySelectSql = "select accuracy_code,long_desc,short_desc,accuracy_indicator,eff_status,decode(accuracy_indicator,'C','Certain','U','Uncertain') indicator_desc from mr_accuracy "+ sql;

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

		
/*rs = stmt.executeQuery(sqlCount);
if(rs.next())
{
	maxRecord = rs.getInt(1);
}
if(rs != null) rs.close();
if(stmt!=null) 	stmt.close();	
	if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");

*/

					stmt = conn.createStatement();
					rs = stmt.executeQuery(accuracySelectSql);

					if ( start != 1 )
					 for( int j=1; j<start; i++,j++ )
					 {
						rs.next() ;
					 }

					 while ( i<=end && rs.next())
						{
							if (maxRecord==0)
								{

%>
					<P>
					<table align='right'>
					<tr>
					<%
					if ( !(start <= 1) )
						out.println("<td align ='right' id='prev'  ><A HREF='../../eMR/jsp/AccuracyQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

					//if ( !( (start+14) > maxRecord ) )
						out.println("<td align ='right' id='next' style='visibility:hidden' ><A HREF='../../eMR/jsp/AccuracyQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
					%>
					</tr>
					</table>
					</P>
					<br><br>
					<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
					<table border="1" width="100%" cellspacing='0' cellpadding='0'>
						
					<tr>
						<th ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
						<th ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
						<th ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
						<th ><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></th>
						<th ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
					</tr>
					
					
	<%
								}
					String classValue = "" ;
					//stmt = conn.createStatement();
					//rs = stmt.executeQuery(accuracySelectSql);

	/*if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		 {
			rs.next() ;
		 }*/
	//while ( rs.next() && i<=end)
	//{

						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						accuracy_code = rs.getString("accuracy_code")==null ? "":rs.getString("accuracy_code");
						short_desc  = rs.getString("short_desc")==null ? "":rs.getString("short_desc");
						long_desc = rs.getString("long_desc")==null ? "":rs.getString("long_desc");
						//indicator = rs.getString("accuracy_indicator")==null ? "":rs.getString("accuracy_indicator");
						eff_status = rs.getString("eff_status")==null ? "D":rs.getString("eff_status");
						indicator_desc=rs.getString("indicator_desc")==null?"":rs.getString("indicator_desc");
	%>
						<tr>
							<td align="left" class=<%=classValue%>><a href="../../eMR/jsp/AccuracyAddModify.jsp?mode=2&accuracy_code=<%=accuracy_code%>"><%=accuracy_code%></a>
							</td>
							<td align="left" class=<%=classValue%>><%=long_desc%></td>
							<td align="left" class=<%=classValue%>><%=short_desc%></td>
							<td align="left" class=<%=classValue%>><%=indicator_desc%></td>
							<% if(eff_status.equals("E")){%>
								<td align="center" class=<%=classValue%>><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
								<%}else{%>
								<td align="center" class=<%=classValue%>><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
								<%}%>
						</tr>
	
<%						i++;
						maxRecord++;
						}

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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



						<%
						}

  //if(rs!=null) 	rs.close();
  //if(stmt!=null) stmt.close();
  %>
	  </table>
<%
}catch(Exception e)
{
	//out.println(e.getMessage());
	e.printStackTrace();
}
finally {
	  if (stmt != null) stmt.close();
	  if (rs != null)   rs.close();
	  ConnectionManager.returnConnection(conn,request);
	}
%>

</BODY>
</HTML>
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

