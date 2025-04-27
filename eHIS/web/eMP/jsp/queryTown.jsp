<!DOCTYPE html>
<%--
/**
  *
  * @filename queryTown.jsp
  * @version 3.0 updated on 2/19/2005
  */
--%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<HTML>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	</head>
	<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
	//int divcnt = 2;
	//String nextrecord ="N";
	//String prevflg =request.getParameter( "prevflg" );
	//if(prevflg == null)
	//prevflg="true";
//	String sql ;									// will be deleted once code walkthrough is done
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

		
	if ( (whereClause == null || whereClause.equals("")) )	{
//	sql = "";
	String cd = request.getParameter("res_town_code");
	cd = cd.toUpperCase();
	String longdesc = request.getParameter("a.long_desc");
	longdesc = longdesc.toUpperCase();
	String area_cd = request.getParameter("a.res_area_code");
	area_cd = area_cd.toUpperCase();
	String area_longdesc = request.getParameter("area_long_desc");
	area_longdesc = area_longdesc.toUpperCase();
	String shortdesc = request.getParameter("a.short_desc");
	if (shortdesc==null) shortdesc="";
			shortdesc = shortdesc.toUpperCase();
	String enabled = request.getParameter("nature");

	//int andCheck = 0;

	if ( !(cd == null || cd.equals("")) )
	{
		sbQuery.append(" and a.res_town_code like '");
		sbQuery.append(cd);
		sbQuery.append("%'");
//		sql = " and a.res_town_code like '"+cd+"%'";
	}
	if ( !(longdesc == null || longdesc.equals("")) )
	{
		sbQuery.append(" and ");
		sbQuery.append("upper(a.long_desc) like  '");
		sbQuery.append(longdesc);
		sbQuery.append("%'" );
//		sql = sql + " and ";
//		sql = sql + "upper(a.long_desc) like  '"+longdesc+"%'" ;
	}
	if ( !(area_cd == null || area_cd.equals("")) )
	{
		sbQuery.setLength(0);
		sbQuery.append(" and a.res_area_code like '");
		sbQuery.append(area_cd);
		sbQuery.append("%'");
//		sql = " and a.res_area_code like '"+area_cd+"%'";
	}
	if ( !(area_longdesc == null || area_longdesc.equals("")) )
	{
		sbQuery.append(" and ");
		sbQuery.append(" a.res_area_code in (select res_area_code from mp_res_area where upper(long_desc) like  '");
		sbQuery.append(area_longdesc);
		sbQuery.append("%')");

//		sql = sql + " and ";
//		sql = sql + " a.res_area_code in (select res_area_code from mp_res_area where upper(short_desc) like  '"+area_longdesc+"%')" ;
	}
	if ( !(shortdesc == null || shortdesc.equals("")) )
	{
		sbQuery.append(" and ");
		sbQuery.append(" a.short_desc like  '");
		sbQuery.append(shortdesc);
		sbQuery.append("%'");
//		sql = sql + " and ";
//		sql = sql + " a.short_desc like  '"+shortdesc+"%'" ;
	}
	if ( !(enabled == null || enabled.equals("")) )
	{
	   if ( enabled.equals("E") ){
		   sbQuery.append(" and a.eff_status='E'");
//			sql = sql + " and a.eff_status='E'";
	   }
	   if ( enabled.equals("D") ){
		   sbQuery.append(" and a.eff_status='D'");
//			sql = sql + " and a.eff_status='D'";
	   }
	}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
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

Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rs=null;
//int maxRecord = 0;
try{
	conn = ConnectionManager.getConnection(request);

	/*pstmt = conn.prepareStatement("select count(*) as total from mp_res_town a, mp_res_area b where a.res_area_code = b.res_area_code "+sbQuery.toString());

	rs = pstmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();

if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/
	
	pstmt = conn.prepareStatement("SELECT  res_town_code, a.long_desc town_long_desc, a.short_desc town_short_desc,a.res_area_code town_area_code,b.long_desc area_short_desc,b.res_area_code,a.eff_status town_eff_status FROM mp_res_town a , mp_res_area b WHERE a.RES_AREA_CODE = b.RES_AREA_CODE(+) "+sbQuery.toString());
	
	rs = pstmt.executeQuery();

%>



<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  	  String classValue = "" ;
		  int cnt=0;

while (i<=end && rs.next())
{
	if(cnt==0)
	{%>
		<P>
		<table align='right'>
		<tr>

		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/queryTown.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		%>
			<td align ='right' id='next' style='visibility:hidden'>
		<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/queryTown.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
			<BR><BR>
		</P>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th width='10%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th width='25%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th width='25%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th width='10%'><fmt:message key="Common.area.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th width='20%'><fmt:message key="Common.area.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	<%}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
			classValue = "QRYODD" ;

	out.println("<tr width='10%'><td align='left' class='" + classValue + "'>");
	String code = rs.getString("res_town_code");
	out.println("<a href='../../eMP/jsp/TownModify.jsp?res_town_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td width='25%' style='WORD-BREAK:BREAK-ALL' class='" + classValue + "'>");
	out.println( rs.getString("town_long_desc")==null?"&nbsp":rs.getString("town_long_desc"));
	out.println("</td><td width='25%' class='" + classValue + "'>");
	out.println(rs.getString("town_short_desc")==null?"&nbsp":rs.getString("town_short_desc"));
	out.println("</td><td width='10%' class='" + classValue + "'>");
	out.println(rs.getString("town_area_code")==null?"&nbsp":rs.getString("town_area_code"));
	out.println("</td><td width='20%' class='" + classValue + "'>");
	out.println(rs.getString("area_short_desc")==null?"&nbsp":rs.getString("area_short_desc"));
	out.println("</td><td width='10%' class='" + classValue + "' align='center'>");

	if ( rs.getString("town_eff_status").equals("E"))
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	cnt++;
}   

	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 14 || (!rs.next()) ) {
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<% flag = true;
			} else {%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%}%>

</td></tr>
</table>
<br><center>
<%
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
}catch(Exception e) { 
	// out.println(e.toString());
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

