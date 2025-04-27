<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>  
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script src="../js/CriteriaForAssessmentCategory.js" language="javascript"></script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
 
		<form name="form_add_mod" id="form_add_mod">
			<table border='0' cellpadding='7' cellspacing='0' align='center' width="90%">
			 <tr><td colspan="4">&nbsp</td></tr>
			 <tr>
				<td width="20%"  align="center" class="label"><fmt:message key="eCP.AssessmentNote.label" bundle="${cp_labels}"/></td>
					<td><input width="30%" type=text name="assess_note_desc" id="assess_note_desc" ><input class='button' type=button name="assess_note_button" id="assess_note_button" value="?"  onClick='viewAssessNote(assess_note_desc);clearDetail()'>
				    <img src='../../eCommon/images/mandatory.gif'align='center'></img>
					<input type="hidden" name="assess_note_id" id="assess_note_id" value="" >			
				</td>
			</tr>
            <tr>
				<td align="center" class="label" width="20%"><fmt:message key="eCP.AssessmentCategory.label" bundle="${cp_labels}"/></td>
				<td  class="label" width="30%">
				<select name="assess_catg_code" id="assess_catg_code" onChange="clearDetail()">
				<option value="" selected> &nbsp&nbsp------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------- </option>
				</select>
			    <img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchDetails()'>&nbsp;&nbsp;&nbsp;</td>
		    </tr>

			<tr><td colspan="4">&nbsp</td></tr>
		  </table>	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	  </form>
 
</body>
</html>



