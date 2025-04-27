<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*" %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<BODY  class='CONTENT' onKeyDown = 'lockKey()' onLoad='ClearMsg()'; OnMouseDown='CodeArrest()'>

<%
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

try{
	conn = ConnectionManager.getConnection(request);

	String whereClause = request.getParameter("whereclause");

		StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;



	stmt = conn.createStatement();

	if ( (whereClause == null || whereClause.equals("")) )
	{
	
	String manufacturer_id=request.getParameter("manufacturer_id");
	String long_name = request.getParameter("long_name");
	String enabled = request.getParameter("eff_status");
	
	int andCheck = 0;

	if ( !(manufacturer_id == null || manufacturer_id.equals("")) )
		{
		sbQuery.append("where  upper(manufacturer_id) like upper('"+manufacturer_id+"%')");
		andCheck = 1;
		}

	if ( !(long_name == null || long_name.equals("")) )
	   {
		if ( andCheck == 1 )

		{	
			sbQuery.append(" and ");
			sbQuery.append("upper(long_name) like  upper('"+long_name+"%')" );
		}
		else
		{
			sbQuery.setLength(0);
				sbQuery.append("where upper(long_name) like upper('"+long_name+"%')");
			andCheck = 1;
		}
	 }


	if ( !(enabled == null || enabled.equals("")) )
	{
	   if ( enabled.equals("E") )
	        {
		if ( andCheck == 0 ) {
			sbQuery.setLength(0);
			sbQuery.append("where eff_status='E'");
			andCheck = 1; }
		else
			sbQuery.append( " and eff_status='E'");
		}
	   if ( enabled.equals("D") )
		{
		if ( andCheck == 0 ) {
			sbQuery.setLength(0);
			sbQuery.append(" where  eff_status='D'");
			andCheck = 1; }
		else
			sbQuery.append(" and eff_status='D'");
		}
	   if ( enabled.equals("B") )
	   	{

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
			sbQuery.append(ord[i]);
		else
			sbQuery.append(ord[i]+",");
		}
	}
	} //end of where clause IF
	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);

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



int maxRecord = 0;



String strsql2="select * from am_manufacturer "+sbQuery.toString();
rs = stmt.executeQuery(strsql2);

if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }

	  while ( i<=end && rs.next() )
	{
		  if(maxRecord==0)
		{
%>

<p>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../jsp/ManufacturerQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/ManufacturerQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>
</tr>
</table>
</p>
<br>
<br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<td class='columnheader'><fmt:message key="Common.ManufacturerID.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.longname.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
<% }

	  String classValue = "" ;

        if ( i % 2 == 0 )
		  classValue = "QRYEVEN" ;
	else
		  classValue = "QRYODD" ;


	out.println("<tr><td class='" + classValue + "'>");
	String manufact_id = rs.getString("manufacturer_id");
	out.println("<a href='../jsp/addModifyManufacturer.jsp?operation=modify&manufacturer_id="+ manufact_id + "' target='f_query_add_mod' >");

	out.println(manufact_id+"</a></td><td class='" + classValue + "'>");


	out.println(rs.getString("long_name") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_name") );
	out.println("</td><td align='center' class='" + classValue + "'>");

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
%>
</td></tr>
</table>
<br><center>

<%
rs.close();
	if (rs != null)   rs.close();
	if (stmt != null)   stmt.close();
}catch(Exception e) {
	//out.println("main try"+e);
	e.printStackTrace();
}
finally
{
	
	ConnectionManager.returnConnection(conn,request);
}
%>

</center>
</BODY>
</HTML>

