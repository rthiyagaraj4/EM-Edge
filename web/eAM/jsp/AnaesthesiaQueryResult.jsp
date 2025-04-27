<!DOCTYPE html>
<!-- 
	FileName	: AnaesthesiaQueryResult.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
-->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*" 
contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()'>

<%
	request.setCharacterEncoding("UTF-8");
	String whereclause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer("");
	String from = request.getParameter("from");
	String to = request.getParameter("to");

	if((whereclause == null || whereclause.equals("")))
	{
		String anaesthesiaCode = request.getParameter("anaesthesia_code");
		String long_desc = request.getParameter("LONG_DESC");
		String enabled = request.getParameter("eff_status");
		int andCheck = 0;

		if(!(anaesthesiaCode==null||anaesthesiaCode.equals("")))
		{
			sql.append(" where upper(anaesthesia_code) like upper('"+anaesthesiaCode+"%')");
			andCheck = 1;
		}

		if(!(long_desc==null || long_desc.equals("")))
		{
			if(andCheck==1)
			{
				sql.append(" and");
				sql.append(" upper(LONG_DESC) like upper('"+long_desc+"%')");
			}else
				{
					sql.append(" where upper(LONG_DESC) like upper('"+long_desc+"%')");
					andCheck=1;
				}
		}

		if(!(enabled==null || enabled.equals("")))
		{
			if(enabled.equals("E"))
			{
				if(andCheck==0)
				{
					sql.append(" where eff_status='E'");
					andCheck=1;
				}else
					sql.append(" and eff_status='E'");
			}

			if(enabled.equals("D"))
			{
				if(andCheck==0)
				{
					sql.append(" where eff_status='D'");
					andCheck=1;
				}else
					sql.append(" and eff_status='D'");
			}

		}

		//appending orderby clause

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
	else 
		{
			sql.append(whereclause);
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

	    Connection con =null;
		Statement stmt=null;
		ResultSet rs=null;
		int maxRecord = 0;


	try
	{
      con = ConnectionManager.getConnection(request);
	  stmt = con.createStatement();
 
	  
	  String strsql2 = "select * from am_anaesthesia"+sql;
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
		
	<!-- <script>
		if (parseInt('<%=maxRecord%>')== 0)
		{
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
			history.go(-1);
			//parent.frames[1]. location.href ="../../eAM/jsp/AnaesthesiaQueryCriteria.jsp" ;
		}
	</script> -->

	<p>
	<table align='right'>
	<tr>
<%

	if ( !(start <= 1) )
		out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/AnaesthesiaQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	//if ( !( (start+14) > maxRecord ) )
		out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/AnaesthesiaQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>"); 
	
%>
	</tr>
	</table>
	</p>
	<br><br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th class='columnheader' nowrap width='5%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th class='columnheader' nowrap width='52%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th class='columnheader' nowrap width='33%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
	<th class='columnheader' nowrap width='30%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<% }
	
		String classValue = "" ;

			if ( i % 2 == 0 )
		  		classValue = "QRYEVEN" ;
			else
		  		classValue = "QRYODD" ;

			String anaesthesia_code = rs.getString("ANAESTHESIA_CODE");
			String long_desc = rs.getString("LONG_DESC");
			String short_desc = rs.getString("SHORT_DESC");

			out.println("<tr><td class='" + classValue + "'>");
			out.println("<a href='../../eAM/jsp/addModifyAnaesthesia.jsp?anaesthesia_code="+anaesthesia_code+"' target='f_query_add_mod' >");
			out.println(anaesthesia_code+"</a></td><td align='left' class='" + classValue + "'>");
			out.println(long_desc+"</td><td align='left' class='" + classValue + "'>");
			out.println(short_desc+"</td><td align='left' class='" + classValue + "'>");
			if ( rs.getString("EFF_STATUS").equals("E") )
				out.println("<div align='center'><img src='../../eCommon/images/enabled.gif'></img></div>");
			else
				out.println("<div align='center'><img src='../../eCommon/images/disabled.gif'></img></div>");
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

			if(rs!=null) rs.close();
			if(stmt!=null)	stmt.close();
 	}catch(Exception e){
		//out.println("Exception raised :"+e.toString());
		e.printStackTrace();
	}
	 finally
	 {
		
			ConnectionManager.returnConnection(con,request);
	 }

%>
  	      </td></tr>	
		</table>
	</BODY>
</HTML>

