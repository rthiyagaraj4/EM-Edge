<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String queryString=request.getQueryString();
	String searchTxt=(request.getParameter("consent_desc")==null)?"":request.getParameter("consent_desc");

%>
<head>
	
	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String imgUrl = "";
		if(sStyle.equals("IeStyle.css"))
		{
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		}
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eOR/js/ConsentOrder.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>

	function CheckForSpecCharsNoCaps(event)
	{
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*. ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
			return (event.keyCode);
		return true ;
	}
	</script> 
</head>
<body >
<script>

	var radioval="D";
	var consentradioval="L";
	function CallDescFrame()
	{
		var listval=document.forms[0].Search_criteria.options.value;
		var textbox=document.forms[0].Search_text.value;
		parent.frames[1].location.href='ExistingOrderMultipleConsentResult.jsp?<%=queryString%>&search_by='+radioval+'&Search_Criteria='+listval+'&Search_Text='+textbox+'&consent_by='+consentradioval;		
	}

	function storeVal(currad){
		radioval = currad.value
	}

	function consentStoreVal(currad){
		consentradioval = currad.value
	}
	 
	function Change(obj){
		if(obj.checked)	   obj.value = 'Y';
		else	   obj.value = 'N';
	}

</script>

<form name="radio" id="radio">
<table align=cneter border="0" width=100% cellspacing='0' cellpadding='3'>
<tr width='100'>
<td colspan='4' class="label"><fmt:message key="eOR.ConsentList.label" bundle="${or_labels}"/>
	<input type="radio" name="consent_by" id="consent_by" class="label" value="L"  checked  onclick='consentStoreVal(this)'><fmt:message key="eOR.SpecifictoCatalog.label" bundle="${or_labels}"/>
		<input type="radio" name="consent_by" id="consent_by" class="label" value="N" onclick='consentStoreVal(this)'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
</td>
</tr>
<tr width='100'>
	<td colspan='2' class="label">
		<fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick='storeVal(this)'><fmt:message key="Common.description.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="C" onclick='storeVal(this)'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
	</td>
	<td class="label" colspan="1" width = '25%'>
		<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>	
	</td>
	<td class ='fields' >
		<select name="Search_criteria" id="Search_criteria">
			<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
			<option value="S" selected><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
		</select>
	</td>
</tr>
<tr>
	<td class='label' colspan=1  width = '25%'><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
	<td class = fields width = '25%' nowrap>
		<input class = fields' type="text"  name="Search_text" id="Search_text" value='<%=searchTxt%>' width=30% align="left" size='20' maxlength='20' onkeypress="return CheckForSpecCharsNoCaps(event);">
	</td>
	<td colspan = 2 width = '50%' align = 'right'>
		<input type="button" width='6%' align="left" name="Search" id="Search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="CallDescFrame(this)" class='button' >
	</td>
</tr>
</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
</form>
</body>
</html>

