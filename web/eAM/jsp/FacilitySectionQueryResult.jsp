<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.net.*,java.text.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()'  class='CONTENT' onKeyDown = 'lockKey()' >");

	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");

	StringBuffer sql=new StringBuffer();
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql.setLength(0);
	String facilityid 	= request.getParameter("operating_facility_id");	
	if(facilityid==null) facilityid="";
	
	String facilityname 	= request.getParameter("facility_name");
	if(facilityname==null) facilityname="";

		
	String deptcode 	= request.getParameter("dept_code");
	if(deptcode==null) deptcode="";
	
	String deptdesc 	= request.getParameter("dept_short_desc");	
	if(deptdesc==null) deptdesc="";
	
	String sectioncode	= request.getParameter("section_code");
	if(sectioncode==null) sectioncode="";
	
	String sectiondesc	= request.getParameter("section_short_desc");	
	if(sectiondesc==null) sectiondesc="";
	
	String enabled          = request.getParameter("nature");
	if(enabled==null) enabled="";
	

	int andCheck = 0;

	facilityid=facilityid.toUpperCase();
	
	if ( !(facilityid == null || facilityid.equals("")) )
	{
		sql.setLength(0);
		sql.append("where operating_facility_id like '"+facilityid+"%'");
		andCheck = 1;
	}
	
	if ( !(facilityname == null || facilityname.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and ");
			sql.append("upper(facility_name) like  upper('"+facilityname+"%') " );
		}
		else
		{
			sql.setLength(0);
			sql.append("where upper(facility_name) like upper('"+facilityname+"%')");
			andCheck = 1;
		}
	}
	
	if ( !(deptcode == null || deptcode.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and ");
			sql.append("upper(dept_code) like  upper('"+deptcode+"%')");
		}
		else
		{
			sql.setLength(0);
			sql.append("where upper(dept_code) like upper('"+deptcode+"%')");
			andCheck = 1;
		}
	}
	if ( !(deptdesc == null || deptdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and ");
			sql.append("upper(dept_short_desc)  like  upper('"+deptdesc+"%')");
		}
		else
		{
			sql.setLength(0);
			sql.append("where upper( dept_short_desc) like  upper('"+deptdesc+"%')");
			andCheck = 1;
		}
	}	
	
	
	if ( !(sectioncode == null || sectioncode.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and ");
			sql.append("upper(section_code) like  upper('"+sectioncode+"%')");
		}
		else
		{
			sql.setLength(0);
			sql.append("where upper(section_code) like upper('"+sectioncode+"%')");
			andCheck = 1;
		}
	}
	if ( !(sectiondesc == null || sectiondesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and ");
			sql.append("upper(section_short_desc) like  upper('"+sectiondesc+"%')");
		}
		else
		{
			sql.setLength(0);
			sql.append(" where upper(section_short_desc)  like upper( '"+sectiondesc+"%')");
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
} //end of where clause IF
	else {
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

Connection conn = null;
Statement stmt=null;
//ResultSet rset=null;
ResultSet rs=null;
int maxRecord = 0;

try{
conn = ConnectionManager.getConnection(request);
if(stmt!=null) 	stmt.close();
String strsql2="select * from am_facility_section_vw "+sql.toString();

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
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/FacilitySectionQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/FacilitySectionQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>
</tr>
</table>
</p>
<br>
<br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='Columnheader'><fmt:message key="Common.facility.label" bundle="${common_labels}"/><fmt:message key="Common.identification.label" bundle="${common_labels}"/> </th>
<th class='Columnheader'><fmt:message key="Common.facility.label" bundle="${common_labels}"/> <fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
<th class='Columnheader'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th> 
<th class='Columnheader'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th class='Columnheader'><fmt:message key="Common.Section.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='Columnheader'><fmt:message key="Common.Section.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th class='Columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<% }

	  String classValue = "" ;
	  
       if ( i % 2 == 0 )
	  	classValue = "QRYEVEN" ;
	  else
	  	classValue = "QRYODD" ;
	  


	out.println("<tr><td class='" + classValue + "' >");
	String fac_id 	= rs.getString("operating_facility_id");
	String dept_cd	= rs.getString("dept_code");
	String sect_cd 	= rs.getString("section_code");	
	
	out.println("<a href='../../eAM/jsp/addModifyFacilitySection.jsp?operating_facility_id="+fac_id+"&dept_code="+dept_cd+"&section_code="+sect_cd+"' target='f_query_add_mod' >");
	out.println(fac_id+"</a></td><td class='" + classValue + "' >");
	
	out.println(rs.getString("facility_name")+"</td><td class='" + classValue + "' >");

	out.println(rs.getString("dept_code")+"</td><td class='" + classValue + "' >");
	
	out.println(rs.getString("dept_short_desc")+"</td><td class='" + classValue + "' >");

	out.println(rs.getString("section_code")+"</td><td class='" + classValue + "' >");
	
	out.println(rs.getString("section_short_desc")+"</td class='" + classValue + "' >");
	
	out.println("<td align='center' class='" + classValue + "' >");
		
	String stat=rs.getString("eff_status");

	if ( stat.equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;
  }//endwhile

 if(maxRecord == 0)
		{ %>
			 <script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<% }

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

  if(rs!=null) 	rs.close();
  if(stmt!=null) stmt.close();
}catch(Exception e){
		e.toString();
}
	finally   {
	if(rs!=null) 	rs.close();
	if(stmt!=null) 	stmt.close();
	ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
<br><center>
<!--%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/FacilitySectionqueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/previous.gif' alt='Previous' border='0'></A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/FacilitySectionqueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='../../eCommon/images/next.gif' alt='Next' border='0'></A>");
rs.close();
%-->
</center>
</BODY>
</HTML>

