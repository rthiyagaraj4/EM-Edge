<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,
java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
Connection conn = null;
Statement stmt = null ;
ResultSet rs = null ;

String sql = "" ;

try
{
	request.setCharacterEncoding("UTF-8");
	conn = ConnectionManager.getConnection(request) ;

	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY  class='CONTENT' onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>") ;

	String whereClause = request.getParameter("whereclause") ;
	String from = request.getParameter("from") ;
	String to = request.getParameter("to") ;

	stmt = conn.createStatement() ;

	if((whereClause == null || whereClause.equals("")))
	{
		String level_of_care_code = ((String)request.getParameter("level_of_care_code")).toUpperCase() ;
		String level_of_care_desc = request.getParameter("level_of_care_desc").trim() ;
		String level_of_care_indicator = request.getParameter("level_of_care_indicator") ;
		String eff_status = request.getParameter("eff_status") ;


		sql = " Where 1 = 1" ;	// All Input fields are optional so 1 = 1 is added as where clause

		if(level_of_care_indicator != null && !level_of_care_indicator.equals("") && !level_of_care_indicator.equals("All"))
			sql = sql + " And level_of_care_indicator = '" + level_of_care_indicator + "'" ;

		if(level_of_care_code != null && !level_of_care_code.equals(""))
		{
			sql = sql + " And upper(level_of_care_code) like upper('" + level_of_care_code + "%') " ;
		}

		if(level_of_care_desc != null && !level_of_care_desc.equals(""))
		{
				sql = sql + " And upper(level_of_care_desc) like upper('" + level_of_care_desc + "%') " ;
		}

		if(eff_status != null && !eff_status.equals("") && !eff_status.equals("B"))
		{
			sql = sql + " And eff_status = '"  + eff_status + "'" ;
		}


		String ord[] = request.getParameterValues("orderbycolumns");

		if(!(ord == null || ord .equals("")))
		{
			sql = sql + " Order By ";

			for(int i=0; i < ord.length; i++)
			{
				if(i == ord.length - 1)
					sql = sql + ord[i] ;
				else
					sql = sql + ord[i] + "," ;
			}
		}
	} //end of where clause IF
	else
	{
		sql = whereClause ;
	}

	int start = 0 ;
	int end = 0 ;
	int i = 1 ;

	if(from == null)
		start = 1 ;
	else
		start = Integer.parseInt(from) ;

	if(to == null)
		end = 14 ;
	else
		end = Integer.parseInt(to) ;

	int maxRecord = 0;

	String strsql1 = " Select count(*) as total From am_level_of_care " + sql ;

	rs = stmt.executeQuery(strsql1);

	rs.next();

	maxRecord = rs.getInt("total");

	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1); </script>");
   if(stmt!=null) 	stmt.close();

	String strsql2 = " Select * From am_level_of_care " + sql ;
	stmt = conn.createStatement() ;
	rs = stmt.executeQuery(strsql2);
%>

	<p>
	<table align='right'>
	<tr>
	<td>
<%
	if (!(start <= 1))
		out.println("<A HREF='../jsp/LevelofCareQueryResult.jsp?from="+(start-14)+"&to="+(end-14) + "&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if (!((start + 14) > maxRecord))
		out.println("<A HREF='../jsp/LevelofCareQueryResult.jsp?from="+(start+14)+"&to="+(end+14) + "&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
	</td>
	</tr>
	</table>
	</p>
	<br><br>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th><fmt:message key="Common.levelofcare.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.levelofcare.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%

	if(start != 1)
	{
		for(int j=1; j<start; i++, j++) 
		{
			rs.next() ;
		}
	}

	String classValue = "" ;
	String level_of_care_code = "" ;
	String level_of_care_indicator = "" ;

	while(rs.next() && i<=end)
	{
		if (i % 2 == 0)
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		out.println("<tr><td class='" + classValue + "'>");

		level_of_care_code = rs.getString("level_of_care_code");

String mod="Modify";

		out.println("<a href='../jsp/addModifyLevelofCare.jsp?level_of_care_code=" + level_of_care_code + "&Mod="+mod+"' target = 'f_query_add_mod' >");

		out.println(level_of_care_code + "</a></td><td class='" + classValue + "'>");

		out.println(rs.getString("level_of_care_desc") );
		out.println("</td><td class='" + classValue + "'>");

		level_of_care_indicator = rs.getString("level_of_care_indicator") ;

		if(level_of_care_indicator.equals("A"))
			level_of_care_indicator = "Ambulatory" ;

		if(level_of_care_indicator.equals("E"))
			level_of_care_indicator = "Emergency" ;

		if(level_of_care_indicator.equals("I"))
			level_of_care_indicator = "Isolation" ;

		if(level_of_care_indicator.equals("N"))
			level_of_care_indicator = "Intensive Care" ;

		if(level_of_care_indicator.equals("C"))
			level_of_care_indicator = "Critical Care" ;

		if(level_of_care_indicator.equals("R"))
			level_of_care_indicator = "Routine" ;
		
		if(level_of_care_indicator.equals("S"))
			level_of_care_indicator = "Surgery" ;

		out.println(level_of_care_indicator);

		out.println("</center></td><td class='" + classValue + "' align='center'>");
		
		if(rs.getString("eff_status").equals("E"))
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

		i++ ;
	}
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
%>

</td></tr>
</table>
<br><center>

<%

}catch(Exception e) {out.println("Exception " + e); }
finally
{
	try
	{
		if(stmt != null) stmt.close();
		if(rs != null) rs.close();
	}catch(Exception e){out.print("Exception in finally " + e) ; }

	ConnectionManager.returnConnection(conn,request);
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
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

