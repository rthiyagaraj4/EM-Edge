<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>    
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
    <script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language="Javascript" src="../../eCP/js/GCPGeneratePlanMenu.js"></script>
    <!-- <script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
    <script>
        var chkBothCriteria = false ;
        var fromCalledPage = false ;
    </script>
</head>
<body > 

<form name="CriteriaForm" id="CriteriaForm"  >
<table align="right"  border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr width="100">
        <td>&nbsp;&nbsp;</td>
        <td colspan=2  class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
        <input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick="storeVal(this)"><fmt:message key="Common.description.label" bundle="${common_labels}"/>
        <input type="radio" name="search_by" id="search_by" class="label" value="C" onclick="storeVal(this)"><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
        <select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;</td>
        <td class="label" colspan=2  ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>
        <input type="text" onBlur="makeValidString(this);"  name="search_text" id="search_text" value="" width="30%" align="left" size="40" maxlength="70" >
        </td>
        <td align="right"><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="valtext(search_text); this.disabled=true;" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetForm(this.form)" class="button" >
        </td>
    </tr>
</table>
<BR>
<BR>
</form>
</body>
<script>
    initializeText();
</script>
</html>

