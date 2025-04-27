<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
 <%--
	@todo Should be declared locally
--%>
<%
String languageid="";
String longdesc="";
String shortname="";
String dflt_lang_online_report = "";
String eff_status="";
%>

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>

<%
languageid = request.getParameter("language_id");
String dflt_lang_appl_yn = request.getParameter("dflt_lang_appl_yn");
//Connection conn = (Connection) session.getValue( "connection" );
Connection conn = null;
PreparedStatement pstmt1=null;
PreparedStatement pstmt=null;
ResultSet rset1=null;
ResultSet rset=null;


try{
	conn = ConnectionManager.getConnection(request);

	pstmt = conn.prepareStatement("select a.lang_id language_id, a.long_name long_name ,a.short_name short_name,a.dflt_lang_online_report dflt_lang_online_report, a.eff_status eff_status from mp_language a  WHERE a.lang_id=?");
	 pstmt.setString(1,languageid); 
	
	rset = pstmt.executeQuery();
	if(rset.next())
	{
		languageid = rset.getString("language_id");
		longdesc= rset.getString("long_name");
		shortname = rset.getString("short_name");
		dflt_lang_online_report = rset.getString("dflt_lang_online_report")==null?"":rset.getString("dflt_lang_online_report");
		eff_status = rset.getString("eff_status");
	}					
%>
	<form name='Language_form' id='Language_form' action='../../servlet/eMP.LanguageServlet' method='post' target='messageFrame'>
		<BR><BR><BR><BR><BR><BR><BR><BR>
		<div align='left'>
		<table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>
			<tr>
				<td width='40%' >&nbsp;</td>
				<td width='60%' colspan='2'>&nbsp;</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td width='60%' class='fields' colspan='2'><input type='text' name='language_id' id='language_id' value='<%=languageid%>' size='2' readonly ><img src='../images/mandatory.gif'></img>
<%
	if ( eff_status.equals("E") )
	{
%>
				</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td width='60%' colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this)' value="<%=longdesc%>"><img src='../images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td width='60%' colspan='2' class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)' value="<%=shortname%>"><img src='../images/mandatory.gif'></img>
				</td>
			</tr>
			<%if(dflt_lang_appl_yn.equals("Y")){%>
			<tr>
			<td width="40%" class="label"><fmt:message key="eMP.Dfltlangforonlinereport.label" bundle="${mp_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><select name="dflt_lang" id="dflt_lang">
	  <option value='' selected>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------

<%
	try{
		   
	      String sql="select language_id, short_name from sm_language where EFF_STATUS='E'order by 2 ";
		  pstmt1 = conn.prepareStatement( sql);
		  rset1 = pstmt1.executeQuery();

	      if(rset1 != null){
	          while( rset1.next()){
				String langCode = rset1.getString( "language_id" ) ;
				String short_name = rset1.getString( "short_name" ) ;
				if(dflt_lang_online_report.equals(langCode)) 
						out.println("<option value=\"" + langCode + "\" selected>" + short_name );
					else 
						out.println("<option value=\"" + langCode + "\">" + short_name);
	          }
	      }
	}catch(Exception e){
	     e.printStackTrace();
	}
   %>
   </td></tr><%}%>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td class='fields' width='60%' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'
<%
		if  ( eff_status.equals("E") )
			out.println("checked >");
		else
			out.println(">");
%>
				</td>
			</tr> 
			<tr>
				<td width='40%' >&nbsp;</td>
				<td width='60%' colspan='2'>&nbsp;</td>
			</tr>
		</table>
		</div>
		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
		<input type='hidden' name='eff_date_from' id='eff_date_from' value=''>
		<input type='hidden' name='eff_date_to' id='eff_date_to' value=''>
	</form>
<%	}
	if ( eff_status.equals("D") )
	{
		//String rgncode="";
%>		
				</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td width='60%' colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this)' value="<%=longdesc%>" readonly><img src='../images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td width='60%' colspan='2' class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)' value="<%=shortname%>" readonly><img src='../images/mandatory.gif'></img>
				</td>
			</tr>
			<%if(dflt_lang_appl_yn.equals("Y")){%>
			<td width="40%" class="label"><fmt:message key="eMP.Dfltlangforonlinereport.label" bundle="${mp_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><select name="dflt_lang" id="dflt_lang">
	  <option value='' selected>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------

<%
	try{
		   
	      String sql="select language_id, short_name from sm_language where EFF_STATUS='E'order by 2 ";
		  pstmt1 = conn.prepareStatement( sql);
		  rset1 = pstmt1.executeQuery();

	      if(rset1 != null){
	          while( rset1.next()){
				String langCode = rset1.getString( "language_id" ) ;
				String short_name = rset1.getString( "short_name" ) ;
				if(dflt_lang_online_report.equals(langCode)) 
						out.println("<option value=\"" + langCode + "\" selected>" + short_name );
					else 
						out.println("<option value=\"" + langCode + "\">" + short_name);
	          }
	      }
	}catch(Exception e){
	     e.printStackTrace();
	}
   %>
   </td>
   <%}%>
			<tr>
				<td width='40%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td width='60%' class='fields' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E' 
<%
		if  ( eff_status.equals("E") )
			out.println("checked >");
		else
			out.println(">");
%>
			</td>
			</tr>
			<tr>
				<td width='40%' >&nbsp;</td>
				<td width='60%' colspan='2'>&nbsp;</td>
			</tr> 
			<%}%>
		</table>
		</div>
		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
		<input type='hidden' name='eff_date_from' id='eff_date_from' value=''>
		<input type='hidden' name='eff_date_to' id='eff_date_to' value=''>
	</form>
<%
}catch(Exception e) { 
	//out.println(e);
	e.printStackTrace();
}finally{
	if (rset != null) rset.close();
	if (pstmt != null) pstmt.close();
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

