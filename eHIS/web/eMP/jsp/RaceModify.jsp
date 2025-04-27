<!DOCTYPE html>
<%--
/**
  *
  * @filename RaceModify.jsp
  * @version 3.0 updated on 2/18/2005
  */
--%>
<%@ page import ="webbeans.eCommon.ConnectionManager, java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.net.URLEncoder, java.text.SimpleDateFormat" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		
	</head>
	<body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>
<% 
	String RACE_CODE = request.getParameter("RACE_CODE");
	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	String eff_date_from="",eff_date_to="";

	try{
		//conn = (Connection) session.getValue( "connection" );
		conn = ConnectionManager.getConnection(request);
		String status = "" ;
		StringBuffer sbQuery = new StringBuffer("select RACE_CODE,LONG_DESC,SHORT_DESC,eff_date_from,eff_date_to,EFF_STATUS from mp_race where RACE_CODE='");
		sbQuery.append(RACE_CODE);
		sbQuery.append("'");
		//String sql = "select RACE_CODE,LONG_DESC,SHORT_DESC,eff_date_from,eff_date_to,EFF_STATUS from mp_race where RACE_CODE='"+RACE_CODE+"'";
		pstmt = conn.prepareStatement(sbQuery.toString());
		rset = pstmt.executeQuery();

		if ( rset != null ) {
			rset.next();
			status = rset.getString( "EFF_STATUS" ) ;
		}
	%>
	<form name='RACE_FORM' id='RACE_FORM' action='../../servlet/eMP.RaceServlet' method='post' target='messageFrame'> 
		<div align='left'>
			<BR><BR><BR><BR><BR><BR><BR><BR><BR>
			<table border='0' cellpadding='0' cellspacing='0' width='75%' align='center'>
			<tr>
				<td width='40%'>&nbsp;</td>
				<td width='60%' colspan='2'>&nbsp;</td>
			</tr>
			<tr>
				<td align='right' width='40%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td width='60%' align='left' colspan='2'>&nbsp;&nbsp;
					<input type='text' size='10' maxlength='10' name='RACE_CODE' id='RACE_CODE' readonly value='<%=rset.getString("RACE_CODE")%>'>
					<img src='../images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td width='40%'>&nbsp;</td>
				<td width='60%' colspan='2'>&nbsp;</td>
			</tr>
			<tr>
				<td align='right' width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td width='60%' align='left' colspan='2'>&nbsp;&nbsp;" ) ;
	<%
		if ( status.equals( "E" ) )
			out.println( "<input type='text' name='LONG_DESC' id='LONG_DESC' size='30' maxlength='30' onBlur='makeValidString(this)' value=\"" + rset.getString( "LONG_DESC" ) + "\">" );
		else
			out.println( "<input type='text' name='LONG_DESC' id='LONG_DESC' size='30' readonly value=\"" + rset.getString( "LONG_DESC" ) + "\">" );
		out.println("<img src='../images/mandatory.gif'></img></td></tr>" ) ;

		out.println( "<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr><tr><td align='right' width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+"</td><td width='60%' align='left' colspan='2'>&nbsp;&nbsp; " ) ;

		if ( status.equals( "E" ) )
			out.println( "<input type='text' name='SHORT_DESC' id='SHORT_DESC' size='15' maxlength='15' onBlur='makeValidString(this)' value=\"" + rset.getString( "SHORT_DESC" ) + "\">" );
		else
			out.println( "<input type='text' name='SHORT_DESC' id='SHORT_DESC' size='15' readonly value=\""  + rset.getString( "SHORT_DESC" ) + "\">" );
		out.println("<img src='../images/mandatory.gif'></img></td></tr>" ) ;

		out.println( "<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");

/*out.println("<tr><td align='right' width='40%' class='label'>Effective From</td><td width='13%' align='left'>&nbsp;&nbsp;" ) ;*/

		if ( status.equals( "E" ) )
			out.println( "<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value='"+eff_date_from+"'>");
		else
			out.println( "<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' readonly value='"+eff_date_from+"'>");

		if ( rset.getDate("eff_date_from") != null ){
			java.util.Date date = rset.getDate("eff_date_from");
			SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			eff_date_from = formatter.format(date);
			date = null;
			formatter = null;
		 }

		/*out.println("' onblur='checkdate(this)'></td><td width='47%' align='left' class='label'>&nbsp;&nbsp;To&nbsp;&nbsp; " ) ;*/

		if ( status.equals( "E" ) )
			out.println( "<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='"+eff_date_to+"'>");
		else
			out.println( "<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  readonly value='"+eff_date_to+"'>");

		if ( rset.getDate("eff_date_to") != null){
			java.util.Date date1 = rset.getDate("eff_date_to");
			SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			eff_date_to = formatter.format(date1);
			date1 = null;
			formatter = null;
		}

		/*out.println("<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");*/

		out.println("<tr><td align='right' width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' align='left' colspan='2'>&nbsp;&nbsp;<input type='checkbox' name='EFF_STATUS' id='EFF_STATUS' value='E'");

		String eff_status = rset.getString("EFF_STATUS");

		if  ( eff_status.equals("E") )
			out.println("checked >");
		else
			out.println(">");

		out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr></table></div><input type='hidden' name='mode' id='mode' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
		if ( rset != null ) rset.close() ;
		if ( pstmt != null ) pstmt.close() ;
	}catch ( Exception e ){ 
		out.println(e.toString());
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

