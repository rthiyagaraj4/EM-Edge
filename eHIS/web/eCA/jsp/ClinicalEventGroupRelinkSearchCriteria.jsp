<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
			request.setCharacterEncoding("UTF-8");	
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCA/js/ClinicalEventGroup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown="lockKey()">
<form name="SearchCriteriaForm" id="SearchCriteriaForm"  >
<table align="right"  border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr width="100">
	       <td>&nbsp;&nbsp;</td>
        <td colspan=2  class="label">Search By
        <input type="radio" name="search_by" id="search_by" class="label" value="C"    onclick="">&nbsp;Code
        <input type="radio" name="search_by" id="search_by" class="label" value="D" onclick="" checked>&nbsp;&nbsp;Description&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Search Criteria
        <select name="search_criteria" id="search_criteria">
        <option value="S">Starts With
        <option value="E">Ends With
        <option value="C">Contains
        </select>
        </td>
        <td>&nbsp;</td>
    </tr> 
    <tr>
        <td>&nbsp;&nbsp;</td>
        <td class="label" colspan=2  >Search Text
        <input type="text" onBlur="makeValidString(this);"  name="search_text" id="search_text" value="" width="30%" align="left" size="40" maxlength="70" >
        </td>
        <td align="right"><input type="button" align="left" name="Search" id="Search" value="Search" onClick="searchGroup()" class="button" >
        </td>
    </tr>
</table>
</form>
</body>
</html>

