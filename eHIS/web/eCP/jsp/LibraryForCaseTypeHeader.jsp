<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=	UTF-8"%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script src="../js/LibraryForCaseType.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" > <%
 try
   {
	 %>
		<form name="form_add_mod" id="form_add_mod">
			<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">
			  <tr><td colspan="5">&nbsp</td></tr>
			    <tr>
					<td width="11%"  align=right class="label"><fmt:message key="eCP.CaseType.label" bundle="${cp_labels}"/></td>
					<td>&nbsp;<input type=text size = '60' maxlength = '60'  name="case_type_desc" id="case_type_desc" value=""  readonly onChange='clearDetail()'><input class='button' type=button name="case_type_button" id="case_type_button" value="?"  onClick='viewAgeGroup(case_type_desc);clearDetail()'>
				    <img src='../../eCommon/images/mandatory.gif'align='center'></img>
					<input type="hidden" name="case_type_code" id="case_type_code" value="" >				
				<td colspan="2" align="right"><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchDetails()'>&nbsp;&nbsp;&nbsp;</td>
			  </tr>
			 <tr><td colspan="5">&nbsp</td></tr>
		  </table>	
		<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	  </form>
 <%}catch(Exception e)
	{
		//out.println("Error is ---"+e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
finally
  {
			
  }
%>
</body>
</html>

