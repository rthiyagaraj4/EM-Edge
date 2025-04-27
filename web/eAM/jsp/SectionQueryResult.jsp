<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head>
<BODY OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' class='CONTENT' >

<%
	
request.setCharacterEncoding("UTF-8");	

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer("");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	sql.setLength(0);	

	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql.setLength(0);

	String dept_cd 		= request.getParameter("dept_code");
	if(dept_cd==null) dept_cd = "";

	String long_desc1 	= request.getParameter("long_desc1");
	if(long_desc1==null) long_desc1 = "";
	
	String sect_cd  	= request.getParameter("section_code");
	if(sect_cd==null) sect_cd = "";

	String long_desc2 	= request.getParameter("long_desc2");	
	if(long_desc2==null) long_desc2 = "";
	
	String enabled 		= request.getParameter("eff_status");
	if(enabled==null) enabled = "";

	String facilityid	=(String)session.getValue("facility_id");
	if(facilityid==null) facilityid = "";

	int andCheck 		= 0;
	dept_cd			=dept_cd.toUpperCase();
	sect_cd 		=sect_cd.toUpperCase();	

	if ( !(dept_cd == null || dept_cd.equals("")) )
	{
		sql.setLength(0);
		sql.append("where upper(dept_code) like upper('"+dept_cd+"%')");
		andCheck = 1;
	}
	
	if ( !(sect_cd == null || sect_cd.equals("")) )
	{
		sql.setLength(0);
		sql.append("where upper(section_code)  like upper('"+sect_cd+"%')");
		andCheck = 1;
	}	

	if ( !(long_desc1 == null || long_desc1.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sql.append(" and ");
				sql.append(" upper(dept_long_desc)  like  upper('"+long_desc1+"%') ") ;
			}
			else
			{
				sql.setLength(0);
				sql.append("where upper(dept_long_desc)  like upper('"+long_desc1+"%') ");
				andCheck = 1;
			}
	}

	if ( !(long_desc2 == null || long_desc2.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(section_long_desc)  like  upper('"+long_desc2+"%') " );
			}
			else
			{
				sql.setLength(0);
				sql.append("where upper(section_long_desc)  like upper('"+long_desc2+"%') ");
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

	if ( !(ord == null || ord.equals("")) )
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

Connection conn =null ;
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;

try{
	conn  = ConnectionManager.getConnection(request);
	String strsql2="select * from am_dept_section_vw "+sql;
	stmt = conn.createStatement();

	rs = stmt.executeQuery(strsql2);

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }
	
	
	
while ( i<=end && rs.next() )
	{
	if(maxRecord == 0)
		{
%>

<P>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/SectionQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/SectionQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>
</tr>
</table>
</p>
<br>
<br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>

<th class='columnheader'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.Section.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
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
	String dept_cd = rs.getString("dept_code");
	String sect_cd = rs.getString("section_code");	
	String dept_desc = rs.getString("dept_short_desc");
	out.println("<a href='../../eAM/jsp/AddModifySection.jsp?dept_code="+dept_cd+"&section_code="+sect_cd+"' target='f_query_add_mod' >");
	out.println(dept_cd+"</a></td><td class='" + classValue + "'>");	


	out.println(dept_desc+"</td><td class='" + classValue + "'>");	
	

	out.println(sect_cd+"</td><td class='" + classValue + "'>");
	out.println(rs.getString("section_long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("section_short_desc") );
	out.println("</td class='" + classValue + "'>");

	out.println("<td align='center' class='" + classValue + "'>");

	if ( rs.getString("eff_status").equals("E") )
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

  if(rs!=null) 		rs.close();
  if(stmt!=null) 		stmt.close();
}// end of try
catch(Exception e){
		e.toString();
}
	finally   {
	if(stmt!=null) 		stmt.close();
	if(rs!=null) 		rs.close();
	ConnectionManager.returnConnection(conn,request);	
	}
%>

</td></tr>
</table>
<br>
</BODY>
</HTML>

