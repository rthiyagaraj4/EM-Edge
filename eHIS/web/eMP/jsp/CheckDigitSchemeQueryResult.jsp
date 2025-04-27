<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*
 " contentType="text/html;charset=UTF-8" %>
 <%
	request.setCharacterEncoding("UTF-8");
%>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
	</head>
	<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad='ClearMsg()'>
<%
	Connection conn = null;
	Statement stmt=null;
	ResultSet rs = null;
	//ResultSet rset=null;

	try{
	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
//	String sql ;									// will be deleted once code walkthrough is done	
	String from = 	request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	//String facilityid=(String)session.getValue("facility_id");

	conn = ConnectionManager.getConnection(request);

	stmt = conn.createStatement();
 
	if ( (whereClause == null || whereClause.equals("")) )
	{
//	sql="";
	String scheme_id = request.getParameter("scheme_id");
	scheme_id = scheme_id.toUpperCase();
	String scheme_name=request.getParameter("scheme_name");
	scheme_name = scheme_name.toUpperCase();
	String enabled = request.getParameter("eff_status");
	
	int andCheck = 0;

	if ( !(scheme_id == null || scheme_id.equals("")) )
		{
		sbQuery.append("where  scheme_id like '");
		sbQuery.append(scheme_id);
		sbQuery.append("%'");
//		sql = "where  scheme_id like '"+scheme_id+"%'";
		andCheck = 1;
		}

	if ( !(scheme_name == null || scheme_name.equals("")) )
	   {
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			sbQuery.append("upper(scheme_name) like  '");
			sbQuery.append(scheme_name);
			sbQuery.append("%'" );
//			sql = sql + " and ";
//			sql = sql + "upper(scheme_name) like  '"+scheme_name+"%'" ;
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append("where upper(scheme_name) like '");
			sbQuery.append(scheme_name);
			sbQuery.append("%'" );
//			sql = "where upper(scheme_name) like '"+scheme_name+"%'" ;
			andCheck = 1;
		}
	 }

	if ( !(enabled == null || enabled.equals("")) )
	{
	   if ( enabled.equals("E") )
	    {
			if ( andCheck == 0 ) {
				sbQuery.setLength(0);
				sbQuery.append("where eff_status='E'");
	//			sql = "where eff_status='E'";
				andCheck = 1; }
			else{
				sbQuery.append(" and eff_status='E'");
//				sql = sql + " and eff_status='E'";
			}
		}
	   if ( enabled.equals("D") )
		{
			if ( andCheck == 0 ) {
				sbQuery.setLength(0);
				sbQuery.append(" where  eff_status='D'");
//				sql = " where  eff_status='D'";
				andCheck = 1; 
			}
			else{
				sbQuery.append(" and eff_status='D'");
//				sql = sql + " and eff_status='D'";
			}
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



/*int maxRecord = 0;


String strsql1=" select count(*) as total from mp_check_digit_scheme "+sbQuery.toString();

rs = stmt.executeQuery(strsql1);
rs.next();
maxRecord = rs.getInt("total");
if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");*/

String strsql2="select * from mp_check_digit_scheme "+sbQuery.toString();
if(rs!=null) rs.close();
rs = stmt.executeQuery(strsql2);
//out.println(strsql2);
%>



<%

 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	  String classValue = "" ;
	  int cnt=0;

while ( i<=end && rs.next())
{
	if(cnt==0)
	{%>
		<p>
		<table align='right'>
		<tr>

		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/CheckDigitSchemeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			%>
				<td align ='right' id='next' style='visibility:hidden'>
			<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/CheckDigitSchemeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

		%>
		</td>
		</tr>
		</table>
			<BR><BR>
		</p>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="eMP.CheckDigitSchemeID.label" bundle="${mp_labels}"/></th>
		<th><fmt:message key="eMP.CheckDigitSchemeName.label" bundle="${mp_labels}"/></th>
		<th><fmt:message key="Common.Function.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%	}

        if ( i % 2 == 0 )
		  classValue = "QRYEVEN" ;
	else
		  classValue = "QRYODD" ;


	out.println("<tr><td class='" + classValue + "'>");
	String ID = rs.getString("scheme_id");
	out.println("<a href='../../eMP/jsp/AddModifyCheckDigitScheme.jsp?ID="+ ID + "' target='f_query_add_mod' >");

	out.println(ID+"</a></td><td class='" + classValue + "'>");


	out.println(rs.getString("scheme_name") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("program_name") );
	
	 
	out.println("</td><td  class='" + classValue +
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
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='hidden';
		</script>
	<% flag = true;
			} else {%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='visible';
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%}%>

</td></tr>
</table>
<br><center>

<%


}catch(Exception e) {
	out.println("main try"+e);
	e.printStackTrace();
}finally { 
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	ConnectionManager.returnConnection(conn,request);
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

