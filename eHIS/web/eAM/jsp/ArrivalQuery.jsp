<!DOCTYPE html>
<%--
	FileName	: ArrivalQuery.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  onLoad='ClearMsg()'  OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' class='CONTENT' >
<%

	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");

	//String sql ;
	StringBuffer sbQuery = new StringBuffer();
	String strsql2 = "" ;
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;
	String facilityid=(String)session.getValue("facility_id");


	if ( (whereClause == null || whereClause.equals("")) )
	{
	String transportmode    = request.getParameter("transportmode")==null ?"":request.getParameter("transportmode");
	String transportdesc    = request.getParameter("TRANS_MODE_LONG_DESC")==null ?"":request.getParameter("TRANS_MODE_LONG_DESC");
	
	String arrival_code    = request.getParameter("arrival_code")==null ?"":request.getParameter("arrival_code");
	String long_desc    = request.getParameter("ARRIVAL_LONG_DESC")==null ?"":request.getParameter("ARRIVAL_LONG_DESC");

	String enabled    = request.getParameter("eff_status")==null ?"":request.getParameter("eff_status");
	int andCheck = 0;
	transportmode=transportmode.toUpperCase();

	if ( !(transportmode == null || transportmode.equals("")) )
		{
		sbQuery.setLength(0);
		sbQuery.append("and upper(transport_mode) like upper('"+transportmode+"%')");
		andCheck = 1;
		}

	if ( !(transportdesc == null || transportdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
				sbQuery.append(" upper(TRANS_MODE_LONG_DESC)  like upper('"+transportdesc+"%') ");
		}
		else
		{		

			sbQuery.setLength(0);
				sbQuery.append("and upper(TRANS_MODE_LONG_DESC)  like upper('"+transportdesc+"%') ");
				andCheck = 1;
		}

	}

	
	if ( !(arrival_code == null || arrival_code.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sbQuery.append(" and ");
				sbQuery.append(" upper(arrival_code)  like upper('"+arrival_code+"%') ");
			}
			else
			{

				sbQuery.setLength(0);
				sbQuery.append("and upper(arrival_code)  like upper('"+arrival_code+"%') ");
				andCheck = 1;
			}
	}

if ( !(long_desc == null || long_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sbQuery.append(" and ");
				sbQuery.append(" upper(arrival_long_desc)  like upper('"+long_desc+"%') ");
			}
			else
			{
				sbQuery.setLength(0);
				sbQuery.append("and upper(arrival_long_desc)  like upper('"+long_desc+"%') ");
				andCheck = 1;
			}
	}


	if ( !(enabled == null || enabled.equals("")) )
	{
	   if ( enabled.equals("E") )
	        {
		if ( andCheck == 0 )
				{
			sbQuery.setLength(0);
			sbQuery.append("and eff_status='E'");}
		else
				{	
			sbQuery.append(" and eff_status='E'");
			}
		}
	   if ( enabled.equals("D") )
		{
		if ( andCheck == 0 ){
			sbQuery.setLength(0);
				sbQuery.append(" and  eff_status='D'");}

		else
			{
			sbQuery.append(" and eff_status='D'");
			}
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
Connection conn = ConnectionManager.getConnection(request);
Statement stmt=null;
ResultSet rset=null;
ResultSet rs=null;
int maxRecord = 0;

try{
stmt = conn.createStatement();

 strsql2="select * from am_arrival_vw  where facility_id='"+facilityid+"' "+sbQuery.toString();


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
<P>
<table align='right'>
<tr >
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/ArrivalQuery.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/ArrivalQuery.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>
</tr>
</table>
	<br><br>
</P>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.TransportMode.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="eAM.ArrivalCode.label" bundle="${am_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<% }


	  String classValue = "" ;
        if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;



	out.println("<tr><td class='" + classValue + "'>");
	String transportmode = rs.getString("transport_mode");
	String TRANS_SHORT_DESC=rs.getString("TRANS_MODE_SHORT_DESC");
	String arrival_code = rs.getString("arrival_code");
	out.println("<a href='../../eAM/jsp/addModifyArrival.jsp?transportmode="+ transportmode+"&arrival_code="+arrival_code+"&source=Modify"+"'target='f_query_add_mod' >");
	out.println(TRANS_SHORT_DESC+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("trans_mode_long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println( rs.getString("arrival_code") );
	out.println("</td><td class='" + classValue + "'>");
	out.println( rs.getString("arrival_long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("arrival_short_desc") );
	out.println("</td>");
	out.println("</td><td align='center' class='" + classValue + "'>");

	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;
		

  }//endwhile

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


}catch(Exception e){
		e.toString();
}
	finally   {
	if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();
	if(rset!=null)rset.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
<br><center>
<%--
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/ArrivalQuery.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'><img src='../../eCommon/images/previous.gif' alt='Previous' border='0'></A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/ArrivalQuery.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'><img src='../../eCommon/images/next.gif' alt='Next' border='0'></A>");
--%>
<%
rs.close();
%>

</center>
</BODY>
</HTML>

