<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String locale= (String)session.getAttribute("LOCALE");
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>  
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
    <script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<script src="../../eCP/js/SpecialtyForAssessmentNote.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form name="form_add_mod" id="form_add_mod">
			<table border='0' cellpadding='0' cellspacing='0' align='center' width="90%">
			  <tr><td colspan="5">&nbsp</td></tr>
			    <tr>
					<td width="25%"  align=right class="label"><fmt:message key="eCP.AssessmentNote.label" bundle="${cp_labels}"/></td>
					<td>&nbsp;<input type=text name="assess_note_desc" id="assess_note_desc" value=""  readonly onBlur=''><input class='button' type=button name="assess_note_button" id="assess_note_button" value="?"  onClick='viewAgeGroup(assess_note_desc)'>
					<input type="hidden" name="assess_note_id" id="assess_note_id" value="" >				
				    <img src='../../eCommon/images/mandatory.gif'align='center'></img>
				<td colspan="2" align="right"><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchDetails()'>&nbsp;&nbsp;&nbsp;</td>
			  </tr>
			 <tr><td colspan="5">&nbsp</td></tr>
		  </table>	
		  <input type="hidden" name="locale" id="locale" value="<%=locale%>">
	  </form>

</body>
</html>

