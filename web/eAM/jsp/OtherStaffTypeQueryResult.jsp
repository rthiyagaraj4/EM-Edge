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
		String facilityid 	= (String) session.getValue("facility_id");

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try{



	StringBuffer sql = new StringBuffer("");
	if ( (whereClause == null || whereClause.equals("")) )
	{
	String other_staff_type			= request.getParameter("StaffTypeCode")==null?"": request.getParameter("StaffTypeCode");
		String long_desc			= request.getParameter("LongDescription")==null?"":request.getParameter("LongDescription");
		String short_desc				= request.getParameter("ShortDescription")==null?"":request.getParameter("ShortDescription");
		String	 eff_status	=request.getParameter("eff_status")==null?"":request.getParameter("eff_status");
		
	

			
	if ( !(other_staff_type == null || other_staff_type.equals("")) )
		{
		other_staff_type=other_staff_type.toUpperCase();
		sql.append(" and upper(OTHER_STAFF_TYPE) like upper('"+other_staff_type+"%')  ");

		}
	

	if ( !(long_desc == null || long_desc.equals("")) )
	{
			sql.append("and  upper(LONG_DESC)  like  upper('"+long_desc+"%')  ") ;
	}
	if ( !(short_desc == null || short_desc.equals("")) )
	{

			sql.append(" and upper(SHORT_DESC)  like  upper('"+short_desc+"%')  ") ;

	}
	
	

	if ( !(eff_status == null || eff_status.equals("")) )
	{
	     if( eff_status.equals("E") )
	     {
	          sql.append(" and eff_status='E' ");
	     }
	     if ( eff_status.equals("D") )
	     {
	          sql.append("and  eff_status='D' ");
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
		sql.append(whereClause);

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

	stmt = conn.createStatement();
	int maxRecord = 0;


		

		String sqlstr1="select OTHER_STAFF_TYPE , LONG_DESC, SHORT_DESC , eff_status from AM_OTHER_STAFF_TYPE where ADDED_FACILITY_ID='"+facilityid+"'"+sql.toString()+"";

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
			out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/OtherStaffTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	//	if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/OtherStaffTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

		%>
		</tr>
		</table>
		</p>
<br><br>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th class='columnheader'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

		<% }
			
			  String classValue = "" ;
			  
			if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				  else
					classValue = "QRYODD" ;
				  

			out.println("<tr><td align=='left' class='" + classValue + "'>");
			String code = rs.getString(1);
			String longdesc=rs.getString(2);
			String shortdesc=rs.getString(3);
			String eff_status=rs.getString(4);
out.println("<a href='../../eAM/jsp/OtherStaffTypeAddModify.jsp?mode=2&OTHER_STAFF_TYPE="+code+"&LONG_DESC="+longdesc+"&SHORT_DESC="+shortdesc+"&EFF_STATUS="+eff_status+"'>");
			
			out.println(code+"</a></td><td class='" + classValue + "'>");
			out.println( rs.getString("LONG_DESC") );
			out.println("</td><td class='" + classValue + "'>");
			out.println(rs.getString("SHORT_DESC"));
			
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

