<!DOCTYPE html>
<%--
	FileName	: DeptforroomQueryResult.jsp
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
<BODY OnMouseDown='CodeArrest()'   class='CONTENT' onKeyDown = 'lockKey()' >
<%
	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");

	StringBuffer sql=new StringBuffer("");
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql.setLength(0);
		sql.append("");

		String cd    = request.getParameter("room_num")==null ?"":request.getParameter("room_num");
		String roomshortdesc    = request.getParameter("room_short_desc")==null ?"":request.getParameter("room_short_desc");
		String deptshortdesc    = request.getParameter("dept_short_desc")==null ?"":request.getParameter("dept_short_desc");
		String serviceshortdesc    = request.getParameter("service_short_desc")==null ?"":request.getParameter("service_short_desc");
		String deptcode    = request.getParameter("dept_code")==null ?"":request.getParameter("dept_code");
		String servicecode    = request.getParameter("service_code")==null ?"":request.getParameter("service_code");
		String facility_id    = request.getParameter("facility_id")==null ?"":request.getParameter("facility_id");
		String facility_name    = request.getParameter("facility_name")==null ?"":request.getParameter("facility_name");

		if ( !(facility_id == null || facility_id.equals("")) )
		{
				sql.append(" and upper(OPERATING_FACILITY_ID)  like upper('"+facility_id.toUpperCase()+"%') ");
		}

		if ( !(facility_name == null || facility_name.equals("")) )
		{
				sql.append(" and upper(b.facility_name)  like upper('"+facility_name+"%') ");
		}


		if ( !(cd == null || cd.equals("")) )
			{
				cd=cd.toUpperCase();
				sql.setLength(0);
				sql.append(" and upper(room_num) like upper('"+cd+"%')");
			}

		if ( !(roomshortdesc == null || roomshortdesc.equals("")) )
		{
		   		sql.append(" and upper(room_short_desc)  like upper('"+roomshortdesc+"%') ");
		}

		if ( !(deptshortdesc == null || deptshortdesc.equals("")) )
		{
			   	sql.append(" and upper(dept_short_desc)  like  upper('"+deptshortdesc+"%') " );
		}

		if ( !(deptcode == null || deptcode.equals("")) )
		{
		   		sql.append(" and upper(dept_code) like  upper('"+deptcode+"%')" );
		}

		if ( !(servicecode == null || servicecode.equals("")) )
		{
		   		sql.append( " and upper(service_code) like  upper('"+servicecode+"%')") ;
		}

		if ( !(serviceshortdesc == null || serviceshortdesc.equals("")) )
		{
		   		sql.append( " and upper(service_short_desc)  like  upper('"+serviceshortdesc+"%') " );
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

Statement stmt=null;
//ResultSet rset=null;
ResultSet rs=null;
Connection conn = null;
int maxRecord = 0;
try{
conn = ConnectionManager.getConnection(request);
//String facilityId = (String) session.getValue("facility_id");


String strsql2="select * from am_dept_for_facility_room_vw a,sm_facility_param b  where a.operating_facility_id=b.facility_id  " + sql;
stmt = conn.createStatement();
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
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/DeptforroomQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/DeptforroomQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>
</td>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.room.label" bundle="${common_labels}"/><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></th>

<%}
 	
	  String classValue = "" ;

       if ( i % 2 == 0 )
       	  	classValue = "QRYEVEN" ;
       	  else
       	  	classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
	String roomnum = rs.getString("room_num");
	String roomshortdesc = rs.getString("room_short_desc");
	String dc=rs.getString("dept_code");
	String ofid=rs.getString("operating_facility_id");
	String scode=rs.getString("service_code");
	String sdesc=rs.getString("service_short_desc");
	String facName=rs.getString("facility_name");

	out.println("<a href='../../eAM/jsp/addmodifyDeptforroom.jsp?room_num="+roomnum+ "&dept_code="+ dc + "&operating_facility_id="+ ofid+ "&facility_name="+java.net.URLEncoder.encode(facName)+"&operating_facility_id="+ofid+"'target='f_query_add_mod' >");
	out.println(ofid+"</a></td><td class='" + classValue + "'>");
	out.println(facName+"</td><td class='" + classValue + "'>");
	out.println("<a href='../../eAM/jsp/addmodifyDeptforroom.jsp?room_num="+roomnum+ "&dept_code="+ dc + "&operating_facility_id="+ ofid+ "&facility_name="+java.net.URLEncoder.encode(facName)+"&operating_facility_id="+ofid+"'target='f_query_add_mod' >");
	out.println(roomnum+"</a></td><td class='" + classValue + "'>");
	//out.println("<a href='../../eAM/jsp/addmodifyDeptforroom.jsp?room_num="+roomnum+ "&dept_code="+ dc + "&operating_facility_id="+ ofid+ "'target='f_query_add_mod' >");
	out.println(roomshortdesc+"</td><td class='" + classValue + "'>");
	out.println( rs.getString("dept_code") );
	out.println("</td><td class='" + classValue + "'>");
	out.println( rs.getString("dept_short_desc") );
	out.println("</td><td class='" + classValue + "'>");
	if (scode == null ) scode ="&nbsp"; // service can be null
	out.println(scode);
	out.println("</td><td class='" + classValue + "'>");
	if (sdesc == null ) sdesc ="&nbsp";
	out.println(sdesc);
	out.println("</td><td class='" + classValue + "'>");

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

  if(rs!=null)	rs.close();
  if(stmt!=null)	stmt.close();
}//end of try
catch(Exception e){
		out.print(e.toString());
}
	finally   {
		try
		{
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		}
		catch(Exception e)
		{}
		ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
<br><center>
<!--%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/DeptforroomQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/previous.gif' alt='Previous' border='0'></A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/DeptforroomQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/next.gif' alt='Next' border='0'></A>");
rs.close();
%-->

</center>
</BODY>
</HTML>

