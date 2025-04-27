<!DOCTYPE html>
<%--
	FileName	: floorinfacilityQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	StringBuffer sql=new StringBuffer("");


	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql.setLength(0);
	sql.append(" ");

	String cd    = request.getParameter("bldng_code")==null ?"":request.getParameter("bldng_code");
	String blngdesc    = request.getParameter("bldng_desc")==null ?"":request.getParameter("bldng_desc");
	String floorcode    = request.getParameter("floor_code")==null ?"":request.getParameter("floor_code");
	String shortdesc    = request.getParameter("short_desc")==null ?"":request.getParameter("short_desc");
	String enabled    = request.getParameter("Nature")==null ?"":request.getParameter("Nature");
	String operating_facility_id = request.getParameter("operating_facility_id")==null ?"":request.getParameter("operating_facility_id");
	String operating_facility_name = request.getParameter("operating_facility_name")==null ?"":request.getParameter("operating_facility_name");


	//int andCheck = 0;

	floorcode=floorcode.toUpperCase();
	cd=cd.toUpperCase();


	if ( !(floorcode== null || floorcode.equals("")) )
			{
			sql.setLength(0);
			sql.append("AND  upper(B.floor_code) like upper('"+floorcode+"%')");
			//andCheck = 1;
			}
	if ( !(cd== null || cd.equals("")) )
			{
			sql.setLength(0);
			sql.append("AND  upper(a.bldng_code) like upper('"+cd+"%')");
			//andCheck = 1;
			}

	if ( !(operating_facility_id== null || operating_facility_id.equals("")) )
			{
			sql.setLength(0);
			sql.append(" and a.OPERATING_FACILITY_ID  like('"+operating_facility_id.toUpperCase()+"%') ");
			//andCheck = 1;
			}

	if ( !(operating_facility_name== null || operating_facility_name.equals("")) )
			{
			sql.setLength(0);
			sql.append(" and upper(c.FACILITY_name)  like upper('"+operating_facility_name+"%') ");
			//andCheck = 1;
			}
		if ( !(shortdesc == null || shortdesc.equals("")) )
			{
					sql.append(" and ");
					sql.append("  upper(B.long_desc)  like upper('"+shortdesc+"%') " );

			}

      if ( !(blngdesc== null || blngdesc.equals("")) )
	  			{
				sql.setLength(0);
	  			sql.append("AND  upper(a.long_desc)   like upper('"+blngdesc+"%') ");
	  			//andCheck = 1;
			}

		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )

				sql.append(" and B.eff_status='E'");

		   if ( enabled.equals("D") )

				sql.append(" and B.eff_status='D'");

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
//ResultSet rset=null;
ResultSet rs=null;
int maxRecord = 0;

try{
stmt = conn.createStatement();


String strsql2="Select  A.long_desc, B.short_desc,B.long_desc long_desc_floor,B.floor_code,B.bldng_code,B.EFF_STATUS,b.operating_facility_id,c.facility_name  from am_bldng A,am_bldng_floor B,  sm_facility_param C where A.bldng_code=B.bldng_code  and  a.operating_facility_id = b.operating_facility_id  and c.facility_id=b.OPERATING_FACILITY_ID  "+sql;  //modified by Srinivas for IN:34525
if(rs!=null)rs.close();

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
try{
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/floorinfacilityQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/floorinfacilityQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
}
catch(Exception e){}
%>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.building.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.building.label" bundle="${common_labels}"/><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.FloorCode.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<% }
 
	  String classValue = "" ;
	String code = rs.getString("bldng_code");
	String floorcode = rs.getString("floor_code");
	String facility_id =rs.getString("operating_facility_id");
	String facility_name =rs.getString("facility_name");


if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
	out.println("<a href='../../eAM/jsp/addModifyfloorinfacility.jsp?fac_id="+facility_id+"&bldng_code="+code+"&floor_code="+ floorcode +"&facility_name="+facility_name+"&operating_facility_id="+java.net.URLEncoder.encode(facility_id)+"' target='f_query_add_mod' >");
	out.println(facility_id+"</a></td><td class='" + classValue + "'>");
	out.println(facility_name+"</td><td class='" + classValue + "'>");
	out.println("<a href='../../eAM/jsp/addModifyfloorinfacility.jsp?fac_id="+facility_id+"&bldng_code="+code+"&floor_code="+ floorcode +"&facility_name="+facility_name+"&operating_facility_id="+java.net.URLEncoder.encode(facility_id)+"' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println(rs.getString(1) +"</td><td class='" + classValue + "' >");
	out.println(floorcode+"</td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc_floor") ); //modified by Srinivas for IN:34525
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString(2) );
	out.println("</td><td class='" + classValue + "' align='center' >");

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
//		out.print(e.toString());
e.printStackTrace();
}
	finally   {
		try
		{
	if(rs!=null) 	rs.close();
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

