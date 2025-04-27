<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	// added by Archana @08-12-08 
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
    //end
	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCA/js/ClinicalRepMast.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()'>
<form name="SearchCriteriaForm" id="SearchCriteriaForm" >
<table align="center"  border="0" width="100%" cellspacing="0" cellpadding="3">
<tr><td class='COLUMNHEADER'  colspan=4><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/> </td></tr>	
    <tr width="100">
        <td class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
        <input type="radio" name="search_by" id="search_by" class="label" value="C" onclick=""><fmt:message key="Common.code.label" bundle="${common_labels}"/>
        <input type="radio" name="search_by" id="search_by" class="label" value="D" onclick="" checked><fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
        <select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/> 
        </select>
		<td></td>
        </td>
    </tr> 
    <tr>
        <td class="label" ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>
        <input type="text" onBlur="makeValidString(this);"  name="search_text" id="search_text" value="" width='30%' size="40" maxlength="70" >
        </td>
        <td ><input type="button" name="Search" id="Search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="searchBatchEventGroup()" class="button" >
        </td>
    </tr>
</table>
<!-- added by Archana @08-12-08 -->

			<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>

				<!-- end -->
</form>
</body>
</html>

