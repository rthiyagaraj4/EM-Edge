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
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()'  class='CONTENT' onKeyDown = 'lockKey()'><form name='Facility_dept_query' id='Facility_dept_query'>");

	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");

	StringBuffer sql=new StringBuffer("");
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql.setLength(0);
		sql.append("");

		String fid = request.getParameter("operating_facility_id");
		if(fid==null) fid = "";

		String fname = request.getParameter("facility_name");
		if(fname==null) fname = "";

		String deptcode = request.getParameter("dept_code");
		if(deptcode==null) deptcode = "";

		String deptdesc = request.getParameter("dept_short_desc");
		if(deptdesc==null) deptdesc = "";

		String enabled = request.getParameter("enabled");
		if(enabled==null) enabled = "";


		int andCheck = 0;

		fid=fid.toUpperCase();
		deptcode=deptcode.toUpperCase();

		if ( !(fname == null || fname.equals("")) )
		{
			sql.setLength(0);
		   sql.append("where upper(facility_name)  like upper('"+fname+"%') ");
		   andCheck = 1;
		}
		if ( !(fid == null || fid.equals("")) )
				{
				   if ( andCheck == 1 )
				   {
				   	sql.append(" and ");
				   	 sql.append("operating_facility_id like  '"+fid+"%'") ;
				   }
				   else
				   {
					   sql.setLength(0);
					sql.append("where operating_facility_id like '"+fid+"%'");
					andCheck = 1;
				   }
		}

		if ( !(deptcode == null || deptcode.equals("")) )
				{
				   if ( andCheck == 1 )
				   {

				   	sql.append(" and ");
				   	 sql.append("upper(dept_code) like  upper('"+deptcode+"%')") ;
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
		   	 sql.append(" upper(dept_short_desc)  like  upper('"+deptdesc+"%')");
		   }
		   else
		   {
			   sql.setLength(0);
			sql.append("where upper(dept_short_desc)  like upper('"+deptdesc+"%') ");
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
Connection conn=null;
int maxRecord = 0;
try{
conn = ConnectionManager.getConnection(request);



String strsql2="select * from am_facility_dept_vw "+sql.toString();
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
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/FacilityDeptQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/FacilityDeptQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>
</tr>
</table>
</p>
<br>
<br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<% }
 	
	  String classValue = "" ;
	  
       if ( i % 2 == 0 )
       	  	classValue = "QRYEVEN" ;
       	  else
       	  	classValue = "QRYODD" ;
       	  


	out.println("<tr><td class='" + classValue + "'>");
	String ofid = rs.getString("operating_facility_id");
	String name = rs.getString("facility_name");
	String dc = rs.getString("dept_code");
	String dept = rs.getString("dept_short_desc");

	out.println(ofid+"</a></td><td class='" + classValue + "'>");

	out.println(name+"</td><td class='" + classValue + "'>");

	out.println(dc+"</td><td class='" + classValue + "'>");

	out.println(dept+"</td class='" + classValue + "'><td align='center' class='" + classValue + "'>");

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

  if(rs!=null) 	rs.close();
  if(stmt!=null) stmt.close();
}// end of try
catch(Exception e){
//		out.print(e.toString());
e.printStackTrace();
}
	finally   {
	if(rs!=null) 	rs.close();
	if(stmt!=null) 	stmt.close();
	ConnectionManager.returnConnection(conn,request);
}
%>

</td></tr>
</table>
<br>
</BODY>
</HTML>

