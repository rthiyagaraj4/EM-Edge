<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eMP/js/ActiveInactive.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown='lockKey();'>
<% String reason_code = request.getParameter("reason_code");
Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
String eff_date_from="",eff_date_to="";
String reason_for_active_yn = "";
try{

	conn = ConnectionManager.getConnection(request);
	StringBuffer sbQuery = new StringBuffer("select reason_code,long_desc,short_desc,eff_date_from,eff_date_to,eff_status,reason_for_active_yn from MP_PAT_INACT_REASON_LANG_VW where reason_code='");
	sbQuery.append(reason_code);
	sbQuery.append("' and language_id='"+localeName+"'");
	pstmt = conn.prepareStatement(sbQuery.toString());

	String status = "" ;

	rset = pstmt.executeQuery();

	if ( rset != null ) 
	{
		rset.next();
		status = rset.getString( "eff_status" ) ;
	}
%>
	<form name='active_inactive_form' id='active_inactive_form' action='../../servlet/eMP.ActiveInactiveServlet' method='post' target='messageFrame'> <BR><BR><BR><BR><BR><BR><BR><BR><BR><div align='left'>
	<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>
	<tr>
		<td width='40%'>&nbsp;</td>
		<td width='60%' colspan='2'>&nbsp;</td>
	</tr>
	<tr>
		<td width='40%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td width='60%' class='fields' colspan='2'><input type='text' size='4' maxlength='4' name='reason_code' id='reason_code' readonly value="<%=rset.getString("reason_code")%>"><img src='../images/mandatory.gif'></img></td>
	</tr>
	<tr>
			<td width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td width='60%' class='fields' colspan='2'>
<%
	if ( status.equals( "E" ) )
		out.println( "<input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this)' value=\"" + rset.getString( "long_desc" ) + "\">" );
	else
		out.println( "<input type='text' name='long_desc' id='long_desc' size='30' readonly value=\"" + rset.getString( "long_desc" ) + "\">" );
%>
	<img src='../images/mandatory.gif'></img></td>
	</tr>

	<tr>
		<td width='40%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td width='60%' class='fields' colspan='2'>
<%
	if ( status.equals( "E" ) )
		out.println( "<input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)' value= \"" + rset.getString( "short_desc" ) + "\">" );
	else
		out.println( "<input type='text' name='short_desc' id='short_desc' size='15' readonly value=\""  + rset.getString( "short_desc" ) + "\">" );
%>
	<img src='../images/mandatory.gif'></img></td>
	</tr>

	<!--Added for Reason for active yn-->
	<tr>
		<td width='40%' class='label'><fmt:message key="eMP.ReasonforActive.label" bundle="${mp_labels}"/></td>
		<td width='60%' class='fields' colspan='2'>
<%	 reason_for_active_yn = rset.getString("reason_for_active_yn");
	if ( status.equals( "E" ) )
	{
		if(reason_for_active_yn.equals("Y"))
		{
		out.println( "<input type='radio' name='reason_for_active_yn' id='reason_for_active_yn' checked value='Y' onclick='assignvalue()'>Active&nbsp;&nbsp;" );
		out.println( "<input type='radio' name='reason_for_active_yn' id='reason_for_active_yn'  value='N' onclick='assignvalue()'>InActive&nbsp;&nbsp;" );
		}
		if(reason_for_active_yn.equals("N"))
		{
		out.println( "<input type='radio' name='reason_for_active_yn' id='reason_for_active_yn' value='Y' onclick='assignvalue()'>Active&nbsp;&nbsp;" );
		out.println( "<input type='radio' checked name='reason_for_active_yn' id='reason_for_active_yn' value='N' onclick='assignvalue()'>InActive&nbsp;&nbsp;" );
		}

	}
	else
	{
	  if(reason_for_active_yn.equals("Y"))
		{
		out.println( "<input type='radio' name='reason_for_active_yn' id='reason_for_active_yn' checked value='Y' disabled>Active&nbsp;&nbsp;" );
		out.println( "<input type='radio' name='reason_for_active_yn' id='reason_for_active_yn'  value='N' disabled>InActive&nbsp;&nbsp;" );
		}
		if(reason_for_active_yn.equals("N"))
		{
		out.println( "<input type='radio' name='reason_for_active_yn' id='reason_for_active_yn'  value='Y' disabled>Active&nbsp;&nbsp;" );
		out.println( "<input type='radio' checked name='reason_for_active_yn' id='reason_for_active_yn'  value='N' value='N' disabled>InActive&nbsp;&nbsp;" );
		}

	}
	

	out.println("<img src='../images/mandatory.gif'></img></td></tr>" ) ;

	if ( rset.getDate("eff_date_from") != null )
	{
		java.util.Date date = rset.getDate("eff_date_from");
		SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
		eff_date_from = formatter.format(date);
		date = null;
		formatter = null;
	}%>
 <%-- <input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' onblur='CheckDate(this)' value='eff_date_from'> --%>
<%
	if ( status.equals( "E" ) )
		out.println( "<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' onblur='validDateObj(this,\"DMY\",localeName)' value='"+eff_date_from+"'>");
	else
		out.println( "<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' onblur='validDateObj(this,\"DMY\",localeName)' readonly value='"+eff_date_from+"'>");


/*out.println("' onblur='checkdate(this)'></td><td width='47%' class='label'>&nbsp;&nbsp;To&nbsp;&nbsp; " ) ;*/

	if ( rset.getDate("eff_date_to") != null)
	{
		java.util.Date date1 = rset.getDate("eff_date_to");
		SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
		eff_date_to = formatter.format(date1);
		date1 = null;
		formatter = null;
	}


	if ( status.equals( "E" ) )
		out.println( "<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  onblur='validDateObj(this,\"DMY\",localeName)' value='"+eff_date_to+"'>");
	else
		out.println( "<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  onblur='validDateObj(this,\"DMY\",localeName)' readonly value='"+eff_date_to+"'>");


/*out.println("' onblur='checkdate(this)'></td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");*/

	out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' class='fields' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'");

	String eff_status = rset.getString("eff_status");

	if  ( eff_status.equals("E") )
		out.println("checked >");
	else
		out.println(">");

	out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr></table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
	if (rset != null) rset.close();
	if (pstmt != null) pstmt.close();
}catch(Exception e) { out.println(e.toString());}
finally
{
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

