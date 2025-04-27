<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<%
	String queryString=request.getQueryString();
	String searchTxt="";
%>
<head>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	
	<script src="../../eMR/js/TermcodeSearchProblem.js.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onKeyDown='lockKey()'>
<script>

	var radioval="D";
	function CallDescFrame(){
		var listval=document.forms[0].Search_criteria.options.value;
		var textbox=document.forms[0].Search_text.value;
		var sensitive_yn=document.forms[0].sensitive_yn.value;
		var notifiable=document.forms[0].opt_notifiable.value;
		if(textbox != ""){
				parent.frames[1].location.href='TermCodeSearchQueryResult.jsp?<%=queryString%>&Search_By='+radioval+'&Search_Criteria='+listval+'&sensitive_yn='+sensitive_yn+'&Search_Text='+textbox+'&notifiable_yn='+notifiable;
				document.radio.Search.disabled=true;
		}else{
			var msg = getMessage('SEARCH_TEXT_BLANK','Common');
			alert (msg);
		}
	}

	function storeVal(currad){
		radioval = currad.value
	}
	 
	function Change(obj){
		if(obj.checked)	   obj.value = 'Y';
		else	   obj.value = 'N';
	}

</script>

<form name="radio" id="radio">
<table align=right border="0" width=100% cellspacing='0' cellpadding='0'>
<tr width='100'>
	<td colspan=1  class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick='storeVal(this)'>Description
		<input type="radio" name="search_by" id="search_by" class="label" value="C" onclick='storeVal(this)'>Code
	</td>
	<td class="label" colspan="1"><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>	
		<select name="Search_criteria" id="Search_criteria">
			<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
			<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
		</select>
	</td>
</tr>
<tr>
	<td align="left" colspan="1" class="label">
		<B><fmt:message key="Common.RestrictTo.label" bundle="${common_labels}"/></B>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Notifiable
		<select name="opt_notifiable" id="opt_notifiable">
			<option value="" selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<option value="Y"><fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/></option>
			<option value="N" ><fmt:message key="eMR.NonNotifiable.label" bundle="${mr_labels}"/></option>
		</select>
	</td>
	<td class="label" colspan="1" align="left">
		<fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<select name="sensitive_yn" id="sensitive_yn">
			<option value="" selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<option value="Y"><fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/></option>
			<option value="N"><fmt:message key="eMR.NonSensitive.label" bundle="${mr_labels}"/></option>
		</select>
	</td>
</tr>
<tr>
	<td class='label' colspan=1  ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>
	&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"  name="Search_text" id="Search_text" value='<%=searchTxt%>' width=30% align="left" size='20' maxlength='20' onkeypress="return CheckForSpecCharsNoCaps(event);">
		<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
	<td class='button'>
		<input type="button" width='6%' align="left" name="Search" id="Search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="CallDescFrame(this)" class='button' >
	</td>
</tr>
</table>
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

