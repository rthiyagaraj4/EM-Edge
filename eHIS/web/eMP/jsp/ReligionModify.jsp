<!DOCTYPE html>
<%--
/**
  *
  * @filename ReligionModify.jsp
  * @version 3.0 updated on 2/17/2005
  */
--%>
<%@ page import ="webbeans.eCommon.ConnectionManager, java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.text.SimpleDateFormat , eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	%>

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script src='../js/Religion.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>
<% 
String religion_code = request.getParameter("religion_code");
Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
String eff_date_from="",eff_date_to= "";
try{
	out.println("");
	//Connection conn = (Connection) session.getAttribute( "connection" );
	//Connection conn = (Connection) session.getValue( "connection" );
	conn = ConnectionManager.getConnection(request);
	StringBuffer sbQuery = new StringBuffer( "select relgn_code, long_desc, short_desc, eff_date_from, eff_date_to, eff_status from mp_religion where relgn_code= ? ");
	//sbQuery.append(religion_code);
	//sbQuery.append("'");
	pstmt = conn.prepareStatement(sbQuery.toString());
	pstmt.setString(1, religion_code); // Added by lakshmanan for security issue ID 174298094 on 05-09-2023
	rset = pstmt.executeQuery();
	if ((rset != null)  && rset.next()){//modified for the incident 36244
%>
	<form name='religion_form' id='religion_form' action='../../servlet/eMP.ReligionServlet' method='post' target='messageFrame'> 	
		<BR><BR><BR><BR><BR><BR><BR><BR><BR>
		<div align='left'>
		<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>
			<tr>
				<td width='40%'>&nbsp;</td>
				<td width='60%' colspan='2'>&nbsp;</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td class='fields' width='60%' colspan='2'>
<%
	out.println( "<input type='text' name='relgn_code' id='relgn_code' value='" + rset.getString("relgn_code") + "' size='4' maxlength='4'  readonly >" ) ;
	out.println("<img src='../images/mandatory.gif'></img>");
	if ( rset.getDate("eff_date_from") != null ){
		 java.util.Date date = rset.getDate("eff_date_from");
		 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
		 eff_date_from = formatter.format(date);
		 date = null;
		 formatter = null;
	}
	if ( rset.getDate("eff_date_to") != null){
		 java.util.Date date1 = rset.getDate("eff_date_to");
		 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
		 eff_date_to = formatter.format(date1);
		 date1 = null;
		 formatter = null;
	}

	if ( rset.getString("eff_status").equals("E") ){
		out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+" </td><td class='fields' width='60%' colspan='2'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this);' value=\""+rset.getString("long_desc")+"\">");
		 %>

		 <% out.println("<img src='../images/mandatory.gif'></img></td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+" </td><td class='fields' width='60%' colspan='2'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this);' value=\"");
		out.println( rset.getString("short_desc"));
		out.println("\"> <img src='../images/mandatory.gif'></img></td></tr>");	/*out.println("<tr><td width='40%' align='right' class='label'>Effective From </td><td width='13%' align='left'>&nbsp;&nbsp;&nbsp; */
		
		out.println("<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value='"+eff_date_from+"'>");
		//out.println("</td><td width='47%' align='left' class='label'>&nbsp;&nbsp;To &nbsp;&nbsp;

		out.println("<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='"+eff_date_to+"' >");
		//out.println("<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");

		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='checkbox' name='eff_status' id='eff_status' value='E'");

		String eff_status = rset.getString("eff_status");

		if  ( eff_status.equals("E") )
			out.println("checked >");
		else
			out.println(">");

		out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from'><input type='hidden' name='eff_date_to' id='eff_date_to'><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
	}
	if ( rset.getString("eff_status").equals("D") ){
		out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+" </td><td class='fields' width='60%' colspan='2'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value=\""+rset.getString("long_desc")+"\" readonly>");

		out.println("<img src='../images/mandatory.gif'></img></td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+" </td><td class='fields' width='60%' colspan='2'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value=\"");
		out.println( rset.getString("short_desc"));	
		out.println("\" readonly >&nbsp;<img src='../images/mandatory.gif'></img></td></tr>");
		/*out.println("<tr><td width='40%' align='right' class='label'>Effective From </td><td width='13%' align='left'>&nbsp;&nbsp;&nbsp;*/
		out.println("<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value='"+eff_date_from+"' readonly>");
	//out.println("</td><td width='47%' align='left' class='label'>&nbsp;&nbsp;To &nbsp;&nbsp;

		out.println("<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='"+eff_date_to+"' readonly></td></tr>");
		//out.println("<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");

		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='checkbox' name='eff_status' id='eff_status' value='E'");
		String eff_status = rset.getString("eff_status");
		if  ( eff_status.equals("E") )
			out.println("checked >");
		else
			out.println(">");
		out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from'  value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
	}
	if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;
	}
}catch ( Exception e ){
	// out.println(e.toString());
	e.printStackTrace();
}finally{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
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

