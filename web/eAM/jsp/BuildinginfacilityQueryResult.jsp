<!DOCTYPE html>

<%--
	FileName	: addModifyBuildinginfacility.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' class='CONTENT' >
<%
	request.setCharacterEncoding("UTF-8");
	String strsql2="";
	StringBuffer sql=new StringBuffer("");
	//String strsql1=" ";

	String whereClause = request.getParameter("whereclause");

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int andCheck = 0;

	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql.setLength(0);
		sql.append(" ");
		String bldngcode    = request.getParameter("bldng_code")==null ?"":request.getParameter("bldng_code");
		String longdesc    = request.getParameter("long_desc")==null ?"":request.getParameter("long_desc");
		String enabled    = request.getParameter("nature")==null ?"":request.getParameter("nature");
		String operating_facility_id = request.getParameter("operating_facility_id")==null ?"":request.getParameter("operating_facility_id");
		String fname = request.getParameter("facility_name");
		if(fname==null) fname = "";

		if ( !(fname == null || fname.equals("")) )
		{
		   sql.setLength(0);
		   sql.append("where upper(facility_name)  like upper('"+fname+"%') ");
		   andCheck = 1;
		}

		if ( !(operating_facility_id == null || operating_facility_id.equals("")) )
		{
				operating_facility_id=operating_facility_id.toUpperCase();
				 if ( andCheck == 1 )
				 {
				sql.append(" and upper(operating_facility_id) like upper('"+operating_facility_id+"%')  ");
				}
				else
				{
				sql.append(" where upper(operating_facility_id) like upper('"+operating_facility_id+"%')  ");
				andCheck = 1;
				}
		}

			if ( !(bldngcode == null || bldngcode.equals("")) )
			{
					bldngcode=bldngcode.toUpperCase();
					 if ( andCheck == 1 )
					 {
					sql.append(" and upper(bldng_code) like upper('"+bldngcode+"%')  ");
					}
					else
					{
					sql.append(" where upper(bldng_code) like upper('"+bldngcode+"%')  ");
					andCheck = 1;
					}
			}

			if ( !(longdesc == null || longdesc.equals("")) )
			{
					if ( andCheck == 1 )
					{
					sql.append(" and upper(BLDNG_LONG_DESC)  like  upper('"+longdesc+"%')  ");
					}
					else
					{
					sql.append(" where upper(BLDNG_LONG_DESC)  like  upper('"+longdesc+"%')  ");
					andCheck = 1;
					}
			}

		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		   {
			if ( andCheck == 0 )
			   {
				sql.setLength(0);
				sql.append("where eff_status='E'");
			   }
			else
				sql.append(" and eff_status='E'");
		    }
		    if ( enabled.equals("D") )
		    {
			if ( andCheck == 0 )
				{
				sql.setLength(0);
				sql.append(" where  eff_status='D'");
				}
			else
				sql.append(" and eff_status='D'");
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

	}// end if whereClause
	else
	{
		sql.setLength(0);
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

Connection conn = ConnectionManager.getConnection(request);
Statement stmt=null;
ResultSet rset=null;
ResultSet rs=null;
int maxRecord = 0;

try
{	
	//String facilityId = (String) session.getValue( "facility_id" ) ;
	stmt = conn.createStatement();


	strsql2="select * from am_bldng_vw  "+  sql;
	//out.println(" strsql2 " + strsql2 );

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
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/BuildinginfacilityQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/BuildinginfacilityQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
</P>
<br><br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

	<% }
		
 String classValue = "",operating_facility_id="" ;
		
		String bcode = rs.getString("bldng_code");
		String facility_name=rs.getString("facility_name");
		operating_facility_id = rs.getString("operating_facility_id");
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

			out.println("<tr><td class='" + classValue + "'>");
			out.println("<a href='../../eAM/jsp/addModifyBuildinginfacility.jsp?bldng_code="+ bcode + "&facility_name="+facility_name+"&operating_facility_id="+operating_facility_id+"' target='f_query_add_mod' >");
			out.println(rs.getString(1));
			out.println("</a></td><td class='" + classValue + "'>");
			out.println(rs.getString("FACILITY_NAME"));
			out.println("</td><td class='" + classValue + "'>");
			out.println("<a href='../../eAM/jsp/addModifyBuildinginfacility.jsp?bldng_code="+ bcode + "&facility_name="+facility_name+"&operating_facility_id="+operating_facility_id+"' target='f_query_add_mod' >");
			out.println(bcode+"</a></td><td class='" + classValue + "'>");
			out.println( rs.getString("BLDNG_LONG_DESC"));
			out.println("</td><td class='" + classValue + "'>");
			out.println(rs.getString("BLDNG_SHORT_DESC"));
			out.println("</td><td class='" + classValue + "'align='center' >");

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

}//end of try
catch(Exception e){
		//out.println(e.toString());
		e.printStackTrace();
}
finally {
	try
	{
	if(rs!=null)	rs.close();
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
	}
	catch(Exception e)
	{}
	ConnectionManager.returnConnection(conn,request);
}
%>

</td></tr>
</table>
<br>
</BODY>
</HTML>

