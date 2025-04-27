<!DOCTYPE html>
<%
/*
*
*	Application		:	eAM
*   File Name       :	EscortTypeQueryResult.jsp
*	
*
*	Created On		:	19-02-2005
*/
%>	
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY  class='CONTENT' onKeyDown = 'lockKey()' onLoad='ClearMsg()' onMouseDown='CodeArrest()'>
<%

request.setCharacterEncoding("UTF-8");
	String whereClause				= request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
	String from 					= request.getParameter("from") ;
	String to 						= request.getParameter("to") ;
	if ( (whereClause == null || whereClause.equals("")) )
	{
	//	 sql						= "";
		
		 String escorttype			= request.getParameter("escort_type");
		 String long_desc			= request.getParameter("long_desc");
		 String enabled				= request.getParameter("eff_status");
		 int andCheck 				= 0;
		 escorttype					= escorttype.toUpperCase();
    	 
	  if ( !(escorttype== null || escorttype.equals("")) )
	  {
				 if ( andCheck == 1 )
				{
				sbQuery.append(" and ");
				//sql 	= sql + " and ";
				sbQuery.append(" ESCORT_TYPE_CODE like '"+escorttype+"%'");
			//	sql		= sql + " ESCORT_TYPE_CODE like '"+escorttype+"%'";
				}
				else
				{
					sbQuery.setLength(0);
					sbQuery.append(" where ESCORT_TYPE_CODE like '"+escorttype+"%'");
				//	sql		= " where ESCORT_TYPE_CODE like '"+escorttype+"%'";
					andCheck =1;
				}

	 }
	 //out.println(sql);		
	 if ( !(long_desc == null || long_desc.equals("")) )
	 	 {
	 	    if ( andCheck == 1 )
	 	    {
				sbQuery.append(	" and ");
	 	         // sql = sql + " and ";
				sbQuery.append(" upper(LONG_DESC) like upper('"+long_desc+"%')" );
	 	     	//  sql = sql + " upper(LONG_DESC) like upper('"+long_desc+"%')" ;
	 	    }
	 	    else
	 	    {
				sbQuery.setLength(0);
				sbQuery.append(" where upper(LONG_DESC) like upper('"+long_desc+"%')");
				//sql = " where upper(LONG_DESC) like upper('"+long_desc+"%')" ;
				andCheck = 1;
	 	    }
	 }
	 if ( !(enabled == null || enabled.equals("")) )
	     {
   	        if ( enabled.equals("E") )
            {
				if ( andCheck == 0 ) 
				 {
					sbQuery.setLength(0);
					sbQuery.append(" where EFF_STATUS='E'");
					//sql = " where EFF_STATUS='E'";
					andCheck = 1;
				}
				else
					sbQuery.append(" and EFF_STATUS='E'");
					// sql = sql + " and EFF_STATUS='E'";
			}
   			if ( enabled.equals("D") )
			{
			  if ( andCheck == 0 ) 
			   {
					sbQuery.setLength(0);
					sbQuery.append(" where  EFF_STATUS='D'");
					//sql = " where  EFF_STATUS='D'";
					andCheck = 1; 
				}
	          else
				 sbQuery.append(" and EFF_STATUS='D'");	
				  //sql = sql + " and EFF_STATUS='D'";
	       }
   			if ( enabled.equals("B") )
   			{
   	   		} 
	    }
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sbQuery.append(" order by ");
		//sql	= sql+" order by ";

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sbQuery.append(ord[i]);
			//sql=sql+ord[i];
		else
			sbQuery.append(ord[i]+",");
			//sql=sql+ord[i]+",";
		}
	} 
	} //end of where clause IF
	else 
		{
			sbQuery.setLength(0);
			sbQuery.append(whereClause);
			//sql = whereClause;
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

		Connection con = null;
		con =  ConnectionManager.getConnection(request);
		Statement stmt=null;
		ResultSet rs=null;
		int maxRecord = 0;

	try
	{
      
	  stmt = con.createStatement();
	
	  

	  String strsql2="select * from AM_ESCORT_TYPE "+sbQuery.toString();
 	  rs = stmt.executeQuery(strsql2);

	  if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  {
	    rs.next() ;
	  }

	  while ( i<=end && rs!=null && rs.next() )
	{
		if(maxRecord==0)
		{
%>
<p>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/EscortTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

 // if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/EscortTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	
%>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader' nowrap width='10%'> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader' nowrap width='30%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader' nowrap width='30%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader' nowrap width='5%' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<% }
	
 String classValue = "" ;

	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;
	out.println("<tr><td class='" + classValue + "'>");
	String escort_type = rs.getString("escort_type_code");
	out.println("<a href='../../eAM/jsp/AddModifyEscortType.jsp?&escort_type="+escort_type+"' target='f_query_add_mod' >");
	out.println(escort_type+"</a></td><td class='" + classValue + "'>");
	String long_desc = rs.getString("long_desc");
	out.println(long_desc+"</td><td class='" + classValue + "'>");
	String short_desc = rs.getString("short_desc");
	out.println(short_desc+"</td><td align='center' class='" + classValue + "'>");
	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/disabled.gif'></img>");
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
 %>
</td></tr>
</table>
<br><center>
</center>
<%
	  
		 if(rs!=null)	rs.close();
		 if(stmt!=null)	stmt.close();

 }catch(Exception e)
     {
		//e.toString();
		//out.println(e.toString());
		e.printStackTrace();
     }
	finally   
	{
		
		 ConnectionManager.returnConnection(con,request);
    }
%>

</BODY>
</HTML>

