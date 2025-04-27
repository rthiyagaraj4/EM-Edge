<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" %>
<% 
request.setCharacterEncoding("UTF-8");
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
</head>
<BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%	
	String whereClause = request.getParameter("whereclause");
	if( whereClause == null) whereClause="";
	String facilityid= request.getParameter("facility_id");
	if( facilityid == null) facilityid="";

	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to   = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	  if(sql.length() > 0) sql.delete(0,sql.length());
	  String prioritycode = request.getParameter("priority_code");
	  if( prioritycode == null) prioritycode="";

	  String shortdesc = request.getParameter("short_desc");
	  if( shortdesc == null) shortdesc="";

	  String enabled = request.getParameter("enabled");

		int andCheck = 0;

		if ( !(prioritycode == null || prioritycode.equals("")) )
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("where upper(priority_code) like upper('"+prioritycode+"%')");
			andCheck = 1;
		}

		if ( !(shortdesc == null || shortdesc.equals("")) )
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("where upper(short_desc) like upper('"+shortdesc+"%')");
			andCheck = 1;
		}

		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		   {
				if ( andCheck == 0 ) 
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" where eff_status='E'");
					andCheck = 1;
				}
				else
					sql.append(" and eff_status='E'");
		   }
		   if ( enabled.equals("D") )
		   {
				if ( andCheck == 0 ) 
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" where  eff_status='D'");
					andCheck = 1;
				}
				else
					sql.append(" and eff_status='D'");
		   }
		}
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
	
	try
		{
		conn = ConnectionManager.getConnection(request); 
		stmt = conn.createStatement();
		/*StringBuffer strsql1 = new StringBuffer();
		strsql1.append("select count(*) as total from IP_TRANSFER_PRIORITY "+sql.toString());
		rs = stmt.executeQuery(strsql1.toString());
		rs.next();
		maxRecord = rs.getInt("total");
		
	if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
}

	else
{*/
	StringBuffer strsql2 = new StringBuffer();
	strsql2.append("select facility_id, priority_code, long_desc, short_desc, color_code_scheme, expire_yn, expiry_period, decode(expiry_period_unit,'D','Days', 'H', 'Hours','','Hours') expiry_period_unit, eff_status from ip_transfer_priority  "+sql.toString());
		rs = stmt.executeQuery(strsql2.toString());

		 if ( start != 1 )
	 	  for( int j=1; j<start; i++,j++ )
	 	  {
	 	  	rs.next() ;
	  	  }
		  while ( i<=end && rs.next()  )
		  {
			    if (maxRecord==0)
					{
		%>
<p>
		<table align='right'>
		  <tr>
		    
<%
		     if ( !(start <= 1) )
		 	out.println("<td align ='right' id='prev'><A HREF='../../eIP/jsp/PriorityQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		    // if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eIP/jsp/PriorityQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>		    
		  </tr>
		</table>
		</p>
		<br>
		<br>

	<table border="1" width="100%" cellspacing='0' cellpadding='0' >
		<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th> 
		<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/> </th>
		<th>&nbsp;<fmt:message key="Common.Color.label" bundle="${common_labels}"/>&nbsp;</th>
 		<th>&nbsp;<fmt:message key="eIP.ExpiryRequired.label" bundle="${ip_labels}"/>&nbsp;</th> 
		<th><fmt:message key="Common.ExpiryPeriod.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eIP.ExpiryPeriodUnit.label" bundle="${ip_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

	<%
					}
 		 /* if ( start != 1 )
	 	  for( int j=1; j<start; i++,j++ )
	 	  {
	 	  	rs.next() ;
	  	  }*/
	  	  String classValue = "" ;	  
		 // while ( rs.next() && i<=end )
		 // {
			if ( i % 2 == 0 )
		  		classValue = "QRYEVEN" ;
		   	else
		  		classValue = "QRYODD" ;
		  		
		  	String priority	    = rs.getString("priority_code");
		  	String longdesc  	= rs.getString("long_desc");
		  	String shortdesc 	= rs.getString("short_desc");

			String colorscheme  = rs.getString("color_code_scheme");
			if(colorscheme == null) colorscheme = "&nbsp;";

			String expire_yn     = rs.getString("expire_yn");

			String exp_day = rs.getString("expiry_period");
			if(exp_day == null) exp_day = "&nbsp;";

			String expiry_period_unit = rs.getString("expiry_period_unit");
			if(expiry_period_unit == null) expiry_period_unit = "&nbsp;";
			String eff_status = rs.getString("eff_status");
			
	out.println("<tr><td class='" + classValue + "'>");
	out.println("<a href='../../eIP/jsp/addModifyPriority.jsp?mode=update&priority_code="+priority+"&color_scheme="+colorscheme+"&exp_status="+expire_yn+"&exp_day="+exp_day+"&days_hours="+expiry_period_unit+"&override="+eff_status+ "&long_desc="+java.net.URLEncoder.encode(longdesc)+"&short_desc="+java.net.URLEncoder.encode(shortdesc)+"&eff_status="+eff_status+"' target='f_query_add_mod' >");							
					
	out.println(priority+"</a></td><td align ='left' nowrap class='" + classValue + "'>");
	out.println(longdesc+"</a></td><td nowrap align ='left' class='" + classValue + "'>");
	out.println(shortdesc+"</a></td><td align ='left' class='" + classValue + "' ");
	out.println("STYLE='background-color:"+colorscheme+"'></a></td><td align ='center' class='" + classValue + "'>");

	if(expire_yn.equals("Y"))
		out.println("<img src='../../eCommon/images/enabled.gif'></img></td><td align='center' class='" + classValue + "'>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img></td><td align='center' class='" + classValue + "'>");

	out.println(exp_day+"</a></td><td align ='center' class='" + classValue + "'>");
	out.println(expiry_period_unit+"</a></td><td align ='center' class='" + classValue + "'>");

		
	if(eff_status.equals("E"))
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

	i++;
	maxRecord++;

	}//endwhile
//}
	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
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

}catch(Exception e){	e.toString();}
	    finally  
	    {
		if(stmt!=null)
		stmt.close();
		if(rs!=null)
		rs.close();
		//if(rset!=null)
		//rset.close();
		ConnectionManager.returnConnection(conn,request); 

	    }
%>
    </td>
   </tr>
  </table>
 </center>
 </BODY>
</HTML>

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

