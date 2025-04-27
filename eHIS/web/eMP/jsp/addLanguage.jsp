<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
%>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eMP/js/language.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="Focusing('language_id')">
<%
 Connection con =null;
 PreparedStatement pstmt=null ;
 ResultSet rs=null;
 con = ConnectionManager.getConnection(request);
try{
%>
<form name="Language_form" id="Language_form" action="../../servlet/eMP.LanguageServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR>

<%
	
	int dflt_lang_appl_cnt = 0;
	try{		 
	      String sql="select count (*) dflt_lang_appl_cnt from sm_site_param a, sm_function_control b where a.customer_id = b.site_id and module_id = 'MP' and functionality_id = 'DFLT_PAT_LANG' ";
		  pstmt = con.prepareStatement( sql);
		  rs = pstmt.executeQuery();

	      if(rs != null){
	          if( rs.next()){
				dflt_lang_appl_cnt = rs.getInt( "dflt_lang_appl_cnt" ) ;			
	          }
	      }
	}catch(Exception e){
	     e.printStackTrace();
	}
   %>
<div align="left">
  <table border="0" cellpadding="3" cellspacing="0" width="75%" align='center'>

  <tr>
	<td width='40%'>&nbsp;</td>
	<td width='60%' colspan='2'></td>
</tr>

    <tr>
      <td width="40%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="language_id" id="language_id" size="2" maxlength="2" OnBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)"><img src='../images/mandatory.gif'></img></td>
		  </tr>
 <tr>
      <td width="40%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" onBlur='makeValidString(this)' style='{ font-size: ;}'><img src='../images/mandatory.gif'></img></td>
    </tr>
   <tr>
      <td width="40%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" onBlur='makeValidString(this)'><img src='../images/mandatory.gif'></img></td>
    </tr>
	<%if(dflt_lang_appl_cnt>0){%>
	<tr>
	<td width="40%" class="label"><fmt:message key="eMP.Dfltlangforonlinereport.label" bundle="${mp_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><select name="dflt_lang" id="dflt_lang">
	  <option value='' selected>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------

<%
	try{
		 if (pstmt!=null)pstmt.close();
		 if (rs!=null)rs.close();
	     String sql="select language_id, short_name from sm_language where EFF_STATUS='E'order by 2 ";
		 pstmt = con.prepareStatement( sql);
		 rs = pstmt.executeQuery();

	      if(rs != null){
	          while( rs.next()){
				String langCode = rs.getString( "language_id" ) ;
				String shortname = rs.getString( "short_name" ) ;%>
				<OPTION VALUE='<%=langCode%>'><%=shortname%><%
	          }
	      }
	}catch(Exception e){
	     e.printStackTrace();
	}
   %>
   </td></tr><%}%>
	<tr>
	<td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    	<td width="60%" class='fields' colspan="2"><input type="checkbox" name="eff_status" id="eff_status" value="E" checked></td></tr>

	

    <tr>
  	<td width='40%'>&nbsp;</td>
  	<td width='60%' colspan='2'></td>
	
  </tr>

  </table>
</div>
<input type="hidden" name="function" id="function" value="insert">
<input type="hidden" name="function_name" id="function_name" value="insert">

</form>
<%
}catch(Exception e) { 
	//out.println(e);
	e.printStackTrace();
}finally{
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
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

