<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<%
	String facilityId = (String)session.getValue("facility_id");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'><form name='requestorResultPage' id='requestorResultPage'> ");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql  = new StringBuffer() ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	String requestorcode = "";
	String longdesc = "" ;
	String indicator = "" ;
	String enabled = "";
   
	if ( (whereClause == null || whereClause.equals("")))
	{
	
		sql.append("");
		requestorcode = request.getParameter("requestor_code");
		longdesc = request.getParameter("long_desc");
		indicator = request.getParameter("indicator");
		enabled = request.getParameter("nature");
 
	int andCheck = 0;

	
	requestorcode=requestorcode.toUpperCase();

	if ( andCheck == 0 )
		{
			sql.append("where facility_id ='"+facilityId+"'");
			andCheck = 1;
		}
	else
		sql.append( " and facility_id ='"+facilityId+"'");



	if ( !(requestorcode == null || requestorcode.equals("")) )
			{
				if ( andCheck == 1 )
				{
					sql.append( " and ");
					sql.append(" upper(requestor_code)  like  upper('"+requestorcode+"%') ");
				}
				else
				{
					sql.append("where upper(requestor_code)  like  upper('"+requestorcode+"%') ");
					//andCheck = 1;
				}
				
			}
	

		if ( !(longdesc == null || longdesc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql.append( " and ");
					sql.append( " upper(long_desc)  like  upper('"+longdesc+"%') " );
				}
				else
				{
					sql.append("where upper(long_desc) like upper('"+longdesc+"%') ") ;
					andCheck = 1;
				}
			}
		
		/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
		if ( !(indicator == null || indicator.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql.append( " and ");
					sql.append( " upper(indicator)  =  upper('"+indicator+"') " );
				}
				else
				{
					sql.append("where upper(indicator) = upper('"+indicator+"') ") ;
					andCheck = 1;
				}
			}


		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		        {
			if ( andCheck == 0 )
				sql.append("where eff_status='E'");
			else
				sql.append( " and eff_status='E'");
			}
		   if ( enabled.equals("D") )
			{
			if ( andCheck == 0 )
				sql.append(" where  eff_status='D'");
			else
				sql.append( " and eff_status='D'");
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
		conn=ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		/*String strsql1="select count(*) as total from mr_requestor "+sql.toString();

		try{
		rs = stmt.executeQuery(strsql1);
		}
		catch(SQLException e)
		{
			out.println("SQLException----"+e.getMessage());
		}
		rs.next();

		maxRecord = rs.getInt("total");

		if(maxRecord == 0)
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		*/

		String strsql2="select requestor_code, long_desc, short_desc, (select long_desc from mr_requestor_type where REQUESTOR_TYPE_CODE = mr_requestor.indicator) indicator, contact1_no, contact2_no, eff_status from mr_requestor "+sql.toString();

		rs = stmt.executeQuery(strsql2);

		if ( start != 1 )
			for( int j=1; j<start; i++,j++ ){
				 rs.next() ;
				  }

		while ( i<=end && rs.next())
		{
			if (maxRecord==0)
			{
%>
		<P>
		<table align='right'>
		<tr>

		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/RequestorQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		 
		//if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/RequestorQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
		%>
		</tr>
		</table>
		<br><br>
		</P>

		<table align='center' border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="eMR.RequestorCode.label" bundle="${mr_labels}"/></th>
		<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.contactNo.label" bundle="${common_labels}"/>&nbsp;1</th>
		<th><fmt:message key="Common.contactNo.label" bundle="${common_labels}"/>&nbsp;2</th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%
			}
 	/*if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }*/
		String classValue="";

//while ( rs.next() && i<=end )
//{


		String contact1="";
		String contact2="";

	/*	indicatorcode=rs.getString("indicator")==null?"":rs.getString("indicator");
		contact1=rs.getString("contact1_no")==null?"":rs.getString( "contact1_no" );
		contact2=rs.getString("contact2_no")==null?"":rs.getString( "contact2_no" );*/

			contact1=rs.getString("contact1_no");
			if(contact1==null) contact1="&nbsp;";

		    contact2=rs.getString("contact2_no");
			if(contact2==null) contact2="&nbsp;";

			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			String appcode="";
			out.println("<tr><td class='" + classValue + "'>");
			String code = rs.getString("requestor_code");
				appcode=code;
			
			out.println("<a href='../../eMR/jsp/RequestorFrames.jsp?requestor_code="+java.net.URLEncoder.encode(appcode) + "' target='f_query_add_mod' >");

			out.println(code+"</a></td><td class='" + classValue + "'>");
			out.println( rs.getString("long_desc") );

			out.println("</td><td class='" + classValue + "'>");
			out.println(rs.getString("short_desc") );

			out.println("</td><td class='" + classValue + "'>");
			out.println( rs.getString("indicator") );

			out.println("</td><td class='" + classValue + "'>");
			out.println(contact1);

			out.println("</td><td class='" + classValue + "'>");
			out.println(contact2);

			out.println("</td><td align='center' class='" + classValue + "'>");
			if ( rs.getString("eff_status").equals("E") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			i++;
			maxRecord++;

		}//endwhile

%>
</td></tr>
<input type='hidden' name='requestor_code' id='requestor_code' value='<%=requestorcode%>'>
<input type='hidden' name='long_desc' id='long_desc' value='<%=longdesc%>'>
<input type='hidden' name='indicator' id='indicator' value='<%=indicator%>'>
<input type='hidden' name='nature' id='nature' value='<%=enabled%>'>
</table>
<br><center>
<%

				if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}
				if ( maxRecord < 14 || (!rs.next()) )
				{
					%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='hidden';
					</script>
					<% 
				}
				else
				{%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='visible';
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



				<%
				}
//rs.close();
%>
</center>
</form>
</BODY>
</HTML>
<%
}catch(Exception e){
		e.toString();
}
	finally   {
		try
		{
	if(stmt!=null)
	stmt.close();
	if(rs!=null)
	rs.close();
	//if(rset!=null)
	//rset.close();
		}catch(Exception e){
}
	ConnectionManager.returnConnection(conn,request);
	}
	
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

