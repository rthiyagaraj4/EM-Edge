<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*"  contentType="text/html;charset=UTF-8"%>
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
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

    <script src="../js/ValidateControl.js" language="javascript"></script>
    <script src="../js/common.js" language="javascript"></script>
    <script src="../js/CommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        var chkBothCriteria = false ;
        var fromCalledPage = false ;

		var fieldLegend     = window.dialogArguments[8] ;
		if(fieldLegend == null) {
		fieldLegend = new Array() ;
		fieldLegend["CODE_LEGEND"] = getLabel("Common.code.label","common")
		fieldLegend["DESC_LEGEND"] = getLabel("Common.description.label","common")
		}
		
    </script>
</head>
<body onload='chk_spl_char()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<form name="CriteriaForm" id="CriteriaForm"  >
<table align="right"  border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr width="100">
        <td>&nbsp;&nbsp;</td> 
		<td   class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>

        <td  class="fields"><input type="radio" name="search_by" id="search_by" class="label" value="C"    onclick="storeVal(this)"><script>document.write(fieldLegend["CODE_LEGEND"])</script>
        <input type="radio" name="search_by" id="search_by" class="label" value="D" onclick="storeVal(this)" checked><script>document.write(fieldLegend["DESC_LEGEND"])</script></td>

		<td class="label" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
        <td class='fields'><select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>
       
    </tr> 
    <tr>
        <td>&nbsp;&nbsp;</td>
        <td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
        <td class="fields"><input type="text" onBlur="makeValidString(this);allow_nochars(this);"  name="search_text" id="search_text" value="" width="30%" align="left" size="40" maxlength="70" >
        </td>
		<td class="label">&nbsp;</td>

        <td align="left" nowrap><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="valtext(search_text); this.disabled=true;" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetForm(this.form)" class="button" >
        </td>
    </tr>
<tr>
	<td colspan='4'>
	<img src='<%=imgUrl%>' width='100%' height='15'/> 
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

