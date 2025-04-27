<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	</head>
	<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{

	String educ_level_code = request.getParameter("educ_level_code");
	if(educ_level_code != null)
		educ_level_code=educ_level_code.toUpperCase();
	String longdesc = request.getParameter("long_desc");
	if(longdesc != null)
		longdesc=longdesc.toUpperCase();
	String enabled = request.getParameter("enabled");

	int andCheck = 0;


	if ( !(educ_level_code == null || educ_level_code.equals("")) )
		{
		sbQuery.append("where upper(educ_level_code) like '");
		sbQuery.append(educ_level_code);
		sbQuery.append("%'");
		andCheck = 1;
		}
	if ( !(longdesc == null || longdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			sbQuery.append("upper(long_desc) like  '");
			sbQuery.append(longdesc);
			sbQuery.append("%'");
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append("where upper(long_desc) like '");
			sbQuery.append(longdesc);
			sbQuery.append("%'");
			andCheck = 1;
		}
	}
	if ( !(enabled == null || enabled.equals("") ||  enabled.equals("B")) )
	{
		String strEffStatus="";
		if(enabled.equals("E"))
			strEffStatus="E";
		else if(enabled.equals("D"))
			strEffStatus="D";
		
		if(andCheck == 0 ){
			sbQuery.setLength(0);
			sbQuery.append("where eff_status='"+strEffStatus+"'");
		}else if(!enabled.equals("B")){
			sbQuery.append(" and eff_status='"+strEffStatus+"'");
		}
	  /* if ( enabled.equals("B") )
	   {
	   }*/
	}

	//sbQuery.append("order by educ_level_code");
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
	}else{
		sbQuery.append(" order by educ_level_code");
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
	/*pstmt = conn.prepareStatement("select count(*) as total from mp_education_level "+sbQuery.toString());

	rs = pstmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/

pstmt = conn.prepareStatement("select educ_level_code, long_desc, short_desc, eff_Status  from mp_education_level "+sbQuery.toString());
rs = pstmt.executeQuery(); %>



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
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/queryEducationLevel.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			%>
				<td align ='right' id='next' style='visibility:hidden'>
			<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/queryEducationLevel.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
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
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%	}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
			classValue = "QRYODD" ;

	out.println("<tr><td align='left' class='" + classValue + "'>");
	String code = rs.getString("educ_level_code");

	out.println("<a href='../../eMP/jsp/EducationLevelModify.jsp?educ_level_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_desc") );
	out.println("</td><td class='" + classValue +
		"'  align='center'>");

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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}%>

</td></tr>
</table>
</center>

<br><center>
<%

		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
	}catch(Exception e) { 
		out.println(e.toString());
		e.printStackTrace();
	}
	finally	{
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
	%>
</center>
</body>
</html>

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

