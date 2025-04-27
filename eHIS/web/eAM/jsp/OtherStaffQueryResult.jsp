<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()' >");

	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" );
	String to = request.getParameter( "to" );
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try{



	StringBuffer sql = new StringBuffer("where a.other_staff_type = b.other_staff_type");
	if ( (whereClause == null || whereClause.equals("")) )
	{
	String cd = request.getParameter("other_staff_id").equals("") ? "":request.getParameter("other_staff_id");
	String ccd = request.getParameter("other_staff_type");
	if(ccd.equals("All")) ccd ="";
	String otherstaffname = request.getParameter("other_staff_name");
	String shortname=request.getParameter("short_name");
	String enabled = request.getParameter("eff_status");
	String Position = request.getParameter("Position");
	String empl_status = request.getParameter("empl_status");
	String all_facilities_yn = request.getParameter("all_facilities_yn");
	String reporting_facility_id = request.getParameter("reporting_facility_id");
	String NATIONAL_ID_NUM = request.getParameter("National_ID");
	String OTH_ALT_ID_NO = request.getParameter("OTHER_ALT_NO");

			
	if ( !(cd == null || cd.equals("")) )
		{
		cd=cd.toUpperCase();
		sql.append(" and upper(a.other_staff_id) like upper('"+cd+"%')");

		}
	if ( !(ccd == null || ccd.equals("")) )
	{
		sql.append(" and a.other_staff_type like  '"+ccd+"%'") ;
	}

	if ( !(Position == null || Position.equals("")) )
	{
			sql.append(" and upper(a.job_title)  like  upper('"+Position+"%') ") ;
	}

	if ( !(empl_status == null || empl_status.equals("")) )
	{
			sql.append(" and upper(a.empl_status)  like  upper('"+empl_status+"%') ") ;
	}

	if ( !(all_facilities_yn == null || all_facilities_yn.equals("")) )
	{
			sql.append(" and upper(a.all_facilities_yn)  like  upper('"+all_facilities_yn+"%') " );
	}

	if ( !(reporting_facility_id == null || reporting_facility_id.equals("")) )
	{
			sql.append(" and upper(a.reporting_facility_id)  like  upper('"+reporting_facility_id+"%') ") ;
	}
	if ( !(shortname == null || shortname.equals("")) )
	{
			sql.append(" and upper(a.short_name)  like  upper('"+shortname+"%') ") ;
	}
	if ( !(otherstaffname == null || otherstaffname.equals("")) )
	{

			sql.append(" and upper(a.other_staff_name)  like  upper('"+otherstaffname+"%') ") ;

	}
	
	if ( !(NATIONAL_ID_NUM == null || NATIONAL_ID_NUM.equals("")) )
	{
		NATIONAL_ID_NUM=NATIONAL_ID_NUM.toUpperCase();
		sql.append(" and upper(a.NATIONAL_ID_NUM) like upper('"+NATIONAL_ID_NUM+"%')");

	}

	if ( !(OTH_ALT_ID_NO == null || OTH_ALT_ID_NO.equals("")) )
	{
		OTH_ALT_ID_NO=OTH_ALT_ID_NO.toUpperCase();
		sql.append(" and upper(a.OTH_ALT_ID_NO) like upper('"+OTH_ALT_ID_NO+"%')");

	}


	if ( !(enabled == null || enabled.equals("")) )
	{
	     if( enabled.equals("E") )
	     {
	          sql.append(" and a.eff_status='E'");
	     }
	     if ( enabled.equals("D") )
	     {
	          sql.append(" and a.eff_status='D'");
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
			 {
				sql.append(ord[i]);
				sql.append(",");
			 }
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

	conn = ConnectionManager.getConnection(request);

	int maxRecord = 0;


	

	

		String sqlstr1="select a.other_staff_id, a.other_staff_name,a.short_name, a.other_staff_type, b.long_desc,b.short_desc, a.eff_date_from, a.eff_date_to, a.eff_status from am_other_staff a, am_other_staff_type b   "+ sql.toString() +"  ";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sqlstr1); 

			if ( start != 1 )
			 for( int j=1; j<start; i++,j++ )
			  rs.next() ;

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
			out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/OtherStaffQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	//	if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/OtherStaffQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

		%>
		</tr>
		</table>
		</p>
<br><br>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th class='columnheader'><fmt:message key="eAM.OtherStaffID.label" bundle="${am_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.FullName.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.StaffType.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

		<% }
			
			  String classValue = "" ;
			  
			if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				  else
					classValue = "QRYODD" ;
				  

			out.println("<tr><td align=='left' class='" + classValue + "'>");
			String code = rs.getString(1);
			String otherstaffname=rs.getString(2);
			String shortname=rs.getString(3);
			String enabled=rs.getString(4);
			String ccd=rs.getString(5);

			out.println("<a href='../../eAM/jsp/OtherStaffMain.jsp?other_staff_id="+code+"&other_staff_name="+otherstaffname+"&short_name="+shortname+"&other_staff_type="+ccd+"&eff_status="+enabled+"'>");
			
			out.println(code+"</a></td><td class='" + classValue + "'>");
			out.println( rs.getString(2) );
			out.println("</td><td class='" + classValue + "'>");
			out.println(rs.getString("short_name"));
			out.println("</td><td class='" + classValue + "'>");
			out.println(rs.getString("short_desc") );
			out.println("</td><td class='" + classValue + "'>");
			
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


		if (rs != null)   rs.close();
		if (stmt != null) stmt.close();
	
	}
	catch(Exception e)
{
	out.println(e.getMessage());
	e.printStackTrace();
}
finally {
	  if (stmt != null) stmt.close();
	  if (rs != null)   rs.close();
	  ConnectionManager.returnConnection(conn,request);
	}
	%>

</td></tr>
</table>
</center>
</BODY>
</HTML>

