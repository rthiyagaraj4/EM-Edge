<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></head><BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  class='CONTENT'>");
request.setCharacterEncoding("UTF-8");	
	String whereClause = request.getParameter("whereclause");
	String sql ="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String rangeType = "";
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String enabled = "";
	String longdesc = "";
	String cd = "";
	if (facilityId == null) facilityId = "";
	int andCheck = 0;
	if ( (whereClause == null || whereClause.equals("")) )
	{
	
	cd = request.getParameter("range_id");
	cd = cd.toUpperCase();
	longdesc = request.getParameter("long_desc");
	longdesc = longdesc.toUpperCase();
	rangeType = request.getParameter("range_type");
	enabled = request.getParameter("nature");

	if ( !(cd == null || cd.equals("")) )
		{
		sql =sql+" where range_id like '"+cd+"%'";
		andCheck = 1;
		}


	if ( !(longdesc == null || longdesc.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql = sql + " and upper(long_desc) like  '"+longdesc+"%'" ;
			}
			else
			{
				sql =sql+" where upper(long_desc) like '"+longdesc+"%'" ;
				andCheck = 1;
			}
	}

	if ( !(rangeType == null || rangeType.equals("")) )
	{
			if ( rangeType.equals("A") )
	        {
				if ( andCheck == 1 )
					sql =sql+" and range_type ='A'";
				else
					sql = sql + " where range_type  ='A'";
			}
		   if ( rangeType.equals("W") )
		   {
				if ( andCheck == 1 )
					sql =sql+" and range_type ='W'";
				else
					sql = sql + " where range_type  ='W'";
		   }
	}

	if ( !(enabled == null || enabled.equals("")) )
	{
	   if ( enabled.equals("E") )
        {
			if ( andCheck == 1 )
				sql =sql+" and  eff_status='E'";
			else
				sql = sql + " where eff_status='E'";
		}
	   if ( enabled.equals("D") )
	   {
			if ( andCheck == 1 )
				sql =sql+" and eff_status='D'";
			else
				sql = sql + " where eff_status='D'";
	   }
	}

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
	} //end of where clause IF
	else
		sql = whereClause;

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
		end = Integer.parseInt(to) ;

Connection conn = null;
Statement stmt=null;
ResultSet rs=null;

try{

conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
int maxRecord = 0;


rs = stmt.executeQuery("select * from am_summ_range "+sql);

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
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/queryAgeRange.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/queryAgeRange.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
</P>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<td class='columnheader'><fmt:message key="eAM.RangeID.label" bundle="${am_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="eAM.RangeType.label" bundle="${am_labels}"/></td>
<!--<th >Effective From</th>
<th >Effective To</th>-->
<td class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

<% }
 	

	  String classValue = "" ;

	if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("range_id");
	String facility="";
	String type= rs.getString("range_type");

	// if ( rs.getString("eff_status").equals("E") )

	out.println("<a href='../../eAM/jsp/addModifyAgeRangeMain.jsp?range_id="+ code +"&facility_id="+facility+"&range_type="+type+"' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class=\"" + classValue + "\">");
	out.println(rs.getString("short_desc") );
	out.println("</td><td class=\"" + classValue + "\">");



	//out.println(rs.getString("range_type") );
	if (rs.getString("range_type").equals("A"))
	   	out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels"));

	if (rs.getString("range_type").equals("W"))
	   	out.println( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weight.label","common_labels") );



	out.println("</td><!--<td class='" + classValue + "'>-->");

	out.println("<td class='" + classValue + "' align='center'>");

	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;
} 

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
<br>
<%
}
catch ( Exception e ){}

finally{

	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;
	ConnectionManager.returnConnection(conn,request);

	}



%>

</BODY>
</HTML>

