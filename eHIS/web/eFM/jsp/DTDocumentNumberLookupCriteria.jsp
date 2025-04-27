<!DOCTYPE html>
<%@ page session="true" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
   <!--  <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
   <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

    <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
    <script src="../../eCommon/js/common.js" language="javascript"></script>
    <script src="../../eFM/js/DTDocumentNumberLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        var chkBothCriteria = false ;
        var fromCalledPage = false ;
    </script>
</head>
<body onKeyDown = 'lockKey();'>

<form name="CriteriaForm" id="CriteriaForm" method="POST" >
<table align="right"  border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr>
        <td class="label" ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
		<td class='fields'>
        <input type="text" onBlur="makeValidString(this);"  name="search_text" id="search_text" value="" width="30%" align="left" size="40" maxlength="70" >
        </td>
		<td class="LABEL" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
		<td class='fields'>
        <select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>
        <td class='button'><input type="button" align="left" name="Search" id="Search" value="Search" onClick="getValidRecords(search_text); this.disabled=true;" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value="Reset" onClick="resetForm(this.form)" class="button" >
        </td>
    </tr>
</table>
<BR>
<BR>
<input type="Hidden" name="sql" id="sql" value="">
<input type="Hidden" name="selectArray" id="selectArray" value="">
<input type="Hidden" name="headArray" id="headArray" value="">
<input type="Hidden" name="link_field" id="link_field" value="">
</form>
</body>
<script>
    initializeText();
</script>
</html>

