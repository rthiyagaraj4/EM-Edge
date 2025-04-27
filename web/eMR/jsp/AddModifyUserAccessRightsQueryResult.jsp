<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>




<%

request.setCharacterEncoding("UTF-8");
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

String whereClause = request.getParameter("whereclause");

StringBuffer sql = new StringBuffer();
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;

   if ( (whereClause == null || whereClause.equals("")) )
     {
	sql.append("");
	String facility_id 	= request.getParameter("facility_id");
	String facility_name    = request.getParameter("facility_name");
	String appl_user_id     =request.getParameter("appl_user_id");
	String appl_user_name   =request.getParameter("appl_user_name");
	int andCheck = 0;

	if ( !(facility_id == null || facility_id.equals("")) )
		{
		sql.append( "where upper(facility_id) like upper('"+facility_id+"%') ");
		andCheck = 1;
		}

	if ( !(facility_name == null || facility_name.equals("")) )
	   {
		if ( andCheck == 1 )
		{	sql.append( " and ");
			sql.append(" upper(facility_name)  like   upper('"+facility_name+"%') ") ;
		}
		else
		{
			sql.append("where upper(facility_name)  like upper('"+facility_name+"%')  " );
			andCheck = 1;
		}
	 }

	if ( !(appl_user_id == null || appl_user_id.equals("")) )
	   {
		if ( andCheck == 1 )
		{	sql.append( " and ");
			sql.append( "appl_user_id like  upper('"+appl_user_id+"%') " );
		}
		else
		{
			sql.append("where appl_user_id like upper('"+appl_user_id+"%') " );
			andCheck = 1;
		}
	 }

	if ( !(appl_user_name == null || appl_user_name.equals("")) )
	   {
		if ( andCheck == 1 )
		{	sql.append( " and ");
			sql.append( " upper(appl_user_name)  like  upper('"+appl_user_name+"%')  " );
		}
		else
		{
			sql.append("where upper(appl_user_name)  like  upper('"+appl_user_name+"%' ) " );
			andCheck = 1;
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
      } //end of where clause IF
	else{
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
	Statement stmt = null;
	ResultSet rs = null;
	try{
		conn=ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		int maxRecord = 0;
/*String strsql1="select count(*) as total from MR_USER_ACCESS_TRN_VW "+sql.toString();

ResultSet rs = stmt.executeQuery(strsql1);
rs.next();
maxRecord = rs.getInt("total");

if(maxRecord == 0)
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
*/
		String strsql2="select * from MR_USER_ACCESS_TRN_VW "+sql.toString();

//if(rs != null) rs.close();
		rs = stmt.executeQuery(strsql2);

		if ( start != 1 )
		for( int j=1; j<start; i++,j++ ){
			rs.next() ;
		}

		while ( i<=end && rs.next())
	   {
			if (maxRecord==0)
				{
		%>

		<p>
		<table align='right'>
		<tr>
		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'  ><A HREF='../../eMR/jsp/AddModifyUserAccessRightsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		//if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden' ><A HREF='../../eMR/jsp/AddModifyUserAccessRightsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

		%>
		
		</tr>
		</table>
		<br><br>
		</p>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.username.label" bundle="${common_labels}"/></th>

<%
				}
	/*if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
		rs.next() ;
	  }*/
	  String classValue = "" ;

	//while ( rs.next() && i<=end )
	  // {
	        if ( i % 2 == 0 )
			  	classValue = "QRYEVEN" ;
			  else
			  	classValue = "QRYODD" ;


		out.println("<tr><td class='" + classValue + "'>");
		String facilityid = rs.getString("facility_id");
		String facilityname=rs.getString("facility_name");
		String appluserid=rs.getString("appl_user_id");
		String applusername=rs.getString("appl_user_name");

		out.println("<a href=\"../../eMR/jsp/AddModifyUserAccessRights.jsp?facility_id="+ facilityid +"&facility_name="+facilityname+"&appl_user_id="+appluserid+"&appl_user_name="+URLEncoder.encode(applusername)+"&source=modify "+"\"target='f_query_add_mod' >");
		out.println(facilityid+"</a></td><td class='" + classValue + "'>");

		//out.println("<a href=\"../../eMR/jsp/AddModifyUserAccessRights.jsp?facility_id="+ facilityid +"&facility_name="+facilityname+"&appl_user_id="+appluserid+"&appl_user_name="+applusername+"&source=modify "+"\"target='f_query_add_mod' >");
		out.println( rs.getString("facility_name") );
		out.println("</td><td class='" + classValue + "'>");

		out.println("<a href=\"../../eMR/jsp/AddModifyUserAccessRights.jsp?facility_id="+ facilityid +"&facility_name="+facilityname+"&appl_user_id="+appluserid+"&appl_user_name="+URLEncoder.encode(applusername)+"&source=modify "+"\"target='f_query_add_mod' >");
		out.println( rs.getString("appl_user_id") );
		out.println("</a></td><td class='" + classValue + "'>");


		//out.println("<a href=\"../../eMR/jsp/AddModifyUserAccessRights.jsp?facility_id="+ facilityid +"&facility_name="+facilityname+"&appl_user_id="+appluserid+"&appl_user_name="+applusername+"&source=modify "+"\"target='f_query_add_mod' >");
		out.println( rs.getString("appl_user_name") );
		out.println("</td><td class='" + classValue + "'>");
		i++;
		maxRecord++;
	   }	   
%>

</td></tr>
</table>
<br><center>
<%
//rs.close();

%>

</center>
</BODY>
</HTML>
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
	{%>
		<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
		</script>
	<%
	}
	sql.setLength(0);
}catch(Exception e)
{}
finally
{
    try
	{
		if(rs != null)rs.close();
		if(stmt != null)stmt.close();
	
	}
	catch(Exception e)
{}

	ConnectionManager.returnConnection(conn,request);}
%>
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

