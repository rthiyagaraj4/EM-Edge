<!DOCTYPE html>
<%@ page import="java.sql.*,java.io.*,java.net.*,webbeans.eCommon.*,java.util.*, java.text.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");

	String imgUrl=""; 
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

	 String searchtxtval = request.getParameter("searchtxtval");
	 if(searchtxtval == null) searchtxtval = "";

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src='../../eXH/js/ExternalApplication.js' language="javascript"></script>
	<script src="../../eSM/js/ActiveDirectoryLoookup.js" language="javascript"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%if(searchtxtval.equals("")){%>
	<body onKeyDown = 'lockKey()'>
<%}else{%>
	<body onKeyDown = 'lockKey()' onload = "CallDescFrame()">
<%}%>

<form name="CriteriaForm" id="CriteriaForm">
<table  border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr>
		<td class="label">&nbsp;</td>
        <td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
        <td class="fields"><input type="text" onBlur="makeValidString(this);"  name="search_text" id="search_text" value="<%=searchtxtval%>" width="30%" align="left" size="40" maxlength="80" >
        </td>

		<td class="label">&nbsp;</td>
		<td class="label" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
        <td class='fields'><select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>

		<td class="label">&nbsp;</td>
    </tr>

	<tr></tr>

    <tr>
		<td class="label" colspan = 5>&nbsp;</td>
        <td align="left" nowrap><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="CallDescFrame();" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetForm(this.form)" class="button" >
        </td>
    </tr>

</table>
<br>
<%if(!imgUrl.equals("")){ %>
	 <img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
</form>
</body>

</html>

