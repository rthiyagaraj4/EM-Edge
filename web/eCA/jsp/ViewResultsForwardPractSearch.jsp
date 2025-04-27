<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
 	<script language="JavaScript" src="../js/ViewResult.js"></script>
 	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	String qry_string = request.getQueryString();
	if (qry_string == null) qry_string = "";
	//out.println("<script>alert('in ReviewResultsForwardPractSearch.jsp,qry_string="+qry_string+"');</script>");
%>
<body onload='FocusFirstElement();'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='review_result_forward_pract_search' id='review_result_forward_pract_search' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr width="100">
        <td class="label" ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
        <td  class="fields">
		<input type="radio" name="search_by" id="search_by" class="label" value="D" checked onclick="document.review_result_forward_pract_search.searchBy.value = this.value"><fmt:message key="Common.description.label" bundle="${common_labels}"/>
        <input type="radio" name="search_by" id="search_by" class="label" value="C" onclick="document.review_result_forward_pract_search.searchBy.value = this.value"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class="label" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
        <td class='fields'><select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>
       </tr>
    <tr>
        <td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
        <td class="fields" ><input type="text" onBlur="makeValidString(this);"  name="practitioner_name" id="practitioner_name" value="" width="30%" align="left" size="40" maxlength="70" >
        </td><td>&nbsp;</td>
        <td align="right"><input type="button" align="left" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchPractitioner(); this.disabled=true;" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetForwardPage()" class="button" >
        </td>
    </tr>
<Input name='qry_string' id='qry_string' type='hidden' value='<%=qry_string%>'>
<input type='hidden' name='searchBy' id='searchBy' value="D"/>
</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
</form>
</body>
</html>

