<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	</head>
	<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
		String cd = request.getParameter("res_area_code");
		cd = cd.toUpperCase();
		String longdesc = request.getParameter("a.long_desc");
		if (longdesc==null) longdesc="";
			longdesc = longdesc.toUpperCase();
		String region_cd = request.getParameter("a.region_code");
		region_cd = region_cd.toUpperCase();
		String region_longdesc = request.getParameter("region_long_desc");
		if (region_longdesc==null) region_longdesc="";
			region_longdesc = region_longdesc.toUpperCase();
		String shortdesc = request.getParameter("a.short_desc");
		if (shortdesc==null) shortdesc="";
			shortdesc = shortdesc.toUpperCase();
		String enabled = request.getParameter("nature");


		if ( !(cd == null || cd.equals("")) )
		{
			sbQuery.append(" and a.res_area_code like '");
			sbQuery.append(cd);
			sbQuery.append("%'");
		}
		if ( !(region_cd == null || region_cd.equals("")) )
		{
			sbQuery.append(" and ");
			sbQuery.append(" a.region_code like '");
			sbQuery.append(region_cd);
			sbQuery.append("%'");
		}
		if ( !(longdesc == null || longdesc.equals("")) )
		{
			sbQuery.append(" and ");
			sbQuery.append("upper(a.long_desc) like  '");
			sbQuery.append(longdesc);
			sbQuery.append("%'");
		}
		if ( !(region_longdesc == null || region_longdesc.equals("")) )
		{
			sbQuery.append(" and ");
			sbQuery.append("a.region_code in (select region_code from mp_region where upper(long_desc) like '");
			sbQuery.append(region_longdesc);
			sbQuery.append("%')");
		}

		if ( !(shortdesc == null || shortdesc.equals("")) )
		{
			sbQuery.append(" and ");
			sbQuery.append("upper(a.short_desc) like  '");
			sbQuery.append(shortdesc);
			sbQuery.append("%'");
		}

		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") ){
			   sbQuery.append(" and a.eff_status='E'");
		   }
		   if ( enabled.equals("D") ){
			   sbQuery.append(" and a.eff_status='D'");
		   }
		}

		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null || ord .equals("")) )
		{
			sbQuery.append(" order by ");
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);
				}else{
					sbQuery.append(ord[i]);
					sbQuery.append(",");
				}
			}
		}
	} //end of where clause IF
	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
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
	/*pstmt = conn.prepareStatement("select count(*) as total from mp_res_area a, mp_region b where a.region_code = b.region_code "+sbQuery.toString());

	rs = pstmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
	if (maxRecord==0) 			
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/
	
	//String FG="select a.res_area_code, a.long_desc area_long_desc, a.short_desc area_short_desc, b.region_code area_region_code, mp_get_desc.MP_REGION(a.res_area_code,'en','1') region_short_desc region_short_desc, a.eff_status from mp_res_area a where  "+sbQuery.toString();
		
	
	pstmt = conn.prepareStatement("select a.res_area_code, a.long_desc area_long_desc, a.short_desc area_short_desc, a.region_code area_region_code, mp_get_desc.MP_REGION(a.REGION_CODE,'en','1') region_short_desc , a.eff_status  from mp_res_area a where a.eff_status=a.eff_status "+sbQuery.toString());
	//pstmt = conn.prepareStatement("select a.res_area_code, a.long_desc area_long_desc, a.short_desc area_short_desc,a.region_codearea_region_code,b.short_desc region_short_desc,mp_get_desc.MP_RES_REGION(a.res_area_code,'en','1') region_short_desc, a.eff_status from mp_res_area a where a.region_code = a.region_code  "+sbQuery.toString());
	
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
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/queryArea.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		%>
			<td align ='right' id='next' style='visibility:hidden'>
		<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/queryArea.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
			<BR><BR>
		</P>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eMP.Regioncode.label" bundle="${mp_labels}"/></th>
		<th ><fmt:message key="eMP.RegionDesc.label" bundle="${mp_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	<%}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
			classValue = "QRYODD" ;

	out.println("<tr><td align='left' class='" + classValue + "'>");
	String code = rs.getString("res_area_code");
	out.println("<a href='../../eMP/jsp/AreaModify.jsp?res_area_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("area_long_desc")==null?"&nbsp":rs.getString("area_long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("area_short_desc")==null?"&nbsp":rs.getString("area_short_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("area_region_code")==null?"&nbsp":rs.getString("area_region_code") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("region_short_desc")==null?"&nbsp":rs.getString("region_short_desc"));
	out.println("</td><td class='" + classValue +	
		"' align='center'>");

	if ( rs.getString("eff_status").equals("E") )
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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



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

