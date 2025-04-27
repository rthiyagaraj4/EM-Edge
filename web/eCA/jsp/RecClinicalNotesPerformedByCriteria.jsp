<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String std_comp_id = request.getParameter( "std_comp_id" );
	String search_val		=	(request.getParameter("search_val")==null)		? ""	:	request.getParameter("search_val");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

    <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
    <script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   </head>
<script>

function valtext(code)
{
	var search_text = document.RecClinicalNotesPerformedByCriteriaForm.search_text.value;
	var search_criteria = document.RecClinicalNotesPerformedByCriteriaForm.search_criteria.value;
	var radBtnVal = document.RecClinicalNotesPerformedByCriteriaForm.radBtnVal.value;
	var queryStr = document.RecClinicalNotesPerformedByCriteriaForm.queryStr.value;

	parent.RecClinicalNotesPerformedByResultFrame.document.location.href = "../../eCA/jsp/RecClinicalNotesPerformedByResult.jsp?std_comp_id="+code+"&search_text="+search_text+"&search_criteria="+search_criteria+"&radBtnVal="+radBtnVal+"&queryString="+queryStr;
}

</script>

<body onKeyDown="lockKey()">
<form name="RecClinicalNotesPerformedByCriteriaForm" id="RecClinicalNotesPerformedByCriteriaForm"  >
<table align="center"  border="0" width="100%" cellspacing="0" cellpadding="3">
    <tr >
       <td colspan=2  class="label" width='25%'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/> </td>
       <td colspan=3 class='fields' width='25%' align="center"><input type="radio" name="search_by" id="search_by" value="D"  checked  onclick="	document.RecClinicalNotesPerformedByCriteriaForm.radBtnVal.value = this.value;"><fmt:message key="Common.description.label" bundle="${common_labels}"/>
        <input type="radio" name="search_by" id="search_by" class="label" value="C" onclick="	document.RecClinicalNotesPerformedByCriteriaForm.radBtnVal.value = this.value;"><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
        <select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>
        
    </tr>
    <tr>
        <td class="label"  width='25%' colspan=2  ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/> </td>
        <td class="fields"  width='25%'> <input type="text" onBlur="makeValidString(this);"  name="search_text" id="search_text" value="<%=search_val%>" width="30%" align="left" size="40" maxlength="70" >
        </td> <td width='25%'>&nbsp;</td>
        <td width='25%' ><input type="button" align="left" name="Search" id="Search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="valtext('<%=std_comp_id%>'); this.disabled=true;" class="button" >
         </td>
    </tr>
</table>
<BR>
<BR>
<input type='hidden' name='radBtnVal' id='radBtnVal' value='D'>
<input type='hidden' name='queryStr' id='queryStr' value='<%=request.getQueryString()%>'>
</form>
</body>
<script>
    //initializeText();
</script>
</html>

