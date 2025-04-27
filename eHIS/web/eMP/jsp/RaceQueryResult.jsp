<!DOCTYPE html>
<%--
/**
  *
  * @filename RaceQueryResult.jsp
  * @version 3.0 updated on 2/18/2005
  */
--%>
<%@ page import ="webbeans.eCommon.ConnectionManager, java.sql.*, java.net.URLEncoder, java.util.ArrayList" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>
<HTML>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
	</head>
	<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
//	String sql ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) ){
//	sql = "";
		String cd = request.getParameter("RACE_CODE");
		cd = cd.toUpperCase();
		String longdesc = request.getParameter("LONG_DESC");
		longdesc = longdesc.toUpperCase();
		String enabled = request.getParameter("nature");

		int andCheck = 0;

		if ( !(cd == null || cd.equals("")) ){
			sbQuery.append("where RACE_CODE like '");
			sbQuery.append(cd);
			sbQuery.append("%'");
//			sql = "where RACE_CODE like '"+cd+"%'";
			andCheck = 1;
		}
		if ( !(longdesc == null || longdesc.equals("")) ){
			if ( andCheck == 1 ){	
				sbQuery.append(" and ");
				sbQuery.append("upper(LONG_DESC) like  '");
				sbQuery.append(longdesc);
				sbQuery.append("%'");
//				sql = sql + " and ";
//				sql = sql + "upper(LONG_DESC) like  '"+longdesc+"%'" ;
			}else	{
				sbQuery.setLength(0);
				sbQuery.append("where upper(LONG_DESC) like  '");
				sbQuery.append(longdesc);
				sbQuery.append("%'");
//				sql = "where upper(LONG_DESC) like '"+longdesc+"%'" ;
//				andCheck = 1;
			}
		}
		if ( !(enabled == null || enabled.equals("")) ){
/*			if ( enabled.equals("D") ){
				if ( andCheck == 0 ){
					sql = " where  EFF_STATUS='D'";
		        }else{
		           sql = sql + " and EFF_STATUS='D'";
				}
		   }
		   if ( enabled.equals("E") ){
				if ( andCheck == 0 )
				   sql = "where EFF_STATUS='E'";
				else
			  	   sql = sql + " and EFF_STATUS='E'";
		   }
*/
			//Added by Sabarinathan S on 2/17/2005
			String strEffStatus="";
			if(enabled.equals("E"))
				strEffStatus="E";
			else if(enabled.equals("D"))
				strEffStatus="D";
			
			if(andCheck == 0 ){
				sbQuery.setLength(0);
				sbQuery.append("where eff_status='"+strEffStatus+"'");
			}else{
				sbQuery.append(" and eff_status='"+strEffStatus+"'");
			}

		   if ( enabled.equals("B") ){
   				//out.println(sql );	
				//sql = sql; //nothing is added to get both E and D
				//Added on 2/18/2005
				sbQuery.setLength(0);
				sbQuery.append("where eff_status='E' or eff_status='D'");
		   }
		}

	//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord.equals("")) ){
			sbQuery.append(" order by ");
//			sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);
//					sql=sql+ord[i];
				}else{
					sbQuery.append(ord[i]);
					sbQuery.append(",");
//					sql=sql+ord[i]+",";
				}
			}
		}
	} //end of where clause IF
	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
//		sql = whereClause;
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

//Connection conn = (Connection) session.getValue( "connection" ) ;

	Connection conn = null;

	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int maxRecord = 0;
	try{
		conn = ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement("select count(*) as total from mp_race "+sbQuery.toString());
		rs = pstmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();

		if (maxRecord==0) 				
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

		pstmt =conn.prepareStatement("select * from mp_race "+sbQuery.toString()); 
		rs = pstmt.executeQuery();
%>

<P>
<table align='right'>
<tr>
<td>
<%
		if ( !(start <= 1) )
			out.println("<A HREF='../../eMP/jsp/RaceQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

		if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/RaceQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
	<BR><BR>
</P>

<center>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<!--th>Effective From</th>
<th>Effective To</th-->
<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
			  rs.next() ;
		 String classValue = "" ;

		while ( rs.next() && i<=end ){
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			out.println("<tr><td align='left' class='" + classValue + "'>");
			String code = rs.getString("RACE_CODE");
			out.println("<a href='../../eMP/jsp/RaceModify.jsp?RACE_CODE="+ code + "' target='f_query_add_mod' >");
			out.println(code+"</a></td><td class='" + classValue + "'>");
			out.println( rs.getString("LONG_DESC") );
			out.println("</td><td class='" + classValue + "'>");
			out.println(rs.getString("SHORT_DESC") );
			out.println("</td><td class='" + classValue +
				"' align='center'>");

			/*if ( rs.getDate("eff_date_from") != null )
			{
			 java.util.Date date = rs.getDate("eff_date_from");
			 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			 String dateString = formatter.format(date);
			 out.println(dateString);
			 dateString = null;
			 formatter = null;
			}
			else
			{
				 out.println("&nbsp;");
			}
			out.println("</td><td class='" + classValue + "'>");

			if ( rs.getDate("eff_date_to") != null )
			{
			 java.util.Date date1 = rs.getDate("eff_date_to");
			 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			 String dateString = formatter.format(date1);
			 out.println(dateString);
			}
			else
			{
					out.println("&nbsp;");
			}
			out.println("</td><td align='center' class='" + classValue + "'>");
		*/
			if ( rs.getString("eff_status").equals("E") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			i++;
		} %>

</td></tr>
</table>
</center>

<br><center>
<!--%
if ( !(start <= 1) )
	out.println("<A HREF='/eCIS/mp/jsp/queryOccupationClass.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='/eCIS/common/images/previous.gif' alt='Previous' border='0'></A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='/eCIS/mp/jsp/queryOccupationClass.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='/eCIS/common/images/next.gif' alt='Next' border='0'></A>");
	-->
<%
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
	}catch(Exception e) { 
		out.println(e.toString());
		e.printStackTrace();
	}finally{
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>

</center>
</BODY>
</HTML>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

