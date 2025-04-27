<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></head><BODY   class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>");

	String whereClause = request.getParameter("whereclause");

	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to   = request.getParameter( "to" ) ;
	
	if ( (whereClause == null || whereClause.equals("")) )
	{
	  if(sql.length() > 0) sql.delete(0,sql.length());
	  String reasonforstaycode = request.getParameter("reason_for_stay_code");
	  String longdesc = request.getParameter("long_desc");
	  String enabled = request.getParameter("nature");
	  int andCheck = 0;

	  reasonforstaycode=reasonforstaycode.toUpperCase();
	  
	  if ( !(reasonforstaycode == null || reasonforstaycode.equals("")) )
	   {
		sql.append("where upper(reason_for_stay_code) like upper('"+reasonforstaycode+"%')");
		andCheck = 1;
	   }
	
	  if ( !(longdesc == null || longdesc.equals("")) )
	   {
	      if ( andCheck == 1 )
	       {	sql.append(" and ");
	        	sql.append("upper(long_desc) like  upper('"+longdesc+"%')" );
	       }
	       else
	       {
				if(sql.length() > 0) sql.delete(0,sql.length());
	        	sql.append("where upper(long_desc) like upper('"+longdesc+"%')" );
	         	andCheck = 1;
	       }
	   }

	  if ( !(enabled == null || enabled.equals("")) )
	   {
	      if ( enabled.equals("E") )
	       {
	 	if ( andCheck == 0 )
			   {
				 if(sql.length() > 0) sql.delete(0,sql.length());
	    	     sql.append("where eff_status='E'");
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
	ResultSet rs=null;
	int maxRecord = 0;

	try{
		conn = ConnectionManager.getConnection(request); 
		stmt = conn.createStatement();
		/*
		StringBuffer strsql1 = new StringBuffer();
		strsql1.append("select count(*) as total from ip_reason_for_lodger_stay "+sql.toString());
		rs = stmt.executeQuery(strsql1.toString());
		rs.next();
		maxRecord = rs.getInt("total");
	if(rs!=null) rs.close();
	if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
}else{*/
		StringBuffer strsql2 = new StringBuffer();
		strsql2.append("select * from ip_reason_for_lodger_stay "+sql.toString());
		rs = stmt.executeQuery(strsql2.toString());

		 if ( start != 1 )
	 	  for( int j=1; j<start; i++,j++ )
	 	  {
	 	  	rs.next() ;
	  	  }

		  while ( i<=end && rs.next() )
		  {
			  if (maxRecord==0)
					{
%>

<p>
		<table align='right'>
		  <tr>
		   
<%
		     if ( !(start <= 1) )
		 	out.println("<td align ='right' id='prev'><A HREF='../../eIP/jsp/LodgerStayReasonQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		     //if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eIP/jsp/LodgerStayReasonQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>		    
		  </tr>
		</table>
		</p>
		<br>
		<br>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		  <th><fmt:message key="eIP.ReasonforStay.label" bundle="${ip_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	 	  <th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		  <th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		  <th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%
					}
 		 /* if ( start != 1 )
	 	  for( int j=1; j<start; i++,j++ )
	 	  {
	 	  	rs.next() ;
	  	  }*/
	  		String classValue = "" ;	  
		  //while ( rs.next() && i<=end )
		  //{
	 	   	if ( i % 2 == 0 )
		  		classValue = "QRYEVEN" ;
		   	else
		  		classValue = "QRYODD" ;
		  		
		  	String reasonforstaycode= rs.getString("reason_for_stay_code");
		  	String longdesc  	= rs.getString("long_desc");
		  	String shortdesc 	= rs.getString("short_desc");
		  	String effstatus 	= rs.getString("eff_status");
		  	
		  	out.println("<tr><td class='" + classValue + "'>");
		   			   	
		   	out.println("<a href='../../eIP/jsp/AddModifyLodgerstayReason.jsp?reason_for_stay_code="+ reasonforstaycode + "&long_desc="+java.net.URLEncoder.encode(longdesc)+"&short_desc="+java.net.URLEncoder.encode(shortdesc)+"&eff_status="+effstatus+"' target='f_query_add_mod' >");		   	
		   	out.println(reasonforstaycode+"</a></td><td class='" + classValue + "'>");
		   	
		   			   	
			out.println(longdesc+"</td><td class='" + classValue + "'>");
			
			out.println(shortdesc+"</td><td align ='center' class='" + classValue + "'>");
		   			   	
		   	if ( rs.getString("eff_status").equals("E") )
		   		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		   	else
				out.println("<img src ='../../eCommon/images/RRnwd.gif'></img>");
		   	i++;
			maxRecord++;

  		  }//endwhile
	//if(rs!=null) rs.close();
	//if(stmt!=null) stmt.close();
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
		ConnectionManager.returnConnection(conn,request); 
	    }
%>
	   </td>
	 </tr>
      </table>
<%
     // rs.close();
%>

</center>
</BODY>
</HTML>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
	}
%>

