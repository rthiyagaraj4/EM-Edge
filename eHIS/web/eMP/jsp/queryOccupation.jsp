<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
//	sql = "";
	String cd = request.getParameter("ocpn_code");
	cd = cd.toUpperCase();
	String ccd = request.getParameter("a.ocpn_class_code");
	ccd = ccd.toUpperCase();	
	String longdesc = request.getParameter("a.long_desc");
	longdesc = longdesc.toUpperCase();
	String class_longdesc = request.getParameter("b.long_desc");
	class_longdesc = class_longdesc.toUpperCase();
	String enabled = request.getParameter("nature");

	//int andCheck = 0;


	if ( !(cd == null || cd.equals("")) )
	{
		sbQuery.append(" and ocpn_code like '");
		sbQuery.append(cd);
		sbQuery.append("%'");
//		sql = " and ocpn_code like '"+cd+"%'";
	}
	if ( !(ccd == null || ccd.equals("")) )
	{
		sbQuery.append(" and ");
		sbQuery.append("a.ocpn_class_code like  '");
		sbQuery.append(ccd);
		sbQuery.append("%'" );
//		sql = sql + " and ";
//		sql = sql + "a.ocpn_class_code like  '"+ccd+"%'" ;
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
	if ( !(class_longdesc == null || class_longdesc.equals("")) )
	{
		sbQuery.append(" and ");
		sbQuery.append(" a.ocpn_class_code in (select ocpn_class_code from mp_occupation_class where upper(long_desc) like  '");
		sbQuery.append(class_longdesc);
		sbQuery.append("%')" );
//		sql = sql + " and ";
//		sql = sql + " a.ocpn_class_code in (select ocpn_class_code from mp_occupation_class where upper(short_desc) like  '"+class_longdesc+"%')" ;
	}

	if ( !(enabled == null || enabled.equals("")) )
	{
	     if( enabled.equals("E") ){
			 sbQuery.append(" and a.eff_status='E'");
//	   		sql = sql + " and a.eff_status='E'";
		 }
	     if ( enabled.equals("D") ){
			 sbQuery.append(" and a.eff_status='D'");
//            sql = sql + " and a.eff_status='D'";
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
//PreparedStatement pstmt=null;
ResultSet rs=null;
//ResultSet rs1=null;
PreparedStatement pstmt1=null;
	//int maxRecord = 0;
try{
	conn = ConnectionManager.getConnection(request);

	/*pstmt = conn.prepareStatement("select count(*) as total from mp_occupation a, mp_occupation_class b where a.ocpn_class_code = b.ocpn_class_code "+sbQuery.toString());

	rs = pstmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
	if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/

	pstmt1 = conn.prepareStatement("select ocpn_code, a.long_desc ocpn_long_desc, a.short_desc ocpn_short_desc, a.eff_status ocpn_eff_status, a.ocpn_class_code ocpn_ocpn_class_code, b.long_desc class_short_desc from mp_occupation a, mp_occupation_class b where a.ocpn_class_code = b.ocpn_class_code "+sbQuery.toString());
	rs = pstmt1.executeQuery();

%>




<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  	  String classValue = "" ;
		int cnt=0;
while ( i<=end && rs.next())
{
	if(cnt==0)
	{%>
		<P>
		<table align='right'>
		<tr>

		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/queryOccupation.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		%>
			<td align ='right' id='next' style='visibility:hidden'>
		<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/queryOccupation.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
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
		<th><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	<%}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
		classValue = "QRYODD" ;

	out.println("<tr><td align=='left' class='" + classValue + "'>");
	String code = rs.getString("ocpn_code");

	out.println("<a href='../../eMP/jsp/occupationModify.jsp?occupation_code="+ code + "' target='f_query_add_mod' >");
        out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("ocpn_long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("ocpn_short_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("ocpn_ocpn_class_code") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("class_short_desc") );
	out.println("</td><td class='" + classValue    
		+ "' align='center'>");

	if ( rs.getString("ocpn_eff_status").equals("E") )
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



	<%}
%>

</td></tr>
</table>
</center>

<br><center>
<%
	if (rs != null) rs.close();
	if (pstmt1 != null) pstmt1.close();
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

