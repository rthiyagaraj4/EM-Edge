<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*
 " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>
<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	String cd = request.getParameter("region_code");
	if(cd != null)
		cd=cd.toUpperCase();
	String longdesc = request.getParameter("long_desc");
	if(longdesc != null)
			longdesc = longdesc.toUpperCase();
	
	//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
	String GST_Region = checkForNull(request.getParameter("GST_Region"));

	//String shortdesc = request.getParameter("short_desc");
	String enabled = request.getParameter("enabled");
String country_code = request.getParameter("country_code");
if(country_code != null)
		country_code=country_code.toUpperCase();
String country_desc = request.getParameter("country_desc");
if(country_desc != null)
		country_desc=country_desc.toUpperCase();

	int andCheck = 0;

	if ( !(cd == null || cd.equals("")) )
		{
		sbQuery.append("where upper(b.region_code) like '");
		sbQuery.append(cd);
		sbQuery.append("%'");
		andCheck = 1;
		}
	if ( !(country_code == null || country_code.equals("")) )
		{
		if ( !(cd == null || cd.equals("")) )
			{
			sbQuery.append(" and upper(b.country_code) like '");
			}
		else
			{
			sbQuery.append(" where upper(b.country_code) like '");
			}
		//sbQuery.append("where upper(b.country_code) like '");
		sbQuery.append(country_code);
		sbQuery.append("%'");
		andCheck = 1;
		}	
	/****************/	
	/****************/	
	if ( !(country_desc == null || country_desc.equals("")) )
		{
			if (( !(country_code == null || country_code.equals("")) )| ( !(cd == null || cd.equals("")) ))
				{
				sbQuery.append(" and ");
				}
			else if ( !(country_desc == null || country_desc.equals("")) )
				{
				sbQuery.append(" where ");
				}
			
			sbQuery.append(" b.country_code in (select country_code from mp_country where upper(short_name) like '");
			sbQuery.append(country_desc);
			sbQuery.append("%')");
		}
	if ( !(longdesc == null || longdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			sbQuery.append(" upper(b.long_desc) like  '");
			sbQuery.append(longdesc);
			sbQuery.append("%'" );
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append(" where upper(b.long_desc) like '");
			sbQuery.append(longdesc);
			sbQuery.append("%'" );
			andCheck = 1;
		}
	}
	
	//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
	if ( !(GST_Region == null || GST_Region.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			sbQuery.append(" upper(b.GST_Region) like  '");
			sbQuery.append(GST_Region);
			sbQuery.append("%'" );
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append(" where upper(b.GST_Region) like '");
			sbQuery.append(GST_Region);
			sbQuery.append("%'" );
			andCheck = 1;
		}
	}
	
	/*if ( !(shortdesc == null || shortdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			sbQuery.append("b.short_desc like  '");
			sbQuery.append(shortdesc);
			sbQuery.append("%'" );
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append("where b.short_desc like '");
			sbQuery.append(shortdesc);
			sbQuery.append("%'" );
			andCheck = 1;
		}
	}*/
	if ( !(enabled == null || enabled.equals("") || enabled.equals("B")) )
	{
			String strEffStatus="";
			if(enabled.equals("E"))
				strEffStatus="E";
			else if(enabled.equals("D"))
				strEffStatus="D";
			
			if(andCheck == 0 ){
				sbQuery.setLength(0);
				sbQuery.append("where b.eff_status='"+strEffStatus+"'");
			}else{
				sbQuery.append(" and b.eff_status='"+strEffStatus+"'");
			}
		    /*if ( enabled.equals("B") ){
				sbQuery.setLength(0);
				sbQuery.append("where b.eff_status='E' or b.eff_status='D'");
			}	*/	
	}

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
Boolean isGSTCodeApplicable = false; //Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132

//int maxRecord = 0;
try{
	conn = ConnectionManager.getConnection(request);

	//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
	isGSTCodeApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn, "MP", "GST_CODE");

	/*pstmt = conn.prepareStatement("select count(*) as total from mp_region "+sbQuery.toString());

	rs = pstmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();

if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/

	//pstmt = conn.prepareStatement("select * from mp_region order by region_code");
	//pstmt = conn.prepareStatement("select * from mp_region "+sbQuery.toString());
	pstmt = conn.prepareStatement("select b.REGION_CODE,b.GST_Region, b.LONG_DESC, b.SHORT_DESC, b.EFF_STATUS,b.COUNTRY_CODE, (select a.SHORT_NAME from mp_country a where a.COUNTRY_CODE= b.COUNTRY_CODE) COUNTRY_DESC from mp_region b "+sbQuery.toString());
	rs = pstmt.executeQuery();

%>



<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  	  String classValue = "" ;
		  int cnt=0;
while (i<=end  && rs.next())
{
	if(cnt==0)
	{
	
	%>
		<P>
		<table align='right'>
		<tr>

		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/queryRegion.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		%>	
			<td align ='right' id='next' style='visibility:hidden'>
		<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/queryRegion.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
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
		<!--Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132-->
		<%if(isGSTCodeApplicable)
		{%>
		<th><fmt:message key="Common.GoodsandServicesTax.label" bundle="${common_labels}"/> <fmt:message key="eMP.Regioncode.label" bundle="${mp_labels}"/></th>
		<%}%>
		<th><fmt:message key="eMP.CountryCode.label" bundle="${mp_labels}"/></th>
		<th><fmt:message key="eMP.CountryDesc.label" bundle="${mp_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
  <%}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
		classValue = "QRYODD" ;

	out.println("<tr><td align='left' class='" + classValue + "'>");
	String code = rs.getString("region_code");
	out.println("<a href='../../eMP/jsp/RegionModify.jsp?region_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_desc") );
	out.println("</td>");
	
	if(isGSTCodeApplicable)
	{
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("GST_Region")==null?"&nbsp":rs.getString("GST_Region") );
	out.println("</td>");
	}

	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("country_code")==null?"&nbsp":rs.getString("country_code") );
	out.println("</td>");
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("country_desc")==null?"&nbsp":rs.getString("country_desc") );
	out.println("</td>");
	out.println("<td class='" + classValue +
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

