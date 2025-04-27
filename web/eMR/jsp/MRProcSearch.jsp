<!DOCTYPE html>
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<% 	request.setCharacterEncoding("UTF-8");	%>
 <%
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="javascript" src='../../eMR/js/MRProcedureList.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String queryString=request.getQueryString();
	String search_text="";
%>
</head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<form name="proc" id="proc">
<table align='center'  border="0" width='100%' cellspacing='0' cellpadding='3'>
<tr width='100'>
	<td colspan='2' class="label">
		<fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick='storeVal(this)'><fmt:message key="Common.description.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="C" onclick='storeVal(this)'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
	</td>
	<td class="label"  width = '25%'>
		<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>	
	</td>
	<td class ='fields' width='25%'>
		<select name="search_criteria" id="search_criteria">
			<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
			<option value="S" selected><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
		</select>
	</td>
</tr>
<tr>
	<td class='label'  width = '25%'><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
	<td class = 'fields' width='25%' >
		<input class = 'fields' type="text"  name="search_text" id="search_text" value='<%=search_text%>' width=30% align="left" size='20' maxlength='20' onkeypress="return CheckForSpecChars(event);"><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
	<td width = '25%' class='label' ></td>
	<td width = '25%' align = 'right' >
		<input type="button" width='6%' align="left" name="Search" id="Search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="valtext(search_text);" class='button' >
	</td>
</tr>
</table>
<BR>
<BR>
<input type='hidden' name='qry_string' id='qry_string' value='<%=queryString%>'></input>
</form>
</body>
</html>

